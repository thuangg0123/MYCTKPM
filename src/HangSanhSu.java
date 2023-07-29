import java.util.Date;
import java.util.Scanner;

public class HangSanhSu extends HangHoa {
    private Date ngayNhapKho;
    private String nhaSanXuat;

    public HangSanhSu(int maHang, String tenHang, int soLuongTon, int donGia, Date ngayNhapKho, String nhaSanXuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.ngayNhapKho = ngayNhapKho;
        this.nhaSanXuat = nhaSanXuat;
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

        System.out.println(">>>> VAT của Hang Sanh Su: " + tinhVAT);
    }
}
