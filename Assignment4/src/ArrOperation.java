/*
 * Performs different operations on array.
 * Input is the array of integers.
 * Integers are assumed to be positive.
 * @since 17-July-2019
 */
public class ArrOperation {

	/**
	 * Splits the array such that sum of numbers is equal both side.
	 * @param arr array to be passed
	 * @return the index at which the array is split
	 */
	int splitArray(int[] arr) {
		int len = arr.length;
		if(len == 0) {
			throw new AssertionError();
		}
		
		int sum = 0;
		int totalSum = 0;
		int j = 0;
		for(int i = 0 ; i<len ; i++){
			totalSum += arr[i];
		}
		
		if(totalSum % 2 == 0){
			while(sum != totalSum/2 && j<len){
				sum += arr[j];
				j++;
			}
			return (sum == (totalSum/2)) ? j : -1;
		}else{
			return -1;
		}
	}

	/**
	 * Performs operation such that every X in array is followed by Y.
	 * @param arr array to be passed
	 * @param X fixed element of array
	 * @param Y follows every occurrence of X
	 * @return resultant array
	 */
	int[] fixXY(int[] arr , int X , int Y) {
		if(arr.length == 0) {
			throw new AssertionError();
		}

		int[] indexX = searchAllIndex(X,arr);
		int[] indexY = searchAllIndex(Y,arr);
		if(indexX.length != indexY.length) {
			throw new AssertionError();
		}
		for(int i = 0 ; i<indexX.length-1 ; i++) {
			if(indexX[i] == indexX[i+1]-1) {
				throw new AssertionError();
			}
		}
		
		if(arr[arr.length-1] == X) {
			throw new AssertionError();
		}
		
		for(int index = 0 ; index<indexX.length ; index++) {
			int swap = arr[indexX[index]+1];
			arr[indexX[index]+1] = arr[indexY[index]];
			arr[indexY[index]] = swap;
		}

		return arr;
	}

	/**
	 * Searches the given item in the array
	 * @param item is the element to be searched
	 * @param arr array to be passed
	 * @return array containing index of every occurrence of item.
	 */
	int[] searchAllIndex(int item , int[] arr) {
		int len = arr.length;
		int count = 0;
		int j = 0;
		for(int i = 0 ; i<len ; i++) {
			if(arr[i] == item) {
				count++;
			}
		
		}
		
		int []index = new int[count];
		for(int i = 0 ; i<len ; i++) {
			if(arr[i] == item) {
				index[j] = i;
				j++;
			}
		}

		return index;
	}

	/**
	 * Counts the clumps in an array
	 * @param arr array to be passed
	 * @return number of clumps
	 */
	int countClumps(int[] arr){
		int len = arr.length;
		if(len == 0) {
			throw new AssertionError();
		} 
		
		boolean flag = false;
		int clump = 0;
		for(int i = 0 ; i<len-1 ; i++){
			if(arr[i] == arr[i+1]){
				flag = true;
			}else{
				if(flag){
					clump++;
					flag = false;
				}
			}
		}
		
		if(flag){
			clump++;
		}

		return clump;    
	}

	/**
	 * Finds largest mirror section in array
	 * @param arr array to be passed
	 * @return length of the largest mirror section
	 */
	int  maxMirror(int[] arr){
		int len = arr.length;
		if(len == 0) {
			throw new AssertionError();
		}
		
		int maxCount = 0;
		for(int i = 0 ; i<len ; i++){
			int count = 0;
			for(int j = len-1 ; j >= 0 && i + count<len ; j--){
				if(arr[i + count] == arr[j]){
					count++;
				}else{
					maxCount = Math.max(maxCount , count);
					count = 0;
				}
			}

			maxCount = Math.max(maxCount , count);
		}

		return maxCount;
	}

}