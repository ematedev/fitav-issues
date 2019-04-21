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

package it.ethica.esf.renewal.service.base;

import it.ethica.esf.renewal.service.ESFRenewalCompanyLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFRenewalCompanyLocalServiceClpInvoker {
	public ESFRenewalCompanyLocalServiceClpInvoker() {
		_methodName0 = "addESFRenewalCompany";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.renewal.model.ESFRenewalCompany"
			};

		_methodName1 = "createESFRenewalCompany";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFRenewalCompany";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFRenewalCompany";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.renewal.model.ESFRenewalCompany"
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

		_methodName10 = "fetchESFRenewalCompany";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFRenewalCompany";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFRenewalCompanies";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFRenewalCompaniesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFRenewalCompany";

		_methodParameterTypes15 = new String[] {
				"it.ethica.esf.renewal.model.ESFRenewalCompany"
			};

		_methodName34 = "getBeanIdentifier";

		_methodParameterTypes34 = new String[] {  };

		_methodName35 = "setBeanIdentifier";

		_methodParameterTypes35 = new String[] { "java.lang.String" };

		_methodName40 = "addESFRenewalCompany";

		_methodParameterTypes40 = new String[] {
				"long", "long", "int", "int", "java.util.Date", "int", "int",
				"double", "java.lang.String", "java.lang.String",
				"java.util.Date", "double", "java.util.Date", "int",
				"java.lang.String", "boolean"
			};

		_methodName41 = "getAllYears";

		_methodParameterTypes41 = new String[] {  };

		_methodName42 = "deleteESFRenewalCompany";

		_methodParameterTypes42 = new String[] { "int" };

		_methodName43 = "getESFRenewalCompanyByStatus";

		_methodParameterTypes43 = new String[] { "int" };

		_methodName44 = "getESFRenewalCompanyByPaymentType";

		_methodParameterTypes44 = new String[] { "int" };

		_methodName45 = "getESFRenewalCompanyByYear";

		_methodParameterTypes45 = new String[] { "int" };

		_methodName46 = "getESFRenewalCompanyByP_S";

		_methodParameterTypes46 = new String[] { "int", "int" };

		_methodName47 = "getESFRenewalCompanyByP_Y";

		_methodParameterTypes47 = new String[] { "int", "int" };

		_methodName48 = "getESFRenewalCompanyByS_Y";

		_methodParameterTypes48 = new String[] { "int", "int" };

		_methodName49 = "getESFRenewalCompanyByE_Y";

		_methodParameterTypes49 = new String[] { "long", "int" };

		_methodName50 = "getESFRenewalCompanyByN_C_R_Y";

		_methodParameterTypes50 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "int"
			};

		_methodName51 = "updateESFRenewalCompany";

		_methodParameterTypes51 = new String[] {
				"long", "long", "long", "int", "int", "java.util.Date", "int",
				"int", "double", "java.lang.String", "java.lang.String",
				"java.util.Date", "double", "java.util.Date", "int",
				"java.lang.String", "boolean"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.addESFRenewalCompany((it.ethica.esf.renewal.model.ESFRenewalCompany)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.createESFRenewalCompany(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.deleteESFRenewalCompany(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.deleteESFRenewalCompany((it.ethica.esf.renewal.model.ESFRenewalCompany)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.fetchESFRenewalCompany(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompany(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompanies(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompaniesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.updateESFRenewalCompany((it.ethica.esf.renewal.model.ESFRenewalCompany)arguments[0]);
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			ESFRenewalCompanyLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.addESFRenewalCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(java.util.Date)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue(),
				((Double)arguments[7]).doubleValue(),
				(java.lang.String)arguments[8], (java.lang.String)arguments[9],
				(java.util.Date)arguments[10],
				((Double)arguments[11]).doubleValue(),
				(java.util.Date)arguments[12],
				((Integer)arguments[13]).intValue(),
				(java.lang.String)arguments[14],
				((Boolean)arguments[15]).booleanValue());
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.getAllYears();
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.deleteESFRenewalCompany(((Integer)arguments[0]).intValue());
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompanyByStatus(((Integer)arguments[0]).intValue());
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompanyByPaymentType(((Integer)arguments[0]).intValue());
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompanyByYear(((Integer)arguments[0]).intValue());
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompanyByP_S(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompanyByP_Y(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompanyByS_Y(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompanyByE_Y(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompanyByN_C_R_Y((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return ESFRenewalCompanyLocalServiceUtil.updateESFRenewalCompany(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				(java.util.Date)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue(),
				((Double)arguments[8]).doubleValue(),
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10], (java.util.Date)arguments[11],
				((Double)arguments[12]).doubleValue(),
				(java.util.Date)arguments[13],
				((Integer)arguments[14]).intValue(),
				(java.lang.String)arguments[15],
				((Boolean)arguments[16]).booleanValue());
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
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
}