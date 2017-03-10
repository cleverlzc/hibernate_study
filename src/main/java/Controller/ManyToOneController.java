package Controller;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.manytoone.Address;
import entity.manytoone.Person;

/**
 * Created by root on 17-2-27.
 */
public class ManyToOneController {

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("many to one");
        p.setAge(1);
        p.setAddress(new Address("many to one address"));

        Configuration cf = new Configuration().configure();
        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        try {
            //session.save(p);
            Person person = (Person) session.get(Person.class, 3l);
            System.out.println(person.getName() + " | " + person.getAddress().getAddress());
            //person.setAddress(new Address("address change"));
            //session.update(person);
            //session.delete(person);
            t.commit();
        }finally {
            session.close();
            sf.close();
        }

    }

}
