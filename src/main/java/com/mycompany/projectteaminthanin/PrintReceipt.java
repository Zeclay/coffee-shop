/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectteaminthanin;

import com.mycompany.projectteaminthanin.DaoModel.DaoReceipt;
import javax.swing.JTextArea;

/**
 *
 * @author ROG
 */
public class PrintReceipt extends javax.swing.JDialog {
    Point_of_sell POS;
    MainMenuPanel mainmenu;
    /**
     * Creates new form PrintReceipt
     */
    public PrintReceipt(java.awt.Frame parent, boolean modal,Point_of_sell POS,MainMenuPanel mainmenu) {
        super(parent, modal);
        initComponents();
        this.POS = POS;
        this.mainmenu = mainmenu;
        DaoReceipt daoRep = new DaoReceipt();
        txtReceipt.setText(txtReceipt.getText()+"------------------------------------------------------\n");
        txtReceipt.setText(txtReceipt.getText()+"                       ร้านกาแฟ Inthanin                \n");
        txtReceipt.setText(txtReceipt.getText()+"                   สาขา  มหาวิทยาลัยบูรพา            \n");
        txtReceipt.setText(txtReceipt.getText()+"รหัสใบเสร็จเลขที่\t"+POS.lastId+"   \n");
        txtReceipt.setText(txtReceipt.getText()+"ผู้ขาย \t"+POS.currentEmp.getEmployee().getName()+"\n");
        txtReceipt.setText(txtReceipt.getText()+"------------------------------------------------------\n");
        int i = 1;
        int amount = 0;
        for(Cart c : POS.cart){
            txtReceipt.setText(txtReceipt.getText()+c.getAmount()+"  "+c.getProduct().getProductName()+"\t"+c.getProduct().getPrice()*c.getAmount()+"\n");
            amount+= c.getAmount();
            i++;
        }
        txtReceipt.setText(txtReceipt.getText()+"------------------------------------------------------\n");
        txtReceipt.setText(txtReceipt.getText()+"ยอดสุทธิ "+amount);
        txtReceipt.setText(txtReceipt.getText()+"\tTotal\t"+POS.total+" Baht\n");
        txtReceipt.setText(txtReceipt.getText()+"\tDiscount\t"+POS.Discount+" Baht\n");
        txtReceipt.setText(txtReceipt.getText()+"\tCash\t"+POS.cash+" Baht\n");
        txtReceipt.setText(txtReceipt.getText()+"\tChange\t"+POS.change+" Baht\n");
        txtReceipt.setText(txtReceipt.getText()+"------------------------------------------------------\n");
        txtReceipt.setText(txtReceipt.getText()+"                      Inthanin Coffee                      \n");
        txtReceipt.setText(txtReceipt.getText()+"------------------------------------------------------\n");
        txtReceipt.setText(txtReceipt.getText()+daoRep.get(POS.lastId).getDate());
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
        txtReceipt = new javax.swing.JTextArea();
        btnReceiptConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtReceipt.setEditable(false);
        txtReceipt.setColumns(20);
        txtReceipt.setFont(new java.awt.Font("AngsanaUPC", 0, 18)); // NOI18N
        txtReceipt.setRows(5);
        jScrollPane1.setViewportView(txtReceipt);

        btnReceiptConfirm.setText("Confirm");
        btnReceiptConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceiptConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(btnReceiptConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReceiptConfirm)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReceiptConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceiptConfirmActionPerformed
        mainmenu.resetPointOfSell();
        this.dispose();
    }//GEN-LAST:event_btnReceiptConfirmActionPerformed

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
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrintReceipt dialog = new PrintReceipt(new javax.swing.JFrame(), true,null,null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReceiptConfirm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtReceipt;
    // End of variables declaration//GEN-END:variables
}
