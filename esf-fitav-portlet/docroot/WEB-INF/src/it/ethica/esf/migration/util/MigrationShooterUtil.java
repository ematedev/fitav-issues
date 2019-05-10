package it.ethica.esf.migration.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.util.StringPool;

public class MigrationShooterUtil {
	public static final List<String> particular = new ArrayList<String>(){{
		  add("DELLO");
		  add("DALLO");
		  add("DELLA");
		  add("DELLE");
		  add("DALLE");
		  add("DELL'");
		  add("DALL'");
		  add("DAL");
		  add("DEL");
		  add("DI");
		  add("DE");
		  add("DA");
		  add("DEGLI");
		  add("D'");
		  add("LA");
		  add("LE");
		  add("L'");
		  add("LO");
		  add("LI");
		  add("LU");
		  add("LE");
		  add("L'");
		  add("MC");
		  add("PEA");
		  add("RE");
		  add("ROS");
		  add("SAN");
		  add("T.");
		  add("UVA");
		  
		  
	  }};
	  
	  
	  public final static List<String> casiParticolari = new ArrayList<String>(){{
	  add("CAMPO");
	  add("DALL'ORTO");
	  add("BALDI");
	  add("PERGAMI");
	  add("BELLUZZI");
	  add("VIGANO'");
	  add("ORLANDI");
	  add("TOGNONI");
	  add("DE");
	  add("PUGI");
	  add("NORIS");
	  add("CHIORDA");
	  add("MEDA");
	  add("SPACCAMELA");
	  add("PASCULLI");
	  add("DE");
	  add("ANGELIS");
	  add("GIUSTI");
	  add("DE");
	  add("MARLE");
	  add("SASSOLI");
	  add("DE");
	  add("BIANCHI");
	  add("ZITO");
	  add("DE");
	  add("LEONARDIS");
	  add("DE");
	  add("PIETRI");
	  add("TONELLI");
	  add("DUPRE'");
	  add("DE");
	  add("FORESTA");
	  add("CARRASSI");
	  add("DEL");
	  add("VILLAR");
	  add("DONA'");
	  add("DALLE");
	  add("ROSE");
	  add("INCISA");
	  add("DELLA");
	  add("ROCCHETTA");
	  add("PIO");
	  add("DI");
	  add("SAVOIA");
	  add("NICOTRA");
	  add("SAN");
	  add("GIACOMO");
	  add("DE");
	  add("REU");
	  add("LUIS");
	  add("DE");
	  add("OLIVEIRA");
	  add("SALVADOR");
	  add("DOS");
	  add("SANTOS");
	  add("CORREIA");
	  add("FERDANDO");
	  add("LA");
	  add("FUENTE");
	  add("MARTINEZ");
	  add("DEL");
	  add("VAS");
	  add("GHELLI");
	  add("LUSERNA");
	  add("RORA'");
	  add("DAL");
	  add("LUOGO");
	  add("PASCALIS");
	  add("MAIO");
	  add("NARDO");
	  add("SPEDALE");
	  add("SALVATORI");
	  add("MALASOMMA");
	  add("MAZZETTI");
	  add("BOTTINI");
	  add("GIUFFRIDA");
	  add("PRIVITERA");
	  add("GARGALLO");
	  add("LENTINI");
	  add("CASTEL");
	  add("PIETRAL.");
	  }};
	  
