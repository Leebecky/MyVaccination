/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

import MyVaccination.Helper_Classes.File_Methods;

public class Vaccine implements File_Methods{

    protected String name;
    protected String manufacturer;
    protected String batchNumber;
    protected int dosage; // number of doses per vaccine bottle
    protected int amount; // number of bottles 
    protected int dosesRequired; // number of shots required for full immunisation
    protected int waitTime; //in weeks

    public String getBatchNumber() {
        return batchNumber;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getDosage() {
        return dosage;
    }

    public int getDosesRequired() {
        return dosesRequired;
    }

    //End of class

    @Override
    public String setFileName() {
        return batchNumber;
    }

    @Override
    public String getFileName() {
        return "Vaccine/" + batchNumber + ".txt";
    }
}
