package com.nguyenthanhnam.quanlysach;

import java.util.Scanner;

public class Sach {
	private String maSach;
	private String tenSach;
	private String ngayNhap;
	private int soLuong;
	private float donGia;
	private String thanhTien;

	public Sach() {
	}

	public Sach(String maSach) {
		this.maSach = maSach;
	}

	public Sach(String maSach, String tenSach, String ngayNhap, int soLuong,
			float donGia) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.ngayNhap = ngayNhap;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao ma sach:");
		maSach = sc.nextLine();
		System.out.println("Nhap vao ten sach:");
		tenSach = sc.nextLine();
		System.out.println("Nhap vao ngay nhap:");
		ngayNhap = sc.nextLine();
		System.out.println("Nhap vao so luong:");
		soLuong = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap vao don gia:");
		donGia = sc.nextFloat();
	}

	public void output() {
		System.out.printf("\n%10s%15s%10s%10d%10f%20f\n", maSach, tenSach,
				ngayNhap, soLuong, donGia, thanhTien());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSach == null) ? 0 : maSach.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		if (maSach == null) {
			if (other.maSach != null)
				return false;
		} else if (!maSach.equals(other.maSach))
			return false;
		return true;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public String getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(String thanhTien) {
		this.thanhTien = thanhTien;
	}

	public float thanhTien() {
		return (float) (soLuong * donGia);
	}
}
