/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package klinik;
import java.sql.*;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jagad
 */
public class Administrasi extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    Connection cn = koneksi.KoneksiDatabase.Koneksi();
    public Administrasi() {
        initComponents();
        Pasien();
        Dokter();
        Obat();
        TampilData("");
        
    btnSimpan.setEnabled(true);
    btnUbah.setEnabled(false);
    btnHapus.setEnabled(false);
    }
    
    private void Bersih(){
    btnSimpan.setEnabled(true);
    btnUbah.setEnabled(false);
    btnHapus.setEnabled(false);

    txtid_administrasi.setEditable(true);

    txtid_administrasi.setText("");
//    select_pasien.setText("");
//    select_dokter.setText("");
    txtdiagnosa.setText("");
//    select_obat.setText("");
    txttarif.setText("");
    txttotalharga.setText("");
    }
    
    private void TampilData(String string){
try {
    st = cn.createStatement();
    rs = st.executeQuery("SELECT * FROM administrasi INNER JOIN pasien ON administrasi.id_pasien = pasien.id_pasien INNER JOIN dokter ON administrasi.id_dokter = dokter.id_dokter INNER JOIN obat ON administrasi.id_obat = obat.id_obat ORDER BY id_administrasi ASC");
    
    DefaultTableModel model = new DefaultTableModel ();
    model.addColumn("id");
    model.addColumn("pasien");
    model.addColumn("dokter");
    model.addColumn("diagnosa");
    model.addColumn("obat");
    model.addColumn("tarif");
    model.addColumn("totalharga");
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();
    model.setRowCount(0);
    
    while (rs.next()){
    Object [] data = {
    rs.getString("id_administrasi"),
    rs.getString("nama_pasien"),
    rs.getString("nama_dokter"),
    rs.getString("diagnosa"),
    rs.getString("nama_obat"),
    rs.getString("tarif"),
    rs.getString("totalharga")
    };
    
    model.addRow(data);
    tblData.setModel(model);
    }
} catch (Exception e){
}
}

    private void Pasien()
    {
        try {
        st = cn.createStatement();
        rs = st.executeQuery("SELECT * FROM pasien");
        
        while (rs.next()) {
                select_pasien.addItem(rs.getString("nama_pasien"));
//                this.idpasien = rs.getString("id_pasien");
            }
        rs.close(); st.close();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
        private void Dokter()
    {
        try {
        st = cn.createStatement();
        rs = st.executeQuery("SELECT * FROM dokter");
        
        while (rs.next()) {
                select_dokter.addItem(rs.getString("nama_dokter"));
//                this.iddokter = rs.getString("id_dokter");
            }
        rs.close(); st.close();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

        private void Obat()
    {
        try {
        st = cn.createStatement();
        rs = st.executeQuery("SELECT * FROM obat");
        
        while (rs.next()) {
                select_obat.addItem(rs.getString("nama_obat"));
//                this.idobat = rs.getString("id_obat");
            }
        rs.close(); st.close();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

        private String idpasien;

        private void getIDpasien()
    {
        try {
        st = cn.createStatement();
        rs = st.executeQuery("SELECT * FROM pasien WHERE nama_pasien = '" + select_pasien.getSelectedItem() + "'");
        
        while (rs.next()) {
            this.idpasien = rs.getString("id_pasien");
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
}

        private String iddokter;

        private void getIDdokter()
    {
        try {
        st = cn.createStatement();
        rs = st.executeQuery("SELECT * FROM dokter WHERE nama_dokter = '" + select_dokter.getSelectedItem() + "'");
        
        while (rs.next()) {
            this.iddokter = rs.getString("id_dokter");
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
}

        private String idobat;

        private void getIDobat()
    {
        try {
        st = cn.createStatement();
        rs = st.executeQuery("SELECT * FROM obat WHERE nama_obat = '" + select_obat.getSelectedItem()+"'");
        
        while (rs.next()) {
            this.idobat = rs.getString("id_obat");
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
}

        private void cektarif()
        {
        try {

            Integer.parseInt(txttarif.getText());

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "Ups..... nominal harus berupa angka");

            return;

        }
    }

    /**
     * Creates new form Administrasi
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtid_administrasi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        select_pasien = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        select_dokter = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtdiagnosa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        select_obat = new javax.swing.JComboBox<>();
        txttarif = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txttotalharga = new javax.swing.JTextField();
        btnHitung = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("id");

        jLabel2.setText("nama pasien");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel5.setText("ADMINISTRASI");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setText("Reset");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "pasien", "dokter", "diagnosa", "obat", "tarif", "totalharga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        jLabel3.setText("nama dokter");

        jLabel4.setText("diagnosa");

        jLabel6.setText("id obat");

        jLabel7.setText("tarif");

        txttotalharga.setEditable(false);

        btnHitung.setText("Hitung total");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        jLabel8.setText("Rp.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(select_obat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(select_dokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txttarif, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdiagnosa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtid_administrasi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(select_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 5, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnHapus)
                                    .addComponent(btnBatal)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txttotalharga, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(81, 81, 81))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUbah)
                            .addComponent(btnSimpan)
                            .addComponent(jLabel7)
                            .addComponent(btnHitung))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid_administrasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(select_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(select_dokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdiagnosa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(select_obat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttotalharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHitung)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnBatal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // TODO add your handling code here:

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
       // TODO add your handling code here:
       try {
       cektarif();
       getIDpasien ();
       getIDdokter ();
       getIDobat ();
       st = cn.createStatement();
       if (txtid_administrasi.getText().equals("") || select_pasien.getSelectedItem().equals("") || select_dokter.getSelectedItem().equals("") || txtdiagnosa.getText().equals("") ||
       txtdiagnosa.getText().equals("") || txttarif.getText().equals("") || txttotalharga.getText().equals("")) {
       JOptionPane.showMessageDialog(null, "Data tidak boleh kosong", "Validasi Data", JOptionPane.INFORMATION_MESSAGE);
       return;
       }
       if (btnSimpan.getText() == "Simpan"){
            String cek = "SELECT * FROM administrasi WHERE id_administrasi = '" + txtid_administrasi.getText() + "'";
            rs = st.executeQuery(cek);
            if (rs.next()){
            JOptionPane.showMessageDialog(null, "Ups.....id_administrasi sudah ada");
            } else {
            String sql  = "INSERT INTO administrasi VALUES ('"+ txtid_administrasi.getText() + 
                    "', '"+ idpasien +
                    "', '"+ iddokter +
                    "', '"+ txtdiagnosa.getText() +
                    "', '"+ idobat +
                    "', '"+ txttarif.getText() + 
                    "', '"+ txttotalharga.getText() + "')";
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            TampilData ("");
            Bersih ();
            }
       }
       } catch (Exception e){
               }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        Bersih ();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try {
          int jawab;

          if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
            st = cn.createStatement();
            st.execute("DELETE FROM administrasi WHERE id_administrasi='"
                + tblData.getValueAt(tblData.getSelectedRow(), 0) + "'");
            TampilData("");
            Bersih ();
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        cektarif();
          try {
        getIDpasien ();
        getIDdokter ();
        getIDobat ();
          st = cn.createStatement();
          st.execute("UPDATE administrasi set " 
              + "id_pasien='"    + idpasien + "', "
              + "id_dokter='"    + iddokter + "', "
              + "diagnosa='"      + txtdiagnosa.getText() + "', "
              + "id_obat='"   + idobat + "', "
              + "tarif='"   + txttarif.getText() + "', "
              + "totalharga='"    + txttotalharga.getText() + "' WHERE "
              + "id_administrasi='"       + txtid_administrasi.getText() + "'");
          TampilData("");
          JOptionPane.showMessageDialog(null, "Update Berhasil");
          Bersih ();
          } catch (Exception e) {
//          e.printStackTrace();
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:
        txtid_administrasi.setText(tblData.getValueAt(tblData.getSelectedRow(), 0).toString());
        select_pasien.setSelectedItem(tblData.getValueAt(tblData.getSelectedRow(), 1).toString());
        select_dokter.setSelectedItem(tblData.getValueAt(tblData.getSelectedRow(), 2).toString());
        txtdiagnosa.setText(tblData.getValueAt(tblData.getSelectedRow(), 3).toString());
        select_obat.setSelectedItem(tblData.getValueAt(tblData.getSelectedRow(), 4).toString());
        txttarif.setText(tblData.getValueAt(tblData.getSelectedRow(), 5).toString());
        txttotalharga.setText(tblData.getValueAt(tblData.getSelectedRow(), 6).toString());
        
        btnSimpan.setEnabled(false);
        btnUbah.setEnabled(true);
        btnHapus.setEnabled(true);
        
        txtid_administrasi.setEditable(false);
    }//GEN-LAST:event_tblDataMouseClicked

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:
        try {
        getIDobat ();
        st = cn.createStatement();
        rs = st.executeQuery("SELECT * FROM obat WHERE id_obat =" + idobat);

        if (rs.next()) {
        int hargaobat = Integer.parseInt(rs.getString("harga"));
        int tarif = Integer.parseInt(txttarif.getText());
        int total = (hargaobat) + (tarif);
        txttotalharga.setText(String.valueOf(total));
        }
        rs.close(); st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnHitungActionPerformed

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
            java.util.logging.Logger.getLogger(Administrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> select_dokter;
    private javax.swing.JComboBox<String> select_obat;
    private javax.swing.JComboBox<String> select_pasien;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtdiagnosa;
    private javax.swing.JTextField txtid_administrasi;
    private javax.swing.JTextField txttarif;
    private javax.swing.JTextField txttotalharga;
    // End of variables declaration//GEN-END:variables
}
