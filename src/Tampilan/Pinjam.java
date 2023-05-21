
package Tampilan;

import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.fonts.*;
import javax.swing.JSpinner;
import koneksi.koneksi;

public class Pinjam extends javax.swing.JFrame {
    public String nis,nama;
    public String kdBk,jdlBk;
    public String idPstkw,nmPstkw;
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    /**
     * Creates new form Pinjam
     */
    public Pinjam() {
        initComponents();
        kosong();
        aktif();
        autoNumber();
        dataTabel();
        
        setExtendedState(Pinjam.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
    }

   
    protected void aktif(){
        txtTglPinjam.setEditor(new JSpinner.DateEditor(txtTglPinjam,"yyyy-MM-dd"));
         Object[] Baris = {"Kode Pinjam","NIS","Nama","Kode Buku","Judul Buku","ID Pustakawan", "Nama","Tanggal Pinjam", "Tanggal Kembali","Jumlah Pinjam"};
        tabmode = new DefaultTableModel(null,Baris);
        tblPinjam.setModel(tabmode);
    }
    
    protected void kosong(){
        txtNis.setText("");
        txtNmSiswa.setText("");
        txtKdBuku.setText("");
        txtJdl.setText("");
        idPus.setText("");
        txtNmPus.setText("");
        txtTglKem.setDate(null);
        txtJmlPin.setText("");
    }
    
    protected void autoNumber(){
        try{
            String sql = "SELECT kode_pinjam FROM pinjam order by kode_pinjam asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            txtKdPin.setText("PB0001");
            while(rs.next()){
                String kd_pinjam = rs.getString("kode_pinjam").substring(2);
                int AN = Integer.parseInt(kd_pinjam)+1;
                String nol = "";
                
                if(AN<010)
                {nol = "000";}
                else if (AN < 100)
                {nol = "00";}
                else if (AN < 1000)
                {nol = "0";}
                else if (AN < 10000)
                {nol = "";}
                txtKdPin.setText("PB" + nol + AN);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Auto Number Gagal"+e);
        }
    }
    
    private void dataTabel(){
       String cariItem = txtCariTbl.getText();
            
            try{
                String sql = "SELECT * FROM pinjam where kode_pinjam like '%"+cariItem+"%' or nama_siswa like '%"+cariItem+"%' order by kode_pinjam asc";
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
                tblPinjam.setModel(tabmode);
            }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Data Gagal dipanggil"+e);
            } 
    }
    
    public void itemTerpilihSiswa(){
        PopupAnggota pa = new PopupAnggota();
        pa.swa = this;
        txtNis.setText(nis);
        txtNmSiswa.setText(nama);
    }
    
    public void itemTerpilihBuku(){
        PopupBuku pb = new PopupBuku();
        pb.bku = this;
        txtKdBuku.setText(kdBk);
        txtJdl.setText(jdlBk);
    }
    
    public void itemTerpilihPstkw(){
        PopupPustakawan pp = new PopupPustakawan();
        pp.pstkw = this;
        idPus.setText(idPstkw);
        txtNmPus.setText(nmPstkw);
    }
    
    public void cetak(){
        try{
            String path = "./src/Tampilan/Peminjaman.jasper";
            HashMap parameter = new HashMap();
            parameter.put ("KodePin",txtPrint.getText());
            JasperPrint print = JasperFillManager.fillReport(path, parameter,conn);
            JasperViewer.viewReport(print,false);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNis = new javax.swing.JTextField();
        txtNmSiswa = new javax.swing.JTextField();
        txtKdBuku = new javax.swing.JTextField();
        txtJdl = new javax.swing.JTextField();
        btnCariNis = new javax.swing.JButton();
        btnCariBuku = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtKdPin = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        idPus = new javax.swing.JTextField();
        txtNmPus = new javax.swing.JTextField();
        txtJmlPin = new javax.swing.JTextField();
        btnCariPus = new javax.swing.JButton();
        txtTglKem = new com.toedter.calendar.JDateChooser();
        txtTglPinjam = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPinjam = new javax.swing.JTable();
        txtCariTbl = new javax.swing.JTextField();
        btnCariTbl = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnUbah = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnBatal = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnHapus = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnPrint = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        txtPrint = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1400, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 229));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Peminjaman");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/peminjaman buku.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        jPanel4.setBackground(new java.awt.Color(0, 102, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Siswa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NIS");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 30, 100, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 65, 100, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kode Buku");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 99, 100, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Judul Buku");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 134, 100, -1));
        jPanel4.add(txtNis, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 25, 240, -1));
        jPanel4.add(txtNmSiswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 60, 240, -1));
        jPanel4.add(txtKdBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 94, 240, -1));
        jPanel4.add(txtJdl, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 129, 240, -1));

        btnCariNis.setBackground(new java.awt.Color(0, 102, 153));
        btnCariNis.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnCariNis.setForeground(new java.awt.Color(255, 255, 255));
        btnCariNis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search Putih.png"))); // NOI18N
        btnCariNis.setText("Cari");
        btnCariNis.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCariNis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariNisActionPerformed(evt);
            }
        });
        jPanel4.add(btnCariNis, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 25, 70, 20));

        btnCariBuku.setBackground(new java.awt.Color(0, 102, 153));
        btnCariBuku.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnCariBuku.setForeground(new java.awt.Color(255, 255, 255));
        btnCariBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search Putih.png"))); // NOI18N
        btnCariBuku.setText("Cari");
        btnCariBuku.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCariBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariBukuActionPerformed(evt);
            }
        });
        jPanel4.add(btnCariBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 94, 70, 20));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kode Pinjam");

        jPanel5.setBackground(new java.awt.Color(0, 102, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Pustakawan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID Pustakawan");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nama");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tanggal Pinjam");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tanggal Kembali");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Jumlah Pinjam");

        btnCariPus.setBackground(new java.awt.Color(0, 102, 153));
        btnCariPus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnCariPus.setForeground(new java.awt.Color(255, 255, 255));
        btnCariPus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search Putih.png"))); // NOI18N
        btnCariPus.setText("Cari");
        btnCariPus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCariPus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPusActionPerformed(evt);
            }
        });

        txtTglKem.setDateFormatString("d MMM y");

        txtTglPinjam.setModel(new javax.swing.SpinnerDateModel());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtTglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTglKem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idPus, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNmPus, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJmlPin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCariPus, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(idPus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariPus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNmPus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(txtTglKem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtJmlPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKdPin, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKdPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(50, 90));

        tblPinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        tblPinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPinjamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPinjam);

        txtCariTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariTblActionPerformed(evt);
            }
        });
        txtCariTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariTblKeyPressed(evt);
            }
        });

        btnCariTbl.setBackground(new java.awt.Color(255, 255, 204));
        btnCariTbl.setForeground(new java.awt.Color(0, 102, 153));
        btnCariTbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        btnCariTbl.setText("Cari");
        btnCariTbl.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCariTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariTblActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSimpan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(0, 102, 153));
        btnSimpan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSimpanMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 204));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setPreferredSize(new java.awt.Dimension(90, 35));

        btnUbah.setBackground(new java.awt.Color(0, 102, 153));
        btnUbah.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(0, 102, 153));
        btnUbah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exchange.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUbahMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setPreferredSize(new java.awt.Dimension(90, 35));

        btnBatal.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(0, 102, 153));
        btnBatal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/remove.png"))); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBatalMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 204));
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnHapus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(0, 102, 153));
        btnHapus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/bin.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHapusMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 204));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnPrint.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(0, 102, 153));
        btnPrint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/printer.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPrintMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 204));
        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnExit.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnExit.setForeground(new java.awt.Color(0, 102, 153));
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Exitt.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnExitMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        txtPrint.setText("Masukan Kode Pinjam");
        txtPrint.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrintFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCariTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCariTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCariTbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrint))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMousePressed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnExitMousePressed

    private void btnSimpanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMousePressed
        // TODO add your handling code here:
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fd = sdf.format(txtTglPinjam.getValue());
         String fd2 = sdf.format(txtTglKem.getDate());
        
         String sql = "insert into pinjam values (?,?,?,?,?,?,?,?,?,?)"    ;
    try{
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, txtKdPin.getText());
        stat.setString(2, txtNis.getText());
        stat.setString(3, txtNmSiswa.getText());
        stat.setString(4, txtKdBuku.getText());
        stat.setString(5, txtJdl.getText());
        stat.setString(6, idPus.getText());
        stat.setString(7, txtNmPus.getText());
        stat.setString(8, fd);
        stat.setString(9, fd2);
        stat.setString(10, txtJmlPin.getText());
        
        stat.executeUpdate();
