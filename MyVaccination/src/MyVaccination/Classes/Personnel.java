/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

import MyVaccination.Helper_Classes.File_Helper;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author leebe
 */
public class Personnel extends User {

    private String status;
    private String state;
    private String clearance;
    
    public Personnel () {
        super();        
        this.userType = "Personnel";
        this.clearance = "Administrator" ;
    }

    public String getStatus() {
        return status;
    }
    
    public String getState() {
        return state;
    }
    
    public String getClearance() {
        return clearance;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public void setClearance(String clearance) {
        this.clearance = clearance;
    }
    
    public static TableModel getTableModel() {
        return new Personnel_TableModel();
    }

    // Retrieve record of existing personnel
    public static Personnel getPersonnel(String userId) {
        User obj = new User(userId);
        String data = File_Helper.readFile(obj.getFileName());
        return File_Helper.gsonWriter.fromJson(data, Personnel.class);
    }

    // Retrieve all records of personnel
    public static List<Personnel> getFolderData() {
        List<String> folderData = File_Helper.readFolder("User_Account");
        List<Personnel> dataList = new ArrayList<>();
        if (folderData != null) {

            folderData.forEach(fileData -> {
                dataList.add(File_Helper.gsonWriter.fromJson(fileData, Personnel.class));
            }
            );
        }

        List<Personnel> personnelList = dataList.stream().filter(d -> (d.getUserType().equals("Personnel"))).toList();

        return personnelList;
    }
}

// Personnel Table Model
class Personnel_TableModel extends AbstractTableModel {

    private final List<Personnel> tblDataList = Personnel.getFolderData();
    private final String[] TblColumnList = {"UserId", "Name", "Clearance Level", "Status"};


    @Override
    public int getRowCount() {

        return tblDataList.size();
    }

    @Override
    public int getColumnCount() {
        return TblColumnList.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Object temp = null;
        Personnel obj = tblDataList.get(rowIndex);

        switch (colIndex) {

            case 0 -> //User Id
                temp = obj.getUserId();
            case 1 -> //Name
                temp = obj.getUsername();
            case 2 -> //Clearance Level
                temp = obj.getClearance();
            case 3 -> //Personnel Status
                temp = obj.getStatus();
            default ->
                temp = null;
        }
        return temp;
    }

    @Override
    public String getColumnName(int colIndex) {
        return TblColumnList[colIndex];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
