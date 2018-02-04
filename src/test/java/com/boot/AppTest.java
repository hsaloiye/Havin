package com.boot;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.boot.controller.HomeController;

public class AppTest{
	
	@Test
    public void testApp(){
		HomeController controller = new HomeController();
		String result = controller.home();
		assertEquals(result, "Hello. I am Havin, your board game choosing assistant.");
    }
}
