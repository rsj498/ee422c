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
	
<<<<<<< HEAD
<<<<<<< HEAD
	
	public void testDFSLong() {
		ArrayList<String> ladder = Main.getWordLadderDFS("bumps", "allee");
=======
	@Test
	public void testDFSShort() { // tests a short DFS ladder
=======
	@BeforeClass
	public static void setUp() {
>>>>>>> 7f64623dd6e0f3f72dcb1f2b948f0bf5130bc6be
		Main.initialize();
	}
	
	@Test
	public void testDFSShort() {
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
	
<<<<<<< HEAD
	public void testDFSLong() { // tests a long DFS ladder
		ArrayList<String> ladder = Main.getWordLadderDFS("bumps", "allee");
>>>>>>> 14ce228f15e57eeb5a450b87bbbd9044e2d7683c
=======
	public void testDFSLong() {
		ArrayList<String> ladder = Main.getWordLadderDFS("hello", "world");
>>>>>>> 7f64623dd6e0f3f72dcb1f2b948f0bf5130bc6be
		Main.printLadder(ladder);
		HashSet<String> ladderSet = new HashSet<String>(ladder);
		assertEquals(ladder.size(), ladderSet.size());
	}
	
<<<<<<< HEAD
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
	public void testDFSZeroRung() { // tests a DFS ladder with zero words between start and end
=======

	public void testDFSZeroRung() {
>>>>>>> 7f64623dd6e0f3f72dcb1f2b948f0bf5130bc6be
		ArrayList<String> ladder = Main.getWordLadderDFS("smart", "start");
		Main.printLadder(ladder);
		HashSet<String> ladderSet = new HashSet<String>(ladder);
		assertEquals(ladder.size(), ladderSet.size());
>>>>>>> 14ce228f15e57eeb5a450b87bbbd9044e2d7683c
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