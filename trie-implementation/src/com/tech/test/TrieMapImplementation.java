package com.tech.test;

import java.util.Arrays;
import java.util.List;

import com.tech.TrieMapDTO;

public class TrieMapImplementation {
	public static void main(String[] args) {
		TrieMapDTO root = new TrieMapDTO();

		List<String> keys = Arrays.asList("apple", "apps", "apxl", "bac", "bat", "batter");

		for (String key : keys) {
			insert(key, root);
		}
		
		searchFromTrie("bat", root);
	}

	private static void searchFromTrie(String string, TrieMapDTO root) {
		if(root == null) {
			return;
		}
		root = root.getChildrenMap().get(string.charAt(0)+""); 
		String substring = string.substring(1, string.length());
		if(substring.isEmpty()) {
			boolean ew = root.isEw();
			if(ew) {
				System.out.println("Search found");
			} else {
				System.out.println("Not fond");
			}
			return;
		}
		searchFromTrie(substring, root);
	}

	private static void insert(String key, TrieMapDTO root) {
		if (root == null) {
			return;
		}
		if (key.isEmpty()) {
			root.setEw(true);
			return;
		} else {
			String currentKey = key.charAt(0)+"";
			TrieMapDTO trieMapDTO = root.getChildrenMap().get(currentKey);
			if (trieMapDTO == null) {
				trieMapDTO = new TrieMapDTO();
				root.getChildrenMap().put(currentKey, trieMapDTO);
			}
			insert(key.substring(1, key.length()), trieMapDTO);
		}
	}
	
	
}
