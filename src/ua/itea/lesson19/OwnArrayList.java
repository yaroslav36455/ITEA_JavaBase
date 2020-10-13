package ua.itea.lesson19;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class OwnArrayList implements List<Dog> {
	private int size = 0; 
	private Dog[] dogs = new Dog[3];
	
	@Override
	public boolean add(Dog e) {
		if(size >= dogs.length) {
			extend();
		}
		
		dogs[size++] = e;
		return true;
	}
	
	private void extend() {
		Dog[] newArray = new Dog[dogs.length * 2];
		
		System.arraycopy(dogs, 0, newArray, 0, dogs.length);
		dogs = newArray;
	}
	
	@Override
	public void add(int index, Dog element) {
		if(size >= dogs.length) {
			extend();
		}
		
		System.arraycopy(dogs, index, dogs, index + 1, size - index);
		dogs[index] = element;
		size++;
	}
	@Override
	public boolean addAll(Collection<? extends Dog> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(int index, Collection<? extends Dog> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Dog get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterator<Dog> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ListIterator<Dog> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ListIterator<Dog> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean remove(Object o) {
		for (int i = 0; i < size; i++) {
			if (dogs[i].equals(o)) {
				if (i < size - 1) {
					System.arraycopy(dogs, i + 1, dogs, i, size - i);
				} else {
					dogs[i] = null;
				}

				size--;
				return true;
			}
		}
		return false;
	}
	@Override
	public Dog remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Dog set(int index, Dog element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public List<Dog> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "OwnArrayList [dogs=" + Arrays.toString(dogs) + "]";
	}
	
}
