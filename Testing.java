package assignment3;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class Testing {
	Scanner kb = new Scanner(System.in);
	
<<<<<<< HEAD
	
	public void testDFSLong() {
		ArrayList<String> ladder = Main.getWordLadderDFS("bumps", "allee");
=======
	@Test
	public void testDFSShort() {
		Main.initialize();
		ArrayList<String> ladder = Main.getWordLadderDFS("hello", "sails");
>>>>>>> 14ce228f15e57eeb5a450b87bbbd9044e2d7683c
		Main.printLadder(ladder);
		HashSet<String> ladderSet = new HashSet<String>(ladder);
		assertEquals(ladder.size(), ladderSet.size());
	}
	
<<<<<<< HEAD
	@Test
	public void testDFSShort() {
		Main.initialize();
		ArrayList<String> ladder = Main.getWordLadderDFS("hello", "sails");
=======
	
	public void testDFSLong() {
		ArrayList<String> ladder = Main.getWordLadderDFS("bumps", "allee");
>>>>>>> 14ce228f15e57eeb5a450b87bbbd9044e2d7683c
		Main.printLadder(ladder);
		HashSet<String> ladderSet = new HashSet<String>(ladder);
		assertEquals(ladder.size(), ladderSet.size());
	}
	
<<<<<<< HEAD
	
	public void testDFSZeroRung() {
		ArrayList<String> ladder2 = Main.getWordLadderDFS("smart", "start");
		Main.printLadder(ladder2);
		HashSet<String> ladderSet2 = new HashSet<String>(ladder2);
		assertEquals(ladder2.size(), ladderSet2.size());
	}
	
	
	public void testDFSNoRung() {
		
=======
	@Test
	public void testDFSZeroRung() {
		ArrayList<String> ladder = Main.getWordLadderDFS("smart", "start");
		Main.printLadder(ladder);
		HashSet<String> ladderSet = new HashSet<String>(ladder);
		assertEquals(ladder.size(), ladderSet.size());
>>>>>>> 14ce228f15e57eeb5a450b87bbbd9044e2d7683c
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