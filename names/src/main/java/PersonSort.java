import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PersonSort {


	public static void main(String[] args)
	{	
		//Get the file name
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the full path of the input file (e.g. src/main/resources/names.txt): ");
		String inputFileName = in.nextLine();
		System.out.println("sort-names " + inputFileName);
		
		//save to list
		ArrayList<Person> personList;
		personList = readFile(inputFileName);
	 
		//Sort by last name and first name
		Collections.sort(personList);
		
		writeToFile(personList, inputFileName);
		
	}
	
	protected static ArrayList<Person> readFile(String inputFileName) 
	{
		
		// Creates a File object for the file path, and scans it
		Scanner inputFile = null;
		Person person;
		ArrayList<Person> personList = new ArrayList<Person>();
		try {
			inputFile = new Scanner(new File(inputFileName));
			while (inputFile.hasNextLine()) 	
			{
				String line = inputFile.nextLine();
		        
				String[] lineData  = line.split(",");
				person = new Person();
				person.setLastName(lineData[0].trim());
				person.setFirstName(lineData[1].trim());
		  
				personList.add(person);  	
		       
			}
			inputFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found");
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Ensure file contains correct format");
		}
		
		return personList;
		
	}
	
	protected static void writeToFile(ArrayList<Person> personList, String inputFileName)
	{
		String outFile = "";
		if(personList.size() > 0)
		{
			//Write output to a file
			BufferedWriter writer = null;
			try {
				outFile = extractFileName(inputFileName) + "-sorted.txt";
				 writer = new BufferedWriter(new FileWriter(outFile));
				 
				 for(int i = 0; i < personList.size(); i++)
			     {
					 //for printing to console
					 System.out.println(personList.get(i).getLastName() + ", " + personList.get(i).getFirstName());
				
					 writer.write(personList.get(i).getLastName() + ", " + personList.get(i).getFirstName() );
					 writer.newLine();
				 }
				 writer.close();    
			} catch (IOException e) {
				System.out.println("Error in creating output file: " + outFile);
				//e.printStackTrace();
			}
			System.out.println("Finished: created " + outFile);
			
		}
		else
			System.out.println("No data to send to output file");
	}
	
	private static String extractFileName(String text)
	{
		//considering input is ONLY text file .txt
		return text.substring(0, text.length() - 4);
	}
}
