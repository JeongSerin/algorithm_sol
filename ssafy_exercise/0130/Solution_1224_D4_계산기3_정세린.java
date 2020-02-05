import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1224_D4_계산기3_정세린 {
	static StringBuilder res = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len;
		String str;
		Stack<Character> st = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		char tmp, top;

		for (int tc = 1; tc <= 10; tc++) {
			sb = new StringBuilder();
			len = Integer.parseInt(br.readLine());
			str = br.readLine();

			for (int i = 0; i < len; i++) {
				tmp = str.charAt(i);

				if (Character.isDigit(tmp)) {
					sb.append(tmp);
				} else if (tmp == ')') {
					// 여는괄호 만날때 까지 팝
					while (!st.isEmpty() && (top = st.pop()) != '(') {
						sb.append(top);
					}
				} else {

					while (!st.isEmpty() && inComingPriority(tmp) <= inStackPriority(st.peek())) {
						sb.append(st.pop());

					}
					st.push(tmp);
				}
			}
			
			while (!st.isEmpty()) sb.append(st.pop());

			res.append('#').append(tc).append(' ').append(calculate(sb)).append('\n');
//			System.out.println(sb.toString());
		}
		
		System.out.println(res.toString());
	}

	private static int inStackPriority(char ch) {
		int pri = 0;
		switch (ch) {
		case '(':
			pri = 0;
			break;
		case '+':
		case '-':
			pri = 1;
			break;
		case '*':
		case '/':
			pri = 2;
			break;

		}
		return pri;
	}

	private static int inComingPriority(char ch) {
		int pri = 0;
		switch (ch) {
		case '(':
			pri = 3;
			break;
		case '+':
		case '-':
			pri = 1;
			break;
		case '*':
		case '/':
			pri = 2;
			break;

		}
		return pri;
	}

	private static int calculate(StringBuilder str) {
		char tmp;
		int a, b;
		Stack<Integer> calst = new Stack<Integer>();

		for (int i = 0; i < str.length(); i++) {
			tmp = str.charAt(i);
			// 연산자면 팝하면서 계산
			if (tmp == '+' || tmp == '*' || tmp == '/' || tmp == '-') {

				b = calst.pop();
				a = calst.pop();

				switch (tmp) {
				case '+':
					calst.push(a + b);
					break;
				case '*':
					calst.push(a * b);
					break;
				case '/':
					calst.push(a / b);
					break;
				case '-':
					calst.push(a - b);
					break;
				}

			}
			// 연산자가 아니라 숫자
			else {
				calst.push(tmp - '0');
			}

		}
		return calst.peek();

	}
}
