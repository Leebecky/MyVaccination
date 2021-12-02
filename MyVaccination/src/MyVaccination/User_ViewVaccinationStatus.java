/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination;

import MyVaccination.Classes.*;
import MyVaccination.Helper_Classes.File_Helper;
import MyVaccination.Helper_Classes.Printer;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class User_ViewVaccinationStatus extends javax.swing.JFrame {

    /**
     * Creates new form User_ViewVaccinationStatus
     */
    public User_ViewVaccinationStatus() {
        initComponents();
        ImageIcon img = new ImageIcon("src/MyVaccination/Images/Logo_Background1024.jpg");
        this.setIconImage(img.getImage());
    }
    
    public User_ViewVaccinationStatus(String id) {
        initComponents();
        ImageIcon img = new ImageIcon("src/MyVaccination/Images/Logo_Background1024.jpg");
        this.setIconImage(img.getImage());
        
        String userData = File_Helper.readFile("User_Account/" + id + ".txt");
        People userFromFile = File_Helper.gsonWriter.fromJson(userData, People.class);
        List<String> vacHistory;
        String apt1, apt2, apt1Data, apt2Data;
        Appointment apt1FromFile = new Appointment();
        Appointment apt2FromFile = new Appointment();
        String centreName1 = "";
        String aptTime1 = "";
        String aptDate1 = "";
        LocalDate aptLocalDate1 = LocalDate.now();;
        LocalDate aptLocalDate2 = LocalDate.now();;
        String centreName2 = "";
        String aptTime2 = "";
        String aptDate2 = "";
        int doseRequired = 0;
        
        if(userFromFile.getVacHistory().size() > 0){
            vacHistory = userFromFile.getVacHistory();
            apt1 = userFromFile.getVacHistory().get(0);
            
            apt1Data = File_Helper.readFile("Appointment/" + apt1 + ".txt");
            apt1FromFile = File_Helper.gsonWriter.fromJson(apt1Data, Appointment.class);
            String centreData1 = File_Helper.readFile("Vaccination_Centre/" + apt1FromFile.getCentreId() + ".txt");
            Vaccination_Centre centreFromFile1 = File_Helper.gsonWriter.fromJson(centreData1, Vaccination_Centre.class);
            List<Candidate> candidateList = apt1FromFile.getCandidateList();
            String batchNumber = "";

            for(Candidate candidate: candidateList){
                if(candidate.getCandidateId().equals(id)){
                    batchNumber = candidate.getVaccineBatchNumber();
                }
            }
            
            Vaccine aptVaccine = new Vaccine();
            aptVaccine = aptVaccine.getVaccine(batchNumber);
            doseRequired = aptVaccine.getDosesRequired();
            
            centreName1 = centreFromFile1.getName();
            aptTime1 = apt1FromFile.getAppointmentTime().toString();
            aptDate1 = apt1FromFile.getAppointmentDate().toString();
            aptLocalDate1 = apt1FromFile.getAppointmentDate();
            
            if(vacHistory.size() == 2){
                apt2 = userFromFile.getVacHistory().get(1);
                
                apt2Data = File_Helper.readFile("Appointment/" + apt2 + ".txt");
                apt2FromFile = File_Helper.gsonWriter.fromJson(apt2Data, Appointment.class);
                
                String centreData2 = File_Helper.readFile("Vaccination_Centre/" + apt2FromFile.getCentreId() + ".txt");
                Vaccination_Centre centreFromFile2 = File_Helper.gsonWriter.fromJson(centreData2, Vaccination_Centre.class);

                centreName2 = centreFromFile2.getName();
                aptTime2 = apt2FromFile.getAppointmentTime().toString();
                aptDate2 = apt2FromFile.getAppointmentDate().toString();
                aptLocalDate2 = apt2FromFile.getAppointmentDate();
            }
        }
        
        lblUsername.setText(userFromFile.getName());
        lblId.setText(id);
        lblId.setVisible(false);
        lblViewProfile.setVisible(false);
        lblLogout.setVisible(false);
        
        if(userFromFile.getStatus().equals("Not Vaccinated")){
            lblAppointDesc.setText("No appointment submitted.");
            lblViewDose1.setText("");
            lblViewDose2.setText("");
            btnPrint.setText("");
            btnCompleteDose1.setVisible(false);
            btnCancelDose1.setVisible(false);
            btnCompleteDose2.setVisible(false);
            btnCancelDose2.setVisible(false);
            
            jPanel3.setBackground(new Color(153,204,255));
            jPanel2.setBackground(new Color(240,240,240));
            jPanel4.setBackground(new Color(240,240,240));
            jPanel5.setBackground(new Color(240,240,240));
        }else if(userFromFile.getStatus().equals("1st Dose Appointment Pending")){
            lblAppointDesc.setText("Appointment submitted.");
            btnSubmitApp.setVisible(false);
            btnCompleteDose1.setText("Confirm");
            lblViewDose2.setText("");
            btnCancelDose2.setVisible(false);
            btnCompleteDose2.setVisible(false);
            btnPrint.setText("");
            lblViewDose1.setText("View Appointment");
            
            jPanel3.setBackground(new Color(78,210,177));
            jPanel2.setBackground(new Color(153,204,255));
            jPanel4.setBackground(new Color(240,240,240));
            jPanel5.setBackground(new Color(240,240,240));
        }else if(userFromFile.getStatus().equals("1st Dose Appointment Confirmed")){
            lblAppointDesc.setText("Appointment submitted.");
            btnSubmitApp.setVisible(false);
            btnCompleteDose1.setText("Complete");
            
            if(LocalDate.now().isBefore(aptLocalDate1)){
                btnCompleteDose1.setEnabled(false);
            }
            
            lblViewDose2.setText("");
            btnCancelDose2.setVisible(false);
            btnCompleteDose2.setVisible(false);
            btnPrint.setText("");
            lblViewDose1.setText("View Appointment");
            
            jPanel3.setBackground(new Color(78,210,177));
            jPanel2.setBackground(new Color(153,204,255));
            jPanel4.setBackground(new Color(240,240,240));
            jPanel5.setBackground(new Color(240,240,240));
            
        }else if(userFromFile.getStatus().equals("1st Dose Completed")){
            lblAppointDesc.setText("Appointment submitted.");
            btnSubmitApp.setVisible(false);
            btnCompleteDose1.setVisible(false);
            btnCancelDose1.setVisible(false);
            lblViewDose1.setText("View Appointment");
            lblViewDose2.setText("No appointment submitted.");
            btnCompleteDose2.setText("Submit");
            btnCancelDose2.setVisible(false);
            btnPrint.setText("");
            
            jPanel3.setBackground(new Color(78,210,177));
            jPanel2.setBackground(new Color(78,210,177));
            jPanel4.setBackground(new Color(153,204,255));
            jPanel5.setBackground(new Color(240,240,240));
        }else if(userFromFile.getStatus().equals("2nd Dose Appointment Pending")){
            lblAppointDesc.setText("Appointment submitted.");
            btnSubmitApp.setVisible(false);
            btnCompleteDose1.setVisible(false);
            btnCancelDose1.setVisible(false);
            btnCompleteDose2.setText("Confirm");
            btnPrint.setText("");
            lblViewDose1.setText("View Appointment");
            lblViewDose2.setText("View Appointment");
            
            jPanel3.setBackground(new Color(78,210,177));
            jPanel2.setBackground(new Color(78,210,177));
            jPanel4.setBackground(new Color(153,204,255));
            jPanel5.setBackground(new Color(240,240,240));
        }else if(userFromFile.getStatus().equals("2nd Dose Appointment Confirmed")){
            lblAppointDesc.setText("Appointment submitted.");
            btnSubmitApp.setVisible(false);
            btnCompleteDose1.setVisible(false);
            btnCancelDose1.setVisible(false);
            
            if(LocalDate.now().isBefore(aptLocalDate2)){
                btnCompleteDose2.setEnabled(false);
            }
            
            btnPrint.setText("");
            lblViewDose1.setText("View Appointment");
            lblViewDose2.setText("View Appointment");
            
            jPanel3.setBackground(new Color(78,210,177));
            jPanel2.setBackground(new Color(78,210,177));
            jPanel4.setBackground(new Color(153,204,255));
            jPanel5.setBackground(new Color(240,240,240));
        }else{
            lblAppointDesc.setText("Appointment submitted.");
            btnSubmitApp.setVisible(false);
            btnCompleteDose1.setVisible(false);
            btnCancelDose1.setVisible(false);
            btnCancelDose2.setVisible(false);
            btnCompleteDose2.setVisible(false);
            lblViewDose1.setText("View Appointment");
            
            if(doseRequired == 1){
                lblViewDose2.setText("Second dose is not required");
            }else{
                lblViewDose2.setText("View Appointment");
            }
            
            jPanel3.setBackground(new Color(78,210,177));
            jPanel2.setBackground(new Color(78,210,177));
            jPanel4.setBackground(new Color(78,210,177));
            jPanel5.setBackground(new Color(153,204,255));
            
        }
        
        if(lblViewDose1.getText().equals("View Appointment")){
            lblViewDose1.setForeground(new Color(0,153,255));
        }

        if(lblViewDose2.getText().equals("View Appointment")){
            lblViewDose2.setForeground(new Color(0,153,255));
        }

        btnPrint.setForeground(new Color(0,153,255));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblDose1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblDate1 = new javax.swing.JLabel();
        lblCentre1 = new javax.swing.JLabel();
        lblBatch1 = new javax.swing.JLabel();
        lblManufacturer1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblDose2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblDate2 = new javax.swing.JLabel();
        lblCentre2 = new javax.swing.JLabel();
        lblBatch2 = new javax.swing.JLabel();
        lblManufacturer2 = new javax.swing.JLabel();
        userHeader2 = new javax.swing.JPanel();
        lblLogo2 = new javax.swing.JLabel();
        userHeader = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        lblViewProfile = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnPrint = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnCompleteDose2 = new javax.swing.JButton();
        lblViewDose2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnCancelDose2 = new javax.swing.JButton();
        lblViewDose1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCancelDose1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnCompleteDose1 = new javax.swing.JButton();
        btnSubmitApp = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblAppointDesc = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();

        jFrame1.setTitle("MyVaccination");
        jFrame1.setLocation(new java.awt.Point(0, 0));
        jFrame1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                jFrame1WindowOpened(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(204, 153, 255));

        jLabel4.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("digital certificate");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("For Covid-19 Vaccination");

        lblName.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("NAME");

        jPanel7.setBackground(new java.awt.Color(213, 177, 248));

        lblDose1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblDose1.setText("Dose 1:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Centre:");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("Date:");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel11.setText("Manufacturer:");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel12.setText("Batch:");

        lblDate1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblDate1.setText("2020-01-01");

        lblCentre1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblCentre1.setText("ABC Hospital");

        lblBatch1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblBatch1.setText("AZ_0123");

        lblManufacturer1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblManufacturer1.setText("AstraZeneca");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDose1)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCentre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblManufacturer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBatch1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDose1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblDate1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblCentre1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblBatch1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblManufacturer1))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(213, 177, 248));

        lblDose2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblDose2.setText("Dose 2:");

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel14.setText("Centre:");

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel15.setText("Date:");

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel16.setText("Manufacturer:");

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel17.setText("Batch:");

        lblDate2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblDate2.setText("2020-01-01");

        lblCentre2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblCentre2.setText("ABC Hospital");

        lblBatch2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblBatch2.setText("AZ_0123");

        lblManufacturer2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblManufacturer2.setText("AstraZeneca");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDose2)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCentre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBatch2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblManufacturer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDose2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblDate2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblCentre2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblBatch2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblManufacturer2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        userHeader2.setBackground(new java.awt.Color(204, 153, 255));

        lblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Logo_200.png"))); // NOI18N
        lblLogo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogo2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblLogo2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout userHeader2Layout = new javax.swing.GroupLayout(userHeader2);
        userHeader2.setLayout(userHeader2Layout);
        userHeader2Layout.setHorizontalGroup(
            userHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userHeader2Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(lblLogo2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userHeader2Layout.setVerticalGroup(
            userHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addComponent(userHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(52, 52, 52))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyVaccination");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userHeader.setBackground(new java.awt.Color(204, 153, 255));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Logo_200.png"))); // NOI18N
        lblLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblLogoMousePressed(evt);
            }
        });

        lblUsername.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        lblUsername.setText("User Name");
        lblUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblUsernameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblUsernameMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblUsernameMousePressed(evt);
            }
        });

        javax.swing.GroupLayout userHeaderLayout = new javax.swing.GroupLayout(userHeader);
        userHeader.setLayout(userHeaderLayout);
        userHeaderLayout.setHorizontalGroup(
            userHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userHeaderLayout.createSequentialGroup()
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 569, Short.MAX_VALUE)
                .addComponent(lblUsername)
                .addGap(21, 21, 21))
        );
        userHeaderLayout.setVerticalGroup(
            userHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(userHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, -1));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VACCINATION STATUS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 540, -1));

        lblLogout.setBackground(new java.awt.Color(204, 153, 255));
        lblLogout.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        lblLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogout.setText("Log Out");
        lblLogout.setToolTipText("");
        lblLogout.setOpaque(true);
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoutMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblLogoutMousePressed(evt);
            }
        });
        getContentPane().add(lblLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, 150, 40));

        lblViewProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblViewProfile.setText("View Profile");
        lblViewProfile.setBackground(new java.awt.Color(204, 153, 255));
        lblViewProfile.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        lblViewProfile.setOpaque(true);
        lblViewProfile.setToolTipText("");
        lblViewProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblViewProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblViewProfileMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblViewProfileMousePressed(evt);
            }
        });
        getContentPane().add(lblViewProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 66, 150, 40));

        lblId.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblId.setForeground(new java.awt.Color(240, 240, 240));
        lblId.setText("userIc");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 440, 80, 40));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 153, 255), 2, true));

        btnPrint.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnPrint.setText("Print Certificate");
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrintMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrintMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 87, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setText("Digital Certificate Issued");

        btnCompleteDose2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCompleteDose2.setText("Complete");
        btnCompleteDose2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteDose2ActionPerformed(evt);
            }
        });

        lblViewDose2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblViewDose2.setText("View Appointment");
        lblViewDose2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewDose2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblViewDose2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblViewDose2MouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel8.setText("2nd Dose Appointment");

        btnCancelDose2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCancelDose2.setText("Cancel");
        btnCancelDose2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelDose2ActionPerformed(evt);
            }
        });

        lblViewDose1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblViewDose1.setText("View Appointment");
        lblViewDose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewDose1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblViewDose1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblViewDose1MouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText("1st Dose Appointment");

        btnCancelDose1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCancelDose1.setText("Cancel");
        btnCancelDose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelDose1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 87, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        btnCompleteDose1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCompleteDose1.setText("Complete");
        btnCompleteDose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteDose1ActionPerformed(evt);
            }
        });

        btnSubmitApp.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnSubmitApp.setText("Submit");
        btnSubmitApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitAppActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(78, 210, 177));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 87, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        lblAppointDesc.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblAppointDesc.setText("No appointment submitted.");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel9.setText("Vaccination Appointment");

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 87, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(lblAppointDesc))
                        .addGap(308, 308, 308))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblViewDose2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCompleteDose2)
                                    .addGap(27, 27, 27)
                                    .addComponent(btnCancelDose2))
                                .addComponent(jLabel8)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(btnPrint))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(lblViewDose1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSubmitApp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCompleteDose1))
                            .addGap(27, 27, 27)
                            .addComponent(btnCancelDose1))))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSubmitApp)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(1, 1, 1)
                        .addComponent(lblAppointDesc)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblViewDose1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCompleteDose1)
                                .addComponent(btnCancelDose1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCompleteDose2)
                                .addComponent(btnCancelDose2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblViewDose2)
                                .addGap(9, 9, 9))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrint)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 660, 290));

        btnBack.setBackground(new java.awt.Color(204, 153, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Back.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setFocusPainted(false);
        btnBack.setFocusable(false);
        btnBack.setRequestFocusEnabled(false);
        btnBack.setRolloverEnabled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 28));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblLogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoMouseEntered
        lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblLogoMouseEntered

    private void lblLogoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoMousePressed
        String id = lblId.getText();

        User_Home userHome = new User_Home(id);
        userHome.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblLogoMousePressed

    private void lblUsernameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsernameMouseEntered
        lblUsername.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Font font = lblUsername.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblUsername.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblUsernameMouseEntered

    private void lblUsernameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsernameMouseExited
        Font font = lblUsername.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        lblUsername.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblUsernameMouseExited

    private void lblUsernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsernameMousePressed
        if(lblLogout.isVisible()){
            lblViewProfile.setVisible(false);
            lblLogout.setVisible(false);
        }
        else{
            lblViewProfile.setVisible(true);
            lblLogout.setVisible(true);
        }
    }//GEN-LAST:event_lblUsernameMousePressed

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
        lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Font font = lblLogout.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblLogout.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblLogoutMouseEntered

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited
        Font font = lblLogout.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        lblLogout.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblLogoutMouseExited

    private void lblLogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMousePressed
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblLogoutMousePressed

    private void lblViewProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewProfileMouseEntered
        lblViewProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Font font = lblViewProfile.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblViewProfile.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblViewProfileMouseEntered

    private void lblViewProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewProfileMouseExited
        Font font = lblViewProfile.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        lblViewProfile.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblViewProfileMouseExited

    private void lblViewProfileMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewProfileMousePressed
        String id = lblId.getText();

        User_ViewProfile viewProfile = new User_ViewProfile(id);
        viewProfile.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblViewProfileMousePressed

    private void btnSubmitAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitAppActionPerformed
        String id = lblId.getText();

        User_SubmitAppointment submitAppointment = new User_SubmitAppointment(id);
        submitAppointment.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSubmitAppActionPerformed

    private void btnCancelDose2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelDose2ActionPerformed
        int decision = JOptionPane.showConfirmDialog(this, "Do you want to cancel this appointment?" , "Appointment", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (decision == JOptionPane.YES_OPTION) {
            String id = lblId.getText();
            String userData = File_Helper.readFile("User_Account/" + id + ".txt");
            People userFromFile = File_Helper.gsonWriter.fromJson(userData, People.class);
            String aptId = userFromFile.getVacHistory().get(1);
            String aptData = File_Helper.readFile("Appointment/" + aptId + ".txt");
            Appointment aptFromFile = File_Helper.gsonWriter.fromJson(aptData, Appointment.class);
            String centreData = File_Helper.readFile("Vaccination_Centre/" + aptFromFile.getCentreId() + ".txt");
            Vaccination_Centre centreFromFile = File_Helper.gsonWriter.fromJson(centreData, Vaccination_Centre.class);
            List<Candidate> candidateList = aptFromFile.getCandidateList();
            String batchNumber = "";

            for(Candidate candidate: candidateList){
                if(candidate.getCandidateId().equals(id)){
                    batchNumber = candidate.getVaccineBatchNumber();
                }
            }

            Candidate aptCandidate = new Candidate(id, "");
            boolean success;

            success = aptFromFile.updateAptStatus(aptCandidate, "Rejected");
            centreFromFile.refundStock(batchNumber);

            if(success){
                userFromFile.setStatus("1st Dose Completed");
                userFromFile.updateVaccinationHistory(aptId, "Remove");
                success = File_Helper.saveData(userFromFile, "User_Account");
            }

            if(!success){
                JOptionPane.showMessageDialog(null, "Appointment update failed.", "Appointment Message", JOptionPane.ERROR_MESSAGE);
            }

            User_ViewVaccinationStatus viewStatus = new User_ViewVaccinationStatus(id);
            viewStatus.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnCancelDose2ActionPerformed

    private void btnCompleteDose2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteDose2ActionPerformed
        String id = lblId.getText();
        String userData = File_Helper.readFile("User_Account/" + id + ".txt");
        People userFromFile = File_Helper.gsonWriter.fromJson(userData, People.class);

        if(btnCompleteDose2.getText().equals("Submit")){
            User_SubmitAppointment submitAppointment = new User_SubmitAppointment(id);
            submitAppointment.setVisible(true);
            this.setVisible(false);
        }else if(btnCompleteDose2.getText().equals("Confirm")){
            String aptId = userFromFile.getVacHistory().get(1);
            String aptData = File_Helper.readFile("Appointment/" + aptId + ".txt");
            Appointment aptFromFile = File_Helper.gsonWriter.fromJson(aptData, Appointment.class);
            Candidate aptCandidate = new Candidate(id, "");
            boolean success;
        
            success = aptFromFile.updateAptStatus(aptCandidate, "Confirmed");

            if(success){
                userFromFile.setStatus("2nd Dose Appointment Confirmed");
                success = File_Helper.saveData(userFromFile, "User_Account");
            }

            if(!success){
                JOptionPane.showMessageDialog(null, "Appointment update failed.", "Appointment Message", JOptionPane.ERROR_MESSAGE);
            }

            User_ViewVaccinationStatus viewStatus = new User_ViewVaccinationStatus(id);
            viewStatus.setVisible(true);
            this.setVisible(false);
        }else{
            String aptId = userFromFile.getVacHistory().get(1);
            String aptData = File_Helper.readFile("Appointment/" + aptId + ".txt");
            Appointment aptFromFile = File_Helper.gsonWriter.fromJson(aptData, Appointment.class);
            Candidate aptCandidate = new Candidate(id, "");
            boolean success;
            
            success = aptFromFile.updateAptStatus(aptCandidate, "Completed");

            if(success){
                userFromFile.setStatus("Fully Vaccinated");
                success = File_Helper.saveData(userFromFile, "User_Account");
            }
            
            if(!success){
                JOptionPane.showMessageDialog(null, "Appointment update failed.", "Appointment Message", JOptionPane.ERROR_MESSAGE);
            }

            User_ViewVaccinationStatus viewStatus = new User_ViewVaccinationStatus(id);
            viewStatus.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnCompleteDose2ActionPerformed

    private void btnCancelDose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelDose1ActionPerformed
        int decision = JOptionPane.showConfirmDialog(this, "Do you want to cancel this appointment?" , "Appointment", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (decision == JOptionPane.YES_OPTION) {
            String id = lblId.getText();
            String userData = File_Helper.readFile("User_Account/" + id + ".txt");
            People userFromFile = File_Helper.gsonWriter.fromJson(userData, People.class);
            String aptId = userFromFile.getVacHistory().get(0);
            String aptData = File_Helper.readFile("Appointment/" + aptId + ".txt");
            Appointment aptFromFile = File_Helper.gsonWriter.fromJson(aptData, Appointment.class);
            String centreData = File_Helper.readFile("Vaccination_Centre/" + aptFromFile.getCentreId() + ".txt");
            Vaccination_Centre centreFromFile = File_Helper.gsonWriter.fromJson(centreData, Vaccination_Centre.class);
            List<Candidate> candidateList = aptFromFile.getCandidateList();
            String batchNumber = "";

            for(Candidate candidate: candidateList){
                if(candidate.getCandidateId().equals(id)){
                    batchNumber = candidate.getVaccineBatchNumber();
                }
            }

            Candidate aptCandidate = new Candidate(id, "");
            System.out.println(batchNumber);
            boolean success;

            success = aptFromFile.updateAptStatus(aptCandidate, "Rejected");
            centreFromFile.refundStock(batchNumber);

            if(success){
                userFromFile.setStatus("Not Vaccinated");
                userFromFile.updateVaccinationHistory(aptId, "Remove");
                success = File_Helper.saveData(userFromFile, "User_Account");
            }

            if(!success){
                JOptionPane.showMessageDialog(null, "Appointment update failed.", "Appointment Message", JOptionPane.ERROR_MESSAGE);
            }

            User_ViewVaccinationStatus viewStatus = new User_ViewVaccinationStatus(id);
            viewStatus.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnCancelDose1ActionPerformed

    private void btnCompleteDose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteDose1ActionPerformed
        String id = lblId.getText();
        String userData = File_Helper.readFile("User_Account/" + id + ".txt");
        People userFromFile = File_Helper.gsonWriter.fromJson(userData, People.class);
        String aptId = userFromFile.getVacHistory().get(0);
        String aptData = File_Helper.readFile("Appointment/" + aptId + ".txt");
        Appointment aptFromFile = File_Helper.gsonWriter.fromJson(aptData, Appointment.class);
        Candidate aptCandidate = new Candidate(id, "");
        boolean success;

        if(btnCompleteDose1.getText().equals("Confirm")){
            success = aptFromFile.updateAptStatus(aptCandidate, "Confirmed");

            if(success){
                userFromFile.setStatus("1st Dose Appointment Confirmed");
                success = File_Helper.saveData(userFromFile, "User_Account");
            }
        }else{
            String centreData = File_Helper.readFile("Vaccination_Centre/" + aptFromFile.getCentreId() + ".txt");
            Vaccination_Centre centreFromFile = File_Helper.gsonWriter.fromJson(centreData, Vaccination_Centre.class);
            List<Candidate> candidateList = aptFromFile.getCandidateList();
            String batchNumber = "";

            for(Candidate candidate: candidateList){
                if(candidate.getCandidateId().equals(id)){
                    batchNumber = candidate.getVaccineBatchNumber();
                }
            }
            
            Vaccine aptVaccine = new Vaccine();
            aptVaccine = aptVaccine.getVaccine(batchNumber);
            int doseRequired = aptVaccine.getDosesRequired();
            
            success = aptFromFile.updateAptStatus(aptCandidate, "Completed");

            if(success){
                
                if(doseRequired == 1){
                    userFromFile.setStatus("Fully Vaccinated");
                }else{
                    userFromFile.setStatus("1st Dose Completed");
                }
                success = File_Helper.saveData(userFromFile, "User_Account");
            }
        }

        if(!success){
            JOptionPane.showMessageDialog(null, "Appointment update failed.", "Appointment Message", JOptionPane.ERROR_MESSAGE);
        }

        User_ViewVaccinationStatus viewStatus = new User_ViewVaccinationStatus(id);
        viewStatus.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCompleteDose1ActionPerformed

    private void lblViewDose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewDose1MouseClicked
        if(lblViewDose1.getText().equals("View Appointment")){
            String id = lblId.getText();

            if(!id.equals("userIc")){
                User_AppointmentDetails aptDetails = new User_AppointmentDetails(id, "1");
                aptDetails.setVisible(true);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_lblViewDose1MouseClicked

    private void lblViewDose2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewDose2MouseClicked
        if(lblViewDose2.getText().equals("View Appointment")){
            String id = lblId.getText();

            if(!id.equals("userIc")){
                User_AppointmentDetails aptDetails = new User_AppointmentDetails(id, "2");
                aptDetails.setVisible(true);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_lblViewDose2MouseClicked

    private void btnPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseClicked
        String id = lblId.getText();
        
        if(!id.equals("userIc")){
            jFrame1.setLocation(550, 200);
            jFrame1.setSize(525, 560);
            jFrame1.setVisible(true);
            
            String userData = File_Helper.readFile("User_Account/" + id + ".txt");
            People userFromFile = File_Helper.gsonWriter.fromJson(userData, People.class);
            String name = userFromFile.getName();
            lblName.setText(name);
            
            String apt1 = userFromFile.getVacHistory().get(0);
            String aptData1 = File_Helper.readFile("Appointment/" + apt1 + ".txt");
            Appointment aptFromFile1 = File_Helper.gsonWriter.fromJson(aptData1, Appointment.class);
            String centreData1 = File_Helper.readFile("Vaccination_Centre/" + aptFromFile1.getCentreId() + ".txt");
            Vaccination_Centre centreFromFile1 = File_Helper.gsonWriter.fromJson(centreData1, Vaccination_Centre.class);
            List<Candidate> candidateList1 = aptFromFile1.getCandidateList();
            String batchNumber1 = "";

            for(Candidate candidate: candidateList1){
                if(candidate.getCandidateId().equals(id)){
                    batchNumber1 = candidate.getVaccineBatchNumber();
                }
            }
            
            Vaccine aptVaccine1 = new Vaccine();
            aptVaccine1 = aptVaccine1.getVaccine(batchNumber1);
            
            String date1 = aptFromFile1.getAppointmentDate().toString();
            String centreName1 = centreFromFile1.getName();
            String manufacturer1 = aptVaccine1.getManufacturer();
            int doseRequired = aptVaccine1.getDosesRequired();
            
            lblDate1.setText(date1);
            lblCentre1.setText(centreName1);
            lblBatch1.setText(batchNumber1);
            lblManufacturer1.setText(manufacturer1);
            
            if(doseRequired == 2){
                String apt2 = userFromFile.getVacHistory().get(1);
                String aptData2 = File_Helper.readFile("Appointment/" + apt2 + ".txt");
                Appointment aptFromFile2 = File_Helper.gsonWriter.fromJson(aptData2, Appointment.class);
                String centreData2 = File_Helper.readFile("Vaccination_Centre/" + aptFromFile2.getCentreId() + ".txt");
                Vaccination_Centre centreFromFile2 = File_Helper.gsonWriter.fromJson(centreData2, Vaccination_Centre.class);
                List<Candidate> candidateList2 = aptFromFile2.getCandidateList();
                String batchNumber2 = "";

                for(Candidate candidate: candidateList1){
                    if(candidate.getCandidateId().equals(id)){
                        batchNumber2 = candidate.getVaccineBatchNumber();
                    }
                }

                Vaccine aptVaccine2 = new Vaccine();
                aptVaccine2 = aptVaccine2.getVaccine(batchNumber2);

                String date2 = aptFromFile2.getAppointmentDate().toString();
                String centreName2 = centreFromFile2.getName();
                String manufacturer2 = aptVaccine2.getManufacturer();

                lblDate2.setText(date2);
                lblCentre2.setText(centreName2);
                lblBatch2.setText(batchNumber2);
                lblManufacturer2.setText(manufacturer2);
            }else{
                lblDose2.setText("Dose 2:  (Dose 2 not required)");
                lblDate2.setText("None");
                lblCentre2.setText("None");
                lblBatch2.setText("None");
                lblManufacturer2.setText("None");
            }
            
        }
        
    }//GEN-LAST:event_btnPrintMouseClicked

    private void lblLogo2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogo2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblLogo2MouseEntered

    private void lblLogo2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogo2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblLogo2MousePressed

    private void jFrame1WindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jFrame1WindowOpened
        try {
            PrinterJob printJob = PrinterJob.getPrinterJob();
            PageFormat preFormat = printJob.defaultPage();
            preFormat.setOrientation(PageFormat.PORTRAIT);
            PageFormat postFormat = printJob.pageDialog(preFormat);
            
            if(preFormat != postFormat){
                //set print component
                printJob.setPrintable(new Printable(){
                    public int print(Graphics pg, PageFormat pf, int pageNum){
                        if(pageNum > 0){
                            return Printable.NO_SUCH_PAGE;
                        }

                        Graphics2D g2 = (Graphics2D)pg;
                        g2.translate(pf.getImageableX(), pf.getImageableY());
                        g2.scale(0.8, 0.8);

                        jFrame1.paint(g2);
                        return Printable.PAGE_EXISTS;
                    }
                });

                boolean ok = printJob.printDialog();
                if(ok){
                    printJob.print();
                }
            }
        } catch (HeadlessException | PrinterException | IllegalArgumentException e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jFrame1WindowOpened

    private void lblViewDose1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewDose1MouseEntered
        if(lblViewDose1.getText().equals("View Appointment")){
            lblViewDose1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            Font font = lblViewDose1.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            lblViewDose1.setFont(font.deriveFont(attributes));
        }
    }//GEN-LAST:event_lblViewDose1MouseEntered

    private void lblViewDose1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewDose1MouseExited
        if(lblViewDose1.getText().equals("View Appointment")){
            Font font = lblViewDose1.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, -1);
            lblViewDose1.setFont(font.deriveFont(attributes));
        }
    }//GEN-LAST:event_lblViewDose1MouseExited

    private void lblViewDose2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewDose2MouseEntered
        if(lblViewDose2.getText().equals("View Appointment")){
            lblViewDose2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            Font font = lblViewDose2.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            lblViewDose2.setFont(font.deriveFont(attributes));
        }
    }//GEN-LAST:event_lblViewDose2MouseEntered

    private void lblViewDose2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewDose2MouseExited
        if(lblViewDose2.getText().equals("View Appointment")){
            Font font = lblViewDose2.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, -1);
            lblViewDose2.setFont(font.deriveFont(attributes));
        }
    }//GEN-LAST:event_lblViewDose2MouseExited

    private void btnPrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseEntered
        btnPrint.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Font font = btnPrint.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        btnPrint.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_btnPrintMouseEntered

    private void btnPrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseExited
        Font font = btnPrint.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        btnPrint.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_btnPrintMouseExited

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        String id = lblId.getText();

        User_Home userHome = new User_Home(id);
        userHome.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(lblId.getText().equals("userIc")){
            JOptionPane.showMessageDialog(null, "Please login into the system.", "Error", JOptionPane.ERROR_MESSAGE);
            Login login = new Login();
            login.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(User_ViewVaccinationStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_ViewVaccinationStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_ViewVaccinationStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_ViewVaccinationStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_ViewVaccinationStatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancelDose1;
    private javax.swing.JButton btnCancelDose2;
    private javax.swing.JButton btnCompleteDose1;
    private javax.swing.JButton btnCompleteDose2;
    private javax.swing.JLabel btnPrint;
    private javax.swing.JButton btnSubmitApp;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblAppointDesc;
    private javax.swing.JLabel lblBatch1;
    private javax.swing.JLabel lblBatch2;
    private javax.swing.JLabel lblCentre1;
    private javax.swing.JLabel lblCentre2;
    private javax.swing.JLabel lblDate1;
    private javax.swing.JLabel lblDate2;
    private javax.swing.JLabel lblDose1;
    private javax.swing.JLabel lblDose2;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogo2;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblManufacturer1;
    private javax.swing.JLabel lblManufacturer2;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblViewDose1;
    private javax.swing.JLabel lblViewDose2;
    private javax.swing.JLabel lblViewProfile;
    private javax.swing.JPanel userHeader;
    private javax.swing.JPanel userHeader2;
    // End of variables declaration//GEN-END:variables
}
