package it.ethica.esf.portlet.utility;

import it.ethica.esf.model.ESFMatch;

import java.util.Comparator;

import com.liferay.portal.kernel.util.Validator;


public class MatchComparator implements Comparator<ESFMatch>{
	
	
	public int compare(ESFMatch m1,ESFMatch m2){ 
		
		if(Validator.isNull(m1.getStartDate()) || Validator.isNull(m2.getStartDate())){
			return 0;
		}else{
			
			if(m1.getStartDate() == m2.getStartDate()) {
				return 0; 
			}else if(m1.getStartDate().before(m2.getStartDate()) ){  
				return 1;  
			}else  
				return -1;  
			}
		}

}
