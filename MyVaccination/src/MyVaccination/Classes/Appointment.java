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
    private String[] vaccineBatchNumber;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String status;
    private String appointmentType;
    private String vaccineBrand;

    //Constructors
    public Appointment() {
        appointmentId = "APT_" + UUID.randomUUID().toString();
    }

    public Appointment(String appointmentId) {
        this.appointmentId = appointmentId;
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
        return (candidateList == null) ? new ArrayList<>() : candidateList;
//        return candidateList;
    }

    public String[] getVaccineBatchNumber() {
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

    public String getVaccineBrand() {
        return vaccineBrand;
    }

    public String getAppointmentType() {
        return appointmentType;
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

    public void setVaccineBatchNumber(String[] vaccineBatchNumber) {
        this.vaccineBatchNumber = vaccineBatchNumber;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public void setVaccineBrand(String vaccineBrand) {
        this.vaccineBrand = vaccineBrand;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    // Create new batch of appointments
    public static boolean updateAppointment(Appointment apt) {
        //Save appointment
        boolean saveSuccess = File_Helper.saveData(apt, "Appointment");

        //Check if save successful
        if (saveSuccess != true) {
            return saveSuccess;
        }

        return saveSuccess;
    }

    // Retrieve existing appointment details
    public static Appointment getAppointmentDetails(String aptId) {
        Appointment vc = new Appointment(aptId);
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

    //Update candidate list
    public void updateAptCandidate(Candidate candidate, String action) {

        if (this.candidateList == null) {
            this.candidateList = new ArrayList<>();
        }

        if (action.equals("Add")) {
            candidateList.add(candidate);

        } else if (action.equals("Remove")) {
            int remove = -1;
            for (int i = 0; i < candidateList.size(); i++) {
                if (candidateList.get(i).getCandidate().getUserId().equals(candidate.getCandidate().getUserId())) {
                    remove = i;
                }
            }

            if (remove != -1) {
                candidateList.remove(remove);
            }
        }
    }

    //Load candidate 
    public static List<People> getAptCandidateList(Appointment appointment) {

        Appointment apt = (appointment != null)
                ? appointment : new Appointment();

        List<Candidate> candidateList = apt.getCandidateList();
        List<People> peopleList = People.getuserFolderData();
        List<People> potentialCandidateList = new ArrayList<>();
        List<People> removalList = new ArrayList<>();

        for (People user : peopleList) {
            if (!user.getStatus().equals("Fully Vaccinated")) {
                potentialCandidateList.add(user);
            }
        }

        potentialCandidateList.forEach(c -> {
            for (Candidate cd : candidateList) {
                if (c.getUserId().equals(cd.getCandidate().getUserId())) {
                    removalList.add(c);
                }
            }
        });

        potentialCandidateList.removeAll(removalList);
        return potentialCandidateList;
    }

    // Get Appointment Table Model
    public static TableModel getAptTableModel() {
        return new Appointment_TableModel();
    }

    // Get Candidate Table Model
    public static TableModel getAptCandidateTableModel(String candidateType, Appointment apt) {
        if (candidateType != null) {
            return new AppointmentCandidate_TableModel(candidateType, apt);
        }

        if (apt != null) {
            return new AppointmentCandidate_TableModel(apt);
        }

        return new AppointmentCandidate_TableModel();
    }

    @Override
    public String setFileName() {
        return appointmentId;
    }

    @Override
    public String getFileName() {

        return "Appointment/" + appointmentId + ".txt";
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
                temp = Vaccination_Centre.getCentre(aptObj.getCentreId()).getName();
            case 2 -> //Vaccine Type
                temp = aptObj.getVaccineBrand();
            case 3 -> //Opening Time
                temp = aptObj.getAppointmentDate();
            case 4 -> //Closing Time
                temp = aptObj.getAppointmentTime();
            case 5 -> //Type
                temp = aptObj.getAppointmentType();
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

//Populate the table with appointment candidates
class AppointmentCandidate_TableModel extends AbstractTableModel {

    private final List<Appointment> tblDataList = Appointment.getAptFolderData();
    private List<People> potentialCandidateList;
    private List<Candidate> candidateList;
    private final String[] TblColumnList = {"UserId", "Name", "Status"};
    private String tableType;

    public AppointmentCandidate_TableModel() {
        potentialCandidateList = Appointment.getAptCandidateList(null);
        tableType = "Potential";
    }

    public AppointmentCandidate_TableModel(String candidateType, Appointment apt) {
        potentialCandidateList = Appointment.getAptCandidateList(apt);
        tableType = "Potential";
    }

//    public AppointmentCandidate_TableModel(String appointmentId) {
//        Appointment apt = (appointmentId.equals("")) ? new Appointment() : Appointment.getAppointmentDetails(appointmentId);
//        candidateList = apt.getCandidateList();
//        tableType = "Appointment";
//    }
    public AppointmentCandidate_TableModel(Appointment apt) {
        candidateList = apt.getCandidateList();
        tableType = "Appointment";
    }

    @Override
    public int getRowCount() {

        if (tableType == "Appointment") {
            return candidateList.size();

        }
        return potentialCandidateList.size();
    }

    @Override
    public int getColumnCount() {
        return TblColumnList.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Object temp = null;
        if (tableType == "Potential") {
            People obj = potentialCandidateList.get(rowIndex);

            switch (colIndex) {

                case 0 -> //User Id
                    temp = obj.getId();
                case 1 -> //Name
                    temp = obj.getName();
                case 2 -> //Vaccination Status
                    temp = obj.getStatus();
                default ->
                    temp = null;
            }
        } else {
            Candidate obj = candidateList.get(rowIndex);

            switch (colIndex) {

                case 0 -> //User Id
                    temp = obj.getCandidate().getId();
                case 1 -> //Name
                    temp = obj.getCandidate().getName();
                case 2 -> //Appointment Status
                    temp = obj.getApptStatus();
                default ->
                    temp = null;
            }
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