//        int t = tblPinjam.getRowCount();
//        for(int i=0; i<t;i++)
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        
        txtNis.requestFocus();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan" +e);
        }
    kosong();
    aktif();
   
    dataTabel();
    autoNumber();
    }//GEN-LAST:event_btnSimpanMousePressed

    private void btnUbahMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMousePressed
//         TODO add your handling code here:
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fd = sdf.format(txtTglPinjam.getValue());
         String fd2 = sdf.format(txtTglKem.getDate());
       
    
       try{
           String sql =" update pinjam set nis=?,nama_siswa=?,kd_buku=?,judul_buku=?,id_pustakawan=?,nama_pustakawan=?,tanggal_pinjam=?,tanggal_kembali=?,jumlah_pinjam=? WHERE kode_pinjam ='"+txtKdPin.getText()+"'";
           
          PreparedStatement stat = conn.prepareStatement(sql);
         stat.setString(1, txtNis.getText());
        stat.setString(2, txtNmSiswa.getText());
        stat.setString(3, txtKdBuku.getText());
        stat.setString(4, txtJdl.getText());
        stat.setString(5, idPus.getText());
        stat.setString(6, txtNmPus.getText());
        stat.setString(7, fd);
        stat.setString(8, fd2);
        stat.setString(9, txtJmlPin.getText());
          
          stat.executeUpdate();
          JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
          kosong();
          txtNis.requestFocus();
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Data Gagal Diubah" +e);
       }
       aktif();
       kosong();
       autoNumber();
       dataTabel();
    }//GEN-LAST:event_btnUbahMousePressed

    private void tblPinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPinjamMouseClicked
        // TODO add your handling code here:
        int index=tblPinjam.getSelectedRow();
       
       txtKdPin.setText((String)tabmode.getValueAt(index, 0));
    txtNis.setText((String)tabmode.getValueAt(index, 1));
    txtNmSiswa.setText((String)tabmode.getValueAt(index, 2));
    txtKdBuku.setText((String)tabmode.getValueAt(index, 3));
    txtJdl.setText((String)tabmode.getValueAt(index, 4));
    idPus.setText((String)tabmode.getValueAt(index, 5));
    txtNmPus.setText((String)tabmode.getValueAt(index, 6));
    try{
        int srow = tblPinjam.getSelectedRow();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)tabmode.getValueAt(srow, 7));
        txtTglPinjam.setValue(date);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String)tabmode.getValueAt(srow,8));
       
        txtTglKem.setDate(date2);
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    txtJmlPin.setText((String)tabmode.getValueAt(index, 9));
    }//GEN-LAST:event_tblPinjamMouseClicked

    private void btnBatalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMousePressed
        // TODO add your handling code here:
        aktif();
        kosong();
        dataTabel();
        autoNumber();
    }//GEN-LAST:event_btnBatalMousePressed

    private void btnHapusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMousePressed
        // TODO add your handling code here:
         int ok = JOptionPane.showConfirmDialog(null, "Hapus","Konfirmasi",JOptionPane.YES_NO_OPTION);
            if (ok==0){
                String sql = "DELETE FROM pinjam WHERE kode_pinjam='"+txtKdPin.getText()+"'";
                try{
                    PreparedStatement stat = conn.prepareStatement(sql);
                    stat.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    kosong();
                    txtNis.requestFocus();
                }catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus"+e);
                }
                aktif();
                dataTabel();
              //  autoNumber();
            }
    }//GEN-LAST:event_btnHapusMousePressed

    private void txtCariTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariTblActionPerformed
        
      
    }//GEN-LAST:event_txtCariTblActionPerformed

    private void txtCariTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariTblKeyPressed
        if (evt.getKeyCode()== KeyEvent.VK_ENTER){
           aktif();
           dataTabel();
       }
    }//GEN-LAST:event_txtCariTblKeyPressed

    private void btnCariTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariTblActionPerformed
        // TODO add your handling code here:
       
      aktif();
      dataTabel();
    }//GEN-LAST:event_btnCariTblActionPerformed

    private void btnCariNisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariNisActionPerformed
        // TODO add your handling code here:
        PopupAnggota pa = new PopupAnggota();
        pa.swa = this;
        pa.setVisible(true);
        pa.setResizable(false);
    }//GEN-LAST:event_btnCariNisActionPerformed

    private void btnCariPusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPusActionPerformed
        // TODO add your handling code here:
         PopupPustakawan pp = new PopupPustakawan();
        pp.pstkw = this;
        pp.setVisible(true);
        pp.setResizable(false);
    }//GEN-LAST:event_btnCariPusActionPerformed

    private void btnCariBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariBukuActionPerformed
        // TODO add your handling code here:
        PopupBuku pb = new PopupBuku();
        pb.bku = this;
        pb.setVisible(true);
        pb.setResizable(false);
    }//GEN-LAST:event_btnCariBukuActionPerformed

    private void txtPrintFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrintFocusGained
        // TODO add your handling code here:
        txtPrint.setText("");
    }//GEN-LAST:event_txtPrintFocusGained

    private void btnPrintMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMousePressed
    cetak();

    
    }//GEN-LAST:event_btnPrintMousePressed

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
            java.util.logging.Logger.getLogger(Pinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pinjam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBatal;
    private javax.swing.JButton btnCariBuku;
    private javax.swing.JButton btnCariNis;
    private javax.swing.JButton btnCariPus;
    private javax.swing.JButton btnCariTbl;
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnHapus;
    private javax.swing.JLabel btnPrint;
    private javax.swing.JLabel btnSimpan;
    private javax.swing.JLabel btnUbah;
    private javax.swing.JTextField idPus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPinjam;
    private javax.swing.JTextField txtCariTbl;
    private javax.swing.JTextField txtJdl;
    private javax.swing.JTextField txtJmlPin;
    private javax.swing.JTextField txtKdBuku;
    private javax.swing.JTextField txtKdPin;
    private javax.swing.JTextField txtNis;
    private javax.swing.JTextField txtNmPus;
    private javax.swing.JTextField txtNmSiswa;
    private javax.swing.JTextField txtPrint;
    private com.toedter.calendar.JDateChooser txtTglKem;
    private javax.swing.JSpinner txtTglPinjam;
    // End of variables declaration//GEN-END:variables

    
    private Date SimpleDateFormat(JDateChooser txtTglPinjam, String yyyMMdd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
