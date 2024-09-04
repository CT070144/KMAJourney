package model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class HocPhan {
    @Id
    @GeneratedValue
    private int STT;
    private String tenHocPhan;
    private double diemThanhPhan1;
    private double diemThanhPhan2;
    private double diemThi;
    private String diemChu;
    private int hocKi;
    private int soTinchi;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sinhvien_id")
    private SinhVien sinhVien;
    private double diemTongKet;


    public HocPhan(String tenHocPhan, double diemThanhPhan1, double diemThanhPhan2, double diemThi, int hocKi,
                   int soTinChi, SinhVien sinhVien) {
        this.tenHocPhan = tenHocPhan;
        this.diemThanhPhan1 = diemThanhPhan1;
        this.diemThanhPhan2 = diemThanhPhan2;
        this.diemThi = diemThi;
        this.hocKi = hocKi;
        tongKet();
        this.soTinchi = soTinChi;
        this.sinhVien = sinhVien;
    }

    public HocPhan() {
    }

    @PrePersist
    @PreUpdate
    public void tongKet() {
        this.diemTongKet = (this.diemThi * 0.7) + (this.diemThanhPhan1 * 0.7 + this.diemThanhPhan2 * 0.3) * 0.3;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int sTT) {
        STT = sTT;
    }

    public String getTenHocPhan() {
        return tenHocPhan;
    }

    public void setTenHocPhan(String tenHocPhan) {
        this.tenHocPhan = tenHocPhan;
    }

    public double getDiemThanhPhan1() {
        return diemThanhPhan1;
    }

    public void setDiemThanhPhan1(double diemThanhPhan1) {
        this.diemThanhPhan1 = diemThanhPhan1;
    }

    public double getDiemThanhPhan2() {
        return diemThanhPhan2;
    }

    public void setDiemThanhPhan2(double diemThanhPhan2) {
        this.diemThanhPhan2 = diemThanhPhan2;
    }

    public double getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(double diemThi) {
        this.diemThi = diemThi;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public String getDiemChu() {
        return diemChu;
    }

    public void setDiemChu(String diemChu) {
        this.diemChu = diemChu;
    }

    public int getHocKi() {
        return hocKi;
    }

    public void setHocKi(int hocKi) {
        this.hocKi = hocKi;
    }

    public double getDiemTongKet() {
        return diemTongKet;
    }

    public void setDiemTongKet(double diemTongKet) {
        this.diemTongKet = diemTongKet;
    }

    public int getSoTinchi() {
        return soTinchi;
    }

    public void setSoTinchi(int soTinchi) {
        this.soTinchi = soTinchi;
    }

    @Override
    public String toString() {
        return "HocPhan [STT=" + STT + ", tenHocPhan=" + tenHocPhan + ", diemThanhPhan1=" + diemThanhPhan1
                + ", diemThanhPhan2=" + diemThanhPhan2 + ", diemThi=" + diemThi + ", diemTongKet=" + diemTongKet
                + "]";
    }


}
