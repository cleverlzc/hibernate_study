package Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Set;

import entity.manyandmany.Address5;
import entity.manyandmany.Person5;

/**
 * Created by root on 17-3-3.
 */
public class ManyAndManyController {

    public static void main(String[] args) {

        Configuration cf = new Configuration().configure();
        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();
        try {
            /*Address5 address5 = (Address5) session.get(Address5.class, 7l);
            session.delete(address5);*/

            Person5 person5 = (Person5) session.get(Person5.class, 9l);
            session.delete(person5);

            /*Person5 person5 = (Person5) session.get(Person5.class, 1l);
            Set<Address5> address5s = person5.getAddress5s();
            for(Address5 address5 : address5s) {
                System.out.println("person : " + person5.getName() + " | " + address5.getAddress());
            }

            Address5 address5 = (Address5) session.get(Address5.class, 2l);
            System.out.println("address5 : " + address5.getAddress());
            Set<Person5> person5s = address5.getPerson5s();
            for(Person5 person51 : person5s) {
                System.out.println("address : " + address5.getAddress() + " | " + person51.getName());
            }*/



            /*Person5 p1 = new Person5();
            p1.setName("many and many 5");

            Person5 p2 = new Person5();
            p2.setName("many and many 6");

            Address5 a1 = new Address5();
            a1.setAddress("many and many address 1");
            a1.getPerson5s().add(p1);

            Address5 a2 = new Address5();
            a2.setAddress("many and many address 2");
            a1.getPerson5s().add(p2);

            p1.getAddress5s().add(a1);
            p1.getAddress5s().add(a2);
            p2.getAddress5s().add(a2);

            session.save(p1);
            session.save(p2);
            session.save(a1);
            session.save(a2);*/

            ts.commit();
        }finally {
            session.close();
            sf.close();
        }

    }
}
