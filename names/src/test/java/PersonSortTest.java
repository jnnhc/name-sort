import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

public class PersonSortTest {
	
	PersonSort personSort;
	ArrayList<Person> personList;
	ArrayList<Person> personListSorted;

	
	@Test
    public void testReadFile() {
		createData();
		personSort = new PersonSort();
		String filename = "src/test/resources/test.txt";
		ArrayList<Person> readList = personSort.readFile(filename);
			
        assertEquals(personList.size(), readList.size());
       
        for(int i = 0; i < personList.size(); i++)
        {
        	 assertEquals(personList.get(i).getFirstName(), readList.get(i).getFirstName());
        	 assertEquals(personList.get(i).getLastName(), readList.get(i).getLastName());
        }   
   }
	
	
	@Test
    public void testWriteFile() {
		createData();
		
		String filename = "src/test/resources/test-sorted.txt";
		personSort.writeToFile(personListSorted,filename);
		
		//read sorted file
		ArrayList<Person> readSortedList = personSort.readFile(filename);
        
        assertEquals(personListSorted.size(), readSortedList.size());
        
        for(int i = 0; i < personListSorted.size(); i++)
        {
        	 assertEquals(personListSorted.get(i).getFirstName(), readSortedList.get(i).getFirstName());
        	 assertEquals(personListSorted.get(i).getLastName(), readSortedList.get(i).getLastName());
        }   
        
   }

	public void createData() {
		personSort = new PersonSort();
    	personList = new ArrayList<Person>();
    	personListSorted = new ArrayList<Person>();
    	Person p1 = new Person();
    	p1.setFirstName("DTEST");
    	p1.setLastName("AAAA");
    	
    	Person p2 = new Person();
    	p2.setFirstName("BTEST");
    	p2.setLastName("DDDD");
    	
    	Person p3 = new Person();
    	p3.setFirstName("ATEST");
    	p3.setLastName("AAAA");
    	
    	personList.add(p1);
    	personList.add(p2);
    	personList.add(p3);

    	personListSorted.add(p1);
    	personListSorted.add(p2);
    	personListSorted.add(p3);
    	Collections.sort(personListSorted);
 
    
	}
	
}
