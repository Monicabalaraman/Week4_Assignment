package week4.day1;

import java.util.LinkedHashSet;
import java.util.Set;

public class DemonstratingSetInterfaceinJava {

	public static void main(String[] args) {
		String companyName="google";
		char[] cs = companyName.toCharArray();
		Set<Character> comp=new LinkedHashSet<Character>();
		for (int i = 0; i < cs.length; i++) {
			comp.add(cs[i]);
		}System.out.println("The unique characters in the given string are ");
		for (Character i : comp) {
			System.out.print(i);			
		}


	}

}


//Writing a Java program that takes a string as input and prints only the unique characters from that String using 
//the Set interface and its implementation class.
//- Given the String companyName = "google"`, the program should print: "gole"
//Assignment Requirements:
//- You are provided with a string variable: companyName = "google"
//- Create a Set to store unique characters.
//- Iterate through each character in the companyName string.
//- Add each character into the Set.
//- Print the unique characters from the string.