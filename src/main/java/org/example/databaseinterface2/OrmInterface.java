package org.example.databaseinterface2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;
import javax.naming.*;

public class OrmInterface {
    public String ExecuteQuery(String query){

            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            NativeQuery<?> nativeQuery = session.createNativeQuery(query);
            nativeQuery.getResultList();
            List<?> results = nativeQuery.getResultList();
            StringBuilder res = new StringBuilder();
            for (Object result : results) {
                if (result instanceof String) {
                    res.append((String) result).append("\n");
                } else if (result instanceof Object[]) {
                    for(Object o : (Object[]) result){
                        res.append(o.toString()).append(" , ");
                    }
                    res.append('\n');
                } else {
                    // Handle other types if necessary
                    res.append(result.toString()).append("\n");
                }
            }

            // Commit transaction
            session.getTransaction().commit();

            // Close session and session factory
            session.close();
            sessionFactory.close();
            return res.toString();
    }
}
