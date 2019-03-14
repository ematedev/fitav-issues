
package it.ethica.esf.util;

public class ESFKeys {

	public interface MinElemIncludePage{
	
		final int MINADDRESSUSER = 1;
		final int MAXADDRESSUSER = 10;
		final int MINADDRESSORG = 3;
		final int MAXADDRESSORG = 10;
		
		final int MINPHONEUSER = 1;
		final int MAXPHONEUSER = 4;
		final int MINPHONEORG = 1;
		final int MAXPHONEORG = 4;
		
		final int MINMACHINE = 1;
		final int MAXMACHINE= 8;
	}
	
	public interface ESFCard {

		final long MINCODENUM = 00000;
		final long MAXCODENUM = 99999;
		final int MAXDIGITS = 5;
		
	}
	public interface FileCostant {

		final String ENTRYTYPE_1 = "Pass";
		final String ENTRYTYPE_2 = "Med";
		final String CUSTOMFIELD_1 = "Data_Rilascio";
		final String CUSTOMFIELD_2 = "Data_Scadenza";
		
	}
	public interface ESFTeem {

		final int NUMMAX = 20;
	}

	public interface ESFStateType {

		final int ENABLE = 1;
		final int DISABLE = 2;
		//final int LOOSE = 3;
		final int LOOSE = 35002;
		final int SUSPENDED = 35003;
		//final int SUSPENSION = 4;
		final int SUSPENSION = 35004;
		final int SUSPENSION_ASSEMBLY = 35005;
		final int LOOSE_NO_RENEWAL = 35006;		
		final int GIVEWAY = 584101;
		
	}

		public interface ESFAddressType {

		final String LEGAL = "legal";
		final String POSTAL = "postal";
		final String FIELD = "field";

		final String[] TYPES = {
				LEGAL,
				FIELD,
				POSTAL
		};
		final String[] MANDATORY_TYPES = {
				LEGAL,
				FIELD
		};
		
		final int TYPES_POSITION_LEGAL=0;
		final int TYPES_POSITION_POSTAL=1;
		final int TYPES_POSITION_FIELD=2;
		
		
			
	
	}

	public interface ESFUserRoleType {

		final int REGULAR = 1;
		final int SITE = 2;
		final int ORGANIZATION = 3;
	}
	
	public interface ESFUserRoleDefault {

		final String COACH = "Allenatore";
		final String REFEREE = "Arbitro";
		final String DOCTOR = "Medico";
		final String STAFF = "Staff";
		final String FITAVMANGAR="Fitav User";
	}
	
	public interface ESFUserRoleMatch {

		final String COACH = "Allenatore";
		final String REFEREE = "Arbitro";
		final String DOCTOR = "Medico";
		final String STAFF = "Staf";
		final String FITAVMANGAR="Fitav User";
		final String DT="Direttore Tecnico";
		final int TYPE = 1;
	}

	public interface ESFNationalDelegationType {

		final int SHOOTER = 1;
		final int DOCTOR = 2;
		final int COACH = 3;
		final int STAFF = 4;
		final int REFEREE = 5;
	}
	
	public interface ESFGunType {

		final int RIFLE = 1;
		final int CANE = 2;
		final int CATRIDGE = 3;
	}

	public interface ESFOrganizationTypeId {

		final long FITAV = 0;
		final long REGION = 1;
		final long PROVINCE = 2;
		final long ASSOCIATION = 3;
		final long ASPETTATIVA = 12073;
	}

	public interface ESFAddressConstant {

		final String DEFAULT_STRING = "";
		final int DEFAULT_NUMBER = 0;
		final String DEFAULT_COUNTRY = "IT";
	}
	
	public static final String PACKAGE_MODEL = "it.ethica.esf.model";
	
	public static final String[] ESFOrganizationTypeLabel = {
		"fitav", "region", "province", "association"
	};

	public interface ESFAddressListType{
		
		final int LEGAL = /*12021;//*/12037;
		final int CORRESPONDENCE = /*12022;//*/12038;
		final int STAND = /*12023;//*/12039;
		final int OTHER = /*12024;//*/12040;
		final int POSTAL = /*12024;//*/12060;
	}
	
	public interface ESFPhoneListType{
		
		final int BUSINESS = 11006;
		final int BUSINESSFAX = 11007;
		final int MOBILE = 11008;
		final int OTHER = 11009;
		final int PERSONAL = 11011;
		final int PERSONALFAX = 11012;
	}
	public interface ESFDocumentType{
		
		final String EUROPEANCARD = "Carta Europea";
		final String MEDICALCERTIFICATE = "Certificato Medico";
		final String IDENTITYCARD = "Carta d'Identità";
		final String PHOTO = "Foto";
		final String PASSPORT="Passaporto";
		final String GUNLICENCE="Porto d'Armi";
	}
	
	public interface ESFCategoryChanges{
		
		final int minNumberMatchs = 7;
		final int minPercent2TO1 = 90;
		final int minPercent3TO2 = 86;
		final int minPercent1TO2 = 87;
		final int minPercent2TO3 = 80;
		final int minPercentGP = 93;
		final int minShooterFirstCategory = 400;
		final int minDTChecked = 81;
		final int minPercent2TO1SK = 88;
		final int minPercent3TO2SK = 84;
		final int minPercent2TO1CK = 90;
		final int minPercent3TO2CK = 86;
		final int minPercentETO1CK = 92;
		final int minPercent1TO2CK = 90;
	}
		
	public interface ESFOrganizationCategory{	
		
		final String first="Prima";
		final String second="Seconda";
		final String third="Terza";
		final String fourth="Quarta";
	}
	
	public interface MaxYearAgo{
		
		final int maxYearAgo = 3;
	}
	
	public interface EsfClassInEntityState{
		final String organization = "it.ethica.esf.model.ESFOrganization";
	}
	
	public interface EsfConfigurationKey{
		final String maxAlfa = "max_card_alfa";
		final String maxNum = "max_card_num";
		final String MAXCODENUM_Card = "MAXCODENUM_Card";
		final String MINCODENUM_Card = "MINCODENUM_card";
	}
	public static final String PRESIDENTE = "Presidente Associazione";
}
