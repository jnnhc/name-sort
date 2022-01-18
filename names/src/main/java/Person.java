
public class Person implements Comparable<Person>{
	
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int compareTo(Person p) {
		int cVal = 0;
		cVal = this.getLastName().compareTo(p.getLastName());
		
		if(cVal == 0)
		{
			cVal = this.getFirstName().compareTo(p.getFirstName());
		}
		return cVal;
	}
	
	
}
