package pl.edu.agh.kis.java2015.domain;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

public class HeapTest {
	
	@Test
	public void insert0intoNewHeap_topIs0() {
		
		Heap heap = new Heap();
		heap.insert(0);
		
		assertEquals("size should be 1",1,heap.size());
		assertEquals(0,heap.top(),0.001);
		assertEquals(1,heap.size());
	}
	
	@Test
	public void insert0AndThen2intoNewHeap_topIs2() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		
		assertEquals("size should be 2",2,heap.size());
		assertEquals(2,heap.top(),0.001);
	}
	
	@Test
	public void insert0And2And3And5And6intoNewHeap_topIs6() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		
		assertEquals(6,heap.top(),0.001);
	}

	@Test
	public void heapifyTests(){
		Heap heap=new Heap();

		ArrayList<Double> lista=new ArrayList<>();
		lista.add(5.0);
		lista.add(8.0);
		lista.add(1.0);
		lista.add(15.0);
		lista.add(9.0);
		lista.add(11.0);

		heap.heapify(lista);

		assertEquals(15,heap.top(),0.001);
		assertEquals(6,heap.size());
	}
	@Test
	public void extract_maxTests(){
		Heap heap = new Heap();
		heap.insert(7);
		heap.insert(5);
		heap.insert(10);
		assertEquals(10,heap.extract_max(),0.001);
	}

	@Test
	public void delete_maxTests(){
		Heap heap = new Heap();
		heap.insert(7);
		heap.insert(5);
		heap.insert(10);

		heap.delete_max();
		assertEquals("size should be 2",2,heap.size());
		assertEquals(7,heap.top(),0.001);
	}

	@Test
	public void replaceTests(){
		Heap heap=new Heap();
		heap.insert(7);
		heap.insert(5);
		heap.insert(10);
		heap.insert(13);

		heap.replace(8);
		assertEquals(10,heap.top(),0.001);
		assertEquals(4,heap.size());
	}

	@Test
	public void meldTests(){
		Heap heap=new Heap();
		heap.insert(7);
		heap.insert(5);
		heap.insert(10);
		heap.insert(13);

		Heap heap2=new Heap();
		heap2.insert(4);
		heap2.insert(14);
		heap2.insert(9);

		heap.meld(heap2);
		assertEquals(14,heap.top(),0.001);
		assertEquals(7,heap.size());
	}
	@Test
	public void mergeTests(){
		Heap heap_result=new Heap();
		Heap heap1=new Heap();
		Heap heap2=new Heap();

		heap1.insert(7);
		heap1.insert(5);
		heap1.insert(10);
		heap1.insert(13);

		heap2.insert(1);
		heap2.insert(4);
		heap2.insert(14);
		heap2.insert(9);


		heap_result.merge(heap1,heap2);
		assertEquals("size should be 8",8,heap_result.size());
		assertEquals(14,heap_result.top(),0.01);
		assertEquals(4,heap1.size());
		assertEquals(13,heap1.top(),0.001);
		assertEquals(14,heap2.top(),0.001);
		assertEquals(4,heap2.size());

	}

}
