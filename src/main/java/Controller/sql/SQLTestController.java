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
            ts.commit();
        } finally {
            session.close();
            sf.close();
        }
    }
}
