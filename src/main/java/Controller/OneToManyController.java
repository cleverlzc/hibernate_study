package Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

import entity.onetomany.Address2;
import entity.onetomany.Person2;

/**
 * Created by root on 17-3-2.
 */
public class OneToManyController {
    public static void main(String[] args) {
        Person2 p = new Person2();
        p.setName("one to many");
        p.setAge(3);
        p.getAddress2s().add(new Address2("one to many address1"));
        p.getAddress2s().add(new Address2("one to many address2"));
        p.getAddress2s().add(new Address2("one to many address3"));

        Configuration cf = new Configuration().configure();
        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();
        try {
            //session.save(p);
            Person2 person2 = (Person2) session.get(Person2.class, 2l);
            Set<Address2> address2s = person2.getAddress2s();
            for (Address2 address2 : address2s)
                System.out.println("person : " + person2.getName() + " | " + address2.getAddress());
            /*Set<Address2> set = new HashSet<Address2>();
            set.add(new Address2("address change"));
            person2.setAddress2s(set);*/
            /*person2.setName("name change");
            session.update(person2);*/
            ts.commit();
        } finally {
            session.close();
            sf.close();
        }
    }
}
