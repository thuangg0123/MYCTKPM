public abstract class HangHoa {
    protected String maHang;
    protected String tenHang;
    protected int soLuongTon;
    protected double donGia;

    HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
    }

    abstract void tinhVAT();
}
