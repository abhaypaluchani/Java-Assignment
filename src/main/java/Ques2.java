
import java.util.Scanner;
import java.util.Stack;

public class Ques2 {

	static boolean balancedbrackets(String expr) {
		Stack<Character> stack = new Stack<Character>();
		for (int index = 0; index < expr.length(); index++) {
			char x = expr.charAt(index);

			if (x == '(' || x == '[' || x == '{') {

				stack.push(x);
				continue;
			}

			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		return (stack.isEmpty());
	}

	public static void main(String[] args) {
		while (true) {
			System.out.print("Please enter an expression: ");
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			if (balancedbrackets(str)) {
				System.out.println("True");
			} else
				System.out.println("False");
			

		}
		
	}
}
