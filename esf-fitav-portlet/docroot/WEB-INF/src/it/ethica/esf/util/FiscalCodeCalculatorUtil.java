package it.ethica.esf.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 * <p>
 * Classe che espone i metodi (statici) per il calcolo di un codice fiscale.
 * <p>
 * Il numero di codice fiscale delle persone fisiche è costituito da
 * un'espressione alfanumerica di sedici caratteri. I primi quindici caratteri
 * sono indicativi dei dati anagrafici di ciascun soggetto secondo l'ordine
 * seguente:
 * <ol>
 * <li>tre caratteri alfabetici per il cognome;</li>
 * <li>tre caratteri alfabetici per il nome;</li>
 * <li>due caratteri numerici per l'anno di nascita;</li>
 * <li>un carattere alfabetico per il mese di nascita;</li>
 * <li>due caratteri numerici per il giorno di nascita ed il sesso</li>
 * <li>quattro caratteri, di cui uno alfabetico e tre (alfa)numerici per il
 * comune italiano o per lo Stato estero di nascita.</li>
 * <li>Il sedicesimo carattere, alfabetico, ha funzione di controllo.</li>
 * 
 * 
 * @author Luca Amoroso, Andrea Zoleo
 */

public class FiscalCodeCalculatorUtil {

	/**
	 * Costruttore privato per inibire l'istanzizione di una classe che ha solo
	 * metodi statici
	 */
	private FiscalCodeCalculatorUtil() {
	}

	/**
	 * Passando in input i dati anagrafici della persona, restituisce il codice
	 * fiscale calcolato. Se uno dei parametri in input è null o stringa vuota
	 * restituisce una stringa vuota.
	 * 
	 * @param cognome Il cognome della persona
	 * @param nome Il nome della persona
	 * @param sesso Il sesso della persona M o F
	 * @param data La data di nascita della persona
	 * @param comune Il codice del comune di nascita della persona
	 * @return String - il codice fiscale calcolato in base a parametri in
	 *         input. Se uno dei parametri in input è null o stringa vuota
	 *         restituisce una stringa vuota.
	 */

	public static String calcolaCf(String cognome, String nome, String sesso,
			Date data, String comune) {
		// controllo gli argomenti
		String[] args = new String[] { cognome, nome, sesso, comune };
		for (String s : args) {
			if (isEmpty(s)) {
				throwEmptyArgException();
			}
		}
		if (data == null) {
			throwEmptyArgException();
		}
		
		sesso = sesso.toUpperCase().trim();
		if (!("M".equals(sesso) || "F".equals(sesso))) {
			throw new IllegalArgumentException(
					"L'argomento 'sesso' deve essere la stringa 'm'o 'f'");
		}

		nome = nome.toUpperCase().trim();
		if (!CHAR_ALLOWED.matcher(nome).matches()) {
			throwIllegalArgException("nome");
		} else {
			nome = sostituzioneChar(nome);
		}

		cognome = cognome.toUpperCase().trim();
		if (!CHAR_ALLOWED.matcher(cognome).matches()) {
			throwIllegalArgException("cognome");
		} else {
			cognome = sostituzioneChar(cognome);
		}

		comune = comune.toUpperCase().trim();
		if (!CODICE_COMUNE_ALLOWED.matcher(comune).matches()) {
			throw new IllegalArgumentException(
					"L'argomento 'comune' non sembra essere un codice valido");
		}

		StringBuilder codfisc = new StringBuilder();
		codfisc.append(calcolaCodCognome(cognome));
		codfisc.append(calcolaCodNome(nome));
		codfisc.append(calcolaCodDt(data, sesso));
		codfisc.append(comune);
		codfisc.append(calcolaCharControllo(codfisc));

		return codfisc.toString();

	}

