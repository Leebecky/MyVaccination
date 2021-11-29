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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Vaccination_Centre implements File_Methods {

    private String centreId;
    private String name;
    private Location location;
    public List<String> servicesId;
    private List<Stock> stock;
    private LocalTime openingTime; //24 hour system
    private LocalTime closingTime; //24 hour system
    private String status;
    private int capacity; //number of people per appointment

    //Constructor
    public Vaccination_Centre() {
        centreId = "VC_" + UUID.randomUUID();
    }

    public Vaccination_Centre(String name, LocalTime openingTime, LocalTime closingTime, String status, Location location, int capacity) {
        centreId = "VC_" + UUID.randomUUID();
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.status = status;
        this.location = location;
        this.capacity = capacity;
    }

    public Vaccination_Centre(String centreId, String name, LocalTime openingTime, LocalTime closingTime, String status, Location location, int capacity) {
        this.centreId = centreId;
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.status = status;
        this.location = location;
        this.capacity = capacity;
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

    public int getCapacity() {
        return capacity;
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

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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

    // Get Vaccination Centre Supply Table Model
    public static TableModel getVcSupplyTableModel(String vcId, Vaccination_Centre vc) {
        if (vc != null) {
            return new VaccinationCentreSupply_TableModel(vc);
        }

        return (vcId == null)
                ? new VaccinationCentreSupply_TableModel() : new VaccinationCentreSupply_TableModel(vcId);
    }

    // Generate dataset for vaccination centre supply chart (Individual)
    public CategoryDataset supplyDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        HashMap<String, Integer> supplyList = this.checkVcSupply();

        Object[] vaccine = supplyList.keySet().toArray();
        Arrays.sort(vaccine);

        for (int i = 0; i < supplyList.size(); i++) {
            dataset.addValue(supplyList.get(vaccine[i].toString()), vaccine[i].toString(), "Quantity");
        }

        return dataset;
    }

    // Generate dataset for vaccination centre supply chart (All)
    public static CategoryDataset supplyDatasetAll() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        List<Vaccination_Centre> vcList = Vaccination_Centre.getVcFolderData();
        for (Vaccination_Centre vc : vcList) {

            HashMap<String, Integer> supplyList = vc.checkVcSupply();
            Object[] vaccine = supplyList.keySet().toArray();

            Arrays.sort(vaccine);

            for (int i = 0; i < supplyList.size(); i++) {
                dataset.addValue(supplyList.get(vaccine[i].toString()), vaccine[i].toString(), vc.getName());
            }

        }

        return dataset;
    }

    // Vaccination Centre Stock
    public HashMap<String, Integer> checkVcSupply() {

        HashMap<String, Integer> supply = new HashMap<>();
        String[] vaccineList = Vaccine.getListOfVaccines();

        for (String vaccineName : vaccineList) {
            int stockQuantity = 0;

            if (stock != null) {
                for (Stock item : stock) {
                    if (item.getVaccine().getName().equals(vaccineName)) {
                        stockQuantity = stockQuantity + item.getQuantity();
                    }
                }
            }

            supply.put(vaccineName, stockQuantity);
        }

        return supply;
    }

    // Update Vaccination Stock for Appointment
    public Appointment updateVcSupply(Appointment objApt) {

        Appointment oriApt = Appointment.getAppointmentDetails(objApt.getAppointmentId());
        List<Candidate> removedCandidates = oriApt.getCandidateList();
        List<Candidate> addedCandidates = objApt.getCandidateList();

        removedCandidates.removeAll(objApt.getCandidateList());
        addedCandidates.removeAll(oriApt.getCandidateList());

        if (!addedCandidates.isEmpty()) {

            List<Stock> vaccinesOfBrand = new ArrayList<>();
            stock.stream().filter(s -> (s.getVaccine().getName().equals(objApt.getVaccineBrand()))).forEachOrdered(s -> {
                vaccinesOfBrand.add(s);
            });

            //Sort according to the supplyDate
            Collections.sort(vaccinesOfBrand, Comparator.comparing(Stock::getSupplyDate));

            // Update the first found stock with value
            for (Candidate c : addedCandidates) {
                String batchNum = "";
                for (Stock s : vaccinesOfBrand) {
                    if (!s.getSupplyStatus().equals("Depleted")) {
                        s.updateQuantity(-1);

                        if (s.getQuantity() == (0)) {
                            s.setSupplyStatus("Depleted");
                        }
                        batchNum = s.getVaccine().getBatchNumber();
                        break;
                    }
                }
                c.setVaccineBatchNumber(batchNum);
            }
        }

        objApt.setCandidateList(addedCandidates);
        return objApt;
    }

    // Add back the vaccine supply when candidate cancels/rejects
    public void refundStock(String vaccineBatchNumber) {
        List<Stock> myVaccine = (List<Stock>) stock.stream().filter(s -> (s.getVaccine().getBatchNumber().equals(vaccineBatchNumber))).toList();
        int myStockIndex = stock.indexOf(myVaccine.get(0));
        Stock myStock = stock.get(myStockIndex);

        if (myStock != null) {

            if (myStock.getSupplyStatus().equals("Depleted")) {
                myStock.setSupplyStatus("Active");
            }

            myStock.updateQuantity(1);
        }

        Vaccination_Centre.updateCentre(this);
    }

    // Subtract stock when new candidate added
    public String useStock(String vaccineBrand) {

//        List<Stock> vaccinesOfBrand = new ArrayList<>();
        List<Stock> vaccineBrandList = (List<Stock>) stock.stream().filter(s -> (s.getVaccine().getName().equals(vaccineBrand))).toList();

        //Find first available stock and update
        for (Stock s : vaccineBrandList) {
            if (s.getSupplyStatus().equals("Active")) {
                s.updateQuantity(-1);

                if (s.getQuantity() == 0) {
                    s.setSupplyStatus("Depleted");
                }

                Vaccination_Centre.updateCentre(this);

                return s.getVaccine().getBatchNumber();
            }
        }
        return null;

    }
    
    //Find vaccine from stock
//    public Vaccine findVaccine(String vaccineBatchNumber) {
//        if (this.stock == null) {
//            return null;
//        }
//        
//        for (Stock s : this.stock) {
//            if (s.getVaccine().getBatchNumber().equals(vaccineBatchNumber)) {
//                return s.getVaccine();
//            }
//        }
//        
//        return null;
//    }

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
    private final String[] vcColumnList = {"CentreId", "Name", "Capacity", "Opening Time", "Closing Time", "Status"};

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
            case 2 -> //Capacity
                temp = vcObj.getCapacity();
            case 3 -> //Opening Time
                temp = vcObj.getOpeningTime();
            case 4 -> //Closing Time
                temp = vcObj.getClosingTime();
            case 5 -> //Status
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

//VC Supply Table
class VaccinationCentreSupply_TableModel extends AbstractTableModel {

    private final List<Vaccination_Centre> vcList = Vaccination_Centre.getVcFolderData();
    private Vaccination_Centre vc;
    private String[] vcColumnList;
    private String modelType;

    public VaccinationCentreSupply_TableModel() {
        vcColumnList = new String[]{"Vaccination Centre", "AstraZeneca", "CanSino", "Pfizer", "Sinovac"};
        modelType = "All";
    }

    public VaccinationCentreSupply_TableModel(String vcId) {
        vcColumnList = new String[]{"Vaccine", "Quantity"};

        if (vcId != "") {
            vc = Vaccination_Centre.getCentre(vcId);
        } else {
            vc = new Vaccination_Centre();
        }
        modelType = "Individual";
    }

    public VaccinationCentreSupply_TableModel(Vaccination_Centre vc) {
        vcColumnList = new String[]{"Vaccine", "Quantity"};

        if (vc != null) {
            this.vc = vc;
        }
        modelType = "Individual";
    }

    @Override
    public int getRowCount() {

        if (modelType == "All") {
            return vcList.size();
        } else {
            return vc.checkVcSupply().size();
        }
    }

    @Override
    public int getColumnCount() {
        return vcColumnList.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Object temp = null;

        if (modelType == "All") {
            Vaccination_Centre vcObj = vcList.get(rowIndex);
            switch (colIndex) {

                case 0 -> //Name
                    temp = vcObj.getName();
                case 1 -> //AstraZeneca
                    temp = vcObj.checkVcSupply().get("AstraZeneca");
                case 2 -> //CanSino
                    temp = vcObj.checkVcSupply().get("CanSino");
                case 3 -> //Pfizer
                    temp = vcObj.checkVcSupply().get("Pfizer");
                case 4 -> //Sinovac
                    temp = vcObj.checkVcSupply().get("Sinovac");

                default ->
                    temp = null;
            }
        } else {
            HashMap<String, Integer> supplyList = vc.checkVcSupply();
            Object[] vaccine = supplyList.keySet().toArray();
            Arrays.sort(vaccine);

            switch (colIndex) {

                case 0 -> //Vaccine
                    temp = vaccine[rowIndex];
                case 1 -> //Quantity
                    temp = supplyList.get(vaccine[rowIndex].toString());
                default ->
                    temp = null;
            }
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
