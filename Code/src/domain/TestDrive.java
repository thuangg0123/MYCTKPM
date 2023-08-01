package domain;

import java.sql.Date;

public class TestDrive {
    public static void main(String[] args) {
        HangHoa temp = new HangDienMay("maHang", "tenHang",  3, 33.3, new Date(2023, 01, 01), "50W");
        temp.setCongSuat(33);
        temp.setCongSuat(35);
        System.out.println(temp.getCongSuat());
    }
}
