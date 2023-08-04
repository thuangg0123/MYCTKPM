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
    private JButton themButton, capnhatButton, xoaButton, timkiemButton;
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
        setLocation(1, 1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        modelRemote = new NguoiQuanLyImpl();
        modelRemote.subscribe(this);
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

        JButton sapXepMaHangButton = new JButton("Sắp xếp theo mã");
        sapXepMaHangButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sapXepSanPhamTheoTieuChi("maHang");
            }
        });

        JButton sapXepSoLuongTonButton = new JButton("Sắp xếp theo tồn kho");
        sapXepSoLuongTonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sapXepSanPhamTheoTieuChi("soLuongTon");
            }
        });

        JButton xuatFileButton = new JButton("Xuất file .txt");
        xuatFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuatFileTxt();
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
        functionPanel.add(sapXepMaHangButton);
        functionPanel.add(xuatFileButton);
        functionPanel.add(sapXepSoLuongTonButton);

        add(functionPanel, BorderLayout.EAST);

        JPanel inforPanel = new JPanel(new GridLayout(2, 6, 10, 0));
        tongTonKhoTP = new JLabel();
        tongTonKhoDM = new JLabel();
        tongTonKhoSS = new JLabel();

        inforPanel.add(new Label("Hang thuc pham"));
        inforPanel.add(tongTonKhoTP);
        inforPanel.add(new Label("Hang dien may"));
        inforPanel.add(tongTonKhoDM);
        inforPanel.add(new Label("Hang sanh su"));
        inforPanel.add(tongTonKhoSS);

        inforPanel.add(new Label());
        inforPanel.add(new Label());
        inforPanel.add(new Label());
        inforPanel.add(new Label());
        inforPanel.add(new Label());
        inforPanel.add(new Label());
        add(inforPanel, BorderLayout.SOUTH);
        xemDSHangHoa();
    }

    @Override
    public void update(List<HangHoa> hanghoaList) {
        while (tableModel.getRowCount() != 0) {
            tableModel.removeRow(0);
        }
        for (HangHoa hangHoa : hanghoaList) {
            Object[] rowData = { hangHoa.getMaHang(), hangHoa.getTenHang(), hangHoa.getSoLuongTon(),
                    hangHoa.getDonGia(), hangHoa.getNgaySX(), hangHoa.getNgayHetHan(),
                    hangHoa.getNhaCungCap(), hangHoa.getThoiGianBH(), hangHoa.getCongSuat(), hangHoa.getNgayNhapKho(),
                    hangHoa.getNhaSanXuat() };
            tableModel.addRow(rowData);
        }
        loadTongTonKho();
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
        if (hanghoa.getNhaCungCap() != null) {
            HangThucPhamGUI temp = new HangThucPhamGUI(this, modelRemote, controllerRemote, 1);
            temp.setMaHang(hanghoa.getMaHang());
            temp.getTenHangTextField().setText(hanghoa.getTenHang());
            temp.getSlTonTextField().setText(Integer.toString(hanghoa.getSoLuongTon()));
            temp.getDonGiaTextField().setText(Double.toString(hanghoa.getDonGia()));
            temp.getNgaySXTextField().setText(hanghoa.getNgaySX().toString());
            temp.getNgayHetHanTextField().setText(hanghoa.getNgayHetHan().toString());
            temp.getNhaCungCapTextField().setText(hanghoa.getNhaCungCap());
            temp.setVisible(true);
        } else if (hanghoa.getCongSuat() != null) {
            HangDienMayGUI temp = new HangDienMayGUI(this, modelRemote, controllerRemote, 1);
            temp.setMaHang(hanghoa.getMaHang());
            temp.getTenHangTextField().setText(hanghoa.getTenHang());
            temp.getSlTonTextField().setText(Integer.toString(hanghoa.getSoLuongTon()));
            temp.getDonGiaTextField().setText(Double.toString(hanghoa.getDonGia()));
            String[] tgBaoHanh = hanghoa.getThoiGianBH().split(" ");
            temp.getTgBaoHanhTextField().setText(tgBaoHanh[0]);
            String[] congSuat = hanghoa.getCongSuat().split(" ");
            temp.getCongSuatTextField().setText(congSuat[0]);
            temp.setVisible(true);
        } else if (hanghoa.getNhaSanXuat() != null) {
            HangSanhSuGUI temp = new HangSanhSuGUI(this, modelRemote, controllerRemote, 1);
            temp.setMaHang(hanghoa.getMaHang());
            temp.getTenHangTextField().setText(hanghoa.getTenHang());
            temp.getSlTonTextField().setText(Integer.toString(hanghoa.getSoLuongTon()));
            temp.getDonGiaTextField().setText(Double.toString(hanghoa.getDonGia()));
            temp.getNgayNhapKhoTextField().setText(hanghoa.getNgayNhapKho().toString());
            temp.getNhaSXTextField().setText(hanghoa.getNhaSanXuat());
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
        tongTonKhoTP.setText(Integer.toString(tongHangThucPham()));
        tongTonKhoDM.setText(Integer.toString(tongHangDienMay()));
        tongTonKhoSS.setText(Integer.toString(tongHangSanhSu()));
    }

    public int tongHangThucPham() {
        return modelRemote.tongHangThucPham();
    }

    public int tongHangDienMay() {
        return modelRemote.tongHangDienMay();
    }

    public int tongHangSanhSu() {
        return modelRemote.tongHangSanhSu();
    }

    public void sapXepSanPhamTheoTieuChi(String tieuchisapxep) {
        modelRemote.sapXepSanPham(tieuchisapxep);
    }

    public void xuatFileTxt() {
        modelRemote.xuatFileTxt();
    }
}
