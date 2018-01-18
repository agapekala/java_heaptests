package pl.edu.agh.kis.java2015.domain;

import java.util.ArrayList;

public class Heap {

	private int heapSize = 0;
	private ArrayList<Double> tab = new ArrayList<>();

	public void insert(double value) {
		int currentIndex = heapSize;
		int parentIndex = parentIndex(currentIndex);
		tab.add(value);
		while( isChildGreaterThanParent(currentIndex, parentIndex) ) {
			swapElements(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = parentIndex(currentIndex);
		}
		heapSize++;
	}

	public boolean isChildGreaterThanParent(int currentIndex, int parentIndex) {
		return tab.get(currentIndex) > tab.get(parentIndex);
	}

	public void swapElements(int currentIndex, int parentIndex) {
		Double parentValue = parentValue(currentIndex);
		Double currentValue = tab.get(currentIndex);
		tab.set(parentIndex, currentValue);
		tab.set(currentIndex, parentValue);
	}

	public Double parentValue(int currentIndex) {
		Double parentValue = tab.get(parentIndex(currentIndex));
		return parentValue;
	}

	public int parentIndex(int currentIndex) {
		return currentIndex/2;
	}

	public int size() {
		return heapSize ;
	}

	public double top() {
		return tab.get(0);
	}

	public double extract_max(){
		double tmp = this.tab.get(0);
		tab.remove(0);
		heapify(tab);
		return tmp;
	}

	public void delete_max(){
		tab.remove(0);
		heapify(tab);
	}


	public void heapify(ArrayList<Double> tab1){
		Heap h=new Heap();
		for(int i=0; i<tab1.size(); i++){
			h.insert(tab1.get(i));
		}
		tab = h.tab;
		heapSize=h.heapSize;

	}

	public void replace(double new_element){
		tab.set(0,new_element);
		heapify(tab);
	}

	public void meld(Heap heap){
		for(int i=0; i<heap.heapSize; i++){
			insert(heap.tab.get(i));
		}
	}

	public void merge(Heap heap1, Heap heap2){
		tab=heap1.tab;
		tab.addAll(heap2.tab);
		heapify(tab);
		heapSize=heap1.size()+heap2.size();
	}


}
