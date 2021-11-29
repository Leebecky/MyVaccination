/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination;

import MyVaccination.Classes.People;
import MyVaccination.Classes.Personnel;
import MyVaccination.Classes.User;
import MyVaccination.Helper_Classes.File_Helper;
import MyVaccination.Helper_Classes.MyVaccination_GeneralFunctions;
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
public class Personnel_ManageUsers extends javax.swing.JFrame {

    String userId = "";
    Personnel user;

    /**
     * Creates new form Personnel_ManageUsers
     */
    public Personnel_ManageUsers() {
        user = new Personnel();
        initComponents();
        ImageIcon img = new ImageIcon("src/MyVaccination/Images/Logo_Background1024.jpg");
        this.setIconImage(img.getImage());

        lblViewProfile.setVisible(false);
        lblLogout.setVisible(false);
    }

    public Personnel_ManageUsers(String userId) {
        this.userId = userId;
         user = Personnel.getPersonnel(userId);

        initComponents();
        ImageIcon img = new ImageIcon("src/MyVaccination/Images/Logo_Background1024.jpg");
        this.setIconImage(img.getImage());


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

        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        homePersonnelHeader = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        btnAddEdi = new javax.swing.JButton();
        btnAddNew = new javax.swing.JButton();
        panelTables = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeople = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPersonnel = new javax.swing.JTable();
        lblLogout = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        lblViewProfile = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyVaccination");
        setPreferredSize(new java.awt.Dimension(944, 539));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Search.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 100, 41, 41));

        txtSearch.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 105, 322, 33));

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

        javax.swing.GroupLayout homePersonnelHeaderLayout = new javax.swing.GroupLayout(homePersonnelHeader);
        homePersonnelHeader.setLayout(homePersonnelHeaderLayout);
        homePersonnelHeaderLayout.setHorizontalGroup(
            homePersonnelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePersonnelHeaderLayout.createSequentialGroup()
                .addComponent(btnHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 633, Short.MAX_VALUE)
                .addComponent(lblUsername)
                .addGap(27, 27, 27))
        );
        homePersonnelHeaderLayout.setVerticalGroup(
            homePersonnelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePersonnelHeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnHome))
            .addGroup(homePersonnelHeaderLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblUsername)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(homePersonnelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, -1));

        btnAddEdi.setBackground(new java.awt.Color(255, 153, 51));
        btnAddEdi.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnAddEdi.setForeground(new java.awt.Color(0, 0, 0));
        btnAddEdi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Edit.png"))); // NOI18N
        btnAddEdi.setText("Edit");
        btnAddEdi.setAlignmentY(0.0F);
        btnAddEdi.setIconTextGap(10);
        btnAddEdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEdiActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddEdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, -1, 41));

        btnAddNew.setBackground(new java.awt.Color(51, 51, 255));
        btnAddNew.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnAddNew.setForeground(new java.awt.Color(0, 0, 0));
        btnAddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/New.png"))); // NOI18N
        btnAddNew.setText("New");
        btnAddNew.setAlignmentY(0.0F);
        btnAddNew.setIconTextGap(10);
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, -1, 41));

        panelTables.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                panelTablesStateChanged(evt);
            }
        });

        tblPeople.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblPeople.setModel(People.getTableModel()
        );
        tblPeople.setRowHeight(30);
        tblPeople.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblPeople);
        tblPeople.removeColumn(tblPeople.getColumnModel().getColumn(0));

        panelTables.addTab("People", jScrollPane1);

        tblPersonnel.setModel(Personnel.getTableModel());
        tblPersonnel.setRowHeight(30);
        tblPersonnel.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPersonnel.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblPersonnel);
        tblPersonnel.removeColumn(tblPersonnel.getColumnModel().getColumn(0));

        panelTables.addTab("Personnel", jScrollPane2);

        getContentPane().add(panelTables, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 147, 870, 320));

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

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setAlignmentY(0.0F);
        btnDelete.setIconTextGap(10);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, -1, 41));

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
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, -1, 28));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        Personnel_Home home = new Personnel_Home(userId);
        home.setVisible(true);
        this.setVisible(false);
        this.dispose();

    }//GEN-LAST:event_btnHomeActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        //Search
        if (panelTables.getSelectedIndex() == 0) {

            MyVaccination_GeneralFunctions.searchTable(txtSearch, tblPeople);
        } else {

            MyVaccination_GeneralFunctions.searchTable(txtSearch, tblPersonnel);
        }
    }//GEN-LAST:event_txtSearchKeyTyped

    private void btnAddEdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEdiActionPerformed
        // Edit the selected Appointment
        int selectedRow = -1;
        int currentTab = panelTables.getSelectedIndex();

        if (currentTab == 0) {
            selectedRow = tblPeople.getSelectedRow();
        } else {
            selectedRow = tblPersonnel.getSelectedRow();
        }

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user!", "User", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String selectedUserId = "";
        if (currentTab == 0) {
            int modelRowIndex = tblPeople.convertRowIndexToModel(selectedRow);
            selectedUserId = tblPeople.getModel().getValueAt(modelRowIndex, 0).toString();

        } else {
            int modelRowIndex = tblPersonnel.convertRowIndexToModel(selectedRow);
            selectedUserId = tblPersonnel.getModel().getValueAt(modelRowIndex, 0).toString();

        }
        String userType = (currentTab == 0) ? "People" : "Personnel";
        Personnel_UserRegistration form = new Personnel_UserRegistration(selectedUserId, userType, userId);
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddEdiActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        Personnel_UserRegistration form = new Personnel_UserRegistration(userId);
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Delete record in table
        int currentTab = panelTables.getSelectedIndex();
        int selectedRow = -1;
        String userId = "";
        User delObj;

        if (currentTab == 0) {
            selectedRow = tblPeople.getSelectedRow();
        } else {
            selectedRow = tblPersonnel.getSelectedRow();
        }

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user!", "User", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (currentTab == 0) {
            int modelRowIndex = tblPeople.convertRowIndexToModel(selectedRow);
            userId = tblPeople.getModel().getValueAt(modelRowIndex, 0).toString();
            delObj = People.getPeople(userId);
        } else {
            int modelRowIndex = tblPersonnel.convertRowIndexToModel(selectedRow);
            userId = tblPersonnel.getModel().getValueAt(modelRowIndex, 0).toString();
            delObj = Personnel.getPersonnel(userId);
        }

        //Confirm request to delete data
        int decision = JOptionPane.showConfirmDialog(this, "Please confirm the deletion of " + delObj.getUsername(), "User", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (decision == JOptionPane.YES_OPTION) {

            boolean deleteSuccess = File_Helper.deleteFile(delObj.getFileName());

            //If file failed to delete
            if (!deleteSuccess) {
                JOptionPane.showMessageDialog(this, "Failed to delete record for " + delObj.getUsername() + "!", "User", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            return;
        }

        //Refresh the table model and hide the id column
        if (currentTab == 0) {

            tblPeople.setModel(People.getTableModel());
            tblPeople.removeColumn(tblPeople.getColumnModel().getColumn(0));
        } else {

            tblPersonnel.setModel(Personnel.getTableModel());
            tblPersonnel.removeColumn(tblPersonnel.getColumnModel().getColumn(0));
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
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

    private void panelTablesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_panelTablesStateChanged
        // TODO add your handling code here:
        if (panelTables.getSelectedIndex() == 1 && user.getClearance().equals("Staff")) {
            btnDelete.setEnabled(false);
        } else {

            btnDelete.setEnabled(true);
        }
    }//GEN-LAST:event_panelTablesStateChanged

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
            java.util.logging.Logger.getLogger(Personnel_ManageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personnel_ManageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personnel_ManageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personnel_ManageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personnel_ManageUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEdi;
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHome;
    private javax.swing.JPanel homePersonnelHeader;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblViewProfile;
    private javax.swing.JTabbedPane panelTables;
    private javax.swing.JTable tblPeople;
    private javax.swing.JTable tblPersonnel;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
