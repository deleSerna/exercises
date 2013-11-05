/** 
* Find next closest palindrome number
* Idea taken from http://www.careercup.com/question?id=237693
* It's not working for 99,999 etc

*/
public class palindrome{

      	static int nextPalindrome(String n){
		String m = n;
		StringBuilder a,b ;
		if(m.length() %2 == 0){
			String z = m.substring(0,(m.length()/2));
			a = new StringBuilder(z);	
			a.reverse();
			//System.out.println("a="+a.toString()+"b="+z);
			a = a.insert(0,z); 
			//int b = Integer.parseInt(a.toString()); 
			//System.out.println(b);
			if(Integer.parseInt(a.toString()) > Integer.parseInt(n))
				return  Integer.parseInt(a.toString());
			else{
				int x = Integer.parseInt(z) + 1;
				b = new StringBuilder(String.valueOf(x));
				b.reverse();
				b = b.insert(0,String.valueOf(x));
				return Integer.parseInt(b.toString());
			}
		}else{
			String z = m.substring(0,(m.length()/2) + 1);
			a = new StringBuilder(z);	
			a.reverse();
			System.out.println("a="+a.toString()+"b="+z);
			a = a.insert(0,z.substring(0,z.length() - 1)); 
			//int b = Integer.parseInt(a.toString()); 
			//System.out.println(b);
			if(Integer.parseInt(a.toString()) > Integer.parseInt(n))
				return  Integer.parseInt(a.toString());
			else{
				int x = Integer.parseInt(z) + 1;
				b = new StringBuilder(String.valueOf(x));
				b.reverse();
				String y = String.valueOf(x);
				b = b.insert(0,y.substring(0,y.length() - 1));
				return Integer.parseInt(b.toString());
			}

		}

	}


	public static void main(String[] args){
	java.util.Scanner inp = new java.util.Scanner(System.in);
	System.out.println("Enter the number");
	String n = inp.next();
	int m = nextPalindrome(n);
	System.out.println("Next closest palindrome is "+ m);
	}

}
