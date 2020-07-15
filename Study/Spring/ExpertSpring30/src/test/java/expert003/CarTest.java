package expert003;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("expert003.xml")
public class CarTest {
	
	@Autowired
	Car car;

	@Test
	public void carKoreaTireTest() {
		assertEquals("장착된 타이어: 한국 타이어", car.getTireBrand());
	}

}
