package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import hello.Operator;

public class Main {

	public static void main(String[] args) {

		Operator group_name_here = new Operator();

		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Please enter your password");
			boolean isAuth = group_name_here.checkPassword(console.readLine());
			if (!isAuth) {
				System.exit(1);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Invalid Input.");
		}

		group_name_here.operatorUI();

	}

}
