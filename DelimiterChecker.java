
public class DelimiterChecker {
	public static void main(String[] args) {
		String in = "(())";
		DelimiterChecker x = new DelimiterChecker();
		x.check(in);
	}

	
	public boolean check(String input) {
		boolean flag = true;
		StackX theStack = new StackX(input.length());
		for (int j = 0; j < input.length(); j++) {
		      char ch = input.charAt(j);
		      switch (ch) {
		      case '{': 
		      case '[':
		      case '(':
		        theStack.push(ch);
		        break;
		      case '}': 
		      case ']':
		      case ')':
		        if (!theStack.isEmpty()) {
		          char chx = theStack.pop();
		          if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[') || (ch == ')' && chx != '(')) {
		        	  flag = false;
		        	  System.out.println("Error: " + ch + " at " + j);
		          }
		           
		        } else {
		        	flag = false; 
		        	System.out.println("Error: " + ch + " at " + j);
		        }
		         
		        break;
		      default:
		        break;
		      }
		    }
		 if (!theStack.isEmpty()){
		    System.out.println("Error: missing right delimiter");
		    flag = false;
		 }
		 else {
			 System.out.println("Matched");
		 }
		 return flag;
	}
}

