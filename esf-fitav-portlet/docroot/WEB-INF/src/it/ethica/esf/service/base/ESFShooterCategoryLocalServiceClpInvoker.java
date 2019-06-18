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

import it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFShooterCategoryLocalServiceClpInvoker {
	public ESFShooterCategoryLocalServiceClpInvoker() {
		_methodName0 = "addESFShooterCategory";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFShooterCategory"
			};

		_methodName1 = "createESFShooterCategory";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFShooterCategory";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFShooterCategory";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFShooterCategory"
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

		_methodName10 = "fetchESFShooterCategory";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFShooterCategoryByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFShooterCategoryByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFShooterCategory";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFShooterCategoryByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFShooterCategoryByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFShooterCategories";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFShooterCategoriesCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFShooterCategory";

		_methodParameterTypes19 = new String[] {
				"it.ethica.esf.model.ESFShooterCategory"
			};

<<<<<<< HEAD
		_methodName396 = "getBeanIdentifier";

		_methodParameterTypes396 = new String[] {  };

		_methodName397 = "setBeanIdentifier";

		_methodParameterTypes397 = new String[] { "java.lang.String" };

		_methodName402 = "getESFShooterCategories";

		_methodParameterTypes402 = new String[] {  };

		_methodName403 = "getESFShooterCategories";

		_methodParameterTypes403 = new String[] { "int", "int" };

		_methodName404 = "getESFShooterCategories";

		_methodParameterTypes404 = new String[] { "long" };

		_methodName405 = "findByMatchId";

		_methodParameterTypes405 = new String[] { "long" };

		_methodName406 = "addESFShooterCategory";

		_methodParameterTypes406 = new String[] {
=======
		_methodName390 = "getBeanIdentifier";

		_methodParameterTypes390 = new String[] {  };

		_methodName391 = "setBeanIdentifier";

		_methodParameterTypes391 = new String[] { "java.lang.String" };

		_methodName396 = "getESFShooterCategories";

		_methodParameterTypes396 = new String[] {  };

		_methodName397 = "getESFShooterCategories";

		_methodParameterTypes397 = new String[] { "int", "int" };

		_methodName398 = "getESFShooterCategories";

		_methodParameterTypes398 = new String[] { "long" };

		_methodName399 = "findByMatchId";

		_methodParameterTypes399 = new String[] { "long" };

		_methodName400 = "addESFShooterCategory";

		_methodParameterTypes400 = new String[] {
>>>>>>> origin/ID32
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName407 = "updateESFShooterCategory";

		_methodParameterTypes407 = new String[] {
=======
		_methodName401 = "updateESFShooterCategory";

		_methodParameterTypes401 = new String[] {
>>>>>>> origin/ID32
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName408 = "deleteESFShooterCategory";

		_methodParameterTypes408 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName409 = "findIDCategoryByName";

		_methodParameterTypes409 = new String[] { "java.lang.String" };

		_methodName410 = "findIDCategoryByCode";

		_methodParameterTypes410 = new String[] { "java.lang.String" };
=======
		_methodName402 = "deleteESFShooterCategory";

		_methodParameterTypes402 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName403 = "findIDCategoryByName";

		_methodParameterTypes403 = new String[] { "java.lang.String" };

		_methodName404 = "findIDCategoryByCode";

		_methodParameterTypes404 = new String[] { "java.lang.String" };
>>>>>>> origin/ID32
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.addESFShooterCategory((it.ethica.esf.model.ESFShooterCategory)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.createESFShooterCategory(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.deleteESFShooterCategory(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.deleteESFShooterCategory((it.ethica.esf.model.ESFShooterCategory)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.fetchESFShooterCategory(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.fetchESFShooterCategoryByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.fetchESFShooterCategoryByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.getESFShooterCategory(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.getESFShooterCategoryByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.getESFShooterCategoryByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.getESFShooterCategories(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.getESFShooterCategoriesCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.updateESFShooterCategory((it.ethica.esf.model.ESFShooterCategory)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
=======
		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
>>>>>>> origin/ID32
			ESFShooterCategoryLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.getESFShooterCategories();
		}

		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
=======
		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.getESFShooterCategories();
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFShooterCategoryLocalServiceUtil.getESFShooterCategories(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.getESFShooterCategories(((Long)arguments[0]).longValue());
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.findByMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
=======
		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.getESFShooterCategories(((Long)arguments[0]).longValue());
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.findByMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFShooterCategoryLocalServiceUtil.addESFShooterCategory(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

<<<<<<< HEAD
		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
=======
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFShooterCategoryLocalServiceUtil.updateESFShooterCategory(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

<<<<<<< HEAD
		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
=======
		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFShooterCategoryLocalServiceUtil.deleteESFShooterCategory(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.findIDCategoryByName((java.lang.String)arguments[0]);
		}

		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
=======
		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
			return ESFShooterCategoryLocalServiceUtil.findIDCategoryByName((java.lang.String)arguments[0]);
		}

		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFShooterCategoryLocalServiceUtil.findIDCategoryByCode((java.lang.String)arguments[0]);
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
<<<<<<< HEAD
=======
	private String _methodName390;
	private String[] _methodParameterTypes390;
	private String _methodName391;
	private String[] _methodParameterTypes391;
>>>>>>> origin/ID32
	private String _methodName396;
	private String[] _methodParameterTypes396;
	private String _methodName397;
	private String[] _methodParameterTypes397;
	private String _methodName402;
	private String[] _methodParameterTypes402;
	private String _methodName403;
	private String[] _methodParameterTypes403;
	private String _methodName404;
	private String[] _methodParameterTypes404;
<<<<<<< HEAD
	private String _methodName405;
	private String[] _methodParameterTypes405;
	private String _methodName406;
	private String[] _methodParameterTypes406;
	private String _methodName407;
	private String[] _methodParameterTypes407;
	private String _methodName408;
	private String[] _methodParameterTypes408;
	private String _methodName409;
	private String[] _methodParameterTypes409;
	private String _methodName410;
	private String[] _methodParameterTypes410;
=======
>>>>>>> origin/ID32
}