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
    CongSuat VARCHAR(20),
	NgayNhapKho date,
    NhaSX VARCHAR(100)
);

INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, NgaySX, NgayHetHan, NhaCungCap) 
VALUES ('tp001', 'Hàng thực phẩm', 5, 100, '2023-01-01', '2023-01-02', 'Nhà cung cấp hàng thực phẩm');
INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, NgaySX, NgayHetHan, NhaCungCap) 
VALUES ('tp002', 'Hàng thực phẩm', 3, 100, '2023-01-01', '2023-01-02', 'Nhà cung cấp hàng thực phẩm');

INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, ThoiGianBH, CongSuat) 
VALUES ('dm001', 'Hàng điện máy', 5, 100, '2023-01-01', '50W');
INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, ThoiGianBH, CongSuat) 
VALUES ('dm002', 'Hàng điện máy', 4, 100, '2023-01-01', '20W');

INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, NgayNhapKho, NhaSX) 
VALUES ('ss001', 'Hàng sành sứ', 5, 100, '2023-01-01', 'Nhà sản suất hàng sành sứ');
INSERT INTO hanghoa (MaHangHoa, TenHangHoa, slTonKho, DonGia, NgayNhapKho, NhaSX) 
VALUES ('ss002', 'Hàng sành sứ', 6, 100, '2023-01-01', 'Nhà sản suất hàng sành sứ');

SELECT * FROM jdbc_db.hanghoa;

-- chức năng tìm kiếm
DELIMITER $$
CREATE PROCEDURE TimKiem(
	tuKhoa VARCHAR(50))
BEGIN
    SELECT *
    FROM HangHoa
    WHERE 
		lower(MaHangHoa) LIKE lower(CONCAT('%', tuKhoa, '%'))
		OR lower(TenHangHoa) LIKE lower(CONCAT('%', tuKhoa, '%'))
		OR lower(slTonKho) LIKE lower(CONCAT('%', tuKhoa, '%'))
		OR lower(DonGia) LIKE lower(CONCAT('%', tuKhoa, '%'))
		OR lower(NgaySX) LIKE lower(CONCAT('%', tuKhoa, '%'))
        OR lower(NgayHetHan) LIKE lower(CONCAT('%', tuKhoa, '%'))
        OR lower(NhaCungCap) LIKE lower(CONCAT('%', tuKhoa, '%'))
        OR lower(ThoiGianBH) LIKE lower(CONCAT('%', tuKhoa, '%'))
        OR lower(CongSuat) LIKE lower(CONCAT('%', tuKhoa, '%'))
        OR lower(NgayNhapKho) LIKE lower(CONCAT('%', tuKhoa, '%'))
        OR lower(NhaSX) LIKE lower(CONCAT('%', tuKhoa, '%'));
END$$
DELIMITER ;

call TimKiem('01');
