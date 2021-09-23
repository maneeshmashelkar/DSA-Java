package hashing;

import java.util.LinkedList;

public class DirectChaning {

	LinkedList<String>[] hashTable;
	int maxChainSize = 5;
	
	@SuppressWarnings("unchecked")
	public DirectChaning(int size) {
		hashTable = new LinkedList[size];
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
	
	public void insertHashTable(String word) {
		int newIndex = modASCIIHashTable(word, hashTable.length);
		
		if(hashTable[newIndex] == null) {
			hashTable[newIndex] = new LinkedList<>();
			hashTable[newIndex].add(word);
		}else {
			hashTable[newIndex].add(word);
		}
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
	
	public boolean  searchHashTable(String word) {
		int newIndex = modASCIIHashTable(word, hashTable.length);
		if(hashTable[newIndex] != null && hashTable[newIndex].contains(word)) {
			System.out.println("\n" + "\""+word+"\""+" found in HashTable at location: "+newIndex);
			return true;
		}else {
			System.out.println("\n" + "\""+word+"\""+" not found in HashTable");
			return false;
		}
	}
	
	public void deleteKeyHashTable(String word) {
		int newIndex = modASCIIHashTable(word, hashTable.length);
		boolean result = searchHashTable(word);
		if(result == true) {
			hashTable[newIndex].remove(word);
			System.out.println("\n" + "\""+word+"\""+" has been deleted from HashTable");
		}
	}
	
	
	public static void main(String[] args) {
		DirectChaning dc =new DirectChaning(10);
		dc.insertHashTable("The");
		dc.insertHashTable("book");
		dc.insertHashTable("Hello");
		dc.insertHashTable("Car");
		dc.insertHashTable("Time");
		
		dc.searchHashTable("Car");
		
		dc.deleteKeyHashTable("book");
		
		dc.displayHashTable();
	}

}
