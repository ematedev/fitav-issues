package it.ethica.esf.portlet;

import java.util.Comparator;

import it.ethica.esf.model.VM_TiratoriTesserati;

public class CompareByNomeCognome implements Comparator<VM_TiratoriTesserati>{

	@Override
	public int compare(VM_TiratoriTesserati o1, VM_TiratoriTesserati o2) {
        int res =  o1.getCognome().compareToIgnoreCase(o2.getCognome());
        if (res != 0) return res;
        return o1.getNome().compareToIgnoreCase(o2.getNome());
	}

}
