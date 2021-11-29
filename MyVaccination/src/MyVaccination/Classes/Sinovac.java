/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

import java.util.UUID;

/**
 *
 * @author leebe
 */
public class Sinovac extends Vaccine {

    public Sinovac() {
        this.manufacturer = "Sinovac-CoronaVac";
        this.name = "Sinovac";
        this.waitTime = 4;
        this.amount = 100;
        this.dosage = 2;
        this.batchNumber = "SV_" + UUID.randomUUID().toString();
        this.dosesRequired = 2;
    }

    public Sinovac(String batchNumber) {
        this.manufacturer = "Sinovac-CoronaVac";
        this.name = "Sinovac";
        this.waitTime = 4;
        this.amount = 100;
        this.dosage = 2;
        this.batchNumber = batchNumber;
        this.dosesRequired = 2;
    }
}
