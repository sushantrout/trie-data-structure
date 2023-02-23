package com.tech.test;

import com.tech.Node;

public class TriImplemenattionTest {
	static Node root = new Node();

	public static void main(String[] args) {
		String words[] = { "the", "a", "there", "their", "any" };

		for (String node : words) {
			createNode(node, root);
		}
		
		searchInTrie("a", root);
		

	}

	private static void createNode(String node, Node currentRoot) {
		if (node.isEmpty()) {
			currentRoot.setEow(true);
			return;
		} else {
			Node[] chihldren = currentRoot.getChihldren();
			int index = node.charAt(0) - 'a';
			Node newNode = chihldren[index];
			if (newNode == null) {
				newNode = new Node();
				chihldren[index] = newNode;
			}
			currentRoot = newNode;
			createNode(node.substring(1, node.length()), currentRoot);
		}
	}

	private static  void searchInTrie(String key, Node root) {
		if (root == null || ((!root.isEow()) && key.isEmpty())) {
			System.out.println("Not found");
			return;
		} else if (root.isEow() && key.isEmpty()) {
			System.out.println("Found");
			return;
		} else {
			char charAt = key.charAt(0);
			searchInTrie(key.substring(1, key.length()), 
					root.getChihldren()[charAt - 'a']);
		}
	}
}
