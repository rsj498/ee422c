package assignment3;

import java.util.ArrayList;
import java.util.Set;

public class DFSHelpers {
	public boolean isNeighbor(String wordA, String wordB) {
		boolean diffByOne = false;
		for (int i = 0; i < wordA.length(); i++) {
			if (wordA.charAt(i) != wordB.charAt(i)) {
				if (diffByOne) {
					return false;
				}
				else {
					diffByOne = true;
				}
			}
		}
		if (diffByOne) {
			return true;
		}
		return false;
	}
	
	public boolean diffByTwo(String a, String b) {
		int diffCount = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				if (diffCount > 2) {
					return false;
				}
				else {
					diffCount++;
				}
			}
		}
		if (diffCount <= 2) {
			return true;
		}
		return false;
	}
	
	public ArrayList<String> getNeighbors(String start, Set<String> dict) {
		ArrayList<String> neighbors = new ArrayList<String>();
		for (String word : dict) {
			if (isNeighbor(start, word)) {
				neighbors.add(word);
			}
		}
		return neighbors;
	}
	
	public ArrayList<String> reverse (ArrayList<String> path) {
		ArrayList<String> reversed = new ArrayList<String>();
		for (int i = path.size() - 1; i >= 0; i--) {
			reversed.add(path.get(i));
		}
		return reversed;
	}
	
	public ArrayList<String> sortNeighbors (ArrayList<String> neighbors, String end) {
		ArrayList<String> sortedNeighbors = new ArrayList<String>();
		for (int i = 0; i < neighbors.size(); i++) {
			if (diffByTwo(neighbors.get(i), end)) {
				sortedNeighbors.add(neighbors.get(i));
			}
		}
		for (int i = 0; i < neighbors.size(); i++) {
			if (!sortedNeighbors.contains(neighbors.get(i))) {
				sortedNeighbors.add(neighbors.get(i));
			}
		}
		return sortedNeighbors;
	}
}
