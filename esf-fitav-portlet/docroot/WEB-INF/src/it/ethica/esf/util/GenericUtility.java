package it.ethica.esf.util;

public class GenericUtility {
	private GenericUtility(){}
	
	public static void main(String args[]){		//Testing
		String code = "200200432";
		String sCode = GenericUtility.getFromChars(code, 4);
		int iCode = Integer.parseInt(sCode);
		iCode++;
		String s = GenericUtility.getZeroPaddedString(String.valueOf(iCode), 4);
		System.out.println(s);
		System.out.println("Length: "+s.length());
		
	}
	
	public static String getZeroPaddedString(String s, int padding){
		int zeros = 0;
		String paddedString = null;
		if(s!=null){
			zeros = padding-s.length();
			paddedString = getZeroPadding(zeros);
			paddedString = paddedString.concat(s);
		}else{
			paddedString = getZeroPadding(padding);			
		}
		return paddedString;
	}
	
	private static String getZeroPadding(int padding){		
		StringBuilder leadingZeros = null;
		if(padding>0){
			leadingZeros = new StringBuilder(padding);
			for(int i=0;i<padding;i++){
				leadingZeros.append("0");
			}
		}else{
			leadingZeros = new StringBuilder("");
		}
		return leadingZeros.toString();
	}
	
	public static String getFromChars(String s, int n){
		String result = null;
		if(s!=null && s.length()>n){
			result = s.substring(n);
		}else{
			result = s;
		}
		return result;
	}
	
}
