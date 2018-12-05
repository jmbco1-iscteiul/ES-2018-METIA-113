package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import MainWork.SignIN;

public class TestSignIn {

	SignIN s = new SignIN( "username", "password", "tokenface", "tokentwitter1", "tokentwitter2" , "tokentwitter3",
			"tokentwitter4", "email", "pass");




	@Test
	public void testGetPass() {
		String pass = new String("pass");
		assertEquals(pass, s.getPass());
	}

	@Test
	public void testGetMail() {
		String mail= new String("email");
		assertEquals(mail, s.getEmail());
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
		s.setEmail("mailJ");
		assertEquals(mail,s.getEmail());
	}

	//TOKEN FACE
	@Test
	public void testGetTokenFace() {
		String tokenface= new String("tokenface");
		assertEquals(tokenface,s.getTokenface());
	}

	@Test
	public void testSetTokenFace() {
		String tokenface= new String("token1234");
		s.setTokenface("token1234");
		assertEquals(tokenface,s.getTokenface());
	}

	//TOKEN TWITTER 1
	@Test
	public void testGetTokenTwitter1() {
		String tokentwitter= new String("tokentwitter1");
		assertEquals(tokentwitter,s.getTokentwitter1());
	}

	@Test
	public void testSetTokentwitter1() {
		String tokentwitter= new String("token1234");
		s.setTokentwitter1("token1234");
		assertEquals(tokentwitter,s.getTokentwitter1());
	}

	//TOKEN TWITTER 2
	@Test
	public void testGetTokenTwitter2() {
		String tokentwitter= new String("tokentwitter2");
		assertEquals(tokentwitter,s.getTokentwitter2());
	}

	@Test
	public void testSetTokentwitter2() {
		String tokentwitter= new String("token1234");
		s.setTokentwitter2("token1234");
		assertEquals(tokentwitter,s.getTokentwitter2());
	}

	//TOKEN TWITTER 3
	@Test
	public void testGetTokenTwitter3() {
		String tokentwitter= new String("tokentwitter3");
		assertEquals(tokentwitter,s.getTokentwitter3());
	}

	@Test
	public void testSetTokentwitter3() {
		String tokentwitter= new String("token1234");
		s.setTokentwitter3("token1234");
		assertEquals(tokentwitter,s.getTokentwitter3());
	}

	//TOKEN TWITTER 4
	@Test
	public void testGetTokenTwitter4() {
		String tokentwitter= new String("tokentwitter4");
		assertEquals(tokentwitter,s.getTokentwitter4());
	}

	@Test
	public void testSetTokentwitter4() {
		String tokentwitter= new String("token1234");
		s.setTokentwitter4("token1234");
		assertEquals(tokentwitter,s.getTokentwitter4());
	}

	//Teste do username
	
	@Test
	public void testGetUsername() {
		String username = new String("username");
		assertEquals(username,s.getUsername());
	}

	@Test
	public void testSetUsername() {
		String mail= new String("usernameI");
		s.setUsername("usernameI");
		assertEquals(mail,s.getUsername());
	}
	
	//Test password
	
	@Test
	public void testGetPassword() {
		String password = new String("password");
		assertEquals(password,s.getPassword());
	}

	@Test
	public void testSetPassword() {
		String password= new String("passw0rd");
		s.setPassword("passw0rd");
		assertEquals(password,s.getPassword());
	}
	


}
