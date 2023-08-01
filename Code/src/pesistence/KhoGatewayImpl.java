package pesistence;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.swing.JOptionPane;
import domain.*;


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
        String sql;
        switch(loaiHang) {
            case 1: 
                sql = "UPDATE hanghoa SET TenHangHoa = ?, slTonKho = ?, DonGia = ?, NgaySX = ?, NgayHetHan = ?, NhaCungCap = ? WHERE MaHangHoa = ?;";
                capnhatHangLoai1(sql, hanghoa);
                break;
            case 2: 
                sql = "UPDATE hanghoa SET TenHangHoa = ?, slTonKho = ?, DonGia = ?, ThoiGianBH = ?, CongSuat = ? WHERE MaHangHoa = ?;";
                capnhatHangLoai23(true, sql, hanghoa);
                break;

            case 3: 
                sql = "UPDATE hanghoa SET TenHangHoa = ?, slTonKho = ?, DonGia = ?, NgayNhapKho = ?, NhaSX = ? WHERE MaHangHoa = ?;";
                capnhatHangLoai23(false, sql, hanghoa);
                break;
        }
    }

    private void capnhatHangLoai1(String sql, HangHoa hanghoa) {
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, hanghoa.getTenHang());
                statement.setInt(2, hanghoa.getSoLuongTon());
                statement.setDouble(3, hanghoa.getDonGia());
                statement.setDate(4,new Date(hanghoa.getNgaySX().getTime()));
                statement.setDate(5, new Date(hanghoa.getNgayHetHan().getTime()));
                statement.setString(6, hanghoa.getNhaCungCap());
                statement.setString(7, hanghoa.getMaHang());
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Cập nhật mặt thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy mặt hàng có mã tương ứng", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println(throwable.getMessage());
        }
    }

    private void capnhatHangLoai23(boolean loai2, String sql, HangHoa hanghoa) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, hanghoa.getTenHang());
            statement.setInt(2, hanghoa.getSoLuongTon());
            statement.setDouble(3, hanghoa.getDonGia());
            if (loai2) {
                statement.setString(4,hanghoa.getThoiGianBH());
                statement.setString(5, hanghoa.getCongSuat());
            } else{
                statement.setDate(4,new Date(hanghoa.getNgayNhapKho().getTime()));
                statement.setString(5, hanghoa.getNhaSanXuat());
            }
            statement.setString(6, hanghoa.getMaHang());

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
    public void themHang(int loaiHang, HangHoa hanghoa) {
        String sql;
        switch(loaiHang) {
            case 1: 
                sql = "INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, NgaySX, NgayHetHan, NhaCungCap) VALUES (?, ?, ?, ?, ?, ?, ?);";
                themHangLoai1(sql, hanghoa);
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

    private void themHangLoai1(String sql, HangHoa hanghoa) {
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
                statement.setString(5,hanghoa.getThoiGianBH());
                statement.setString(6, hanghoa.getCongSuat());
            } else{
                statement.setDate(5,new Date(hanghoa.getNgayNhapKho().getTime()));
                statement.setString(6, hanghoa.getNhaSanXuat());
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
                String ThoiGianBH = resultSet.getString("ThoiGianBH");
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
    public void xoaHang(String maHang) {
        try {
            String query = "DELETE FROM hanghoa WHERE MaHangHoa = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, maHang);

                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Xóa mặt hàng thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy mặt hàng có mã tương ứng", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println(throwable.getMessage());
        }
    }
    
    @Override
    public HangHoa getDuLieu(String maHang) {
        HangHoa hanghoa = null;
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM hanghoa where MaHangHoa = '" + maHang + "';";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String tenHang = resultSet.getString("TenHangHoa");
                int slTonKho = resultSet.getInt("slTonKho");
                Double DonGia = resultSet.getDouble("DonGia");
                Date NgaySX = resultSet.getDate("NgaySX");
                Date NgayHetHan = resultSet.getDate("NgayHetHan");
                String NhaCungCap = resultSet.getString("NhaCungCap");
                String ThoiGianBH = resultSet.getString("ThoiGianBH");
                String CongSuat = resultSet.getString("CongSuat");
                Date NgayNhapKho = resultSet.getDate("NgayNhapKho");
                String NhaSX = resultSet.getString("NhaSX");
                
                if(NhaCungCap != null && !NhaCungCap.isEmpty()) {
                    hanghoa = new HangThucPham(maHang, tenHang, slTonKho, DonGia, NgaySX, NgayHetHan, NhaCungCap);
                    return hanghoa;
                } else if(CongSuat != null && !CongSuat.isEmpty()) {
                    hanghoa = new HangDienMay(maHang, tenHang, slTonKho, DonGia, ThoiGianBH, CongSuat);
                    return hanghoa;
                } else if(NhaSX != null && !NhaSX.isEmpty()) {
                    hanghoa = new HangSanhSu(maHang, tenHang, slTonKho, DonGia, NgayNhapKho, NhaSX);
                    return hanghoa;
                }
            }
        }  catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }
}
