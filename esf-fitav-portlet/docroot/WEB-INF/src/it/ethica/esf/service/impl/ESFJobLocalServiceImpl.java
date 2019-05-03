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

package it.ethica.esf.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFJob;
import it.ethica.esf.service.ESFJobLocalServiceUtil;
import it.ethica.esf.service.base.ESFJobLocalServiceBaseImpl;

/**
 * The implementation of the e s f job local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFJobLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFJobLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFJobLocalServiceUtil
 */
public class ESFJobLocalServiceImpl extends ESFJobLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFJobLocalServiceUtil} to access the e s f job local service.
	 */
	
	public List<ESFJob> findAll()
			throws SystemException {

			return esfJobPersistence.findAll();
		}
	
	public ESFJob addEsfJob(ServiceContext serviceContext, String name)
			throws SystemException {

			long jobId = counterLocalService.increment();

			ESFJob esfJob =
				esfJobLocalService.createESFJob(jobId);

			esfJob.setEsfName(name);
			
			esfJobLocalService.updateESFJob(esfJob);

			return esfJob;
		}
	
	public ESFJob updateEsfJob(
			 ServiceContext serviceContext, long jobId, String name)
			throws SystemException {

			ESFJob esfJob =
				esfJobLocalService.fetchESFJob(jobId);

			esfJob.setEsfName(name);
			
			ESFJobLocalServiceUtil.updateESFJob(esfJob);

			return esfJob;
		}

		public ESFJob deleteEsfJob( long jobId)
			throws SystemException {

			ESFJob esfJob = null;
			try {
				esfJob = ESFJobLocalServiceUtil.deleteESFJob(jobId);
			}
			catch (PortalException e) {
				e.printStackTrace();
			}

			return esfJob;
		}

}