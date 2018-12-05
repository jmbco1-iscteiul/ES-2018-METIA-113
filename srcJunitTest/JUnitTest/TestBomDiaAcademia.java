package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import MainWork.BomDiaAcademia;
import MainWork.XmlProject;
import facebook.Facebook;

public class TestBomDiaAcademia {

	BomDiaAcademia bda = new BomDiaAcademia();
	
	@Test
	public void testSetUserName() {
		String user = ("Username");
		bda.setUserName(user);
		assertEquals(user, bda.getUserName());
	}	

}
