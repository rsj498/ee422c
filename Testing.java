package assignment3;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class Testing {
	Scanner kb = new Scanner(System.in);
	
	@Test
	public void testDFSShort() {
		Main.initialize();
		ArrayList<String> ladder = Main.getWordLadderDFS("hello", "sails");
		Main.printLadder(ladder);
		HashSet<String> ladderSet = new HashSet<String>(ladder);
		assertEquals(ladder.size(), ladderSet.size());
	}
	
	
	public void testDFSLong() {
		ArrayList<String> ladder = Main.getWordLadderDFS("bumps", "allee");
		Main.printLadder(ladder);
		HashSet<String> ladderSet = new HashSet<String>(ladder);
		assertEquals(ladder.size(), ladderSet.size());
	}
	
	@Test
	public void testDFSZeroRung() {
		ArrayList<String> ladder = Main.getWordLadderDFS("smart", "start");
		Main.printLadder(ladder);
		HashSet<String> ladderSet = new HashSet<String>(ladder);
		assertEquals(ladder.size(), ladderSet.size());
	}
	
	@Test
	public void testDFSNoRung() {
		ArrayList<String> ladder = Main.getWordLadderDFS("jazzy", "leady");
		Main.printLadder(ladder);
	}
	
	
	public void testParse() {
		ArrayList<String> input = Main.parse(kb);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("HELLO");
		expected.add("SAILS");
		assertEquals(input.get(0), expected.get(0));
		assertEquals(input.get(1), expected.get(1));
	}
	
	
	public void testQuit() {
		Main.parse(kb);
		// Program should quit
	}
}