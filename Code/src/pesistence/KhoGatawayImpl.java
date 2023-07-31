package pesistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import domain.HangHoa;

public class KhoGatawayImpl implements KhoGataway{
    private Connection connection;

    KhoGatawayImpl() {
        String DB_NAME = "jdbc_db";
        String DB_URL = "jdbc:mysql://localhost:3306/";
        String USER_NAME = "root";
        String PASSWORD = "123456789";
        try {
            connection = DriverManager.getConnection(DB_URL + DB_NAME, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Kết nối không thành công \n" + e.toString(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void capnhatHang(int loaiHang, HangHoa hanghoa) {
        
    }

    @Override
    public void themHang(int loaiHang, HangHoa hanghoa) {
        
    }

    @Override
    public void timTTHH(String thongtin) {
        
    }

    @Override
    public List<HangHoa> xemTTAllHH() {

        return null;
    }

    @Override
    public void xemTTHH(String maHang) {
        
    }

    @Override
    public void xoaHang(String maHang) {
        
    }
    
}
