/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

import java.time.LocalDate;

public class Stock {

    private Vaccine vaccine;
    private int quantity;
    private LocalDate supplyDate;
    private String status;

    public Stock(Vaccine vac) {
        vaccine = vac;
        quantity = vac.getAmount() * vac.getDosage();
        supplyDate = LocalDate.now();
        status = "Active";
    }
    
    //Getters
    public Vaccine getVaccine() {
        return vaccine;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
      public LocalDate getSupplyDate() {
        return supplyDate;
    }
      public String getSupplyStatus() {
        return status;
    }
      
     //Setters
      public void updateQuantity(int amount) {
          quantity = quantity + amount;
      }
      
      public void setSupplyStatus(String status) {
          this.status = status;
      }

    //end Stock class
}
