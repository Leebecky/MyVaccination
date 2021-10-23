/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

public class Stock {

    private Vaccine vaccine;
    private int quantity;

    public Stock(Vaccine vac) {
        vaccine = vac;
        quantity = vac.getAmount() * vac.getDosage();

    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    //end Stock class
}