	/**
	 * Verifica se una stringa è vuota.
	 * 
	 * @param s la stringa da controllare.
	 * @return true se s è null o se è di lunghezza zero o se contiene solo
	 *         spazi.
	 */
	private static boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}

	private static void throwEmptyArgException() {
		throw new IllegalArgumentException(
				"non sono permessi parametri nulli o vuoti");
	}

	private static void throwIllegalArgException(String arg_name) {
		throw new IllegalArgumentException(
				"L'argomento '"
						+ arg_name
						+ "' non può contenere caratteri speciali.");
	}

	/**
	 * Passata una stringa in input, ritorna le sole consonanti o vocali delle
	 * stringa.
	 * <p>
	 * Per ottenere le vocali, passare conson = false
	 * <br/>
	 * Per ottenere le consonanti passare conson = true
	 * 
	 * @param stringa La stringa per la quale si vogliono ottenere le sole
	 *            consonanti o vocali
	 * @param cod può essere false o true a seconda che si vogliano
	 *            ottenere le vocali o le consonanti della stringa
	 * @return String - La stringa contente le solo vocali o consonanti della
	 *         stringa passata in input
	 */

	private static String ottieniConsVoc(String stringa, boolean conson) {
		StringBuilder testo = new StringBuilder();
		int i = 0;
		char[] valChar = stringa.toCharArray();
		for (i = 0; i < valChar.length; i++) {
			if (isVowel(valChar[i]) ^ conson) {
				testo.append(valChar[i]);
			}
		}
		return testo.toString();
	}

	/**
	 * 
	 * I cognomi che risultano composti da più parti o comunque separati od
	 * interrotti, vengono considerati come se fossero scritti secondo un'unica
	 * ed ininterrotta successione di caratteri. Per i soggetti coniugati di
	 * sesso femminile si prende in considerazione soltanto il cognome da
	 * nubile. Se il cognome contiene tre o più consonanti, i tre caratteri da
	 * rilevare sono, nell'ordine, la prima, la seconda e la terza consonante.
	 * Se il cognome contiene due consonanti, i tre caratteri da rilevare sono,
	 * nell'ordine, la prima e la seconda consonante e la prima vocale. Se il
	 * cognome contiene una consonante e due vocali, si rilevano, nell'ordine,
	 * quella consonante e quindi la prima e la seconda vocale. Se il cognome
	 * contiene una consonante e una vocale, si rilevano la consonante e la
	 * vocale, nell'ordine, e si assume come terzo carattere la lettera x (ics).
	 * Se il cognome e' costituito da due sole vocali, esse si rilevano,
	 * nell'ordine, e si assume come terzo carattere la lettera x (ics).
	 * 
	 * @param stringa - Il cognome della persona
	 * @return StringBuilder - Parte del codice fiscale relativo al cognome
	 *         della persona
	 */

	private static StringBuilder calcolaCodCognome(String stringa) {

		StringBuilder codice = new StringBuilder();

		codice.append(ottieniConsVoc(stringa, true)
				+ ottieniConsVoc(stringa, false));

		if (codice.length() > 3) {
			codice = new StringBuilder(codice.substring(0, 3));
		}

		for (int i = codice.length(); i < 3; i++) {
			codice.append(CARATTERE_SOSTITUTO);
		}
		
		return codice;

	}

	/**
	 * 
	 * I nomi doppi, multipli o comunque composti, vengono considerati come
	 * scritti per esteso in ogni loro parte e secondo un'unica ed ininterrotta
	 * successione di caratteri. Se il nome contiene quattro o più consonanti, i
	 * tre caratteri da rilevare sono, nell'ordine, la prima, la terza e la
	 * quarta consonante. Se il nome contiene tre consonanti, i tre caratteri da
	 * rilevare sono, nell'ordine, la prima, la seconda e la terza consonante.
	 * Se il nome contiene due consonanti, i tre caratteri da rilevare sono,
	 * nell'ordine, la prima e la seconda consonante e la prima vocale. Se il
	 * nome contiene una consonante e due vocali, i tre caratteri da rilevare
	 * sono, nell'ordine, quella consonante e quindi la prima e la seconda
	 * vocale. Se il nome contiene una consonante e una vocale, si rilevano la
	 * consonante e la vocale, nell'ordine, e si assume come terzo carattere la
	 * lettera x (ics). Se il nome e' costituito da due vocali, esse si rilevano
	 * nell'ordine, e si assume come terzo carattere la lettera x (ics).
	 * 
	 * @param stringa Il nome della persona
	 * @return StringBuilder - Parte del codice fiscale relativo al nome della
	 *         persona
	 */

	private static StringBuilder calcolaCodNome(String stringa) {

		StringBuilder codice = new StringBuilder(ottieniConsVoc(stringa, true));

		if (codice.length() >= 4) {
			codice = codice.delete(1, 2);
		}

		codice.append(ottieniConsVoc(stringa, false));

		if (codice.length() > 3) {
			codice = codice.replace(0, codice.length(), codice.substring(0, 3));
		}

		for (int i = codice.length(); i < 3; i++) {
			codice.append(CARATTERE_SOSTITUTO);
		}

		return codice;

	}

	/**
	 * 
	 * I due caratteri numerici indicativi dell'anno di nascita sono,
	 * nell'ordine, la cifra delle decine e la cifra delle unità dell'anno
	 * stesso. Il carattere alfabetico corrispondente al mese di nascita e'
	 * quello dal COD_MESE, definito in questa classe. I due caratteri numerici
	 * indicativi del giorno di nascita e del sesso vengono determinati nel modo
	 * seguente: per i soggetti maschili il giorno di nascita figura invariato,
	 * con i numeri da uno a trentuno, facendo precedere dalla cifra zero i
	 * giorni del mese dall'uno al nove; per i soggetti femminili il giorno di
	 * nascita viene aumentato di quaranta unità, per cui esso figura con i
	 * numeri da quarantuno a settantuno. I quatto caratteri alfanumerici
	 * indicativi del comune italiano o dello Stato estero di nascita, sono
	 * costituiti da un carattere alfabetico seguito da tre caratteri numerici,
	 * secondo la codifica stabilita dall'Agenzia del Territorio.
	 * 
	 * @param dtNasc La data di nascita della persona
	 * @param sesso Il sesso della persona M o F
	 * @return StringBuilder - Parte del codice fiscale relativo alla data di
	 *         nascita e al sesso della persona
	 */

	private static StringBuilder calcolaCodDt(Date dtNasc, String sesso) {

		StringBuilder cod = new StringBuilder();

		GregorianCalendar cal = new GregorianCalendar();

		cal.setTime(dtNasc);

		Integer giorno = cal.get(GregorianCalendar.DAY_OF_MONTH);
		Integer mese = cal.get(GregorianCalendar.MONTH);
		Integer anno = cal.get(GregorianCalendar.YEAR);

		cod.append(anno.toString().substring(2, 4));
		cod.append(getCodiceMese(mese));

		if (sesso.equals("M")) {
			cod.append(String.format("%02d", giorno));
		} else {
			giorno += 40;
			cod.append((giorno).toString());
		}
		
		return cod;

	}

	/**
	 * 
	 * Il sedicesimo carattere ha funzione di controllo dell'esatta trascrizione
	 * dei primi quindici caratteri e viene determinato in questo modo: ciascuno
	 * degli anzidetti quindici caratteri, a seconda che occupi posizione di
	 * ordine pari o posizione di ordine dispari, viene convertito in un valore
	 * numerico: 
	 * Per i sette caratteri con posizione di ordine pari viene utilizzato
	 * COD_CHAR_PARI, definito in questa classe 
	 * Per gli otto caratteri con posizione di ordine dispari viene utilizzato
	 * COD_CHAR_DISPARI, definito in questa classe 
	 * I valori numerici così determinati vengono addizionati e la somma si
	 * divide per il numero 26. Il carattere di controllo si ottiene convertendo
	 * il resto di tale divisione nel carattere alfabetico ad esso
	 * corrispondente nella sotto indicata tabella:
	 * 
	 * @param codfisc Il codice fiscale calcolato della persona
	 * @return Character - L'ultimo carattere di controllo relativo al codice
	 *         fiscale
	 */

	private static Character calcolaCharControllo(StringBuilder codfisc) {

		Integer somma = new Integer(0);

		for (int i = 0; i < codfisc.length(); i++) {
			
			int k = Character.getNumericValue(codfisc.charAt(i));
			if (i % 2 == 0) {//parità invertita perchè stringa è zero aligned
				somma += EVEN_ODD_CHAR_CODES[1][k];
			} else {
				somma +=  EVEN_ODD_CHAR_CODES[0][k];
			}

		}
		
		return Character.toUpperCase(Character.forDigit(((somma % 26)+10), 35));

	}
	
	/**
	 * Prende la stringa in input (nome o cognome) e sostituisce tutti i 
	 * caratteri non ammessi con dei caratteri ammessi o stringa vuota.
	 * I caratteri gestiti, e le relative sostituzioni, sono i seguenti:<p>
	 * 
	 * <li>"À" -> "A"</li>
	 * <li>"È" -> "E"</li>
	 * <li>"É" -> "E"</li>
	 * <li>"Ì" -> "I"</li>
	 * <li>"Ò" -> "O"</li>
	 * <li>"Ù" -> "U"</li>
	 * <li>" " (Spazio) -> "" (stringa vuota)</li>
	 * <li>"'" -> "" (stringa vuota)</li>
	 * 
	 * @param value La stringa per la quale si desidera effettuare le sostituzioni
	 * @return String - La stringa con i caratteri non ammessi sostituiti da
	 * caratteri ammessi
	 */
	
	private static String sostituzioneChar(String value){
		
		for (int i = 0; i < CHAR_SOSTITUZIONE[1].length;i++){
			
			value = value.replaceAll(CHAR_SOSTITUZIONE[ROW_REGEX][i], 
												CHAR_SOSTITUZIONE[ROW_SOST][i]);
			
		}
		
		return value;
		
	}

	private static final String CARATTERE_SOSTITUTO = "X";

	private static char[] codici_mesi = { 
			'A', 'B', 'C', 'D', 'E', 'H', 
			'L', 'M', 'P', 'R', 'S', 'T' };

	private static char getCodiceMese(int mese){
		return codici_mesi[mese];
	}
	
	private static int[][] EVEN_ODD_CHAR_CODES={
	{0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25},
	{1,0,5,7,9,13,15,17,19,21,1,0,5,7,9,13,15,17,19,21,2,4,18,20,11,3,6,8,12,14,16,10,22,25,24,23}};
	

	private static boolean isVowel(char c) {
		return VOCALE_ALLOWED.matcher(String.valueOf(c)).matches();
	}
	
	/**
	 * Array utilizzato per ottenere la regex di sostituzione e la relativa
	 * stringa di sostituzione. Si usa per modificare nome e cognome e renderli
	 * sintatticamente corretti.
	 * @see sostituzioneChar()
	 */
	private static final String[][] 
	        CHAR_SOSTITUZIONE = {{"[À]","[È]","[É]","[Ì]","[Ò]","[Ù]","[\\s]","[']"},
			                    {"A","E","E","I","O","U","",""}};
	
	private static final int ROW_REGEX = 0;
	private static final int ROW_SOST = 1;
	
	/**
	 * Utilizzata per verificare la sintassi delle stringhe nome e cognome
	 */
	private static final Pattern CHAR_ALLOWED = Pattern.compile("[A-ZÀÈÉÌÒÙ' ]+");
	
	/**
	 * Utilizzata per il controllo della sintassi del codice dei comuni
	 */
	private static final Pattern CODICE_COMUNE_ALLOWED = Pattern
			.compile("[A-Z][0-9]{3}");

	/**
	 * Utilizzato per verificare se una lettera è una consonante
	 */
	private static final Pattern VOCALE_ALLOWED = Pattern.compile("[AEIOU]");

}
