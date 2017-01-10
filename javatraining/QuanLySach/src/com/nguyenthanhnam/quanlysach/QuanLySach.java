package com.nguyenthanhnam.quanlysach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLySach {
	private Sach sach;
	private ArrayList<Sach> lisSachs;

	public QuanLySach() {
		lisSachs = new ArrayList<>();
	}

	public void displayList() {
		for (int i = 0; i < lisSachs.size(); i++) {
			lisSachs.get(i).output();
		}
	}

	private int checkExits(String maSach) {
		Sach sach = new Sach(maSach);
		if (lisSachs.contains(sach)) {
			return lisSachs.indexOf(sach);
		}
		return -1;
	}

	public void themSach() {
		sach = new Sach();
		sach.input();
		lisSachs.add(sach);
	}

	public void suaThongTin() {
		Scanner sc = new Scanner(System.in);
		String maSach;
		System.out.println("Nhap vao ma sach can sua thong tin");
		maSach = sc.next();
		sc.nextLine();
		int position = checkExits(maSach);
		if (position >= 0) {
			Sach sach = new Sach();
			sach.input();
			lisSachs.set(position, sach);
		} else {
			System.out.println("Khong tim thay thong tin can sua");
		}
		displayList();
	}

	public void timKiemThongTin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao ten tim kiem");
		String tenSach = sc.nextLine();
		for (int i = 0; i < lisSachs.size(); i++) {
			if (lisSachs.get(i).getTenSach().contains(tenSach)) {
				lisSachs.get(i).output();
			}
		}
	}

	public void xoaThongTin() {
		String maSach;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao ma sach:");
		maSach = sc.nextLine();
		int position = checkExits(maSach);
		if (position >= 0) {
			lisSachs.remove(position);
			System.out.println("Xoa thanh cong");
		} else {
			System.out.println("Khong tim thay ma can xoa");
		}
		displayList();
	}

	public void sapXep() {
		Collections.sort(lisSachs, new Comparator<Sach>() {
			@Override
			public int compare(Sach o1, Sach o2) {
				if (o1.getMaSach().compareTo(o2.getMaSach()) > 0) {
					return 1;
				} else if (o1.getMaSach().compareTo(o2.getMaSach()) < 0) {
					return -1;
				}
				return 0;
			}
		});
		displayList();
	}
}
