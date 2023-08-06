package presentation.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import domain.*;
import presentation.*;
import presentation.Command.*;

//View
public class QuanLyKhoGUI extends JFrame implements Subscriber {
    private QuanLyKhoController controllerRemote;
    private NguoiQuanLy modelRemote;
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton themButton, capnhatButton, xoaButton, timkiemButton, hethanButton, xemAllButton, sapXepButton;
    private JTextField tuKhoaTextField;
    private JLabel tongTonKhoTP, tongTonKhoDM, tongTonKhoSS;

    public QuanLyKhoController getControllerRemote() {
        return controllerRemote;
    }

    public NguoiQuanLy getModelRemote() {
        return modelRemote;
    }

    public QuanLyKhoGUI() {
        setTitle("Quản lý hàng hóa trong kho");
        setSize(1280, 400);
        setLocation(320, 340);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        modelRemote = new NguoiQuanLyImpl();
        modelRemote.subscribe(this);
        controllerRemote = new QuanLyKhoController();

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem nhapFileItem = new JMenuItem("Nhập dữ liệu từ file excel");
        JMenuItem xuatFileItem = new JMenuItem("Xuất dữ liệu ra file excel");
        JMenuItem exitItem = new JMenuItem("Thoát");
        fileMenu.add(nhapFileItem);
        fileMenu.add(xuatFileItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        xuatFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    xuatFile();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        nhapFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    nhapFile();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

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
        table.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        themButton = new JButton("Thêm");
        themButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themHangHoa();
            }
        });

        capnhatButton = new JButton("Cập nhật");
        capnhatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                capnhatHangGUI(table.getSelectedRow());
            }
        });

        xoaButton = new JButton("Xóa");
        xoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaHangHoaGUI(table.getSelectedRow());
            }
        });

        timkiemButton = new JButton("Tìm kiếm");
        timkiemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timTTHH();
            }
        });
        tuKhoaTextField = new JTextField();

        hethanButton = new JButton("Hàng sắp hết hạn");
        hethanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xemDSHetHan();
            }
        });

        xemAllButton = new JButton("Xem danh sách hàng hóa");
        xemAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xemDSHangHoa();
            }
        });

        sapXepButton = new JButton("Sắp xếp");
        sapXepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sapXepSanPham();
            }
        });



        JPanel functionPanel = new JPanel(new GridLayout(9, 0, 0, 10));

        functionPanel.add(tuKhoaTextField);
        functionPanel.add(timkiemButton);
        functionPanel.add(new Label());

        functionPanel.add(xemAllButton);
        functionPanel.add(hethanButton);
        functionPanel.add(themButton);
        functionPanel.add(capnhatButton);
        functionPanel.add(xoaButton);
        functionPanel.add(sapXepButton);

        add(functionPanel, BorderLayout.EAST);

        JPanel inforPanel = new JPanel(new GridLayout(2, 6, 10, 0));
        tongTonKhoTP = new JLabel();
        tongTonKhoDM = new JLabel();
        tongTonKhoSS = new JLabel();

        inforPanel.add(new Label("Số lượng tồn kho hàng thực phẩm"));
        inforPanel.add(tongTonKhoTP);
        inforPanel.add(new Label("Số lượng tồn kho hàng điện máy"));
        inforPanel.add(tongTonKhoDM);
        inforPanel.add(new Label("Số lượng tồn kho hàng sành sứ"));
        inforPanel.add(tongTonKhoSS);

        inforPanel.add(new Label());
        inforPanel.add(new Label());
        inforPanel.add(new Label());
        inforPanel.add(new Label());
        inforPanel.add(new Label());
        inforPanel.add(new Label());
        add(inforPanel, BorderLayout.SOUTH);

        xemDSHangHoa();
        loadTongTonKho();
    }

    @Override
    public void update(List<HangHoa> hanghoaList) {
        while (tableModel.getRowCount() != 0) {
            tableModel.removeRow(0);
        }
        for (HangHoa hangHoa : hanghoaList) {
            Object[] rowData = { hangHoa.getMaHH(), hangHoa.getTenHH(), hangHoa.getSlTon(),
                    hangHoa.getDonGia(), hangHoa.getNgaySX(), hangHoa.getNgayHH(),
                    hangHoa.getNhaCC(), hangHoa.getThoiGianBH(), hangHoa.getCongSuat(), hangHoa.getNgayNK(),
                    hangHoa.getNhaSX() };
            tableModel.addRow(rowData);
        }
    }

    @Override
    public void update(String[] tongTonKho) {
        tongTonKhoTP.setText(tongTonKho[0]);
        tongTonKhoDM.setText(tongTonKho[1]);
        tongTonKhoSS.setText(tongTonKho[2]);
    }

    public void xemDSHangHoa() {
        modelRemote.xemTTAllHH();
    }

    public void themHangHoa() {
        new LoaiHangHoa(this, modelRemote, controllerRemote).setVisible(true);
    }

    public void capnhatHangGUI(int rowIndex) {
        String maHang;
        HangHoa hanghoa;
        if (rowIndex == -1) {
            maHang = JOptionPane.showInputDialog(null, "Nhập số mã hàng hóa cần sửa");
            if (maHang != null) {
                hanghoa = xemThongTin1HH(maHang);
                capnhatHang(hanghoa);
            }
        } else {
            maHang = tableModel.getValueAt(rowIndex, 0).toString();
            hanghoa = xemThongTin1HH(maHang);
            capnhatHang(hanghoa);
        }
    }

    public void capnhatHang(HangHoa hanghoa) {
        if (hanghoa.getNhaCC() != null) {
            HangThucPhamGUI temp = new HangThucPhamGUI(this, modelRemote, controllerRemote, 1);
            temp.setMaHang(hanghoa.getMaHH());
            temp.getTenHangTextField().setText(hanghoa.getTenHH());
            temp.getSlTonTextField().setText(Integer.toString(hanghoa.getSlTon()));
            temp.getDonGiaTextField().setText(Double.toString(hanghoa.getDonGia()));
            temp.getNgaySXTextField().setText(hanghoa.getNgaySX().toString());
            temp.getNgayHetHanTextField().setText(hanghoa.getNgayHH().toString());
            temp.getNhaCungCapTextField().setText(hanghoa.getNhaCC());
            temp.setVisible(true);
        } else if (hanghoa.getCongSuat() != null) {
            HangDienMayGUI temp = new HangDienMayGUI(this, modelRemote, controllerRemote, 1);
            temp.setMaHang(hanghoa.getMaHH());
            temp.getTenHangTextField().setText(hanghoa.getTenHH());
            temp.getSlTonTextField().setText(Integer.toString(hanghoa.getSlTon()));
            temp.getDonGiaTextField().setText(Double.toString(hanghoa.getDonGia()));
            String[] tgBaoHanh = hanghoa.getThoiGianBH().split(" ");
            temp.getTgBaoHanhTextField().setText(tgBaoHanh[0]);
            String[] congSuat = hanghoa.getCongSuat().split(" ");
            temp.getCongSuatTextField().setText(congSuat[0]);
            temp.setVisible(true);
        } else if (hanghoa.getNhaSX() != null) {
            HangSanhSuGUI temp = new HangSanhSuGUI(this, modelRemote, controllerRemote, 1);
            temp.setMaHang(hanghoa.getMaHH());
            temp.getTenHangTextField().setText(hanghoa.getTenHH());
            temp.getSlTonTextField().setText(Integer.toString(hanghoa.getSlTon()));
            temp.getDonGiaTextField().setText(Double.toString(hanghoa.getDonGia()));
            temp.getNgayNhapKhoTextField().setText(hanghoa.getNgayNK().toString());
            temp.getNhaSXTextField().setText(hanghoa.getNhaSX());
            temp.setVisible(true);
        }
    }

    public void xoaHangHoaGUI(int rowIndex) {
        String maHang;
        if (rowIndex == -1) {
            maHang = JOptionPane.showInputDialog(null, "Nhập số mã hàng hóa cần xóa");
            if (maHang != null) {
                xoaHangHoa(maHang);
            }
        } else {
            maHang = tableModel.getValueAt(rowIndex, 0).toString();
            xoaHangHoa(maHang);
        }
    }

    public void xoaHangHoa(String maHang) {
        Command xoaHang = new Xoa(modelRemote, maHang);
        controllerRemote.execute(xoaHang);
    }

    public void timTTHH() {
        Command timKiem = new TimKiem(modelRemote, tuKhoaTextField.getText());
        controllerRemote.execute(timKiem);
    }

    public HangHoa xemThongTin1HH(String maHang) {
        return modelRemote.xemThongTin1HH(maHang);
    }

    private void loadTongTonKho() {
        modelRemote.tongTonKho();
    }

    public void xemDSHetHan() {
        modelRemote.xemDSHetHan();
    }

    public void sapXepSanPham() {
        new LoaiSapXep(this, modelRemote).setVisible(true);
        ;
    }

    public void xuatFile() throws Exception {
        modelRemote.xuatFile();
    }

    public void nhapFile() throws Exception {
        modelRemote.nhapFile();
    }
}
