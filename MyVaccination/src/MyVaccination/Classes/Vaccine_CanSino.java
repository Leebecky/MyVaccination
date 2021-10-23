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
public class Vaccine_CanSino extends Vaccine {

    public Vaccine_CanSino() {
        this.manufacturer = "CanSino Biologics";
        this.name = "CanSino";
        this.waitTime = 0;
        this.amount = 60;
        this.dosage = 3;
        this.batchNumber = "CS_" + UUID.randomUUID().toString();
        this.dosesRequired = 1;
    }

    
}
