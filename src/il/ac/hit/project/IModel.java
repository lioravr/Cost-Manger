package il.ac.hit.project;

import javax.swing.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;

public interface IModel {


    public ResultSet login(Account user) throws MyExecption;
    public void logout();
    public void addCost(Cost item);
    public void addCategory(Subcategory category);
    public ResultSet report(LocalDate start, LocalDate end);

    /*
    write all the function that the standalone application should do
1. login
2. logout
3. add cost
4. add category
5. report
    example:
        *****public void addItem(Item item) throws ToDoListException;*****
     */
}
