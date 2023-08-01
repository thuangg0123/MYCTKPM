package presentation.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import domain.HangHoa;
import domain.NguoiQuanLy;
import domain.NguoiQuanLyImpl;
import presentation.QuanLyKhoController;
import presentation.Subscriber;

//View
public class QuanLyKhoGUI extends JFrame implements Subscriber{
    private QuanLyKhoController controllerRemote;
    public QuanLyKhoController getControllerRemote() {
        return controllerRemote;
    }

    public NguoiQuanLy getModelRemote() {
        return modelRemote;
    }

    private NguoiQuanLy modelRemote;
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton themButton, capnhatButton, xoaButton, timkiemButton;
    private JTextField tuKhoaTextField;


    public QuanLyKhoGUI() {
        setTitle("Quản lý hàng hóa trong kho");
        setSize(1280, 400);
        setLocation(320, 340);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        modelRemote = new NguoiQuanLyImpl();
        controllerRemote = new QuanLyKhoController();

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã hàng hóa");
        tableModel.addColumn("Tên hàng hóa");
        tableModel.addColumn("Số lượng tồn");
        tableModel.addColumn("Đơn giá");
        tableModel.addColumn("Ngày sản suất");
        tableModel.addColumn("Ngày hết hạn");
        tableModel.addColumn("Nhà cung cấp");
        tableModel.addColumn("Thời gian BH");
        tableModel.addColumn("Công suất");
        tableModel.addColumn("Ngày nhập kho");
        tableModel.addColumn("Nhà sản suất");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        themButton = new JButton("Thêm");
        capnhatButton = new JButton("Cập nhật");
        xoaButton = new JButton("Xóa");
        timkiemButton = new JButton("Tìm kiếm");
        timkiemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timTTHH();
            }
        });
        tuKhoaTextField = new JTextField();

        JPanel functionPanel = new JPanel(new GridLayout(7, 0, 0, 10));

        functionPanel.add(tuKhoaTextField);
        functionPanel.add(timkiemButton);
        functionPanel.add(new Label());

        functionPanel.add(themButton);
        functionPanel.add(capnhatButton);
        functionPanel.add(xoaButton);

        add(functionPanel, BorderLayout.EAST);
        xemDSHangHoa();
    }

    @Override
    public void update(List<HangHoa> hanghoaList) {
        while(tableModel.getRowCount() != 0) {
            tableModel.removeRow(0);
        }
        for (HangHoa hangHoa : hanghoaList) {
            Object[] rowData = { hangHoa.getMaHang(), hangHoa.getTenHang(), hangHoa.getSoLuongTon(), hangHoa.getDonGia(), hangHoa.getNgaySX(), hangHoa.getNgayHetHan(),
            hangHoa.getNhaCungCap(), hangHoa.getThoiGianBH(), hangHoa.getCongSuat(), hangHoa.getNgayNhapKho(), hangHoa.getNhaSanXuat()};
            tableModel.addRow(rowData); 
        }
    }

    void xemDSHangHoa() {
        update(modelRemote.xemTTAllHH());
    }
    
    void themHanghoa() {
        modelRemote.themHang(ABORT, null);
    }

    void timTTHH() {
        update(modelRemote.timTTHH(tuKhoaTextField.getText()));
    }

}
