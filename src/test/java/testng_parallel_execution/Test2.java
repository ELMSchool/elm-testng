package testng_parallel_execution;

import org.testng.annotations.Test;

public class Test2 {
	
	@Test
	public void methodD() {
		System.out.println("Test2 => methodD => " + Thread.currentThread().getId());
	}

	@Test
	public void methodE() {
		System.out.println("Test2 => methodE => " + Thread.currentThread().getId());
	}

	@Test
	public void methodF() {
		System.out.println("Test2 => methodF => " + Thread.currentThread().getId());
	}


}