	  public static String [] getCognome_Nome (String [] inputs){
		  List<String> lista = particular;
	       List<String> lista2 = casiParticolari;
		  String cognome = StringPool.BLANK;
		  String nome = StringPool.BLANK;
		  String [] result = new String [2];
		  if (lista.contains(inputs[0])){
	        	if (inputs.length==2){
	        		cognome=inputs[0];
		        	nome = inputs[1];
	        	}
	        	else 
	        	if (inputs.length==3){
		        	cognome=inputs[0]+" "+inputs[1];
		        	nome = inputs[2];
	        	}
	        	else 
	        	if (inputs.length==4){
	            	if (lista2.contains(inputs[2])){
	            		cognome=inputs[0]+" "+inputs[1]+" "+inputs[2];
	                	nome = inputs[3];
	            	}
	            	else {
	            		cognome=inputs[0]+" "+inputs[1];
	                	nome = inputs[2]+" "+inputs[3];
	            	}
	        		
	        	}
	        	else {
	        		if (lista2.contains(inputs[2])){
	        			if (lista.contains(inputs[2])){
	        				cognome=inputs[0]+" "+inputs[1]+" "+inputs[2]+ " "+inputs[3];
	                		for (int i=4;i<inputs.length;i++){
	                        	nome += inputs[i];
	                        			if (i!=inputs.length-1)
	                        				nome +=" ";
	                		}
	        			}
	        			else {
	        				cognome=inputs[0]+" "+inputs[1]+" "+inputs[2];
	                		for (int i=3;i<inputs.length;i++){
	                        	nome += inputs[i];
	                        			if (i!=inputs.length-1)
	                        				nome +=" ";
	                		}
	        			}
	            		
	            	}
	        		else {
	        			cognome=inputs[0]+" "+inputs[1];
	            		for (int i=2;i<inputs.length;i++){
	                    	nome += inputs[i];
	                    	if (i!=inputs.length-1)
	            				nome +=" ";
	            		}
	        		}
	        		
	     
	        		
	        	}
	        }
	       else if (lista2.contains(inputs[0])){
	        	if (lista2.contains(inputs[1])){
	        		if (inputs.length==2){
	        			cognome=inputs[0];
	                	nome = inputs[1];
	        		} else
	        		if (inputs.length==3){
	        			cognome=inputs[0]+" "+inputs[1];
	        			nome = inputs[2];
	        		}
	        		else 
	        		if (inputs.length==4){
	        			if (lista2.contains(inputs[2])){
	        				cognome=inputs[0]+" "+inputs[1]+" "+inputs[2];
	            			nome = inputs[3];
	        			}
	        			else {
	        				cognome=inputs[0]+" "+inputs[1];
	            			nome = inputs[2] + " "+inputs[3];
	        			}
	        		}
	        		else 
	        		if (inputs.length==5){
	        			if (lista2.contains(inputs[2])){
	        				if (lista2.contains(inputs[3])){
	            				cognome=inputs[0]+" "+inputs[1]+" "+inputs[2] +" "+inputs[3];
	                			nome = inputs[4];
	            			}
	        				else {
	        					System.out.println ("1");
	        					cognome=inputs[0]+" "+inputs[1]+" "+inputs[2];
	        					nome = inputs[3] + " "+inputs[4];
	        				}
	        			}
	        			else {
	        				cognome=inputs[0]+" "+inputs[1];
	            			nome = inputs[2] + " "+inputs[3]+" "+inputs[4];
	        				}
	        		}
	        		else
	        			if (inputs.length==6){
		        			if (lista2.contains(inputs[2])){
		        				if (lista2.contains(inputs[3])){
		            				cognome=inputs[0]+" "+inputs[1]+" "+inputs[2] +" "+inputs[3];
		                			nome = inputs[4]+ " "+inputs[5];
		            			}
		        				else {
		        					cognome=inputs[0]+" "+inputs[1]+" "+inputs[2];
		        					nome = inputs[3] + " "+inputs[4]+ " "+inputs[5];
		        				}
		        			}
		        			else {
		        				cognome=inputs[0]+" "+inputs[1];
		            			nome = inputs[2] + " "+inputs[3]+" "+inputs[4];
		        				}
		        		}
	        	}
	        		
	       
	        	else 
	        		if (inputs.length==2){
	        			cognome=inputs[0];
	                	nome = inputs[1];
	        		}
	        		else 
	        			if (lista2.contains(inputs[1])){
	        				if (lista2.contains(inputs[2])){
	        					cognome=inputs[0]+" "+inputs[1]+ " "+inputs[2];
	        					for (int i=3;i<inputs.length;i++){
	        	                	nome += inputs[i];
	        	                	if (i!=inputs.length-1)
	        	        				nome +=" ";
	        					}
	        				}
	        				else {
	        					cognome=inputs[0]+" "+inputs[1];
	        					for (int i=2;i<inputs.length;i++){
	        	                	nome += inputs[i];
	        	                	if (i!=inputs.length-1)
	        	        				nome +=" ";
	        					}
	        				}
	        				
	        			}
	        			else {
		        			cognome=inputs[0];
		        			for (int i=1;i<inputs.length;i++){
		                	nome += inputs[i];
		                	if (i!=inputs.length-1)
		        				nome +=" ";
	        			}
	        	
	        	}
	        }
	       else {
				cognome=inputs[0];
				for (int i=1;i<inputs.length;i++){
					nome += inputs[i];
					if (i!=inputs.length-1)
						nome +=" ";
				}
	       }
		  result [0] = cognome;
		  result[1] = nome;
		  return result;
	        
	  }
}
