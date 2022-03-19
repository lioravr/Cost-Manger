package il.ac.hit.project;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class Model implements IModel {
    private String driverFullQualifiedName = "com.mysql.jdbc.Driver";
    private String connectionString = "jdbc:mysql://localhost:3306/shirel";
    private Statement DbTables;
    private Connection connection = null;

    public Model() {
        try {
            Class.forName(driverFullQualifiedName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet login(Account user) throws MyExecption {
        try {
            connection = DriverManager.getConnection(connectionString, user.getUserName(), user.getPassword());
            DbTables = connection.createStatement();
            ResultSet rs = DbTables.executeQuery("select * from costs");
            return rs;
        } catch (SQLException e) {
            throw new MyExecption("Sorry, your password was incorrect", e);
        }
    }

    @Override
    public void logout() {
        try {
            connection.close();
            DbTables = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCost(Cost item) {
        try {
            String query = " insert into costs (Category, Description, Sum, Currency,Date)"
                    + " values (?, ?, ?, ?,?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, item.getCategory().getCategory());
            preparedStmt.setString(2, item.getDescription());
            preparedStmt.setDouble(3, item.getSum());
            preparedStmt.setString(4, item.getCurrency());
            preparedStmt.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
            preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCategory(Subcategory category) {
        try {
            ResultSet rs = DbTables.executeQuery("select * from categories");
            while(rs.next()) {
                if (rs.getString("name").equals(category.getCategory())) {
                    return;
                }
            }
            String query = " insert into categories (Category)"
                    + " values (?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, category.getCategory());
            preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet report(LocalDate start, LocalDate end) {
        ResultSet st=null;
        try {
            st = DbTables.executeQuery("SELECT * FROM costs where Date between '" + start + "'and '" + end+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }
}
    /*
    Implements what should the methods does
    *** All methods should use the database MySQL ***
    list of methods:
    ^Optional: 5. Apply costs within the last 10 days (by clicking "Last 10 days")
     */

