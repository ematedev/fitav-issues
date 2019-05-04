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

import it.ethica.esf.service.ESFDocumentLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFDocumentLocalServiceClpInvoker {
	public ESFDocumentLocalServiceClpInvoker() {
		_methodName0 = "addESFDocument";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFDocument" };

		_methodName1 = "createESFDocument";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFDocument";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFDocument";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFDocument" };

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

		_methodName10 = "fetchESFDocument";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFDocument";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFDocuments";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFDocumentsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFDocument";

		_methodParameterTypes15 = new String[] { "it.ethica.esf.model.ESFDocument" };

<<<<<<< HEAD
		_methodName380 = "getBeanIdentifier";

		_methodParameterTypes380 = new String[] {  };

		_methodName381 = "setBeanIdentifier";

		_methodParameterTypes381 = new String[] { "java.lang.String" };

		_methodName386 = "findAll";

		_methodParameterTypes386 = new String[] {  };

		_methodName387 = "addEsfDocument";

		_methodParameterTypes387 = new String[] {
=======
		_methodName372 = "getBeanIdentifier";

		_methodParameterTypes372 = new String[] {  };

		_methodName373 = "setBeanIdentifier";

		_methodParameterTypes373 = new String[] { "java.lang.String" };

		_methodName378 = "findAll";

		_methodParameterTypes378 = new String[] {  };

		_methodName379 = "addEsfDocument";

		_methodParameterTypes379 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "java.lang.String", "long", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.util.Date", "java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName388 = "updateEsfDocument";

		_methodParameterTypes388 = new String[] {
=======
		_methodName380 = "updateEsfDocument";

		_methodParameterTypes380 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "long", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.util.Date", "java.lang.String",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName389 = "findByCode";

		_methodParameterTypes389 = new String[] { "java.lang.String" };

		_methodName390 = "findByesfUserId";

		_methodParameterTypes390 = new String[] { "long" };

		_methodName391 = "findByT_U";

		_methodParameterTypes391 = new String[] { "java.lang.String", "long" };

		_methodName392 = "findByU_ED";

		_methodParameterTypes392 = new String[] { "long", "java.util.Date" };
=======
		_methodName381 = "findByCode";

		_methodParameterTypes381 = new String[] { "java.lang.String" };

		_methodName382 = "findByesfUserId";

		_methodParameterTypes382 = new String[] { "long" };

		_methodName383 = "findByT_U";

		_methodParameterTypes383 = new String[] { "java.lang.String", "long" };

		_methodName384 = "findByU_ED";

		_methodParameterTypes384 = new String[] { "long", "java.util.Date" };
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.addESFDocument((it.ethica.esf.model.ESFDocument)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.createESFDocument(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.deleteESFDocument(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.deleteESFDocument((it.ethica.esf.model.ESFDocument)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.fetchESFDocument(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.getESFDocument(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.getESFDocuments(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.getESFDocumentsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.updateESFDocument((it.ethica.esf.model.ESFDocument)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName380.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes380, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName381.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes381, parameterTypes)) {
=======
		if (_methodName372.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes372, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName373.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes373, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			ESFDocumentLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.findAll();
		}

		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
=======
		if (_methodName378.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes378, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.findAll();
		}

		if (_methodName379.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes379, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFDocumentLocalServiceUtil.addEsfDocument(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.util.Date)arguments[6], (java.util.Date)arguments[7],
				(java.util.Date)arguments[8], (java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				(com.liferay.portal.service.ServiceContext)arguments[11]);
		}

<<<<<<< HEAD
		if (_methodName388.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes388, parameterTypes)) {
=======
		if (_methodName380.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes380, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFDocumentLocalServiceUtil.updateEsfDocument(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.util.Date)arguments[7], (java.util.Date)arguments[8],
				(java.util.Date)arguments[9], (java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(com.liferay.portal.service.ServiceContext)arguments[12]);
		}

<<<<<<< HEAD
		if (_methodName389.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes389, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.findByCode((java.lang.String)arguments[0]);
		}

		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.findByesfUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
=======
		if (_methodName381.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes381, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.findByCode((java.lang.String)arguments[0]);
		}

		if (_methodName382.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes382, parameterTypes)) {
			return ESFDocumentLocalServiceUtil.findByesfUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName383.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes383, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFDocumentLocalServiceUtil.findByT_U((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
=======
		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFDocumentLocalServiceUtil.findByU_ED(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1]);
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
	private String _methodName372;
	private String[] _methodParameterTypes372;
	private String _methodName373;
	private String[] _methodParameterTypes373;
	private String _methodName378;
	private String[] _methodParameterTypes378;
	private String _methodName379;
	private String[] _methodParameterTypes379;
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	private String _methodName380;
	private String[] _methodParameterTypes380;
	private String _methodName381;
	private String[] _methodParameterTypes381;
<<<<<<< HEAD
	private String _methodName386;
	private String[] _methodParameterTypes386;
	private String _methodName387;
	private String[] _methodParameterTypes387;
	private String _methodName388;
	private String[] _methodParameterTypes388;
	private String _methodName389;
	private String[] _methodParameterTypes389;
	private String _methodName390;
	private String[] _methodParameterTypes390;
	private String _methodName391;
	private String[] _methodParameterTypes391;
	private String _methodName392;
	private String[] _methodParameterTypes392;
=======
	private String _methodName382;
	private String[] _methodParameterTypes382;
	private String _methodName383;
	private String[] _methodParameterTypes383;
	private String _methodName384;
	private String[] _methodParameterTypes384;
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
}