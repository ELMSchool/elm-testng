package intro;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class AgeTest {
	
	
	@Test
	public void testCalculateAge() {
		Age age = new Age(1990);
		
		assertEquals(age.calculateAge(2023), 33);
		
	}
	
	@Test
	public void testIsYounger() {
		Age age = new Age(1990);
		
		assertEquals(age.isYounger(1994), false);
		
	}
	
	

}
