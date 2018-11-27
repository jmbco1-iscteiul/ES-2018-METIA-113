package Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import MainWork.Mensagem;
import MainWork.SignIN;


public class TestMensagem {
	String[] m = null;
	
	
	@Before
	public void setUp()  {
		String[] meses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
		m = meses;
	}

	@Test
	public void testMes() {
		int i = 2;
		assertEquals("Mar", m[2]);
	}
	

	
}
