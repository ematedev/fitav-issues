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

import it.ethica.esf.service.ESFTournamentLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFTournamentLocalServiceClpInvoker {
	public ESFTournamentLocalServiceClpInvoker() {
		_methodName0 = "addESFTournament";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFTournament"
			};

		_methodName1 = "createESFTournament";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFTournament";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFTournament";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFTournament"
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

		_methodName10 = "fetchESFTournament";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFTournamentByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFTournamentByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFTournament";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFTournamentByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFTournamentByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFTournaments";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFTournamentsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFTournament";

		_methodParameterTypes19 = new String[] {
				"it.ethica.esf.model.ESFTournament"
			};

		_methodName458 = "getBeanIdentifier";

		_methodParameterTypes458 = new String[] {  };

		_methodName459 = "setBeanIdentifier";

		_methodParameterTypes459 = new String[] { "java.lang.String" };

		_methodName464 = "findESFTournamentsByState";

		_methodParameterTypes464 = new String[] { "int" };

		_methodName465 = "findESFTournamentsByState";

		_methodParameterTypes465 = new String[] { "int", "int", "int" };

		_methodName466 = "findESFTournamentsByOrganizationId";

		_methodParameterTypes466 = new String[] {
				"long", "boolean", "int", "boolean"
			};

		_methodName467 = "findESFTournamentsByOrganizationId";

		_methodParameterTypes467 = new String[] {
				"long", "boolean", "int", "boolean", "int", "int"
			};

		_methodName468 = "addESFTournament";

		_methodParameterTypes468 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String", "int",
				"int", "boolean", "boolean", "boolean", "boolean", "boolean",
				"boolean", "long[][]", "long[][]", "java.util.Date",
				"java.util.Date", "java.util.List",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName469 = "deleteESFTournament";

		_methodParameterTypes469 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName470 = "updateESFTournament";

		_methodParameterTypes470 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"int", "int", "boolean", "boolean", "boolean", "boolean",
				"boolean", "boolean", "long[][]", "long[][]", "java.util.Date",
				"java.util.Date", "java.util.List",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.addESFTournament((it.ethica.esf.model.ESFTournament)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.createESFTournament(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.deleteESFTournament(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.deleteESFTournament((it.ethica.esf.model.ESFTournament)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.fetchESFTournament(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.fetchESFTournamentByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.fetchESFTournamentByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.getESFTournament(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.getESFTournamentByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.getESFTournamentByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.getESFTournaments(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.getESFTournamentsCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.updateESFTournament((it.ethica.esf.model.ESFTournament)arguments[0]);
		}

		if (_methodName458.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes458, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName459.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes459, parameterTypes)) {
			ESFTournamentLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName464.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes464, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.findESFTournamentsByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName465.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes465, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.findESFTournamentsByState(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName466.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes466, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.findESFTournamentsByOrganizationId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Boolean)arguments[3]).booleanValue());
		}

		if (_methodName467.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes467, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.findESFTournamentsByOrganizationId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Boolean)arguments[3]).booleanValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName468.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes468, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.addESFTournament(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue(),
				((Boolean)arguments[6]).booleanValue(),
				((Boolean)arguments[7]).booleanValue(),
				((Boolean)arguments[8]).booleanValue(),
				((Boolean)arguments[9]).booleanValue(),
				((Boolean)arguments[10]).booleanValue(),
				((Boolean)arguments[11]).booleanValue(), (long[])arguments[12],
				(long[])arguments[13], (java.util.Date)arguments[14],
				(java.util.Date)arguments[15],
				(java.util.List<it.ethica.esf.model.ESFTeam>)arguments[16],
				(it.ethica.esf.model.ESFEntityState)arguments[17],
				(com.liferay.portal.service.ServiceContext)arguments[18]);
		}

		if (_methodName469.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes469, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.deleteESFTournament(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName470.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes470, parameterTypes)) {
			return ESFTournamentLocalServiceUtil.updateESFTournament(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue(),
				((Boolean)arguments[7]).booleanValue(),
				((Boolean)arguments[8]).booleanValue(),
				((Boolean)arguments[9]).booleanValue(),
				((Boolean)arguments[10]).booleanValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Boolean)arguments[12]).booleanValue(), (long[])arguments[13],
				(long[])arguments[14], (java.util.Date)arguments[15],
				(java.util.Date)arguments[16],
				(java.util.List<it.ethica.esf.model.ESFTeam>)arguments[17],
				(it.ethica.esf.model.ESFEntityState)arguments[18],
				(com.liferay.portal.service.ServiceContext)arguments[19]);
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
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName458;
	private String[] _methodParameterTypes458;
	private String _methodName459;
	private String[] _methodParameterTypes459;
	private String _methodName464;
	private String[] _methodParameterTypes464;
	private String _methodName465;
	private String[] _methodParameterTypes465;
	private String _methodName466;
	private String[] _methodParameterTypes466;
	private String _methodName467;
	private String[] _methodParameterTypes467;
	private String _methodName468;
	private String[] _methodParameterTypes468;
	private String _methodName469;
	private String[] _methodParameterTypes469;
	private String _methodName470;
	private String[] _methodParameterTypes470;
}