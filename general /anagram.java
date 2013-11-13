/**
* Program to check two words are anagram or not
* accept input in the format 
* total no of pair to check  -n
* word1  word2  -- first pair
* word3 word4  -- second pair 
* etc.... upto nth pair

*/

public class anagram{


	static boolean isAnagram(String word1, String word2){
		if((word1 == null) || (word2 == null))
		{
			return false;
		}else if(word1.length()!= word2.length()){
			return false;
		}else{
			char [] array1 = word1.toCharArray();
			char [] array2 = word2.toCharArray();
			java.util.Arrays.sort(array1);
			java.util.Arrays.sort(array2);
			return java.util.Arrays.equals(array1,array2);
		}
		
	}



	public static void main(String [] args){
		java.util.Scanner inp = new java.util.Scanner(System.in);
		java.util.ArrayList<String> words = new java.util.ArrayList<String>();
		int count = 0;
		while(inp.hasNext()){
			words.add(inp.next());
		}
		count = Integer.parseInt(words.get(0));
		System.out.println("Anagrams are");
		for(int i = 0;i < count;i++){

			if(isAnagram(words.get(2 * i + 1),words.get(2 *i + 2)))
				System.out.println(words.get(2 * i + 1)+"\t"+words.get(2 *i + 2));
		}

	}
}
