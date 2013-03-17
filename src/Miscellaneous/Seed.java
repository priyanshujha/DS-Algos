package Miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Anubhav Jain
 */
public class Seed {

	public static void main(String args[]){
	
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number="56";
		int num = Integer.parseInt(number);
		int i;

		for (i = 1; i <= num; i++) {
			// System.out.println("*" + i);
			int count = 1;
			int y = i;
			count = count * y;
			while (y >= 1) {
				count = count * (y % 10);
				y = y / 10;
			}
			// System.out.println(count);
			if (count == num) {
				System.out.println(i);
			}
		}

	}
}