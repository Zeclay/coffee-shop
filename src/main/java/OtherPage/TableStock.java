/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtherPage;

import com.mycompany.projectteaminthanin.DaoModel.DaoStock;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Stock;

/**
 *
 * @author NITRO 5
 */
public class TableStock extends javax.swing.JPanel {

    private ArrayList<Stock> stockList;
    private Stocktablemodel model;
    Stock editedStock;

    /**
     * Creates new form TableStock
     */
    public TableStock() {
        initComponents();
        DaoStock dao = new DaoStock();
        initForm();
        loadTable(dao);
    }

    public void initForm() {
        lblidStock.setEnabled(false);
        txtnameStock.setEnabled(false);
        txtamountStock.setEnabled(false);
        txtpriceStock.setEnabled(false);
        btnsaveStock.setEnabled(false);
        btncancleStock.setEnabled(false);
    }

    public void refreshTable() {
        DaoStock dao = new DaoStock();
        ArrayList<Stock> newList = dao.getAll();
        stockList.clear();
        stockList.addAll(newList);
        tblStock.revalidate();
        tblStock.repaint();
    }

    public void clearEditForm() {
        editedStock = null;
        lblshowidStock.setText("");
        txtnameStock.setText("");
        txtamountStock.setText("");
        txtpriceStock.setText("");
        initForm();

    }

    public void loadFormToStock() {
        editedStock.setStockprod_name(txtnameStock.getText());
        editedStock.setAmount(Integer.parseInt(txtamountStock.getText()));
        editedStock.setPrice(Double.parseDouble(txtpriceStock.getText()));
    }

    public void loadTable(DaoStock dao) {
        stockList = dao.getAll();
        model = new Stocktablemodel(stockList);
        tblStock.setModel(model);
    }

    public void loadStockToForm() {
        if (editedStock.getStock_id() >= 0) {
            lblshowidStock.setText("" + editedStock.getStock_id());
        }
        txtnameStock.setText(editedStock.getStockprod_name());
        txtamountStock.setText(editedStock.getAmount() + "");
        txtpriceStock.setText("" + editedStock.getPrice());
        txtnameStock.setEnabled(true);
        txtamountStock.setEnabled(true);
        txtpriceStock.setEnabled(true);
        btnsaveStock.setEnabled(true);
        btncancleStock.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblnameStock = new javax.swing.JLabel();
        lblidStock = new javax.swing.JLabel();
        lbamountStock = new javax.swing.JLabel();
        lblpriceStock = new javax.swing.JLabel();
        txtnameStock = new javax.swing.JTextField();
        txtamountStock = new javax.swing.JTextField();
        txtpriceStock = new javax.swing.JTextField();
        lblshowidStock = new javax.swing.JLabel();
        btnsaveStock = new javax.swing.JButton();
        btncancleStock = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(207, 192, 183));
        setPreferredSize(new java.awt.Dimension(888, 469));

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStock);

        jPanel1.setBackground(new java.awt.Color(112, 84, 62));

        lblnameStock.setText("Name    : ");

        lblidStock.setText("ID         :");

        lbamountStock.setText("Amount :");

        lblpriceStock.setText("Price     : ");

        txtamountStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamountStockActionPerformed(evt);
            }
        });

        lblshowidStock.setText("?");

        btnsaveStock.setBackground(new java.awt.Color(0, 153, 153));
        btnsaveStock.setText("Save");
        btnsaveStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveStockActionPerformed(evt);
            }
        });

        btncancleStock.setBackground(new java.awt.Color(102, 102, 102));
        btncancleStock.setText("Cancle");
        btncancleStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancleStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblnameStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbamountStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblidStock)
                    .addComponent(lblpriceStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnsaveStock, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncancleStock)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblshowidStock)
                            .addComponent(txtamountStock)
                            .addComponent(txtnameStock, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtpriceStock))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblidStock)
                    .addComponent(lblshowidStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnameStock)
                    .addComponent(txtnameStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbamountStock)
                    .addComponent(txtamountStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpriceStock)
                    .addComponent(txtpriceStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsaveStock)
                    .addComponent(btncancleStock))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(110, 95, 56));

        btnAdd.setBackground(new java.awt.Color(102, 102, 102));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(102, 102, 102));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(102, 102, 102));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtamountStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamountStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtamountStockActionPerformed

    private void btnsaveStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveStockActionPerformed
        loadFormToStock();
        DaoStock dao = new DaoStock();
        if (editedStock.getStock_id() >= 0) {
            dao.update(editedStock);
        } else {
            dao.add(editedStock);
        }
        refreshTable();
        clearEditForm();
    }//GEN-LAST:event_btnsaveStockActionPerformed

    private void btncancleStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancleStockActionPerformed
        clearEditForm();
    }//GEN-LAST:event_btncancleStockActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        editedStock = new Stock(-1, "", 0, 0.0);
        loadStockToForm();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tblStock.getSelectedRow() >= 0) {
            editedStock = stockList.get(tblStock.getSelectedRow());
            loadStockToForm();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (tblStock.getSelectedRow() >= 0) {
                DaoStock dao = new DaoStock();
                editedStock = stockList.get(tblStock.getSelectedRow());
                dao.delete(editedStock.getStock_id());
            }
            refreshTable();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btncancleStock;
    private javax.swing.JButton btnsaveStock;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbamountStock;
    private javax.swing.JLabel lblidStock;
    private javax.swing.JLabel lblnameStock;
    private javax.swing.JLabel lblpriceStock;
    private javax.swing.JLabel lblshowidStock;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txtamountStock;
    private javax.swing.JTextField txtnameStock;
    private javax.swing.JTextField txtpriceStock;
    // End of variables declaration//GEN-END:variables
private class Stocktablemodel extends AbstractTableModel {

        private final ArrayList<Stock> data;

        String[] columnName = {"ID", "Name", "Amount", "Price"};

        private Stocktablemodel(ArrayList<Stock> data) {
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return this.data.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Stock stock = this.data.get(rowIndex);
            if (columnIndex == 0) {
                return stock.getStock_id();
            }
            if (columnIndex == 1) {
                return stock.getStockprod_name();
            }
            if (columnIndex == 2) {
                return stock.getAmount();
            }
            if (columnIndex == 3) {
                return stock.getPrice();
            }
            return "";
        }

        @Override
        public String getColumnName(int column) {
            return columnName[column];
        }

    }

}
