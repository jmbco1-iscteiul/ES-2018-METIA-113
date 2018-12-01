package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import MainWork.SignIN;


public class TestSignIN {
	
	SignIN s=null;

	@Before
	public void setUp()  {
	//	s= new SignIN( "token", "mail", "pass");
	}

	@Test
	public void testGetPass() {
		String pass= new String("pass");
		assertEquals(pass, s.getPass());
	}

	@Test
	public void testGetMail() {
		String mail= new String("mail");
	//	assertEquals(mail, s.getMail());
	}

	@Test
	public void testSetPass() {
		String pass= new String("mailM");
		s.setPass("mailM");
		assertEquals(pass,s.getPass());
	}

	@Test
	public void testSetMail() {
		String mail= new String("mailJ");
	//	s.setMail("mailJ");
	//	assertEquals(mail,s.getMail());
	}
	
	@Test
	public void testGetToken() {
		String pass= new String("token");
	//	assertEquals(pass,s.getToken());
	}

	@Test
	public void testSetToken() {
		String mail= new String("token1234");
	//	s.setToken("token1234");
	//	assertEquals(mail,s.getToken());
	}
}
