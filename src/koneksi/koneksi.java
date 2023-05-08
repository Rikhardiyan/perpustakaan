
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class koneksi {
     private Connection koneksi;
    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("berhasil cennect");
        }catch( ClassNotFoundException ex){
            System.out.println("gagal connect"+ex);
        }
        String url = "jdbc:mysql://localhost/perpustakaan";
        try{
            koneksi = DriverManager.getConnection(url, "root", "");
            System.out.println("brhasil connect database");
        }catch(SQLException ex) {
            System.out.println("gagal koneksi database"+ex);
        }
        return koneksi;
    }
}

