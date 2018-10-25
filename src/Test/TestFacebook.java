package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import MainWork.SignIN;

public class TestFacebook {

	SignIN client = null;

	@Before
	public void setUp()  {
		client = new SignIN( "token", "mail", "pass");
	}

	@Test
	public void testGetClientFacebook() {
		String pass= new String("token");
		assertEquals(pass,client.getToken());
	}
}
