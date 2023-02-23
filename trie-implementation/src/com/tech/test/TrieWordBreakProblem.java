package com.tech.test;

import com.tech.Node;

public class TrieWordBreakProblem {
	public static void main(String[] args) {
		String[] words = { "i", "like", "sam", "samsung", "mobile", "ice" };
		
		String key = "ilikesamsungmobile";
		
		Node root = new Node();
		for(int i=0; i< words.length; i++) {
			TrieUtil.createNode(words[i], root);
		}
		
		boolean wordbreak = wordbreak(key, root);
		System.out.println(wordbreak);
	}

	private static boolean wordbreak(String key, Node root) {
		if(TrieUtil.searchInTrie(key, root)) {
			return true;
		} else {
			for(int i=1; i<key.length(); i++) {
				String fp = key.substring(0, i);
				if(TrieUtil.searchInTrie(fp, root) && wordbreak(key.substring(i), root)) {
					return true;
				}
			}
		}
		return false;
	}
}
