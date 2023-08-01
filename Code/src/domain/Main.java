package domain;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        HangHoa hd= new HangDienMay("123", "Tivi", 10, 5000000, new Date(2023, 6, 3), 100);

        String congSuat = hd.getCongSuat();
        System.out.println("Công suất: " + congSuat);
    }
}
