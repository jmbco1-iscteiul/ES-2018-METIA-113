package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import MainWork.TwitterAccess;

public class TestTwitterAcess {

	TwitterAccess t = new TwitterAccess();
	
	@Test
	public void testTokenTwitter1() {
		String tokentwitter1  =("tokentwitter1");
		t.setTokentwitter1(tokentwitter1);
		assertEquals(tokentwitter1, t.getTokentwitter1());
	}
	
	@Test
	public void testTokenTwitter2() {
		String tokentwitter2  =("tokentwitter");
		t.setTokentwitter2(tokentwitter2);
		assertEquals(tokentwitter2, t.getTokentwitter2());
	}
	
	@Test
	public void testTokenTwitter3() {
		String tokentwitter3  =("tokentwitter");
		t.setTokentwitter3(tokentwitter3);
		assertEquals(tokentwitter3, t.getTokentwitter3());
	}
	
	@Test
	public void testTokenTwitter4() {
		String tokentwitter4  =("tokentwitter");
		t.setTokentwitter4(tokentwitter4);
		assertEquals(tokentwitter4, t.getTokentwitter4());
	}

}
