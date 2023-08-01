package presentation.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.HangDienMay;
import domain.HangHoa;

public class HangDienMayGUI extends JFrame{
    private JTextField maHangTextField, tenHangTextField, slTonTextField, donGiaTextField, tgBaoHanhTextField, congSuatTextField;
    private JButton luuButton, huyButton;
    private int choice;

    /*
     Yêu cầu:
     0: Thêm mới hàng hóa
     1: Cập nhật lại thông tin hàng hóa
     */
    public HangDienMayGUI(QuanLyKhoGUI viewRemote, int choice) {
        this.choice = choice;
        JPanel inputPanel;
        if(choice == 0) {
            inputPanel = new JPanel(new GridLayout(9, 2));
        } else {
            inputPanel = new JPanel(new GridLayout(8, 2));
        }
        maHangTextField = new JTextField();
        tenHangTextField = new JTextField();
        slTonTextField = new JTextField();
        donGiaTextField = new JTextField();
        tgBaoHanhTextField = new JTextField();
        congSuatTextField = new JTextField();
        luuButton = new JButton("Lưu");
        huyButton = new JButton("Hủy");

        luuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewRemote.getModelRemote().themHang(2, luuThongTin());
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
        inputPanel.add(new JLabel("Thời gian bảo hành:"));
        inputPanel.add(tgBaoHanhTextField);
        inputPanel.add(new JLabel("Công suất:"));
        inputPanel.add(congSuatTextField);
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(luuButton);
        inputPanel.add(huyButton);
        
        setTitle("Hàng điện máy");
        setSize(600, 300);
        setLocation(660, 390);    
        setDefaultCloseOperation(HangDienMayGUI.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(inputPanel);
        setVisible(true);
    }

    private HangHoa luuThongTin() {
        String tenHang = tenHangTextField.getText();
        int slTon = Integer.parseInt(slTonTextField.getText());
        double donGia = Double.parseDouble(donGiaTextField.getText());
        Date tgBaoHanh = java.sql.Date.valueOf(tgBaoHanhTextField.getText());
        String congSuat = congSuatTextField.getText();
        if(choice == 0) {
            String maHang = maHangTextField.getText();
            return (HangHoa)new HangDienMay(maHang, tenHang, slTon, donGia, tgBaoHanh, congSuat);
        } else {
            return (HangHoa)new HangDienMay(tenHang, slTon, donGia, tgBaoHanh, congSuat);
        }
    }
}
