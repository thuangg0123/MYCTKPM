CREATE DATABASE jdbc_db;
USE jdbc_db;

CREATE TABLE HangHoa (
    MaHangHoa varchar(5) PRIMARY KEY,
    TenHangHoa VARCHAR(50) NOT NULL,
    slTonKho INT,
    DonGia INT,
    NgaySX date,
    NgayHetHan date,
    NhaCungCap VARCHAR(100),
	ThoiGianBH date,
    CongSuat int,
	NgayNhapKho date,
    NhaSX VARCHAR(100)
);

INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, NgaySX, NgayHetHan, NhaCungCap) 
VALUES ('tp001', 'Hàng thực phẩm', 5, 100, '2023-01-01', '2023-01-02', 'Nhà cung cấp hàng thực phẩm');
INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, NgaySX, NgayHetHan, NhaCungCap) 
VALUES ('tp002', 'Hàng thực phẩm', 3, 100, '2023-01-01', '2023-01-02', 'Nhà cung cấp hàng thực phẩm');

INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, ThoiGianBH, CongSuat) 
VALUES ('dm001', 'Hàng điện máy', 5, 100, '2023-01-01', 50);
INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, ThoiGianBH, CongSuat) 
VALUES ('dm002', 'Hàng điện máy', 4, 100, '2023-01-01', 20);

INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, NgayNhapKho, NhaSX) 
VALUES ('ss001', 'Hàng sành sứ', 5, 100, '2023-01-01', 'Nhà sản suất hàng sành sứ');
INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, NgayNhapKho, NhaSX) 
VALUES ('ss002', 'Hàng sành sứ', 6, 100, '2023-01-01', 'Nhà sản suất hàng sành sứ');

SELECT * FROM jdbc_db.hanghoa;
