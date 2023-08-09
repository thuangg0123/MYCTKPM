package presentation.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.*;

public class LoaiSapXep extends JFrame {
    private JButton theoMaHangButton, theoSLTonButton, theoDonGiaButton, theoTenHang;
    private JPanel panel;

    public LoaiSapXep(QuanLyKhoGUI viewRemote) {
        Facade facadeRemote = Facade.getInstance();
        panel = new JPanel(new GridLayout(0, 4, 10, 10));

        theoMaHangButton = new JButton("Theo mã");
        theoMaHangButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facadeRemote.sapXepHH("maHang");
                dispose();
            }
        });

        theoSLTonButton = new JButton("Theo số lượng tồn kho");
        theoSLTonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facadeRemote.sapXepHH("soLuongTon");
                dispose();
            }
        });

        theoDonGiaButton = new JButton("Theo đơn giá");
        theoDonGiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facadeRemote.sapXepHH("donGia");
                dispose();
            }
        });

        theoTenHang = new JButton("Theo tên");
        theoTenHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facadeRemote.sapXepHH("tenHang");
                dispose();
            }
        });

        panel.add(theoMaHangButton);
        panel.add(theoTenHang);
        panel.add(theoSLTonButton);
        panel.add(theoDonGiaButton);

        setTitle("Chọn thể loại sắp xếp");
        setSize(800, 100);
        setLocation(560, 490);
        setDefaultCloseOperation(LoaiSapXep.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        add(panel);
    }
}
