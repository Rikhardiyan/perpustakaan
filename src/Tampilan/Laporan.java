
package Tampilan;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.fonts.*;
import koneksi.koneksi;

public class Laporan extends javax.swing.JFrame {
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;
  
    public Laporan() {
        initComponents();
        dataTabelBuku();
        dataTabelPstkw();
        dataTabelAnggota();
        dataTabelPeminjam();
        dataTabelPengembalian();
        
         setExtendedState(Laporan.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
        
    }
    
    private void dataTabelBuku(){
         Object[] Baris ={ "Kode Buku","Judul Buku","Tanggal Beli","Pengarang","Tahun Terbit", "Jumlah Buku","Penerbit"};
        tabmode = new DefaultTableModel(null, Baris);
       
        
       try{
                String sql = "SELECT * FROM buku where 1";
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    tabmode.addRow(new Object[]{
                        hasil.getString(1),
                        hasil.getString(2),
                        hasil.getString(3),
                        hasil.getString(4),
                        hasil.getString(5),
                        hasil.getString(6),
                        hasil.getString(7)
                    });
                    
                }
                tblBk.setModel(tabmode);
            }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Data Gagal dipanggil"+e);
            }
    }
    
    private void dataTabelPstkw(){
        Object[] Baris ={"ID Pustakawan","No KTP","Nama","Jenis Kelamin","Agama","No. HP","Alamat"};
            tabmode = new DefaultTableModel(null,Baris);
            
            try{
                String sql = "SELECT * FROM pustakawan where 1";
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    tabmode.addRow(new Object[]{
                        hasil.getString(1),
                        hasil.getString(2),
                        hasil.getString(3),
                        hasil.getString(4),
                        hasil.getString(5),
                        hasil.getString(6),
                        hasil.getString(7)
                    });
                    
                }
                tblpstkw.setModel(tabmode);
            }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Data Gagal dipanggil"+e);
            }
    }
    
    private void dataTabelAnggota(){
         Object[] Baris ={"NIS","Nama","Jenis Kelamin","Tanggal Lahir","Tempat Lahir","No. HP","Alamat"};
            tabmode = new DefaultTableModel(null,Baris);
            
            
            try{
                String sql = "SELECT * FROM anggota where 1";
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    tabmode.addRow(new Object[]{
                        hasil.getString(1),
                        hasil.getString(2),
                        hasil.getString(3),
                        hasil.getString(4),
                        hasil.getString(5),
                        hasil.getString(6),
                        hasil.getString(7)
                    });
                    
                }
                tblAng.setModel(tabmode);
            }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Data Gagal dipanggil"+e);
            }
    }
    
    private void dataTabelPeminjam(){
        try{
             Object[] Baris = {"Kode Pinjam","NIS","Nama","Kode Buku","Judul Buku","ID Pustakawan", "Nama","Tanggal Pinjam", "Tanggal Kembali","Jumlah Pinjam"};
               tabmode = new DefaultTableModel(null,Baris);
             String sql = "SELECT * FROM pinjam where 1";
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    tabmode.addRow(new Object[]{
                        hasil.getString(1),
                        hasil.getString(2),
                        hasil.getString(3),
                        hasil.getString(4),
                        hasil.getString(5),
                        hasil.getString(6),
                        hasil.getString(7),
                        hasil.getString(8),
                        hasil.getString(9),
                        hasil.getString(10),
                    });
                    
                }
                tblPin.setModel(tabmode);
            }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Data Gagal dipanggil"+e);
            } 
    }
    
     private void dataTabelPengembalian(){
        try{
             Object[] Baris = {"NIS","Nama","Nama Pustakawan","Judul Buku","Tanggal Pinjam", "Tanggal Kembali","Jumlah Telat","Denda"};
               tabmode = new DefaultTableModel(null,Baris);
             String sql = "SELECT * FROM pengembalian where 1";
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    tabmode.addRow(new Object[]{
                        hasil.getString(1),
                        hasil.getString(2),
                        hasil.getString(3),
                        hasil.getString(4),
                        hasil.getString(5),
                        hasil.getString(6),
                        hasil.getString(7),
                        hasil.getString(8),
                       
                    });
                    
                }
                tblPengembalian.setModel(tabmode);
            }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Data Gagal dipanggil"+e);
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

        jLabel2 = new javax.swing.JLabel();
        panelUtama = new javax.swing.JPanel();
        panelBtn = new javax.swing.JPanel();
        btnBuku = new javax.swing.JButton();
        btnPus = new javax.swing.JButton();
        btnAnggota = new javax.swing.JButton();
        btnPeminjaman = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnPengembalian = new javax.swing.JButton();
        panelAwal = new javax.swing.JPanel();
        panelDaftarBuku = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBk = new javax.swing.JTable();
        btnCetakBk = new javax.swing.JButton();
        panelPstkw = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblpstkw = new javax.swing.JTable();
        btnPrintPstkw = new javax.swing.JButton();
        panelAng = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAng = new javax.swing.JTable();
        btnPrintAng = new javax.swing.JButton();
        panelPeminjam = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPin = new javax.swing.JTable();
        btnPrintPin = new javax.swing.JButton();
        panelPengembalian = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPengembalian = new javax.swing.JTable();
        btnCetakKem = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelUtama.setBackground(new java.awt.Color(0, 102, 153));

        panelBtn.setBackground(new java.awt.Color(0, 102, 153));
        panelBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnBuku.setBackground(new java.awt.Color(0, 102, 153));
        btnBuku.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnBuku.setForeground(new java.awt.Color(255, 255, 255));
        btnBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/book white 24px.png"))); // NOI18N
        btnBuku.setText("Daftar Buku");
        btnBuku.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuku.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBukuActionPerformed(evt);
            }
        });

        btnPus.setBackground(new java.awt.Color(0, 102, 153));
        btnPus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnPus.setForeground(new java.awt.Color(255, 255, 255));
        btnPus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pustakawan putih 24px.png"))); // NOI18N
        btnPus.setText("Pustakawan");
        btnPus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPusActionPerformed(evt);
            }
        });

        btnAnggota.setBackground(new java.awt.Color(0, 102, 153));
        btnAnggota.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnAnggota.setForeground(new java.awt.Color(255, 255, 255));
        btnAnggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/anggota 24px.png"))); // NOI18N
        btnAnggota.setText("Anggota");
        btnAnggota.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAnggota.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnggotaActionPerformed(evt);
            }
        });

        btnPeminjaman.setBackground(new java.awt.Color(0, 102, 153));
        btnPeminjaman.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnPeminjaman.setForeground(new java.awt.Color(255, 255, 255));
        btnPeminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/peminjaman 24px.png"))); // NOI18N
        btnPeminjaman.setText("Peminjaman");
        btnPeminjaman.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPeminjaman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeminjamanActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/report 64px.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Laporan");

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exit putih.png"))); // NOI18N
        jButton1.setText("Exit");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnPengembalian.setBackground(new java.awt.Color(0, 102, 153));
        btnPengembalian.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnPengembalian.setForeground(new java.awt.Color(255, 255, 255));
        btnPengembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/peminjaman 24px.png"))); // NOI18N
        btnPengembalian.setText("Pengembalian");
        btnPengembalian.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPengembalian.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengembalianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtnLayout = new javax.swing.GroupLayout(panelBtn);
        panelBtn.setLayout(panelBtnLayout);
        panelBtnLayout.setHorizontalGroup(
            panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBtnLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBtnLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBtnLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBtnLayout.createSequentialGroup()
                        .addGroup(panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))))
        );
        panelBtnLayout.setVerticalGroup(
            panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBtnLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(84, 84, 84)
                .addComponent(btnBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        panelAwal.setBackground(new java.awt.Color(0, 102, 153));
        panelAwal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panelAwal.setPreferredSize(new java.awt.Dimension(900, 600));
        panelAwal.setLayout(new java.awt.CardLayout());

        panelDaftarBuku.setBackground(new java.awt.Color(0, 102, 153));
        panelDaftarBuku.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/book white 32 px.png"))); // NOI18N
        jLabel3.setText("Daftar Buku");

        tblBk.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblBk);

        btnCetakBk.setBackground(new java.awt.Color(0, 102, 153));
        btnCetakBk.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnCetakBk.setForeground(new java.awt.Color(255, 255, 255));
        btnCetakBk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/print putih.png"))); // NOI18N
        btnCetakBk.setText("Cetak");
        btnCetakBk.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCetakBk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakBkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDaftarBukuLayout = new javax.swing.GroupLayout(panelDaftarBuku);
        panelDaftarBuku.setLayout(panelDaftarBukuLayout);
        panelDaftarBukuLayout.setHorizontalGroup(
            panelDaftarBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDaftarBukuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDaftarBukuLayout.createSequentialGroup()
                .addGroup(panelDaftarBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDaftarBukuLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCetakBk, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDaftarBukuLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );
        panelDaftarBukuLayout.setVerticalGroup(
            panelDaftarBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDaftarBukuLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addGap(113, 113, 113)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCetakBk, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        panelAwal.add(panelDaftarBuku, "card2");

        panelPstkw.setBackground(new java.awt.Color(0, 102, 153));
        panelPstkw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pustakawan putih 32 px.png"))); // NOI18N
        jLabel1.setText("Pustakawan");

        tblpstkw.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblpstkw);

        btnPrintPstkw.setBackground(new java.awt.Color(0, 102, 153));
        btnPrintPstkw.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnPrintPstkw.setForeground(new java.awt.Color(255, 255, 255));
        btnPrintPstkw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/print putih.png"))); // NOI18N
        btnPrintPstkw.setText("Cetak");
        btnPrintPstkw.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPrintPstkw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintPstkwActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPstkwLayout = new javax.swing.GroupLayout(panelPstkw);
        panelPstkw.setLayout(panelPstkwLayout);
        panelPstkwLayout.setHorizontalGroup(
            panelPstkwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPstkwLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addContainerGap(443, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPstkwLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPstkwLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrintPstkw, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        panelPstkwLayout.setVerticalGroup(
            panelPstkwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPstkwLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(100, 100, 100)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPrintPstkw, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        panelAwal.add(panelPstkw, "card3");

        panelAng.setBackground(new java.awt.Color(0, 102, 153));
        panelAng.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Anggota");

        tblAng.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblAng);

        btnPrintAng.setBackground(new java.awt.Color(0, 102, 153));
        btnPrintAng.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnPrintAng.setForeground(new java.awt.Color(255, 255, 255));
        btnPrintAng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/print putih.png"))); // NOI18N
        btnPrintAng.setText("Cetak");
        btnPrintAng.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPrintAng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintAngActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAngLayout = new javax.swing.GroupLayout(panelAng);
        panelAng.setLayout(panelAngLayout);
        panelAngLayout.setHorizontalGroup(
            panelAngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAngLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAngLayout.createSequentialGroup()
                .addGroup(panelAngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAngLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrintAng, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAngLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );
        panelAngLayout.setVerticalGroup(
            panelAngLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAngLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(94, 94, 94)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPrintAng, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        panelAwal.add(panelAng, "card4");

        panelPeminjam.setBackground(new java.awt.Color(0, 102, 153));
        panelPeminjam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Peminjaman");

        tblPin.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblPin);

        btnPrintPin.setBackground(new java.awt.Color(0, 102, 153));
        btnPrintPin.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnPrintPin.setForeground(new java.awt.Color(255, 255, 255));
        btnPrintPin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/print putih.png"))); // NOI18N
        btnPrintPin.setText("Cetak");
        btnPrintPin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPrintPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintPinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPeminjamLayout = new javax.swing.GroupLayout(panelPeminjam);
        panelPeminjam.setLayout(panelPeminjamLayout);
        panelPeminjamLayout.setHorizontalGroup(
            panelPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPeminjamLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPeminjamLayout.createSequentialGroup()
                .addGroup(panelPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPeminjamLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrintPin, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPeminjamLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );
        panelPeminjamLayout.setVerticalGroup(
            panelPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPeminjamLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addGap(92, 92, 92)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPrintPin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        panelAwal.add(panelPeminjam, "card5");

        panelPengembalian.setBackground(new java.awt.Color(0, 102, 153));
        panelPengembalian.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tblPengembalian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tblPengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPengembalianMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblPengembalian);

        btnCetakKem.setBackground(new java.awt.Color(0, 102, 153));
        btnCetakKem.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnCetakKem.setForeground(new java.awt.Color(255, 255, 255));
        btnCetakKem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/print putih.png"))); // NOI18N
        btnCetakKem.setText("Cetak");
        btnCetakKem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCetakKem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakKemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPengembalianLayout = new javax.swing.GroupLayout(panelPengembalian);
        panelPengembalian.setLayout(panelPengembalianLayout);
        panelPengembalianLayout.setHorizontalGroup(
            panelPengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPengembalianLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCetakKem, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPengembalianLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        panelPengembalianLayout.setVerticalGroup(
            panelPengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPengembalianLayout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCetakKem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );

        panelAwal.add(panelPengembalian, "card6");

        javax.swing.GroupLayout panelUtamaLayout = new javax.swing.GroupLayout(panelUtama);
        panelUtama.setLayout(panelUtamaLayout);
        panelUtamaLayout.setHorizontalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAwal, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelUtamaLayout.setVerticalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUtamaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBukuActionPerformed
        // TODO add your handling code here:
        panelAwal.removeAll();
        panelAwal.repaint();
        panelAwal.revalidate();
        
        panelAwal.add(panelDaftarBuku);
        panelAwal.repaint();
        panelAwal.revalidate();
    }//GEN-LAST:event_btnBukuActionPerformed

    private void btnPusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPusActionPerformed
        // TODO add your handling code here:
        panelAwal.removeAll();
        panelAwal.repaint();
        panelAwal.revalidate();
        
        panelAwal.add(panelPstkw);
        panelAwal.repaint();
        panelAwal.revalidate();
    }//GEN-LAST:event_btnPusActionPerformed

    private void btnAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnggotaActionPerformed
        // TODO add your handling code here:
        panelAwal.removeAll();
        panelAwal.repaint();
        panelAwal.revalidate();
        
        panelAwal.add(panelAng);
        panelAwal.repaint();
        panelAwal.revalidate();
    }//GEN-LAST:event_btnAnggotaActionPerformed

    private void btnPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeminjamanActionPerformed
        // TODO add your handling code here:
        panelAwal.removeAll();
        panelAwal.repaint();
        panelAwal.revalidate();
        
        panelAwal.add(panelPeminjam);
        panelAwal.repaint();
        panelAwal.revalidate();
    }//GEN-LAST:event_btnPeminjamanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCetakBkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakBkActionPerformed
        // TODO add your handling code here:
        try{
            String path = "./src/Tampilan/LaporanBuku.jasper";
            HashMap parameter = new HashMap();
            JasperPrint print = JasperFillManager.fillReport(path, parameter,conn);
            JasperViewer.viewReport(print,false);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ ex);
        }
    }//GEN-LAST:event_btnCetakBkActionPerformed

    private void btnPrintPstkwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintPstkwActionPerformed
        // TODO add your handling code here:
        try{
            String path = "./src/Tampilan/LaporanPustakawan.jasper";
            HashMap parameter = new HashMap();
            JasperPrint print = JasperFillManager.fillReport(path, parameter,conn);
            JasperViewer.viewReport(print,false);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ ex);
        }
    }//GEN-LAST:event_btnPrintPstkwActionPerformed

    private void btnPrintAngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintAngActionPerformed
        // TODO add your handling code here:
        try{
            String path = "./src/Tampilan/LaporanAnggota.jasper";
            HashMap parameter = new HashMap();
            JasperPrint print = JasperFillManager.fillReport(path, parameter,conn);
            JasperViewer.viewReport(print,false);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ ex);
        }
    }//GEN-LAST:event_btnPrintAngActionPerformed

    private void btnPrintPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintPinActionPerformed
        // TODO add your handling code here:
        try{
            String path = "./src/Tampilan/LaporanPeminjaman.jasper";
            HashMap parameter = new HashMap();
            JasperPrint print = JasperFillManager.fillReport(path, parameter,conn);
            JasperViewer.viewReport(print,false);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ ex);
        }
    }//GEN-LAST:event_btnPrintPinActionPerformed

    private void btnPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengembalianActionPerformed
        // TODO add your handling code here:
          panelAwal.removeAll();
        panelAwal.repaint();
        panelAwal.revalidate();
        
        panelAwal.add(panelPengembalian);
        panelAwal.repaint();
        panelAwal.revalidate();
    }//GEN-LAST:event_btnPengembalianActionPerformed

    private void tblPengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPengembalianMouseClicked

   
    }//GEN-LAST:event_tblPengembalianMouseClicked

    private void btnCetakKemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakKemActionPerformed
        // TODO add your handling code here:
          try{
            String path = "./src/Tampilan/LaporanPengembalian.jasper";
            HashMap parameter = new HashMap();
            JasperPrint print = JasperFillManager.fillReport(path, parameter,conn);
            JasperViewer.viewReport(print,false);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ ex);
        }
    }//GEN-LAST:event_btnCetakKemActionPerformed

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
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnggota;
    private javax.swing.JButton btnBuku;
    private javax.swing.JButton btnCetakBk;
    private javax.swing.JButton btnCetakKem;
    private javax.swing.JButton btnPeminjaman;
    private javax.swing.JButton btnPengembalian;
    private javax.swing.JButton btnPrintAng;
    private javax.swing.JButton btnPrintPin;
    private javax.swing.JButton btnPrintPstkw;
    private javax.swing.JButton btnPus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel panelAng;
    private javax.swing.JPanel panelAwal;
    private javax.swing.JPanel panelBtn;
    private javax.swing.JPanel panelDaftarBuku;
    private javax.swing.JPanel panelPeminjam;
    private javax.swing.JPanel panelPengembalian;
    private javax.swing.JPanel panelPstkw;
    private javax.swing.JPanel panelUtama;
    private javax.swing.JTable tblAng;
    private javax.swing.JTable tblBk;
    private javax.swing.JTable tblPengembalian;
    private javax.swing.JTable tblPin;
    private javax.swing.JTable tblpstkw;
    // End of variables declaration//GEN-END:variables
}
