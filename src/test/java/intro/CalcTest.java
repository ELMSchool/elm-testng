package intro;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcTest {
	
	@DataProvider(name = "data")
	public Object[][] dataProvider(){
		
		return new Object[][] {
			
			{5,   7},
			{11,  3},
			{42, 58}
		};
	}
	
	@Test(dataProvider = "data")
	public void addNumbersTest(int num1, int num2) {
		
		System.out.println("num1 = "+ num1 + "  "+ "num2 = "+num2);
	}
	
//	@Test
//	public void subtractNumbersTest() {
//		
//	
//	}

}
