package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class TestMensage {

	String[] m = null;
	int i = 2;


	@Before
	public void setUp()  {
		String[] meses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
		m = meses;
	}

	@Test
	public void testMes() {
		
		assertEquals("Mar", m[2]);
	}


}




