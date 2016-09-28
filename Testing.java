package assignment3;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class Testing {
	Scanner kb = new Scanner(System.in);
	
	@Test
	public void testDFSShort() { // tests a short DFS ladder
		Main.initialize();
		ArrayList<String> ladder = Main.getWordLadderDFS("hello", "sails");
		Main.printLadder(ladder);
		HashSet<String> ladderSet = new HashSet<String>(ladder);
		assertEquals(ladder.size(), ladderSet.size());
	}
	
	
	public void testDFSLong() { // tests a long DFS ladder
		ArrayList<String> ladder = Main.getWordLadderDFS("bumps", "allee");
		Main.printLadder(ladder);
		HashSet<String> ladderSet = new HashSet<String>(ladder);
		assertEquals(ladder.size(), ladderSet.size());
	}
	
	@Test
	public void testDFSZeroRung() { // tests a DFS ladder with zero words between start and end
		ArrayList<String> ladder = Main.getWordLadderDFS("smart", "start");
		Main.printLadder(ladder);
		HashSet<String> ladderSet = new HashSet<String>(ladder);
		assertEquals(ladder.size(), ladderSet.size());
	}
	
	@Test
	public void testDFSNoRung() { // tests DFS for a ladder that doesn't exist
		ArrayList<String> ladder = Main.getWordLadderDFS("jazzy", "leady");
		Main.printLadder(ladder);
	}
	
	
	public void testParse() { // tests parse, expects input of "hello sails"
		ArrayList<String> input = Main.parse(kb);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("HELLO");
		expected.add("SAILS");
		assertEquals(input.get(0), expected.get(0));
		assertEquals(input.get(1), expected.get(1));
	}
	
	
	public void testQuit() { // check if program quits after input of "/quit"
		Main.parse(kb);
		// Program should quit
	}
}
