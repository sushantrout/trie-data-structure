package com.tech.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tech.TrieMapDTO;

public class TrieMapImplementation {
	public static void main(String[] args) {
		TrieMapDTO root = new TrieMapDTO();

		List<String> keys = Arrays.asList("apple", "apps", "apxl", "bac", "bat", "batter");

		for (String key : keys) {
			insert(key, root);
		}
		
		System.out.println("=============================");
		System.out.println("Print all node");
		System.out.println("=============================");
		print(root, "ap");
		System.out.println("=============================");
		searchFromTrie("bat", root);
		
		System.out.println("=============================");
		TrieMapDTO startWIth = startWIth("ap", root);
		
		System.out.println("Print by prefix");
		System.out.println("=============================");
		print(startWIth, "ap");
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
	
	private static TrieMapDTO startWIth(String searchWord, TrieMapDTO root) {
		if(searchWord.isEmpty()) {
			return root;
		} else {
			char charAt = searchWord.charAt(0);
			TrieMapDTO trieMapDTO = root.getChildrenMap().get(charAt+"");
			return startWIth(searchWord.substring(1, searchWord.length()), trieMapDTO);
		}
	}

	private static void print(TrieMapDTO root, String word) {
		if(root != null && root.isEw()) {
			System.out.println(word);
		}
		Map<String, TrieMapDTO> childrenMap = root.getChildrenMap();
		Set<String> keySet = childrenMap.keySet();
		for(String key : keySet) {
			print(childrenMap.get(key), word + key);
		}
	}
}
