package presentation.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.*;
import presentation.*;
import presentation.Command.*;

public class HangSanhSuGUI extends JFrame{
    private JTextField maHangTextField, tenHangTextField, slTonTextField, donGiaTextField, ngayNhapKhoTextField, nhaSXTextField;
    private JButton luuButton, huyButton;
    private int choice;
    private String maHang;

    /*
     Yêu cầu:
     0: Thêm mới hàng hóa
     1: Cập nhật lại thông tin hàng hóa
     */
    public HangSanhSuGUI(QuanLyKhoGUI viewRemote, NguoiQuanLy modelRemote, QuanLyKhoController controllerRemote, int choice) {
        this.choice = choice;
        JPanel inputPanel;
        if (choice == 0) {
            inputPanel = new JPanel(new GridLayout(9, 2));
        } else {
            inputPanel = new JPanel(new GridLayout(8, 2));
        }
        maHangTextField = new JTextField();
        tenHangTextField = new JTextField();
        slTonTextField = new JTextField();
        donGiaTextField = new JTextField();
        ngayNhapKhoTextField = new JTextField();
        nhaSXTextField = new JTextField();
        luuButton = new JButton("Lưu");
        huyButton = new JButton("Hủy");

        luuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Command themHH = new Them(modelRemote, 3, luuThongTin());
                controllerRemote.execute(themHH);
                dispose();
            }
        });
        huyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        if(choice == 0) {
            inputPanel.add(new JLabel("Mã hàng hóa:"));
            inputPanel.add(maHangTextField);
        }
        inputPanel.add(new JLabel("Tên hàng hóa:"));
        inputPanel.add(tenHangTextField);
        inputPanel.add(new JLabel("Số lượng tồn kho:"));
        inputPanel.add(slTonTextField);
        inputPanel.add(new JLabel("Đơn giá:"));
        inputPanel.add(donGiaTextField);
        inputPanel.add(new JLabel("Ngày nhập kho:"));
        inputPanel.add(ngayNhapKhoTextField);
        inputPanel.add(new JLabel("Nhà sản Xuất:"));
        inputPanel.add(nhaSXTextField);
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(luuButton);
        inputPanel.add(huyButton);
        
        setTitle("Hàng sành sứ");
        setSize(600, 300);
        setLocation(660, 390);    
        setDefaultCloseOperation(HangSanhSuGUI.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(inputPanel);
    }

    private HangHoa luuThongTin() {
        String tenHang = tenHangTextField.getText();
        int slTon = Integer.parseInt(slTonTextField.getText());
        double donGia = Double.parseDouble(donGiaTextField.getText());
        Date ngayNhapKho = java.sql.Date.valueOf(ngayNhapKhoTextField.getText());
        String nhaSX = nhaSXTextField.getText();
        if (choice == 0) {
            maHang = maHangTextField.getText();
        }
        return (HangHoa)new HangSanhSu(maHang, tenHang, slTon, donGia, ngayNhapKho, nhaSX);

    }
    public JTextField getMaHangTextField() {
        return maHangTextField;
    }
    public JTextField getTenHangTextField() {
        return tenHangTextField;
    }
    public JTextField getSlTonTextField() {
        return slTonTextField;
    }
    public JTextField getDonGiaTextField() {
        return donGiaTextField;
    }
    public JTextField getNgayNhapKhoTextField() {
        return ngayNhapKhoTextField;
    }
    public JTextField getNhaSXTextField() {
        return nhaSXTextField;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }
}
