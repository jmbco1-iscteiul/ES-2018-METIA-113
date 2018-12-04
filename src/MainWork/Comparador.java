package MainWork;

import java.util.Calendar;
import java.util.Comparator;

public class Comparador implements Comparator<Mensagem>{

	
	@Override
	public int compare(Mensagem m1, Mensagem m2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(m1.getData());

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(m2.getData());

		if(m1.getData().compareTo(m2.getData())>0) {
			return -1;
		}else if(m1.getData().compareTo(m2.getData())<0) {
			return 1;
		}else if(m1.getData().compareTo(m2.getData())==0) {
			return 0;
		}
		return 0;
	}
	
	

}
