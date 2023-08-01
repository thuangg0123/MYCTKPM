package presentation.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoaiHangHoa extends JFrame{
    JButton thucphamButton, dienmayButton, sanhsuButton;
    JPanel panel;

    public LoaiHangHoa() {

        panel = new JPanel(new GridLayout(0,5,10,10));
        thucphamButton = new JButton("Thực phẩm");
        dienmayButton = new JButton("Điện  máy");
        sanhsuButton = new JButton("Sành sứ");
        panel.add(new Label());
        panel.add(thucphamButton);
        panel.add(dienmayButton);
        panel.add(sanhsuButton);
        panel.add(new Label());

        setTitle("Chọn loại hàng hóa");
        setSize(500, 100);
        setLocation(760, 390);    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(panel);
        setVisible(true);
    }
}
