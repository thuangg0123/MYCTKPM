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
    private JButton theoMaHangButton, theoSLTonButton, theoDonGiaButton, theoTenHang, tempButton;
    private JPanel panel;

    /*
     * 0: Hàng thực phẩm
     * 1: Hàng điện máy
     * 2: Hàng sành sứ
     */
    public LoaiSapXep(QuanLyKhoGUI viewRemote, NguoiQuanLy modelRemote) {
        panel = new JPanel(new GridLayout(0, 4, 10, 10));

        theoMaHangButton = new JButton("Sắp xếp theo mã");
        theoMaHangButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelRemote.sapXepHH("maHang");
                dispose();
            }
        });

        theoSLTonButton = new JButton("Sắp xếp theo tồn kho");
        theoSLTonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelRemote.sapXepHH("soLuongTon");
                dispose();
            }
        });

        theoDonGiaButton = new JButton("Sắp xếp theo đơn giá");
        theoDonGiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelRemote.sapXepHH("donGia");
                dispose();
            }
        });

        theoTenHang = new JButton("Sắp xếp theo tên hàng");
        theoTenHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelRemote.sapXepHH("tenHang");
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
        panel.add(theoDonGiaButton);
        panel.add(theoTenHang);
        panel.add(tempButton);

        setTitle("Chọn thể loại sắp xếp");
        setSize(800, 100);
        setLocation(200, 200);
        setDefaultCloseOperation(LoaiHangHoa.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(panel);
    }
}
