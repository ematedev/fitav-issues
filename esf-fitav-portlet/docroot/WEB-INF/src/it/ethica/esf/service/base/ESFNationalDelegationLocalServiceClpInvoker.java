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

import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFNationalDelegationLocalServiceClpInvoker {
	public ESFNationalDelegationLocalServiceClpInvoker() {
		_methodName0 = "addESFNationalDelegation";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFNationalDelegation"
			};

		_methodName1 = "createESFNationalDelegation";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFNationalDelegation";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFNationalDelegation";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFNationalDelegation"
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

		_methodName10 = "fetchESFNationalDelegation";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFNationalDelegation";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFNationalDelegations";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFNationalDelegationsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFNationalDelegation";

		_methodParameterTypes15 = new String[] {
				"it.ethica.esf.model.ESFNationalDelegation"
			};

		_methodName420 = "getBeanIdentifier";

		_methodParameterTypes420 = new String[] {  };

		_methodName421 = "setBeanIdentifier";

		_methodParameterTypes421 = new String[] { "java.lang.String" };

		_methodName426 = "getESFNationalDelegationByMatchId_PartecipantTypeId";

		_methodParameterTypes426 = new String[] { "long", "long" };

		_methodName427 = "getESFNationalDelegationByMatchId_PartecipantTypeId_sportTypeId";

		_methodParameterTypes427 = new String[] { "long", "long", "long" };

		_methodName428 = "getMatchId_SportTypeId_QualificationId";

		_methodParameterTypes428 = new String[] { "long", "long", "long" };

		_methodName429 = "getMatchId_UserId_SportTypeId_QualificationId";

		_methodParameterTypes429 = new String[] { "long", "long", "long", "long" };

		_methodName430 = "getESFNationalDelegationByESFUserId_ESFMatchId";

		_methodParameterTypes430 = new String[] { "long", "long" };

		_methodName431 = "getESFNationalDelegationByESFMatchId";

		_methodParameterTypes431 = new String[] { "long" };

		_methodName432 = "getPartecipantType_EsfUserId";

		_methodParameterTypes432 = new String[] { "long" };

		_methodName433 = "findByPartecipantType_EsfUserId";

		_methodParameterTypes433 = new String[] { "long", "long", "int", "int" };

		_methodName434 = "countPartecipantType_EsfUserId";

		_methodParameterTypes434 = new String[] { "long", "long" };

		_methodName435 = "getESFNationalDelegationByESFMatchIdNotShooter";

		_methodParameterTypes435 = new String[] { "long" };

		_methodName436 = "deleteESFNationalDelegation";

		_methodParameterTypes436 = new String[] { "long", "long" };

		_methodName437 = "changeCard";

		_methodParameterTypes437 = new String[] {
				"javax.portlet.ActionRequest", "javax.portlet.ActionResponse"
			};

		_methodName438 = "findConvocation";

		_methodParameterTypes438 = new String[] { "long", "long", "int" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.addESFNationalDelegation((it.ethica.esf.model.ESFNationalDelegation)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.createESFNationalDelegation(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.deleteESFNationalDelegation(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.deleteESFNationalDelegation((it.ethica.esf.model.ESFNationalDelegation)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.fetchESFNationalDelegation(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.getESFNationalDelegation(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.getESFNationalDelegations(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.updateESFNationalDelegation((it.ethica.esf.model.ESFNationalDelegation)arguments[0]);
		}

		if (_methodName420.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes420, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName421.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes421, parameterTypes)) {
			ESFNationalDelegationLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName426.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes426, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName427.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes427, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId_sportTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName428.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes428, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.getMatchId_SportTypeId_QualificationId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName429.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes429, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.getMatchId_UserId_SportTypeId_QualificationId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName430.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes430, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFUserId_ESFMatchId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName431.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes431, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName432.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes432, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.getPartecipantType_EsfUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName433.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes433, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.findByPartecipantType_EsfUserId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName434.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes434, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.countPartecipantType_EsfUserId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName435.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes435, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchIdNotShooter(((Long)arguments[0]).longValue());
		}

		if (_methodName436.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes436, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.deleteESFNationalDelegation(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName437.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes437, parameterTypes)) {
			ESFNationalDelegationLocalServiceUtil.changeCard((javax.portlet.ActionRequest)arguments[0],
				(javax.portlet.ActionResponse)arguments[1]);

			return null;
		}

		if (_methodName438.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes438, parameterTypes)) {
			return ESFNationalDelegationLocalServiceUtil.findConvocation(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
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
	private String _methodName420;
	private String[] _methodParameterTypes420;
	private String _methodName421;
	private String[] _methodParameterTypes421;
	private String _methodName426;
	private String[] _methodParameterTypes426;
	private String _methodName427;
	private String[] _methodParameterTypes427;
	private String _methodName428;
	private String[] _methodParameterTypes428;
	private String _methodName429;
	private String[] _methodParameterTypes429;
	private String _methodName430;
	private String[] _methodParameterTypes430;
	private String _methodName431;
	private String[] _methodParameterTypes431;
	private String _methodName432;
	private String[] _methodParameterTypes432;
	private String _methodName433;
	private String[] _methodParameterTypes433;
	private String _methodName434;
	private String[] _methodParameterTypes434;
	private String _methodName435;
	private String[] _methodParameterTypes435;
	private String _methodName436;
	private String[] _methodParameterTypes436;
	private String _methodName437;
	private String[] _methodParameterTypes437;
	private String _methodName438;
	private String[] _methodParameterTypes438;
}