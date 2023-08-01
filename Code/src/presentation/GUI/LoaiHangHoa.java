package presentation.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoaiHangHoa extends JFrame{
    private JButton thucphamButton, dienmayButton, sanhsuButton;
    private JPanel panel;

    public LoaiHangHoa(QuanLyKhoGUI viewRemote) {
        panel = new JPanel(new GridLayout(0,3,10,10));
        thucphamButton = new JButton("Thực phẩm");
        thucphamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HangThucPhamGUI(viewRemote, 0).setVisible(true);
                dispose();
            }
        });

        dienmayButton = new JButton("Điện máy");
        dienmayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HangDienMayGUI(viewRemote, 0).setVisible(true);
                dispose();
            }
        });

        sanhsuButton = new JButton("Sành sứ");
        sanhsuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HangSanhSuGUI(viewRemote, 0).setVisible(true);
                dispose();
            }
        });
        panel.add(thucphamButton);
        panel.add(dienmayButton);
        panel.add(sanhsuButton);

        setTitle("Chọn loại hàng hóa");
        setSize(500, 100);
        setLocation(760, 390);    
        setDefaultCloseOperation(LoaiHangHoa.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(panel);
        setVisible(true);
    }
}
