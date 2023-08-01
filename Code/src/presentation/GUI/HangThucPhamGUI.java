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

import domain.HangHoa;
import domain.HangThucPham;

public class HangThucPhamGUI extends JFrame{
    private JTextField maHangTextField, tenHangTextField, slTonTextField, donGiaTextField, ngaySXTextField, ngayHetHanTextField, nhaCungCapTextField;
    private JButton luuButton, huyButton;
    private int choice;

    /*
     Yêu cầu:
     0: Thêm mới hàng hóa
     1: Cập nhật lại thông tin hàng hóa
     */
    public HangThucPhamGUI(QuanLyKhoGUI viewRemote, int choice) {
        this.choice = choice;
        JPanel inputPanel;
        if(choice == 0) {
            inputPanel = new JPanel(new GridLayout(10, 2));
        } else {
            inputPanel = new JPanel(new GridLayout(9, 2));
        }
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
                viewRemote.getModelRemote().themHang(1, luuThongTin());
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
        if (choice == 0) {
            inputPanel.add(new JLabel("Mã hàng hóa:"));
            inputPanel.add(maHangTextField);
        }
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
        setDefaultCloseOperation(HangThucPhamGUI.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(inputPanel);
        setVisible(true);
    }

    private HangHoa luuThongTin() {
        String tenHang = tenHangTextField.getText();
        int slTon = Integer.parseInt(slTonTextField.getText());
        double donGia = Double.parseDouble(donGiaTextField.getText());
        Date ngaySX = java.sql.Date.valueOf(ngaySXTextField.getText());
        Date ngayHetHan = java.sql.Date.valueOf(ngayHetHanTextField.getText());
        String nhaCungCap = nhaCungCapTextField.getText();
        if(choice == 0) {
            String maHang = maHangTextField.getText();
            return (HangHoa)new HangThucPham(maHang, tenHang, slTon, donGia, ngaySX, ngayHetHan, nhaCungCap);
        } else {
            return (HangHoa)new HangThucPham(tenHang, slTon, donGia, ngaySX, ngayHetHan, nhaCungCap);
        }
    }
}
