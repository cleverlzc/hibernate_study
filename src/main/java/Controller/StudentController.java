package Controller;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Parents;
import entity.Season;
import entity.Student;

/**
 * Created by root on 17-2-27.
 */
public class StudentController {

    public static void main(String[] args) {
        Student a = new Student();
        a.setAge(32);
        a.setName("hello hibernate!");

        a.setSex(Season.boy);
        a.setBoy_or_girl(Season.girl);

        Date date = new Date();
        a.setDate(date);
        a.setTime(date);
        a.setTimestamp(date);

        a.getTeachers().add("lao shi 1");
        a.getTeachers().add("lao shi 2");
        a.getTeachers().add("lao shi 3");

        a.setArrayTeacher(new String[]{"lao shi 1", "lao shi 2", "lao shi 3"});

        a.getSetTeacher().add("lao shi 1");
        a.getSetTeacher().add("lao shi 2");
        a.getSetTeacher().add("lao shi 3");

        a.getMapScores().put("shu xue", 81f);

        a.setParents(new Parents("mother", "father"));

        Configuration cfg = new Configuration().configure();
        SessionFactory cf = cfg.buildSessionFactory();
        Session session = cf.openSession();
        session.beginTransaction();
        try {
            Serializable s = session.save(a);
            //System.out.println(s.toString());
            Student student = (Student) session.get(Student.class, 35l);
            System.out.println(student.getInfo() +
                    " | teacher size : " + student.getTeachers().size() +
                    " | array teacher size : " + student.getArrayTeacher().length +
                    " | set teacher size : " + student.getSetTeacher().size());

            /*List<String> list = new ArrayList<String>();
            list.add("lao shi 4");
            list.add("lao shi 5");
            list.add("lao shi 6");
            student.setTeachers(list);
            session.update(student);*///会自动删除后再插入
            //session.delete(student);
            session.getTransaction().commit();
        } finally {
            session.close();
            cf.close();
        }
    }

}
