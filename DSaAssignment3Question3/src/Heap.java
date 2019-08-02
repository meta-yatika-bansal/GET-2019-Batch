import java.util.ArrayList;
import java.util.List;

/*
 * Represents heap
 */
public class Heap {
	Bowler[] heap ;
	int size;
	int maxsize;

	public Heap(int maxsize){
		this.maxsize = maxsize;
		this.size = -1;
		heap = new Bowler[this.maxsize];
	}

	/**
	 * Adds a bowler to heap
	 * @param b is the bowler
	 */
	public void add(Bowler[]  b){
		try{
			for(Bowler i : b){
				heap[++size] = i; 
				int current = size; 
				while (heap[current].quota > heap[parent(current)].quota) { 
					swap(current, parent(current)); 
					current = parent(current); 
				} 
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * Removes a bowler from heap
	 * @return bowler removed
	 */
	public List<String> removeMax(int quotaVirat){
		try{
			List<String> order = new ArrayList<String>();
			while(quotaVirat != 0){
				if(size != -1){
					Bowler max = heap[0];
					max.quota--;
					quotaVirat--;
					order.add(max.name);        
					size--;
					Bowler[] bowlerN = new Bowler[size];
					for(int i =0; i< size ; i++){
						bowlerN[i] = heap[i+1];
					}
					add(bowlerN);
				}
			}

			return order;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Finds parent of a given node
	 * @param position of node
	 * @return parent position
	 */
	private int parent(int position){
		return position/2;
	}

	/**
	 * Finds left Child of a given node
	 * @param position of node
	 * @return left Child position
	 */
	private int leftChild(int position){
		return (2*position +1);
	}

	/**
	 * Finds right Child of a given node
	 * @param position of node
	 * @return right Child position
	 */
	private int rightChild(int position){
		return (2*position+2);
	}

	/**
	 * Finds whether given node is leaf
	 * @param position of node
	 * @return true or false accordingly
	 */
	private boolean isLeaf(int position){
		if (position >= (size / 2) && position <= size) { 
			return true; 
		} 

		return false; 
	}

	/**
	 * Swap function
	 * @param a First Element
	 * @param b Second Element
	 */
	private void swap(int a, int b){
		Bowler swap;
		swap = heap[a];
		heap[a] = heap[b];
		heap[b] = swap;
	}

	/**
	 * heapify the heap 
	 * @param position of node
	 */
	public void maxHeapify(int position){
		try{
			if(isLeaf(position)){
				return;
			}
			if(heap[position].quota < heap[leftChild(position)].quota ||
					heap[position].quota < heap[rightChild(position)].quota ){
				if(heap[leftChild(position)].quota >  heap[rightChild(position)].quota){
					swap(position, leftChild(position));
					maxHeapify(leftChild(position));
				}else{
					swap(position, rightChild(position));
					maxHeapify(rightChild(position));
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
