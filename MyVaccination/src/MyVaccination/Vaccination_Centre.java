/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination;

import java.time.*;
import java.util.List;
import java.util.Map;

/**
 *
 * @author leebe
 */
public class Vaccination_Centre {

    public String centreId;
    public String name;
    public Location location;
    public List<String> servicesId;
    private Map<Vaccine, Integer> stock;
    private LocalDate openingTime;
    private LocalDate closingTime;
    public String status;
    
//Some placeholder functions
    public void registerCentre() {}
    public void updateCentre() {}
    public void getCentre() {}
    
}
