/*
*Inversion Count for an array indicates – how far (or close) the array is from being sorted. 
*If array is already sorted then inversion count is 0. 
*If array is sorted in reverse order that inversion count is the maximum.
* Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
*Example:The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

*/
public class inversionCount{

static int mergeSort(int array[],int beg, int end){
	int count1 = 0,count2 = 0, count3 = 0, mid;
	if(beg < end){
		mid = (beg + end)/2;
		count1 = mergeSort(array,beg,mid);
		count2 = mergeSort(array, mid +1, end);
		count3 = merge(array,beg,mid,end);
	
	}

	return count1+count2+count3;


}

static int merge(int a[],int beg,int mid,int end){
	int b [] = new int [5];
	int j = mid +1,i = beg,k = 0,count = 0;

	while((i <= mid) && (j <= end)){
		if(a[i] <= a[j]){
			b[k] = a[i];
			i++;
		}else{
			b[k] = a[j];
			//count = count + (end - (j-1)); // cuurent element in 1st arry is bigger than all remainin elemnt in second array
			count = count + (mid+1) - i; // If commenting this line uncomment aboave line and line no 46,47 then also this will work
			j++;		// But the method used here (not commented ) is efficient
		}
		k++;
	}
	while(i <= mid){
		b[k] = a[i];
		k++;
		//if( i != mid)  // i == mid already count in else part of above  to avoid repetition remove this count
		 //count = count + (end - mid); // all remaining elements in 1st arry is bigger than all element originally contained in 2nd array
		i++;
	}
	while(j <= end){
		b[k] = a[j];
		k++;
		j++;
	}
	i = beg;
	for(int m = 0; m<k; m++){
		a[i] = b[m];
		i++;
	}	
	
 return count;



}



public static void main(String args[]){
int array [] = {2,4,1,3,5};
System.out.println("InversionCount="+mergeSort(array,0,4));
System.out.println("Sorted elements are");
for(int i =0; i<=4;i++)
	System.out.println(array[i]);

}

}
