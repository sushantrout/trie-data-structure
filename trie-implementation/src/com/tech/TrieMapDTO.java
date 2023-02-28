package com.tech;

import java.util.LinkedHashMap;
import java.util.Map;

public class TrieMapDTO {
	Map<String, TrieMapDTO> childrenMap = new LinkedHashMap<>();
	boolean ew;
	int count = 0;
	int completedCount = 0;

	public Map<String, TrieMapDTO> getChildrenMap() {
		return childrenMap;
	}

	public void setChildrenMap(Map<String, TrieMapDTO> childrenMap) {
		this.childrenMap = childrenMap;
	}

	public boolean isEw() {
		return ew;
	}

	public void setEw(boolean ew) {
		this.ew = ew;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCompletedCount() {
		return completedCount;
	}

	public void setCompletedCount(int completedCount) {
		this.completedCount = completedCount;
	}

}
