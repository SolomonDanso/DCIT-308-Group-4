package com.raven.form;

import com.raven.model.Model_Card;
import com.raven.model.Drug;
import com.raven.model.DrugManager;
import com.raven.swing.ScrollBar;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JOptionPane;

public class Form_Home extends javax.swing.JPanel {
    private DrugManager drugManager;
    private JTextField searchField;
    private JButton searchButton;
    private JPanel searchPanel;

    public Form_Home() {
        initComponents();
        drugManager = new DrugManager();
        initializeDrugs();
        updateTable();
       // initSearch();

        // Additional UI initializations
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Total Drugs", "48", "Increased by 60%"));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/profit.png")), "Total Profit", "GHC 15,000", "Year to Date"));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/flag.png")), "Unique Customers", "520", "Increased by 70%"));
        card4.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Suppliers", "600", "Active Suppliers"));

        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

       
    }

    private void initializeDrugs() {
        drugManager.addDrug(new Drug("87564", "Paracetamol", 48.45, 59, "Ernest Chemist Limited", "25th June, 2024"));
        drugManager.addDrug(new Drug("87565", "Ibuprofen", 20.30, 100, "Danadams", "26th June, 2024"));
        // Add more initial drugs if necessary
    }

    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows

        for (Drug drug : drugManager.getAllDrugs().values()) {
            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    deleteDrug(drug.getCode());
                }
            });
            model.addRow(new Object[]{drug.getCode(), drug.getName(), drug.getPrice(), drug.getQuantity(), drug.getSupplier(), drug.getDateAdded(), deleteButton});
        }
    }

      private void searchDrug(String searchTerm) {
        System.out.println("Search Term: " + searchTerm); // Print searchTerm for debugging
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows
    
        boolean found = false;
        for (Drug drug : drugManager.getAllDrugs().values()) {
            if (containsIgnoreCase(drug.getName(), searchTerm) || containsIgnoreCase(drug.getCode(), searchTerm) ||
                    containsIgnoreCase(drug.getSupplier(), searchTerm) || containsIgnoreCase(drug.getDateAdded(), searchTerm) ||
                    containsDouble(drug.getPrice(), searchTerm) || containsInteger(drug.getQuantity(), searchTerm)) {
                
                        JButton deleteButton = new JButton("Delete");
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteDrug(drug.getCode());
                        System.out.println("Delete button clicked for drug code: " + drug.getCode()); // Print delete button clicked event
                    }
                });
                model.addRow(new Object[]{drug.getCode(), drug.getName(), drug.getPrice(), drug.getQuantity(), drug.getSupplier(), drug.getDateAdded(), deleteButton});
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
    
    

    public void addDrug(Drug drug) {
        drugManager.addDrug(drug);
        updateTable();
    }

    public void viewDrug(String code) {
        Drug drug = drugManager.getDrug(code);
        if (drug != null) {
            // Display drug details in the UI
            // You can add a new method to show details in a dialog or another panel
        } else {
            // Show message that drug is not found
        }
    }

    public void updateDrug(Drug drug) {
        drugManager.updateDrug(drug);
        updateTable();
    }

    public void deleteDrug(String code) {
        drugManager.removeDrug(code);
        updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new com.raven.component.Card();
        card2 = new com.raven.component.Card();
        card3 = new com.raven.component.Card();
        card4 = new com.raven.component.Card();
        panelBorder1 = new com.raven.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new com.raven.swing.Table();

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        panel.add(card3);

        card4.setColor1(new java.awt.Color(243, 128, 102));
        card4.setColor2(new java.awt.Color(240, 96, 64));
        panel.add(card4);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("List of All Drugs");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Price", "Quantity", "Supplier", "Date Added", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        // Set custom renderer and editor for the "Action" column
        table.getColumn("Action").setCellRenderer(new ButtonRenderer());
        table.getColumn("Action").setCellEditor(new ButtonEditor());

        spTable.setViewportView(table);

        // Initialize search panel
        searchPanel = new JPanel();
          searchField = new javax.swing.JTextField(40);
        searchButton = new JButton("Search");
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
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                    .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Custom button renderer class
    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
            setText("Delete");
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    // Custom button editor class
    class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

        private JButton button;
        private String drugCode;

        public ButtonEditor() {
            button = new JButton("Delete");
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                    deleteDrug(drugCode);
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            drugCode = table.getValueAt(row, 0).toString();
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return button.getText();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card card1;
    private com.raven.component.Card card2;
    private com.raven.component.Card card3;
    private com.raven.component.Card card4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private com.raven.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private com.raven.swing.Table table;
    // End of variables declaration//GEN-END:variables
}
