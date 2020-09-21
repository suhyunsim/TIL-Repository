package expert001_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {

	@Test
	public void carTest() {
		Car car = new Car();
		
		assertEquals("장착된 타이어: 한국 타이어", car.getTireBrand());
	}

}
