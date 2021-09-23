package hashing;

import java.util.ArrayList;


public class LinearProbing {
	
	String[] hashTable;
	int usedCellNumber ;
	
	public LinearProbing(int size) {
		hashTable = new String[size];
		usedCellNumber = 0;
	}
	
	public int modASCIIHashTable(String word,int m) {
		char[] ch;
		ch = word.toCharArray();
		int i,sum;
		for(sum=0,i=0;i<ch.length;i++) {
			sum = sum + ch[i];
		}
		return sum % m;
	}
	
	public double getLoadFactor() {
		double loadFactor = usedCellNumber * 1.0/hashTable.length;
		return loadFactor;
	}
	
	public void rehashKeys(String word) {
		ArrayList<String> data = new ArrayList<>();
		for(String s : hashTable) {
			if(s != null) {
				data.add(s);
			}
		}
		data.add(word);
		hashTable = new String[hashTable.length *2];
		for(String s1: data) {
			insertInHashTable(s1);
		}
	}
	
	public void insertInHashTable(String word) {
		double loadFactor = getLoadFactor();
		if(loadFactor >= 0.75) {
			rehashKeys(word);
		}else {
			int index =modASCIIHashTable(word, hashTable.length);
			for(int i=index;i<index+hashTable.length;i++) {
				int newIndex = i % hashTable.length;
				if(hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println("The "+ word+" sucessfully inserted at location: "+newIndex);
					break;
				}else {
					System.out.println(newIndex+" is already occupied . Trying next empty cell");
				}
			}
		}
		usedCellNumber++;
	}
	
	public void displayHashTable() {
		if(hashTable == null) {
			System.out.println("\nHashTable does not exists");
			return;
		}else {
			System.out.println("\n-----HashTable-----");
			for(int i=0;i<hashTable.length;i++) {
				System.out.println("index "+i+ " key:"+hashTable[i]);
			}
		}
	}
	
	public boolean searchInHashTable(String word) {
		int index = modASCIIHashTable(word, hashTable.length);
		for(int i=index;i<index+hashTable.length;i++) {
			int newIndex = i % hashTable.length;
			if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				System.out.println(word+ " found at index " + newIndex+" in HashTable");
				return true;
			}
		}
		System.out.println(word+" not found in hashTable");
		return false;
	}
	
	public void deleteInHashTable(String word) {
		int index = modASCIIHashTable(word, hashTable.length);
		for(int i= index;i<index+hashTable.length;i++) {
			int newIndex = i % hashTable.length;
			if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				hashTable[newIndex] = null;
				System.out.println(word+" is deleted from HashTable");
				return;
			}
		}
		System.out.println(word+" not found in hashTable");
	}
	
	
	public static void main(String[] args) {

		LinearProbing lp = new LinearProbing(12);
		lp.insertInHashTable("The");
		lp.insertInHashTable("quick");
		lp.insertInHashTable("brown");
		lp.insertInHashTable("fox");
		lp.insertInHashTable("over");
		lp.insertInHashTable("value");
		lp.insertInHashTable("lot");
		lp.insertInHashTable("game");
		lp.insertInHashTable("plane");
		lp.insertInHashTable("tough");
		lp.insertInHashTable("best");
		lp.displayHashTable();
		
//		lp.searchInHashTable("b");
		
//		lp.deleteInHashTable("g");
		
//		lp.displayHashTable();
	}

}
