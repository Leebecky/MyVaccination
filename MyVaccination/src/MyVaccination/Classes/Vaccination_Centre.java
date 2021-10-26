/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

import MyVaccination.Helper_Classes.File_Helper;
import MyVaccination.Helper_Classes.File_Methods;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class Vaccination_Centre implements File_Methods {

    private String centreId;
    private String name;
    public Location location;
    public List<String> servicesId;
    private List<Stock> stock;
    private LocalTime openingTime; //24 hour system
    private LocalTime closingTime; //24 hour system
    private String status;

    //Constructor
    public Vaccination_Centre(String name, LocalTime openingTime, LocalTime closingTime, String status) {
        centreId = "VC_" + UUID.randomUUID();
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.status = status;
    }

    public Vaccination_Centre(String centreId, String name, LocalTime openingTime, LocalTime closingTime, String status) {
        this.centreId = centreId;
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.status = status;
    }

    public Vaccination_Centre(String centreId) {
        this.centreId = centreId;
    }

    //Getters & Setters
    public void setStock(List<Stock> item) {
        stock = item;
    }

    public String getCentreId() {
        return centreId;
    }

    public String getName() {
        return name;
    }

    public List<Stock> getStock() {
        return stock;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public String getStatus() {
        return status;
    }

    public static boolean registerCentre(String name, LocalTime openingTime, LocalTime closingTime, String status) {
        Vaccination_Centre vc = new Vaccination_Centre(name, openingTime, closingTime, status);
        boolean saveSuccess = File_Helper.saveData(vc, "Vaccination_Centre");
        return saveSuccess;
    }

    public static boolean updateCentre(String centreId, String name, LocalTime openingTime, LocalTime closingTime, String status) {
        Vaccination_Centre vc = new Vaccination_Centre(centreId, name, openingTime, closingTime, status);
        boolean saveSuccess = File_Helper.saveData(vc, "Vaccination_Centre");
        return saveSuccess;
    }

    public static Vaccination_Centre getCentre(String vcCentreId) {
        Vaccination_Centre vc = new Vaccination_Centre(vcCentreId);
        String vcData = File_Helper.readFile(vc.getFileName());
        return File_Helper.gsonWriter.fromJson(vcData, Vaccination_Centre.class);
    }

    public static List<Vaccination_Centre> getVcFolderData() {
        List<String> vcFolderData = File_Helper.readFolder("Vaccination_Centre");
        List<Vaccination_Centre> vcList = new ArrayList<>();
        vcFolderData.forEach(fileData -> {
            vcList.add(File_Helper.gsonWriter.fromJson(fileData, Vaccination_Centre.class));
        }
        );

        return vcList;
    }

    public static TableModel getVcTableModel() {
        return new VaccinationCentre_TableModel();
    }

    //Interface implementation
    @Override
    public String setFileName() {
        return centreId;
    }

    @Override
    public String getFileName() {
        return "Vaccination_Centre/" + centreId + ".txt";
    }

}

class VaccinationCentre_TableModel extends AbstractTableModel {

    private final List<Vaccination_Centre> vcList = Vaccination_Centre.getVcFolderData();
    private final String[] vcColumnList = {"CentreId", "Name", "Opening Time", "Closing Time", "Status"};

    @Override
    public int getRowCount() {

        return vcList.size();
    }

    @Override
    public int getColumnCount() {
        return vcColumnList.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Object temp = null;
        Vaccination_Centre vcObj = vcList.get(rowIndex);
        switch (colIndex) {

            case 0 -> //Id
                temp = vcObj.getCentreId();
            case 1 -> //Name
                temp = vcObj.getName();
            case 2 -> //Opening Time
                temp = vcObj.getOpeningTime();
            case 3 -> //Closing Time
                temp = vcObj.getClosingTime();
            case 4 -> //Status
                temp = vcObj.getStatus();
            default ->
                temp = null;
        }

        return temp;
    }

    @Override
    public String getColumnName(int colIndex) {
        return vcColumnList[colIndex];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

}
