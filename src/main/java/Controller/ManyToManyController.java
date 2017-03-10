package Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

import entity.manytomany.Address3;
import entity.manytomany.Person3;

/**
 * Created by root on 17-3-2.报错，未解决
 */

public class ManyToManyController {
    public static void main(String[] args) {
        Person3 p = new Person3();
        p.setName("many to many");
        p.setAge(3);
        Address3 a1 = new Address3("many to many address 1");
        Address3 a2 = new Address3("many to many address 2");
        Address3 a3 = new Address3("many to many address 3");

        Configuration cf = new Configuration().configure();
        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();
        try {
            Serializable s1 = session.save(a1);
            Serializable s2 = session.save(a2);
            Serializable s3 = session.save(a3);
            Address3 ad = (Address3) session.get(Address3.class, s1);
            System.out.println(s1 + " | " + ad.getAddress());
            p.getAddress3s().add((Address3) session.get(Address3.class, s1));
            p.getAddress3s().add((Address3) session.get(Address3.class, s2));
            p.getAddress3s().add((Address3) session.get(Address3.class, s3));
            session.save(p);
            ts.commit();
        } finally {
            session.close();
            sf.close();
        }
    }
}
