package Controller.sql;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.StandardBasicTypes;

import java.util.List;

import entity.sql.SQLStudent;
import entity.sql.SQLTeacher;

/**
 * Created by root on 17-3-8.
 */
public class SQLTestController {
    public static void main(String[] args) {
        Configuration cf = new Configuration().configure();
        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();

        try {
            //1、标量查询

            //标量查询会获得数据表列对应的Object数组组成的List，hibernate会默认通过ResultSetMetadata来判定所返回数据列的实际顺序和类型，
            //但这样的默认处理会降低程序性能，因此在代码书写时建议明确返回值类型
            /*String sql = "select * from sql_student";
            SQLQuery q = session.createSQLQuery(sql)
                    .addScalar("id", StandardBasicTypes.LONG)//明确返回值类型，属性名称必须和表中列名相同
                    .addScalar("sname", StandardBasicTypes.STRING)
                    .addScalar("teacher_id", StandardBasicTypes.LONG);
            List list = q.list();
            for (Object ob : list) {
                Object[] ob1 = (Object[]) ob;
                System.out.println(ob1[0] + " | " + ob1[1] + " | " + ob1[2]);
            }*/

            //多表查询
            /*String sql = "select t.tid, t.tname,s.sid,s.sname from sql_teacher t, sql_student s WHERE t.tid = s.teacher_id";
            SQLQuery q = session.createSQLQuery(sql)
                    .addScalar("t.tid", StandardBasicTypes.LONG)//明确返回值类型，属性名称必须和表中列名相同
                    .addScalar("t.tname", StandardBasicTypes.STRING)
                    .addScalar("s.sid", StandardBasicTypes.LONG)
                    .addScalar("s.sname", StandardBasicTypes.STRING);
            List list = q.list();
            for (Object ob : list) {
                Object[] ob1 = (Object[]) ob;
                System.out.println(ob1[0] + " " + ob1[1] + " | " + ob1[2] + " " + ob1[3]);
            }*/

            //2、实体查询

            //如果查询返回了某个数据表的全部数据列，且该数据表有对应的持久化类映射，就可用实体查询将查询结果转换成实体
            /*String sql = "select * from sql_student";
            SQLQuery q = session.createSQLQuery(sql)
                    .addEntity(SQLStudent.class);//程序必须选出所有数据列才可被转换成持久化实体
            List<SQLStudent> list = q.list();
            for (SQLStudent s : list) {
                System.out.println(s.getId() + " | " + s.getSname() + " | " + s.getSqlTeacher().getName());
            }*/

            //多表查询(使用这种查询，如果两张表中有相同字段，则得到这两字段值均为顺序在前的字段的值，解决办法是将表中名称相同字段名称做区别)
            /*String sql = "SELECT s.*,t.*  FROM sql_teacher t,sql_student s WHERE s.teacher_id = t.tid";
            SQLQuery sqlQuery = session.createSQLQuery(sql)
                    .addEntity("t", SQLTeacher.class)
                    .addEntity("s", SQLStudent.class);
            List list = sqlQuery.list();
            for (Object obj : list) {
                Object[] objects = (Object[]) obj;
                SQLTeacher sqlTeacher = (SQLTeacher) objects[0];
                SQLStudent sqlStudent = (SQLStudent) objects[1];
                System.out.println(sqlTeacher.getId() + " " + sqlTeacher.getTname() + " | " + sqlStudent.getId() + " " + sqlStudent.getSname());
            }*/

            //3、关联查询
            String sql = "SELECT t.*,s.* FROM sql_teacher t LEFT JOIN sql_student s ON t.tid = s.teacher_id";
            SQLQuery sqlQuery = session.createSQLQuery(sql)
                    .addEntity("t", SQLTeacher.class)
                    .addEntity("s", SQLStudent.class);
            List list = sqlQuery.list();
            for (Object obj : list) {
                Object[] objects = (Object[]) obj;
                SQLTeacher sqlTeacher = (SQLTeacher) objects[0];
                SQLStudent sqlStudent = (SQLStudent) objects[1];
                System.out.println(sqlTeacher.getId() + " " + sqlTeacher.getTname() + " | " + sqlStudent.getId() + " " + sqlStudent.getSname());
            }
            //注意：两个表中字段名称不能重复，否则得到结果的相同名称字段的值会出现混淆（只取顺序排在前面的字段值）

            ts.commit();
        } finally {
            session.close();
            sf.close();
        }
    }
}
