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
public class Vaccine_Sinovac extends Vaccine {

    public Vaccine_Sinovac() {
        this.manufacturer = "Sinovac";
        this.name = "Sinovac-CoronaVac";
        this.waitTime = 4;
        this.amount = 100;
        this.dosage = 2;
        this.batchNumber = "SV_" + UUID.randomUUID().toString();
        this.dosesRequired = 2;
    }

}
