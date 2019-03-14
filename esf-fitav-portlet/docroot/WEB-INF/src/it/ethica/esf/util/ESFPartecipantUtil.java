
package it.ethica.esf.util;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.model.Contact;

import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.service.ESFGunLocalServiceUtil;
import it.ethica.esf.service.ESFGunLocalService;
import it.ethica.esf.service.ESFPartecipantInfoLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;
import it.ethica.esf.model.ESFDocument;

import com.liferay.portal.service.ListTypeService;

import it.ethica.esf.service.ESFPhoneLocalServiceUtil;

import com.liferay.portal.model.Phone;

import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.service.persistence.ESFProvincePK;
import it.ethica.esf.service.ESFProvinceLocalServiceUtil;
import it.ethica.esf.model.ESFProvince;
import it.ethica.esf.service.persistence.ESFCityPK;
import it.ethica.esf.service.ESFCityLocalServiceUtil;
import it.ethica.esf.model.ESFCity;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Address;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.mysql.jdbc.Connection;

import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.util.ManageDate;
import it.ethica.esf.model.ESFUser;

public class ESFPartecipantUtil {

	
	public static void generatePasses(long esfPartecipantInfoId){
		
		System.out.println("----------------1----------");
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =
				(Connection) DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/lportal", "root", "password");
		
		
			System.out.println("----------------2----------");
			
			// Compile jrxml file.
	
			JasperReport jasperReport = JasperCompileManager.compileReport("/home/igor/Scrivania/report/LettereAutorizzazione.jrxml/");
			// Parameters for report
			
			System.out.println("----------------3----------");

			
/*!!!!!!!!!!!!!!!!!!!
 *
 * Attenzione codice cablato!
 *  Serve per fare le prove
 *
 *!!!!!!!!!!!!!!*/
			esfPartecipantInfoId = 590001;
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("P_MatchId", esfPartecipantInfoId);
			
			System.out.println("----------------4----------");
			
			JasperPrint jasperPrint =
				JasperFillManager.fillReport(jasperReport, parameters, conn);
			
			System.out.println("----------------4.1----------");
			// Make sure the output directory exists.
			File outDir = new File("/home/igor/Scrivania/risultati/");
			outDir.mkdirs();
			System.out.println("----------------4.2----------");
			JRPdfExporter exporter = new JRPdfExporter();
			System.out.println("----------------4.3----------");
			ExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
			
			System.out.println("----------------5----------");
			
			// ExporterInput
			 exporter.setExporterInput(exporterInput);
			// ExporterOutput
			OutputStreamExporterOutput exporterOutput =
				new SimpleOutputStreamExporterOutput(
					"/home/igor/Scrivania/risultati/ultimoReport.pdf");
			// Output
			
			System.out.println("----------------6----------");
			exporter.setExporterOutput(exporterOutput);
			
			SimplePdfExporterConfiguration configuration =
				new SimplePdfExporterConfiguration();
			exporter.setConfiguration(configuration);
			exporter.exportReport();
	
			System.out.println("----------------7----------");
		
		}catch(Exception e){
			e.getMessage();
		}
		
