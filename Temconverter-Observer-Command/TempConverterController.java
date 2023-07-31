/*
*  created date: Jul 17, 2023
*  author: cgm
*/
package tuan7;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;


//Control - Controller Object
public class TempConverterController implements java.awt.event.ActionListener{

    //fields
    private TempConverterGUI viewRemote;

    //constructor
    public TempConverterController(){}

    public TempConverterController(TempConverterGUI viewRemote){
        this.viewRemote = viewRemote;
    }

    /**
     * @param viewRemote the viewRemote to set
     */
    public void setViewRemote(TempConverterGUI viewRemote) {
        this.viewRemote = viewRemote;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //dependency

        //message đến View
        TempConverter modelRemote = viewRemote.getModelRemote();

        //lấy dữ liệu tù celJTextField, fahJTextField tại Boundary
        JTextField celJTextFieldRemote = viewRemote.getCelJTextFieldRemote();
        double celValue = Double.parseDouble(celJTextFieldRemote.getText());

        JTextField fahJTextFieldRemote = viewRemote.getFahJTextFieldRemote();
        double fahValue = Double.parseDouble(fahJTextFieldRemote.getText());

        //new TempConverter();

        //PHÂN BIỆT ĐƯỢC SỰ KIỆN PHÁT SINH TỪ celTextField hay fahTextField
        if(e.getSource() == celJTextFieldRemote){
            //c => f
            //truyền dữ liệu độ C cho model -entity
            modelRemote.setCel(celValue);

            //gửi message kêu Entity - Model
            //chuyển từ c => f
            double newFah = modelRemote.c2f();

            //cập nhật lên fahTextField tại Boudary
           // fahJTextFieldRemote.setText("" + newFah);
        }else{
            //f => c
            modelRemote.setFah(fahValue);
            double newCel = modelRemote.f2c();
            //celJTextFieldRemote.setText("" + newCel);
        }

    }
    
}
