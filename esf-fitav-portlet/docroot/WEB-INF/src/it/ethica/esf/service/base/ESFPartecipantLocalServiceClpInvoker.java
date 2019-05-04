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

import it.ethica.esf.service.ESFPartecipantLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFPartecipantLocalServiceClpInvoker {
	public ESFPartecipantLocalServiceClpInvoker() {
		_methodName0 = "addESFPartecipant";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFPartecipant"
			};

		_methodName1 = "createESFPartecipant";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFPartecipant";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFPartecipant";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFPartecipant"
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

		_methodName10 = "fetchESFPartecipant";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFPartecipantByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFPartecipantByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFPartecipant";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFPartecipantByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFPartecipantByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFPartecipants";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFPartecipantsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFPartecipant";

		_methodParameterTypes19 = new String[] {
				"it.ethica.esf.model.ESFPartecipant"
			};

<<<<<<< HEAD
		_methodName394 = "getBeanIdentifier";

		_methodParameterTypes394 = new String[] {  };

		_methodName395 = "setBeanIdentifier";

		_methodParameterTypes395 = new String[] { "java.lang.String" };

		_methodName400 = "getESFPartecipantByESFMatchId_ESFUserId";

		_methodParameterTypes400 = new String[] { "long", "long" };

		_methodName401 = "getESFPartecipantsByESFMatchId";

		_methodParameterTypes401 = new String[] { "long" };

		_methodName402 = "getESFPartecipantsByESFMatchId";

		_methodParameterTypes402 = new String[] { "long", "int", "int" };

		_methodName403 = "findPartecipants";

		_methodParameterTypes403 = new String[] {
				"long", "java.lang.Object[][]", "long"
			};

		_methodName404 = "findbyUserId";

		_methodParameterTypes404 = new String[] { "long" };

		_methodName405 = "findPartecipantsByMatch";

		_methodParameterTypes405 = new String[] { "long" };

		_methodName406 = "findPartecipantsByTournament";

		_methodParameterTypes406 = new String[] { "long" };

		_methodName407 = "getPartecipantByU_M_T";

		_methodParameterTypes407 = new String[] { "long", "long", "long" };

		_methodName408 = "addESFPartecipant";

		_methodParameterTypes408 = new String[] {
=======
		_methodName386 = "getBeanIdentifier";

		_methodParameterTypes386 = new String[] {  };

		_methodName387 = "setBeanIdentifier";

		_methodParameterTypes387 = new String[] { "java.lang.String" };

		_methodName392 = "getESFPartecipantByESFMatchId_ESFUserId";

		_methodParameterTypes392 = new String[] { "long", "long" };

		_methodName393 = "getESFPartecipantsByESFMatchId";

		_methodParameterTypes393 = new String[] { "long" };

		_methodName394 = "getESFPartecipantsByESFMatchId";

		_methodParameterTypes394 = new String[] { "long", "int", "int" };

		_methodName395 = "findPartecipants";

		_methodParameterTypes395 = new String[] {
				"long", "java.lang.Object[][]", "long"
			};

		_methodName396 = "findbyUserId";

		_methodParameterTypes396 = new String[] { "long" };

		_methodName397 = "findPartecipantsByMatch";

		_methodParameterTypes397 = new String[] { "long" };

		_methodName398 = "findPartecipantsByTournament";

		_methodParameterTypes398 = new String[] { "long" };

		_methodName399 = "getPartecipantByU_M_T";

		_methodParameterTypes399 = new String[] { "long", "long", "long" };

		_methodName400 = "addESFPartecipant";

		_methodParameterTypes400 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "long", "long", "long", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName409 = "deleteESFPartecipant";

		_methodParameterTypes409 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName410 = "updateESFPartecipant";

		_methodParameterTypes410 = new String[] {
=======
		_methodName401 = "deleteESFPartecipant";

		_methodParameterTypes401 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName402 = "updateESFPartecipant";

		_methodParameterTypes402 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "long", "long", "long", "long", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.addESFPartecipant((it.ethica.esf.model.ESFPartecipant)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.createESFPartecipant(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.deleteESFPartecipant(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.deleteESFPartecipant((it.ethica.esf.model.ESFPartecipant)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.fetchESFPartecipant(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.fetchESFPartecipantByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.fetchESFPartecipantByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.getESFPartecipant(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.getESFPartecipantByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.getESFPartecipantByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.getESFPartecipants(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.getESFPartecipantsCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.updateESFPartecipant((it.ethica.esf.model.ESFPartecipant)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
=======
		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			ESFPartecipantLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
=======
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFPartecipantLocalServiceUtil.getESFPartecipantByESFMatchId_ESFUserId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.getESFPartecipantsByESFMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
=======
		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.getESFPartecipantsByESFMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFPartecipantLocalServiceUtil.getESFPartecipantsByESFMatchId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
=======
		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFPartecipantLocalServiceUtil.findPartecipants(((Long)arguments[0]).longValue(),
				(java.lang.Object[])arguments[1],
				((Long)arguments[2]).longValue());
		}

<<<<<<< HEAD
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.findbyUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.findPartecipantsByMatch(((Long)arguments[0]).longValue());
		}

		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.findPartecipantsByTournament(((Long)arguments[0]).longValue());
		}

		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
=======
		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.findbyUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.findPartecipantsByMatch(((Long)arguments[0]).longValue());
		}

		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			return ESFPartecipantLocalServiceUtil.findPartecipantsByTournament(((Long)arguments[0]).longValue());
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFPartecipantLocalServiceUtil.getPartecipantByU_M_T(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

<<<<<<< HEAD
		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
=======
		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFPartecipantLocalServiceUtil.addESFPartecipant(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[7]);
		}

<<<<<<< HEAD
		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
=======
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFPartecipantLocalServiceUtil.deleteESFPartecipant(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
=======
		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFPartecipantLocalServiceUtil.updateESFPartecipant(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				((Long)arguments[7]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[8]);
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
	private String _methodName386;
	private String[] _methodParameterTypes386;
	private String _methodName387;
	private String[] _methodParameterTypes387;
	private String _methodName392;
	private String[] _methodParameterTypes392;
	private String _methodName393;
	private String[] _methodParameterTypes393;
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	private String _methodName394;
	private String[] _methodParameterTypes394;
	private String _methodName395;
	private String[] _methodParameterTypes395;
<<<<<<< HEAD
=======
	private String _methodName396;
	private String[] _methodParameterTypes396;
	private String _methodName397;
	private String[] _methodParameterTypes397;
	private String _methodName398;
	private String[] _methodParameterTypes398;
	private String _methodName399;
	private String[] _methodParameterTypes399;
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	private String _methodName400;
	private String[] _methodParameterTypes400;
	private String _methodName401;
	private String[] _methodParameterTypes401;
	private String _methodName402;
	private String[] _methodParameterTypes402;
<<<<<<< HEAD
	private String _methodName403;
	private String[] _methodParameterTypes403;
	private String _methodName404;
	private String[] _methodParameterTypes404;
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
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
}