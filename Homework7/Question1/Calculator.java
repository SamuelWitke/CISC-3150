import java.lang.IllegalArgumentException;
import java.util.*;
import PostFix.*;
class Calculator{
	public static void main(String[] args) {
		// Check number of command-line arguments 
		if (args.length == 0) {
			System.out.println("Get good with arguments");
			System.exit(1);
		}

		try {
			System.out.println(Arrays.toString(args));
			String line="";
			for(int i=0;i<args.length;i++)
				line+=args[i];	
			PostFixEval eval = new PostFixEval(line);
			if(eval.outputString.contains(" "))
				System.out.println(evaluateExpression(eval.outputString));
			else
				throw new IllegalOperationException();
		}
		catch ( LookAtMrAlgebraOverHereException ex) {
			System.out.println("LookAtMrAlgebraOverHereException");
		}catch (UserIsADumbassException ex) {
			System.out.println("UserIsADumbassException"); 
		}catch ( IllegalOperationException ex) {
			System.out.println(" Illegaloperationexception "); 
		}catch(Exception ex){
			System.out.println("Something went terribly wrong");
			ex.printStackTrace();
		}
	}

	/** Evaluate a postfix notation expression */
	public static double evaluateExpression(
		String expression) throws Exception {
		Stack<Double> operandStack = new Stack<>();
		expression = insertBlanks(expression);
		String[] tokens = expression.split(" ");
		for (String token: tokens) {
			if(token.charAt(0) == '(')
				System.out.println(token);	
		}
		for (String token: tokens) {
			if (token.length() == 0) // Blank space
				continue; // Back to the while loop to extract the next token
			else if (token.charAt(0) == '+' ||
					 token.charAt(0) == '-' ||
					 token.charAt(0) == '/' || 
					 token.charAt(0) == '*' ||
					 token.charAt(0) == '%') {
					// Process all operands in the top of the stack
					processAnOperator(operandStack, token.charAt(0));
			}
			else if (Character.isDigit(token.charAt(0))){
				operandStack.push(Double.parseDouble(token));
			}
			else if (!Character.isLetter(token.charAt(0)))
				throw new LookAtMrAlgebraOverHereException();
		
		}

		return operandStack.pop();
	}

	/** Process one operator: Apply an operator 
	  * to the operands in the stack */
	public static void processAnOperator(
			Stack<Double> operandStack, char operator) throws Exception{
		double op1=0,op2=0;
		try{
			op1 = operandStack.pop();
			op2 = operandStack.pop();
		}catch(Exception e){
			throw new UserIsADumbassException();
		}
		switch (operator) {
			case '+': operandStack.push(op2 + op1); break;
			case '-': operandStack.push(op2 - op1); break;
			case '/': operandStack.push(op2 / op1); break;
			case '*': operandStack.push(op2 * op1); break;
			case '%': operandStack.push(op2 % op1);
		}
	}

	/** Inserts blanks around +, -, /, and * */
	public static String insertBlanks(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '+' || 
				s.charAt(i) == '-' ||
				s.charAt(i) == '/' || 
				s.charAt(i) == '%' || 
				s.charAt(i) == '*')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}
		return result;
	}
}

class LookAtMrAlgebraOverHereException extends IllegalArgumentException{}
class UserIsADumbassException extends IllegalArgumentException{}
class IllegalOperationException extends IllegalArgumentException{}
