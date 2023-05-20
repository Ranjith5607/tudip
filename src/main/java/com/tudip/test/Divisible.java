package com.tudip.test;

import java.util.Scanner;

public class Divisible {

	public static void main(String[] args) {
//		If a number is divisible by 5, then print Hello
//		If a number is divisible by 7, then print World
//		If a number is divisible by both 5 and 7, then print Hello World

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter the Number");

		int number = scanner.nextInt();

		if ((number % 5 == 0) && (number % 7 == 0)) {

			System.out.println("Hello World");
		}

		else if (number % 5 == 0) {
			System.out.println("Hello");

		}

		else if (number % 7 == 0) {
			System.out.println("World");

		}

		else {
			System.out.println("there is no devided the 5 and 7 ");
		}

	}

}
