/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination;

import MyVaccination.Classes.Personnel;
import MyVaccination.Classes.Stock;
import MyVaccination.Classes.Vaccination_Centre;
import MyVaccination.Classes.Vaccine;
import MyVaccination.Helper_Classes.MyVaccination_GeneralFunctions;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.SlidingCategoryDataset;

/**
 *
 * @author leebe
 */
public class Personnel_ManageVaccineSupply extends javax.swing.JFrame {

    String userId = "";

    /**
     * Creates new form Personnel_ManageVaccineSupply
     */
    public Personnel_ManageVaccineSupply() {
        initComponents();
        ImageIcon img = new ImageIcon("src/MyVaccination/Images/Logo_Background1024.jpg");
        this.setIconImage(img.getImage());

        lblViewProfile.setVisible(false);
        lblLogout.setVisible(false);
    }

    public Personnel_ManageVaccineSupply(String userId) {
        this.userId = userId;
        initComponents();
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

        diaResupply = new javax.swing.JDialog();
        btnResupplyCancel = new javax.swing.JButton();
        btnResupplySave = new javax.swing.JButton();
        List<String> vcNameList = new ArrayList<>();
        List<Vaccination_Centre> vcList = Vaccination_Centre.getVcFolderData();
        cmbResupplyVc =  new javax.swing.JComboBox<>(vcList.toArray(new Vaccination_Centre[vcList.size()]));
        spinResupply = new javax.swing.JSpinner();
        cmbResupplyVaccine =  new javax.swing.JComboBox<>(Vaccine.getListOfVaccines());
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        homePersonnelHeader = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelSupply = new javax.swing.JTabbedPane();
        panelChart = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSupply = new javax.swing.JTable();
        btnVcSupply = new javax.swing.JButton();
        int vcSize = Vaccination_Centre.getVcFolderData().size();
        sliderChart = new javax.swing.JSlider();
        btnBack = new javax.swing.JButton();
        lblViewProfile = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();

        diaResupply.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        diaResupply.setTitle("Vaccination Centre Resupply");
        diaResupply.setMinimumSize(new java.awt.Dimension(403, 382));
        diaResupply.setResizable(false);
        diaResupply.setSize(diaResupply.getPreferredSize());

        btnResupplyCancel.setBackground(new java.awt.Color(204, 51, 0));
        btnResupplyCancel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnResupplyCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Cancel.png"))); // NOI18N
        btnResupplyCancel.setText("Cancel");
        btnResupplyCancel.setIconTextGap(10);
        btnResupplyCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResupplyCancelActionPerformed(evt);
            }
        });

        btnResupplySave.setBackground(new java.awt.Color(0, 204, 51));
        btnResupplySave.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnResupplySave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/Save.png"))); // NOI18N
        btnResupplySave.setText("Confirm");
        btnResupplySave.setIconTextGap(10);
        btnResupplySave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResupplySaveActionPerformed(evt);
            }
        });

        cmbResupplyVc.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cmbResupplyVc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbResupplyVcItemStateChanged(evt);
            }
        });

        spinResupply.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        spinResupply.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        cmbResupplyVaccine.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel1.setText("Vaccination Centre");

        jLabel2.setText("Vaccine Brand");

        jLabel3.setText("Stock Amount");

        javax.swing.GroupLayout diaResupplyLayout = new javax.swing.GroupLayout(diaResupply.getContentPane());
        diaResupply.getContentPane().setLayout(diaResupplyLayout);
        diaResupplyLayout.setHorizontalGroup(
            diaResupplyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diaResupplyLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnResupplyCancel)
                .addGap(36, 36, 36)
                .addComponent(btnResupplySave)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, diaResupplyLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(diaResupplyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(diaResupplyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(spinResupply, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(diaResupplyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbResupplyVc, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(66, 66, 66))
            .addGroup(diaResupplyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(diaResupplyLayout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(cmbResupplyVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        diaResupplyLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbResupplyVaccine, cmbResupplyVc, spinResupply});

        diaResupplyLayout.setVerticalGroup(
            diaResupplyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, diaResupplyLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbResupplyVc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(66, 66, 66)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinResupply, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(diaResupplyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResupplySave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResupplyCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
            .addGroup(diaResupplyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(diaResupplyLayout.createSequentialGroup()
                    .addGap(116, 116, 116)
                    .addComponent(cmbResupplyVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(226, Short.MAX_VALUE)))
        );

        diaResupplyLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbResupplyVaccine, cmbResupplyVc, spinResupply});

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyVaccination");
        setMaximumSize(new java.awt.Dimension(950, 570));
        setMinimumSize(new java.awt.Dimension(950, 570));
        setPreferredSize(new java.awt.Dimension(950, 570));
        setResizable(false);
        setSize(new java.awt.Dimension(950, 570));
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
        jLabel5.setText("manage vaccine supply");

        javax.swing.GroupLayout homePersonnelHeaderLayout = new javax.swing.GroupLayout(homePersonnelHeader);
        homePersonnelHeader.setLayout(homePersonnelHeaderLayout);
        homePersonnelHeaderLayout.setHorizontalGroup(
            homePersonnelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePersonnelHeaderLayout.createSequentialGroup()
                .addComponent(btnHome)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(lblUsername)
                .addGap(29, 29, 29))
        );
        homePersonnelHeaderLayout.setVerticalGroup(
            homePersonnelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePersonnelHeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnHome))
            .addGroup(homePersonnelHeaderLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(homePersonnelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(homePersonnelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, -1));

        panelSupply.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                panelSupplyStateChanged(evt);
            }
        });

        panelChart.setMinimumSize(new java.awt.Dimension(675, 266));
        panelChart.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelChartLayout = new javax.swing.GroupLayout(panelChart);
        panelChart.setLayout(panelChartLayout);
        panelChartLayout.setHorizontalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );
        panelChartLayout.setVerticalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );

        panelSupply.addTab("Chart", panelChart);

        tblSupply.setModel(Vaccination_Centre.getVcSupplyTableModel(null, null));
        tblSupply.setMaximumSize(new java.awt.Dimension(675, 266));
        tblSupply.setMinimumSize(new java.awt.Dimension(675, 266));
        tblSupply.setRowHeight(30);
        jScrollPane1.setViewportView(tblSupply);

        panelSupply.addTab("Table", jScrollPane1);

        getContentPane().add(panelSupply, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 111, 670, 299));

        btnVcSupply.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnVcSupply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyVaccination/Images/Icons/supply_48.png"))); // NOI18N
        btnVcSupply.setText("Resupply");
        btnVcSupply.setIconTextGap(20);
        btnVcSupply.setPreferredSize(new java.awt.Dimension(111, 30));
        btnVcSupply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVcSupplyActionPerformed(evt);
            }
        });
        getContentPane().add(btnVcSupply, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, 232, 57));

        sliderChart.setMaximum(vcSize);
        sliderChart.setMinorTickSpacing(3);
        sliderChart.setPaintLabels(true);
        sliderChart.setPaintTicks(true);
        sliderChart.setSnapToTicks(true);
        sliderChart.setValue(0);
        sliderChart.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderChartStateChanged(evt);
            }
        });
        getContentPane().add(sliderChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 422, 675, -1));

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

    private void btnResupplyCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResupplyCancelActionPerformed

        //Check if user is certain
        int decision = JOptionPane.showConfirmDialog(diaResupply, "Warning, no unsaved changes will be saved!", "Cancel Vaccination Centre Resupply", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

        // Close the popup window
        if (decision == JOptionPane.OK_OPTION) {

            diaResupply.setVisible(false);
            diaResupply.dispose();
        } else {
            return;
        }
    }//GEN-LAST:event_btnResupplyCancelActionPerformed

    private void btnResupplySaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResupplySaveActionPerformed
        // Add vaccine supply
        Vaccination_Centre selectedVc = (Vaccination_Centre) cmbResupplyVc.getModel().getSelectedItem();

        String vaccineBrand = cmbResupplyVaccine.getSelectedItem().toString();
        for (int i = 1; i <= (int) spinResupply.getValue(); i++) {
            Vaccine resupplyItem = Vaccine.generateVaccine(vaccineBrand);
            selectedVc.resupply(new Stock(resupplyItem));
        }

        Vaccination_Centre.updateCentre(selectedVc);

        spinResupply.setValue(1);

        //Close the window
        diaResupply.setVisible(false);
        diaResupply.dispose();

        //Refresh Dataset
        CategoryDataset ds = (Vaccination_Centre.supplyDatasetAll() == null) ? new DefaultCategoryDataset() : Vaccination_Centre.supplyDatasetAll();

        JFreeChart barChart = ChartFactory.createStackedBarChart(
                "Vaccination Centre Supply",
                "Vaccination Centre",
                "Quantity",
                new SlidingCategoryDataset(ds, 0, 3),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        panelSupply.setComponentAt(0, chartPanel);

        //Reload the table
        tblSupply.setModel(Vaccination_Centre.getVcSupplyTableModel(null, null));
    }//GEN-LAST:event_btnResupplySaveActionPerformed

    private void btnVcSupplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVcSupplyActionPerformed
        // open resupply menu
        diaResupply.setLocationRelativeTo(this);
        diaResupply.setVisible(true);
        diaResupply.setIconImage(this.getIconImage());

    }//GEN-LAST:event_btnVcSupplyActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (userId.equals("")) {
            JOptionPane.showMessageDialog(null, "Please login into the system.", "Error", JOptionPane.ERROR_MESSAGE);
            Login login = new Login();
            login.setVisible(true);
            this.setVisible(false);
        }

        //Generate supply chart
        CategoryDataset ds = (Vaccination_Centre.supplyDatasetAll() == null) ? new DefaultCategoryDataset() : Vaccination_Centre.supplyDatasetAll();

        JFreeChart barChart = ChartFactory.createStackedBarChart(
                "Vaccination Centre Supply",
                "Vaccination Centre",
                "Quantity",
                new SlidingCategoryDataset(ds, 0, 3),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        panelSupply.setComponentAt(0, chartPanel);
    }//GEN-LAST:event_formWindowOpened

    private void cmbResupplyVcItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbResupplyVcItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbResupplyVcItemStateChanged

    private void panelSupplyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_panelSupplyStateChanged
        // Tab Change

        //if table, hide slider
        if (panelSupply.getSelectedIndex() == 1) {
            sliderChart.setVisible(false);
        }

        //if chart, show slider
        if (panelSupply.getSelectedIndex() == 0) {
            sliderChart.setVisible(true);
        }

    }//GEN-LAST:event_panelSupplyStateChanged

    private void sliderChartStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderChartStateChanged
        // To adjust the chart size
        int sliderValue = sliderChart.getValue();
        CategoryDataset ds = (Vaccination_Centre.supplyDatasetAll() == null) ? new DefaultCategoryDataset() : Vaccination_Centre.supplyDatasetAll();

        JFreeChart barChart = ChartFactory.createStackedBarChart(
                "Vaccination Centre Supply",
                "Vaccination Centre",
                "Quantity",
                new SlidingCategoryDataset(ds, 0 + sliderValue, 3),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        panelSupply.setComponentAt(0, chartPanel);
    }//GEN-LAST:event_sliderChartStateChanged

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Return to Personnel Home page
        Personnel_Home home = new Personnel_Home(userId);
        home.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(Personnel_ManageVaccineSupply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personnel_ManageVaccineSupply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personnel_ManageVaccineSupply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personnel_ManageVaccineSupply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personnel_ManageVaccineSupply().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnResupplyCancel;
    private javax.swing.JButton btnResupplySave;
    private javax.swing.JButton btnVcSupply;
    private javax.swing.JComboBox<String> cmbResupplyVaccine;
    private javax.swing.JComboBox<Vaccination_Centre> cmbResupplyVc;
    private javax.swing.JDialog diaResupply;
    private javax.swing.JPanel homePersonnelHeader;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblViewProfile;
    private javax.swing.JPanel panelChart;
    private javax.swing.JTabbedPane panelSupply;
    private javax.swing.JSlider sliderChart;
    private javax.swing.JSpinner spinResupply;
    private javax.swing.JTable tblSupply;
    // End of variables declaration//GEN-END:variables
}
