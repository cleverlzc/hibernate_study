package Controller.transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.transaction.TransactionTest;

/**
 * Created by root on 17-3-17.
 */
public class TransactionTestController {
    public static void main(String[] args) {
        Configuration cf = new Configuration().configure();
        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();

        try {
            TransactionTest tt = new TransactionTest();
            tt.setAge(1);
            tt.setName("1");
            session.save(tt);

            TransactionTest tt1 = new TransactionTest();
            tt1.setAge(2);
            tt1.setName("2");
            session.save(tt1);
            ts.commit();

        } finally {
            session.close();
            sf.close();
        }

    }
}
