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

import it.ethica.esf.service.ESFOrganizationUnitserviceLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFOrganizationUnitserviceLocalServiceClpInvoker {
	public ESFOrganizationUnitserviceLocalServiceClpInvoker() {
		_methodName0 = "addESFOrganizationUnitservice";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFOrganizationUnitservice"
			};

		_methodName1 = "createESFOrganizationUnitservice";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFOrganizationUnitservice";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFOrganizationUnitservice";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFOrganizationUnitservice"
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

		_methodName10 = "fetchESFOrganizationUnitservice";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFOrganizationUnitserviceByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFOrganizationUnitserviceByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFOrganizationUnitservice";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFOrganizationUnitserviceByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFOrganizationUnitserviceByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFOrganizationUnitservices";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFOrganizationUnitservicesCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFOrganizationUnitservice";

		_methodParameterTypes19 = new String[] {
				"it.ethica.esf.model.ESFOrganizationUnitservice"
			};

<<<<<<< HEAD
		_methodName384 = "getBeanIdentifier";

		_methodParameterTypes384 = new String[] {  };

		_methodName385 = "setBeanIdentifier";

		_methodParameterTypes385 = new String[] { "java.lang.String" };

		_methodName390 = "getAllESFOrganizationUnitservices";

		_methodParameterTypes390 = new String[] {  };

		_methodName391 = "getAllESFOrganizationUnitservices";

		_methodParameterTypes391 = new String[] { "int", "int" };

		_methodName392 = "getAllESFOrganizationUnitservices";

		_methodParameterTypes392 = new String[] { "long" };

		_methodName393 = "getAllESFOrganizationUnitservices";

		_methodParameterTypes393 = new String[] { "long", "int", "int" };

		_methodName394 = "countByGroupId";

		_methodParameterTypes394 = new String[] { "long" };

		_methodName395 = "findByESFOrganizationId";

		_methodParameterTypes395 = new String[] { "long", "int", "int" };

		_methodName396 = "findByESFOrganizationId";

		_methodParameterTypes396 = new String[] { "long" };

		_methodName397 = "findByESFUnitserviceId";

		_methodParameterTypes397 = new String[] { "long" };

		_methodName398 = "addESFOrganizationUnitservice";

		_methodParameterTypes398 = new String[] {
=======
		_methodName376 = "getBeanIdentifier";

		_methodParameterTypes376 = new String[] {  };

		_methodName377 = "setBeanIdentifier";

		_methodParameterTypes377 = new String[] { "java.lang.String" };

		_methodName382 = "getAllESFOrganizationUnitservices";

		_methodParameterTypes382 = new String[] {  };

		_methodName383 = "getAllESFOrganizationUnitservices";

		_methodParameterTypes383 = new String[] { "int", "int" };

		_methodName384 = "getAllESFOrganizationUnitservices";

		_methodParameterTypes384 = new String[] { "long" };

		_methodName385 = "getAllESFOrganizationUnitservices";

		_methodParameterTypes385 = new String[] { "long", "int", "int" };

		_methodName386 = "countByGroupId";

		_methodParameterTypes386 = new String[] { "long" };

		_methodName387 = "findByESFOrganizationId";

		_methodParameterTypes387 = new String[] { "long", "int", "int" };

		_methodName388 = "findByESFOrganizationId";

		_methodParameterTypes388 = new String[] { "long" };

		_methodName389 = "findByESFUnitserviceId";

		_methodParameterTypes389 = new String[] { "long" };

		_methodName390 = "addESFOrganizationUnitservice";

		_methodParameterTypes390 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "long", "long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName399 = "updateESFOrganizationUnitservice";

		_methodParameterTypes399 = new String[] {
=======
		_methodName391 = "updateESFOrganizationUnitservice";

		_methodParameterTypes391 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "long", "long", "long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName400 = "deleteESFOrganizationUnitservice";

		_methodParameterTypes400 = new String[] {
=======
		_methodName392 = "deleteESFOrganizationUnitservice";

		_methodParameterTypes392 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.addESFOrganizationUnitservice((it.ethica.esf.model.ESFOrganizationUnitservice)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.createESFOrganizationUnitservice(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.deleteESFOrganizationUnitservice(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.deleteESFOrganizationUnitservice((it.ethica.esf.model.ESFOrganizationUnitservice)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.fetchESFOrganizationUnitservice(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.fetchESFOrganizationUnitserviceByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.fetchESFOrganizationUnitserviceByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.getESFOrganizationUnitservice(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.getESFOrganizationUnitserviceByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.getESFOrganizationUnitserviceByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.getESFOrganizationUnitservices(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.getESFOrganizationUnitservicesCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.updateESFOrganizationUnitservice((it.ethica.esf.model.ESFOrganizationUnitservice)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName385.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes385, parameterTypes)) {
=======
		if (_methodName376.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes376, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName377.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes377, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			ESFOrganizationUnitserviceLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.getAllESFOrganizationUnitservices();
		}

		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
=======
		if (_methodName382.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes382, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.getAllESFOrganizationUnitservices();
		}

		if (_methodName383.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes383, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFOrganizationUnitserviceLocalServiceUtil.getAllESFOrganizationUnitservices(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.getAllESFOrganizationUnitservices(((Long)arguments[0]).longValue());
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
=======
		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.getAllESFOrganizationUnitservices(((Long)arguments[0]).longValue());
		}

		if (_methodName385.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes385, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFOrganizationUnitserviceLocalServiceUtil.getAllESFOrganizationUnitservices(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.countByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
=======
		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.countByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFOrganizationUnitserviceLocalServiceUtil.findByESFOrganizationId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.findByESFOrganizationId(((Long)arguments[0]).longValue());
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.findByESFUnitserviceId(((Long)arguments[0]).longValue());
		}

		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
=======
		if (_methodName388.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes388, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.findByESFOrganizationId(((Long)arguments[0]).longValue());
		}

		if (_methodName389.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes389, parameterTypes)) {
			return ESFOrganizationUnitserviceLocalServiceUtil.findByESFUnitserviceId(((Long)arguments[0]).longValue());
		}

		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFOrganizationUnitserviceLocalServiceUtil.addESFOrganizationUnitservice(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4],
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

<<<<<<< HEAD
		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
=======
		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFOrganizationUnitserviceLocalServiceUtil.updateESFOrganizationUnitservice(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5],
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

<<<<<<< HEAD
		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
=======
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFOrganizationUnitserviceLocalServiceUtil.deleteESFOrganizationUnitservice(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
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
	private String _methodName376;
	private String[] _methodParameterTypes376;
	private String _methodName377;
	private String[] _methodParameterTypes377;
	private String _methodName382;
	private String[] _methodParameterTypes382;
	private String _methodName383;
	private String[] _methodParameterTypes383;
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	private String _methodName384;
	private String[] _methodParameterTypes384;
	private String _methodName385;
	private String[] _methodParameterTypes385;
<<<<<<< HEAD
=======
	private String _methodName386;
	private String[] _methodParameterTypes386;
	private String _methodName387;
	private String[] _methodParameterTypes387;
	private String _methodName388;
	private String[] _methodParameterTypes388;
	private String _methodName389;
	private String[] _methodParameterTypes389;
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	private String _methodName390;
	private String[] _methodParameterTypes390;
	private String _methodName391;
	private String[] _methodParameterTypes391;
	private String _methodName392;
	private String[] _methodParameterTypes392;
<<<<<<< HEAD
	private String _methodName393;
	private String[] _methodParameterTypes393;
	private String _methodName394;
	private String[] _methodParameterTypes394;
	private String _methodName395;
	private String[] _methodParameterTypes395;
	private String _methodName396;
	private String[] _methodParameterTypes396;
	private String _methodName397;
	private String[] _methodParameterTypes397;
	private String _methodName398;
	private String[] _methodParameterTypes398;
	private String _methodName399;
	private String[] _methodParameterTypes399;
	private String _methodName400;
	private String[] _methodParameterTypes400;
=======
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
}