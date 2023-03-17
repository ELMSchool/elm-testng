package testng_parallel_execution;

import org.testng.annotations.Test;

public class Test1 {

	@Test
	public void methodA() {
		System.out.println("Test1 => methodA => " + Thread.currentThread().getId());
	}

	@Test
	public void methodB() {
		System.out.println("Test1 => methodB => " + Thread.currentThread().getId());
	}

	@Test
	public void methodC() {
		System.out.println("Test1 => methodC => " + Thread.currentThread().getId());
	}
}
