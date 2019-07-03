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

import it.ethica.esf.service.ESFGunLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFGunLocalServiceClpInvoker {
	public ESFGunLocalServiceClpInvoker() {
		_methodName0 = "addESFGun";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFGun" };

		_methodName1 = "createESFGun";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFGun";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFGun";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFGun" };

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

		_methodName10 = "fetchESFGun";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFGunByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFGunByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFGun";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFGunByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFGunByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFGuns";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFGunsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFGun";

		_methodParameterTypes19 = new String[] { "it.ethica.esf.model.ESFGun" };

		_methodName458 = "getBeanIdentifier";

		_methodParameterTypes458 = new String[] {  };

		_methodName459 = "setBeanIdentifier";

		_methodParameterTypes459 = new String[] { "java.lang.String" };

		_methodName464 = "getESFGunByLikeC_K";

		_methodParameterTypes464 = new String[] { "java.lang.String", "long" };

		_methodName465 = "getESFGunByLikeC_K";

		_methodParameterTypes465 = new String[] {
				"java.lang.String", "long", "int", "int"
			};

		_methodName466 = "getESFGunByLikeC_K_U";

		_methodParameterTypes466 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName467 = "getESFGunByLikeM_C_K_U";

		_methodParameterTypes467 = new String[] {
				"long", "java.lang.String", "long", "long", "int", "int"
			};

		_methodName468 = "countESFGunByLikeM_C_K_U";

		_methodParameterTypes468 = new String[] {
				"long", "java.lang.String", "long", "long"
			};

		_methodName469 = "getESFGunByLikeM_K";

		_methodParameterTypes469 = new String[] { "long", "long", "int", "int" };

		_methodName470 = "countESFGunByLikeM_K";

		_methodParameterTypes470 = new String[] { "long", "long" };

		_methodName471 = "getESFGunsByUserId";

		_methodParameterTypes471 = new String[] { "long" };

		_methodName472 = "getESFGunsByUserId";

		_methodParameterTypes472 = new String[] { "long", "int", "int" };

		_methodName473 = "getESFGuns";

		_methodParameterTypes473 = new String[] {  };

		_methodName474 = "getESFGuns";

		_methodParameterTypes474 = new String[] { "int", "int" };

		_methodName475 = "getESFGunsByESFGunKind";

		_methodParameterTypes475 = new String[] { "long" };

		_methodName476 = "getESFGunsByESFGunKindCount";

		_methodParameterTypes476 = new String[] { "long" };

		_methodName477 = "getESFGunByLikeC_K_U";

		_methodParameterTypes477 = new String[] {
				"java.lang.String", "long", "long", "int", "int"
			};

		_methodName478 = "getESFGunByLikeC_K_M_U";

		_methodParameterTypes478 = new String[] {
				"java.lang.String", "long", "java.lang.String", "long"
			};

		_methodName479 = "addESFGun";

		_methodParameterTypes479 = new String[] {
				"long", "java.lang.String", "long", "long", "long",
				"java.lang.String", "long", "int", "java.lang.String", "boolean",
				"java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName480 = "updateESFGun";

		_methodParameterTypes480 = new String[] {
				"long", "long", "java.lang.String", "long", "long", "long",
				"java.lang.String", "long", "int", "java.lang.String", "boolean",
				"java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName481 = "deleteESFGun";

		_methodParameterTypes481 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName482 = "getFullName";

		_methodParameterTypes482 = new String[] { "it.ethica.esf.model.ESFGun" };

		_methodName485 = "checkCode";

		_methodParameterTypes485 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName486 = "getNameMod";

		_methodParameterTypes486 = new String[] { "it.ethica.esf.model.ESFGun" };

		_methodName487 = "getNameM";

		_methodParameterTypes487 = new String[] { "it.ethica.esf.model.ESFGun" };

		_methodName488 = "getNameT";

		_methodParameterTypes488 = new String[] { "it.ethica.esf.model.ESFGun" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFGunLocalServiceUtil.addESFGun((it.ethica.esf.model.ESFGun)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFGunLocalServiceUtil.createESFGun(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFGunLocalServiceUtil.deleteESFGun(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFGunLocalServiceUtil.deleteESFGun((it.ethica.esf.model.ESFGun)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFGunLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFGunLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFGunLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFGunLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFGunLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFGunLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFGunLocalServiceUtil.fetchESFGun(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFGunLocalServiceUtil.fetchESFGunByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFGunLocalServiceUtil.fetchESFGunByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGun(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFGunLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGunByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGunByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGuns(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGunsCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFGunLocalServiceUtil.updateESFGun((it.ethica.esf.model.ESFGun)arguments[0]);
		}

		if (_methodName458.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes458, parameterTypes)) {
			return ESFGunLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName459.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes459, parameterTypes)) {
			ESFGunLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName464.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes464, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGunByLikeC_K((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName465.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes465, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGunByLikeC_K((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName466.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes466, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGunByLikeC_K_U((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName467.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes467, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGunByLikeM_C_K_U(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName468.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes468, parameterTypes)) {
			return ESFGunLocalServiceUtil.countESFGunByLikeM_C_K_U(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName469.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes469, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGunByLikeM_K(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName470.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes470, parameterTypes)) {
			return ESFGunLocalServiceUtil.countESFGunByLikeM_K(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName471.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes471, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGunsByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName472.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes472, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGunsByUserId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName473.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes473, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGuns();
		}

		if (_methodName474.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes474, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGuns(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName475.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes475, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGunsByESFGunKind(((Long)arguments[0]).longValue());
		}

		if (_methodName476.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes476, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGunsByESFGunKindCount(((Long)arguments[0]).longValue());
		}

		if (_methodName477.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes477, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGunByLikeC_K_U((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName478.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes478, parameterTypes)) {
			return ESFGunLocalServiceUtil.getESFGunByLikeC_K_M_U((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], ((Long)arguments[3]).longValue());
		}

		if (_methodName479.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes479, parameterTypes)) {
			return ESFGunLocalServiceUtil.addESFGun(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5],
				((Long)arguments[6]).longValue(),
				((Integer)arguments[7]).intValue(),
				(java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(com.liferay.portal.service.ServiceContext)arguments[12]);
		}

		if (_methodName480.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes480, parameterTypes)) {
			return ESFGunLocalServiceUtil.updateESFGun(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6],
				((Long)arguments[7]).longValue(),
				((Integer)arguments[8]).intValue(),
				(java.lang.String)arguments[9],
				((Boolean)arguments[10]).booleanValue(),
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				(com.liferay.portal.service.ServiceContext)arguments[13]);
		}

		if (_methodName481.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes481, parameterTypes)) {
			return ESFGunLocalServiceUtil.deleteESFGun(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName482.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes482, parameterTypes)) {
			return ESFGunLocalServiceUtil.getFullName((it.ethica.esf.model.ESFGun)arguments[0]);
		}

		if (_methodName485.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes485, parameterTypes)) {
			return ESFGunLocalServiceUtil.checkCode((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName486.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes486, parameterTypes)) {
			return ESFGunLocalServiceUtil.getNameMod((it.ethica.esf.model.ESFGun)arguments[0]);
		}

		if (_methodName487.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes487, parameterTypes)) {
			return ESFGunLocalServiceUtil.getNameM((it.ethica.esf.model.ESFGun)arguments[0]);
		}

		if (_methodName488.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes488, parameterTypes)) {
			return ESFGunLocalServiceUtil.getNameT((it.ethica.esf.model.ESFGun)arguments[0]);
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
	private String _methodName471;
	private String[] _methodParameterTypes471;
	private String _methodName472;
	private String[] _methodParameterTypes472;
	private String _methodName473;
	private String[] _methodParameterTypes473;
	private String _methodName474;
	private String[] _methodParameterTypes474;
	private String _methodName475;
	private String[] _methodParameterTypes475;
	private String _methodName476;
	private String[] _methodParameterTypes476;
	private String _methodName477;
	private String[] _methodParameterTypes477;
	private String _methodName478;
	private String[] _methodParameterTypes478;
	private String _methodName479;
	private String[] _methodParameterTypes479;
	private String _methodName480;
	private String[] _methodParameterTypes480;
	private String _methodName481;
	private String[] _methodParameterTypes481;
	private String _methodName482;
	private String[] _methodParameterTypes482;
	private String _methodName485;
	private String[] _methodParameterTypes485;
	private String _methodName486;
	private String[] _methodParameterTypes486;
	private String _methodName487;
	private String[] _methodParameterTypes487;
	private String _methodName488;
	private String[] _methodParameterTypes488;
}