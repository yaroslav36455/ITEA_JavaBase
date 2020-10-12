package ua.itea.lesson18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main2 {

	public static void main(String[] args) {
		ArrayList<Hero> al = new ArrayList<>();

		al.add(new Pudge("Pudge name", 34));
		al.add(new CrystalMaiden("CrystalMaiden name", 12));
		al.add(new Sniper("Sniper name", 88));
		
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i).getUltimate());
		}
		
		CrystalMaiden crystalMaiden = new CrystalMaiden("CrystalMaiden name", 12);
		
		System.out.println(al.contains(crystalMaiden));
		
		al.add(crystalMaiden);
		System.out.println(al.lastIndexOf(crystalMaiden));
		
		al.remove(crystalMaiden);
		al.remove(crystalMaiden);
		System.out.println(al.size());
		
		
		LinkedList<Hero> ll = new LinkedList<>();
		ll.addAll(al);
		System.out.println(ll);
		
		
		HashSet<Integer> hashSet = new HashSet<>();
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
		TreeSet<Integer> treeSet = new TreeSet<>();
		
		for (int i = 0; i < 10; i++) {
			int random = (int) (Math.random() * 101);
			
			System.out.print(random + ", ");
			
			hashSet.add(random);
			linkedHashSet.add(random);
			treeSet.add(random);
		}
		System.out.println();
		
		System.out.println("HS: " + hashSet);
		System.out.println("LHS:" + linkedHashSet);
		System.out.println("TS: " + treeSet);
		
		Iterator<Integer> iter = linkedHashSet.iterator();
		
		while (iter.hasNext()) {
			Integer i = iter.next();
			
			if (i % 2 == 0) {
				iter.remove();
			}
		}
		
		System.out.println("LHS:" + linkedHashSet);
		
		treeSet.removeAll(linkedHashSet);
		System.out.println("TS: " + treeSet);
		
		treeSet.retainAll(linkedHashSet);
		System.out.println("TS: " + treeSet);
		
		treeSet.addAll(linkedHashSet);
		System.out.println("TS: " + treeSet);
	}

}