		try {
			conn.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	
	public static long generateESFPartecipantInfo(
		long esfUserId, long esfMatchId, boolean isPortalUser,
		ServiceContext serviceContext)
		throws InstantiationException, IllegalAccessException {

		long esfPartId = 0;

		try {
			ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
			User liferayUser =
				UserLocalServiceUtil.getUser(esfUser.getEsfUserId());

			long companyId = serviceContext.getCompanyId();
			long userId = serviceContext.getUserId();
			User user = UserLocalServiceUtil.getUser(userId);
			String userName = user.getFullName();
			long groupId = user.getGroupId();

			/* Retriving user postal address */

			ESFAddress esfUserPostalAddress = null;
			Contact userContact = liferayUser.getContact();

			List<Address> userAddresses =
				AddressLocalServiceUtil.getAddresses(
					liferayUser.getCompanyId(), ESFUser.class.getName(),
					esfUser.getEsfUserId());

			for (Address a : userAddresses) {
				ESFAddress esfAddressTemp =
					ESFAddressLocalServiceUtil.getESFAddress(a.getAddressId());
				if (Validator.isNotNull(esfAddressTemp.getType())) {
					if (esfAddressTemp.getType().equals(
						ESFKeys.ESFAddressType.POSTAL)) {
						esfUserPostalAddress =
							ESFAddressLocalServiceUtil.getESFAddress(a.getAddressId());
					}
				}
			}

			liferayUser.getAddresses();

			/*------------User general info----------*/

			String firstName = esfUser.getFirstName();
			String lastName = esfUser.getLastName();
			String placeOfBirth = esfUser.getBirthcity();
			Date dateOfBirth = esfUser.getBirthday();

			/*---------------User address info--------------*/
			/* In case user postal address is null */
			String residenceCity = "";
			String province = "";
			int zip = 0;
			String address = "";
			/* In case user postal address is NOT null */
			if (Validator.isNotNull(esfUserPostalAddress)) {
				if (esfUserPostalAddress.getEsfCityId() > 0) {
					/* ESFCity primary key creation */
					ESFCityPK esfCityPk = ESFCityPK.class.newInstance();

					if (Validator.isNotNull(esfUserPostalAddress.getEsfCityId())) {
						esfCityPk.setIdCity(esfUserPostalAddress.getEsfCityId());
					}
					if (Validator.isNotNull(esfUserPostalAddress.getEsfRegionId())) {
						esfCityPk.setIdRegion(esfUserPostalAddress.getEsfRegionId());
					}
					if (Validator.isNotNull(esfUserPostalAddress.getEsfCountryId())) {
						esfCityPk.setIdCountry(esfUserPostalAddress.getEsfCountryId());
					}
					if (Validator.isNotNull(esfUserPostalAddress.getEsfProvinceId())) {
						esfCityPk.setIdProvince(esfUserPostalAddress.getEsfProvinceId());
					}

					ESFCity city =
						ESFCityLocalServiceUtil.fetchESFCity(esfCityPk);

					if (Validator.isNotNull(city)) {
						residenceCity = city.getName();
					}

					if (Validator.isNotNull(esfUserPostalAddress.getEsfProvinceId()) &&
						Validator.isNotNull(city)) {
						ESFProvincePK esfProvincePK =
							ESFProvincePK.class.newInstance();

						if (Validator.isNotNull(city.getIdCountry())) {
							esfProvincePK.setIdCountry(city.getIdCountry());
						}
						if (Validator.isNotNull(city.getIdProvince())) {
							esfProvincePK.setIdProvince(city.getIdProvince());
						}
						if (Validator.isNotNull(city.getIdRegion())) {
							esfProvincePK.setIdRegion(city.getIdRegion());
						}
						ESFProvince esfProvince =
							ESFProvinceLocalServiceUtil.fetchESFProvince(esfProvincePK);

						if (Validator.isNotNull(esfProvince)) {
							province = esfProvince.getName();
						}
					}

					if (Validator.isNotNull(city) &&
						Validator.isNotNull(city.getZip())) {
						zip = (int) city.getZip();
					}

					if (Validator.isNotNull(esfUserPostalAddress.getStreet1())) {

						address = esfUserPostalAddress.getStreet1();
					}

				}
			}

			/* User contact info */

			String phoneNumber = "";

			List<Phone> userPhones =
				PhoneLocalServiceUtil.getPhones(
					liferayUser.getCompanyId(), ESFUser.class.getName(),
					esfUser.getEsfUserId());
				
			for (Phone p : userPhones) {
				
				ESFPhone esfUserPhone =
					ESFPhoneLocalServiceUtil.getESFPhone(p.getPhoneId());
				long phoneType = esfUserPhone.getListTypeId();
				
				if (Validator.isNotNull(phoneType)) {
					if (phoneType == ESFKeys.ESFPhoneListType.MOBILE) {
						phoneNumber = p.getNumber();
					}
				}
			}

			String email = "";

			if (Validator.isNotNull(liferayUser.getContact()) &&
				Validator.isNotNull(liferayUser.getContact().getEmailAddress())) {
				email = liferayUser.getContact().getEmailAddress();
			}

			String fiscalCode = "";
			// String maritialStatus = user.getM;
			if (Validator.isNotNull(esfUser.getFiscalCode())) {
				fiscalCode = esfUser.getFiscalCode();
			}

			/* User documents info */

			String releasedBy = "";
			Date passportReleaseDate = null;
			Date passportExpirationDate = null;
			String passport = "";
			String europeanCardNumber = "";
			Date europeanCardReleaseDate = null;
			Date europeanCardExpirationDate = null;
			String gunLicenceNumber = "";
			Date gunLicenceReleaseDate = null;
			Date gunLicenceExpirationDate = null;

			ESFDocument esfPassport = null;
			ESFDocument esfGunLicence = null;
			ESFDocument esfEuropeanCard = null;

			List<ESFDocument> esfDocuments = null;
			esfDocuments =
				ESFDocumentLocalServiceUtil.findByT_U(
					ESFKeys.ESFDocumentType.PASSPORT, esfUser.getEsfUserId());
			if (Validator.isNotNull(esfDocuments) && esfDocuments.size() > 0) {
				esfPassport = esfDocuments.get(0);
			}
			esfDocuments = null;

			esfDocuments =
				ESFDocumentLocalServiceUtil.findByT_U(
					ESFKeys.ESFDocumentType.GUNLICENCE, esfUser.getEsfUserId());

			if (Validator.isNotNull(esfDocuments) && esfDocuments.size() > 0) {
				esfGunLicence = esfDocuments.get(0);
			}

			esfDocuments = null;

			esfDocuments =
				ESFDocumentLocalServiceUtil.findByT_U(
					ESFKeys.ESFDocumentType.EUROPEANCARD,
					esfUser.getEsfUserId());

			if (Validator.isNotNull(esfDocuments) && esfDocuments.size() > 0) {
				esfEuropeanCard = esfDocuments.get(0);
			}

			if (Validator.isNotNull(esfPassport)) {
				passport = esfPassport.getCode();
				passportReleaseDate = esfPassport.getReleaseDate();
				releasedBy = esfPassport.getReleasedBy();
				passportExpirationDate = esfPassport.getExpirationDate();
				passportReleaseDate = esfPassport.getReleaseDate();
			}

			if (Validator.isNotNull(esfGunLicence)) {
				gunLicenceNumber = esfGunLicence.getCode();
				gunLicenceExpirationDate = esfGunLicence.getExpirationDate();
				gunLicenceReleaseDate = esfGunLicence.getReleaseDate();
			}

			if (Validator.isNotNull(esfEuropeanCard)) {
				europeanCardNumber = esfEuropeanCard.getCode();
				europeanCardExpirationDate =
					esfEuropeanCard.getExpirationDate();
				europeanCardReleaseDate = esfEuropeanCard.getReleaseDate();
			}

			/*-----------------------User gun info-----------------------------------------*/
			String firstGunType = "";
			String firstGunExtraCanes = "";
			String firstGunKind = "";
			double firstGunCaliber = 0;
			String firstGunCode = "";
			String secondGunType = "";
			String secondGunKind = "";
			double secondGunCaliber = 0;
			String secondGunCode = "";
			String secondGunExtraCanes = "";
			long firstGunTypeId = 0;
			long firstGunKindId = 0;
			long secondGunTypeId = 0;
			long secondGunKindId = 0;

			List<ESFGun> esfUserGuns =
				ESFGunLocalServiceUtil.getESFGunsByUserId(esfUser.getEsfUserId());
			List<ESFGun> userFavoriteGuns = new ArrayList<ESFGun>();

			for (ESFGun esfGun : esfUserGuns) {
				if (Validator.isNotNull(esfGun.getIsFavoriteGun()) &&
					esfGun.getIsFavoriteGun()) {
					userFavoriteGuns.add(esfGun);
				}
			}

			if (userFavoriteGuns.size() > 0) {

				ESFGun esfFirstGun = userFavoriteGuns.get(0);
				/*
				if (Validator.isNotNull(esfFirstGun.getCanesExtra())) {
					firstGunExtraCanes = esfFirstGun.getCanesExtra();
				} */
				firstGunCode = esfFirstGun.getCode();
				if (Validator.isNotNull(esfFirstGun.getEsfGunKindId())) {

					ESFGunKind esfGunKind =
						ESFGunKindLocalServiceUtil.getESFGunKind(esfFirstGun.getEsfGunKindId());

					if (Validator.isNotNull(esfGunKind)) {
						firstGunKindId = esfGunKind.getEsfGunKindId();

						ESFGunType esfGunType =
							ESFGunTypeLocalServiceUtil.fetchESFGunType(esfGunKind.getEsfGunTypeId());

						if (Validator.isNotNull(esfGunType)) {
							firstGunTypeId = esfGunType.getEsfGunTypeId();
							firstGunType = esfGunType.getName();
							firstGunKind = esfGunKind.getName();
						//	firstGunCaliber = esfGunKind.getCaliber();
						}
					}
				}
				if (userFavoriteGuns.size() >= 2) {
					ESFGun esfSecondGun = userFavoriteGuns.get(1);
					/*
					if (Validator.isNotNull(esfSecondGun.getCanesExtra())) {
						secondGunExtraCanes = esfSecondGun.getCanesExtra();
					} */
					secondGunCode = esfSecondGun.getCode();

					if (Validator.isNotNull(esfSecondGun.getEsfGunKindId())) {

						ESFGunKind esfGunKind =
							ESFGunKindLocalServiceUtil.getESFGunKind(esfSecondGun.getEsfGunKindId());

						if (Validator.isNotNull(esfGunKind)) {

							secondGunKindId = esfGunKind.getEsfGunKindId();

							ESFGunType esfGunType =
								ESFGunTypeLocalServiceUtil.fetchESFGunType(esfGunKind.getEsfGunTypeId());
							if (Validator.isNotNull(esfGunType)) {

								secondGunTypeId = esfGunType.getEsfGunTypeId();

								secondGunType = esfGunType.getName();
								secondGunKind = esfGunType.getName();
								//secondGunCaliber = esfGunKind.getCaliber();
							}
						}
					}
				}

			}

			if (/* esfUserGuns.size() == 1 || */esfUserGuns.size() >= 1 &&
				userFavoriteGuns.size() == 0) {
				ESFGun esfUserGun = esfUserGuns.get(0);
				/*
				if (Validator.isNotNull(esfUserGun.getCanesExtra())) {
					firstGunExtraCanes = esfUserGun.getCanesExtra();
				}*/
				firstGunCode = esfUserGun.getCode();
				if (Validator.isNotNull(esfUserGun.getEsfGunKindId())) {

					ESFGunKind esfGunKind =
						ESFGunKindLocalServiceUtil.getESFGunKind(esfUserGun.getEsfGunKindId());

					if (Validator.isNotNull(esfGunKind)) {

						firstGunKindId = esfGunKind.getEsfGunKindId();

						ESFGunType esfGunType =
							ESFGunTypeLocalServiceUtil.fetchESFGunType(esfGunKind.getEsfGunTypeId());

						if (Validator.isNotNull(esfGunType)) {

							firstGunTypeId = esfGunType.getEsfGunTypeId();

							firstGunType = esfGunType.getName();
							firstGunKind = esfGunKind.getName();

							//firstGunCaliber = esfGunKind.getCaliber();
						}
					}
				}
			}

			List<ESFGun> userNotFavoriteGuns = new ArrayList<ESFGun>();
			for (ESFGun e : esfUserGuns) {
				if (Validator.isNotNull(e.getIsFavoriteGun()) &&
					!e.getIsFavoriteGun()) {
					userNotFavoriteGuns.add(e);
				}
			}

			if (esfUserGuns.size() >= 2) {

				ESFGun esfUserGun = esfUserGuns.get(1);
				if (userFavoriteGuns.size() == 1 &&
					userNotFavoriteGuns.size() > 0) {
					esfUserGun = userNotFavoriteGuns.get(0);
				}
				/*
				if (Validator.isNotNull(esfUserGun.getCanesExtra())) {
					secondGunExtraCanes = esfUserGun.getCanesExtra();
				}*/
				secondGunCode = esfUserGun.getCode();

				if (Validator.isNotNull(esfUserGun.getEsfGunKindId())) {

					ESFGunKind esfGunKind =
						ESFGunKindLocalServiceUtil.getESFGunKind(esfUserGun.getEsfGunKindId());

					if (Validator.isNotNull(esfGunKind)) {

						secondGunKindId = esfGunKind.getEsfGunKindId();

						ESFGunType esfGunType =
							ESFGunTypeLocalServiceUtil.fetchESFGunType(esfGunKind.getEsfGunTypeId());
						if (Validator.isNotNull(esfGunType)) {

							secondGunTypeId = esfGunType.getEsfGunTypeId();

							secondGunType = esfGunType.getName();
							secondGunKind = esfGunType.getName();
						//	secondGunCaliber = esfGunKind.getCaliber();
						}
					}
				}
			}

			/* Get Armi */

			/*
			 * First Gun
			 */
			/*
			 * long esfGunKindIdOne = 0; long esfGunTypeIdOne =
			 * ParamUtil.getLong(request, "esfGunTypeIdOne");
			 */
			if (firstGunTypeId > 0 && Validator.isNotNull(firstGunTypeId)) {
				ESFGunType esfGunType =
					ESFGunTypeLocalServiceUtil.getESFGunType(firstGunTypeId);
				if (Validator.isNotNull(esfGunType) &&
					Validator.isNotNull(esfGunType.getName())) {
					firstGunType = esfGunType.getName();
				}

				if (firstGunKindId > 0 && Validator.isNotNull(firstGunKindId)) {
					ESFGunKind esfGunKind =
						ESFGunKindLocalServiceUtil.getESFGunKind(firstGunKindId);
					if (Validator.isNotNull(esfGunKind) &&
						Validator.isNotNull(esfGunKind.getName())) {
						firstGunKind = esfGunKind.getName();
					}
				}

			}
			/*
			 * Second Gun
			 */

			if (secondGunTypeId > 0 && Validator.isNotNull(secondGunTypeId)) {
				ESFGunType esfGunType =
					ESFGunTypeLocalServiceUtil.getESFGunType(secondGunTypeId);
				if (Validator.isNotNull(esfGunType) &&
					Validator.isNotNull(esfGunType.getName())) {
					secondGunType = esfGunType.getName();
				}

				if (secondGunKindId > 0 && Validator.isNotNull(secondGunKindId)) {
					ESFGunKind esfGunKind =
						ESFGunKindLocalServiceUtil.getESFGunKind(secondGunKindId);
					if (Validator.isNotNull(esfGunKind) &&
						Validator.isNotNull(esfGunKind.getName())) {
						secondGunKind = esfGunKind.getName();
					}
				}
			}

			/*-----------*/

			long protocol = 0;
			List<it.ethica.esf.model.ESFPartecipantInfo> e =
				ESFPartecipantInfoLocalServiceUtil.getESFPartecipantInfos(
					0,
					ESFPartecipantInfoLocalServiceUtil.getESFPartecipantInfosCount());

			if (Validator.isNotNull(e)) {
				long max = 0;
				for (it.ethica.esf.model.ESFPartecipantInfo p : e) {
					if (p.getProtocol() > max) {
						max = p.getProtocol();
					}
				}
				protocol = max + 1;
			}
			else {
				protocol = 1;
			}

			Date createDate = new Date();
			esfPartId =
				ESFPartecipantInfoLocalServiceUtil.addESFPartecipantInfoAndReturnId(
					groupId, companyId, userId, userName, createDate,
					isPortalUser, esfUserId, protocol, firstName, lastName,
					placeOfBirth, dateOfBirth, residenceCity, province, zip,
					address, phoneNumber, email, "", fiscalCode, passport,
					releasedBy, passportReleaseDate, passportExpirationDate,
					europeanCardNumber, europeanCardReleaseDate,
					europeanCardExpirationDate, gunLicenceNumber,
					gunLicenceReleaseDate, gunLicenceExpirationDate,
					firstGunType, firstGunKind, firstGunCode, firstGunCaliber,
					firstGunExtraCanes, secondGunType, secondGunKind,
					secondGunCode, secondGunCaliber, secondGunExtraCanes, "",
					"", "", 0, firstGunTypeId, firstGunKindId, secondGunTypeId,
					secondGunKindId);
		}

		catch (Exception e) {
			e.getMessage();
		}
		return esfPartId;
	}
}
