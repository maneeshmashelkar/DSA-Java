package trie;

public class Trie {
	
	public TrieNode root;
	
	public Trie() {
		root = new TrieNode();
		System.out.println("Trie has been created");
	}
	
	//insert
	public void insert(String word) {
		TrieNode current = root;
		
		for (int i=0;i<word.length();i++) {
			Character ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node ==null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfString= true;
		System.out.println("inserted "+word+" in Trie");
	}
	
	// search 
	public boolean search(String word) {
		TrieNode current  = root;
		
		for(int i=0;i<word.length();i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			
			if(node == null) {
				System.out.println("Word: "+word+" does not exist in Trie");
				return false;
			}
			current =node;
		}
		if(current.endOfString == true) {
			System.out.println("Word: " + word +" exist in Trie");
			return true;
		}else {
			System.out.println("Word: "+word+ " does not exist,but it is prefix of another string");
			return false;
		}
	}
	
	//delete 
	private boolean delete(TrieNode parentNode,String word,int index) {
		char ch = word.charAt(index);
		TrieNode current = parentNode.children.get(ch);
		boolean canThisNodeBeDeleted;
		
		if(current.children.size() > 1) {
			delete(current, word, index+1);
			return false;
		}
		if(index == word.length() -1) {
			if(current.children.size()>=1) {
				current.endOfString = false;
				return false;
			}else {
				parentNode.children.remove(ch);
				return true;
			}
		}
		if(current.endOfString == true) {
			delete(current, word, index+1);
			return false;
		}
		canThisNodeBeDeleted = delete(current, word, index+1);
		if(canThisNodeBeDeleted == true) {
			parentNode.children.remove(ch);
			return true;
		}else {
			return false;
		}
		
	}
	
	public void delete(String word) {
		if(search(word)==true) {
			delete(root,word,0);
		}
	}
	
	public static void main(String[] args) {
		
		Trie t= new Trie();
		
		t.insert("man");
		t.insert("mat");
		
		t.search("man");
		
		t.delete("man");
		
		t.search("man");
		
	}

}
