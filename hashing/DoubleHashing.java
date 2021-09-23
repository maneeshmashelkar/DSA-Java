package hashing;

import java.util.ArrayList;

public class DoubleHashing {
	String[] hashTable;
	int noOfCellUsedInHashTable;

	public DoubleHashing(int size) {
		hashTable = new String[size];
		noOfCellUsedInHashTable = 0;
	}

	public int simpleASCIIHashTable(String word, int m) {
		char[] ch;
		ch = word.toCharArray();
		int i, sum;
		for (sum = 0, i = 0; i < ch.length; i++) {
			sum = sum + ch[i];
		}
		return sum % m;
	}

	public double getLoadFactor() {
		return noOfCellUsedInHashTable * 1.0 / hashTable.length;
	}
	
	private  int addAllDigitsTogether(int sum) {
		int value=0;
		while(sum >0) {
			value = sum%10;
			sum = sum / 10;
		}
		return value;
	}
	
	public int secondHashFunction(String x,int m) {
		char ch[];
		ch = x.toCharArray();
		int i,sum;
		for(sum=0,i=0;i<x.length();i++) {
			sum += ch[i];
		}
		while(sum > hashTable.length) {
			sum = addAllDigitsTogether(sum);
		}
		return sum % m;
	}
	
	
	

	public void rehashKeys(String word) {
		ArrayList<String> data = new ArrayList<>();
		for (String s : hashTable) {
			if (s != null) {
				data.add(s);
			}
		}
		data.add(word);
		hashTable = new String[hashTable.length * 2];
		for (String s1 : data) {
			insertInHashTable(s1);
		}
	}

	public void insertInHashTable(String word) {
		double loadFactor = getLoadFactor();
		if (loadFactor >= 0.75) {
			rehashKeys(word);
		} else {
			int x = simpleASCIIHashTable(word, hashTable.length);
			int y = secondHashFunction(word, hashTable.length);
			for (int i = 0; i < hashTable.length; i++) {
				int newIndex = (x + i*y) % hashTable.length;
				if (hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println("The " + word + " sucessfully inserted at location: " + newIndex);
					break;
				} else {
					System.out.println(newIndex + " is already occupied . Trying next empty cell");
				}
			}
		}
		noOfCellUsedInHashTable++;
	}

	public void displayHashTable() {
		if (hashTable == null) {
			System.out.println("\nHashTable does not exists");
			return;
		} else {
			System.out.println("\n-----HashTable-----");
			for (int i = 0; i < hashTable.length; i++) {
				System.out.println("index " + i + " key:" + hashTable[i]);
			}
		}
	}

	public boolean searchInHashTable(String word) {
		int x = simpleASCIIHashTable(word, hashTable.length);
		int y = secondHashFunction(word, hashTable.length);
		for (int i = 0; i < hashTable.length; i++) {
			int newIndex = (x + i*y) % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				System.out.println(word + " found at index " + newIndex + " in HashTable");
				return true;
			}
		}
		System.out.println(word + " not found in hashTable");
		return false;
	}

	public void deleteInHashTable(String word) {
		int x = simpleASCIIHashTable(word, hashTable.length);
		int y = secondHashFunction(word, hashTable.length);
		for (int i = 0; i < hashTable.length; i++) {
			int newIndex = (x + i*y) % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				hashTable[newIndex] = null;
				System.out.println(word + " is deleted from HashTable");
				return;
			}

		}
		System.out.println(word + " not found in hashTable");
	}
	
	public static void main(String[] args) {
		QuadraticProbing qp = new QuadraticProbing(15);
		qp.insertInHashTable("The");
		qp.insertInHashTable("quick");
		qp.insertInHashTable("brown");
		qp.insertInHashTable("fox");
		qp.insertInHashTable("over");
		qp.insertInHashTable("value");
		qp.insertInHashTable("lot");
		qp.insertInHashTable("game");
		qp.insertInHashTable("plane");
		qp.insertInHashTable("tough");
		qp.insertInHashTable("best");
		qp.displayHashTable();

		qp.searchInHashTable("best");

		qp.deleteInHashTable("best");

		qp.displayHashTable();
	}

}
