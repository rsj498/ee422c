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
	static Set<String> dict;
	
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
		
		ArrayList<String> input = parse(kb);
		ArrayList<String> ladder = getWordLadderDFS(input.get(0), input.get(1));
		printLadder(ladder);
	}
	
	public static void initialize() {
		// initialize your static variables or constants here.
		// We will call this method before running our JUNIT tests.  So call it 
		// only once at the start of main.
		dict = makeDictionary();
	}
	
	/**
	 * @param keyboard Scanner connected to System.in
	 * @return ArrayList of 2 Strings containing start word and end word. 
	 * If command is /quit, return empty ArrayList. 
	 */
	public static ArrayList<String> parse(Scanner keyboard) {
		String input = keyboard.nextLine();
		if (input == "/quit") {
			return null;
		}
		
		int i = 0;
		while (input.charAt(i) != ' ') {
			i++;
		}
		String firstWord = input.substring(0,  i);
		firstWord = firstWord.toUpperCase();
		String secondWord = input.substring(i + 1, input.length());
		secondWord = secondWord.toUpperCase();
		
		ArrayList<String> words = new ArrayList<String>();
		words.add(firstWord);
		words.add(secondWord);
		return words;
	}
	
	public static boolean isNeighbor(String wordA, String wordB) {
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
	
	public static boolean diffByTwo(String a, String b) {
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
	
	public static ArrayList<String> getNeighbors(String start, Set<String> dict) {
		ArrayList<String> neighbors = new ArrayList<String>();
		for (String word : dict) {
			if (isNeighbor(start, word)) {
				neighbors.add(word);
			}
		}
		return neighbors;
	}
	
	public static ArrayList<String> reverse (ArrayList<String> path) {
		ArrayList<String> reversed = new ArrayList<String>();
		for (int i = path.size() - 1; i >= 0; i--) {
			reversed.add(path.get(i));
		}
		return reversed;
	}
	
	public static ArrayList<String> sortNeighbors (ArrayList<String> neighbors, String end) {
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
	
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		
		ArrayList<String> neighbors = getNeighbors(start, dict);
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
		
		dict.remove(start);
		neighbors = sortNeighbors(neighbors, end);
		ArrayList<String> path = new ArrayList<String>();
		for (String currentWord : neighbors) {
			path = getWordLadderDFS(currentWord, end);
			if (path == null) {
				dict.remove(currentWord);
				continue;
			}
			else {
				break;
			}
		}
		if (path == null) {
			return null;
		}
		
		path.add(start);
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
		
	}
	// TODO
	// Other private static methods here
}
