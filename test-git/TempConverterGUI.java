/*
*  created date: Jul 17, 2023
*  author: cgm
*/
package tuan7;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//view
public class TempConverterGUI extends JPanel implements Subscriber, java.awt.event.ActionListener {

    // fields
    private String title;
    private JLabel celJLabelRemote;
    private JLabel fahJLabelRemote;
    private JTextField celJTextFieldRemote;
    private JTextField fahJTextFieldRemote;

    // private TempConverterController controllerRemote;
    private CommandProcessor commandProcessor;
    private TempConverter modelRemote;

    // constructor
    public TempConverterGUI() {

        // COMPOSITION
        // controllerRemote = new TempConverterController();
        commandProcessor = new CommandProcessor();

        // truyen view vao controller qua setter
        // controllerRemote.setViewRemote(this);

        // đã tồn tại rồi
        modelRemote = new TempConverter();// PUBLISHER

        // DANG KY VOI PUBLISHER
        modelRemote.subscribe(this);

        title = "Temperature Converter";
        celJLabelRemote = new JLabel("Celsius");
        fahJLabelRemote = new JLabel("Fahrenheit");

        celJTextFieldRemote = new JTextField("0.0", 10);
        fahJTextFieldRemote = new JTextField("32.0", 10);
        // đăng ký đố tượng lắng nghe - controller
        celJTextFieldRemote.addActionListener(this);
        // fahJTextFieldRemote.addActionListener(controllerRemote);

        // dua vao JPanel
        add(celJLabelRemote);
        add(celJTextFieldRemote);
        add(fahJLabelRemote);
        add(fahJTextFieldRemote);
    }

    // methods
    public void display() {
        JFrame jFrameRemote = new JFrame(title);
        jFrameRemote.add(this);
        jFrameRemote.pack();// set size
        // dong cua so => thoat app
        jFrameRemote.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // hien thi cua so
        jFrameRemote.setVisible(true);

    }

    /**
     * @return the modelRemote
     */
    public TempConverter getModelRemote() {
        return modelRemote;
    }

    /**
     * @return the celJTextFieldRemote
     */
    public JTextField getCelJTextFieldRemote() {
        return celJTextFieldRemote;
    }

    /**
     * @return the fahJTextFieldRemote
     */
    public JTextField getFahJTextFieldRemote() {
        return fahJTextFieldRemote;
    }

    @Override
    public void update() {
        this.celJTextFieldRemote.setText("" + modelRemote.getCel());
        this.fahJTextFieldRemote.setText("" + modelRemote.getFah());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // TempConverter modelRemote = viewRemote.getModelRemote();

        // lấy dữ liệu tù celJTextField, fahJTextField tại Boundary
        // JTextField celJTextFieldRemote = viewRemote.getCelJTextFieldRemote();
        double celValue = Double.parseDouble(celJTextFieldRemote.getText());

        // JTextField fahJTextFieldRemote = viewRemote.getFahJTextFieldRemote();
        double fahValue = Double.parseDouble(fahJTextFieldRemote.getText());

        // new TempConverter();

        // PHÂN BIỆT ĐƯỢC SỰ KIỆN PHÁT SINH TỪ celTextField hay fahTextField
        if (e.getSource() == celJTextFieldRemote) {
            // c => f
            // truyền dữ liệu độ C cho model -entity
            modelRemote.setCel(celValue);
            Command c2FCommand = new C2FCommand(modelRemote);
            commandProcessor.execute(c2FCommand);

            // gửi message kêu Entity - Model
            // chuyển từ c => f
            // double newFah = modelRemote.c2f();

            // cập nhật lên fahTextField tại Boudary
            // fahJTextFieldRemote.setText("" + newFah);
        } else {
            // f => c
            modelRemote.setFah(fahValue);
            double newCel = modelRemote.f2c();
            // celJTextFieldRemote.setText("" + newCel);
        }

    }

}
