/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author leebe
 */
public class Vaccine {

    protected String name;
    protected String manufacturer;
    protected String batchNumber;
    protected int dosage;
    protected int amount;
    protected int dosesRequired;
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
}
