

import java.util.Scanner;
 
public class Ques1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of pairs: ");
		int noofpairs=sc.nextInt();
		int noofwords = 2 * (noofpairs);
		String[] words = new String[noofwords];

		if (noofpairs == 1) {
			System.out.println("Please enter more than one pair");
		} else {
			System.out.println("Enter the pairs of words: ");
			for (int indexofarr = 0; indexofarr < noofwords; indexofarr++) {
				words[indexofarr] = sc.next();
				
			}

			
			System.out.println("Total unique pairs are "+(checkdistinctpairs(words,noofwords)+1));

			sc.close();

		}
	}
	static int checkdistinctpairs(String words[],int noofwords) {
		int distinctpairs = 0; 
		int noofpairs=noofwords/2;

		for (int index = 0; index <= noofwords-4;index+=2 ) {
			int distinctpaircount=0;
			
			for(int innerloopindex=index+2;innerloopindex<=noofwords-2;innerloopindex+=2) {
		
				if (!(words[index].equals(words[innerloopindex]) && words[index + 1].equals(words[innerloopindex+1]))) {

					distinctpaircount++;
											
				}
								
		} 
			int remainingpairs=(index/2+1);
			if(distinctpaircount==(noofpairs-remainingpairs)) {
				distinctpairs++;
			}
			
		}
		return distinctpairs;
	}
}
