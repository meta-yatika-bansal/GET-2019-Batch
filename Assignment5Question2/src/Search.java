/*
 * Performs Linear Search and Binary Search.
 * Input is the array of numbers and element to be searched.
 * Output is the index of element.
 * For Binary Search,array is assumed to be sorted.
 * @since 18-July-2019
 */
public class Search {
	int index = 0;
    
	/**
	 * Performs Linear Search
	 * @param array is the array of numbers
	 * @param element is the number to be searched
	 * @return index of the element in the array 
	 */
	int linearSearch(double[] array, double element){
		int len = array.length;
		if(len == 0 || index == len){
			return -1;
		}
		if(array[index] == element){
			return index;
		}else{
			index++;
			return linearSearch(array, element);
		}
	}
	
	/**
	 * Performs Binary Search
	 * @param array is the array of numbers
	 * @param element is the number to be searched
	 * @return index of the element in the array 
	 */
    int binarySearch(double[] array, double element, int firstIndex, int lastIndex){
    	if(firstIndex < 0 || lastIndex < 0 || array.length == 0 || firstIndex > lastIndex){
    		return -1;
    	}
    	int mid = ((firstIndex + lastIndex)/2);
    	if(array[mid] == element){
    		return mid;
    	}else {
    		if(array[mid] > element){
    			lastIndex = mid - 1;
    		}else{
    			firstIndex = mid + 1;
    		}
    		return binarySearch(array, element, firstIndex, lastIndex);
    	}

    }
}
