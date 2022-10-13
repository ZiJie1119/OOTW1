package singleton;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class Main {
    public static void main(String[] args) {
//        EntityManagerFactory emf
//                = Persistence.createEntityManagerFactory(
//                "contact.odb");
//        EntityManager em = emf.createEntityManager();
        DBConnector dbConnector = new DBConnector();
        DBConnector dbConnectorInstance = dbConnector.getInstance();
        dbConnectorInstance

        em.getTransaction().begin();

        Contact c1 =new Contact("Tim Gmail","b10923057@gemai.yuntech.edu.tw");
        Contact c2 =new Contact("Jim Gmail","b10923055@gemai.yuntech.edu.tw");
        Contact c3 =new Contact("Aven Gmail","b10923003@gemai.yuntech.edu.tw");
        Contact c4 =new Contact("Min Gmail","b10923012@gemai.yuntech.edu.tw");
        Contact c5 =new Contact("Kevin Gmail","b10923026@gemai.yuntech.edu.tw");
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.persist(c5);
        em.getTransaction().commit();
        TypedQuery<Contact> query
                = em.createQuery("SELECT c FROM Contact c",
                Contact.class);
        List<Contact> results = query.getResultList();
        for (Contact bb : results) {
            System.out.println(bb);
        }
        em.close();
        emf.close();
    }
}
