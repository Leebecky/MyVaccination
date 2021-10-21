/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination;

import java.util.UUID;

/**
 *
 * @author leebe
 */
public class Pfizer extends Vaccine {

    public Pfizer() {
        this.manufacturer = "Pfizer";
        this.name = "Pfizer";
        this.waitTime = 3;
        this.amount = 50;
        this.dosage = 5;
        this.batchNumber = "PF_" + UUID.randomUUID().toString();
        this.dosesRequired = 2;
    }

}
