package intro;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalcTest {
	
	
	@Test
	public void addNumbersTest() {
		
		Calculator calculator = new Calculator();
		
		assertEquals(calculator.addNumbers(5, 10), 15);
		
	}
	
	@Test
	public void subtractNumbersTest() {
		Calculator calculator = new Calculator();
		assertEquals(calculator.subtractNumbers(5, 3), 2);
	
	}

}
