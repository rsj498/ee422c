/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:
 * Fall 2016
 */


package assignment3;
import java.util.*;
import java.io.*;


public class Main {
	
	// static variables and constants only here.
	static DFSHelpers helpers;
	static int depth;
	static ArrayList<String> visited;
	static String start, end;
	
	public static void main(String[] args) throws Exception {
		
		Scanner kb;	// input Scanner for commands
		PrintStream ps;	// output file
		// If arguments are specified, read/write from/to files instead of Std IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			System.setOut(ps);			// redirect output to ps
		} else {
			kb = new Scanner(System.in);// default from Stdin
			ps = System.out;			// default to Stdout
		}
		initialize();
	}
	
	public static void initialize() {
		// initialize your static variables or constants here.
		// We will call this method before running our JUNIT tests.  So call it 
		// only once at the start of main.
		helpers = new DFSHelpers();
		depth = 0;
		visited = new ArrayList<String>();
	}
	
	/**
	 * @param keyboard Scanner connected to System.in
	 * @return ArrayList of 2 Strings containing start word and end word. 
	 * If command is /quit, return empty ArrayList. 
	 */
	public static ArrayList<String> parse(Scanner keyboard) {
		String input = keyboard.nextLine();
		if (input.equals("/quit")) {
			System.exit(0);
		}
		
		int i = 0;
		while (input.charAt(i) != ' ') {
			i++;
		}
		start = input.substring(0,  i);
		start = start.toUpperCase();
		end = input.substring(i + 1, input.length());
		end = end.toUpperCase();
		
		ArrayList<String> words = new ArrayList<String>();
		words.add(start);
		words.add(end);
		return words;
	}
	/**
	 * This method creates a word ladder using DFS
	 * @param start is the start word
	 * @param end is the end word
	 * @return the word ladder
	 */
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		Set<String> dict = makeDictionary();
		ArrayList<String> neighbors = helpers.getNeighbors(start, dict, visited);
		
		// Base Case: Found a word that is directly connected to end
		if (neighbors.contains(end)) {
			ArrayList<String> finPath = new ArrayList<String>();
			finPath.add(end);
			finPath.add(start);
			return finPath;
		}
		
		// No path
		if (neighbors.isEmpty()) {
			return null;
		}
		
		// Allow this path to be used again
		visited.add(start);
		
		neighbors = helpers.sortNeighbors(neighbors, end);
		ArrayList<String> path = new ArrayList<String>();
		for (String currentWord : neighbors) {
			depth++;
			path = getWordLadderDFS(currentWord, end);
			depth--;
			
			if (path == null) { // Dead end, don't use this path again
				visited.add(currentWord);
				continue;
			}
			else { // Found a working path
				break;
			}
		}
		
		// No path found
		if (path == null) {
			return null;
		}
		
		path.add(start);
		if (depth == 0) { // Finished ladder
			visited.clear();
			path = helpers.reverse(path);
		}
		return path;
	}
	
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
		
		// TODO some code
		Set<String> dict = makeDictionary();
		// TODO more code
		
		return null; // replace this line later with real return
	}
    
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		}
		return words;
	}
	
	public static void printLadder(ArrayList<String> ladder) {
		// No ladder exists
		if (ladder == null) {
			System.out.println("no word ladder can be found between " + start.toLowerCase() + " and " + end.toLowerCase() + ".");
			return;
		}
		
		// Ladder does exist
		System.out.println("a " + (ladder.size() - 2) + "-rung word ladder exists between " + start.toLowerCase() + " and " + end.toLowerCase() + ".");
		for (int i = 0; i < ladder.size(); i++) {
			System.out.println(ladder.get(i).toLowerCase());
		}
		return;
	}
}
