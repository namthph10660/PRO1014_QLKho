Create database QLK
go 
use QLK
go 

Create table NHACUNGCAP(
MaNhaCC varchar(8) not null,
TenNhaCC nvarchar(50) not null,
NguoiDaiDien nvarchar(50) not null,
Email nvarchar(60) not null,
SDT nvarchar(15) not null,
DiaChi nvarchar(max) not null,
constraint PK_NhaCungCap primary key(MaNhaCC)
)
go

Create table NHANVIEN(
MaNhanVien varchar(8) ,
Hoten nvarchar (30) ,
SoDthoai nvarchar(15) ,
CMND varchar(15) ,
NgaySinh Date,
GioiTinh bit ,
--0 là nữ, 1 là Nam
VaiTro bit ,
--1 là nhân viên, 0 là trưởng kho
MatKhau varchar(50)
constraint PK_NhanVien primary key(MaNhanVien)
)
go

Create table LoaiSP  (
MaloaiSP varchar(8) not null,
Tenloaisp nvarchar(50) not null,
DonViTinh nvarchar(20) not null,
constraint PK_LoaiSP primary key(MaloaiSP)
)
go

Create table PHIEUNHAP(
MaPhieuNhap int identity(1,1) not null,
ThoiGianNhap datetime not null,
MaNhanVien varchar(8) not null,
constraint PK_PHIEUNHAP primary key(MaPhieuNhap),
constraint FK_PhieuNhap_NhanVien foreign key(MaNhanVien)references NhanVien(MaNhanVien)
)
go

Create table CTPHIEUNHAP(
MaCTPhieuNhap int identity(1,1) not null,
SoTien money not null,
SoLuong int not null,
MaNhaCC varchar(8) not null,
MaPhieuNhap int not null ,
constraint PK_CTPHIEUNHAP primary key(MaCTPhieuNhap),
constraint FK_CTPHIEUNHAP_PHIEUNHAP foreign key (MaPhieuNhap) references PHIEUNHAP(MaPhieuNhap),
constraint FK_CTPHIEUNHAP_NHACUNGCAP foreign key (MaNhaCC) references NHACUNGCAP(MaNhaCC)
)
go

Create table SANPHAM (
MaSP int identity(1,1) not null,
Tensp nvarchar(50) not null,
MaloaiSP varchar(8) not null,
Hinh nvarchar(max) ,
SoLuongSP int not null,
constraint PK_SANPHAM primary key(MaSP),
constraint FK_SANPHAM_LoaiSP foreign key (MaloaiSP) references LoaiSP(MaloaiSP)
)
go

Create table LOSANPHAM (
MaLo int identity(1,1) not null,
NgaySX date not null,
HanSuDung date,
MaPhieuNhap int not null,
TrangThai nvarchar(50),
SoLuong nvarchar(50) not null,
SoTien varchar(8) not null,
MaSP int not null,
constraint PK_LOSANPHAM primary key(Malo),
constraint FK_LOSANPHAM_PHIEUNHAP foreign key (MaPhieuNhap) references PHIEUNHAP(MaPhieuNhap),
constraint FK_LOSANPHAM_SANPHAM foreign key (MaSP) references SANPHAM(MaSP)
)

go

Create table HANGTRA (
MaHangTra int identity(1,1) not null,
MaLo int not null,
GhiChu nvarchar (max),
constraint PK_THUOCTINH primary key(MaHangTra),
constraint FK_HANGTRA_LOSANPHAM foreign key (MaLo) references LOSANPHAM(MaLo)
)
go

Create table PhieuXuat (
MaPhieuXuat int identity(1,1) not null,
ThoiGianXuat date not null,
MaNhanVien varchar(8) not null,
constraint PK_PhieuXuat primary key(MaPhieuXuat),
constraint FK_NhanVien_PhieuXuat foreign key (MaNhanVien) references NHANVIEN(MaNhanVien)
)
go

Create table CTPHIEUXUAT  (
MaCTPhieuXuat int identity(1,1) not null,
Soluong int not null,
GiaXuat money not null,
MaLo int not null,
MaPhieuXuat int not null,
constraint PK_CTPhieuXuat primary key(MaCTPhieuXuat),
constraint FK_CTPhieuXuat_PhieuXuat foreign key (MaPhieuXuat) references PhieuXuat(MaPhieuXuat),
constraint FK_CTPhieuXuat_LOSANPHAM foreign key (MaLo) references LOSANPHAM(MaLo)
)
go


Create table THUOCTINH(
MaThuocTinh int identity(1,1) not null,
MaloaiSP varchar(8) not null,
TruongTT nvarchar (50) not null,
DonViTinh nvarchar (20),
constraint PK_TTHUOCTINH primary key(MaThuocTinh),
constraint FK_LoaiSP_TTHUOCTINH foreign key (MaloaiSP) references LoaiSP(MaloaiSP)
)
go

