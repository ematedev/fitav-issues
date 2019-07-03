package it.ethica.esf.portlet;

import java.util.Comparator;
import java.util.Date;

import it.ethica.esf.model.VW_NomineDirettoriTiro;

public class CompareByData implements Comparator<VW_NomineDirettoriTiro> {

	@Override
	public int compare(VW_NomineDirettoriTiro e0, VW_NomineDirettoriTiro e1) {
		Date data1 = e0.getDataAssegnazione();
		Date data2 = e1.getDataAssegnazione();
		if(data1.after(data2)) { return -1; }
		if(data1.before(data2)) { return 1; }
		return 0;
	}

}
