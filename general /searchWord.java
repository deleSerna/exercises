/**
* Given an NxN grid of alphabets. You need to search one word in that grid. 
* Word can be present in any row (in reverse order too), 
* any column (in reverse order too)  or any diagonal contiguously
* Epic system coding question
* Code adopted from http://pastebin.com/4ptu8VFi
*/
public class searchWord{

	public static void main(String[] args){
		System.out.println("Enter the matrix size");
		java.util.Scanner inp = new java.util.Scanner(System.in);
		int n = inp.nextInt();
		System.out.println("Enter the word");
		String word = inp.next();
		int wordSize = word.length();
		String [] matrix = new String [n];
		System.out.println("Enter th matrix rowwise");
		int count = 0;
		StringBuilder sb = new StringBuilder();
		int rightLimit = n - wordSize;
		int bottomLimit = n - wordSize;
		while(count < n){
			matrix[count] = inp.next();
			count++;
		}
	
		for(int i = 0; i < n;i++){
			for(int j = 0; j < n; j++){
				if(j  <= rightLimit){
					sb.setLength(0);
					sb.append(matrix[i].substring(j,j + wordSize));
					if((word.equals(sb.toString())) || (word.equals((sb.reverse()).toString()))){
						System.out.println("Found at"+ (i+1) +"th row" + (j+1) + " th column in row wise ");
						return;
					}
					
				}
				 if (j <= bottomLimit){
					sb.setLength(0);
					for(int k=0;k<wordSize;k++)
						sb.append(matrix[i+k].substring(j,j+1));
						if((word.equals(sb.toString())) || (word.equals((sb.reverse()).toString()))){
						System.out.println("Found at"+ (i+1) +"th row" + (j+1) + " th column in columnwise ");
						return;
					}
				}
				 if ((j <= bottomLimit) && (j <= rightLimit)){
					sb.setLength(0);
					for(int k=0;k<wordSize;k++)
						sb.append(matrix[i+k].substring(j+k,j+k+1));
						if((word.equals(sb.toString())) || (word.equals((sb.reverse()).toString()))){
						System.out.println("Found at"+ (i+1) +"th row" + (j+1) + " th column in diagonal ");
						return;
					}
				}

			}
	

		}	

	}



}
