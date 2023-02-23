package com.tech.test;

import com.tech.Node;

public class TriImplemenattionTest {
	static Node root = new Node();

	public static void main(String[] args) {
		String words[] = { "the", "a", "there", "their", "any", "then" };

		for (String node : words) {
			TrieUtil.createNode(node, root);
		}

		boolean searchInTrie = TrieUtil.searchInTrie("an", root);
		System.out.println(searchInTrie);
		searchInTrie = TrieUtil.searchInTrie("any", root);
		System.out.println(searchInTrie);
		
		Node startWith = TrieUtil.startWith("the", root);
		TrieUtil.print(startWith, "the");
	}
}
