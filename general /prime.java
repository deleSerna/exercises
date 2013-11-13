
/**
 * Program to  check a number is prime

*/
public class prime{
	
	static boolean isPrime(int n){
		int s = (int)Math.sqrt(n);
		int i = 2;
		for(;i<=s;i++)
			if(n%i==0)
				return false;
		return true;	


	}

	public static void main(String [] args){

	java.util.Scanner inp = new java.util.Scanner(System.in);
	int n = 2;
	while(inp.hasNext()){
		n = inp.nextInt();	
	}
	if(isPrime(n))
		System.out.println(n+" is prime");

	}
}
