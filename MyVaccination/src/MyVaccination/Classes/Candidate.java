/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

/**
 *
 * @author leebe
 */
public class Candidate {
    private People candidate;
    private String apptStatus;
    
    //Constructor
    public Candidate(String userId){
        //retrieve people by user id
        candidate = new People();
        apptStatus = "Pending";
        
    }
    
    //Getter
    public People getCandidate(){
        return candidate;
    }
    
    public String getApptStatus() {
        return apptStatus;
    }
}
