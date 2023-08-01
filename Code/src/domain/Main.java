package domain;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        HangDienMay hdm = new HangDienMay("123", "Tivi", 10, 5000000, new Date(2023, 6, 3), 100);

        HangHoa hd = hdm;
        String congSuat = hd.getCongSuat(hdm);
        System.out.println("Công suất: " + congSuat);
    }
}
