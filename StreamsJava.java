import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsJava {

	public static void main(String[] args) throws IOException {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(200);
		arr.add(30);
		arr.add(40);
		arr.add(50);
		arr.add(40);

		
		/**
		 * stream() functions:--->
		 * distinct()
		 * filter()
		 * map()
		 * max(comparator)
		 * min(comparator)
		 * sorted()
		 * sorted(comparator)
		 * toArray(Integer[]::new)
		 * forEach()
		 * 
		 */
		
		/*
		 * // 2)) READ FILE LINES //METHOD1: Using Stream(), read all the lines of a
		 * file try { //File file = new File("test.java"); // FileInputStream fis = new
		 * FileInputStream(file);
		 * 
		 * Path path = Paths.get("test.java");
		 * 
		 * Stream<String> streamObj = Files.lines(path); // all lines of the file as
		 * stream
		 * 
		 * streamObj.forEach(System.out::println); } catch (Exception e) {
		 * 
		 * e.printStackTrace(); System.out.println("exception sakshi"); }
		 * 
		 * //METHOD2: File file = new File("test.java"); BufferedReader br=new
		 * BufferedReader(new FileReader(file)); if(br.readLine()!=null) {
		 * 
		 * System.out.println(br.readLine()); }
		 */
		
		//1)) Using Stream remove duplicates in a given List
				arr.stream().distinct().forEach(System.out::println);
		
		//3)) STREAM - FILTER Objects of the collection object based on some condition
	    /** In-order to print we need to collect the stream object*/
		
		System.out.println(arr.stream().filter(i->i>30).collect(Collectors.toList()));
		
		//4)) STREAM - MAP : Process all Collection objects
		
		System.out.println(arr.stream().map(i->i+5).collect(Collectors.toList()));
		
		//5)) STREAM - SORTED() : Sorts the  Collection : natural sorting order : asc
		
				System.out.println(arr.stream().sorted().collect(Collectors.toList()));
				
				//STREAM - CUSTOM SORT : comparator: asc sort
				System.out.println(arr.stream().sorted((i1,i2)->i1.compareTo(i2)).collect(Collectors.toList()));
				
				//STREAM - CUSTOM SORT : comparator: desc sort
				System.out.println(arr.stream().sorted((i1,i2)->i2.compareTo(i1)).collect(Collectors.toList()));
				
				//STREAM - CUSTOM SORT : comparator: desc sort
				System.out.println(arr.stream().sorted((i1,i2)->-i1.compareTo(i2)).collect(Collectors.toList()));
				
				
				//STREAM - MIN MAX using Comparator ,
				
				//Min gives the FIRST item for the sorted list
				Integer min=arr.stream().min((i1,i2)->i1.compareTo(i2)).get();
				System.out.println(min);
				
				//Max gives the LAST item for the sorted list
				Integer max=arr.stream().max((i1,i2)->i1.compareTo(i2)).get();
				System.out.println(max);
				
				//CONVERT A STRING TO AN ARRAY
				Integer[] array= arr.stream().toArray(Integer[]::new);
				for(Integer x:array) {
					System.out.println(x);
				}
				
				//FOR EACH
				arr.stream().forEach(i->{
					
					System.out.println(i*i);
					
				});

	}

}
