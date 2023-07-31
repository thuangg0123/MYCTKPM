import java.util.Date;
import java.util.Scanner;

public class HangDienMay extends HangHoa {
    private Date thoiGianBH;
    private int congSuat;

    public HangDienMay(int maHang, String tenHang, int soLuongTon, int donGia, Date thoiGianBH, int congSuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.thoiGianBH = thoiGianBH;
        this.congSuat = congSuat;
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

        double tinhVAT = 0.1 * (double) donGia;

        System.out.println(">>>> VAT của Hang Dien May: " + tinhVAT);
    }
}
