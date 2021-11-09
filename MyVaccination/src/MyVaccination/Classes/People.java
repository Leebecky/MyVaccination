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

    }

    public People(String n, LocalDate dob, String id, String nat, String v, String a, String g) {
        this.name = n;
        this.dateOfBirth = dob;
        this.identification = id;
        this.nationality = nat;
        this.vaccinationStatus = v;
        this.address = a;
        this.gender = g;
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

    // Retrieve all records of People
    public static List<People> getuserFolderData() {
        List<String> userFolderData = File_Helper.readFolder("User_Account");
        List<People> userList = new ArrayList<>();
        if (userFolderData != null) {

            userFolderData.forEach(fileData -> {
                userList.add(File_Helper.gsonWriter.fromJson(fileData, People.class));
            }
            );
        }

        List<People> peopleList = new ArrayList<>();
        for (People user : userList) {
            String userType = user.getUserType();

            if (user.getId() != null && !userType.equals("Personnel")) {
                peopleList.add(user);
            }
        }

        return peopleList;
    }
}

