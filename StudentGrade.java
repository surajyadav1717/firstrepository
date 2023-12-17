package com.technicalsums;

import java.util.Scanner;

public class StudentGrade {

	// Four subject total Marks  and percentage calculation with Grade wise

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("ENTER  PHYSICS MARKS: ");
		int Physics=  sc.nextInt();


		System.out.println("ENTER  CHEMISTRY  MARKS: ");
		int  Biology =sc.nextInt();

		System.out.println("ENTER  BIOLOGY   MARKS: ");
		int Chemistry=sc.nextInt();


		System.out.println("ENTER  MATHS MARKS: ");
		int Maths=sc.nextInt();

		int Total = Physics+Biology+Chemistry+Maths;

		System.out.println("---------------------------------------");

		System.out.println("Total Marks is :"+Total);

		System.out.println("----------------------------------------");
		double Percent=Total*100/400;

		System.out.println("Total percentage is :"+Percent);

		System.out.println("-----------------------------------------");

		if (Percent >85 && Percent< 99) {

			System.out.println("PASSED WITH GRADE A :CONGRATS ");

			System.out.println("--------------------------------------");

		}
		else if(Percent >70 && Percent <85){

			System.out.println("PASSED WITH GRADE  B :CONGRATS");

			System.out.println("---------------------------------------|");

		}
		else if (Percent >55 && Percent<=70) {

			System.out.println("PASSED WITH GRADE C :CONGRATS");

			System.out.println("----------------------------------------|");

		}

		else if (Percent >36 && Percent <=55) {

			System.out.println("PASSED WITH GRADE D :CONGRATS");

			System.out.println("----------------------------------------|");

		}


		else{
			System.out.println("FAIL");

			System.out.println("----------------------------------------|");

		}
	}

}



