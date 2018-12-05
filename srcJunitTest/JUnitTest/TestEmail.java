package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import MainWork.Email;

public class TestEmail {
	
	Email e = new Email();
	
	@Test
	public void testSetMail() {
		String email = ("Geremias");
		e.setMail(email);
		assertEquals(email, e.getMail());
	}
	
	@Test
	public void testSetPass() {
		String pass = ("Geremias");
		e.setPass(pass);
		assertEquals(pass, e.getPass());
	}


}
