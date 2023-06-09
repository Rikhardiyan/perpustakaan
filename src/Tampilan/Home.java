
package Tampilan;

import java.sql.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import koneksi.koneksi;

public class Home extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();

    /**
     * Creates new form Dasboard
     */
    public Home() {
        initComponents();
        
        akses();
        
        setExtendedState(Pustakawan.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
    }
    
    protected void akses(){
        String KD = UserID.getUserLogin();
        
        try{
            String sql = "SELECT * FROM user WHERE id_user='"+KD+"'";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()){
                if(hasil.getString("username").equals("Pustakawan")){
                    user.setVisible(false);
                }else if (hasil.getString("username").equals("Anggota")){
                    peminjaman.setVisible(false);
                    pengembalian.setVisible(false);
                    pustakawan.setVisible(false);
                    laporan.setVisible(false);
                    user.setVisible(false);
                    daftarBuku.setVisible(false);
                    anggota.setVisible(false);
                }else if (hasil.getString("username").equals("Admin")){
                    
                    
                    JOptionPane.showMessageDialog(null, "Selamat Datang Admin");
                }else{
                peminjaman.setVisible(false);
                pengembalian.setVisible(false);
                anggota.setVisible(false);
                pustakawan.setVisible(false);
                laporan.setVisible(false);
                user.setVisible(false);
                daftarBuku.setVisible(false);
            }
        }
    }catch (SQLException e){
        
    }
        
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUtamaHome = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        daftarBuku = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pustakawan = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        anggota = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        peminjaman = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pengembalian = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        laporan = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        user = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pustakaBuku = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelUtamaHome.setBackground(new java.awt.Color(255, 255, 204));
        panelUtamaHome.setPreferredSize(new java.awt.Dimension(985, 780));

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Home");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/home_1.png"))); // NOI18N

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/power-off.png"))); // NOI18N
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logout)
                            .addComponent(jLabel5))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        daftarBuku.setBackground(new java.awt.Color(255, 243, 160));
        daftarBuku.setPreferredSize(new java.awt.Dimension(213, 120));
        daftarBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                daftarBukuMousePressed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/book blue 64px.png"))); // NOI18N
        jLabel1.setText("Buku");

        javax.swing.GroupLayout daftarBukuLayout = new javax.swing.GroupLayout(daftarBuku);
        daftarBuku.setLayout(daftarBukuLayout);
        daftarBukuLayout.setHorizontalGroup(
            daftarBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(daftarBukuLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        daftarBukuLayout.setVerticalGroup(
            daftarBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, daftarBukuLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(50, 50, 50))
        );

        pustakawan.setBackground(new java.awt.Color(255, 243, 160));
        pustakawan.setPreferredSize(new java.awt.Dimension(213, 164));
        pustakawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pustakawanMousePressed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/write Blue.png"))); // NOI18N
        jLabel2.setText("Pustakawan");

        javax.swing.GroupLayout pustakawanLayout = new javax.swing.GroupLayout(pustakawan);
        pustakawan.setLayout(pustakawanLayout);
        pustakawanLayout.setHorizontalGroup(
            pustakawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pustakawanLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(41, 41, 41))
        );
        pustakawanLayout.setVerticalGroup(
            pustakawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pustakawanLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        anggota.setBackground(new java.awt.Color(255, 243, 160));
        anggota.setPreferredSize(new java.awt.Dimension(213, 164));
        anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                anggotaMousePressed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 102, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reading Blue.png"))); // NOI18N
        jLabel3.setText("Anggota");

        javax.swing.GroupLayout anggotaLayout = new javax.swing.GroupLayout(anggota);
        anggota.setLayout(anggotaLayout);
        anggotaLayout.setHorizontalGroup(
            anggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, anggotaLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(58, 58, 58))
        );
        anggotaLayout.setVerticalGroup(
            anggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anggotaLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        peminjaman.setBackground(new java.awt.Color(255, 243, 160));
        peminjaman.setPreferredSize(new java.awt.Dimension(213, 120));
        peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                peminjamanMousePressed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 102, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/peminjaman buku.png"))); // NOI18N
        jLabel6.setText("Peminjaman");

        javax.swing.GroupLayout peminjamanLayout = new javax.swing.GroupLayout(peminjaman);
        peminjaman.setLayout(peminjamanLayout);
        peminjamanLayout.setHorizontalGroup(
            peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, peminjamanLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(30, 30, 30))
        );
        peminjamanLayout.setVerticalGroup(
            peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(peminjamanLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel6)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pengembalian.setBackground(new java.awt.Color(255, 243, 160));
        pengembalian.setPreferredSize(new java.awt.Dimension(213, 120));
        pengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pengembalianMousePressed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 102, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/delivering.png"))); // NOI18N
        jLabel7.setText("Pengembalian");

        javax.swing.GroupLayout pengembalianLayout = new javax.swing.GroupLayout(pengembalian);
        pengembalian.setLayout(pengembalianLayout);
        pengembalianLayout.setHorizontalGroup(
            pengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pengembalianLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(30, 30, 30))
        );
        pengembalianLayout.setVerticalGroup(
            pengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengembalianLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel7)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        laporan.setBackground(new java.awt.Color(255, 243, 160));
        laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                laporanMousePressed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 102, 153));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/notes.png"))); // NOI18N
        jLabel8.setText("Laporan");

        javax.swing.GroupLayout laporanLayout = new javax.swing.GroupLayout(laporan);
        laporan.setLayout(laporanLayout);
        laporanLayout.setHorizontalGroup(
            laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laporanLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        laporanLayout.setVerticalGroup(
            laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laporanLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        user.setBackground(new java.awt.Color(255, 243, 160));
        user.setPreferredSize(new java.awt.Dimension(213, 120));
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userMousePressed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 102, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/User 64px.png"))); // NOI18N
        jLabel9.setText("User");

        javax.swing.GroupLayout userLayout = new javax.swing.GroupLayout(user);
        user.setLayout(userLayout);
        userLayout.setHorizontalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel9)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        userLayout.setVerticalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pustakaBuku.setBackground(new java.awt.Color(255, 243, 160));
        pustakaBuku.setPreferredSize(new java.awt.Dimension(213, 120));
        pustakaBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pustakaBukuMousePressed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(0, 102, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/open-book 64px.png"))); // NOI18N
        jLabel10.setText("Daftar Buku");

        javax.swing.GroupLayout pustakaBukuLayout = new javax.swing.GroupLayout(pustakaBuku);
        pustakaBuku.setLayout(pustakaBukuLayout);
        pustakaBukuLayout.setHorizontalGroup(
            pustakaBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pustakaBukuLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(42, 42, 42))
        );
        pustakaBukuLayout.setVerticalGroup(
            pustakaBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pustakaBukuLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel10)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelUtamaHomeLayout = new javax.swing.GroupLayout(panelUtamaHome);
        panelUtamaHome.setLayout(panelUtamaHomeLayout);
        panelUtamaHomeLayout.setHorizontalGroup(
            panelUtamaHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelUtamaHomeLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(panelUtamaHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(daftarBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelUtamaHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUtamaHomeLayout.createSequentialGroup()
                        .addGroup(panelUtamaHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pustakawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pustakaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(panelUtamaHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(anggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(pengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        panelUtamaHomeLayout.setVerticalGroup(
            panelUtamaHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtamaHomeLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelUtamaHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(anggota, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pustakawan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(daftarBuku, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(panelUtamaHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pustakaBuku, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(user, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(panelUtamaHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pengembalian, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(peminjaman, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtamaHome, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelUtamaHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void daftarBukuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftarBukuMousePressed
        DaftarBuku frmDB = new DaftarBuku();
        frmDB.setVisible(true);
    }//GEN-LAST:event_daftarBukuMousePressed

    private void pustakawanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pustakawanMousePressed
        Pustakawan frmP = new Pustakawan();
        frmP.setVisible(true);
    }//GEN-LAST:event_pustakawanMousePressed

    private void anggotaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anggotaMousePressed
        // TODO add your handling code here:
        Anggota frmA = new Anggota();
        frmA.setVisible(true);
    }//GEN-LAST:event_anggotaMousePressed

    private void peminjamanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_peminjamanMousePressed
        // TODO add your handling code here:
        Pinjam frmPin = new Pinjam();
        frmPin.setVisible(true);
    }//GEN-LAST:event_peminjamanMousePressed

    private void laporanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanMousePressed
        // TODO add your handling code here:
        Laporan frmL = new Laporan();
        frmL.setVisible(true);
    }//GEN-LAST:event_laporanMousePressed

    private void userMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMousePressed
       User frmU = new User();
       frmU.setVisible(true);
    }//GEN-LAST:event_userMousePressed

    private void pustakaBukuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pustakaBukuMousePressed
        Buku dftB = new Buku();
        dftB.setVisible(true);
    }//GEN-LAST:event_pustakaBukuMousePressed

    private void pengembalianMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pengembalianMousePressed
        // TODO add your handling code here:
        Pengembalian frmKem = new Pengembalian();
        frmKem.setVisible(true);
    }//GEN-LAST:event_pengembalianMousePressed

    private void logoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMousePressed
        dispose();
        Home home = new Home();
        home.removeAll();
        Login loginForm = new Login();
        loginForm.setVisible(true);
        home.setVisible(false);
        loginForm.setVisible(true);
       
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutMousePressed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel anggota;
    private javax.swing.JPanel daftarBuku;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel laporan;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel panelUtamaHome;
    private javax.swing.JPanel peminjaman;
    private javax.swing.JPanel pengembalian;
    private javax.swing.JPanel pustakaBuku;
    private javax.swing.JPanel pustakawan;
    private javax.swing.JPanel user;
    // End of variables declaration//GEN-END:variables

   
}
