package com.group4.form;

import com.group4.model.Sales;
import com.group4.swing.ScrollBar;
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
import java.text.SimpleDateFormat;

public class ReportForm extends javax.swing.JPanel {

    private TableRowSorter<DefaultTableModel> rowSorter;

    public ReportForm() {
        initComponents();
        updateTable();
        initSearch();
        initReload();
    }

    private void updateTable() {
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows

        // Fetch sales from the database using getAllSales() from DatabaseHelper
        Map<String, Sales> sales = DatabaseHelper.getAllSales();

        // Iterate over the sales and add rows to the table model
        for (Sales sale : sales.values()) {
            // Add a row to the table model
            model.addRow(new Object[]{
                sale.getCode(), 
                sale.getName(),
                sale.getPrice(),
                sale.getQuantity(),
                sale.getAmount(),
                sale.getSupplier(),
                sale.getDateAdded(),
            });
        }
    }

    private void searchDrug(String searchTerm) {
        System.out.println("Search Term: " + searchTerm); // Print searchTerm for debugging
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows
    
        Map<String, Sales> sales = DatabaseHelper.getAllSales();
    
        boolean found = false;
    
        for (Map.Entry<String, Sales> entry : sales.entrySet()) {
            Sales sale = entry.getValue();
    
            // Convert Timestamp to String for comparison
            String dateAddedStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sale.getDateAdded());
    
            if (containsIgnoreCase(sale.getName(), searchTerm) ||containsDouble(sale.getAmount(), searchTerm) || containsIgnoreCase(sale.getCode(), searchTerm) ||
                containsIgnoreCase(sale.getSupplier(), searchTerm) || containsIgnoreCase(dateAddedStr, searchTerm) ||
                containsDouble(sale.getPrice(), searchTerm) || containsInteger(sale.getQuantity(), searchTerm)) {
    
                model.addRow(new Object[]{
                    sale.getCode(), 
                    sale.getName(),
                    sale.getPrice(),
                    sale.getQuantity(),
                    sale.getAmount(),
                    sale.getSupplier(),
                    dateAddedStr,
                });
                found = true;
            }
        }
    
        if (!found) {
            JOptionPane.showMessageDialog(this, "No sales found matching the search criteria.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
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

    private void initReload() {
        reloadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTable();
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new com.group4.swing.Table();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        reloadButton = new javax.swing.JButton(); // Add reload button

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Sales Reports");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Drug Name", "Unit Price", "Quantity", "Amount", "Customer", "Date Added"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);

        searchButton.setText("Search");
        reloadButton.setText("Reload"); // Set text for reload button

        // Add components with margin
        this.setBorder(new EmptyBorder(20, 20, 20, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reloadButton)) // Add reload button to layout
            .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(reloadButton)) // Add reload button to layout
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
    private com.group4.swing.Table table;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton reloadButton; // Declare reload button
    // End of variables declaration
}
