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
import MyVaccination.Classes.Vaccination_Centre;
import MyVaccination.Helper_Classes.File_Helper;
import MyVaccination.Helper_Classes.MyVaccination_GeneralFunctions;
import javax.swing.JOptionPane;

public class Personnel_ManageVaccinationCentre extends javax.swing.JFrame {

    /**
     * Creates new form Personnel_ManageVaccinationCentre
     */
    public Personnel_ManageVaccinationCentre() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVc = new javax.swing.JTable();
        btnAddNewVc = new javax.swing.JButton();
        btnDeleteVc = new javax.swing.JButton();
        txtVcSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAddEditVc = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Vaccination Centre");
        setName("frmMngVc"); // NOI18N
        setSize(getPreferredSize());

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

        javax.swing.GroupLayout homePersonnelHeaderLayout = new javax.swing.GroupLayout(homePersonnelHeader);
        homePersonnelHeader.setLayout(homePersonnelHeaderLayout);
        homePersonnelHeaderLayout.setHorizontalGroup(
            homePersonnelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePersonnelHeaderLayout.createSequentialGroup()
                .addComponent(btnHome)
                .addGap(0, 735, Short.MAX_VALUE))
        );
        homePersonnelHeaderLayout.setVerticalGroup(
            homePersonnelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePersonnelHeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnHome))
        );

        tblVc.setModel(Vaccination_Centre.getVcTableModel()
        );
        tblVc.setRowHeight(30);
        tblVc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblVc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblVc);
        tblVc.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblVc.removeColumn(tblVc.getColumnModel().getColumn(0));

        btnAddNewVc.setBackground(new java.awt.Color(51, 51, 255));
        btnAddNewVc.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnAddNewVc.setForeground(new java.awt.Color(0, 0, 0));
        btnAddNewVc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/New.png"))); // NOI18N
        btnAddNewVc.setText("New");
        btnAddNewVc.setIconTextGap(10);
        btnAddNewVc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewVcActionPerformed(evt);
            }
        });

        btnDeleteVc.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteVc.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnDeleteVc.setForeground(new java.awt.Color(0, 0, 0));
        btnDeleteVc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Delete.png"))); // NOI18N
        btnDeleteVc.setText("Delete");
        btnDeleteVc.setIconTextGap(10);
        btnDeleteVc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteVcActionPerformed(evt);
            }
        });

        txtVcSearch.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtVcSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVcSearchKeyTyped(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Search.png"))); // NOI18N

        btnAddEditVc.setBackground(new java.awt.Color(255, 153, 51));
        btnAddEditVc.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnAddEditVc.setForeground(new java.awt.Color(0, 0, 0));
        btnAddEditVc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Edit.png"))); // NOI18N
        btnAddEditVc.setText("Edit");
        btnAddEditVc.setIconTextGap(10);
        btnAddEditVc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEditVcActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homePersonnelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVcSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddEditVc)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddNewVc)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteVc)))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnBack)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(homePersonnelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDeleteVc, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddNewVc, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddEditVc, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtVcSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 84, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddNewVc, txtVcSearch});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        Personnel_Home home = new Personnel_Home();
        home.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnAddNewVcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewVcActionPerformed
        Personnel_VaccinationCentreForm vcForm = new Personnel_VaccinationCentreForm();
        vcForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddNewVcActionPerformed

    private void btnDeleteVcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteVcActionPerformed
        // Delete record in table
        int selectedRow = tblVc.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a vaccination centre!", "Vaccination Centre", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int modelRowIndex = tblVc.convertRowIndexToModel(selectedRow);
        String vcId = tblVc.getModel().getValueAt(modelRowIndex, 0).toString();
        Vaccination_Centre vcObject = Vaccination_Centre.getCentre(vcId);

        //Confirm request to delete data
        int decision = JOptionPane.showConfirmDialog(this, "Please confirm the deletion of " + vcObject.getName(), "Vaccination Centre", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (decision == JOptionPane.YES_OPTION) {

            boolean deleteSuccess = File_Helper.deleteFile(vcObject.getFileName());

            //If file failed to delete
            if (!deleteSuccess) {
                JOptionPane.showMessageDialog(this, "Failed to delete record for " + vcObject.getName() + "!", "Vaccination Centre", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            return;
        }

        //Refresh the table model and hide the id column
        tblVc.setModel(Vaccination_Centre.getVcTableModel());
        tblVc.removeColumn(tblVc.getColumnModel().getColumn(0));
    }//GEN-LAST:event_btnDeleteVcActionPerformed

    private void btnAddEditVcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEditVcActionPerformed
        // Edit the selected Vaccination Centre
        int selectedRow = tblVc.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a vaccination centre!", "Vaccination Centre", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int modelRowIndex = tblVc.convertRowIndexToModel(selectedRow);
        String vcId = tblVc.getModel().getValueAt(modelRowIndex, 0).toString();

        Personnel_VaccinationCentreForm vcForm = new Personnel_VaccinationCentreForm(vcId);
        vcForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddEditVcActionPerformed

    private void txtVcSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVcSearchKeyTyped
        //Search
        MyVaccination_GeneralFunctions.searchTable(txtVcSearch, tblVc);
    }//GEN-LAST:event_txtVcSearchKeyTyped

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
      // Return to Personnel Home page
         Personnel_Home home = new Personnel_Home();
        home.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(Personnel_ManageVaccinationCentre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personnel_ManageVaccinationCentre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personnel_ManageVaccinationCentre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personnel_ManageVaccinationCentre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personnel_ManageVaccinationCentre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEditVc;
    private javax.swing.JButton btnAddNewVc;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteVc;
    private javax.swing.JButton btnHome;
    private javax.swing.JPanel homePersonnelHeader;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVc;
    private javax.swing.JTextField txtVcSearch;
    // End of variables declaration//GEN-END:variables
}
