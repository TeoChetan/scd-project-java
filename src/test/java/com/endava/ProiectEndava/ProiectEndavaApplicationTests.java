package com.endava.ProiectEndava;

import com.endava.ProiectEndava.controllers.SampleClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProiectEndavaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void Scenario_1(){
		SampleClass sc = new SampleClass();
		sc.Add(-1,2);
		assertEquals(1,sc.getResult());
	}

	@Test
	public void Scenario_2(){
		SampleClass sc = new SampleClass();
		sc.Add(-1,-1);
		assertEquals(-2,sc.getResult());
	}
	@Test
	public void Scenario_3(){
		SampleClass sc = new SampleClass();
		sc.Add(null,-1);
		assertEquals(-2,sc.getResult());
	}

}
