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

package it.ethica.esf.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.ethica.esf.service.ESFConfigurationServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link it.ethica.esf.service.ESFConfigurationServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link it.ethica.esf.model.ESFConfigurationSoap}.
 * If the method in the service utility returns a
 * {@link it.ethica.esf.model.ESFConfiguration}, that is translated to a
 * {@link it.ethica.esf.model.ESFConfigurationSoap}. Methods that SOAP cannot
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
 * @see ESFConfigurationServiceHttp
 * @see it.ethica.esf.model.ESFConfigurationSoap
 * @see it.ethica.esf.service.ESFConfigurationServiceUtil
 * @generated
 */
public class ESFConfigurationServiceSoap {
	public static it.ethica.esf.model.ESFConfigurationSoap[] getAllEsfConfigurations()
		throws RemoteException {
		try {
			java.util.List<it.ethica.esf.model.ESFConfiguration> returnValue = ESFConfigurationServiceUtil.getAllEsfConfigurations();

			return it.ethica.esf.model.ESFConfigurationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.ethica.esf.model.ESFConfigurationSoap[] getAllEsfConfigurations(
		int start, int end) throws RemoteException {
		try {
			java.util.List<it.ethica.esf.model.ESFConfiguration> returnValue = ESFConfigurationServiceUtil.getAllEsfConfigurations(start,
					end);

			return it.ethica.esf.model.ESFConfigurationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.ethica.esf.model.ESFConfigurationSoap[] getAllEsfConfigurations(
		long groupId) throws RemoteException {
		try {
			java.util.List<it.ethica.esf.model.ESFConfiguration> returnValue = ESFConfigurationServiceUtil.getAllEsfConfigurations(groupId);

			return it.ethica.esf.model.ESFConfigurationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.ethica.esf.model.ESFConfigurationSoap[] getAllEsfConfigurations(
		long groupId, int start, int end) throws RemoteException {
		try {
			java.util.List<it.ethica.esf.model.ESFConfiguration> returnValue = ESFConfigurationServiceUtil.getAllEsfConfigurations(groupId,
					start, end);

			return it.ethica.esf.model.ESFConfigurationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByGroupId(long groupId) throws RemoteException {
		try {
			int returnValue = ESFConfigurationServiceUtil.countByGroupId(groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.ethica.esf.model.ESFConfigurationSoap[] findESFFornitureTypeByDescription(
		java.lang.String description) throws RemoteException {
		try {
			java.util.List<it.ethica.esf.model.ESFConfiguration> returnValue = ESFConfigurationServiceUtil.findESFFornitureTypeByDescription(description);

			return it.ethica.esf.model.ESFConfigurationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ESFConfigurationServiceSoap.class);
}