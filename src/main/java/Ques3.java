
import java.util.Scanner;

public class Ques3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter number of digits: ");

		int noofdigits = sc.nextInt();
		System.out.println("Please enter the digits of the number: ");

		int[] num = new int[noofdigits];
		for (int indexofnumarr = 0; indexofnumarr < noofdigits; indexofnumarr++) {
			num[indexofnumarr] = sc.nextInt();
		}

		System.out.println("Minimum jumps required to reach are " + noofsteps(num, noofdigits));
		sc.close();

	}

	static int noofsteps(int num[], int length) {
		int steps = 0;
		if (num[0] == 0 && num[length - 1] == 0) {
			for (int index = 0; index < length;) {
				if ((index <= length - 3) && (num[index + 2] == 0)) {
					index += 2;
					steps++;

				} else if ((index <= length - 2) && (num[index + 1] == 0)) {
					index += 1;
					steps++;
				} else if (index == length - 1) {
					break;

				} else {
					System.out.println("Not possible!");
					break;
				}

			}
			return steps;
		} else
			System.out.println(
					"Make sure that the starting and ending numbers are zeros, also consecutive ones are not allowed");
		return 0;
	}

}
