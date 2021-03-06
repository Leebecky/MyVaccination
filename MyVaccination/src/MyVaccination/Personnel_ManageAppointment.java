/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination;

/**
 *
 * @author leebe
 */
import MyVaccination.Classes.Appointment;
import MyVaccination.Classes.Personnel;
import MyVaccination.Helper_Classes.File_Helper;
import MyVaccination.Helper_Classes.MyVaccination_GeneralFunctions;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Personnel_ManageAppointment extends javax.swing.JFrame {

    String userId = "";

    /**
     * Creates new form Personnel_ManageVaccinationCentre
     */
    public Personnel_ManageAppointment() {
        initComponents();
        ImageIcon img = new ImageIcon("src/MyVaccination/Images/Logo_Background1024.jpg");
        this.setIconImage(img.getImage());

        lblViewProfile.setVisible(false);
        lblLogout.setVisible(false);
    }

    public Personnel_ManageAppointment(String userId) {
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

        homePersonnelHeader = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblApt = new javax.swing.JTable();
        btnAddNewApt = new javax.swing.JButton();
        btnDeleteApt = new javax.swing.JButton();
        txtAptSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAddEditApt = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblViewProfile = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyVaccination");
        setMinimumSize(new java.awt.Dimension(944, 539));
        setName("frmMngApt"); // NOI18N
        setResizable(false);
        setSize(getPreferredSize());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homePersonnelHeader.setBackground(new java.awt.Color(204, 153, 255));

        btnHome.setBackground(new java.awt.Color(204, 153, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Logo_200.png"))); // NOI18N
        btnHome.setBorder(null);
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setFocusPainted(false);
        btnHome.setFocusable(false);
        btnHome.setRequestFocusEnabled(false);
        btnHome.setRolloverEnabled(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        lblUsername.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(0, 0, 0));
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

        jLabel5.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Manage appointments");

        javax.swing.GroupLayout homePersonnelHeaderLayout = new javax.swing.GroupLayout(homePersonnelHeader);
        homePersonnelHeader.setLayout(homePersonnelHeaderLayout);
        homePersonnelHeaderLayout.setHorizontalGroup(
            homePersonnelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePersonnelHeaderLayout.createSequentialGroup()
                .addComponent(btnHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(lblUsername)
                .addGap(19, 19, 19))
        );
        homePersonnelHeaderLayout.setVerticalGroup(
            homePersonnelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePersonnelHeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnHome))
            .addGroup(homePersonnelHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(homePersonnelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lblUsername))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(homePersonnelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, -1));

        tblApt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblApt.setModel(Appointment.getAptTableModel()
        );
        tblApt.setRowHeight(30);
        tblApt.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblApt.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblApt);
        tblApt.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblApt.removeColumn(tblApt.getColumnModel().getColumn(0));

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 180, 811, 303));

        btnAddNewApt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/New.png"))); // NOI18N
        btnAddNewApt.setText("New");
        btnAddNewApt.setAlignmentY(0.0F);
        btnAddNewApt.setBackground(new java.awt.Color(51, 51, 255));
        btnAddNewApt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnAddNewApt.setIconTextGap(10);
        btnAddNewApt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewAptActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddNewApt, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 133, -1, 41));

        btnDeleteApt.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteApt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnDeleteApt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Delete.png"))); // NOI18N
        btnDeleteApt.setText("Delete");
        btnDeleteApt.setAlignmentY(0.0F);
        btnDeleteApt.setIconTextGap(10);
        btnDeleteApt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAptActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteApt, new org.netbeans.lib.awtextra.AbsoluteConstraints(758, 133, -1, 41));

        txtAptSearch.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtAptSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAptSearchKeyTyped(evt);
            }
        });
        getContentPane().add(txtAptSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 133, 322, 41));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Search.png"))); // NOI18N
        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 133, 41, 41));

        btnAddEditApt.setBackground(new java.awt.Color(255, 153, 51));
        btnAddEditApt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnAddEditApt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Edit.png"))); // NOI18N
        btnAddEditApt.setText("Edit");
        btnAddEditApt.setAlignmentY(0.0F);
        btnAddEditApt.setIconTextGap(10);
        btnAddEditApt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEditAptActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddEditApt, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 133, -1, 41));

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
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 66, -1, 28));

        lblViewProfile.setBackground(new java.awt.Color(204, 153, 255));
        lblViewProfile.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        lblViewProfile.setForeground(new java.awt.Color(0, 0, 0));
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

        lblLogout.setBackground(new java.awt.Color(204, 153, 255));
        lblLogout.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(0, 0, 0));
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        Personnel_Home home = new Personnel_Home(userId);
        home.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnAddNewAptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewAptActionPerformed
        Personnel_AppointmentForm aptForm = new Personnel_AppointmentForm(userId);
        aptForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddNewAptActionPerformed

    private void btnDeleteAptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAptActionPerformed
        // Delete record in table
        int selectedRow = tblApt.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an appointment!", "Appointment", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int modelRowIndex = tblApt.convertRowIndexToModel(selectedRow);
        String aptId = tblApt.getModel().getValueAt(modelRowIndex, 0).toString();
        Appointment tblObject = Appointment.getAppointmentDetails(aptId);

        if (!tblObject.getStatus().equals("Closed")) {

            JOptionPane.showMessageDialog(this, "This appointment is still active!", "Appointment", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!tblObject.getCandidateList().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "There are people assigned to this appointment!", "Appointment", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Confirm request to delete data
        int decision = JOptionPane.showConfirmDialog(this, "Please confirm the deletion of this appointment", "Appointment", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (decision == JOptionPane.YES_OPTION) {

            boolean deleteSuccess = File_Helper.deleteFile(tblObject.getFileName());

            //If file failed to delete
            if (!deleteSuccess) {
                JOptionPane.showMessageDialog(this, "Failed to delete record for this appointment" + "!", "Appointment", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            return;
        }

        //Refresh the table model and hide the id column
        tblApt.setModel(Appointment.getAptTableModel());
        tblApt.removeColumn(tblApt.getColumnModel().getColumn(0));
    }//GEN-LAST:event_btnDeleteAptActionPerformed

    private void btnAddEditAptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEditAptActionPerformed
        // Edit the selected Appointment
        int selectedRow = tblApt.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an appointment!", "Appointment", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int modelRowIndex = tblApt.convertRowIndexToModel(selectedRow);
        String aptId = tblApt.getModel().getValueAt(modelRowIndex, 0).toString();

        Personnel_AppointmentForm form = new Personnel_AppointmentForm(aptId, userId);
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddEditAptActionPerformed

    private void txtAptSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAptSearchKeyTyped
        //Search
        MyVaccination_GeneralFunctions.searchTable(txtAptSearch, tblApt);
    }//GEN-LAST:event_txtAptSearchKeyTyped

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Return to Personnel Home page
        Personnel_Home home = new Personnel_Home(userId);
        home.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
      MyVaccination_GeneralFunctions.logout(this, lblUsername.getText());
    }//GEN-LAST:event_lblLogoutMousePressed

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
            java.util.logging.Logger.getLogger(Personnel_ManageAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personnel_ManageAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personnel_ManageAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personnel_ManageAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personnel_ManageAppointment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEditApt;
    private javax.swing.JButton btnAddNewApt;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteApt;
    private javax.swing.JButton btnHome;
    private javax.swing.JPanel homePersonnelHeader;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblViewProfile;
    private javax.swing.JTable tblApt;
    private javax.swing.JTextField txtAptSearch;
    // End of variables declaration//GEN-END:variables
}
