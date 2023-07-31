import java.util.Date;
import java.util.Scanner;

public class HangThucPham extends HangHoa {
    private Date ngaySX;
    private Date ngayHetHan;
    private String nhaCungCap;

    public HangThucPham(int maHang, String tenHang, int soLuongTon, int donGia, Date ngaySX,
            Date ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.ngaySX = ngaySX;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public void tinhVAT(int maHang, String tenHang, int soLuongTon, int donGia) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã hàng: ");
        maHang = scanner.nextInt();
        System.out.print("Nhập tên hàng: ");

        scanner.nextLine();
        tenHang = scanner.nextLine();

        System.out.print("Nhập số lượng tồn: ");
        soLuongTon = scanner.nextInt();

        System.out.print("Nhập đơn giá: ");
        donGia = scanner.nextInt();

        double tinhVAT = 0.05 * (double) donGia;

        System.out.println(">>>> VAT của Hang Dien May: " + tinhVAT);
    }
}
