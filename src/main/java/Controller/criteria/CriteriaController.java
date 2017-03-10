package Controller.criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.List;

import entity.criteria.CriteriaStudent;
import entity.criteria.CriteriaTeacher;

/**
 * Created by root on 17-3-8.
 */
public class CriteriaController {
    public static void main(String[] args) {
        Configuration cf = new Configuration().configure();
        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();
        try {

            //Criteria,Restrictions
            /*Criteria criteria = session.createCriteria(CriteriaTeacher.class)
                    .createCriteria("criteriaStudents")
                    .add(Restrictions.ne("name", "student 1"))
                    .add(Restrictions.ne("name", "student 2"))
                    .add(Restrictions.ne("name", "student 3"));
            List<CriteriaTeacher> criteriaTeacherList = criteria.list();
            for(CriteriaTeacher c : criteriaTeacherList) System.out.println(c.getName() + " | " + c.getCriteriaStudents().size());*/

            //Criteria,Projection,Projections,Property
            Criteria criteria = session.createCriteria(CriteriaStudent.class)
                    .setProjection(Projections.projectionList()
                            .add(Property.forName("id"))
                            .add(Property.forName("name"))
                            .add(Projections.groupProperty("name"))
                            .add(Projections.rowCount())
                    )
                    .setFirstResult(0)
                    .setMaxResults(5);
            List list = criteria.list();
            for(Object obj : list) {
                Object[] objects = (Object[]) obj;
                for(int i = 0; i < objects.length; i++) {
                    System.out.print(objects[i] + " | ");
                }
                System.out.println();
            }

            /*CriteriaTeacher t = new CriteriaTeacher();
            t.setName("teacher 6");
            Serializable id = session.save(t);
            t = (CriteriaTeacher) session.get(CriteriaTeacher.class, id);

            CriteriaStudent s1 = new CriteriaStudent();
            s1.setName("student 1");
            s1.setCriteriaTeacher(t);

            CriteriaStudent s2 = new CriteriaStudent();
            s2.setName("student 1");
            s2.setCriteriaTeacher(t);

            CriteriaStudent s3 = new CriteriaStudent();
            s3.setName("student 1");
            s3.setCriteriaTeacher(t);

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
