package ssafy.ex_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
11
(9+(5*2+1))
 */
public class Solution_D4_1224_계산기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = 1;
		int T = 10;
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			char[] line = br.readLine().toCharArray();
			
			// step1. 후위표기식 만들기
			char temp,top;
			Stack<Character> stack  = new Stack<Character>();
			StringBuilder expression = new StringBuilder();
			for(int i=0; i<N; ++i) {
				temp = line[i];
				if(Character.isDigit(temp)) {// 피연산자이면   temp>='0' && temp<='9'
					expression.append(temp);
				}else if(temp == ')') {
					while( !stack.isEmpty() && (top = stack.pop()) != '(') expression.append(top);
				}else{ //'+', '-','*','/', '('
					// 스택의 탑에 있는 연산자의 우선순위가 같거나 높으면 먼저 처리         
					while(!stack.isEmpty() && getPriority(stack.peek(),true)>=getPriority(temp,false)) 
						expression.append(stack.pop());
					// 현 연산자 스택에 넣기
					stack.push(temp);
				}
			}
			while(!stack.isEmpty()) expression.append(stack.pop());
//			System.out.println(expression);
			
			// step2 후위표기식 계산하기  : 피연산자 스택에 push,연산자 스택 pop,pop 하여 연산 후 다시 스택에 push
			Stack<Integer> stack2  = new Stack<Integer>();
			int k=0;
			int size = expression.length();
			for(int i=0; i<size; ++i) {
				temp = expression.charAt(i);
				k = temp-'0';
				if(k>=0 && k<=9) { //피연산자
					stack2.push(k);
				}else {// 연산자
					int value2 = stack2.pop();
					int value1 = stack2.pop();
					switch (temp) {
					case '+':
						stack2.push(value1+value2);
						break;
					case '*':
						stack2.push(value1*value2);
						break;
					case '-':
						stack2.push(value1-value2);
						break;
					case '/':
						stack2.push(value1/value2);
						break;						
					}
				}
			}
			System.out.println("#"+t+" "+stack2.pop());
		}
		
	}

	private static int getPriority(char ch,boolean isInStack) {
		if(ch=='+'||ch=='-') return 1;
		else if(ch=='*'|| ch=='/') return 2;
		else return isInStack?0:3;
	}
}













