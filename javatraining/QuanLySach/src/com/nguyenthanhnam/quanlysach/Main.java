package com.nguyenthanhnam.quanlysach;

import java.util.Scanner;

import com.nguyenthanhnam.quanlysach.QuanLySach;

public class Main {
	public static void main(String[] args) {
		QuanLySach quanLySach = new QuanLySach();
		while (true) {
			System.out.println("----------MENU-------------");
			System.out.println("1.NHAP THONG TIN SACH");
			System.out.println("2.SUA THONG TIN SACH");
			System.out.println("3.XOA THONG TIN SACH");
			System.out.println("4.TIM THONG TIN SACH");
			System.out.println("5.SAP XEP THEO MA SACH");
			System.out.println("6.HIEN THI THONG TIN SACH");
			System.out.println("7.THOAT CHUONG TRINH");
			System.out.println("Nhap vao su lua chon cua ban:");
			Scanner sc = new Scanner(System.in);
			int select = sc.nextInt();
			switch (select) {
			case 1:
				quanLySach.themSach();
				break;
			case 2:
				quanLySach.suaThongTin();
				break;
			case 3:
				quanLySach.xoaThongTin();
				break;
			case 4:
				quanLySach.timKiemThongTin();
				break;
			case 5:
				quanLySach.sapXep();
				break;
			case 6:
				quanLySach.displayList();
				break;
			case 7:
				System.exit(0);
				break;
			}
		}

	}
}
