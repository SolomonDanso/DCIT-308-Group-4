package com.raven.form;

import com.raven.model.Drug;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

public class SupplierForm extends javax.swing.JPanel {

    private TableRowSorter<DefaultTableModel> rowSorter;

    public SupplierForm() {
        initComponents();
        updateTable();
        initSearch();
    }

    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows

        // Fetch drugs from the database using getAllDrugs() from DatabaseHelper
        Map<String, Drug> drugs = DatabaseHelper.getAllDrugs();

        // Iterate over the drugs and add rows to the table model
        for (Drug drug : drugs.values()) {
            // Add a row to the table model
            model.addRow(new Object[]{drug.getSupplier(), drug.getLocation(), drug.getDateAdded()});
        }
    }

    private void searchDrug(String searchTerm) {
        System.out.println("Search Term: " + searchTerm); // Print searchTerm for debugging
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows

        Map<String, Drug> drugs = DatabaseHelper.getAllDrugs();
        boolean found = false;

        for (Map.Entry<String, Drug> entry : drugs.entrySet()) {
            Drug drug = entry.getValue();

            if (containsIgnoreCase(drug.getName(), searchTerm) || containsIgnoreCase(drug.getCode(), searchTerm) ||
                containsIgnoreCase(drug.getSupplier(), searchTerm) || containsIgnoreCase(drug.getDateAdded(), searchTerm) ||
                containsDouble(drug.getPrice(), searchTerm) || containsInteger(drug.getQuantity(), searchTerm)) {

                model.addRow(new Object[]{drug.getSupplier(), drug.getLocation(), drug.getDateAdded()});
                found = true;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "No drugs found matching the search criteria.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
            updateTable();
        }
    }

    private boolean containsIgnoreCase(String source, String searchTerm) {
        return source.toLowerCase().contains(searchTerm.toLowerCase());
    }

    private boolean containsDouble(double value, String searchTerm) {
        try {
            double searchValue = Double.parseDouble(searchTerm);
            return value == searchValue;
        } catch (NumberFormatException e) {
            return false; // If parsing fails, searchTerm is not a valid double
        }
    }

    private boolean containsInteger(int value, String searchTerm) {
        try {
            int searchValue = Integer.parseInt(searchTerm);
            return value == searchValue;
        } catch (NumberFormatException e) {
            return false; // If parsing fails, searchTerm is not a valid integer
        }
    }

    private void initSearch() {
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = searchField.getText();
                System.out.println(text);
                if (text.trim().length() == 0) {
                    // rowSorter.setRowFilter(null);
                } else {
                    searchDrug(text.trim());
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new com.raven.swing.Table();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("List of all Suppliers");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier", "Location", "Date Added"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);

        searchButton.setText("Search");

        // Add components with margin
        this.setBorder(new EmptyBorder(20, 20, 20, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton))
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE) // Adjusted height
                .addGap(20, 20, 20))
        );

        // Set the preferred size to make the height cover the screen
       // this.setPreferredSize(new Dimension(1200, 800)); // Adjust the height as needed
   
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane spTable;
    private com.raven.swing.Table table;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton searchButton;
    // End of variables declaration
}
