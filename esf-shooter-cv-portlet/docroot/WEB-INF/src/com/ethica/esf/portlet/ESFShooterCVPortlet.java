package com.ethica.esf.portlet;

import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sun.org.mozilla.javascript.internal.regexp.SubString;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.TabStop.Alignment;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFShooterCVPortlet
 */
public class ESFShooterCVPortlet extends MVCPortlet {
	public static Font boldFont16 = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD);
	public static Font boldFont10 = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD);
	public static Font font10 = FontFactory.getFont(FontFactory.COURIER, 10, Font.ITALIC);
	public static Font normalFontHelvetica8 = FontFactory.getFont(FontFactory.COURIER, 8, Font.NORMAL);
	public static Font boldFontHelvetica8 = FontFactory.getFont(FontFactory.COURIER, 8, Font.BOLD);
	public static Font normalFont = FontFactory.getFont(FontFactory.COURIER, 6, Font.ITALIC);
	
	@Override
	public void serveResource(ResourceRequest req,
			ResourceResponse res) throws IOException,
			PortletException {

			/*recupero parametri per capire :
			 * reportType --> se la stampa è pdf o excel
			 * cvType --> nel caso di cv azzurri
			 * 
			 */
	     	String rType = ParamUtil.getString(req, "reportType");
	     	
	     	if(rType != null && rType.equals("pdf")) {
	     		generatePDF(req,res);
	     	}
	     	else {
	     		generateExcel(req, res);
	     	}  

	}
	
	private static void insertCell(PdfPTable table, Phrase phrase, int colspan){
		   
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(phrase);
		  //set the cell alignment
		  cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	
		   cell.setColspan(colspan);
		   cell.setBorder(0);
		   cell.setMinimumHeight(12f);
		   table.addCell("");
		
		  //add the call to the table
		  table.addCell(cell);

	}
	
	private static void insertInt(PdfPTable table, String phrase, Font font){
		   
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(new Phrase(phrase,font));
		  //set the cell alignment
		  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		  cell.setMinimumHeight(1.5f);
		  table.addCell(cell);

	}
	
	
	private void generateExcel(ResourceRequest req,
			ResourceResponse res) throws IOException,
			PortletException {
		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		/*recupero parametri per capire :
		 * cvType --> nel caso di cv azzurri
		 * 
		 */
     	String cvType = ParamUtil.getString(req, "cvType");
     	
     	
     	//arrtable sono i json passati tramite url dalla jsp via js
     	String arrTable1 = ParamUtil.getString(req, "arrTable1");
	    String arrTable2 = ParamUtil.getString(req, "arrTable2"); 
	    String arrTable3 = ParamUtil.getString(req, "arrTable3"); 
	    
	    String name_shooter = StringPool.BLANK;
	    String birthday = StringPool.BLANK;
	    String address1 = StringPool.BLANK;
	    String address2 = StringPool.BLANK;
	    String tessera = StringPool.BLANK;
	    
	    //creazione oggetto JSONArray
	  	JSONArray table1JSONArray = null;
		try {
			table1JSONArray = JSONFactoryUtil.createJSONArray(arrTable1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	JSONArray table2JSONArray = null;
		try {
			table2JSONArray = JSONFactoryUtil.createJSONArray(arrTable2);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	JSONArray table3JSONArray = null;
		try {
			table3JSONArray = JSONFactoryUtil.createJSONArray(arrTable3);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//creazione JSONObject  per recuperari i valori del json
	    JSONObject jsonobject = table1JSONArray.getJSONObject(0);
	    name_shooter = jsonobject.getString("name_shooter");
	    birthday = jsonobject.getString("birthday");
	    address1 = jsonobject.getString("address1");
	    address2 = jsonobject.getString("address2");
	    tessera = jsonobject.getString("tessera");
     
	    
	    String name_file = name_shooter;
		if (Validator.isNotNull(cvType)){
			name_file = "Azzurri_"+name_shooter;
		}
	    
		name_file ="cv_"+name_file;
		
		try {
			
		//Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook(); 
        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet( 
        name_file);
       
        XSSFCellStyle cellStyle = workbook.createCellStyle();
       
        
        //Create row object
        int numrow =0;
        XSSFRow row = spreadsheet.createRow(numrow);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("CURRICULUM");
        
        XSSFRow row1 = spreadsheet.createRow(++numrow);
        XSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue("");
       
        XSSFRow row2 = spreadsheet.createRow(++numrow);
        XSSFCell cell2 = row2.createCell(0);
        cell2.setCellValue("Cognome e Nome:  " +name_shooter);
        
       
	    if(!cvType.equals("azzurri")) {
	    	XSSFRow row3 = spreadsheet.createRow(++numrow);
            XSSFCell cell31 = row3.createCell(0);
            cell31.setCellValue("Data di Nascita:  "+birthday);
	    
           
	    }
	    
	    XSSFRow row4 = spreadsheet.createRow(++numrow);
        XSSFCell cell41 = row4.createCell(0);
        cell41.setCellValue("Indirizzo:  "+address1);
	    
        XSSFRow row42 = spreadsheet.createRow(++numrow);
        XSSFCell cell43 = row42.createCell(0);
        cell43.setCellValue(address2);
        
	    if(!cvType.equals("azzurri")) {
	    	XSSFRow row5 = spreadsheet.createRow(++numrow);
            XSSFCell cell51 = row5.createCell(0);
            cell51.setCellValue("Tessera:  "+tessera);
	    
	    }
	   
	    XSSFRow row6 = spreadsheet.createRow(++numrow);
        
	    XSSFRow row7 = spreadsheet.createRow(++numrow);
        
	    if (cvType.equals("azzurri")){
	    	XSSFRow row8 = spreadsheet.createRow(++numrow);
            XSSFCell cell81 = row8.createCell(0);
            cell81.setCellValue("SCHEDA AZZURRI:");
	    }
	    
	    
	    if (!cvType.equals("azzurri")){
    		
	    	 XSSFRow row9 = spreadsheet.createRow(++numrow);
			
			
			for (int k=0;k<table2JSONArray.length();k++){
		    	JSONObject jsonobject2 = table2JSONArray.getJSONObject(k);
		    	Iterator<String> keys = jsonobject2.keys();
		    	String key = StringPool.BLANK;
		    	while( keys.hasNext() ) {
		    	    key = (String)keys.next();
		    	}
    			
    		    XSSFRow row10 = spreadsheet.createRow(++numrow);
                XSSFCell cell101 = row10.createCell(0);
                cell101.setCellValue(key);
    	    
                XSSFCell cell102 = row10.createCell(1);
                cell102.setCellValue(jsonobject2.getString(key));
			}
			
			 XSSFRow row11 = spreadsheet.createRow(++numrow);
			 
			 
			 XSSFRow row12 = spreadsheet.createRow(++numrow); 
			 XSSFCell cell121 = row12.createCell(0);
			 cell121.setCellValue("MEDAGLIERE");
			
			 XSSFRow row13 = spreadsheet.createRow(++numrow);
			
			
			 XSSFRow row14 = spreadsheet.createRow(++numrow);
			 
			 XSSFCell cell141 = row14.createCell(0);
			 cell141.setCellValue("Descrizione".toUpperCase());
			 
			 XSSFCell cell142 = row14.createCell(1);
			 cell142.setCellValue("Oro".toUpperCase());
			 
			 XSSFCell cell143 = row14.createCell(2);
			 cell143.setCellValue("Argento".toUpperCase());
			 
			 XSSFCell cell144 = row14.createCell(3);
			 cell144.setCellValue("Bronzo".toUpperCase());
			 
			 XSSFCell cell145 = row14.createCell(4);
			 cell145.setCellValue("Anno".toUpperCase());
			 
			 XSSFCell cell146 = row14.createCell(5);
			 cell146.setCellValue("Qualif.".toUpperCase());
			 
			 XSSFCell cell147 = row14.createCell(6);
			 cell147.setCellValue("Tipologia".toUpperCase());
			 
			 XSSFCell cell148 = row14.createCell(7);
			 cell148.setCellValue("Località".toUpperCase());
			 
			 XSSFCell cell149 = row14.createCell(8);
			 cell149.setCellValue("Stato".toUpperCase());
			 
			 XSSFCell cell1410 = row14.createCell(9);
			 cell1410.setCellValue("Specialità".toUpperCase());
			 
			 CellStyle style = workbook.createCellStyle();//Create style
			    XSSFFont font = workbook.createFont();//Create font
			    font.setFontHeightInPoints((short)10);
			    font.setFontName("Arial");
			    font.setColor(IndexedColors.BLUE.getIndex());
			    font.setBold(true);
			    font.setItalic(false);
			    style.setFont(font);//set it to bold

			    for(int i = 0; i < row14.getLastCellNum(); i++){//For each cell in the row 
			    	row14.getCell(i).setCellStyle(style);//Set the sty;e
			    }
			
			for (int q=0;q<table3JSONArray.length();q++){
		    	JSONObject jsonobject3 = table3JSONArray.getJSONObject(q);
		    	String descrizione = jsonobject3.getString("Descrizione");
			    String anno = jsonobject3.getString("Anno");
			    String argento = jsonobject3.getString("Argento");
			    String oro = jsonobject3.getString("Oro");
			    String bronzo = jsonobject3.getString("Bronzo");
			    String qualificazione = jsonobject3.getString("Qualificazione");
			    String specialita = jsonobject3.getString("Specialità");
			    String stato = jsonobject3.getString("Stato");
			    String localita = jsonobject3.getString("Località");
			    String tipologia = jsonobject3.getString("Tipologia");
			    
			    int index = descrizione.indexOf("-");
				String descr = descrizione.substring(0,index-1);
				String descr2 = descrizione.
						substring(index+2,descrizione.length());
			   
				
				//insert riga description
				XSSFRow row15 = spreadsheet.createRow(++numrow);
                XSSFCell cell151 = row15.createCell(0);
                cell151.setCellValue(descrizione);
                cell151.setCellStyle(cellStyle );
                cellStyle.setWrapText(true);
			    
                XSSFCell cell152 = row15.createCell(1);
                cell152.setCellValue(oro);
			    
                XSSFCell cell153 = row15.createCell(2);
                cell153.setCellValue(argento);
                
                XSSFCell cell154 = row15.createCell(3);
                cell154.setCellValue(bronzo);
                
                XSSFCell cell155 = row15.createCell(4);
                cell155.setCellValue(anno);
                
                XSSFCell cell156 = row15.createCell(5);
                cell156.setCellValue(qualificazione);
                
                XSSFCell cell157 = row15.createCell(6);
                cell157.setCellValue(tipologia);
                
                XSSFCell cell158 = row15.createCell(7);
                cell158.setCellValue(localita);
			    
                XSSFCell cell159 = row15.createCell(8);
                cell159.setCellValue(stato);
			    
                XSSFCell cell1510 = row15.createCell(9);
                cell1510.setCellValue(specialita);
			}
			
			
	    }
	   
        spreadsheet.autoSizeColumn(0);
        
		
        /*  */
        ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
        workbook.write(outByteStream);
        byte [] outArray = outByteStream.toByteArray();
        
        res.setContentType("application/vnd.ms-excel");
       
        res.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
        res.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+name_file+".xls;");
       
        
        OutputStream out = res.getPortletOutputStream();

        out.write(outArray);
        out.flush();
        out.close();
        
		} catch (Exception exc){
			exc.printStackTrace();
		}
		
	}
	
	private void generatePDF(ResourceRequest req,
			ResourceResponse res) throws IOException,
			PortletException {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		/*recupero parametri per capire :
		 * cvType --> nel caso di cv azzurri
		 * 
		 */
     	String cvType = ParamUtil.getString(req, "cvType");
     	
     	
     	//arrtable sono i json passati tramite url dalla jsp via js
     	String arrTable1 = ParamUtil.getString(req, "arrTable1");
	    String arrTable2 = ParamUtil.getString(req, "arrTable2"); 
	    String arrTable3 = ParamUtil.getString(req, "arrTable3"); 
	    
	    String name_shooter = StringPool.BLANK;
	    String birthday = StringPool.BLANK;
	    String address1 = StringPool.BLANK;
	    String address2 = StringPool.BLANK;
	    String tessera = StringPool.BLANK;
	    
	    //creazione oggetto JSONArray
	  	JSONArray table1JSONArray = null;
		try {
			table1JSONArray = JSONFactoryUtil.createJSONArray(arrTable1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	JSONArray table2JSONArray = null;
		try {
			table2JSONArray = JSONFactoryUtil.createJSONArray(arrTable2);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	JSONArray table3JSONArray = null;
		try {
			table3JSONArray = JSONFactoryUtil.createJSONArray(arrTable3);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//creazione JSONObject  per recuperari i valori del json
	    JSONObject jsonobject = table1JSONArray.getJSONObject(0);
	    name_shooter = jsonobject.getString("name_shooter");
	    birthday = jsonobject.getString("birthday");
	    address1 = jsonobject.getString("address1");
	    address2 = jsonobject.getString("address2");
	    tessera = jsonobject.getString("tessera");
     
	    
	    String name_file = name_shooter;
		if (Validator.isNotNull(cvType)){
			name_file = "Azzurri_"+name_shooter;
		}
	    
		name_file ="cv_"+name_file;
		
        	try {   
        		
        		Document document = new Document();
      
                PdfWriter.getInstance(document, baos);
                
                document.open();
	  
			    String tessIntest = tessera.substring(0,tessera.indexOf(":")+1);
			    tessera = tessera.
			    		substring(tessera.indexOf(":")+1,tessera.length())
    			    		.replace(StringPool.SPACE, StringPool.BLANK);

    			PdfPTable table = new PdfPTable(12);
    			table.getDefaultCell().setPadding(12);
    			table.getDefaultCell().setBorder(0);
    			
        		
        		if(!cvType.equals("azzurri")) {
        			PdfPCell titleCell = new PdfPCell();
        			Phrase titleLine = new Phrase("CURRICULUM ", boldFont16 );
        			titleCell.setPhrase(titleLine);
        			titleCell.setBorder(0);
        			titleCell.setVerticalAlignment(Element.ALIGN_LEFT);
        			titleCell.setColspan(12);
        			table.addCell(titleCell);
    			}
    			
				insertCell(table, new Phrase(" "),12);
    			
    			PdfPCell cell;
    	        
    			cell = new PdfPCell(new Phrase("Cognome e Nome:",boldFont10));
    		    cell.setBorder(0);
    		    cell.setColspan(4);
    		    table.addCell(cell);
        		    
    		    cell = new PdfPCell(new Phrase(name_shooter,font10));
    		    cell.setBorder(0);
    		    cell.setColspan(8);
    		    table.addCell(cell);
    		    
    		    if(!cvType.equals("azzurri")) {
    		    cell = new PdfPCell(new Phrase("Data di Nascita:",boldFont10));
    		    cell.setBorder(0);
    		    cell.setColspan(4);
    		    table.addCell(cell);
    		    
    		    cell = new PdfPCell(new Phrase(birthday,font10));
    		    cell.setBorder(0);
    		    cell.setColspan(8);
    		    table.addCell(cell);
    		    }
    		    cell = new PdfPCell(new Phrase("Indirizzo",boldFont10));
    		    cell.setBorder(0);
    		    cell.setColspan(4);
    		    cell.setRowspan(2);
    		    table.addCell(cell);
    		    
    		    cell = new PdfPCell(new Phrase(address1,font10));
    		    cell.setBorder(0);
    		    cell.setColspan(8);
    		    table.addCell(cell);
    		    
    		    cell = new PdfPCell(new Phrase(address2,font10));
    		    cell.setBorder(0);
    		    cell.setColspan(8);
    		    table.addCell(cell);
    		    
    		    if(!cvType.equals("azzurri")) {
        		    cell = new PdfPCell(new Phrase(tessIntest,boldFont10));
        		    cell.setBorder(0);
        		    cell.setColspan(4);
        		    cell.setRowspan(2);
        		    table.addCell(cell);
        		    
        		    cell = new PdfPCell(new Phrase(tessera,font10));
        		    cell.setBorder(0);
        		    cell.setColspan(8);
        		    table.addCell(cell);
    		    }
    		   
    		    insertCell(table, new Phrase(" "),12);
    		    insertCell(table, new Phrase(" "),12);
    		    
    		    if (cvType.equals("azzurri")){
    		    	cell = new PdfPCell(new Phrase("SCHEDA AZZURRI",boldFont16));
	        		    cell.setBorder(0);
	        		    cell.setColspan(12);
	        		    cell.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        		    table.addCell(cell);
    		    }
    		    
    		    document.add(table);
    		    
    		    if(!cvType.equals("azzurri")) {
    			    PdfPTable tableDati = new PdfPTable(12);
    			    
    			    tableDati.getDefaultCell().setBorder(1);
    			    float[] columnWidths = 
    			    		new float[] {2.5f, 2f, 2f, 1.5f, 
    			    		1.3f, 1.3f, 1.3f, 1.5f, 2f, 1.5f, 2f, 2f};
    			    tableDati.setWidths(columnWidths);
    			    
        			insertInt(tableDati, "Descr.Gara", boldFontHelvetica8);
        			insertInt(tableDati, "Data_Da", boldFontHelvetica8);
        			insertInt(tableDati, "Data_A", boldFontHelvetica8);
        			insertInt(tableDati, "Spec.", boldFontHelvetica8);
        			insertInt(tableDati, "I/S", boldFontHelvetica8);
        			insertInt(tableDati, "Cat.", boldFontHelvetica8);
        			insertInt(tableDati, "Qual.", boldFontHelvetica8);
        			insertInt(tableDati, "Posiz.", boldFontHelvetica8);
        			insertInt(tableDati, "Risult.", boldFontHelvetica8);
        			insertInt(tableDati, "Finale", boldFontHelvetica8);
        			insertInt(tableDati, "Spar.1", boldFontHelvetica8);
        			insertInt(tableDati, "Spar.2", boldFontHelvetica8);
        			
        			PdfPCell cellDati;
        			
        			for (int j=1;j<table2JSONArray.length();j++){
    			    	JSONObject jsonobject2 = table2JSONArray.getJSONObject(j);
    			    	String col1 = jsonobject2.getString("Descrizione Gara");
        			    String col2 = jsonobject2.getString("Data Da");
        			    String col3 = jsonobject2.getString("Data A");
        			    String col4 = jsonobject2.getString("Spec.");
        			    String col5 = jsonobject2.getString("I/S");
        			    String col6 = jsonobject2.getString("Cat.");
        			    String col7 = jsonobject2.getString("Qual.");
        			    String col8 = jsonobject2.getString("Posiz.");
        			    String col9 = jsonobject2.getString("Risult.");
        			    String col10 = jsonobject2.getString("Finale");
        			    String col11 = jsonobject2.getString("Spar.1");
        			    String col12 = jsonobject2.getString("Spar.2");
        			    
        			    cellDati = new PdfPCell(new Phrase(col1,normalFont));
        			    tableDati.addCell(cellDati);
        			    
        			    cellDati = new PdfPCell(new Phrase(col2,normalFont));
        			    tableDati.addCell(cellDati);
        			    
        			    cellDati = new PdfPCell(new Phrase(col3,normalFont));
        			    tableDati.addCell(cellDati);
        			    
        			    cellDati = new PdfPCell(new Phrase(col4,normalFont));
        			    tableDati.addCell(cellDati);
        			    
        			    cellDati = new PdfPCell(new Phrase(col5,normalFont));
        			    tableDati.addCell(cellDati);
        			    
        			    cellDati = new PdfPCell(new Phrase(col6,normalFont));
        			    tableDati.addCell(cellDati);
        			    
        			    cellDati = new PdfPCell(new Phrase(col7,normalFont));
        			    tableDati.addCell(cellDati);
        			    
        			    cellDati = new PdfPCell(new Phrase(col8,normalFont));
        			    tableDati.addCell(cellDati);
        			    
        			    cellDati = new PdfPCell(new Phrase(col9,normalFont));
        			    tableDati.addCell(cellDati);
        			    
        			    cellDati = new PdfPCell(new Phrase(col10,normalFont));
        			    tableDati.addCell(cellDati);
        			    
        			    cellDati = new PdfPCell(new Phrase(col11,normalFont));
        			    tableDati.addCell(cellDati);
        			    
        			    cellDati = new PdfPCell(new Phrase(col12,normalFont));
        			    tableDati.addCell(cellDati);
			    }
        			
        		
        			document.add(tableDati);
    			
    		    }
    		    if (cvType.equals("azzurri")){
    		
    		    	PdfPTable tableAz = new PdfPTable(12);
        			tableAz.getDefaultCell().setPadding(12);
        			tableAz.getDefaultCell().setBorder(0);
        			
					insertCell(tableAz, new Phrase(" "),12);
        			
        			PdfPCell cellAz;
        			
        			
        			for (int k=0;k<table2JSONArray.length();k++){
    			    	JSONObject jsonobject2 = table2JSONArray.getJSONObject(k);
    			    	Iterator<String> keys = jsonobject2.keys();
    			    	String key = StringPool.BLANK;
    			    	while( keys.hasNext() ) {
    			    	    key = (String)keys.next();
    			    	}
            			cellAz = new PdfPCell(new Phrase(key,boldFont10));
            			cellAz.setBorder(0);
            			cellAz.setColspan(4);
            		    tableAz.addCell(cellAz);
                		    
            		    cellAz = 
            		    		new PdfPCell
            		    		(new Phrase(jsonobject2.getString(key),font10));
            		    cellAz.setBorder(0);
            		    cellAz.setColspan(8);
            		    tableAz.addCell(cellAz);
        			}
        			
        			insertCell(tableAz, new Phrase(" "),12);
        			 
        			cellAz = new PdfPCell(new Phrase("MEDAGLIERE",boldFont16));
        			cellAz.setBorder(0);
        			cellAz.setColspan(12);
        			cellAz.setHorizontalAlignment(Element.ALIGN_CENTER); 
        			tableAz.addCell(cellAz);
        			
        			insertCell(tableAz, new Phrase(" "),12);
        			
        			document.add(tableAz);
        		  
        			PdfPTable tableMed = new PdfPTable(10);
        			tableMed.getDefaultCell().setBorder(0);
        			float[] columnWidths = 
    			    		new float[] 
    			    				{2.5f, 1.5f, 1.5f, 1.5f, 1f,
        					1.5f, 2f, 2f, 1.3f, 1.5f};
        			tableMed.setWidths(columnWidths);
        			PdfPCell cellMed;
        			
        			insertInt(tableMed, "Descrizione",normalFontHelvetica8);
        			insertInt(tableMed, "Oro",normalFontHelvetica8);
        			insertInt(tableMed, "Argento",normalFontHelvetica8);
        			insertInt(tableMed, "Bronzo",normalFontHelvetica8);
        			insertInt(tableMed, "Anno",normalFontHelvetica8);
        			insertInt(tableMed, "Qualif.",normalFontHelvetica8);
        			insertInt(tableMed, "Tipologia",normalFontHelvetica8);
        			insertInt(tableMed, "Località",normalFontHelvetica8);
        			insertInt(tableMed, "Stato",normalFontHelvetica8);
        			insertInt(tableMed, "Spec.",normalFontHelvetica8);
        			
        			
        			for (int q=0;q<table3JSONArray.length();q++){
    			    	JSONObject jsonobject3 = table3JSONArray.getJSONObject(q);
    			    	String descrizione = jsonobject3.getString("Descrizione");
        			    String anno = jsonobject3.getString("Anno");
        			    String argento = jsonobject3.getString("Argento");
        			    String oro = jsonobject3.getString("Oro");
        			    String bronzo = jsonobject3.getString("Bronzo");
        			    String qualificazione = jsonobject3.getString("Qualificazione");
        			    String specialita = jsonobject3.getString("Specialità");
        			    String stato = jsonobject3.getString("Stato");
        			    String localita = jsonobject3.getString("Località");
        			    String tipologia = jsonobject3.getString("Tipologia");
        			    
        			    int index = descrizione.indexOf("-");
        				String descr = descrizione.substring(0,index-1);
        				String descr2 = descrizione.
        						substring(index+2,descrizione.length());
        			    
        				
        				Phrase description = new Phrase();
        				description.add(new Chunk(descr,boldFontHelvetica8));
        				
        				Phrase description1 = new Phrase();
        				description1.add(new Chunk(descr2,normalFontHelvetica8));
        				
        				//insert riga description
        			    cellMed = new PdfPCell(new Phrase(description));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    cellMed.setBorder( Rectangle.LEFT | Rectangle.TOP);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(""));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    cellMed.setBorder( Rectangle.TOP);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(("")));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    cellMed.setBorder( Rectangle.TOP);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(("")));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    cellMed.setBorder( Rectangle.TOP);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(("")));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    cellMed.setBorder( Rectangle.TOP);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(("")));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    cellMed.setBorder( Rectangle.TOP);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(("")));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    cellMed.setBorder( Rectangle.TOP);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(("")));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    cellMed.setBorder( Rectangle.TOP);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(("")));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    cellMed.setBorder( Rectangle.TOP);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(("")));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    cellMed.setBorder(Rectangle.RIGHT |Rectangle.TOP);
        			    tableMed.addCell(cellMed);
        			    
        			    //fine riga description;
        			    cellMed = new PdfPCell(new Phrase(description1));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(oro,normalFont));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(argento,normalFont));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(bronzo,normalFont));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(anno,normalFont));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(qualificazione,normalFont));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(tipologia,normalFont));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(localita,normalFont));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(stato,normalFont));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    tableMed.addCell(cellMed);
        			    
        			    cellMed = new PdfPCell(new Phrase(specialita,normalFont));
        			    cellMed.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			    tableMed.addCell(cellMed);
        			}
        			
        			document.add(tableMed);
    		    }
    		    
        		document.close();
                
        		
                res.setContentType("application/pdf");
                
                res.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
                res.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+name_file+".pdf;");
               
                
                OutputStream out = res.getPortletOutputStream();
                baos.writeTo(out);
                
                out.flush();
                out.close();

        	} catch (Exception e2) {
                    e2.printStackTrace();
        	}
        
		
	}

}
