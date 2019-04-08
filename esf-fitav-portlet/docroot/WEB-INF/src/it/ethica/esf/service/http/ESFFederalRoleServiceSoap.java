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

package it.ethica.esf.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.ethica.esf.service.ESFFederalRoleServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link it.ethica.esf.service.ESFFederalRoleServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link it.ethica.esf.model.ESFFederalRoleSoap}.
 * If the method in the service utility returns a
 * {@link it.ethica.esf.model.ESFFederalRole}, that is translated to a
 * {@link it.ethica.esf.model.ESFFederalRoleSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Ethica
 * @see ESFFederalRoleServiceHttp
 * @see it.ethica.esf.model.ESFFederalRoleSoap
 * @see it.ethica.esf.service.ESFFederalRoleServiceUtil
 * @generated
 */
public class ESFFederalRoleServiceSoap {
	public static it.ethica.esf.model.ESFFederalRoleSoap updateEsfFederalRole(
		long esfFederalRoleId, java.lang.String name,
		java.lang.String description, boolean regional, boolean provincial)
		throws RemoteException {
		try {
			it.ethica.esf.model.ESFFederalRole returnValue = ESFFederalRoleServiceUtil.updateEsfFederalRole(esfFederalRoleId,
					name, description, regional, provincial);

			return it.ethica.esf.model.ESFFederalRoleSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.ethica.esf.model.ESFSpecificSoap[] getFederalRoleSpecifics(
		long esfFederalRoleId) throws RemoteException {
		try {
			java.util.List<it.ethica.esf.model.ESFSpecific> returnValue = ESFFederalRoleServiceUtil.getFederalRoleSpecifics(esfFederalRoleId);

			return it.ethica.esf.model.ESFSpecificSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.ethica.esf.model.ESFFederalRoleSoap[] findByCode(
		java.lang.String name) throws RemoteException {
		try {
			java.util.List<it.ethica.esf.model.ESFFederalRole> returnValue = ESFFederalRoleServiceUtil.findByCode(name);

			return it.ethica.esf.model.ESFFederalRoleSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ESFFederalRoleServiceSoap.class);
}