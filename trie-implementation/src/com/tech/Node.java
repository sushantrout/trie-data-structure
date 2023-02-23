package com.tech;

public class Node {
	Node[] chihldren;
	boolean eow;

	public Node() {
		chihldren = new Node[26];
		for (int i = 0; i < 26; i++) {
			chihldren[i] = null;
		}
		eow = false;
	}

	public Node[] getChihldren() {
		return chihldren;
	}

	public void setChihldren(Node[] chihldren) {
		this.chihldren = chihldren;
	}

	public boolean isEow() {
		return eow;
	}

	public void setEow(boolean eow) {
		this.eow = eow;
	}

}
