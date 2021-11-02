/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eshop;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author acer
 */
public class ShowPurchaseDetail extends javax.swing.JFrame {
    Connection con;
    Statement st;
    PreparedStatement pst;
    ResultSet rec;
    String a1;

    /**
     * Creates new form ShowPurchaseDetail
     */
    public ShowPurchaseDetail() {
        initComponents();
        fetch();
    }
     public void getData(){
        a1=jTextField1.getText();
    }
    public void connect()
    {
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:JAISWALDSN");
        }
        catch(Exception ex){
        System.out.println(ex);
        }
    }
    public void showData()
     {
     try
        {
        connect();
        st=con.createStatement();
        String str=jTextField1.getText();
        if(str.equals("")){
            DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
                while(model.getRowCount()>0){
                    for(int i=0;i<model.getRowCount();i++){
                        model.removeRow(i);
                    }
                }
            fetch();
        }
        else{
            rec=st.executeQuery("select * from purchasedetail where billno='"+str+"'");
        if(rec.next())
            {
                DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
                while(model.getRowCount()>0){
                    for(int i=0;i<model.getRowCount();i++){
                        model.removeRow(i);
                    }
                }
                fetch1();
                jLabel3.setText("");
            }
        }
        }
       catch(Exception ex)
        {
        System.out.println(ex);
        }
     }
    public ArrayList<PurchaseList> userList(){
        ArrayList<PurchaseList> userList =new ArrayList<>();
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:JAISWALDSN");
            st=con.createStatement();
            rec=st.executeQuery("select * from PurchaseDetail");
            while(rec.next()){
                PurchaseList user=new PurchaseList(rec.getString("dealername"),rec.getString("billno"),rec.getString("itemname"),rec.getString("company"),rec.getString("model"),rec.getString("quantity"),rec.getString("price"),rec.getString("tax"),rec.getString("netamount"));
                userList.add(user);
                
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return userList;
    }
    public ArrayList<PurchaseList> userList1(){
        ArrayList<PurchaseList> userList1 =new ArrayList<>();
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:JAISWALDSN");
            st=con.createStatement();
             String str=jTextField1.getText();
            rec=st.executeQuery("select * from PurchaseDetail where billno='"+str+"'");
            while(rec.next()){
                PurchaseList user=new PurchaseList(rec.getString("dealername"),rec.getString("billno"),rec.getString("itemname"),rec.getString("company"),rec.getString("model"),rec.getString("quantity"),rec.getString("price"),rec.getString("tax"),rec.getString("netamount"));
                userList1.add(user);
                
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return userList1;
    }
    public void fetch(){
        ArrayList<PurchaseList> list = userList();
        DefaultTableModel model1=(DefaultTableModel) jTable1.getModel();
        Object[] row=new Object[9];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getdealer();
            row[1]=list.get(i).getbill();
            row[2]=list.get(i).getname();
            row[3]=list.get(i).getcompany();
            row[4]=list.get(i).getmodel();
            row[5]=list.get(i).getquantity();
            row[6]=list.get(i).getprice();
            row[7]=list.get(i).gettax();
            row[8]=list.get(i).getnetprice();
            model1.addRow(row);           
        }

}
    public void fetch1(){
        ArrayList<PurchaseList> list = userList1();
        DefaultTableModel model1=(DefaultTableModel) jTable1.getModel();
        Object[] row=new Object[9];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getdealer();
            row[1]=list.get(i).getbill();
            row[2]=list.get(i).getname();
            row[3]=list.get(i).getcompany();
            row[4]=list.get(i).getmodel();
            row[5]=list.get(i).getquantity();
            row[6]=list.get(i).getprice();
            row[7]=list.get(i).gettax();
            row[8]=list.get(i).getnetprice();
            model1.addRow(row);           
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "        Dealer's Name", "        Bill Number", "        Item Name", "          Company", "            Model", "         Quantity", "             Price", "                Tax", "          Net Amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("        Purchase Detail   ");

        jLabel2.setText("             Search/Filter");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(29, 29, 29))))
            .addGroup(layout.createSequentialGroup()
                .addGap(841, 841, 841)
                .addComponent(jLabel1)
                .addGap(0, 861, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jTextField1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(153, 153, 153))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
     showData();   // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ShowPurchaseDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowPurchaseDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowPurchaseDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowPurchaseDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowPurchaseDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
