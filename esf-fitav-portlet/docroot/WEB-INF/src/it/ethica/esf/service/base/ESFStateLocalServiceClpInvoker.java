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

import it.ethica.esf.service.ESFStateLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFStateLocalServiceClpInvoker {
	public ESFStateLocalServiceClpInvoker() {
		_methodName0 = "addESFState";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFState" };

		_methodName1 = "createESFState";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFState";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFState";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFState" };

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

		_methodName10 = "fetchESFState";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFState";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFStates";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFStatesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFState";

		_methodParameterTypes15 = new String[] { "it.ethica.esf.model.ESFState" };

<<<<<<< HEAD
		_methodName386 = "getBeanIdentifier";

		_methodParameterTypes386 = new String[] {  };

		_methodName387 = "setBeanIdentifier";

		_methodParameterTypes387 = new String[] { "java.lang.String" };

		_methodName392 = "findESFStates";

		_methodParameterTypes392 = new String[] { "java.lang.String" };

		_methodName393 = "findESFStateById";

		_methodParameterTypes393 = new String[] { "long" };

		_methodName394 = "findAllESFStates";

		_methodParameterTypes394 = new String[] {  };

		_methodName395 = "getESFStateAssEntitybyId_CN";

		_methodParameterTypes395 = new String[] { "long", "java.lang.String" };

		_methodName396 = "getESFClassNameAssigned";

		_methodParameterTypes396 = new String[] { "long" };

		_methodName397 = "getESFClassNameNotAssigned";

		_methodParameterTypes397 = new String[] { "long" };

		_methodName398 = "addState";

		_methodParameterTypes398 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName399 = "updateState";

		_methodParameterTypes399 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName400 = "deleteState";

		_methodParameterTypes400 = new String[] { "long" };

		_methodName401 = "addESFStateAssEntity";

		_methodParameterTypes401 = new String[] { "long", "long" };

		_methodName402 = "deleteESFStateAssEntity";

		_methodParameterTypes402 = new String[] { "long", "long" };

		_methodName403 = "checkName";

		_methodParameterTypes403 = new String[] { "java.lang.String" };

		_methodName404 = "isStateAssEntity";

		_methodParameterTypes404 = new String[] { "long" };
=======
		_methodName378 = "getBeanIdentifier";

		_methodParameterTypes378 = new String[] {  };

		_methodName379 = "setBeanIdentifier";

		_methodParameterTypes379 = new String[] { "java.lang.String" };

		_methodName384 = "findESFStates";

		_methodParameterTypes384 = new String[] { "java.lang.String" };

		_methodName385 = "findESFStateById";

		_methodParameterTypes385 = new String[] { "long" };

		_methodName386 = "findAllESFStates";

		_methodParameterTypes386 = new String[] {  };

		_methodName387 = "getESFStateAssEntitybyId_CN";

		_methodParameterTypes387 = new String[] { "long", "java.lang.String" };

		_methodName388 = "getESFClassNameAssigned";

		_methodParameterTypes388 = new String[] { "long" };

		_methodName389 = "getESFClassNameNotAssigned";

		_methodParameterTypes389 = new String[] { "long" };

		_methodName390 = "addState";

		_methodParameterTypes390 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName391 = "updateState";

		_methodParameterTypes391 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName392 = "deleteState";

		_methodParameterTypes392 = new String[] { "long" };

		_methodName393 = "addESFStateAssEntity";

		_methodParameterTypes393 = new String[] { "long", "long" };

		_methodName394 = "deleteESFStateAssEntity";

		_methodParameterTypes394 = new String[] { "long", "long" };

		_methodName395 = "checkName";

		_methodParameterTypes395 = new String[] { "java.lang.String" };

		_methodName396 = "isStateAssEntity";

		_methodParameterTypes396 = new String[] { "long" };
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFStateLocalServiceUtil.addESFState((it.ethica.esf.model.ESFState)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFStateLocalServiceUtil.createESFState(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFStateLocalServiceUtil.deleteESFState(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFStateLocalServiceUtil.deleteESFState((it.ethica.esf.model.ESFState)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFStateLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFStateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFStateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFStateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFStateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFStateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFStateLocalServiceUtil.fetchESFState(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFStateLocalServiceUtil.getESFState(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFStateLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFStateLocalServiceUtil.getESFStates(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFStateLocalServiceUtil.getESFStatesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFStateLocalServiceUtil.updateESFState((it.ethica.esf.model.ESFState)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
			return ESFStateLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
=======
		if (_methodName378.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes378, parameterTypes)) {
			return ESFStateLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName379.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes379, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			ESFStateLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFStateLocalServiceUtil.findESFStates((java.lang.String)arguments[0]);
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
			return ESFStateLocalServiceUtil.findESFStateById(((Long)arguments[0]).longValue());
		}

		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			return ESFStateLocalServiceUtil.findAllESFStates();
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
=======
		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
			return ESFStateLocalServiceUtil.findESFStates((java.lang.String)arguments[0]);
		}

		if (_methodName385.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes385, parameterTypes)) {
			return ESFStateLocalServiceUtil.findESFStateById(((Long)arguments[0]).longValue());
		}

		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
			return ESFStateLocalServiceUtil.findAllESFStates();
		}

		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFStateLocalServiceUtil.getESFStateAssEntitybyId_CN(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFStateLocalServiceUtil.getESFClassNameAssigned(((Long)arguments[0]).longValue());
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			return ESFStateLocalServiceUtil.getESFClassNameNotAssigned(((Long)arguments[0]).longValue());
		}

		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
=======
		if (_methodName388.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes388, parameterTypes)) {
			return ESFStateLocalServiceUtil.getESFClassNameAssigned(((Long)arguments[0]).longValue());
		}

		if (_methodName389.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes389, parameterTypes)) {
			return ESFStateLocalServiceUtil.getESFClassNameNotAssigned(((Long)arguments[0]).longValue());
		}

		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFStateLocalServiceUtil.addState((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
=======
		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFStateLocalServiceUtil.updateState(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

<<<<<<< HEAD
		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
			return ESFStateLocalServiceUtil.deleteState(((Long)arguments[0]).longValue());
		}

		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
=======
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFStateLocalServiceUtil.deleteState(((Long)arguments[0]).longValue());
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFStateLocalServiceUtil.addESFStateAssEntity(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
=======
		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFStateLocalServiceUtil.deleteESFStateAssEntity(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
			return ESFStateLocalServiceUtil.checkName((java.lang.String)arguments[0]);
		}

		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
=======
		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFStateLocalServiceUtil.checkName((java.lang.String)arguments[0]);
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFStateLocalServiceUtil.isStateAssEntity(((Long)arguments[0]).longValue());
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
<<<<<<< HEAD
=======
	private String _methodName378;
	private String[] _methodParameterTypes378;
	private String _methodName379;
	private String[] _methodParameterTypes379;
	private String _methodName384;
	private String[] _methodParameterTypes384;
	private String _methodName385;
	private String[] _methodParameterTypes385;
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	private String _methodName386;
	private String[] _methodParameterTypes386;
	private String _methodName387;
	private String[] _methodParameterTypes387;
	private String _methodName392;
	private String[] _methodParameterTypes392;
	private String _methodName393;
	private String[] _methodParameterTypes393;
	private String _methodName394;
	private String[] _methodParameterTypes394;
	private String _methodName395;
	private String[] _methodParameterTypes395;
	private String _methodName396;
	private String[] _methodParameterTypes396;
<<<<<<< HEAD
	private String _methodName397;
	private String[] _methodParameterTypes397;
	private String _methodName398;
	private String[] _methodParameterTypes398;
	private String _methodName399;
	private String[] _methodParameterTypes399;
	private String _methodName400;
	private String[] _methodParameterTypes400;
	private String _methodName401;
	private String[] _methodParameterTypes401;
	private String _methodName402;
	private String[] _methodParameterTypes402;
	private String _methodName403;
	private String[] _methodParameterTypes403;
	private String _methodName404;
	private String[] _methodParameterTypes404;
=======
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
}