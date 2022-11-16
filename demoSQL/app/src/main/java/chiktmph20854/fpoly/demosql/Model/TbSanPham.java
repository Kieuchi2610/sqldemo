package chiktmph20854.fpoly.demosql.Model;

public class TbSanPham {
    int id_sanPham;
    String ten_sanPham;
    String srcAnh;
    int giaNhap;
    int giaBan;
    int tonKho;
    int id_danhmuc;

    public TbSanPham() {
    }

    public TbSanPham(String ten_sanPham, String srcAnh, int giaNhap, int giaBan, int tonKho) {
        this.ten_sanPham = ten_sanPham;
        this.srcAnh = srcAnh;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.tonKho = tonKho;
    }

    public int getId_sanPham() {
        return id_sanPham;
    }

    public void setId_sanPham(int id_sanPham) {
        this.id_sanPham = id_sanPham;
    }

    public String getTen_sanPham() {
        return ten_sanPham;
    }

    public void setTen_sanPham(String ten_sanPham) {
        this.ten_sanPham = ten_sanPham;
    }

    public String getSrcAnh() {
        return srcAnh;
    }

    public void setSrcAnh(String srcAnh) {
        this.srcAnh = srcAnh;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getTonKho() {
        return tonKho;
    }

    public void setTonKho(int tonKho) {
        this.tonKho = tonKho;
    }

    public int getId_danhmuc() {
        return id_danhmuc;
    }

    public void setId_danhmuc(int id_danhmuc) {
        this.id_danhmuc = id_danhmuc;
    }
}
