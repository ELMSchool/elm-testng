package intro;

public class Age {

	int yearOfBirth;
	
	public Age(int yearOfBirth) {
		
		this.yearOfBirth = yearOfBirth;
	}

	public int calculateAge(int currentYear) {
		
		return currentYear-yearOfBirth;
		
	}
	
	public boolean isYounger(int yearOfBirth) {
		
		return this.yearOfBirth > yearOfBirth;
		
	}
}

