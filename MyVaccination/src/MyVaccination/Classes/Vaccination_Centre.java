/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

import MyVaccination.Helper_Classes.File_Methods;
import java.time.*;
import java.util.List;
import java.util.Map;

/**
 *
 * @author leebe
 */
public class Vaccination_Centre implements File_Methods {

    public String centreId;
    public String name;
    public Location location;
    public List<String> servicesId;
    private List<Stock> stock;
    private int openingTime = 9;
    private int closingTime = 18;
    public String status;

//Some placeholder functions
    public void registerCentre() {
    }

    public void updateCentre() {
    }

    public void getCentre() {
    }

    public void setStock(List<Stock> item) {
        stock = item;
    }
    
    public List<Stock> getStock(){
        return stock;
    }
    
    public int getOpeningTime() {
        return openingTime;
    }

    //Interface implementation
    @Override
    public String setFileName() {
        return centreId;
    }

    @Override
    public String getFileName() {
        return "Vaccination_Centre/" + centreId + ".txt";
    }

}
