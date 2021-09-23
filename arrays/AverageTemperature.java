package arrays;

import java.util.*;

public class AverageTemperature {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("How many day`s temperature: ");
		int days = sc.nextInt();
		int[] temp = new int[days];
		int sum = 0;
		for (int i = 0; i < days; i++) {
			System.out.print("Day " + (i+1) + "`s high temperature is : ");
			int data = sc.nextInt();
			temp[i] = data;
			sum += temp[i];
		}
		double avg = sum / days;
		System.out.println("\naverage temp = " + avg);

		int above = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] > avg) {
				above++;
			}
		}
		System.out.println(above + " Days above average");
		sc.close();

	}

}
