package com.shopping.main;

import java.util.Scanner;

import com.shopping.api.PointOfSaleTerminal;

public class ScannerMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		PointOfSaleTerminal terminal = new PointOfSaleTerminal();

		System.out.println("Enter the No of Products to Scan :: ");
		int numProds = sc.nextInt();
		
		System.out.println("Enter the List of Products :: ");
		sc.nextLine();
		for(int i=0;i<numProds;i++) {
			terminal.scanProduct(sc.nextLine());
		}
		
		try {
			System.out.println("The toatl  Cart Amount is = $" + terminal.calculateTotal());
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		finally {
			sc.close();
		}
	}

}
