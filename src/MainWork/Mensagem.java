package MainWork;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe Mensagem que representa o que é enviado nos emails
 *@author Brogueira
 */

public class Mensagem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String tipo;

	private String content;
	private String subject;
	private String to;
	
	private Date data;
	
	private String creator;


	public Mensagem(String tipo, String content, Date data) {//mail face
		this.tipo = tipo;
		this.content = content;
		this.data = data;
	}
	
	public Mensagem(String tipo, String content, String creator, Date data) {//twitter
		this.tipo = tipo;
		this.content = content;
		this.creator = creator;
		this.data = data;
		
	}
	
	public String mes(int i) {
		String[] meses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
		
		return meses[i];
	}


	

	@SuppressWarnings("deprecation")
	@Override
	public String toString() {

		if(tipo.equals("M")) {
			
			Calendar cal = Calendar.getInstance();
		    cal.setTime(data);
			
			return cal.get(Calendar.DAY_OF_MONTH) + "/" + mes(data.getMonth()) + " " + content;
		}else{
			return content;
		}
		
	}

	public Date getData() {
		return data;
	}
	
public void setData(Date data) {
		this.data = data;
	}
	
}
