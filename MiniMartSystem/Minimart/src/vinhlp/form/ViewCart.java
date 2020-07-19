/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.form;

import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vinhlp.bill.BillDAO;
import vinhlp.bill.BillDTO;
import vinhlp.billdetail.BillDetailsDAO;
import vinhlp.billdetail.BillDetailsDTO;
import vinhlp.cart.CartObject;
import vinhlp.product.ProductDAO;
/**
 *
 * @author Asus
 */
public class ViewCart extends javax.swing.JFrame {

    private CartObject cart;
    DefaultTableModel tblModelCart = null;

    /**
     * Creates new form ViewCart
     */
    public ViewCart() {
        initComponents();
    }

    public ViewCart(CartObject cart) {
        initComponents();
        this.cart = cart;
        tblModelCart = (DefaultTableModel) tblCart.getModel();
        loadCart();
    }

    private Vector toVector(String name, int quan) {
        Vector result = new Vector();
        result.add(name);
        result.add(quan);
        return result;
    }

    public void loadCart() {
        ProductDAO dao = new ProductDAO();
        tblModelCart.setRowCount(0);
        if (cart != null) {
            try {
                for (String key : cart.getItems().keySet()) {
                    String name = dao.getProductName(key);
                    int quan = cart.getItems().get(key);
                    tblModelCart.addRow(toVector(name, quan));
                }
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("load cart: " + e.getMessage());
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnContinueShoppong = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ProductName", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(tblCart);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Your Cart:");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnContinueShoppong.setText("Continue to \nchoose product"); // NOI18N
        btnContinueShoppong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueShoppongActionPerformed(evt);
            }
        });

        btnCheckOut.setText("check out");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnContinueShoppong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnContinueShoppong, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinueShoppongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueShoppongActionPerformed
        new CreateBill(cart).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnContinueShoppongActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String productName = (String) tblModelCart.getValueAt(tblCart.getSelectedRow(), 0);
        if (productName != null) {
            ProductDAO dao = new ProductDAO();
            try {
                String id = dao.getProductID(productName);
                cart.deleteItems(id);
                loadCart();
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("delete items: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        BillDAO dao = new BillDAO();
        ProductDAO daoPro = new ProductDAO();
        String username = "tester";
        String date = java.time.LocalDate.now().toString();
        try {
            int time = dao.getTimeCustomerComeInOneDay(username, date)+1;
            String billID = username + " " + date + " " + time;
            float total = 0;
            for (String key : cart.getItems().keySet()) {
                float priceOfOne = daoPro.getProductPrice(key);
                total += priceOfOne * cart.getItems().get(key);
            }
            BillDTO dto = new BillDTO(billID, username, date, total);
            boolean result = dao.insertNewBill(dto);
            if (result) {
                int count = 1;
                for (String key : cart.getItems().keySet()) {
                    String billDetailId = billID + " " + count;
                    BillDetailsDTO dtoDetails = new BillDetailsDTO(billDetailId, billID, key, cart.getItems().get(key));
                    BillDetailsDAO daoDetails = new BillDetailsDAO();
                    result = daoDetails.insertNewBillDetails(dtoDetails);
                    int availableProduct = daoPro.getQuantityOfProduct(key);
                    int afterProcess = availableProduct - cart.getItems().get(key);
                    result = daoPro.updateQuantity(key, afterProcess);
                    count++;
                }
                if (result) {
                    JOptionPane.showMessageDialog(this, "Checked out!", "Check out: ", HEIGHT);
                    new CreateBill().setVisible(true);
                    this.dispose();
                }
            }
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("Check out process: "+e.getMessage());
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
            java.util.logging.Logger.getLogger(ViewCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnContinueShoppong;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCart;
    // End of variables declaration//GEN-END:variables
}