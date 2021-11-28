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
public class AstraZeneca extends Vaccine {

    public AstraZeneca() {
        this.manufacturer = "Oxford AstraZeneca";
        this.name = "AstraZeneca";
        this.waitTime = 12;
        this.amount = 50;
        this.dosage = 5;
        this.batchNumber = "AZ_" + UUID.randomUUID().toString();
        this.dosesRequired = 2;
    }

    public AstraZeneca(String batchNumber) {
        this.manufacturer = "Oxford AstraZeneca";
        this.name = "AstraZeneca";
        this.waitTime = 12;
        this.amount = 50;
        this.dosage = 5;
        this.batchNumber = batchNumber;
        this.dosesRequired = 2;
    }
}