Create table TTSP (
MaTTSP int identity(1,1) not null,
MaSP int not null,
GiaTri nvarchar(max) not null,
MaThuocTinh int not null ,
constraint PK_TTSP primary key(MaTTSP),
constraint FK_TTSP_TTHUOCTINH foreign key (MaThuocTinh) references THUOCTINH(MaThuocTinh),
constraint FK_TTSP_SANPHAM foreign key (MaSP) references SANPHAM(MaSP)
)
go

create table LOAITHONGBAO(
MaLoaiThongBao int identity(1,1) not null,
TenloaiThongBao nvarchar(15) not null,
constraint PK_LoaiThongBao primary key(MaLoaiThongBao)
)
go

create table THONGBAO(
MaThongBao int identity(1,1) not null,
TenThongBao nvarchar(20) not null,
NoiDung nvarchar(max),
NgayTao datetime not null,
MaNhanVien varchar(8) not null,
Han datetime,
MaLoaiThongBao int  not null,
constraint PK_THONGBAO primary key(MaThongBao),
constraint FK_THONGBAO_LOAITHONGBAO foreign key (MaLoaiThongBao) references LOAITHONGBAO(MaLoaiThongBao),
constraint FK_THONGBAO_NHANVIEN foreign key (MaNhanVien) references NHANVIEN(MaNhanVien)
)
go 
insert into NHACUNGCAP
values('NCC1',N'Hoa Sen',N'Nguyễn Đông Nam','dongnamhoasen@gmail.com','0338459391',N'183 Nguyễn Văn Trỗi, Phường 10, Quận Phú Nhuận, TPHCM')
insert into NHACUNGCAP
values('NCC2',N'Tiền Phong',N'Nguyễn An Minh','minhantienphong@gmail.com','0338459396',N'222 Mạc Đăng Doanh, Phường Hưng Đạo, Quận Dương Kinh, TP Hải Phòng')

insert into NHANVIEN
values('NV1',N'Hoàng Hoài Thảo','0973418651','001301025792','1992-11-17',0,0,'hoaithao1711')
insert into NHANVIEN
values('NV2',N'Nguyễn Hoài An','0973418657','001301026798','1993-10-14',1,1,'hoaian1993')

insert into LoaiSP
values('ONN',N'Ống nước nhựa',N'Cây')
insert into LoaiSP
values('T',N'Tôn',N'Tấm')
insert into LoaiSP
values('OK',N'Ống kẽm',N'Cây')

insert into PHIEUNHAP
values('2020-09-12','NV1')
insert into PHIEUNHAP
values('2020-10-15','NV2')
insert into PHIEUNHAP
values('2020-10-17','NV1')

insert into CTPHIEUNHAP
values(30000000,100,'NCC1',1)
insert into CTPHIEUNHAP
values(35000000,300,'NCC2',2)
insert into CTPHIEUNHAP
values(20000000,200,'NCC2',3)

insert into SANPHAM
values(N'Tôn lạnh mạ hợp kim','T','ton-lanh-mau-hoa-sen-936x480.jpg',100)
insert into SANPHAM
values(N'Ống nước PP-R','ONN','',200)
insert into SANPHAM
values(N'Tôn lạnh mạ hợp kim','T','ton-lanh-mau-hoa-sen-936x480.jpg',200)


insert into LOSANPHAM
values('2020-06-11','',1,N'Đã nhập hàng',100,30000000,1)
insert into LOSANPHAM
values('2020-04-02','',2,N'Đã nhập hàng',300,35000000,2)
insert into LOSANPHAM
values('2020-08-14','',3,N'Đã nhập hàng',200,20000000,3)

insert into HANGTRA
values(2,N'Giao sai màu')
 
insert into ThuocTinh
values('T',N'Loại sóng','')
insert into ThuocTinh
values('T',N'Màu sắc','')
insert into ThuocTinh
values('T',N'Độ dày','mililet')
insert into ThuocTinh
values('ONN',N'Độ dài','mét')

insert into TTSP
values(2,N'5 sóng vuông',1)
insert into TTSP
values(1,N'10',4)

insert into PhieuXuat
values('2020-11-17','NV1')

insert into CTPhieuXuat
values(50,20000000,1,1)
select * from NHANVIEN

insert into LOAITHONGBAO
values(N'Hàng Tồn')
insert into LOAITHONGBAO
values(N'Hết Hàng')

--insert into THONGBAO
--values(N'Thông báo sản phẩm hết hàng',N'Xi măng đã hết hàng','2020-08-09','NV1','2020-11-10',2)











