<<<<<<< HEAD
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

import it.ethica.esf.service.ESFShooterAffiliationChronoLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFShooterAffiliationChronoLocalServiceClpInvoker {
	public ESFShooterAffiliationChronoLocalServiceClpInvoker() {
		_methodName0 = "addESFShooterAffiliationChrono";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFShooterAffiliationChrono"
			};

		_methodName1 = "createESFShooterAffiliationChrono";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFShooterAffiliationChrono";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFShooterAffiliationChrono";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFShooterAffiliationChrono"
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

		_methodName10 = "fetchESFShooterAffiliationChrono";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFShooterAffiliationChrono";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFShooterAffiliationChronos";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFShooterAffiliationChronosCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFShooterAffiliationChrono";

		_methodParameterTypes15 = new String[] {
				"it.ethica.esf.model.ESFShooterAffiliationChrono"
			};

<<<<<<< HEAD
		_methodName384 = "getBeanIdentifier";

		_methodParameterTypes384 = new String[] {  };

		_methodName385 = "setBeanIdentifier";

		_methodParameterTypes385 = new String[] { "java.lang.String" };

		_methodName390 = "affiliated";

		_methodParameterTypes390 = new String[] { "long", "int" };

		_methodName391 = "findbyDate";

		_methodParameterTypes391 = new String[] { "java.util.Date", "int", "int" };

		_methodName392 = "countByDate";

		_methodParameterTypes392 = new String[] { "java.util.Date" };

		_methodName393 = "findChronobyDate";

		_methodParameterTypes393 = new String[] { "java.lang.String", "int", "int" };

		_methodName394 = "findChronobyCardAndYear";

		_methodParameterTypes394 = new String[] { "java.lang.String", "int" };

		_methodName395 = "countChronoByDate";

		_methodParameterTypes395 = new String[] { "java.lang.String" };

		_methodName396 = "countShooterByYear";

		_methodParameterTypes396 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName397 = "countShooterThisYear";

		_methodParameterTypes397 = new String[] {
=======
		_methodName376 = "getBeanIdentifier";

		_methodParameterTypes376 = new String[] {  };

		_methodName377 = "setBeanIdentifier";

		_methodParameterTypes377 = new String[] { "java.lang.String" };

		_methodName382 = "affiliated";

		_methodParameterTypes382 = new String[] { "long", "int" };

		_methodName383 = "findbyDate";

		_methodParameterTypes383 = new String[] { "java.util.Date", "int", "int" };

		_methodName384 = "countByDate";

		_methodParameterTypes384 = new String[] { "java.util.Date" };

		_methodName385 = "findChronobyDate";

		_methodParameterTypes385 = new String[] { "java.lang.String", "int", "int" };

		_methodName386 = "findChronobyCardAndYear";

		_methodParameterTypes386 = new String[] { "java.lang.String", "int" };

		_methodName387 = "countChronoByDate";

		_methodParameterTypes387 = new String[] { "java.lang.String" };

		_methodName388 = "countShooterByYear";

		_methodParameterTypes388 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName389 = "countShooterThisYear";

		_methodParameterTypes389 = new String[] {
>>>>>>> anomalia-id16
				"java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.addESFShooterAffiliationChrono((it.ethica.esf.model.ESFShooterAffiliationChrono)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.createESFShooterAffiliationChrono(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.deleteESFShooterAffiliationChrono(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.deleteESFShooterAffiliationChrono((it.ethica.esf.model.ESFShooterAffiliationChrono)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.fetchESFShooterAffiliationChrono(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.getESFShooterAffiliationChrono(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.getESFShooterAffiliationChronos(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.getESFShooterAffiliationChronosCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.updateESFShooterAffiliationChrono((it.ethica.esf.model.ESFShooterAffiliationChrono)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName385.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes385, parameterTypes)) {
=======
		if (_methodName376.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes376, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName377.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes377, parameterTypes)) {
>>>>>>> anomalia-id16
			ESFShooterAffiliationChronoLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
=======
		if (_methodName382.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes382, parameterTypes)) {
>>>>>>> anomalia-id16
			return ESFShooterAffiliationChronoLocalServiceUtil.affiliated(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
=======
		if (_methodName383.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes383, parameterTypes)) {
>>>>>>> anomalia-id16
			return ESFShooterAffiliationChronoLocalServiceUtil.findbyDate((java.util.Date)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.countByDate((java.util.Date)arguments[0]);
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
=======
		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.countByDate((java.util.Date)arguments[0]);
		}

		if (_methodName385.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes385, parameterTypes)) {
>>>>>>> anomalia-id16
			return ESFShooterAffiliationChronoLocalServiceUtil.findChronobyDate((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
=======
		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
>>>>>>> anomalia-id16
			return ESFShooterAffiliationChronoLocalServiceUtil.findChronobyCardAndYear((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.countChronoByDate((java.lang.String)arguments[0]);
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
=======
		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.countChronoByDate((java.lang.String)arguments[0]);
		}

		if (_methodName388.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes388, parameterTypes)) {
>>>>>>> anomalia-id16
			return ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
=======
		if (_methodName389.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes389, parameterTypes)) {
>>>>>>> anomalia-id16
			return ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
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
	private String _methodName376;
	private String[] _methodParameterTypes376;
	private String _methodName377;
	private String[] _methodParameterTypes377;
	private String _methodName382;
	private String[] _methodParameterTypes382;
	private String _methodName383;
	private String[] _methodParameterTypes383;
>>>>>>> anomalia-id16
	private String _methodName384;
	private String[] _methodParameterTypes384;
	private String _methodName385;
	private String[] _methodParameterTypes385;
<<<<<<< HEAD
	private String _methodName390;
	private String[] _methodParameterTypes390;
	private String _methodName391;
	private String[] _methodParameterTypes391;
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
	private String _methodName397;
	private String[] _methodParameterTypes397;
=======
	private String _methodName386;
	private String[] _methodParameterTypes386;
	private String _methodName387;
	private String[] _methodParameterTypes387;
	private String _methodName388;
	private String[] _methodParameterTypes388;
	private String _methodName389;
	private String[] _methodParameterTypes389;
>>>>>>> anomalia-id16
=======
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

import it.ethica.esf.service.ESFShooterAffiliationChronoLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFShooterAffiliationChronoLocalServiceClpInvoker {
	public ESFShooterAffiliationChronoLocalServiceClpInvoker() {
		_methodName0 = "addESFShooterAffiliationChrono";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFShooterAffiliationChrono"
			};

		_methodName1 = "createESFShooterAffiliationChrono";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFShooterAffiliationChrono";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFShooterAffiliationChrono";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFShooterAffiliationChrono"
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

		_methodName10 = "fetchESFShooterAffiliationChrono";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFShooterAffiliationChrono";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFShooterAffiliationChronos";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFShooterAffiliationChronosCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFShooterAffiliationChrono";

		_methodParameterTypes15 = new String[] {
				"it.ethica.esf.model.ESFShooterAffiliationChrono"
			};

		_methodName384 = "getBeanIdentifier";

		_methodParameterTypes384 = new String[] {  };

		_methodName385 = "setBeanIdentifier";

		_methodParameterTypes385 = new String[] { "java.lang.String" };

		_methodName390 = "affiliated";

		_methodParameterTypes390 = new String[] { "long", "int" };

		_methodName391 = "findbyDate";

		_methodParameterTypes391 = new String[] { "java.util.Date", "int", "int" };

		_methodName392 = "countByDate";

		_methodParameterTypes392 = new String[] { "java.util.Date" };

		_methodName393 = "findChronobyDate";

		_methodParameterTypes393 = new String[] { "java.lang.String", "int", "int" };

		_methodName394 = "findChronobyCardAndYear";

		_methodParameterTypes394 = new String[] { "java.lang.String", "int" };

		_methodName395 = "countChronoByDate";

		_methodParameterTypes395 = new String[] { "java.lang.String" };

		_methodName396 = "countShooterByYear";

		_methodParameterTypes396 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName397 = "countShooterThisYear";

		_methodParameterTypes397 = new String[] {
				"java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.addESFShooterAffiliationChrono((it.ethica.esf.model.ESFShooterAffiliationChrono)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.createESFShooterAffiliationChrono(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.deleteESFShooterAffiliationChrono(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.deleteESFShooterAffiliationChrono((it.ethica.esf.model.ESFShooterAffiliationChrono)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.fetchESFShooterAffiliationChrono(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.getESFShooterAffiliationChrono(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.getESFShooterAffiliationChronos(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.getESFShooterAffiliationChronosCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.updateESFShooterAffiliationChrono((it.ethica.esf.model.ESFShooterAffiliationChrono)arguments[0]);
		}

		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName385.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes385, parameterTypes)) {
			ESFShooterAffiliationChronoLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.affiliated(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.findbyDate((java.util.Date)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.countByDate((java.util.Date)arguments[0]);
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.findChronobyDate((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.findChronobyCardAndYear((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.countChronoByDate((java.lang.String)arguments[0]);
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.countShooterByYear((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			return ESFShooterAffiliationChronoLocalServiceUtil.countShooterThisYear((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
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
	private String _methodName384;
	private String[] _methodParameterTypes384;
	private String _methodName385;
	private String[] _methodParameterTypes385;
	private String _methodName390;
	private String[] _methodParameterTypes390;
	private String _methodName391;
	private String[] _methodParameterTypes391;
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
	private String _methodName397;
	private String[] _methodParameterTypes397;
>>>>>>> 4e2f23245d33f5cc80bffcdd36acf34e75accc38
}