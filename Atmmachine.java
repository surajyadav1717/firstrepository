package com.bankprojecy;

import java.util.Scanner;

class Atm{

	int pin=1717;

	float balance;

	public void checkpin() {
		
		System.out.println("----------------------------------------------");

		System.out.println("_________| WELCOME TO BANK OF RCB |____________");
		
		
		System.out.println("__________| PLEASE ENTER THE PIN  : |_____________");
		
		
		

		Scanner sc = new Scanner(System.in);

		int enteredPin = sc.nextInt();

		if (enteredPin==pin) {

			System.out.println("Your Pin Is Matched"+ pin);

			menu();

		}

		else {
			System.out.println("Invalid pin !  try Again "+enteredPin);

			menu();
		}

	}

	public void menu() {

		System.out.println("Enter yours choice");

		System.out.println("1. Check Account Balance");
		System.out.println("2. Enter Amount to Withdraw");
		System.out.println("3. Enter Amount to Deposit");
		System.out.println("4. Exit ");

		Scanner sc = new  Scanner(System.in);

		int option = sc.nextInt();

		if (option==1) {

			checkbalance();
		}
		else if (option==2) {

			withdrawmoney();
		}

		else if (option==3) {

			depositmoney();
		}

		else if (option==4) {

			return;
		}

		else {

			System.out.println("Invalid choice Entered !!!");

			menu();
		}

	}

	public void checkbalance() {


		System.out.println(" Your Balance Amount is:"+balance+"Rs");

		menu();

	}


	public void withdrawmoney() {


		System.out.println("Enter amout to withdraw: " );

		Scanner sc = new Scanner(System.in);

		float amount =sc.nextFloat();

		if (amount>balance) {


			System.out.println("Insufficent Balance : "+ balance +"Rs");


		}

		else {

			balance= balance-amount;

			System.out.println("Money Withdraw Succesfully" +balance);

			menu();
		}

	}

	public void depositmoney() {

		System.out.println("Enter the amount to deposit");

		Scanner sc = new Scanner(System.in);

		float amount = sc.nextFloat();

		balance = balance+amount;

		System.out.println("Amount Deposited Succesfully");

		menu();

	}
	
	public class  Atmmachine {

		public static void main(String[] args) {

			Atm a = new Atm();

			a.checkpin();
			a.checkbalance();
			a.depositmoney();
			a.withdrawmoney();
			

		}
	}
}


