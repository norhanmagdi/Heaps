package eg.edu.alexu.csd.filestructure.sort;


import java.util.ArrayList;

public class Sort <T extends Comparable<T>> implements ISort {
	@Override
	public IHeap heapSort(ArrayList unordered) {
		return null;
	}

	@Override
	public void sortSlow(ArrayList unordered) {
		//bubble sort
		if(unordered==null||unordered.size()==0)
			return;
		for (int i=0;i<unordered.size();i++){
			for(int j=0;j<unordered.size()-1-i;j++){
				Comparable cur = (Comparable) unordered.get(j);
				Comparable next = (Comparable) unordered.get(j+1);
				if(cur.compareTo(next)>0){
					unordered.set(j,next);
					unordered.set(j+1,cur);

				}
			}
		}

	}


	@Override
	public void sortFast(ArrayList unordered) {
		if(unordered == null || unordered.size() == 0) return;
		int l = 0;
		int r = unordered.size() - 1;
		mergeSort(unordered, l, r);
	}

	private void mergeSort(ArrayList array, int l, int r) {
		if(l >= r) return;
		int m = (l + r) / 2;
		mergeSort(array, l, m);
		mergeSort(array, m + 1, r);
		merge(array, l, r, m);
	}

	private void merge(ArrayList array, int l, int r, int m) {
		int j = m + 1;
		int i = l;
		ArrayList n = new ArrayList();
		while(i <= m && j <= r) {
			Comparable eleL = (Comparable) array.get(i);
			Comparable eleR = (Comparable) array.get(j);
			if(eleL.compareTo(eleR) > 0) {
				n.add(eleR);
				j++;
			} else {
				n.add(eleL);
				i++;
			}
		}
		while(i <= m) {
			Comparable eleL = (Comparable) array.get(i);
			n.add(eleL);
			i++;
		}
		while(j <= r) {
			Comparable eleR = (Comparable) array.get(j);
			n.add(eleR);
			j++;
		}
		for(i = 0; i < n.size(); i++) {
			array.set(l + i, n.get(i));
		}
	}



//	public static void main(String args[])
//	{
//		ArrayList<Integer> n =new ArrayList<Integer>();
//		n.add(12);
//		n.add(11);
//		n.add(13);
//		n.add(5);
//		n.add(6);
//		n.add(7);
//
//
//		System.out.println(n);
//
//		Sort ob = new Sort();
//		ob.mergeSort(n,0,n.size()-1);
//
//		System.out.println("\nSorted array");
//		System.out.println(ob.toString());
//	}


}
