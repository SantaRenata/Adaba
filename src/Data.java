import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Data {

    Database database;
    Connection con;

    public Data(Database database) {
        this.database = database;
    }

    public void connect(){
        this.con = this.database.connectDb();
    }

    public void close(){
        this.database.closeDb(con);
    }


    public ArrayList<Employee> getEmployees(){
        ArrayList<Employee> employeeList = new ArrayList<>();

        try {
            employeeList = this.tryGetEmployees();
        } catch (SQLException e) {
            System.err.println("Hiba! A dolgozók lekérdezése sikertelen");
        }
        
        return employeeList;
    }

    public ArrayList<Employee> tryGetEmployees() throws SQLException{
        ArrayList<Employee> employeeList = new ArrayList<>();
        String sql = "select * from employees";
        this.connect();
        Statement st = this.con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            Employee emp = new Employee();
            emp.id = rs.getInt("id");
            emp.name = rs.getString("name");
            emp.city = rs.getString("city");
            emp.salary = rs.getDouble("salary");
            employeeList.add(emp);
        }

        this.close();

        return employeeList;
        
    }
}
