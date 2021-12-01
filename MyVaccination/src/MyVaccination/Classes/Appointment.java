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
import java.util.Optional;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
    
/**
 *
 * @author leebe
 */
public class Appointment implements File_Methods {

    private String appointmentId;
    private String centreId;
    private List<Candidate> candidateList;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String status;
    private String vaccineBrand;
//    private String appointmentType;
//    private String candidateId;
//    private String[] vaccineBatchNumber;

    //Constructors
    public Appointment() {
        appointmentId = "APT_" + UUID.randomUUID().toString();
        status = "Active";
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

//    public String getCandidateId() {
//        return candidateId;
//    }

    public List<Candidate> getCandidateList() {
        return (candidateList == null) ? new ArrayList<>() : candidateList;
//        return candidateList;
    }

//    public String[] getVaccineBatchNumber() {
//        return vaccineBatchNumber;
//    }

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

//    public String getAppointmentType() {
//        return appointmentType;
//    }

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

//    public void setVaccineBatchNumber(String[] vaccineBatchNumber) {
//        this.vaccineBatchNumber = vaccineBatchNumber;
//    }
//
//    public void setCandidateId(String candidateId) {
//        this.candidateId = candidateId;
//    }

    public void setVaccineBrand(String vaccineBrand) {
        this.vaccineBrand = vaccineBrand;
    }

//    public void setAppointmentType(String appointmentType) {
//        this.appointmentType = appointmentType;
//    }

    // Create new batch of appointments/updating appointments
    public static boolean updateAppointment(Appointment apt) {
        Appointment oriApt = Appointment.getAppointmentDetails(apt.getAppointmentId());
        List<Candidate> candidateList = apt.getCandidateList();
        Vaccination_Centre vc = Vaccination_Centre.getCentre(apt.getCentreId());

        if (oriApt != null) { //If existing appointment
            //Removed Candidates - add stock
            List<Candidate> currentList = apt.getCandidateList();
            for (Candidate oriC : oriApt.getCandidateList()) {
                Optional<Candidate> existingCandidate = currentList.stream().filter(c -> (c.getCandidateId().equals(oriC.getCandidateId()))).findFirst();
                if (existingCandidate.isEmpty()) {
                    vc.refundStock(oriC.getVaccineBatchNumber());

                    String vStatus = (oriC.findCandidate().getStatus().contains("2")) ? "1st Dose Completed" : "Not Vaccinated";

                    oriC.updateCandidateStatus(vStatus, "Removed", apt.getAppointmentId(), "Remove");
                }
            }

            //Added Candidates - subtract stock
            for (Candidate aptC : candidateList) {
                List<Candidate> oriList = oriApt.getCandidateList();
                Optional<Candidate> addedCandidate = oriList.stream().filter(c -> (c.getCandidateId().equals(aptC.getCandidateId()))).findFirst();

                if (addedCandidate.isEmpty()) {
                    String vaccineBatchNum = vc.useStock(apt.getVaccineBrand());
                    aptC.setVaccineBatchNumber(vaccineBatchNum);
                    String vStatus = (aptC.findCandidate().getStatus().contains("1")) ? "2nd Dose Appointment Pending" : "1st Dose Appointment Pending";

                    aptC.updateCandidateStatus(vStatus, "Pending", apt.getAppointmentId(), "Add");
//                    aptC.findCandidate().updateVaccinationHistory(apt.getAppointmentId(), "Add");
                }
            }
        } else { //If new appointment
            for (Candidate aptC : candidateList) {
                //Added Candidates - subtract stock
                String vaccineBatchNum = vc.useStock(apt.getVaccineBrand());
                aptC.setVaccineBatchNumber(vaccineBatchNum);

                String vStatus = (aptC.findCandidate().getStatus().contains("1")) ? "2nd Dose Appointment Pending" : "1st Dose Appointment Pending";

                aptC.updateCandidateStatus(vStatus, "Pending", apt.getAppointmentId(), "Add");
//                aptC.findCandidate().updateVaccinationHistory(apt.getAppointmentId(), "Add");
            }
        }

        apt.setCandidateList(candidateList);

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
                if (candidateList.get(i).getCandidateId().equals(candidate.getCandidateId())) {
                    remove = i;
                }
            }

            if (remove != -1) {
                candidateList.remove(remove);
            }
        }
    }
    
    // Update appointment status (Pending -> Rejected/Confirmed)
    public boolean updateAptStatus(Candidate candidate, String status){
        for (int i = 0; i < candidateList.size(); i++) {
            if (candidateList.get(i).getCandidateId().equals(candidate.getCandidateId())) {
                candidateList.get(i).setApptStatus(status);
            }
        }
        
        boolean saveSuccess = File_Helper.saveData(this, "Appointment");

        //Check if save successful
        if (saveSuccess != true) {
            return saveSuccess;
        }

        return saveSuccess;
    }

    //Get potential candidates
    public static List<People> getAptCandidateList(Appointment appointment) {

        Appointment apt = (appointment != null)
                ? appointment : new Appointment();

        Vaccination_Centre vc = Vaccination_Centre.getCentre(appointment.getCentreId());
        String state = (vc != null) ? vc.getLocation().getState() : "All";

        List<Candidate> candidateList = apt.getCandidateList();
        List<People> peopleList = People.getFolderData();
        List<People> potentialCandidateList = new ArrayList<>();
        List<People> removalList = new ArrayList<>();

        for (People user : peopleList) {
            if (!user.getStatus().equals("Fully Vaccinated") && (!user.getStatus().contains("Pending"))) {
                potentialCandidateList.add(user);
            }
        }

        for (People c : potentialCandidateList) {
            for (Candidate cd : candidateList) {
                if (c.getUserId().equals(cd.findCandidate().getUserId())) {
                    removalList.add(c);
                }
            }

            //Vaccination Centre should be in same state as candidate
            if (!state.equals("All")) {

                if (!c.getAddress().equals(state)) {
                    removalList.add(c);
                    continue;
                }
            }

            // 2nd appointment, only if the wait time has been long enough
            List<String> vaccinationHistory = c.getVaccinationHistory();
            if (vaccinationHistory.isEmpty()) {
                continue;
            }
            Appointment apt1 = Appointment.getAppointmentDetails(vaccinationHistory.get(0));
            LocalDate vaccinationDate = apt1.getAppointmentDate();
            Vaccine vaccine = Vaccine.generateVaccine(apt1.getVaccineBrand());
            LocalDate apt2Date = vaccinationDate.plusWeeks(vaccine.getWaitTime());
            LocalDate appointmentDate = (appointment.getAppointmentDate() == null) ? LocalDate.now() : appointment.getAppointmentDate();
            if (appointmentDate.isBefore(apt2Date)) {
                removalList.add(c);
                continue;
            }

            //2nd appointment, should be in same vaccination centre
            if (!appointment.getCentreId().equals(apt1.getCentreId())) {
                removalList.add(c);
                continue;
            }

            //2nd appointment, should be of same vaccine brand
            if (!appointment.getVaccineBrand().equals(apt1.getVaccineBrand())) {
                removalList.add(c);
                continue;
            }
        }

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
                temp = aptObj.getStatus();
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

    public AppointmentCandidate_TableModel(Appointment apt) {
        candidateList = apt.getCandidateList();
        tableType = "Appointment";
    }

    @Override
    public int getRowCount() {

        if (tableType.equals("Appointment")) {
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
        if (tableType.equals("Potential")) {
            People obj = potentialCandidateList.get(rowIndex);

            switch (colIndex) {

                case 0 -> //User Id
                    temp = obj.getUserId();
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
                    temp = obj.findCandidate().getUserId();
                case 1 -> //Name
                    temp = obj.findCandidate().getName();
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
