/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.ethica.esf.service.base;

import it.ethica.esf.service.ESFShooterCategoryESFTournamentLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFShooterCategoryESFTournamentLocalServiceClpInvoker {
	public ESFShooterCategoryESFTournamentLocalServiceClpInvoker() {
		_methodName0 = "addESFShooterCategoryESFTournament";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFShooterCategoryESFTournament"
			};

		_methodName1 = "createESFShooterCategoryESFTournament";

		_methodParameterTypes1 = new String[] {
				"it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK"
			};

		_methodName2 = "deleteESFShooterCategoryESFTournament";

		_methodParameterTypes2 = new String[] {
				"it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK"
			};

		_methodName3 = "deleteESFShooterCategoryESFTournament";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFShooterCategoryESFTournament"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchESFShooterCategoryESFTournament";

		_methodParameterTypes10 = new String[] {
				"it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK"
			};

		_methodName11 = "fetchESFShooterCategoryESFTournamentByUuidAndGroupId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "getESFShooterCategoryESFTournament";

		_methodParameterTypes12 = new String[] {
				"it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK"
			};

		_methodName13 = "getPersistedModel";

		_methodParameterTypes13 = new String[] { "java.io.Serializable" };

		_methodName14 = "getESFShooterCategoryESFTournamentByUuidAndGroupId";

		_methodParameterTypes14 = new String[] { "java.lang.String", "long" };

		_methodName15 = "getESFShooterCategoryESFTournaments";

		_methodParameterTypes15 = new String[] { "int", "int" };

		_methodName16 = "getESFShooterCategoryESFTournamentsCount";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "updateESFShooterCategoryESFTournament";

		_methodParameterTypes17 = new String[] {
				"it.ethica.esf.model.ESFShooterCategoryESFTournament"
			};

		_methodName446 = "getBeanIdentifier";

		_methodParameterTypes446 = new String[] {  };

		_methodName447 = "setBeanIdentifier";

		_methodParameterTypes447 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.addESFShooterCategoryESFTournament((it.ethica.esf.model.ESFShooterCategoryESFTournament)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.createESFShooterCategoryESFTournament((it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.deleteESFShooterCategoryESFTournament((it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.deleteESFShooterCategoryESFTournament((it.ethica.esf.model.ESFShooterCategoryESFTournament)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.fetchESFShooterCategoryESFTournament((it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.fetchESFShooterCategoryESFTournamentByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.getESFShooterCategoryESFTournament((it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.getESFShooterCategoryESFTournamentByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.getESFShooterCategoryESFTournaments(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.getESFShooterCategoryESFTournamentsCount();
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.updateESFShooterCategoryESFTournament((it.ethica.esf.model.ESFShooterCategoryESFTournament)arguments[0]);
		}

		if (_methodName446.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes446, parameterTypes)) {
			return ESFShooterCategoryESFTournamentLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName447.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes447, parameterTypes)) {
			ESFShooterCategoryESFTournamentLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName446;
	private String[] _methodParameterTypes446;
	private String _methodName447;
	private String[] _methodParameterTypes447;
}