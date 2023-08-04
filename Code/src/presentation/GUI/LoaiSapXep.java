package presentation.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.*;

public class LoaiSapXep extends JFrame{
    private JButton theoMaHangButton, theoSLTonButton, tempButton;
    private JPanel panel;

    /*
     0: Hàng thực phẩm
     1: Hàng điện máy
     2: Hàng sành sứ
     */
    public LoaiSapXep(QuanLyKhoGUI viewRemote, NguoiQuanLy modelRemote) {
        panel = new JPanel(new GridLayout(0,3,10,10));

        theoMaHangButton = new JButton("Sắp xếp theo mã");
        theoMaHangButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelRemote.sapXepSanPham("maHang");
                dispose();
            }
        });

        theoSLTonButton = new JButton("Sắp xếp theo tồn kho");
        theoSLTonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelRemote.sapXepSanPham("soLuongTon");
                dispose();
            }
        });

        tempButton = new JButton("temp");
        tempButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(theoMaHangButton);
        panel.add(theoSLTonButton);
        panel.add(tempButton);

        setTitle("Chọn thể loại sắp xếp");
        setSize(500, 100);
        setLocation(760, 390);    
        setDefaultCloseOperation(LoaiHangHoa.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(panel);
    }
}
