package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class SinhVien {
    @Id
    private String maSinhVien;
    private String tenSinhvien;
    private String lop;
    private String khoa;
    private String trangThai = "ĐANG HỌC";
    private double gpa;
    @OneToMany(mappedBy = "sinhVien", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HocPhan> danhSachHocPhan;


    public SinhVien() {
    }


    
    public SinhVien(String maSinhVien, String tenSinhvien, String lop, String khoa, 
			List<HocPhan> danhSachHocPhan) {
		this.maSinhVien = maSinhVien;
		this.tenSinhvien = tenSinhvien;
		this.lop = lop;
		this.khoa = khoa;
		this.danhSachHocPhan = danhSachHocPhan;
	}



	public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhvien() {
        return tenSinhvien;
    }

    public void setTenSinhvien(String tenSinhvien) {
        this.tenSinhvien = tenSinhvien;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public List<HocPhan> getHocPhan() {
        return danhSachHocPhan;
    }

    public void setHocPhan(List<HocPhan> hocPhan) {
        this.danhSachHocPhan = hocPhan;
    }

    public void addHP(HocPhan hocPhan) {
        this.danhSachHocPhan.add(hocPhan);
    }
    
    public String getTrangThai() {
		return trangThai;
	}


	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}


	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
    
     
	@Override
    public String toString() {
        return "SinhVien [maSinhVien=" + maSinhVien + ", tenSinhvien=" + tenSinhvien + ", lop=" + lop + ", khoa=" + khoa
               + "]";
    }


}
