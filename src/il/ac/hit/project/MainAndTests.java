package il.ac.hit.project;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;

public class MainAndTests {
    public static void main(String args[])
    {
        Model model=new Model();
        Account user=new Account("shirel","2000");
        JFrame frame=new JFrame();
        JTable table=new JTable();
        frame.add(table);
        try {
            ResultSet rs=model.login(user);
            //table.setModel(DbUtils.resultSetToTableModel(rs));
            frame.setSize(500,400);
            LocalDate start=LocalDate.of(2020,10,1);
            LocalDate end=LocalDate.of(2021,12,3);
            ResultSet st=model.report(start,end);
            table.setModel(DbUtils.resultSetToTableModel(st));
            frame.setVisible(true);
            //Cost C=new Cost("Black Friday",100,"US",new Subcategory("Buying"));
            //model.addCost(C);
        } catch (MyExecption e) {
            e.printStackTrace();
        }
    }
}