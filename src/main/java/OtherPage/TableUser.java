/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtherPage;

import com.mycompany.projectteaminthanin.DaoModel.DaoStock;
import com.mycompany.projectteaminthanin.DaoModel.DaoUser;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Employee;
import model.Stock;
import model.User;

/**
 *
 * @author ADMIN
 */
public class TableUser extends javax.swing.JPanel {

    private ArrayList<User> userList;
    private UserTablemodel model;
    User editedUser;

    /**
     * Creates new form TableUser2
     */
    public TableUser() {
        initComponents();
        DaoUser dao = new DaoUser();
        initForm();
        loadTable(dao);
    }

    public void initForm() {
        lblidUser.setEnabled(false);
        txtempIdUser.setEnabled(false);
        txtusernameUser.setEnabled(false);
        txtpasswordUser.setEnabled(false);
        btnsaveUser.setEnabled(false);
        btncancelUser.setEnabled(false);
    }

    public void refreshTable() {
        DaoUser dao = new DaoUser();
        ArrayList<User> newList = dao.getAll();
        userList.clear();
        userList.addAll(newList);
        tblUser.revalidate();
        tblUser.repaint();
    }

    public void clearEditForm() {
        editedUser = null;
        lblshowIdUser.setText("");
        txtempIdUser.setText("");
        txtusernameUser.setText("");
        txtpasswordUser.setText("");
        initForm();
    }

    public void loadFormToUser() {
        editedUser.setEmployee(Integer.parseInt(txtempIdUser.getText()));
        editedUser.setUsername(txtusernameUser.getText());
        editedUser.setPassword(txtpasswordUser.getText());
    }

    public void loadTable(DaoUser dao) {
        userList = dao.getAll();
        model = new UserTablemodel(userList);
        tblUser.setModel(model);
    }

    public void loadUserToForm() {
        if (editedUser.getUser_id() >= 0) {
            lblshowIdUser.setText("" + editedUser.getUser_id());
        }
        txtempIdUser.setText("" + editedUser.getEmpID());
        txtusernameUser.setText(editedUser.getUsername() + "");
        txtpasswordUser.setText("" + editedUser.getPassword());
        lblidUser.setEnabled(true);
        txtempIdUser.setEnabled(true);
        txtusernameUser.setEnabled(true);
        txtpasswordUser.setEnabled(true);
        btnsaveUser.setEnabled(true);
        btncancelUser.setEnabled(true);

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
        tblUser = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblpasswordUser = new javax.swing.JLabel();
        btnsaveUser = new javax.swing.JButton();
        btncancelUser = new javax.swing.JButton();
        txtempIdUser = new javax.swing.JTextField();
        txtusernameUser = new javax.swing.JTextField();
        txtpasswordUser = new javax.swing.JTextField();
        lblidUser = new javax.swing.JLabel();
        lblshowIdUser = new javax.swing.JLabel();
        lblempIdUser = new javax.swing.JLabel();
        lblusernameUser = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(888, 469));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUser);

        lblpasswordUser.setText("Password :");

        btnsaveUser.setText("Save");
        btnsaveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveUserActionPerformed(evt);
            }
        });

        btncancelUser.setText("Cancel");
        btncancelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelUserActionPerformed(evt);
            }
        });

        txtempIdUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtempIdUserActionPerformed(evt);
            }
        });

        txtusernameUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameUserActionPerformed(evt);
            }
        });

        lblidUser.setText("ID :");

        lblshowIdUser.setText("?");

        lblempIdUser.setText("EMP_ID :");

        lblusernameUser.setText("Username :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setText("User Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblpasswordUser)
                            .addComponent(lblusernameUser))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnsaveUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btncancelUser)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtpasswordUser)
                            .addComponent(txtusernameUser, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblempIdUser)
                            .addComponent(lblidUser))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblshowIdUser))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(txtempIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel6)
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblidUser)
                    .addComponent(lblshowIdUser))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblempIdUser)
                            .addComponent(txtempIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblusernameUser)
                            .addComponent(txtusernameUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblpasswordUser)
                            .addComponent(txtpasswordUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6)))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsaveUser)
                    .addComponent(btncancelUser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (tblUser.getSelectedRow() >= 0) {
                DaoUser dao = new DaoUser();
                editedUser = userList.get(tblUser.getSelectedRow());
                dao.delete(editedUser.getUser_id());
            }
            refreshTable();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtusernameUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameUserActionPerformed

    private void txtempIdUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtempIdUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtempIdUserActionPerformed

    private void btnsaveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveUserActionPerformed
        loadFormToUser();
        DaoUser dao = new DaoUser();
        if (editedUser.getUser_id() >= 0) {
            dao.update(editedUser);
        } else {
            dao.add(editedUser);
        }
        refreshTable();
        clearEditForm();
    }//GEN-LAST:event_btnsaveUserActionPerformed

    private void btncancelUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelUserActionPerformed
        clearEditForm();
    }//GEN-LAST:event_btncancelUserActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        editedUser = new User(-1, new Employee(), "", "");
        loadUserToForm();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tblUser.getSelectedRow() >= 0) {
            editedUser = userList.get(tblUser.getSelectedRow());
            loadUserToForm();
        }
    }//GEN-LAST:event_btnEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btncancelUser;
    private javax.swing.JButton btnsaveUser;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblempIdUser;
    private javax.swing.JLabel lblidUser;
    private javax.swing.JLabel lblpasswordUser;
    private javax.swing.JLabel lblshowIdUser;
    private javax.swing.JLabel lblusernameUser;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtempIdUser;
    private javax.swing.JTextField txtpasswordUser;
    private javax.swing.JTextField txtusernameUser;
    // End of variables declaration//GEN-END:variables

    private static class UserTablemodel extends AbstractTableModel {

        private final ArrayList<User> data;

        String[] columnName = {"ID", "EMP_ID", "Username", "Password"};

        private UserTablemodel(ArrayList<User> data) {
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
            User user = this.data.get(rowIndex);
            if (columnIndex == 0) {
                return user.getUser_id();
            }
            if (columnIndex == 1) {
                return user.getEmpID();
            }
            if (columnIndex == 2) {
                return user.getUsername();
            }
            if (columnIndex == 3) {
                return user.getPassword();
            }
            return "";
        }

        @Override
        public String getColumnName(int column) {
            return columnName[column];
        }

    }

}
