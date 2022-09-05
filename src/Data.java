public class Data {

    Database database;
    public Data(Database database) {
        this.database = database;
    }

    public void connect(){
        this.database.connectDb();
    }
}
