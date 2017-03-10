package Controller.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import entity.hql.GroupTest;
import entity.hql.HQLStudent;
import entity.hql.HQLTeacher;

/**
 * Created by root on 17-3-4.
 */
public class HQLController {
    public static void main(String[] args) {
        Configuration cf = new Configuration().configure();
        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();
        try {

            //from
            String hql = "from HQLTeacher";

            hql = "from HQLStudent s where s.hqlTeacher.id = :id";

            //select
            hql = "select new list(s.name, s.hqlTeacher) from HQLStudent s";

            //count
            hql = "select count(*) from HQLStudent";

            hql = "select min(s.name) from HQLStudent s";

            //1
            hql = "select s.name, count(*) as count from  HQLStudent s group by s.name";

            //2 注意此处GroupTest名
            //hql = "select new entity.hql.GroupTest(s.name, count(*)) from  HQLStudent s group by s.name";

            Query query = session.createQuery(hql);
            //query.setParameter("id", 1l);

            //1
            List list = query.list();
            for(Object object : list) {
                Object[] obj = (Object[]) object;
                System.out.println(obj[0] + " | " + obj[1]);
            }

            //2
            /*List<GroupTest> list = query.list();
            for(GroupTest g : list) System.out.println(g.getName() + " | " + g.getCount());*/


            //System.out.println(query.uniqueResult());

            /*List students = query.list();
            for (int i = 0; i < students.size(); i ++) {
                System.out.println(students.get(0));
            }*/

            /*List<HQLStudent> students = query.list();
            for (HQLStudent s : students) System.out.println(s.getName() + " | " + s.getHqlTeacher().getId());*/


            /*List<HQLTeacher> list = query.list();
            for(HQLTeacher t : list) System.out.println(t.getName() + " | " + t.getHqlStudents().size());*/

            /*HQLTeacher t = new HQLTeacher();
            t.setName("teacher 3");
            Serializable id = session.save(t);
            t = (HQLTeacher) session.get(HQLTeacher.class, id);

            HQLStudent s1 = new HQLStudent();
            s1.setName("student 1");
            s1.setHqlTeacher(t);

            HQLStudent s2 = new HQLStudent();
            s2.setName("student 2");
            s2.setHqlTeacher(t);

            HQLStudent s3 = new HQLStudent();
            s3.setName("student 3");
            s3.setHqlTeacher(t);
            session.save(s1);
            session.save(s2);
            session.save(s3);*/

            ts.commit();
        }finally {
            session.close();
            sf.close();
        }
    }
}
