package testng_parallel_execution;

import org.testng.annotations.Test;

public class Test3 {
	
	
	@Test
	public void methodG() {
		System.out.println("Test3 => methodG => " + Thread.currentThread().getId());
	}

	@Test
	public void methodH() {
		System.out.println("Test3 => methodH => " + Thread.currentThread().getId());
	}

	@Test
	public void methodI() {
		System.out.println("Test3 => methodI => " + Thread.currentThread().getId());
	}

	@Test
	public void methodJ() {
		System.out.println("Test3 => methodJ => " + Thread.currentThread().getId());
	}
}
