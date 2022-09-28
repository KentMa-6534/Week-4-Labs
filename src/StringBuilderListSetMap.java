import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringBuilderListSetMap {

	public static void main(String[] args) {
		
		//Why should we use a StringBuilder instead of a String?
		/**
		 *  Strings are immutable or cannot be changed. Whenever a String value is changed, a new String value in memory is created, and can cause memory leaks.
		 *  A StringBuilder is a mutable or dynamic series of characters that can be changed before becoming a String, thus preventing new Strings 
		 *  from being printed.
		 */
		
		//Instantiate a new StringBuilder and append the characters 0 through 9 to it separated by dashes
		//Make sure no dash appears at the end of the StringBuilder
		StringBuilder numbers = new StringBuilder();
		for(int i = 0; i<10; i++) {
			numbers.append(i);
			if(i!= 9) {
				numbers.append("-");
			}
		}
		System.out.println(numbers.toString());
		
		//Create a list of Strings and add 5 Strings to it, each with a different length
		List<String> strings = new ArrayList<String>();
		strings.add("Cheeseburger");
		strings.add("Chicken Nuggets");
		strings.add("French Fries");
		strings.add("Diet Coke");
		strings.add("Ketchup");
		
		//Easier way of making a List of multiple elements: 
		List<String> fastFood = Arrays.asList("Cheeseburger","Chicken Nuggets", "French Fries", "Diet Coke", "Ketchup");
		
		//Write and test a method that takes a list of strings and returns the shortest string
		System.out.println(shortestString(fastFood));
		
		//Write and test a method that takes a list of strings and returns the first and last element switched
		System.out.println(firstAndLastElementSwitch(fastFood));
		
		//Write and test a method that takes a list of strings and returns a string with all the list elements concatenated to each other,
		//separated by a comma
		System.out.println(listElementsConcatenated(fastFood));
		
		//Write and test a method that takes a list of strings and returns a string with all the last elements concatenated to each other,
		//separated by a comma
		System.out.println(lastElementsOfString(fastFood));
		
		//Write and test a method that takes a list of strings and a string and returns a new list with all strings from the original list
		//containing the second parameter (i.e. like a search method)
		List<String> candy = Arrays.asList("Milk Chocolate", "Dark Chocolate", "White Chocolate", "Pop Rocks", "Licorice", "Gummy Bears", "Taffy");
		
		System.out.println(listSearch(candy, "Chocolate"));
		
		//Write and test a method that takes a list of integers and returns a List<List<Integer>> where the first list in the returned value
		//contains any number from the input list that is divisible by 2, the second list contains values from the input list that are divisible
		//by 3, the third divisible by 5, and the fourth all numbers from the input list not divisible by 2,3, or 5.
		List<Integer> digits = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		System.out.println(listOfIntegerLists(digits));
		
		//Write and test a method that takes a list of strings and returns a list of integers that contains the length of each string.
		System.out.println(listOfStringLength(candy));
		
		//Create a set of strings and add 5 values
		Set<String>computerBrands = new HashSet<String>(Arrays.asList("HP","Dell","Lenovo","Asus","Acer"));
		
		//Write and test a method that takes a set of strings and a character and returns a set of strings consisting of all the strings 
		//in the input set that start with the character parameter.
		System.out.println(startsWith(computerBrands,'A'));
		
		//Write and test a method that takes a set of strings and returns a list of the same strings
		System.out.println(setToList(computerBrands));
		
		//Write and test a method that takes a set of integers and returns a new set of integers containing only even numbers from the original set
		Set<Integer>integers = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		System.out.println(evenSet(integers));
		
		//Create a map of string and string and add 3 items to it where the key of each is a word and the value is the definition of the word
		Map<String, String> coffeeTypes = new HashMap<String,String>();
		coffeeTypes.put("Espresso", "A coffee-brewing method of Italian origin");
		coffeeTypes.put("Caffè Americano", "A type of coffee drink prepared by diluting an espresso with hot water");
		coffeeTypes.put("Cappuccino", "An espresso-based coffee drink that originated in Italy and is prepared with steamed milk foam");
		
		//Write and test a method that takes a Map<String, String> and a string and returns the value for a key in the map that matches the 
		//string parameter (i.e. like a dictionary lookup)
		System.out.println(coffeeLookUp(coffeeTypes, "A type of coffee drink prepared by diluting an espresso with hot water"));
		
		//Write and test a method that takes a List<String> and returns a Map<Character, Integer> containing a count of all the strings that 
		//start with a given character
		System.out.println(stringsThatStartWith(candy));
	}
	//Write and test a method that takes a list of strings and returns the shortest string
	public static String shortestString(List <String> list) {
		String shortest = list.get(0);
		for (String string : list) {
			if(string.length()<shortest.length()) {
				shortest = string;
			}
		}
		return shortest;
	}
	
	//Write and test a method that takes a list of strings and returns the first and last element switched
	public static List<String> firstAndLastElementSwitch(List<String>strings){
		String word = strings.get(0);
		strings.set(0, strings.get(strings.size()-1));
		strings.set(strings.size()-1, word);
		
		return strings;
	}
	
	//Write and test a method that takes a list of strings and returns a string with all the list elements concatenated to each other,
	//separated by a comma
	public static String listElementsConcatenated(List <String> list) {
		StringBuilder listElements = new StringBuilder();
		for(String string : list) {
			listElements.append(string+", ");
		}
		return listElements.toString();
		
	}
	//Write and test a method that takes a list of strings and returns a string with all the last elements concatenated to each other,
	//separated by a comma
	public static String lastElementsOfString(List <String> list) {
		StringBuilder lastElements = new StringBuilder();
		for (String index : list) {
			lastElements.append((index.substring(index.length()-1)).concat(","));
		}
		return lastElements.toString();
	}
	
	//Write and test a method that takes a list of strings and a string and returns a new list with all strings from the original list
	//containing the second parameter (i.e. like a search method)
	public static List<String> listSearch(List<String>words, String search){
		List<String>results = new ArrayList<String>();
		for(String index:words) {
			if(index.contains(search)) {
				results.add(index);
			}
		}
		return results;
	}
	
	//Write and test a method that takes a list of integers and returns a List<List<Integer>> where the first list in the returned value
	//contains any number from the input list that is divisible by 2, the second list contains values from the input list that are divisible
	//by 3, the third divisible by 5, and the fourth all numbers from the input list not divisible by 2,3, or 5.
	public static List<List<Integer>> listOfIntegerLists(List<Integer>ints){
		List<List<Integer>> newList = new ArrayList<List<Integer>>();
//		List<Integer>firstList = new ArrayList<Integer>();
//		List<Integer>secondList = new ArrayList<Integer>();
//		List<Integer>thirdList = new ArrayList<Integer>();
//		List<Integer>fourthList = new ArrayList<Integer>();
		for(int i = 0; i<4; i++) {
			newList.add(new ArrayList<Integer>());
		}
		for(int index:ints) {
			if(index%2==0) {
				newList.get(0).add(index);
//				firstList.add(index);
			}
			else if(index%3==0) {
				newList.get(1).add(index);
//				secondList.add(index);
			}
			else if(index%5==0) {
				newList.get(2).add(index);
//				thirdList.add(index);
			}
			else {
				newList.get(3).add(index);
//				fourthList.add(index);
			}
		}
//		newList.add(firstList);
//		newList.add(secondList);
//		newList.add(thirdList);
//		newList.add(fourthList);
		
		return newList;
	}
	
	//Write and test a method that takes a list of strings and returns a list of integers that contains the length of each string.
	public static List<Integer>listOfStringLength(List<String>words){
		List<Integer>stringLength = new ArrayList<Integer>();
		for(String index:words) {
			stringLength.add(index.length());
		}
		return stringLength;
	}
	
	//Write and test a method that takes a set of strings and a character and returns a set of strings consisting of all the strings 
	//in the input set that start with the character parameter.
	public static Set<String> startsWith(Set<String>words, char letter){
		Set<String>result = new HashSet<String>();
		for(String index:words) {
			if(index.charAt(0) == letter) {
				result.add(index);
			}
		}
		return result;
	}
	
	//Write and test a method that takes a set of strings and returns a list of the same strings
	public static List<String>setToList(Set<String>words){
		List<String>computerList = new ArrayList<String>();
		for(String index:words) {
			computerList.add(index);
		}
		return computerList;
	}
	
	//Write and test a method that takes a set of integers and returns a new set of integers containing only even numbers from the original set
	public static Set<Integer>evenSet(Set<Integer>numbers){
		Set<Integer>evenNumbers = new HashSet<Integer>();
		for(int number:numbers) {
			if(number % 2 == 0) {
				evenNumbers.add(number);
			}
		}
		return evenNumbers;
	}
	
	//Write and test a method that takes a Map<String, String> and a string and returns the value for a key in the map that matches the 
	//string parameter (i.e. like a dictionary lookup)
	public static String coffeeLookUp(Map<String,String>coffee, String definition){
		for(String key:coffee.keySet()) {
			if(coffee.get(key).equals(definition)) {
				definition = key;
			}
		}
		return definition;
	}
	
	//Write and test a method that takes a List<String> and returns a Map<Character, Integer> containing a count of all the strings that 
	//start with a given character
	public static Map<Character, Integer>stringsThatStartWith(List<String>words){
		Map<Character,Integer>results = new HashMap<Character, Integer>();
		
		for(String string:words) {
		char c = string.charAt(0);
		if(results.get(c) == null) {
			results.put(c, 1);
		}
		else {
			results.put(c, results.get(c)+1);
		}
		}
		return results;
	}
	

}
