/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

import java.time.*;

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
   
    People(String n, LocalDate dob, String id, String nat, String v, String a, String g){
        this.name = n;
        this.dateOfBirth = dob;
        this.identification = id;
        this.nationality = nat;
        this.vaccinationStatus = v;
        this.address = a;
        this.gender = g;
    }
    
    public String getName(){
        return this.name;
    }
    
    public LocalDate getDob(){
        return this.dateOfBirth;
    }
    
    public String getId(){
        return this.identification;
    }
    
    public String getNation(){
        return this.nationality;
    }
    
    public String getStatus(){
        return this.vaccinationStatus;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public String getGender(){
        return this.gender;
    }
}
