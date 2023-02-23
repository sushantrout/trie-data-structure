package com.tech.test;

import com.tech.Node;

public class TrieUtil {
	public static void createNode(String key, Node currentRoot) {
		if (key.isEmpty()) {
			currentRoot.setEow(true);
			return;
		} else {
			Node[] chihldren = currentRoot.getChihldren();
			int index = key.charAt(0) - 'a';
			Node newNode = chihldren[index];
			if (newNode == null) {
				newNode = new Node();
				chihldren[index] = newNode;
			}
			currentRoot = newNode;
			createNode(key.substring(1, key.length()), currentRoot);
		}
	}

	public static boolean searchInTrie(String key, Node root) {
		if (root == null || ((!root.isEow()) && key.isEmpty())) {
			return false;
		} else if (root.isEow() && key.isEmpty()) {
			return true;
		} else {
			char charAt = key.charAt(0);
			return searchInTrie(key.substring(1, key.length()), root.getChihldren()[charAt - 'a']);
		}
	}

	public static Node startWith(String key, Node root) {
		if (root == null || key.isEmpty()) {
			return root;
		} else {
			char charAt = key.charAt(0);
			return startWith(key.substring(1, key.length()), root.getChihldren()[charAt - 'a']);
		}
	}

	public static void print(Node root, String output) {
		if (root == null) {
			return;
		}
		if (root.isEow()) {
			System.out.println(output);
		}
		Node[] chihldren = root.getChihldren();
		for (int i = 0; i < chihldren.length; i++) {
			Node currentNode = chihldren[i];

			if (currentNode != null) {
				output = output + (char) (i + 'a');
				print(currentNode, output);
				output = output.substring(0, output.length() - 1);
			}
		}
	}
}
