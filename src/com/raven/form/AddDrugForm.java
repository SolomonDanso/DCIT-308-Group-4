package com.raven.form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.raven.model.Drug;
import com.raven.swing.PanelBorder;

public class AddDrugForm extends javax.swing.JPanel {

    private Queue<Drug> drugQueue;
    private PanelBorder panelBorder1;
    private JPanel panelForm;
    private JLabel jLabel1, lblCode, lblName, lblPrice, lblQuantity, lblSupplier, lblDateAdded;
    private JTextField txtCode, txtName, txtPrice, txtQuantity, txtSupplier, txtDateAdded;
    private JButton btnSave;

    public AddDrugForm() {
        initComponents();
        drugQueue = new LinkedList<>(); // Initialize drugQueue

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.raven.swing.PanelBorder();
        panelForm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lblSupplier = new javax.swing.JLabel();
        txtSupplier = new javax.swing.JTextField();
        lblDateAdded = new javax.swing.JLabel();
        txtDateAdded = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(panelBorder1, gbc);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new java.awt.GridBagLayout());

        panelForm.setBackground(new java.awt.Color(255, 255, 255));
        panelForm.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Add New Drug");
        java.awt.GridBagConstraints gbcPanel = new java.awt.GridBagConstraints();
        gbcPanel.insets = new java.awt.Insets(10, 10, 10, 10);
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 0;
        gbcPanel.gridwidth = 2;
        gbcPanel.anchor = java.awt.GridBagConstraints.CENTER;
        panelForm.add(jLabel1, gbcPanel);

        lblCode.setText("Code:");
        gbcPanel = new java.awt.GridBagConstraints();
        gbcPanel.insets = new java.awt.Insets(10, 10, 10, 10);
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 1;
        gbcPanel.anchor = java.awt.GridBagConstraints.WEST;
        panelForm.add(lblCode, gbcPanel);

        txtCode.setColumns(20);
        gbcPanel = new java.awt.GridBagConstraints();
        gbcPanel.insets = new java.awt.Insets(10, 10, 10, 10);
        gbcPanel.gridx = 1;
        gbcPanel.gridy = 1;
        panelForm.add(txtCode, gbcPanel);

        lblName.setText("Name:");
        gbcPanel = new java.awt.GridBagConstraints();
        gbcPanel.insets = new java.awt.Insets(10, 10, 10, 10);
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 2;
        gbcPanel.anchor = java.awt.GridBagConstraints.WEST;
        panelForm.add(lblName, gbcPanel);

        txtName.setColumns(20);
        gbcPanel = new java.awt.GridBagConstraints();
        gbcPanel.insets = new java.awt.Insets(10, 10, 10, 10);
        gbcPanel.gridx = 1;
        gbcPanel.gridy = 2;
        panelForm.add(txtName, gbcPanel);

        lblPrice.setText("Price:");
        gbcPanel = new java.awt.GridBagConstraints();
        gbcPanel.insets = new java.awt.Insets(10, 10, 10, 10);
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 3;
        gbcPanel.anchor = java.awt.GridBagConstraints.WEST;
        panelForm.add(lblPrice, gbcPanel);

        txtPrice.setColumns(20);
        gbcPanel = new java.awt.GridBagConstraints();
        gbcPanel.insets = new java.awt.Insets(10, 10, 10, 10);
        gbcPanel.gridx = 1;
        gbcPanel.gridy = 3;
        panelForm.add(txtPrice, gbcPanel);

        lblQuantity.setText("Quantity:");
        gbcPanel = new java.awt.GridBagConstraints();
        gbcPanel.insets = new java.awt.Insets(10, 10, 10, 10);
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 4;
        gbcPanel.anchor = java.awt.GridBagConstraints.WEST;
        panelForm.add(lblQuantity, gbcPanel);

        txtQuantity.setColumns(20);
        gbcPanel = new java.awt.GridBagConstraints();
        gbcPanel.insets = new java.awt.Insets(10, 10, 10, 10);
        gbcPanel.gridx = 1;
        gbcPanel.gridy = 4;
        panelForm.add(txtQuantity, gbcPanel);

        lblSupplier.setText("Supplier:");
        gbcPanel = new java.awt.GridBagConstraints();
        gbcPanel.insets = new java.awt.Insets(10, 10, 10, 10);
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 5;
        gbcPanel.anchor = java.awt.GridBagConstraints.WEST;
        panelForm.add(lblSupplier, gbcPanel);

        txtSupplier.setColumns(20);
        gbcPanel = new java.awt.GridBagConstraints();
        gbcPanel.insets = new java.awt.Insets(10, 10, 10, 10);
        gbcPanel.gridx = 1;
        gbcPanel.gridy = 5;
        panelForm.add(txtSupplier, gbcPanel);

        lblDateAdded.setText("Date Added:");
        gbcPanel = new java.awt.GridBagConstraints();
        gbcPanel.insets = new java.awt.Insets(10, 10, 10, 10);
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 6;
        gbcPanel.anchor = java.awt.GridBagConstraints.WEST;
        panelForm.add(lblDateAdded, gbcPanel);

        txtDateAdded.setColumns(20);
        gbcPanel = new java.awt.GridBagConstraints();
        gbcPanel.insets = new java.awt.Insets(10, 10, 10, 10);
        gbcPanel.gridx = 1;
        gbcPanel.gridy = 6;
        panelForm.add(txtDateAdded, gbcPanel);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        gbcPanel = new java.awt.GridBagConstraints();
        gbcPanel.insets = new java.awt.Insets(10, 10, 10, 10);
        gbcPanel.gridx = 1;
        gbcPanel.gridy = 7;
        gbcPanel.anchor = java.awt.GridBagConstraints.EAST;
        panelForm.add(btnSave, gbcPanel);

        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelBorder1.add(panelForm, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

  
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // Handle save button action here
        String code = txtCode.getText();
        String name = txtName.getText();
        String priceStr = txtPrice.getText();
        String quantityStr = txtQuantity.getText();
        String supplier = txtSupplier.getText();
        String dateAdded = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    
        // Validate input
        if (priceStr.isEmpty() || quantityStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Price and Quantity cannot be empty!");
            return;
        }
    
        double price;
        int quantity;
    
        try {
            price = Double.parseDouble(priceStr);
            quantity = Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Price or Quantity!");
            return;
        }
    
        // Create a Drug object and add to queue
        Drug drug = new Drug(code, name, price, quantity, supplier, dateAdded);
        drugQueue.add(drug);
    
        // Process the queue
        while (!drugQueue.isEmpty()) {
            Drug d = drugQueue.poll();
            DatabaseHelper.insertDrug(d.getCode(), d.getName(), d.getPrice(), d.getQuantity(), d.getSupplier(), d.getDateAdded());
        }
    
        // Notify the user
        JOptionPane.showMessageDialog(this, "Drug added successfully!");
    }
    


}
