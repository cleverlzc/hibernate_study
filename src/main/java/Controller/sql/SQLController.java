package Controller.sql;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;

import entity.sql.SQLStudent;
import entity.sql.SQLTeacher;

/**
 * Created by root on 17-3-8.
 */
public class SQLController {
    public static void main(String[] args) {
        Configuration cf = new Configuration().configure();
        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();

        //返回结果映射到多张表,多张表有重复字段会出现混淆,（解决方案改为不同名）;一对多时，多的一方取到的总是第一条（解决方案用多的一方关联1的一方）
        try {
            String sql = "SELECT t.*,s.* FROM sql_teacher t LEFT JOIN sql_student s ON t.tid = s.teacher_id";
            SQLQuery sqlQuery = session.createSQLQuery(sql)
                    .addEntity("t", SQLTeacher.class)
                    .addEntity("s", SQLStudent.class);
            List list = sqlQuery.list();
            for (Object obj : list) {
                Object[] objects = (Object[]) obj;
                SQLTeacher sqlTeacher = (SQLTeacher) objects[0];
                SQLStudent sqlStudent = (SQLStudent) objects[1];
                System.out.println(sqlStudent.getSname() + " | " + sqlTeacher.getTname());
            }

            /*String sql = "SELECT s.*,t.*  FROM sql_student s LEFT JOIN sql_teacher t ON s.teacher_id = t.tid ";
            SQLQuery sqlQuery = session.createSQLQuery(sql)
                    .addEntity("s", SQLStudent.class)
                    .addEntity("t", SQLTeacher.class);
            List list = sqlQuery.list();
            for(Object obj : list) {
                Object[] objects = (Object[]) obj;
                SQLStudent sqlStudent = (SQLStudent) objects[0];
                SQLTeacher sqlTeacher = (SQLTeacher) objects[1];
                System.out.println(sqlStudent.getSname() + " | " + sqlTeacher.getTname());
            }*/

            /*String sql = "SELECT * FROM sql_teacher WHERE id = :id";
            SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(SQLTeacher.class);
            List<SQLTeacher> sqlTeacherList = sqlQuery.setLong("id", 1l).list();
            for (SQLTeacher t : sqlTeacherList) System.out.println(t.getName());*/


            /*SQLTeacher t = new SQLTeacher();
            t.setTname("teacher 3");
            Serializable id = session.save(t);
            t = (SQLTeacher) session.get(SQLTeacher.class, id);

            SQLStudent s1 = new SQLStudent();
            s1.setSname("student 1");
            s1.setSqlTeacher(t);

            SQLStudent s2 = new SQLStudent();
            s2.setSname("student 2");
            s2.setSqlTeacher(t);

            SQLStudent s3 = new SQLStudent();
            s3.setSname("student 3");
            s3.setSqlTeacher(t);

            session.save(s1);
            session.save(s2);
            session.save(s3);*/
            ts.commit();
        } finally {
            session.close();
            sf.close();
        }
    }
}
