
package it.ethica.esf.migration.util;

import it.ethica.esf.NoSuchUserESFUserRoleException;
import it.ethica.esf.model.ESFCity;
import it.ethica.esf.model.ESFProvince;
import it.ethica.esf.service.ESFCityLocalServiceUtil;
import it.ethica.esf.service.ESFProvinceLocalServiceUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

public class ManageAddress {

	// private static Log _log = LogFactoryUtil.getLog(ManageAddress.class);

	public static String getRegionId(String regione) {

		if (Validator.isNull(regione)) {
			return null;
		}
		if (regione.equalsIgnoreCase("Abruzzo"))
			return "ABR";
		if (regione.equalsIgnoreCase("Basilicata"))
			return "BAS";
		if (regione.equalsIgnoreCase("Calabria"))
			return "CAL";
		if (regione.equalsIgnoreCase("Campania"))
			return "CAM";
		if (regione.equalsIgnoreCase("Lazio"))
			return "LAZ";
		if (regione.equalsIgnoreCase("Liguria"))
			return "LIG";
		if (regione.equalsIgnoreCase("Lombardia"))
			return "LOM";
		if (regione.equalsIgnoreCase("Marche"))
			return "MAR";
		if (regione.equalsIgnoreCase("Molise"))
			return "MOL";
		if (regione.equalsIgnoreCase("Piemonte"))
			return "PIE";
		if (regione.equalsIgnoreCase("Puglia"))
			return "PUG";
		if (regione.equalsIgnoreCase("Sardegna"))
			return "SAR";
		if (regione.equalsIgnoreCase("Sicilia"))
			return "SIC";
		if (regione.equalsIgnoreCase("Toscana"))
			return "TOS";
		if (regione.equalsIgnoreCase("Umbria"))
			return "UMB";
		if (regione.equalsIgnoreCase("Veneto"))
			return "VEN";
		regione = regione.toLowerCase();
		if (regione.contains("valle") || regione.contains("aosta"))
			return "AOS";
		if (regione.contains("emilia") || regione.contains("romagna"))
			return "EMR";
		if (regione.contains("friuli") || regione.contains("venezia") ||
			regione.contains("giulia"))
			return "FVG";
		if (regione.contains("trentino") || regione.contains("alto") ||
			regione.contains("adige"))
			return "TAA";

		return null;
	}

	public static String getRegionIdFromProvince(
		Connection connection, String id)
		throws SQLException {

		Statement stat = connection.createStatement();

		ResultSet res =
			stat.executeQuery("select idRegion from fitav.ESFProvince " +
				"where idProvince like '" + id + "'");

		// _log.debug("getRegionIdFromProvince= select idRegion from ESFProvince "
		// +
		// "where idProvince like '" + id + "'");
		while (res.next()) {
			// _log.debug("getRegionIdFromProvince= "+res.getString("idRegion"));
			return res.getString("idRegion");
		}
		return null;
	}

	public static String getProvinceId(String id)
		throws NoSuchUserESFUserRoleException, SystemException {

		List<ESFProvince> province =
			ESFProvinceLocalServiceUtil.findByProvinceId(id);
		if (Validator.isNull(province) || province.size() == 0)
			return null;
		return province.get(0).getIdProvince();
	}

	public static long getCityId(String name)
		throws SystemException {

		List<ESFCity> cities = ESFCityLocalServiceUtil.getESFCity(name);
		// _log.debug("getCityId= "+cities);
		if (Validator.isNull(cities) || cities.size() == 0)
			return 0;
		// _log.debug("getCityId= "+cities.size());
		// _log.debug("getCityId= "+cities.get(0).getIdCity());
		return cities.get(0).getIdCity();

	}

}
