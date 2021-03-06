/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.form;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vinhlp.product.ProductDAO;
import vinhlp.stokeinout.StokeInOutDAO;
import vinhlp.stokeinout.StokeInOutDTO;
import vinhlp.stokeinoutdetails.StokeInOutDetailsDAO;
import vinhlp.stokeinoutdetails.StokeInOutDetailsDTO;
import vinhlp.user.UserDAO;

/**
 *
 * @author Asus
 */
public class ViewSelectedProduct extends javax.swing.JFrame {

    HashMap<String, Integer> selectedProduct;
    DefaultTableModel tblModelProduct = null;
    String inOrOut;

    /**
     * Creates new form ViewSelectedProduct
     */
    public ViewSelectedProduct() {
        initComponents();
    }

    public ViewSelectedProduct(HashMap<String, Integer> selected, String inout) {
        initComponents();
        this.selectedProduct = selected;
        tblModelProduct = (DefaultTableModel) tblProduct.getModel();
        loadSelectedProduct();
        inOrOut = inout;
    }

    private Vector toVector(String key, String value) {
        Vector result = new Vector();
        result.add(key);
        result.add(value);
        return result;
    }

    private void loadSelectedProduct() {
        tblModelProduct.setRowCount(0);
        for (String key : selectedProduct.keySet()) {
            tblModelProduct.addRow(toVector(key, selectedProduct.get(key).toString()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lbNameProduct = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Selected Product");

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Quantity"
            }
        ));
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        jLabel2.setText("Name:");

        jLabel3.setText("Quantity:");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton1.setText("Back to select product");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCheckOut.setText("Check out");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(98, 98, 98)
                                        .addComponent(lbNameProduct))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCheckOut)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbNameProduct)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btnCheckOut))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        int row = tblProduct.getSelectedRow();
        lbNameProduct.setText((String) tblModelProduct.getValueAt(row, 0));
        txtQuantity.setText((String) tblModelProduct.getValueAt(row, 1));
    }//GEN-LAST:event_tblProductMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String deleteProductName = lbNameProduct.getText();
        if (deleteProductName != null) {
            if (selectedProduct.containsKey(deleteProductName)) {
                selectedProduct.remove(deleteProductName);
                loadSelectedProduct();
                JOptionPane.showMessageDialog(this, "Delete Success!", "Delete Selected product: ", HEIGHT);
            } else {
                JOptionPane.showMessageDialog(this, "Please select the product to delete!", "Delete Selected product: ", HEIGHT);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select the product to delete!", "Delete Selected product: ", HEIGHT);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new NewInventoryBill(selectedProduct, inOrOut).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String key = lbNameProduct.getText().trim();
        if (!key.equals("")) {
            int quantity = selectedProduct.get(key);
            try {
                quantity = Integer.parseInt(txtQuantity.getText());
                if (quantity > 0) {
                    selectedProduct.put(key, quantity);
                    loadSelectedProduct();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid number of quantity!", "Change quantity process: ", HEIGHT);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid number of quantity!", "Change quantity process: ", HEIGHT);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        StokeInOutDAO daoInOut = new StokeInOutDAO();
        UserDAO daoUser = new UserDAO();
        ProductDAO daoPro = new ProductDAO();
        StokeInOutDetailsDAO daoDetails = new StokeInOutDetailsDAO();
        //insert to StokeInOut table process:
        //get day, month, year
        String date = java.time.LocalDate.now().toString();
        StringTokenizer stk = new StringTokenizer(date, "-");
        String day = "", month = "", year;
        while (stk.hasMoreTokens()) {
            year = stk.nextToken();
            month = stk.nextToken();
            day = stk.nextToken();
        }
        //prepare value to insert
        try {
            int time = daoInOut.getNumOfBillInThatDay(date) + 1;
            String user = daoUser.getInventoryStaffName();
            String id = day + month + time;
            //insert to stoke in out table
            StokeInOutDTO dto = new StokeInOutDTO(id, user, date, inOrOut);
            boolean result = daoInOut.createNewBill(dto);
            if (result) {
                //insert into stoke in out details:
                int count = 0;
                for (String key : selectedProduct.keySet()) {
                    ++count;
                    String idDetails = id + count;
                    String productId = daoPro.getProductID(key);
                    int amount = selectedProduct.get(key);
                    StokeInOutDetailsDTO dtoDetails = new StokeInOutDetailsDTO(idDetails, id, productId, amount);
                    result = daoDetails.createNewBill(dtoDetails);
                    //update quantity of product
                    if (inOrOut.equals("out")) {
                        int available = daoPro.getQuantityOfProduct(productId);
                        result = daoPro.updateQuantity(productId, available - amount);
                    } else {
                        int available = daoPro.getQuantityOfProduct(productId);
                        result = daoPro.updateQuantity(productId, available + amount);
                    }
                }
                if (result) {
                    JOptionPane.showMessageDialog(this, "Create New bill success!", "Create new bill process: ", HEIGHT);
                    new InventoryManagement().setVisible(true);
                    this.dispose();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Check out process: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCheckOutActionPerformed

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
            java.util.logging.Logger.getLogger(ViewSelectedProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSelectedProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSelectedProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSelectedProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSelectedProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNameProduct;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
