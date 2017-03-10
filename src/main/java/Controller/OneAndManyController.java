package Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Set;

import entity.oneandmany.Address4;
import entity.oneandmany.Person4;

/**
 * Created by root on 17-3-3.
 */
public class OneAndManyController {
    public static void main(String[] args) {
        Person4 p = new Person4();
        p.setName("one and many");
        p.setAge(4);

        Configuration cf = new Configuration().configure();
        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();
        try {
            /*session.save(p);
            Address4 a = new Address4("one and many address");
            a.setPerson4(p);
            session.persist(a);
            Address4 a1 = new Address4("one and many address1");
            a1.setPerson4(p);
            session.persist(a1);*/
            Person4 person4 = (Person4) session.get(Person4.class, 7l);
            Set<Address4> address4s = person4.getAddress4s();
            for(Address4 address4 : address4s)
                System.out.println("person : " + person4.getName() + " | " + address4.getAddress());
            Address4 address4 = (Address4) session.get(Address4.class, 3l);
            System.out.println("address : " + address4.getAddress() + " | " + address4.getPerson4().getName());
            ts.commit();
        }finally {
            session.close();
            sf.close();
        }

    }
}
