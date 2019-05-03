package it.ethica.esf.portlet.utility;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFResult;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.impl.ESFCardImpl;
import it.ethica.esf.model.impl.ESFMatchImpl;
import it.ethica.esf.model.impl.ESFOrganizationImpl;
import it.ethica.esf.model.impl.ESFUserImpl;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFCityLocalServiceUtil;
import it.ethica.esf.service.ESFDescriptionLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFResultLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFCityPK;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFKeys.ESFAddressListType;


public class GenerateShooterCV extends MVCPortlet{
	
	public void generateShooterCV(ResourceRequest req, ResourceResponse resp, long shooterId)
					throws SystemException, PortalException, PortletException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		
		ESFUser shooter = new ESFUserImpl();
		
		List<ESFResult> mrs = new ArrayList<ESFResult>();
		List<ESFResult> sortedMrs = new ArrayList<ESFResult>();
		List<Long> matchIds = new ArrayList<Long>();
		List<ESFMatch> matchs = new ArrayList<ESFMatch>();
		List<CurriculumShooterInfo> cs = new ArrayList<CurriculumShooterInfo>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//String className = (String)req.getAttribute("addresses.className");
		String correspondenceAddress = "";
		String street = "";
		String city= "";
		String zip = "";
		
		
		List<ESFAddress> esfAddresses = new ArrayList<ESFAddress>();
		ESFAddress esfAddress = null; 
		
		esfAddresses = ESFAddressLocalServiceUtil.getESFAddresses(themeDisplay.getCompanyId(), ESFUser.class.getName(), shooterId);
		
		for(ESFAddress a: esfAddresses){
			
			if(ESFAddressListType.CORRESPONDENCE == a.getListTypeId()){
				
				ESFCityPK cityPk = new ESFCityPK();
				cityPk.setIdCity(a.getEsfCityId());
				cityPk.setIdCountry(a.getEsfCountryId());
				cityPk.setIdProvince(a.getEsfProvinceId());
				cityPk.setIdRegion(a.getEsfRegionId());
				
				street = a.getStreet1();
				
				if(Validator.isNotNull(a.getEsfCityId()) && Validator.isNotNull(ESFCityLocalServiceUtil.fetchESFCity(cityPk)) &&
								Validator.isNotNull(ESFCityLocalServiceUtil.fetchESFCity(cityPk).getName())){
					city = ESFCityLocalServiceUtil.fetchESFCity(cityPk).getName();
				}
				
				zip = a.getZip();
			}
			
			correspondenceAddress ="Indirizzo: via"+ street + ", città: " + city + " CAP:" + zip;
		}

		mrs = ESFResultLocalServiceUtil.findByESFShooterId(shooterId);
		
		for(ESFResult nmr : mrs){
			
			if(!matchIds.contains(nmr.getEsfMatchId())){
				matchIds.add(nmr.getEsfMatchId());
			}
		}

		for(ESFResult mr : mrs){
			
			if(!matchIds.contains(mr.getEsfMatchId())){
				matchIds.add(mr.getEsfMatchId());
			}
		}

		for(Long mId : matchIds){
			if(Validator.isNotNull(ESFMatchLocalServiceUtil.fetchESFMatch(mId))){
				matchs.add(ESFMatchLocalServiceUtil.fetchESFMatch(mId));
			}
		}
		
		sortedMrs.addAll(mrs);
		Collections.sort(sortedMrs, new ResultComparator());
		
