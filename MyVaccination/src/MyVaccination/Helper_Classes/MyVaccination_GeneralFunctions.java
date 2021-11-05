/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Helper_Classes;

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
