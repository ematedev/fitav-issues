package it.ethica.esf.portlet.utility;

import it.ethica.esf.model.ESFNationalMatchResult;

import java.util.Comparator;

public class NationalResultsComparator implements Comparator<ESFNationalMatchResult>{
	
	public int compare(ESFNationalMatchResult m1,ESFNationalMatchResult m2){
		
		if(m1.getPosition() == m2.getPosition()) {
			
			return 0; 
			
		}else if(m1.getPosition() > (m2.getPosition())){
			
			return 1;
			
		}else
			
			return -1;
		}

}
