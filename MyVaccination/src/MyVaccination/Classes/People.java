/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

import MyVaccination.Helper_Classes.File_Helper;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author user
 */
public class People extends User {

    public String name;
    public LocalDate dateOfBirth;
    private String identification; //Passport or IC number
    public String nationality;
    public String vaccinationStatus;
    public String address;
    public String gender;
    private List<String> vaccinationHistory;

    public People() {
        super();
        this.userType = "People";
        this.vaccinationStatus = "Not Vaccinated";
        
    }

    public People(String n, LocalDate dob, String id, String nat, String v, String a, String g, String email, String phoneNum) {
        this.name = n;
        this.dateOfBirth = dob;
        this.identification = id;
        this.nationality = nat;
        this.vaccinationStatus = v;
        this.address = a;
        this.gender = g;
        this.email = email;
        this.contactNumber = phoneNum;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDob() {
        return this.dateOfBirth;
    }

    public String getId() {
        return this.identification;
    }

    public String getNation() {
        return this.nationality;
    }

    public String getStatus() {
        return this.vaccinationStatus;
    }

    public String getAddress() {
        return this.address;
    }

    public String getGender() {
        return this.gender;
    }
    
    public List<String> getVaccinationHistory() {
        if (this.vaccinationHistory == null) {
            this.vaccinationHistory = new ArrayList<>();
        }
        return this.vaccinationHistory;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setDob(LocalDate dob) {
        this.dateOfBirth = dob;
    }

    public void setId(String id) {
        this.identification = id;
    }

    public void setNation(String nat) {
        this.nationality = nat;
    }

    public void setStatus(String v) {
        this.vaccinationStatus = v;
    }

    public void setAddress(String a) {
        this.address = a;
    }

    public void setGender(String g) {
        this.gender = g;
    }

    public void updateVaccinationHistory(String aptId, String updateType) {
        if (this.vaccinationHistory == null) {
            this.vaccinationHistory = new ArrayList<>();
        }
        
        if (updateType.equals("Add")) {

            this.vaccinationHistory.add(aptId);
        }

        if (updateType.equals("Remove")) {
            this.vaccinationHistory.remove(aptId);
        }
    }

    public static TableModel getTableModel() {
        return new People_TableModel();
    }

    // Retrieve record of existing People
    public static People getPeople(String userId) {
        User obj = new User(userId);
        String data = File_Helper.readFile(obj.getFileName());
        return File_Helper.gsonWriter.fromJson(data, People.class);
    }

    // Retrieve all records of People
    public static List<People> getFolderData() {
        List<String> folderData = File_Helper.readFolder("User_Account");
        List<People> dataList = new ArrayList<>();
        if (folderData != null) {

            folderData.forEach(fileData -> {
                dataList.add(File_Helper.gsonWriter.fromJson(fileData, People.class));
            }
            );
        }

        List<People> PeopleList = dataList.stream().filter(d -> (!d.getUserType().equals("Personnel"))).toList();

        return PeopleList;
    }
}

// People Table Model
class People_TableModel extends AbstractTableModel {

    private final List<People> tblDataList = People.getFolderData();
    private final String[] TblColumnList = {"UserId", "Name", "Identification", "Nationality", "Vaccination Status", "State"};

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
        Object temp;
        People obj = tblDataList.get(rowIndex);

        switch (colIndex) {

            case 0 -> //User Id
                temp = obj.getUserId();
            case 1 -> //Name
                temp = obj.getName();
            case 2 -> //Identification
                temp = obj.getId();
            case 3 -> //Nationality
                temp = obj.getNation();
            case 4 -> //Vacccination Status
                temp = obj.getStatus();
            case 5 -> //State
                temp = obj.getAddress();
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
