package Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.onetoone.Address1;
import entity.onetoone.Person1;

/**
 * Created by root on 17-3-2.
 */
public class OneToOneController {

    public static void main(String[] args) {
        Person1 p = new Person1();
        p.setName("one to one");
        p.setAge(2);
        p.setAddress1(new Address1("one to one address"));

        Configuration cf = new Configuration().configure();
        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();
        try {
            //session.save(p);
            Person1 person1 = (Person1) session.get(Person1.class, 2l);
            System.out.println(person1.getName() + " | " + person1.getAddress1().getAddress());
            person1.setAddress1(new Address1("address change"));
            session.update(person1);
            ts.commit();
        } finally {
            session.close();
            sf.close();
        }
    }

}
