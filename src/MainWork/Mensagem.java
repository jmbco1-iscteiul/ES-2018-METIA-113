package MainWork;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Asus
 *
 */
public class Mensagem{

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

}
