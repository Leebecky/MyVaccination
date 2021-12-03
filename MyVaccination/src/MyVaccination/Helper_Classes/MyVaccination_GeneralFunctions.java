/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Helper_Classes;

import MyVaccination.Classes.User;
import static MyVaccination.Helper_Classes.File_Helper.logToFile;
import MyVaccination.Login;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author leebe
 */
public class MyVaccination_GeneralFunctions {
    //Logout 
    public static void logout(JFrame form, String userId) {
         Login login = new Login();
        login.setVisible(true);
        form.setVisible(false);
        form.dispose();
        
        User user  = User.findUser(userId);
         logToFile(user.getUserType() + " " + user.username + " has logged out",  "Logout");
    }

    //Searches the given JTable based on the value in the given JTextField
    public static void searchTable(JTextField txtSearchBox, JTable tbl) {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tbl.getModel());
        tbl.setRowSorter(rowSorter);

        txtSearchBox.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String searchText = txtSearchBox.getText();
                if (searchText.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String searchText = txtSearchBox.getText();
                if (searchText.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }
}
