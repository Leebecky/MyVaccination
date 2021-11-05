/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

import MyVaccination.Helper_Classes.File_Helper;
import MyVaccination.Helper_Classes.File_Methods;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author leebe
 */
public class Appointment implements File_Methods {

    private String appointmentId;
    private String centreId;
    private String candidateId;
    private List<Candidate> candidateList;
    private String vaccineBatchNumber;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String status;
    private String appointmentType;

    //Constructors
    public Appointment() {
        appointmentId = "APT_" + UUID.randomUUID().toString();
    }

    public Appointment(String appointmentId, String appointmentType) {
        this.appointmentId = appointmentId;
        this.appointmentType = appointmentType;
    }

    //User appointment 
    public Appointment(Appointment apt, String candidateId) {
        appointmentId = apt.appointmentId;
        this.candidateId = candidateId;
        vaccineBatchNumber = apt.vaccineBatchNumber;
        appointmentDate = apt.appointmentDate;
        appointmentTime = apt.appointmentTime;
        status = apt.status;
        appointmentType = "Individual";

    }

    //Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public String getCentreId() {
        return centreId;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    public String getVaccineBatchNumber() {
        return vaccineBatchNumber;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    //Setters
    public void setCentreId(String centreId) {
        this.centreId = centreId;
    }

    public void setCandidateList(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setVaccineBatchNumber(String vaccineBatchNumber) {
        this.vaccineBatchNumber = vaccineBatchNumber;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    // Create new batch of appointments
    public static boolean registerAppointment(Appointment apt) {
        //Save batch
        apt.appointmentType = "Batch";
        boolean saveSuccess = File_Helper.saveData(apt, "Appointment");

        //Testing candidate list
        List<Candidate> testList = new ArrayList<>();
        testList.add(new Candidate("123"));
        apt.candidateList = testList;
        
        //Check if batch save successful
        if (saveSuccess != true) {
            return saveSuccess;
        }

        if (apt.candidateList != null) {

            //Save user appointment details
            for (Candidate candidate : apt.candidateList) {

                //TODO: should be passing in candidate id not name
                People candTest = candidate.getCandidate();
                candTest.name = "123";
                
                Appointment userAppointment = new Appointment(apt, candTest.name);
//                Appointment userAppointment = new Appointment(apt, candidate.getCandidate().name);

                saveSuccess = File_Helper.saveData(userAppointment, "Appointment");

                //Check if individual save successful
                if (saveSuccess != true) {
                    return saveSuccess;
                }
            }
        }

        return saveSuccess;
    }

    // Update details of existing appointment
    public static void updateAppointment() {
    }

    // Retrieve existing appointment details
    public static Appointment getBatchAppointment(String aptId) {
        Appointment vc = new Appointment(aptId, "Batch");
        String aptData = File_Helper.readFile(vc.getFileName());
        return File_Helper.gsonWriter.fromJson(aptData, Appointment.class);
    }

    // Retrieve all records of vaccination centres
    public static List<Appointment> getAptFolderData() {
        List<String> aptFolderData = File_Helper.readFolder("Appointment");
        List<Appointment> aptList = new ArrayList<>();
        if (aptFolderData != null) {

            aptFolderData.forEach(fileData -> {
                aptList.add(File_Helper.gsonWriter.fromJson(fileData, Appointment.class));
            }
            );
        }

        return aptList;
    }

    // Get Vaccination Centre Table Model
    public static TableModel getAptTableModel() {
        return new Appointment_TableModel();
    }

    @Override
    public String setFileName() {
        if (appointmentType == "Batch") {
            return appointmentId;
        } else {
            return appointmentId + "/" + candidateId;
        }
    }

    @Override
    public String getFileName() {

        if (appointmentType == "Batch") {
            return "Appointment/" + appointmentId + ".txt";
        } else {
            return "Appointment/" + appointmentId + "/" + candidateId + ".txt";
        }
    }

    //end class
}

class Appointment_TableModel extends AbstractTableModel {

    private final List<Appointment> tblDataList = Appointment.getAptFolderData();
    private final String[] TblColumnList = {"AppointmentId", "Vaccination Centre", "Vaccine", "Appointment Date", "Appointment Time", "Status"};

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
        Appointment aptObj = tblDataList.get(rowIndex);

        switch (colIndex) {

            case 0 -> //Id
                temp = aptObj.getAppointmentId();
            case 1 -> //VC Name
                //PLACEHOLDER ONLY
//                temp = "VC_c773b88a-f84c-44da-98b1-d90687bb977e";
                temp = Vaccination_Centre.getCentre(aptObj.getCentreId()).getName();
            case 2 -> //Vaccine Type
                //TODO get vaccine and return type based on batch number
                temp = aptObj.getVaccineBatchNumber();
            case 3 -> //Opening Time
                temp = aptObj.getAppointmentDate();
            case 4 -> //Closing Time
                temp = aptObj.getAppointmentTime();
            case 5 -> //Status
                temp = "Active";
//                temp = aptObj.getStatus();
            default ->
                temp = null;
        }

        return temp;
    }

    @Override
    public String getColumnName(int colIndex) {
        return TblColumnList[colIndex];
    }

//    @Override
//    public Class getColumnClass(int c) {
//        return getValueAt(0, c).getClass();
//    }

}
