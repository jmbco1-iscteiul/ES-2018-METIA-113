package JUnitTest;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import MainWork.SignIN;

public class TestFacebook {

	SignIN client = null;

	@Before
	public void setUp()  {
		client = new SignIN( "username", "password", "tokenface", "tokentwitter1", "tokentwitter2" , "tokentwitter3",
				"tokentwitter4", "email", "pass");
	}

	@Test
	public void testGetClientFacebook() {
		String tokenface = new String("tokenface");
		assertEquals(tokenface,client.getTokenface());
	}
}
