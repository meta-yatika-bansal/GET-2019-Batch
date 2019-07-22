/*
 * It performs various operations on Sets.
 * Set is assumed to have Integers in the range [1-1000].
 * @since 20-July-2019
 */
public final class IntSet {
	final int[] array;
    
	/**
	 * Constructor initializes array
	 * @param array is the input array
	 */
	IntSet(int[] array){
		this.array = array;
	}
	
    /**
     * It checks whether the input is a Set
     * @return true or false accordingly
     */
	private Boolean isSet(){
		for(int i = 0 ; i < array.length ; i++) {
			for(int j = i+1 ; j < array.length ; j++) {
				if(array[i]==array[j]) {
					return false;
				}
			}
			
			continue;
		}
		
		return true;
	}
    
	/**
	 * It searches a given element in the Set
	 * @param x is the element to be searched
	 * @return true or false accordingly
	 */
	private Boolean search(int x){
		for(int i = 0 ; i <size() ; i++){
			if(array[i]==x){
				return true;
			}
		}
		
		return false;
	}
   
	/**
	 * It checks whether a given element is a member of Set
	 * @param x is the element to be checked
	 * @return true or false accordingly
	 */
	public Boolean isMember(int x){
		if(isSet()) {
			return this.search(x);
		}else {
			throw new AssertionError();
		}
	}
    
	/**
	 * Computes Size of the Set
	 * @return Size
	 */
	public int size(){
		if(isSet()) {
			return array.length;
		}else {
			throw new AssertionError();

		}
	}
    
	/**
	 * It checks whether given set is a Subset
	 * @param s is the set to be checked
	 * @return true or false accordingly
	 */
	public Boolean isSubset(IntSet s){
		if(isSet() && s.isSet() ) {
			for(int i = 0 ; i < s.size() ; i++){
				if(!this.search(s.array[i])){
					return false;
				}
			}
			
			return true;
		}else {
			throw new AssertionError();

		}
	}
    
	/**
	 * Computes complement of given Set
	 * @return Complement Set
	 */
	public int[] getComplement(){
		if(isSet()) {
			int[] arrayComplement = new int[1000-size()];
			int j = 0;
			for(int i = 1 ; i <= 1000 ; i++){
				if(!isMember(i)){
					arrayComplement[j]=i;
					j++;
				}
			}
			
			return arrayComplement;
		}else {
			throw new AssertionError();

		}
	}
    
	/**
	 * Computes union of two Sets
	 * @param s1 is the first Set
	 * @param s2 is the second Set
	 * @return Union Set
	 */
	public int[] union(IntSet s1, IntSet s2){
		if(s1.isSet() && s2.isSet()) {
			int[] unionArray = new int[s1.size()+s2.size()];
			int k = 0;
			for(int i = 0 ; i < s1.size() ; i++) {
				if(!s2.search(s1.array[i])) {
					unionArray[k] = s1.array[i];
					k++;
				}
			}
			
			for(int j = 0 ; j < s2.size() ; j++) {
				unionArray[k] = s2.array[j];
				k++;
			}
			
			int[] array= new int[k];
			for(int i = 0 ; i < k ; i++){
				array[i] = unionArray[i];
			}
			
			return array;
		}else {
			throw new AssertionError();

		}
	}
}