		for(ESFResult r : sortedMrs){
			ESFMatch match = new ESFMatchImpl();
			CurriculumShooterInfo csI = new CurriculumShooterInfo();
			String matchDesc="";
			Date matchStartDate = new Date();
			Date matchEndDate  = new Date();
			String spec = "";
			String isIndividual = "";
			String category = "";
			String qualification = "";
			int position = 0;
			int result = 0;
			int total = 0;
			int finalTotal = 0;
			int shootOff1 ;
			int shootOff2 ;
			
			
			try {
				match = ESFMatchLocalServiceUtil.fetchESFMatch(r.getEsfMatchId());
			}
			catch (Exception e) {
				// TODO: handle exception
				_log.error("ERRORE, match non trovato");
			}
			
			if(Validator.isNotNull(match)){
				
				matchStartDate = match.getStartDate();
				matchEndDate = match.getEndDate();
				if(match.isIsIndividualMatch()){
					isIndividual = isIndividual+"Ind";
				}
				if(match.isIsTeamMatch()){
					isIndividual = isIndividual +" Squa";
				}
				if(0 < match.getDescription()){
					if(Validator.isNotNull(ESFDescriptionLocalServiceUtil.fetchESFDescription(match.getDescription())) && 
							Validator.isNotNull(ESFDescriptionLocalServiceUtil.fetchESFDescription(match.getDescription()).getName())){
						matchDesc = ESFDescriptionLocalServiceUtil.fetchESFDescription(match.getDescription()).getName();
					}
				}
				if(0 < match.getEsfAssociationId()){
					try{
						if(Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(match.getEsfAssociationId())) &&
										Validator.isNotNull(ESFOrganizationLocalServiceUtil.fetchESFOrganization(match.getEsfAssociationId()).getName())){
							matchDesc = matchDesc + " " + ESFOrganizationLocalServiceUtil.fetchESFOrganization(match.getEsfAssociationId()).getName();
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						_log.error("ERRORE, associazione non trovata");
					}
					
				}else if(!StringPool.BLANK.equals(match.getNotNationalAssotiation())){
					matchDesc = matchDesc + " " +match.getNotNationalAssotiation();
				}
			}
			
			if(0 < r.getEsfMatchTypeId()){
				
				try {
					if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(r.getEsfMatchTypeId())) &&
									Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(r.getEsfMatchTypeId()).getCode())){
						spec = ESFSportTypeLocalServiceUtil.fetchESFSportType(r.getEsfMatchTypeId()).getCode();
					}
				}
				catch (Exception e) {
					// TODO: handle exception
					_log.error("ERRORE, specialità non trovata");
				}
				
			}
			
			category = r.getCategory();
			qualification = r.getQualificationCode();
			position = r.getPosition();
			result = r.getTotalS();
			finalTotal = r.getFinalTotal();
			shootOff1 = r.getShootOff1s();
			shootOff2 = r.getShootOff2s();
			
			csI.setMatchStartDate(matchStartDate);
			csI.setMatchEndDate(matchEndDate);
			csI.setMatchDesc(matchDesc);
			csI.setIndividual(isIndividual);
			csI.setSpec(spec);
			csI.setCategory(category);
			csI.setQualification(qualification);
			csI.setPosition(position);
			csI.setResult(result);
			csI.setFinalTotal(finalTotal);
			csI.setShootOff1(shootOff1);
			csI.setShootOff2(shootOff2);
			
			cs.add(csI);
		}

		try {
			
			shooter = ESFUserLocalServiceUtil.fetchESFUser(shooterId);
			
			String shooterName = "";
			String birthDate= "";
			String birthCity = "";
			String soc = "";
			String cardCode = "";
			String actualOrg = "";
			ESFCard card = new ESFCardImpl();
			ESFOrganization organization = new ESFOrganizationImpl();
			
			List<ESFCard> cards = new ArrayList<ESFCard>();
			cards = ESFCardLocalServiceUtil.findAllESFCardsByU_S(shooterId, ESFKeys.ESFStateType.ENABLE);

			if (cards.size() > 0){
				card = cards.get(0);
				
			}

			long  associationId = shooterId > 0 && Validator.isNotNull(card) ?card.getEsfOrganizationId():0;

			if(Validator.isNotNull(card) && Validator.isNotNull(card.getCode())){
				cardCode = card.getCode();
				organization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(card.getEsfOrganizationId());
			}

			if(cards.size() > 0 && Validator.isNotNull(organization) && Validator.isNotNull(organization.getName())){
				actualOrg = organization.getName();
			}

			if(Validator.isNotNull(shooter) && Validator.isNotNull(shooter.getFirstName()) &&
							Validator.isNotNull(shooter.getLastName())){
				shooterName = shooter.getFirstName() + " " + shooter.getLastName();
			}

			if(Validator.isNotNull(shooter) && Validator.isNotNull(shooter.getBirthcity())){
				birthCity = shooter.getBirthcity();
			}

			com.itextpdf.text.Document document = new com.itextpdf.text.Document(); 
			ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
			PdfWriter writer = PdfWriter.getInstance(document, baos);
			document.open();
			
			Paragraph paragraph = new Paragraph();
			Paragraph paragraph1 = new Paragraph();
			
			Font f = new Font(FontFamily.TIMES_ROMAN,10.0f,Font.NORMAL,BaseColor.BLACK);
			
			paragraph.add("Curriculum Sportivo "+shooterName);
			paragraph.setAlignment(Element.ALIGN_RIGHT);
			paragraph.setSpacingAfter(15);
			
			document.add(paragraph);
			
			document.add(new Paragraph(correspondenceAddress));
			document.add(new Paragraph("Data e luogo di nascita: "+sdf.format(shooter.getBirthday())+"     "+birthCity.toUpperCase()));
			document.add(new Paragraph("Tessera:   "+cardCode+"                         Società:"+actualOrg));
			document.add(new Paragraph(" "));

			float[] columnWidths = {20,10,10,5,5,5,5,5,5,5,5,5};
			PdfPTable table = new PdfPTable(columnWidths); 
			table.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.setWidthPercentage(100);
			
			PdfPCell cell1 = new PdfPCell(new Paragraph("Descrizione Gara"));
			PdfPCell cell2 = new PdfPCell(new Paragraph("Data da"));
			PdfPCell cell3 = new PdfPCell(new Paragraph("Data a"));
			PdfPCell cell4 = new PdfPCell(new Paragraph("Spe"));
			PdfPCell cell5 = new PdfPCell(new Paragraph("I/S"));
			PdfPCell cell6 = new PdfPCell(new Paragraph("Cat"));
			PdfPCell cell7 = new PdfPCell(new Paragraph("Qua"));
			PdfPCell cell8 = new PdfPCell(new Paragraph("Pos"));
			PdfPCell cell9 = new PdfPCell(new Paragraph("Ris"));
			PdfPCell cell10 = new PdfPCell(new Paragraph("Fin"));
			PdfPCell cell11 = new PdfPCell(new Paragraph("Spa1"));
			PdfPCell cell12 = new PdfPCell(new Paragraph("Spa2"));
			
			cell1.setBorder(0);
			cell2.setBorder(0);
			cell3.setBorder(0);
			cell4.setBorder(0);
			cell5.setBorder(0);
			cell6.setBorder(0);
			cell7.setBorder(0);
			cell8.setBorder(0);
			cell9.setBorder(0);
			cell10.setBorder(0);
			cell11.setBorder(0);
			cell12.setBorder(0);
			
			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			table.addCell(cell5);
			table.addCell(cell6);
			table.addCell(cell7);
			table.addCell(cell8);
			table.addCell(cell9);
			table.addCell(cell10);
			table.addCell(cell11);
			table.addCell(cell12);
			
			for(CurriculumShooterInfo c : cs){
				
				PdfPCell cell1cs = new PdfPCell(new Paragraph(c.getMatchDesc()));
				PdfPCell cell2cs = new PdfPCell(new Paragraph(sdf.format(c.getMatchStartDate())));
				PdfPCell cell3cs = new PdfPCell(new Paragraph(sdf.format(c.getMatchEndDate())));
				PdfPCell cell4cs = new PdfPCell(new Paragraph(c.getSpec()));
				PdfPCell cell5cs = new PdfPCell(new Paragraph(c.getIndividual()));
				PdfPCell cell6cs = new PdfPCell(new Paragraph(c.getCategory()));
				PdfPCell cell7cs = new PdfPCell(new Paragraph(c.getQualification()));
				PdfPCell cell8cs = new PdfPCell(new Paragraph(String.valueOf(c.getPosition())));
				PdfPCell cell9cs = new PdfPCell(new Paragraph(String.valueOf(c.getResult())));
				PdfPCell cell10cs = new PdfPCell(new Paragraph(String.valueOf(c.getFinalTotal())));
				PdfPCell cell11cs = new PdfPCell(new Paragraph(String.valueOf(c.getShootOff1())));
				PdfPCell cell12cs = new PdfPCell(new Paragraph(String.valueOf(c.getShootOff2())));
				
				cell1cs.setBorder(0);
				cell2cs.setBorder(0);
				cell3cs.setBorder(0);
				cell4cs.setBorder(0);
				cell5cs.setBorder(0);
				cell6cs.setBorder(0);
				cell7cs.setBorder(0);
				cell8cs.setBorder(0);
				cell9cs.setBorder(0);
				cell10cs.setBorder(0);
				cell11cs.setBorder(0);
				cell12cs.setBorder(0);
				
				table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
				
				table.addCell(new Phrase(c.getMatchDesc(), f));
				table.addCell(new Phrase(sdf.format(c.getMatchStartDate()), f));
				table.addCell(new Phrase(sdf.format(c.getMatchEndDate()), f));
				table.addCell(new Phrase(c.getSpec(), f));
				table.addCell(new Phrase(c.getIndividual(), f));
				table.addCell(new Phrase(c.getCategory(), f));
				table.addCell(new Phrase(c.getQualification(), f));
				table.addCell(new Phrase(String.valueOf(c.getPosition()), f));
				table.addCell(new Phrase(String.valueOf(c.getResult()), f));
				table.addCell(new Phrase(String.valueOf(c.getFinalTotal()), f));
				table.addCell(new Phrase(0 == c.getShootOff1() ? "" : String.valueOf(c.getShootOff1()), f));
				table.addCell(new Phrase(0 == c.getShootOff2() ? "" : String.valueOf(c.getShootOff2()), f));
				
				
				/*table.addCell(cell1cs);
				table.addCell(cell2cs);
				table.addCell(cell3cs);
				table.addCell(cell4cs);
				table.addCell(cell5cs);
				table.addCell(cell6cs);
				table.addCell(cell7cs);
				table.addCell(cell8cs);
				table.addCell(cell9cs);
				table.addCell(cell10cs);
				table.addCell(cell11cs);
				table.addCell(cell12cs);*/
			}
			
			
			document.add(table);
			
			XMLWorkerHelper worker = XMLWorkerHelper.getInstance();	
			document.newPage();
			document.close();

			resp.setContentType("application/pdf");
			resp.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
			resp.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= CV Tiratore "+shooterName+".pdf;");
			OutputStream out = resp.getPortletOutputStream();
			baos.writeTo(out);
			out.flush();
			out.close();
		}
		catch (Exception e) {
			throw new PortletException(e);
		}
		
	}
	private static Log _log = LogFactoryUtil.getLog(GenerateShooterCV.class);
}