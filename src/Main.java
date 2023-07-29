public class Main {
    public static void main(String[] args) {
        HangDienMay dienMay = new HangDienMay(0, null, 0, 0, null, 0);
        dienMay.tinhVAT(dienMay.getMaHang(), dienMay.getTenHang(), dienMay.getSoLuongTon(), dienMay.getDonGia());
    }
}
