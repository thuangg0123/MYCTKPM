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

public class HangThucPhamGUI extends JFrame{
    JTextField maHangTextField, tenHangTextField, slTonTextField, donGiaTextField, ngaySXTextField, ngayHetHanTextField, nhaCungCapTextField;
    JButton luuButton, huyButton;

    public HangThucPhamGUI() {
        JPanel inputPanel = new JPanel(new GridLayout(10, 2));
        maHangTextField = new JTextField();
        tenHangTextField = new JTextField();
        slTonTextField = new JTextField();
        donGiaTextField = new JTextField();
        ngaySXTextField = new JTextField();
        ngayHetHanTextField = new JTextField();
        nhaCungCapTextField = new JTextField();
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
        inputPanel.add(new JLabel("Ngày sản suất:"));
        inputPanel.add(ngaySXTextField);
        inputPanel.add(new JLabel("Ngày hết hạn:"));
        inputPanel.add(ngayHetHanTextField);
        inputPanel.add(new JLabel("Nhà cung cấp:"));
        inputPanel.add(nhaCungCapTextField);
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(luuButton);
        inputPanel.add(huyButton);
        
        setTitle("Hàng thực phẩm");
        setSize(600, 300);
        setLocation(660, 390);    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(inputPanel);
        setVisible(true);
    }
}
