/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import it.ethica.esf.service.ESFFieldLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFFieldLocalServiceClpInvoker {
	public ESFFieldLocalServiceClpInvoker() {
		_methodName0 = "addESFField";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFField" };

		_methodName1 = "createESFField";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFField";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFField";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFField" };

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

		_methodName10 = "fetchESFField";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFFieldByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFFieldByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFField";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFFieldByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFFieldByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFFields";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFFieldsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFField";

		_methodParameterTypes19 = new String[] { "it.ethica.esf.model.ESFField" };

		_methodName304 = "getBeanIdentifier";

		_methodParameterTypes304 = new String[] {  };

		_methodName305 = "setBeanIdentifier";

		_methodParameterTypes305 = new String[] { "java.lang.String" };

		_methodName310 = "getESFFields";

		_methodParameterTypes310 = new String[] { "long" };

		_methodName311 = "getESFFields";

		_methodParameterTypes311 = new String[] { "long", "int", "int" };

		_methodName312 = "getEsfFieldByState";

		_methodParameterTypes312 = new String[] { "int" };

		_methodName313 = "getEsfFieldByState";

		_methodParameterTypes313 = new String[] { "int", "int", "int" };

		_methodName314 = "countByGroupId";

		_methodParameterTypes314 = new String[] { "long" };

		_methodName315 = "countByESFOrganization";

		_methodParameterTypes315 = new String[] { "long" };

		_methodName316 = "findByRealOwner";

		_methodParameterTypes316 = new String[] { "long", "long" };

		_methodName317 = "findByRealOwner";

		_methodParameterTypes317 = new String[] { "long", "long", "int", "int" };

		_methodName318 = "findByESFOrganization";

		_methodParameterTypes318 = new String[] { "long", "int" };

		_methodName319 = "findByESFOrganization";

		_methodParameterTypes319 = new String[] { "long" };

		_methodName320 = "findByESFOrganization";

		_methodParameterTypes320 = new String[] { "long", "int", "int" };

		_methodName321 = "findByESFOrganization";

		_methodParameterTypes321 = new String[] { "long", "int", "int", "int" };

		_methodName322 = "findESFFieldESFSportTypeByField";

		_methodParameterTypes322 = new String[] { "long" };

		_methodName323 = "findByESFSportTypeId";

		_methodParameterTypes323 = new String[] { "long" };

		_methodName324 = "addESFField";

		_methodParameterTypes324 = new String[] {
				"long", "java.lang.String", "long", "long", "long", "long[][]",
				"java.lang.String", "long", "boolean", "boolean", "boolean",
				"boolean", "boolean", "java.util.List",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName325 = "addESFField";

		_methodParameterTypes325 = new String[] {
				"long", "java.lang.String", "long", "long", "long[][]",
				"it.ethica.esf.model.ESFEntityState", "java.lang.String", "long",
				"boolean", "boolean", "boolean", "boolean", "boolean",
				"java.util.List", "com.liferay.portal.service.ServiceContext"
			};

		_methodName326 = "updateESFField";

		_methodParameterTypes326 = new String[] {
				"long", "long", "java.lang.String", "long", "long", "long[][]",
				"it.ethica.esf.model.ESFEntityState", "java.lang.String", "long",
				"boolean", "boolean", "boolean", "boolean", "boolean",
				"java.util.List", "com.liferay.portal.service.ServiceContext"
			};

		_methodName327 = "deleteESFField";

		_methodParameterTypes327 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName328 = "giveWayESFField";

		_methodParameterTypes328 = new String[] {
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName329 = "returnESFField";

		_methodParameterTypes329 = new String[] {
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFFieldLocalServiceUtil.addESFField((it.ethica.esf.model.ESFField)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFFieldLocalServiceUtil.createESFField(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFFieldLocalServiceUtil.deleteESFField(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFFieldLocalServiceUtil.deleteESFField((it.ethica.esf.model.ESFField)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFFieldLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFFieldLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFFieldLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFFieldLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFFieldLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFFieldLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFFieldLocalServiceUtil.fetchESFField(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFFieldLocalServiceUtil.fetchESFFieldByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFFieldLocalServiceUtil.fetchESFFieldByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFFieldLocalServiceUtil.getESFField(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFFieldLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFFieldLocalServiceUtil.getESFFieldByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFFieldLocalServiceUtil.getESFFieldByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFFieldLocalServiceUtil.getESFFields(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFFieldLocalServiceUtil.getESFFieldsCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFFieldLocalServiceUtil.updateESFField((it.ethica.esf.model.ESFField)arguments[0]);
		}

		if (_methodName304.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes304, parameterTypes)) {
			return ESFFieldLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName305.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes305, parameterTypes)) {
			ESFFieldLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName310.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes310, parameterTypes)) {
			return ESFFieldLocalServiceUtil.getESFFields(((Long)arguments[0]).longValue());
		}

		if (_methodName311.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes311, parameterTypes)) {
			return ESFFieldLocalServiceUtil.getESFFields(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName312.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes312, parameterTypes)) {
			return ESFFieldLocalServiceUtil.getEsfFieldByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName313.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes313, parameterTypes)) {
			return ESFFieldLocalServiceUtil.getEsfFieldByState(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName314.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes314, parameterTypes)) {
			return ESFFieldLocalServiceUtil.countByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName315.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes315, parameterTypes)) {
			return ESFFieldLocalServiceUtil.countByESFOrganization(((Long)arguments[0]).longValue());
		}

		if (_methodName316.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes316, parameterTypes)) {
			return ESFFieldLocalServiceUtil.findByRealOwner(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName317.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes317, parameterTypes)) {
			return ESFFieldLocalServiceUtil.findByRealOwner(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName318.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes318, parameterTypes)) {
			return ESFFieldLocalServiceUtil.findByESFOrganization(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName319.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes319, parameterTypes)) {
			return ESFFieldLocalServiceUtil.findByESFOrganization(((Long)arguments[0]).longValue());
		}

		if (_methodName320.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes320, parameterTypes)) {
			return ESFFieldLocalServiceUtil.findByESFOrganization(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName321.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes321, parameterTypes)) {
			return ESFFieldLocalServiceUtil.findByESFOrganization(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName322.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes322, parameterTypes)) {
			return ESFFieldLocalServiceUtil.findESFFieldESFSportTypeByField(((Long)arguments[0]).longValue());
		}

		if (_methodName323.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes323, parameterTypes)) {
			return ESFFieldLocalServiceUtil.findByESFSportTypeId(((Long)arguments[0]).longValue());
		}

		if (_methodName324.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes324, parameterTypes)) {
			return ESFFieldLocalServiceUtil.addESFField(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(), (long[])arguments[5],
				(java.lang.String)arguments[6],
				((Long)arguments[7]).longValue(),
				((Boolean)arguments[8]).booleanValue(),
				((Boolean)arguments[9]).booleanValue(),
				((Boolean)arguments[10]).booleanValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Boolean)arguments[12]).booleanValue(),
				(java.util.List<it.ethica.esf.model.ESFFieldESFElectronic>)arguments[13],
				(com.liferay.portal.service.ServiceContext)arguments[14]);
		}

		if (_methodName325.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes325, parameterTypes)) {
			return ESFFieldLocalServiceUtil.addESFField(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(), (long[])arguments[4],
				(it.ethica.esf.model.ESFEntityState)arguments[5],
				(java.lang.String)arguments[6],
				((Long)arguments[7]).longValue(),
				((Boolean)arguments[8]).booleanValue(),
				((Boolean)arguments[9]).booleanValue(),
				((Boolean)arguments[10]).booleanValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Boolean)arguments[12]).booleanValue(),
				(java.util.List<it.ethica.esf.model.ESFFieldESFElectronic>)arguments[13],
				(com.liferay.portal.service.ServiceContext)arguments[14]);
		}

		if (_methodName326.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes326, parameterTypes)) {
			return ESFFieldLocalServiceUtil.updateESFField(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(), (long[])arguments[5],
				(it.ethica.esf.model.ESFEntityState)arguments[6],
				(java.lang.String)arguments[7],
				((Long)arguments[8]).longValue(),
				((Boolean)arguments[9]).booleanValue(),
				((Boolean)arguments[10]).booleanValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Boolean)arguments[12]).booleanValue(),
				((Boolean)arguments[13]).booleanValue(),
				(java.util.List<it.ethica.esf.model.ESFFieldESFElectronic>)arguments[14],
				(com.liferay.portal.service.ServiceContext)arguments[15]);
		}

		if (_methodName327.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes327, parameterTypes)) {
			return ESFFieldLocalServiceUtil.deleteESFField(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName328.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes328, parameterTypes)) {
			return ESFFieldLocalServiceUtil.giveWayESFField(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName329.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes329, parameterTypes)) {
			return ESFFieldLocalServiceUtil.returnESFField(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
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
	private String _methodName304;
	private String[] _methodParameterTypes304;
	private String _methodName305;
	private String[] _methodParameterTypes305;
	private String _methodName310;
	private String[] _methodParameterTypes310;
	private String _methodName311;
	private String[] _methodParameterTypes311;
	private String _methodName312;
	private String[] _methodParameterTypes312;
	private String _methodName313;
	private String[] _methodParameterTypes313;
	private String _methodName314;
	private String[] _methodParameterTypes314;
	private String _methodName315;
	private String[] _methodParameterTypes315;
	private String _methodName316;
	private String[] _methodParameterTypes316;
	private String _methodName317;
	private String[] _methodParameterTypes317;
	private String _methodName318;
	private String[] _methodParameterTypes318;
	private String _methodName319;
	private String[] _methodParameterTypes319;
	private String _methodName320;
	private String[] _methodParameterTypes320;
	private String _methodName321;
	private String[] _methodParameterTypes321;
	private String _methodName322;
	private String[] _methodParameterTypes322;
	private String _methodName323;
	private String[] _methodParameterTypes323;
	private String _methodName324;
	private String[] _methodParameterTypes324;
	private String _methodName325;
	private String[] _methodParameterTypes325;
	private String _methodName326;
	private String[] _methodParameterTypes326;
	private String _methodName327;
	private String[] _methodParameterTypes327;
	private String _methodName328;
	private String[] _methodParameterTypes328;
	private String _methodName329;
	private String[] _methodParameterTypes329;
}