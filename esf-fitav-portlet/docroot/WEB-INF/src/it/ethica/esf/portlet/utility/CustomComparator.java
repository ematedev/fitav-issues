package it.ethica.esf.portlet.utility;

import java.util.Comparator;

import it.ethica.esf.model.ESFMatchResult;
import it.ethica.esf.model.ESFNationalMatchResult;

public class CustomComparator implements Comparator<ESFMatchResult> {
	
	@Override
    public int compare(ESFMatchResult o1, ESFMatchResult o2) {
        return o1.getCategoryClassPosition()-o2.getCategoryClassPosition();
    }
}