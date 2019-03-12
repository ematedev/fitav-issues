
package it.ethica.esf.migration.util;

public class ESFKeys {

	public interface ESFStateType {

		final int ENABLE = 1;
		final int DISABLE = 2;
		// final int LOOSE = 3;
		final int LOOSE = 35002;
		final int SUSPENDED = 35003;
		// final int SUSPENSION = 4;
		final int SUSPENSION = 35004;
		final int SUSPENSION_ASSEMBLY = 35005;
		final int LOOSE_NO_RENEWAL = 35006;

	}

	public interface ESFAddressType {

		final int LEGAL = 12037;
		final int CORRISPONDENCE = 12038;
		final int STAND = 12039;
		final int OTHER = 12040;
	}

	public interface ESFOrganizationTypeId {

		final int FITAV = 0;
		final int REGION = 1;
		final int PROVINCE = 2;
		final int ASSOCIATION = 3;
	}

	public interface ESFPhoneListType {

		final int BUSINESS = 11006;
		final int BUSINESSFAX = 11007;
		final int MOBILE = 11008;
		final int OTHER = 11009;
		final int PERSONAL = 11011;
		final int PERSONALFAX = 11012;
	}

	public interface ESFBillboardType {

		final int ELECTRINIC = 12035;
		final int MANUAL = 12036;
	}

	public interface ESFSportTypeId {

		final long DOUBLETRAP = 15609;
		final long ELECTROCIBLES = 15612;
		final long ELICA = 15608;
		final long FINTELLO = 15264;
		final long FOSSAAUTOMATICA = 15618;
		final long FOSSAOLIMPICA = 15605;
		final long FOSSAUNIVERSALE = 15610;
		final long PERCORSOCACCIA = 15613;
		final long PERCORSOCACCIAPEDANA = 15267;
		final long SKEET = 15606;
		final long SPORTING = 35007;
		final long TRAPAMERICANO = 15268;
		final long VOLATILE = 35008;

	}

	public interface ESFServiceTypeId {

		final long SALA_STAMPA = 13302;
		final long SEGRETERIA = 15269;
		final long GUARDAROBA = 15270;
		final long ARMERIA = 34974;
		final long SALA_RIPOSO = 34975;
		final long SALA_RIUNIONE = 34976;
		final long WC_UOMINI = 34977;
		final long WC_DONNE = 34978;
		final long BAR = 34979;
		final long RISTORANTE = 34980;
		final long PARCHEGGIO = 34981;
		final long IMPIANTI_RISCALDAMENTE_STAND = 34982;
		final long SELF_SERVICE = 34983;
		final long ILLUMINAZIONE_NOTTURNA = 34984;
		final long CAMPO_MULTIDIREZIONALE = 34985;
		final long ZONA_RICREATIVA_TIRATORI = 34986;
		final long COMPUTER_STAMPANTI = 34987;
	}
	
	
	
	public static final String[] ESFOrganizationTypeLabel = {
		"fitav", "region", "province", "association"
	};
	
	
	public static final String PRESIDENTE = "Presidente Associazione";
	
	public static final String VICEPRESIDENTE = "Vice Presidente Associazione";
	
	public static final String SEGRETARIO = "Segretario Associazione";
	
	public static final String CONSIGLIERE = "Consigliere Associazione";
}
