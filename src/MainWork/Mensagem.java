package MainWork;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

/**
 * Classe Mensagem que representa o que é enviado nos emails
 *@author Brogueira
 */

public class Mensagem extends Object implements Serializable{

	private static final long serialVersionUID = 826905894253379454L;

	private final String tipo;

	private String content;

	private String mailContent;
	private String subject;
	private String to;

	private Date data;

	private String creator;


	public Mensagem(String tipo, String content, Date data) {// face
		this.tipo = tipo;
		this.content = content;
		this.data = data;
	}

	public Mensagem(String tipo, String content, String creator, Date data) {//twitter mail
		if(tipo.equals("T")) {
			this.tipo = tipo;
			this.content = content;
			this.creator = creator;
			this.data = data;
		}else{
			this.tipo = tipo;
			this.subject = content;
			this.mailContent = creator;
			this.data = data;
		}
	}



	public String mes(int i) {
		String[] meses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};

		return meses[i];
	}

	public String getMailContent() {
		return mailContent;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {


		Calendar cal = Calendar.getInstance();
		cal.setTime(data);

		String resultado = "ups";
		if(content == null && tipo.equals("F")) {
			resultado = cal.get(Calendar.DAY_OF_MONTH) + "/" + mes(cal.get(Calendar.MONTH)) + "/" + cal.get(Calendar.YEAR) + " - " + "Imagem";
		}else if(tipo.equals("M")){

			resultado = cal.get(Calendar.DAY_OF_MONTH) + "/" + mes(cal.get(Calendar.MONTH)) + "/" + cal.get(Calendar.YEAR) + " - " + subject;
		}else {
			resultado = cal.get(Calendar.DAY_OF_MONTH) + "/" + mes(cal.get(Calendar.MONTH)) + "/" + cal.get(Calendar.YEAR) + " - " + content;
		}

		return resultado;
	}


	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

}
