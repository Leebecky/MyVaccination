/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination;

//import static MyVaccination.MyVaccination.parseGsonArray;
import MyVaccination.Helper_Classes.File_Helper;
import MyVaccination.Classes.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.IconUIResource;

/**
 *
 * @author user
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();

        // For fullscreen, but components will misalign
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        diaChangePassword = new javax.swing.JDialog();
        btnPasswordShow_Old = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtChangeUsername = new javax.swing.JTextField();
        txtResetPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        lblResetPassword = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        btnPasswordShow_New = new javax.swing.JButton();
        btnConfirmChange = new javax.swing.JButton();
        btnCancelChange = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblRegister = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblChangePassword = new javax.swing.JLabel();
        btnPasswordShow = new javax.swing.JButton();

        diaChangePassword.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        diaChangePassword.setTitle("MyVaccination");
        diaChangePassword.setMinimumSize(new java.awt.Dimension(690, 370));
        diaChangePassword.setPreferredSize(new java.awt.Dimension(690, 370));
        diaChangePassword.setResizable(false);
        diaChangePassword.setSize(new java.awt.Dimension(690, 370));
        diaChangePassword.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPasswordShow_Old.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/PwOpen.png"))); // NOI18N
        btnPasswordShow_Old.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasswordShow_OldActionPerformed(evt);
            }
        });
        diaChangePassword.getContentPane().add(btnPasswordShow_Old, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 83, -1, 24));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Username :");
        diaChangePassword.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 38, 139, -1));

        txtChangeUsername.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        diaChangePassword.getContentPane().add(txtChangeUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 35, 284, -1));

        txtResetPassword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        diaChangePassword.getContentPane().add(txtResetPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 83, 284, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Old Password :");
        diaChangePassword.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 89, 139, -1));

        txtNewPassword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        diaChangePassword.getContentPane().add(txtNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 125, 284, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("New Password :");
        diaChangePassword.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 128, 139, -1));

        lblResetPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblResetPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblResetPassword.setText("Forgot Password?");
        lblResetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblResetPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblResetPasswordMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblResetPasswordMousePressed(evt);
            }
        });
        diaChangePassword.getContentPane().add(lblResetPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, -1, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Confirm New Password :");
        diaChangePassword.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txtConfirmPassword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        diaChangePassword.getContentPane().add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 284, -1));

        btnPasswordShow_New.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/PwOpen.png"))); // NOI18N
        btnPasswordShow_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasswordShow_NewActionPerformed(evt);
            }
        });
        diaChangePassword.getContentPane().add(btnPasswordShow_New, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 125, -1, 24));

        btnConfirmChange.setBackground(new java.awt.Color(51, 255, 51));
        btnConfirmChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Save.png"))); // NOI18N
        btnConfirmChange.setBorder(null);
        btnConfirmChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmChangeActionPerformed(evt);
            }
        });
        diaChangePassword.getContentPane().add(btnConfirmChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 239, 104, 39));

        btnCancelChange.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Cancel.png"))); // NOI18N
        btnCancelChange.setBorder(null);
        btnCancelChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelChangeActionPerformed(evt);
            }
        });
        diaChangePassword.getContentPane().add(btnCancelChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 239, 104, 39));

        jLabel9.setText("Minimum length is 8 characters");
        diaChangePassword.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 170, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyVaccination");
        setBackground(new java.awt.Color(225, 226, 239));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(180, 151, 214));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel1.setText("LOGIN");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Logo_200.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(378, 378, 378))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 875, -1));

        txtUsername.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        txtUsername.setAlignmentY(0.0F);
        txtUsername.setName(""); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 174, 325, 41));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel2.setText("Password :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 251, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel3.setText("Username : ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 176, -1, -1));

        btnLogin.setBackground(new java.awt.Color(180, 151, 214));
        btnLogin.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogin.setBorderPainted(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 327, 120, 50));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("Don't have an account? ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 438, -1, -1));

        lblRegister.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblRegister.setForeground(new java.awt.Color(0, 153, 255));
        lblRegister.setText("Register Now!");
        lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRegisterMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRegisterMousePressed(evt);
            }
        });
        getContentPane().add(lblRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 438, -1, -1));

        txtPassword.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 244, 325, 45));

        lblChangePassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblChangePassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblChangePassword.setText("Change Password?");
        lblChangePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblChangePasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblChangePasswordMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblChangePasswordMousePressed(evt);
            }
        });
        getContentPane().add(lblChangePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 130, -1));

        btnPasswordShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/PwOpen.png"))); // NOI18N
        btnPasswordShow.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/PwClose.png"))); // NOI18N
        btnPasswordShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasswordShowActionPerformed(evt);
            }
        });
        getContentPane().add(btnPasswordShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 40, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String username = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());
        boolean isValid = false;
        String accName = "";
        String userType = "";
        String userId = "";

        if (!username.isEmpty() && !password.isEmpty()) {
            List<String> userDataArray = File_Helper.readFolder("User_Account");
            List<People> userList = new ArrayList();

            userDataArray.forEach(fileInFolder -> {
                userList.add(File_Helper.gsonWriter.fromJson(fileInFolder, People.class));
            });

            for (int i = 0; i < userList.size(); i++) {
                if (username.equals(userList.get(i).getUsername())) {
                    if (password.equals(userList.get(i).getPassword())) {
                        isValid = true;
                        accName = userList.get(i).getName();
                        userType = userList.get(i).getUserType();
                        userId = userList.get(i).getUserId();
                        break;
                    }
                }
                
                if(isValid){
                    if(userType.equals("Personnel")){
                        String personnelData = File_Helper.readFile("User_Account/" + userId + ".txt");
                        Personnel personnelFromFile = File_Helper.gsonWriter.fromJson(personnelData, Personnel.class);
                        
                        if(personnelFromFile.getStatus().equals("Active")){
                            JOptionPane.showMessageDialog(null, "Login successfully!", "Login Message", JOptionPane.INFORMATION_MESSAGE);
                            Personnel_Home home = new Personnel_Home();
                            home.setVisible(true);
                            this.setVisible(false);
                        }else{
                            JOptionPane.showMessageDialog(null, "The account is inactive!", "Error", JOptionPane.ERROR_MESSAGE);
                            txtUsername.setText("");
                            txtPassword.setText("");  
                        } 
                    }else{
                        JOptionPane.showMessageDialog(null, "Login successfully!", "Login Message", JOptionPane.INFORMATION_MESSAGE);
                        User_Home home = new User_Home(userId);
                        home.setVisible(true);
                        this.setVisible(false);
                    }
                }else{
                   JOptionPane.showMessageDialog(null, "Login information incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
                   txtUsername.setText("");
                   txtPassword.setText("");                
                }
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Please input both username and password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseEntered
        lblRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Font font = lblRegister.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblRegister.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblRegisterMouseEntered

    private void lblRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseExited
        Font font = lblRegister.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        lblRegister.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblRegisterMouseExited

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void lblRegisterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMousePressed
        RegisterAccount register = new RegisterAccount();
        register.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblRegisterMousePressed

    private void lblChangePasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangePasswordMouseEntered
        // Highlight text 
        lblChangePassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Font font = lblChangePassword.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblChangePassword.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblChangePasswordMouseEntered

    private void lblChangePasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangePasswordMouseExited
        // Remove text highlight
        Font font = lblChangePassword.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        lblChangePassword.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblChangePasswordMouseExited

    private void lblChangePasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangePasswordMousePressed
        // Reset Password
        diaChangePassword.setLocationRelativeTo(this);
        diaChangePassword.setVisible(true);
    }//GEN-LAST:event_lblChangePasswordMousePressed

    private void btnPasswordShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasswordShowActionPerformed
        // Hide Password
        if (txtPassword.getEchoChar() == 0) {
            txtPassword.setEchoChar('*');
            btnPasswordShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/PwOpen.png")));

        } else {
            //Show Password
            txtPassword.setEchoChar((char) 0);
            btnPasswordShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/PwClose.png")));
        }
    }//GEN-LAST:event_btnPasswordShowActionPerformed

    private void btnPasswordShow_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasswordShow_NewActionPerformed

        // Hide Password
        if (txtNewPassword.getEchoChar() == 0) {
            txtNewPassword.setEchoChar('*');
            btnPasswordShow_New.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/PwOpen.png")));

        } else {
            //Show Password
            txtNewPassword.setEchoChar((char) 0);
            btnPasswordShow_New.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/PwClose.png")));
        }
    }//GEN-LAST:event_btnPasswordShow_NewActionPerformed

    private void lblResetPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetPasswordMousePressed

        // Reset Password
        int resetDecision = JOptionPane.showConfirmDialog(this, "Are you sure you wish to reset your password to the default?", "Password Reset", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (resetDecision == JOptionPane.YES_OPTION) {
            String username = JOptionPane.showInputDialog(this, "Please enter your username");
            boolean resetSuccess = false;
            String config = "";
//            List<People> peopleList = People.getFolderData();
//            List<Personnel> personnelList = Personnel.getFolderData();
//            List<User> userList = new ArrayList<>();
//            userList.addAll(peopleList);
//            userList.addAll(personnelList);
//
//            for (User u : userList) {
//                if (u.getUsername().equals(username)) {
//                    config = (u.getUserType().equals("Personnel")) ? "Username_(last 4 digits of your user id)" : "Username_DateOfBirth";
//                    resetSuccess = User.registerUser_Personnel(u);
//                    break;
//                }
//            }

            User myUser = User.findUser(username);
            if (myUser != null) {
                config = (myUser.getUserType().equals("Personnel")) ? "Username_(last 4 digits of your user id)" : "Username_DateOfBirth";
                resetSuccess = User.registerUser_Personnel(myUser);
            }

            if (resetSuccess) {
                JOptionPane.showMessageDialog(this, "Password has been reset to the default configuration: " + config + ". Please check your email", "Password Reset", JOptionPane.INFORMATION_MESSAGE);
            } else {

                JOptionPane.showMessageDialog(this, "User not found. Please try again", "Password Reset", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }//GEN-LAST:event_lblResetPasswordMousePressed

    private void lblResetPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetPasswordMouseExited
        // Remove text highlight
        Font font = lblResetPassword.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        lblResetPassword.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblResetPasswordMouseExited

    private void lblResetPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetPasswordMouseEntered
        // Highlight text 
        lblResetPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Font font = lblResetPassword.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblResetPassword.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblResetPasswordMouseEntered

    private void btnPasswordShow_OldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasswordShow_OldActionPerformed

        // Hide Password
        if (txtResetPassword.getEchoChar() == 0) {
            txtResetPassword.setEchoChar('*');
            btnPasswordShow_Old.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/PwOpen.png")));

        } else {
            //Show Password
            txtResetPassword.setEchoChar((char) 0);
            btnPasswordShow_Old.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/PwClose.png")));
        }
    }//GEN-LAST:event_btnPasswordShow_OldActionPerformed

    private void btnCancelChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelChangeActionPerformed
        // Close dialog box
        diaChangePassword.setVisible(false);
        diaChangePassword.dispose();
    }//GEN-LAST:event_btnCancelChangeActionPerformed

    private void btnConfirmChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmChangeActionPerformed
        // Change Password
        String newPassword = txtNewPassword.getText();
        if (txtChangeUsername.getText().isBlank() || txtResetPassword.getText().isBlank() || newPassword.isBlank() || txtConfirmPassword.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields!", "Password Reset", JOptionPane.WARNING_MESSAGE);
            return;
        }

        User myUser = User.findUser(txtChangeUsername.getText());

        if (myUser == null) {
            JOptionPane.showMessageDialog(null, "User not found!", "Password Reset", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!myUser.getPassword().equals(txtResetPassword.getText())) {
            JOptionPane.showMessageDialog(null, "Password is incorrect!", "Password Reset", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!newPassword.equals(txtConfirmPassword.getText())) {
            JOptionPane.showMessageDialog(null, "New passwords do not match!", "Password Reset", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (newPassword.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password is too short!", "Password Reset", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //If all conditions satisfied
        myUser.setPassword(newPassword);
        boolean changeSuccess = User.saveUser(myUser);

        if (changeSuccess) {
            JOptionPane.showMessageDialog(null, "Password successfully changed!", "Password Reset", JOptionPane.INFORMATION_MESSAGE);
            diaChangePassword.setVisible(false);
            diaChangePassword.dispose();
        } else {
                 JOptionPane.showMessageDialog(null, "Failed to update password!", "Password Reset", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmChangeActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelChange;
    private javax.swing.JButton btnConfirmChange;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnPasswordShow;
    private javax.swing.JButton btnPasswordShow_New;
    private javax.swing.JButton btnPasswordShow_Old;
    private javax.swing.JDialog diaChangePassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblChangePassword;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblResetPassword;
    private javax.swing.JTextField txtChangeUsername;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtResetPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
