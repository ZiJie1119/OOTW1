//package Iterator;
//
//import Database.DBConnector;
//import Database.Model.DocumentModel;
//
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//import javax.swing.*;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
////        stuffFakeData();
////        clearDatabase();
//        printAllDocument();
//        DocumentIterator documentIterator = constructDialog();
//    }
//    public static JFrame setUpVersionJFrame(){
//        JFrame versionFrame = new JFrame("Version Showing");
//        versionFrame.setVisible(true);
//        versionFrame.setSize(500,500);
//
//        return versionFrame;
//    }
//
//
//    public static DocumentIterator constructDialog(){
//        DBConnector dbConnector = DBConnector.getInstance();
//        EntityManager entityManager = dbConnector.getConnection();
//
//        TypedQuery<DocumentModel> documentQuery = entityManager.createQuery("SELECT document from DocumentModel document",DocumentModel.class);
//        List<DocumentModel> documentModelList = documentQuery.getResultList();
//
//        DocumentCollection collection = new ArrayDocumentCollection(documentModelList);
//        DocumentIterator documentIterator = collection.iterator();
//
//        JFrame jFrame = setUpVersionJFrame();
//        JDialog versionDialog = new JDialog(jFrame,"Version");
//        JPanel versionPanel = new JPanel();
//
//        versionDialog.setSize(400, 100);
//
//        while(documentIterator.hasNext()){
//            DocumentModel documentModel = documentIterator.next();
//            String tempDocumentId = String.valueOf(documentModel.documentId);
//
//            JButton tempButton = new JButton(tempDocumentId);
//            tempButton.addActionListener(e -> versionDialog.dispose());
//
//            versionPanel.add(tempButton);
//        }
//        versionPanel.invalidate();
//        versionPanel.repaint();
//
//        versionDialog.setContentPane(versionPanel);
//        versionDialog.setVisible(true);
//
//        return documentIterator;
//    }
//    public static void stuffFakeData(){
//        DBConnector dbConnector = DBConnector.getInstance();
//        EntityManager entityManager = dbConnector.getConnection();
//
//        entityManager.getTransaction().begin();
//
//        DocumentModel documentModel1 = new DocumentModel();
//        documentModel1.setDocumentId(1);
//        documentModel1.setFileName("Tim");
//
//        DocumentModel documentModel2 = new DocumentModel();
//        documentModel2.setDocumentId(2);
//        documentModel2.setFileName("Mim");
//
//        DocumentModel documentModel3 = new DocumentModel();
//        documentModel3.setDocumentId(3);
//        documentModel3.setFileName("Kevin");
//
//        DocumentModel documentModel4 = new DocumentModel();
//        documentModel4.setDocumentId(4);
//        documentModel4.setFileName("Andy");
//
//        entityManager.persist(documentModel1);
//        entityManager.persist(documentModel2);
//        entityManager.persist(documentModel3);
//        entityManager.persist(documentModel4);
//
//        entityManager.getTransaction().commit();
//
//        System.out.println("Fake Data Construct Complete");
//    }
//    public static void clearDatabase(){
//        DBConnector dbConnector = DBConnector.getInstance();
//        EntityManager entityManager = dbConnector.getConnection();
//
//        entityManager.getTransaction().begin();
//        TypedQuery<DocumentModel> documentQuery = entityManager.createQuery("SELECT document from DocumentModel document",DocumentModel.class);
//
//        for (DocumentModel documentModel:documentQuery.getResultList()
//             ) {
//            entityManager.remove(documentModel);
//        }
//        entityManager.getTransaction().commit();
//
//        System.out.println("Clean Database");
//    }
//    public static void printAllDocument(){
//        DBConnector dbConnector = DBConnector.getInstance();
//        EntityManager entityManager = dbConnector.getConnection();
//
//        TypedQuery<DocumentModel> documentQuery = entityManager.createQuery("SELECT document from DocumentModel document",DocumentModel.class);
//        List<DocumentModel> documentModelList = documentQuery.getResultList();
//
//        for(DocumentModel documentModel:documentModelList){
//            System.out.print(documentModel.documentId+"\t");
//            System.out.print(documentModel.getFileName()+"\t");
//            System.out.print(documentModel.getUpdateTime()+"\t");
//
//            System.out.println("\n");
//        }
//    }
//}
