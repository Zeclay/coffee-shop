/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectteaminthanin;

import com.mycompany.projectteaminthanin.DaoModel.DaoCustomer;
import com.mycompany.projectteaminthanin.Menu.CoffeePanel;
import com.mycompany.projectteaminthanin.Menu.FruitPanel;
import com.mycompany.projectteaminthanin.Menu.TeaAndCocoaPanel;
import javax.swing.JOptionPane;
import model.Customer;

/**
 *
 * @author AuyouknoW
 */
public class Point_of_sell extends javax.swing.JPanel {
    public static boolean beMember = false;
    /**
     * Creates new form Point_of_sell
     */
    public Point_of_sell() {
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

        btnCoffee2 = new javax.swing.JButton();
        scrMenuPanel = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtMember = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        pnlShowname = new javax.swing.JPanel();
        txtNameMember = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listProduct = new javax.swing.JList<>();
        pnlTotal = new javax.swing.JPanel();
        txtTotal = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        scpmenu = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        btnPay = new javax.swing.JButton();
        btnCoffee = new javax.swing.JButton();
        btnTea = new javax.swing.JButton();
        btnFriut = new javax.swing.JButton();

        btnCoffee2.setText("COFFEE");

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        txtMember.setBackground(new java.awt.Color(255, 255, 255));
        txtMember.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMember.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMember.setText("MEMBER");

        tfSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSearch.setText("SEARCH");
        tfSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfSearchMouseClicked(evt);
            }
        });
        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });

        txtNameMember.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNameMember.setText("Name :");

        javax.swing.GroupLayout pnlShownameLayout = new javax.swing.GroupLayout(pnlShowname);
        pnlShowname.setLayout(pnlShownameLayout);
        pnlShownameLayout.setHorizontalGroup(
            pnlShownameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShownameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNameMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlShownameLayout.setVerticalGroup(
            pnlShownameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShownameLayout.createSequentialGroup()
                .addComponent(txtNameMember, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        listProduct.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listProduct);

        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotal.setText("TOTAL");

        javax.swing.GroupLayout pnlTotalLayout = new javax.swing.GroupLayout(pnlTotal);
        pnlTotal.setLayout(pnlTotalLayout);
        pnlTotalLayout.setHorizontalGroup(
            pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTotalLayout.setVerticalGroup(
            pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDelete.setText("DELETE");

        btnClear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnClear.setText("CLEAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(pnlTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfSearch)
                            .addComponent(pnlShowname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(txtMember, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(txtMember, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlShowname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        scpmenu.setViewportView(jPanel3);

        btnPay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPay.setText("PAY");

        btnCoffee.setText("COFFEE");
        btnCoffee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoffeeActionPerformed(evt);
            }
        });

        btnTea.setText("TEA & COCOA");
        btnTea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeaActionPerformed(evt);
            }
        });

        btnFriut.setText("FRUIT DRINK");
        btnFriut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFriutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpmenu)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTea, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFriut, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTea, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFriut, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        scrMenuPanel.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrMenuPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrMenuPanel)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCoffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoffeeActionPerformed
        scpmenu.setViewportView(new CoffeePanel());
    }//GEN-LAST:event_btnCoffeeActionPerformed

    private void btnTeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeaActionPerformed
        scpmenu.setViewportView(new TeaAndCocoaPanel());
    }//GEN-LAST:event_btnTeaActionPerformed

    private void btnFriutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFriutActionPerformed
        scpmenu.setViewportView(new FruitPanel());
    }//GEN-LAST:event_btnFriutActionPerformed

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        String tel = tfSearch.getText();
        DaoCustomer daoCus = new DaoCustomer();
        
        for(Customer c : daoCus.getAll()){
            if(tel.equals(c.getPhone())){
                txtNameMember.setText("Name : "+c.getName());
                beMember = true;
                tfSearch.setEnabled(false);
                return;
            }
        }
        txtNameMember.setText("Not Found");
        tfSearch.setText("");
    }//GEN-LAST:event_tfSearchActionPerformed

    private void tfSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSearchMouseClicked
        tfSearch.setText("");
    }//GEN-LAST:event_tfSearchMouseClicked

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        
    }//GEN-LAST:event_btnRegisterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCoffee;
    private javax.swing.JButton btnCoffee2;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFriut;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnTea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listProduct;
    private javax.swing.JPanel pnlShowname;
    private javax.swing.JPanel pnlTotal;
    private javax.swing.JScrollPane scpmenu;
    private javax.swing.JScrollPane scrMenuPanel;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JLabel txtMember;
    private javax.swing.JLabel txtNameMember;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
