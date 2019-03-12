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

package it.ethica.esf.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;
import it.ethica.esf.service.ESFDocumentTypeLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationTypeLocalServiceUtil;
import it.ethica.esf.service.ESFTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;

/**
 * @author Ethica
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			ESFCardLocalServiceUtil.clearService();

			ESFDocumentLocalServiceUtil.clearService();

			ESFDocumentTypeLocalServiceUtil.clearService();

			ESFOrganizationLocalServiceUtil.clearService();

			ESFOrganizationTypeLocalServiceUtil.clearService();

			ESFTypeLocalServiceUtil.clearService();

			ESFUserLocalServiceUtil.clearService();
		}
	}
}