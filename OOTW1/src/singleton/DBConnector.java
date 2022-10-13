package singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnector {
    private static DBConnector dbConnector;

    private static EntityManager entityManager;

    DBConnector() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                "contact.odb");
        entityManager = emf.createEntityManager();
    };
    public static DBConnector getInstance(){
        if(dbConnector==null){
            dbConnector= new DBConnector();
        }
        return dbConnector;
    }
    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
