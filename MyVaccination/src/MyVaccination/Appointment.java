/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination;

import java.time.LocalDate;

/**
 *
 * @author leebe
 */
public class Appointment {

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

}
