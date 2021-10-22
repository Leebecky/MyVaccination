/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

import MyVaccination.Helper_Classes.File_Methods;
import java.time.LocalDate;

/**
 *
 * @author leebe
 */
public class Appointment implements File_Methods{

    private String appointmentId;
    private String centreId;
    private String userId;
    private String vaccineBatchNumber;
    public LocalDate appointmentDate;
    public LocalDate appointmentTime;
    public String status;

    //Some placeholder functions
    public void registerAppointment() {
    }

    public void updateAppointment() {
    }

    public Appointment getAppointment() {
        return new Appointment();
    }

    @Override
    public String setFileName() {
        return appointmentId;
    }

    @Override
    public String getFileName() {
       return "Appointment/" + appointmentId + ".txt";
    }

}
