/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination;

import MyVaccination.Classes.Personnel;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author leebe
 */
public class Personnel_Home extends javax.swing.JFrame {

    /**
     * Creates new form Personnel_Home
     */
    String userId = "";

    public Personnel_Home() {
        initComponents();
        ImageIcon img = new ImageIcon("src/MyVaccination/Images/Logo_Background1024.jpg");
        this.setIconImage(img.getImage());
        
        
        lblViewProfile.setVisible(false);
        lblLogout.setVisible(false);
    }

    public Personnel_Home(String userId) {
        initComponents();
        this.userId = userId;
        ImageIcon img = new ImageIcon("src/MyVaccination/Images/Logo_Background1024.jpg");
        this.setIconImage(img.getImage());

        Personnel user = Personnel.getPersonnel(userId);

        lblUsername.setText(user.getUsername());

        lblViewProfile.setVisible(false);
        lblLogout.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMngVC = new javax.swing.JButton();
        btnMngUser = new javax.swing.JButton();
        btnMngApt = new javax.swing.JButton();
        btnMngSupply = new javax.swing.JButton();
        homePersonnelHeader = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        lblViewProfile = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyVaccination");
        setBackground(new java.awt.Color(204, 204, 255));
        setForeground(new java.awt.Color(204, 204, 255));
        setMinimumSize(new java.awt.Dimension(945, 482));
        setSize(new java.awt.Dimension(945, 482));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMngVC.setBackground(new java.awt.Color(204, 153, 255));
        btnMngVC.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnMngVC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Vaccination_Centre_32.png"))); // NOI18N
        btnMngVC.setText("Manage Vaccination Centres");
        btnMngVC.setAlignmentY(0.0F);
        btnMngVC.setIconTextGap(20);
        btnMngVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMngVCActionPerformed(evt);
            }
        });
        getContentPane().add(btnMngVC, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 129, 306, 73));

        btnMngUser.setBackground(new java.awt.Color(204, 153, 255));
        btnMngUser.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnMngUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/User.png"))); // NOI18N
        btnMngUser.setText("Manage Users");
        btnMngUser.setAlignmentY(0.0F);
        btnMngUser.setIconTextGap(20);
        btnMngUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMngUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnMngUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 129, 306, 73));

        btnMngApt.setBackground(new java.awt.Color(204, 153, 255));
        btnMngApt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnMngApt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Appointment2_48.png"))); // NOI18N
        btnMngApt.setText("Manage Appointments");
        btnMngApt.setAlignmentY(0.0F);
        btnMngApt.setIconTextGap(20);
        btnMngApt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMngAptActionPerformed(evt);
            }
        });
        getContentPane().add(btnMngApt, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 260, 306, 73));

        btnMngSupply.setBackground(new java.awt.Color(204, 153, 255));
        btnMngSupply.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnMngSupply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Vaccine.png"))); // NOI18N
        btnMngSupply.setText("Manage Vaccine Supply");
        btnMngSupply.setAlignmentY(0.0F);
        btnMngSupply.setIconTextGap(20);
        btnMngSupply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMngSupplyActionPerformed(evt);
            }
        });
        getContentPane().add(btnMngSupply, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 260, 306, 73));

        homePersonnelHeader.setBackground(new java.awt.Color(204, 153, 255));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Logo_200.png"))); // NOI18N

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

        javax.swing.GroupLayout homePersonnelHeaderLayout = new javax.swing.GroupLayout(homePersonnelHeader);
        homePersonnelHeader.setLayout(homePersonnelHeaderLayout);
        homePersonnelHeaderLayout.setHorizontalGroup(
            homePersonnelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePersonnelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 629, Short.MAX_VALUE)
                .addComponent(lblUsername)
                .addGap(25, 25, 25))
        );
        homePersonnelHeaderLayout.setVerticalGroup(
            homePersonnelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePersonnelHeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo))
            .addGroup(homePersonnelHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblUsername)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(homePersonnelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 60));

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
        getContentPane().add(lblLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 150, 40));

        lblViewProfile.setBackground(new java.awt.Color(204, 153, 255));
        lblViewProfile.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        lblViewProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblViewProfile.setText("View Profile");
        lblViewProfile.setToolTipText("");
        lblViewProfile.setOpaque(true);
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
        getContentPane().add(lblViewProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 150, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMngVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMngVCActionPerformed
        Personnel_ManageVaccinationCentre vc = new Personnel_ManageVaccinationCentre(userId);
        vc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMngVCActionPerformed

    private void btnMngUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMngUserActionPerformed
        Personnel_ManageUsers mngUser = new Personnel_ManageUsers(userId);
        mngUser.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMngUserActionPerformed

    private void btnMngAptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMngAptActionPerformed
        // Redirect to Manage Appointment
        Personnel_ManageAppointment apt = new Personnel_ManageAppointment(userId);
        apt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMngAptActionPerformed

    private void btnMngSupplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMngSupplyActionPerformed
        // Navigate to manage Vaccine supply
        Personnel_ManageVaccineSupply mngForm = new Personnel_ManageVaccineSupply(userId);
        mngForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMngSupplyActionPerformed

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

        Personnel_ViewProfile viewProfile = new Personnel_ViewProfile(userId);
        viewProfile.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblViewProfileMousePressed

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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(userId.equals("")){
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
            java.util.logging.Logger.getLogger(Personnel_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personnel_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personnel_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personnel_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personnel_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMngApt;
    private javax.swing.JButton btnMngSupply;
    private javax.swing.JButton btnMngUser;
    private javax.swing.JButton btnMngVC;
    private javax.swing.JPanel homePersonnelHeader;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblViewProfile;
    // End of variables declaration//GEN-END:variables
}
