CREATE DATABASE ltudvj;
USE ltudvj;

CREATE TABLE SinhVien (
    maSV varchar(10) PRIMARY KEY,
    tenSV VARCHAR(50) NOT NULL,
    nganh VARCHAR(50) NOT NULL,
    lop VARCHAR(20) NOT NULL,
	khoa VARCHAR(20),
	bac VARCHAR(20),
    danghoc boolean
);



INSERT INTO SinhVien (maSV, tenSV, nganh, lop, khoa, bac, danghoc) 
VALUES ('sv0001', 'Sinh Viên 01', 'Kĩ thuật phần mềm', 'K15DCPM07', 'Công nghệ thông tin', 'Đại học', true);
INSERT INTO SinhVien (maSV, tenSV, nganh, lop, khoa, bac, danghoc) 
VALUES ('sv0002', 'Sinh Viên 02', 'Kĩ thuật phần mềm', 'K15DCPM07', 'Công nghệ thông tin', 'Đại học', true);

INSERT INTO SinhVien (maSV, tenSV, nganh, lop, khoa, bac, danghoc) 
VALUES ('sv0003', 'Sinh Viên 03', 'Kĩ thuật phần mềm', 'K15DCPM07', 'Công nghệ thông tin', 'Đại học', false);
INSERT INTO SinhVien (maSV, tenSV, nganh, lop, khoa, bac, danghoc) 
VALUES ('sv0004', 'Sinh Viên 04', 'Kĩ thuật phần mềm', 'K15DCPM07', 'Công nghệ thông tin', 'Đại học', true);
INSERT INTO SinhVien (maSV, tenSV, nganh, lop, khoa, bac, danghoc) 
VALUES ('sv0005', 'Sinh Viên 05', 'Kĩ thuật phần mềm', 'K15DCPM07', 'Công nghệ thông tin', 'Đại học', false);

UPDATE sinhvien SET tenSV = 'Sinh Viên 06', nganh = 'Kĩ thuật phần mềm', lop = 'K15DCPM07', khoa = 'Công nghệ thông tin', bac = 'Đại học', danghoc = false WHERE maSV = 'sv0004';

SELECT * FROM SinhVien;
SELECT * FROM SinhVien WHERE maSV = 'sv0003';


