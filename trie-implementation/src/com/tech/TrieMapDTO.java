package com.tech;

import java.util.LinkedHashMap;
import java.util.Map;

public class TrieMapDTO {
	Map<String, TrieMapDTO> childrenMap = new LinkedHashMap<>();
	boolean ew;

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

	@Override
	public String toString() {
		return "TrieMapDTO [childrenMap=" + childrenMap + ", ew=" + ew + "]";
	}

}
