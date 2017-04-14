package Main;

import Bean.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

/**
 * Created by kingwen on 2017/4/14.
 */
public class SearchDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory fac = cfg.buildSessionFactory();
        Session session = null;
        Transaction tx = null;
        try {
            session = fac.openSession();
            tx = session.beginTransaction();

 /*方式一进行sql语句的执行。*/
          /*  String sql="select * from t_user ";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(User.class);
            List results = query.list();
            tx.commit();*/
/*方式二 通过参数进行查询。*/
            String sql2 = "select * from t_user where id =  :user_id";
            SQLQuery query1 = session.createSQLQuery(sql2);
            query1.addEntity(User.class);
            query1.setParameter("user_id", 1);
            List results1 = query1.list();
            printResult(results1);
            tx.commit();

        }catch(HibernateException e) {
            tx.rollback();
            if(session.isOpen()) {
                session.close();
            }
        }
    }

    public static void printResult(List results){
        System.out.println("the num of result is "+results.size());
        if(results!=null){
            for (Iterator iterator =
                 results.iterator(); iterator.hasNext();){
                User user = (User) iterator.next();
                System.out.print("id: " + user.getId());
                System.out.print("name: " + user.getName());
                System.out.print("pass: " + user.getPass()+"\n");
            }
        }
    }
}
