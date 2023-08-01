package pesistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import domain.HangDienMay;
import domain.HangHoa;
import domain.HangSanhSu;
import domain.HangThucPham;

public class KhoGatewayImpl implements KhoGateway{
    private Connection connection;

    public KhoGatewayImpl() {
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
        String sql;
        switch(loaiHang) {
            case 1: 
                sql = "INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, NgaySX, NgayHetHan, NhaCungCap) VALUES (?, ?, ?, ?, ?, ?, ?);";
                themHangLoai1(sql, (HangThucPham)hanghoa);
                break;
            case 2: 
                sql = "INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, ThoiGianBH, CongSuat) VALUES (?, ?, ?, ?, ?, ?);";
                themHangLoai23(true, sql, hanghoa);
                break;

            case 3: 
                sql = "INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, NgayNhapKho, NhaSX) VALUES (?, ?, ?, ?, ?, ?);";
                themHangLoai23(false, sql, hanghoa);
                break;

        }
        
    }

    private void themHangLoai1(String sql, HangThucPham hanghoa) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, hanghoa.getMaHang());
            statement.setString(2, hanghoa.getTenHang());
            statement.setInt(3, hanghoa.getSoLuongTon());
            statement.setDouble(4, hanghoa.getDonGia());
            statement.setDate(5,new Date(hanghoa.getNgaySX().getTime()));
            statement.setDate(6, new Date(hanghoa.getNgayHetHan().getTime()));
            statement.setString(7, hanghoa.getNhaCungCap());
            if (statement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Thêm mặt hàng thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mặt hàng không thành công", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void themHangLoai23(boolean loai2, String sql, HangHoa hanghoa) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, hanghoa.getMaHang());
            statement.setString(2, hanghoa.getTenHang());
            statement.setInt(3, hanghoa.getSoLuongTon());
            statement.setDouble(4, hanghoa.getDonGia());
            if (loai2) {
                HangDienMay temp = (HangDienMay)hanghoa;
                statement.setDate(5,new Date(temp.getThoiGianBH().getTime()));
                statement.setString(6, temp.getCongSuat());
            } else{
                HangSanhSu temp = (HangSanhSu)hanghoa;
                statement.setDate(5,new Date(temp.getNgayNhapKho().getTime()));
                statement.setString(6, temp.getNhaSanXuat());
            }

            if (statement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Thêm mặt hàng thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mặt hàng không thành công", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HangHoa> timTTHH(String thongtin) {
        String sql = "call TimKiem('"+thongtin+"')";
        try (Statement statement = connection.createStatement()) {
            int rowsInserted = statement.executeUpdate(sql);
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Có "+ rowsInserted + " mặt hàng thỏa điều kiện tìm kiếm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Không có mặt hàng nào thỏa điều kiện tìm kiếm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
                
            ResultSet resultSet = statement.executeQuery(sql);
            return kqTruySuat(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<HangHoa> xemTTAllHH() {
        String sql = "SELECT * FROM hanghoa";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            
            return kqTruySuat(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<HangHoa> kqTruySuat(ResultSet resultSet) {
        List<HangHoa> hanghoaList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String maHang = resultSet.getString("MaHangHoa");
                String tenHang = resultSet.getString("TenHangHoa");
                int slTonKho = resultSet.getInt("slTonKho");
                Double DonGia = resultSet.getDouble("DonGia");
                Date NgaySX = resultSet.getDate("NgaySX");
                Date NgayHetHan = resultSet.getDate("NgayHetHan");
                String NhaCungCap = resultSet.getString("NhaCungCap");
                Date ThoiGianBH = resultSet.getDate("ThoiGianBH");
                String CongSuat = resultSet.getString("CongSuat");
                Date NgayNhapKho = resultSet.getDate("NgayNhapKho");
                String NhaSX = resultSet.getString("NhaSX");
                
                if(NhaCungCap != null && !NhaCungCap.isEmpty()) {
                    hanghoaList.add(new HangThucPham(maHang, tenHang, slTonKho, DonGia, NgaySX, NgayHetHan, NhaCungCap));
                } else if(CongSuat != null && !CongSuat.isEmpty()) {
                    hanghoaList.add(new HangDienMay(maHang, tenHang, slTonKho, DonGia, ThoiGianBH, CongSuat));
                } else if(NhaSX != null && !NhaSX.isEmpty()) {
                    hanghoaList.add(new HangSanhSu(maHang, tenHang, slTonKho, DonGia, NgayNhapKho, NhaSX));
                }
            }
            return hanghoaList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void xemTTHH(String maHang) {
        
    }

    @Override
    public void xoaHang(String maHang) {
        
    }
    
}
