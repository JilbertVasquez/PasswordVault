/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package passwordvault;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jilbert PC
 */
public class VaultSection extends javax.swing.JFrame {
    public String loginusername;
    public String loginpassword;
    public String logintable;
    /**
     * Creates new form IncomingPurchaseSection
     */
    public VaultSection() {
        initComponents();
        this.setResizable(false);
        setIcon();
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("padlock (1).png")));
    };
    
    public void RefreshTable() {
        DefaultTableModel tablemodel = (DefaultTableModel)vaulttable.getModel();
        int tablecount = tablemodel.getRowCount();
        for (int i = tablecount-1; i >= 0; i--) {
            tablemodel.removeRow(i);
        }
        
        String dbName = "Vault";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, "root", "root");
            Statement st = con.createStatement();

            tablemodel = (DefaultTableModel)vaulttable.getModel();
            
            String usertablename = "";
            String exe2 = "select * from Users";

            ResultSet rs2 = st.executeQuery(exe2);
            while (rs2.next()) {
                String data1 = rs2.getString("username");
                String data2 = rs2.getString("password");

                if (data1.equals(loginusername) && data2.equals(loginpassword)) {
                    usertablename = rs2.getString("tablename");
                    logintable = usertablename;
                    break;
                }
            }
            
            ResultSet rs = st.executeQuery("select * from " + usertablename);
            while (rs.next()) {
                String data1 = rs.getString("saname");
                String data2 = rs.getString("username");
                String data3 = rs.getString("gmail");
                String data4 = rs.getString("password");
                String data5 = rs.getString("addinfo");

                String[] vaultdata = {data1, data2, data3, data4, data5};

                tablemodel.addRow(vaultdata);
            }
        }
         catch (SQLException ex) {
        Logger.getLogger(VaultSection.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SAname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        vaulttable = new javax.swing.JTable();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        addbutton = new javax.swing.JButton();
        addbutton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 1, 36)); // NOI18N
        jLabel2.setText("PASSWORD VAULT");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 45, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setText("VAULT");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 6, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/padlock.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 16, -1, -1));

        SAname.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jPanel2.add(SAname, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 114, 281, -1));

        jLabel3.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jLabel3.setText("SITE / APP NAME:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 113, -1, 32));

        jButton1.setBackground(new java.awt.Color(70, 129, 244));
        jButton1.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/search.png"))); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 113, -1, -1));

        vaulttable.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        vaulttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SITE / APP NAME", "USERNAME", "GMAIL", "PASSWORD", "ADDITIONAL INFO.", "DATE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        vaulttable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(vaulttable);
        if (vaulttable.getColumnModel().getColumnCount() > 0) {
            vaulttable.getColumnModel().getColumn(0).setResizable(false);
            vaulttable.getColumnModel().getColumn(1).setResizable(false);
            vaulttable.getColumnModel().getColumn(2).setResizable(false);
            vaulttable.getColumnModel().getColumn(3).setResizable(false);
            vaulttable.getColumnModel().getColumn(4).setResizable(false);
            vaulttable.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 165, 1161, 490));

        edit.setBackground(new java.awt.Color(70, 129, 244));
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/editing.png"))); // NOI18N
        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel2.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 674, 110, -1));

        delete.setBackground(new java.awt.Color(70, 129, 244));
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/remove.png"))); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(989, 673, 110, 33));

        refresh.setBackground(new java.awt.Color(70, 129, 244));
        refresh.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/refresh-arrow.png"))); // NOI18N
        refresh.setText("REFRESH");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel2.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1113, 115, -1, 32));

        addbutton.setBackground(new java.awt.Color(70, 129, 244));
        addbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/add.png"))); // NOI18N
        addbutton.setText("ADD");
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(addbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 674, 110, -1));

        addbutton1.setBackground(new java.awt.Color(70, 129, 244));
        addbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/logout.png"))); // NOI18N
        addbutton1.setText("LOGOUT");
        addbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbutton1ActionPerformed(evt);
            }
        });
        jPanel2.add(addbutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1117, 674, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/pexels-pixabay-274895 (3).jpg"))); // NOI18N
        jLabel5.setText("J");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -350, 1270, 1070));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        DefaultTableModel tablemodel = (DefaultTableModel)vaulttable.getModel();
        int sel = vaulttable.getSelectedRow();

        if (sel != -1) {
        
            String edititem1 = (String) tablemodel.getValueAt(sel, 0);
            String edititem2 = (String) tablemodel.getValueAt(sel, 1);
            String edititem3 = (String) tablemodel.getValueAt(sel, 2);
            String edititem4 = (String) tablemodel.getValueAt(sel, 3);
            String edititem5 = (String) tablemodel.getValueAt(sel, 4);
            
            String dbName = "Vault";
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, "root", "root");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s WHERE saname = '%s' and gmail = '%s' and password = '%s'",logintable, edititem1, edititem3, edititem4));
                int data0 = 0;
                String data1 = "";
                String data2 = "";
                String data3 = "";
                String data4 = "";
                String data5 = "";
                while(rs.next()) {
                    data0 = rs.getInt("Id");
                    data1 = rs.getString("saname");
                    data2 = rs.getString("username");
                    data3 = rs.getString("gmail");
                    data4 = rs.getString("password");
                    data5 = rs.getString("addinfo");
                }

                EditAccountSection EAS = new EditAccountSection();
                EAS.loginusername = loginusername;
                EAS.loginpassword = loginpassword;
                EAS.logintable = logintable;
                EAS.id = data0;
                
                EAS.accsaname = data1;
                EAS.accusername = data2;
                EAS.accemail = data3;
                EAS.password = data4;
                EAS.accaddinfo = data5;
                
                EAS.editsaname.setText(data1);
                EAS.editusername.setText(data2);
                EAS.editgmail.setText(data3);
                EAS.editpassword.setText(data4);
                EAS.editaddinfo.setText(data5);
                
                EAS.setVisible(true);
                this.dispose();
            }
            catch (SQLException ex) {
                Logger.getLogger(VaultSection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Please select an item.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        DefaultTableModel tablemodel = (DefaultTableModel)vaulttable.getModel();
        int[] sel = vaulttable.getSelectedRows();
        try {
            int a=JOptionPane.showConfirmDialog(this,"Are you sure you want to delete this item/s?");
            
            if (a==JOptionPane.YES_OPTION) {
                String dbName = "Vault";
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, "root", "root");
                    for (int i = 0; i < sel.length; i++) {
                        String delitem = (String) tablemodel.getValueAt(sel[i], 0);
                        String delitem2 = (String) tablemodel.getValueAt(sel[i], 1);
                        String delitem3 = (String) tablemodel.getValueAt(sel[i], 2);
                        String delitem4 = (String) tablemodel.getValueAt(sel[i], 3);
                        String delitem5 = (String) tablemodel.getValueAt(sel[i], 4);
                        
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
                        SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm"); 
                        Date datenow = new Date();  
                        
                        String typeof = "DELETE";
                        String history0 = logintable + "history";
                        String sql2 = "INSERT into " +  history0 + "(saname, username, gmail, password, addinfo, typeof, date, time) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement ps2 = con.prepareStatement(sql2);

                        ps2.setString(1, delitem);
                        ps2.setString(2, delitem2);
                        ps2.setString(3, delitem3);
                        ps2.setString(4, delitem4);
                        ps2.setString(5, delitem5);
                        ps2.setString(6, typeof);
                        ps2.setString(7, formatter.format(datenow));
                        ps2.setString(8, formatter2.format(datenow));
                        ps2.execute();
                        
                        String sql = "Delete from " + logintable + " where saname = ? and username = ? and gmail = ? and password = ? and addinfo = ?";
                        PreparedStatement ps = con.prepareStatement(sql);

                        ps.setString(1, delitem);
                        ps.setString(2, delitem2);
                        ps.setString(3, delitem3);
                        ps.setString(4, delitem4);
                        ps.setString(5, delitem5);
                        ps.execute();
                    }
                    RefreshTable();
                }
                catch (SQLException ex) {
                    Logger.getLogger(VaultSection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please fill out all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String empty = "";
        
        if (!SAname.getText().equals(empty)) {
            String searchproduct = SAname.getText();

            DefaultTableModel tablemodel = (DefaultTableModel)vaulttable.getModel();
            int tablecount = tablemodel.getRowCount();
            for (int i = tablecount-1; i >= 0; i--) {
                tablemodel.removeRow(i);
            }
            
            String dbName = "Vault";
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, "root", "root");
                Statement st = con.createStatement();

                tablemodel = (DefaultTableModel)vaulttable.getModel();

                String searchtemp = "\'" + searchproduct + "%'";
                String exe = String.format("select * from %s where SAName LIKE %s ", logintable, searchtemp);
                ResultSet rs = st.executeQuery(exe);
                while (rs.next()) {
                    String data1 = rs.getString("SAName");
                    String data2 = rs.getString("username");
                    String data3 = rs.getString("gmail");
                    String data4 = rs.getString("password");
                    String data5 = rs.getString("addinfo");
                    
                    String[] vaultdata = {data1, data2, data3, data4, data5};

                    tablemodel.addRow(vaultdata);
                }
            }
             catch (SQLException ex) {
            Logger.getLogger(VaultSection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Please fill out all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        RefreshTable();
    }//GEN-LAST:event_refreshActionPerformed

    private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed
        AddPasswordSection APS = new AddPasswordSection();
        APS.loginusername = loginusername;
        APS.loginpassword = loginpassword;
        APS.logintable = logintable;
        APS.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addbuttonActionPerformed

    private void addbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbutton1ActionPerformed
        LoginSection LS = new LoginSection();
        LS.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addbutton1ActionPerformed

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
            java.util.logging.Logger.getLogger(VaultSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VaultSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VaultSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VaultSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VaultSection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SAname;
    private javax.swing.JButton addbutton;
    private javax.swing.JButton addbutton1;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refresh;
    private javax.swing.JTable vaulttable;
    // End of variables declaration//GEN-END:variables
}
