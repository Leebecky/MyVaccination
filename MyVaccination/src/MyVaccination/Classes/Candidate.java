/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

import java.util.List;

/**
 *
 * @author leebe
 */
public class Candidate {

//    private People candidate;
    private String candidateId;
    private String apptStatus;
    private String vaccineBatchNumber;

//    Constructor
    public Candidate(String candidateId, String vaccineBatchNumber) {
        this.candidateId = candidateId;
        this.vaccineBatchNumber = vaccineBatchNumber;
        apptStatus = "Pending";
    }
    
    public Candidate(String candidateId) {
        this.candidateId = candidateId;
    }
    
//    public Candidate(String userId) {
//        //retrieve people by user id
//        List<People> peopleList = People.getFolderData();
//        peopleList.forEach(p -> {
//            if (p.getId().equals(userId)) {
//                candidate = p;
//            }
//        });
//                
//        apptStatus = "Pending";
//    }
    //Getter

    public People findCandidate() {
        People candidate = null;

        //retrieve people by user id
        List<People> peopleList = People.getFolderData();

        for (People p : peopleList) {
            if (p.getUserId().equals(candidateId)) {
                candidate = p;
            }
        }

        return candidate;
    }

    public void updateCandidateStatus(String candidateStatus, String apptStatus, String aptId, String updateType) {
        People myCandidate = this.findCandidate();
        if (myCandidate != null) {
            myCandidate.setStatus(candidateStatus);
            
            myCandidate.updateVaccinationHistory(aptId, updateType);
            
            User.saveUser(myCandidate);
            this.apptStatus = apptStatus;
        }

    }
    public String getCandidateId() {
        return candidateId;
    }

    public String getApptStatus() {
        return apptStatus;
    }

    public String getVaccineBatchNumber() {
        return vaccineBatchNumber;
    }

    public void setVaccineBatchNumber(String vaccineBatchNumber) {
        this.vaccineBatchNumber = vaccineBatchNumber;
    }
    
    public void setApptStatus(String status){
        this.apptStatus = status;
    }
}
