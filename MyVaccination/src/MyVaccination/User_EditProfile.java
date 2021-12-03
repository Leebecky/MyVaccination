/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination;

import MyVaccination.Classes.*;
import MyVaccination.Helper_Classes.*;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.time.LocalDate;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class User_EditProfile extends javax.swing.JFrame {

    /**
     * Creates new form User_EditProfile
     */
    public User_EditProfile() {
        initComponents();
        ImageIcon img = new ImageIcon("src/MyVaccination/Images/Logo_Background1024.jpg");
        this.setIconImage(img.getImage());
    }

    public User_EditProfile(String id) {
        initComponents();
        ImageIcon img = new ImageIcon("src/MyVaccination/Images/Logo_Background1024.jpg");
        this.setIconImage(img.getImage());

        String userData = File_Helper.readFile("User_Account/" + id + ".txt");
        People userFromFile = File_Helper.gsonWriter.fromJson(userData, People.class);

        Location location = new Location();
        String[] states = location.getStateList();

        cmbLocation.removeAllItems();
        for (String state : states) {
            cmbLocation.addItem(state);
        }

        lblUsername.setText(userFromFile.getName());
        lblId.setText(id);
        lblId.setVisible(false);
        lblViewProfile.setVisible(false);
        lblLogout.setVisible(false);

        txtFullName.setText(userFromFile.getName());
        txtIcPassport.setText(userFromFile.getId());
        dtDoB.setDate(userFromFile.getDob());
        txtEmail.setText(userFromFile.getEmail());
        txtPhone.setText(userFromFile.getPhone());
        cmbGender.setSelectedItem(userFromFile.getGender());
        cmbNationality.setSelectedItem(userFromFile.getNation());
        cmbLocation.setSelectedItem(userFromFile.getAddress());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userHeader = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        lblViewProfile = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIcPassport = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dtDoB = new com.github.lgooddatepicker.components.DatePicker();
        cmbNationality = new javax.swing.JComboBox<>();
        cmbGender = new javax.swing.JComboBox<>();
        cmbLocation = new javax.swing.JComboBox<>();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyVaccination");
        setResizable(false);
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

        lblUsername.setText("User Name");
        lblUsername.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("edit PROFILE");
        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
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

        txtFullName.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtFullName.setInputVerifier(new Validator());
        txtFullName.setName("Name"); // NOI18N
        getContentPane().add(txtFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 218, 30));

        jLabel3.setText("Full Name : ");
        jLabel3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        txtIcPassport.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtIcPassport.setName(""); // NOI18N
        getContentPane().add(txtIcPassport, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 218, 30));

        jLabel4.setText("IC/Passport :");
        jLabel4.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jLabel5.setText("Email :");
        jLabel5.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, 30));

        jLabel6.setText("Nationality :");
        jLabel6.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, -1, -1));

        jLabel7.setText("Current Location :");
        jLabel7.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, -1, 30));

        jLabel9.setText("Phone Number :");
        jLabel9.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));

        dtDoB.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        getContentPane().add(dtDoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 218, 30));

        cmbNationality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Malaysian", "Non Malaysian" }));
        cmbNationality.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        getContentPane().add(cmbNationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 218, 30));

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        cmbGender.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        getContentPane().add(cmbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 218, 30));

        cmbLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selangor", "Kuala Lumpur", "Penang", "Johor", "Kedah", "Pahang" }));
        cmbLocation.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        getContentPane().add(cmbLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 218, 30));

        btnCancel.setText("Cancel");
        btnCancel.setBackground(new java.awt.Color(204, 153, 255));
        btnCancel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancel.setBorderPainted(false);
        btnCancel.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 110, 40));

        btnSave.setText("Save");
        btnSave.setBackground(new java.awt.Color(204, 153, 255));
        btnSave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSave.setBorderPainted(false);
        btnSave.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 110, 40));

        lblId.setText("userIc");
        lblId.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblId.setForeground(new java.awt.Color(240, 240, 240));
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, 80, 40));

        jLabel2.setText("**This will be your  login username");
        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, 20));

        jLabel8.setText("Date of Birth :");
        jLabel8.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, 30));

        txtEmail.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtEmail.setInputVerifier(new Validator());
        txtEmail.setName("Email"); // NOI18N
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 218, 30));

        jLabel10.setText("Gender :");
        jLabel10.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, -1, -1));

        txtPhone.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtPhone.setInputVerifier(new Validator());
        txtPhone.setName("Phone"); // NOI18N
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 218, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        if (lblLogout.isVisible()) {
            lblViewProfile.setVisible(false);
            lblLogout.setVisible(false);
        } else {
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
         MyVaccination_GeneralFunctions.logout(this, lblId.getText(), "people");
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

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        String id = lblId.getText();

        User_ViewProfile viewProfile = new User_ViewProfile(id);
        viewProfile.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String fullname = txtFullName.getText();
        String ic = txtIcPassport.getText();
        LocalDate dob = dtDoB.getDate();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        String gender = String.valueOf(cmbGender.getSelectedItem());
        String nationality = String.valueOf(cmbNationality.getSelectedItem());
        String location = String.valueOf(cmbLocation.getSelectedItem());
        String id = lblId.getText();

        boolean isBlank = false;
        String todaydt = java.time.LocalDate.now().toString();
        if (fullname.equals("") || ic.equals("") || email.equals("") || phone.equals("")) {
            isBlank = true;
        }

        if (isBlank) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String userData = File_Helper.readFile("User_Account/" + id + ".txt");
            People userInfo = File_Helper.gsonWriter.fromJson(userData, People.class);

            userInfo.setName(fullname);
            userInfo.setId(ic);
            userInfo.setUsername(ic);
            userInfo.setDob(dob);
            userInfo.setEmail(email);
            userInfo.setPhone(phone);
            userInfo.setGender(gender);
            userInfo.setNation(nationality);
            userInfo.setAddress(location);

            
            //Logging changed username
            User currentUser = People.getPeople(lblId.getText());
            if (!currentUser.getUsername().equals(ic)) {
                File_Helper.logToFile("Username updated from " + currentUser.getUsername() + " to " + ic, "User_EditProfile.java");
            }
            
            File_Helper.saveData(userInfo, "User_Account");

            JOptionPane.showMessageDialog(this, "Info Updated!", "Registration Message", JOptionPane.INFORMATION_MESSAGE);

            User_ViewProfile viewProfile = new User_ViewProfile(id);
            viewProfile.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void lblViewProfileMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewProfileMousePressed
        String id = lblId.getText();

        User_ViewProfile viewProfile = new User_ViewProfile(id);
        viewProfile.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblViewProfileMousePressed

    private void lblLogoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoMousePressed
        String id = lblId.getText();

        User_Home userHome = new User_Home(id);
        userHome.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblLogoMousePressed

    private void lblLogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoMouseEntered
        lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblLogoMouseEntered

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (lblId.getText().equals("userIc")) {
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
            java.util.logging.Logger.getLogger(User_EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_EditProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JComboBox<String> cmbLocation;
    private javax.swing.JComboBox<String> cmbNationality;
    private com.github.lgooddatepicker.components.DatePicker dtDoB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblViewProfile;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtIcPassport;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JPanel userHeader;
    // End of variables declaration//GEN-END:variables
}
