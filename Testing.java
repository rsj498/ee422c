/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Jessica Slaughter
 * jts3329
 * 16470
 * Rebecca Jiang
 * rsj498
 * 16470
 * Slip days used: <0>
 * Git URL: https://github.com/rsj498/ee422c
 * Fall 2016
 */

package assignment3;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class Testing {
	
	@BeforeClass
	public static void setUp() {
		Main.initialize();
	}
	
	@Test
	public void testDFSShort() {
		ArrayList<String> ladder = Main.getWordLadderDFS("hello", "sails");
		Main.printLadder(ladder);
		HashSet<String> ladderSet = new HashSet<String>(ladder);
		assertEquals(ladder.size(), ladderSet.size());
	}
	
	
	public void testDFSLong() {
		ArrayList<String> ladder = Main.getWordLadderDFS("hello", "world");
		Main.printLadder(ladder);
		HashSet<String> ladderSet = new HashSet<String>(ladder);
		assertEquals(ladder.size(), ladderSet.size());
	}
	

	public void testDFSZeroRung() {
		ArrayList<String> ladder = Main.getWordLadderDFS("smart", "start");
		Main.printLadder(ladder);
		HashSet<String> ladderSet = new HashSet<String>(ladder);
		assertEquals(ladder.size(), ladderSet.size());
	}
	

	public void testDFSNoRung() {
		ArrayList<String> ladder = Main.getWordLadderDFS("jazzy", "leady");
		Main.printLadder(ladder);
	}
	
	
	public void testParse() {
		String input = "hello sails";
		Scanner scan = new Scanner(input);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("hello");
		expected.add("sails");
		assertEquals(expected, Main.parse(scan));
	}
	
	
	public void testQuit() {
		String input = "/quit";
		Scanner scan = new Scanner(input);
		Main.parse(scan); // Program should quit
	}
}