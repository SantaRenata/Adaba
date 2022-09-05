import java.sql.Connection;

public interface Database {
    public Connection connectDb();
    public void closeDb(Connection con);
}