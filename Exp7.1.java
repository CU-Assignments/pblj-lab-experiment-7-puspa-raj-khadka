

1. **Setup MySQL Database**  
   - Ensure MySQL is installed and running.  
   - Create a database and an `Employee` table with columns `EmpID`, `Name`, and `Salary`.

2. **Update Database Credentials**  
   - Replace `your_database`, `your_username`, and `your_password` in the code with actual database credentials.

3. **Add MySQL JDBC Driver**  
   - Download and add `mysql-connector-java.jar` to your project’s classpath.

4. **Compile and Run the Program**  
   - Compile: `javac MySQLConnection.java`  
   - Run: `java MySQLConnection`

5. **Verify Output**  
   - Ensure that employee records are displayed correctly from the database.

   code - import java.sql.*;

public class MySQLConnection {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "Aditya";
        String password = "123456";

        // JDBC variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");

            // Create and execute query
            stmt = conn.createStatement();
            String query = "SELECT * FROM Employee";
            rs = stmt.executeQuery(query);

            // Process and display results
            System.out.println("EmpID | Name | Salary");
            while (rs.next()) {
                int id = rs.getInt("EmpID");
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");
                System.out.println(id + " | " + name + " | " + salary);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error!");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
