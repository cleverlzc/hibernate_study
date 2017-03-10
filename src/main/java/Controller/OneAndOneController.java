package Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.oneandone.Address6;
import entity.oneandone.Person6;

/**
 * Created by root on 17-3-3.
 */
public class OneAndOneController {
    public static void main(String[] args) {
        Person6 p = new Person6();
        p.setName("one and one");
        p.setAge(6);
        Address6 a = new Address6();
        a.setAddress("one and one address");

        a.setPerson6(p);

        Configuration cf = new Configuration().configure();
        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();
        try {
           /* session.save(p);
            session.save(a);*/
            Person6 person6 = (Person6) session.get(Person6.class, 2l);
            System.out.println(person6.getName() + " | " + person6.getAddress6().getAddress());
            Address6 address6 = (Address6) session.get(Address6.class, 1l);
            System.out.println(address6.getAddress() + " | " + address6.getPerson6().getName());
            ts.commit();
        } finally {
            session.close();
            sf.close();
        }
    }
}
