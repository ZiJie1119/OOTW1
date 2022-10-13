package singleton;

public class DBManager {
    private static DBManager dbManager;
    private DBManager(){

    }

    DBManager getInstance(){
        if(dbManager == null){
            dbManager = new DBManager();
        }
        return dbManager;
    }
}
