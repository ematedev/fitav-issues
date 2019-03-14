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

package com.ethica.esf.service.base;

import com.ethica.esf.service.ESFArticle_ESFOrderLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFArticle_ESFOrderLocalServiceClpInvoker {
	public ESFArticle_ESFOrderLocalServiceClpInvoker() {
		_methodName0 = "addESFArticle_ESFOrder";

		_methodParameterTypes0 = new String[] {
				"com.ethica.esf.model.ESFArticle_ESFOrder"
			};

		_methodName1 = "createESFArticle_ESFOrder";

		_methodParameterTypes1 = new String[] {
				"com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK"
			};

		_methodName2 = "deleteESFArticle_ESFOrder";

		_methodParameterTypes2 = new String[] {
				"com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK"
			};

		_methodName3 = "deleteESFArticle_ESFOrder";

		_methodParameterTypes3 = new String[] {
				"com.ethica.esf.model.ESFArticle_ESFOrder"
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

		_methodName10 = "fetchESFArticle_ESFOrder";

		_methodParameterTypes10 = new String[] {
				"com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK"
			};

		_methodName11 = "getESFArticle_ESFOrder";

		_methodParameterTypes11 = new String[] {
				"com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFArticle_ESFOrders";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFArticle_ESFOrdersCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFArticle_ESFOrder";

		_methodParameterTypes15 = new String[] {
				"com.ethica.esf.model.ESFArticle_ESFOrder"
			};

		_methodName56 = "getBeanIdentifier";

		_methodParameterTypes56 = new String[] {  };

		_methodName57 = "setBeanIdentifier";

		_methodParameterTypes57 = new String[] { "java.lang.String" };

		_methodName62 = "addESFArticle_ESFOrder";

		_methodParameterTypes62 = new String[] {
				"long", "long", "long", "long", "long", "long", "long", "long",
				"long", "long", "long", "long", "double", "double", "double"
			};

		_methodName63 = "updateESFArticle_ESFOrder";

		_methodParameterTypes63 = new String[] {
				"long", "long", "long", "long", "long", "long", "long", "long",
				"long", "long", "long", "long", "double", "double", "double"
			};

		_methodName64 = "findByEsfOrderId";

		_methodParameterTypes64 = new String[] { "long" };

		_methodName65 = "getEsfArticleIdByEsfOrderId";

		_methodParameterTypes65 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.addESFArticle_ESFOrder((com.ethica.esf.model.ESFArticle_ESFOrder)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.createESFArticle_ESFOrder((com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.deleteESFArticle_ESFOrder((com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.deleteESFArticle_ESFOrder((com.ethica.esf.model.ESFArticle_ESFOrder)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.fetchESFArticle_ESFOrder((com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.getESFArticle_ESFOrder((com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.getESFArticle_ESFOrders(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.getESFArticle_ESFOrdersCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.updateESFArticle_ESFOrder((com.ethica.esf.model.ESFArticle_ESFOrder)arguments[0]);
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			ESFArticle_ESFOrderLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.addESFArticle_ESFOrder(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				((Long)arguments[7]).longValue(),
				((Long)arguments[8]).longValue(),
				((Long)arguments[9]).longValue(),
				((Long)arguments[10]).longValue(),
				((Long)arguments[11]).longValue(),
				((Double)arguments[12]).doubleValue(),
				((Double)arguments[13]).doubleValue(),
				((Double)arguments[14]).doubleValue());
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.updateESFArticle_ESFOrder(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				((Long)arguments[7]).longValue(),
				((Long)arguments[8]).longValue(),
				((Long)arguments[9]).longValue(),
				((Long)arguments[10]).longValue(),
				((Long)arguments[11]).longValue(),
				((Double)arguments[12]).doubleValue(),
				((Double)arguments[13]).doubleValue(),
				((Double)arguments[14]).doubleValue());
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.findByEsfOrderId(((Long)arguments[0]).longValue());
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return ESFArticle_ESFOrderLocalServiceUtil.getEsfArticleIdByEsfOrderId(((Long)arguments[0]).longValue());
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
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
}