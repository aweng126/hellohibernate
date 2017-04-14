package Main;

import Bean.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by kingwen on 2017/4/13.
 */
public class InsertDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory fac = cfg.buildSessionFactory();
        Session s = null;
        Transaction tx = null;
        try {
            s = fac.openSession();
            tx = s.beginTransaction();
            User u = new User();
            u.setName("tom");
            u.setPass("888888");
            s.save(u);
            tx.commit();

        }catch(HibernateException e) {
            tx.rollback();
            if(s.isOpen()) {
                s.close();
            }
        }
    }
}
