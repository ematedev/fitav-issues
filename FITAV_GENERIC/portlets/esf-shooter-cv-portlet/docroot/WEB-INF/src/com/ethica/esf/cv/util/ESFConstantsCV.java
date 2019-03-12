package com.ethica.esf.cv.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ESFConstantsCV {

	public static Map<String, String> spec = new TreeMap<String, String>(){{
		put("Double Trap","DT");
		put("Elica","EL");
		put("Fossa Olimpica","FO");
		put("Fossa Universale","FU");
		put("Percorso Caccia","PC");
		put("Percorso Caccia In Pedana","PP");
		put("Skeet","SK");
		}
	};
	
	public static Map<String, String> qual = new TreeMap<String, String>(){{
		put("Lady Junior","JL");
		put("Lady","L");
		}
	};
	
	public static String TEAM_MATCH = "Squadra";
	
	public static String INDIVIDUAL_MATCH = "Individuale";
}
