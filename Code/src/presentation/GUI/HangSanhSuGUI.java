package presentation.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HangSanhSuGUI extends JFrame{
    JTextField maHangTextField, tenHangTextField, slTonTextField, donGiaTextField, ngayNhapKhoTextField, nhaSXTextField;
    JButton luuButton, huyButton;

    public HangSanhSuGUI() {
        JPanel inputPanel = new JPanel(new GridLayout(9, 2));
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
        inputPanel.add(new JLabel("Mã hàng hóa:"));
        inputPanel.add(maHangTextField);
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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(inputPanel);
        setVisible(true);
    }
}
