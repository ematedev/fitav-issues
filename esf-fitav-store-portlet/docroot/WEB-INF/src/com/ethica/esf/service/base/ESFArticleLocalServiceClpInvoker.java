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

import com.ethica.esf.service.ESFArticleLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFArticleLocalServiceClpInvoker {
	public ESFArticleLocalServiceClpInvoker() {
		_methodName0 = "addESFArticle";

		_methodParameterTypes0 = new String[] { "com.ethica.esf.model.ESFArticle" };

		_methodName1 = "createESFArticle";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFArticle";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFArticle";

		_methodParameterTypes3 = new String[] { "com.ethica.esf.model.ESFArticle" };

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

		_methodName10 = "fetchESFArticle";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFArticle";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFArticles";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFArticlesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFArticle";

		_methodParameterTypes15 = new String[] { "com.ethica.esf.model.ESFArticle" };

		_methodName48 = "getBeanIdentifier";

		_methodParameterTypes48 = new String[] {  };

		_methodName49 = "setBeanIdentifier";

		_methodParameterTypes49 = new String[] { "java.lang.String" };

		_methodName54 = "addESFArticle";

		_methodParameterTypes54 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "long", "long", "long", "long", "long", "long", "long",
				"long", "double", "double", "double", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName55 = "checkCode";

		_methodParameterTypes55 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName56 = "decrementESFArticleQ";

		_methodParameterTypes56 = new String[] {
				"long", "long", "long", "long", "long", "long", "long", "long",
				"long", "long"
			};

		_methodName57 = "getDescriptionType";

		_methodParameterTypes57 = new String[] { "long" };

		_methodName58 = "getElements";

		_methodParameterTypes58 = new String[] { "com.ethica.esf.model.ESFArticle" };

		_methodName59 = "getESFArticleByArticleTypeId";

		_methodParameterTypes59 = new String[] { "long" };

		_methodName60 = "getESFArticleByLikeC_N_T";

		_methodParameterTypes60 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName61 = "getESFArticleByLikeC_N_T";

		_methodParameterTypes61 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};

		_methodName62 = "getESFArticles";

		_methodParameterTypes62 = new String[] {  };

		_methodName63 = "updateESFArticle";

		_methodParameterTypes63 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long", "long", "long", "long",
				"long", "long", "long", "long", "double", "double", "double",
				"long", "com.liferay.portal.service.ServiceContext", "boolean"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFArticleLocalServiceUtil.addESFArticle((com.ethica.esf.model.ESFArticle)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFArticleLocalServiceUtil.createESFArticle(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFArticleLocalServiceUtil.deleteESFArticle(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFArticleLocalServiceUtil.deleteESFArticle((com.ethica.esf.model.ESFArticle)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFArticleLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFArticleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFArticleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFArticleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFArticleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFArticleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFArticleLocalServiceUtil.fetchESFArticle(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFArticleLocalServiceUtil.getESFArticle(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFArticleLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFArticleLocalServiceUtil.getESFArticles(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFArticleLocalServiceUtil.getESFArticlesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFArticleLocalServiceUtil.updateESFArticle((com.ethica.esf.model.ESFArticle)arguments[0]);
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return ESFArticleLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			ESFArticleLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return ESFArticleLocalServiceUtil.addESFArticle((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
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
				((Double)arguments[14]).doubleValue(),
				((Long)arguments[15]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[16]);
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return ESFArticleLocalServiceUtil.checkCode((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return ESFArticleLocalServiceUtil.decrementESFArticleQ(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				((Long)arguments[7]).longValue(),
				((Long)arguments[8]).longValue(),
				((Long)arguments[9]).longValue());
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return ESFArticleLocalServiceUtil.getDescriptionType(((Long)arguments[0]).longValue());
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return ESFArticleLocalServiceUtil.getElements((com.ethica.esf.model.ESFArticle)arguments[0]);
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return ESFArticleLocalServiceUtil.getESFArticleByArticleTypeId(((Long)arguments[0]).longValue());
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return ESFArticleLocalServiceUtil.getESFArticleByLikeC_N_T((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return ESFArticleLocalServiceUtil.getESFArticleByLikeC_N_T((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return ESFArticleLocalServiceUtil.getESFArticles();
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return ESFArticleLocalServiceUtil.updateESFArticle(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				((Long)arguments[7]).longValue(),
				((Long)arguments[8]).longValue(),
				((Long)arguments[9]).longValue(),
				((Long)arguments[10]).longValue(),
				((Long)arguments[11]).longValue(),
				((Long)arguments[12]).longValue(),
				((Double)arguments[13]).doubleValue(),
				((Double)arguments[14]).doubleValue(),
				((Double)arguments[15]).doubleValue(),
				((Long)arguments[16]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[17],
				((Boolean)arguments[18]).booleanValue());
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
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
}