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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Vaccination_Centre implements File_Methods {

    private String centreId;
    private String name;
    private Location location;
    public List<String> servicesId;
    private List<Stock> stock;
    private LocalTime openingTime; //24 hour system
    private LocalTime closingTime; //24 hour system
    private String status;

    //Constructor
    public Vaccination_Centre() {
        centreId = "VC_" + UUID.randomUUID();
    }

    public Vaccination_Centre(String name, LocalTime openingTime, LocalTime closingTime, String status, Location location) {
        centreId = "VC_" + UUID.randomUUID();
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.status = status;
        this.location = location;
    }

    public Vaccination_Centre(String centreId, String name, LocalTime openingTime, LocalTime closingTime, String status, Location location) {
        this.centreId = centreId;
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.status = status;
        this.location = location;
    }

    public Vaccination_Centre(String centreId) {
        this.centreId = centreId;
    }

    //Getters & Setters
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

    public Location getLocation() {
        return (this.location == null) ? new Location() : this.location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setStock(List<Stock> stockList) {
        stock = stockList;
    }

    public void resupply(Stock stockItem) {
        if (stock != null) {
            stock.add(stockItem);
        } else {
            List<Stock> vcStock = new ArrayList<>();
            vcStock.add(stockItem);
            stock = vcStock;
        }
    }

    // Create new vaccination centre or Update details of existing vaccination centre 
    public static boolean updateCentre(Vaccination_Centre vc) {
        boolean saveSuccess = File_Helper.saveData(vc, "Vaccination_Centre");
        return saveSuccess;
    }

    // Retrieve record of existing vaccination centre
    public static Vaccination_Centre getCentre(String vcCentreId) {
        Vaccination_Centre vc = new Vaccination_Centre(vcCentreId);
        String vcData = File_Helper.readFile(vc.getFileName());
        return File_Helper.gsonWriter.fromJson(vcData, Vaccination_Centre.class);
    }

    // Retrieve all records of vaccination centres
    public static List<Vaccination_Centre> getVcFolderData() {
        List<String> vcFolderData = File_Helper.readFolder("Vaccination_Centre");
        List<Vaccination_Centre> vcList = new ArrayList<>();
        if (vcFolderData != null) {

            vcFolderData.forEach(fileData -> {
                vcList.add(File_Helper.gsonWriter.fromJson(fileData, Vaccination_Centre.class));
            }
            );
        }

        return vcList;
    }

    // Get Vaccination Centre Table Model
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

    // For use in the JComboBox
    @Override
    public String toString() {
        return name;
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
