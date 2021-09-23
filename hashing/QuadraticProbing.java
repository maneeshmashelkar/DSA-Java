package hashing;

import java.util.ArrayList;

public class QuadraticProbing {
	String[] hashTable;
	int usedCellNumber;

	public QuadraticProbing(int size) {
		hashTable = new String[size];
		usedCellNumber = 0;
	}

	public int modASCIIHashTable(String word, int m) {
		char[] ch;
		ch = word.toCharArray();
		int i, sum;
		for (sum = 0, i = 0; i < ch.length; i++) {
			sum = sum + ch[i];
		}
		return sum % m;
	}

	public double getLoadFactor() {
		double loadFactor = usedCellNumber * 1.0 / hashTable.length;
		return loadFactor;
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
			int index = modASCIIHashTable(word, hashTable.length);
			int counter = 0;
			for (int i = index; i < index + hashTable.length; i++) {
				int newIndex = (index + (counter * counter)) % hashTable.length;
				if (hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println("The " + word + " sucessfully inserted at location: " + newIndex);
					break;
				} else {
					System.out.println(newIndex + " is already occupied . Trying next empty cell");
				}
				counter++;
			}
		}
		usedCellNumber++;
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
		int index = modASCIIHashTable(word, hashTable.length);
		int counter = 0;
		for (int i = index; i < index + hashTable.length; i++) {
			int newIndex = (index + (counter * counter)) % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				System.out.println(word + " found at index " + newIndex + " in HashTable");
				return true;
			}
			counter++;
		}
		System.out.println(word + " not found in hashTable");
		return false;
	}

	public void deleteInHashTable(String word) {
		int index = modASCIIHashTable(word, hashTable.length);
		int counter = 0;
		for (int i = index; i < index + hashTable.length; i++) {
			int newIndex = (index + (counter * counter)) % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				hashTable[newIndex] = null;
				System.out.println(word + " is deleted from HashTable");
				return;
			}
			counter++;
		}
		System.out.println(word + " not found in hashTable");
	}

	public static void main(String[] args) {

		QuadraticProbing qp = new QuadraticProbing(12);
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
