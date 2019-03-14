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

package it.ethica.esf.model.impl;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

/**
 * The extended model implementation for the ESFOrganization service. Represents
 * a row in the &quot;ESF_ESFOrganization&quot; database table, with each column
 * mapped to a property of this class. <p> Helper methods and all application
 * logic should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.model.ESFOrganization} interface. </p>
 *
 * @author Ethica
 */
public class ESFOrganizationImpl extends ESFOrganizationBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. All methods
	 * that expect a e s f organization model instance should use the {@link
	 * it.ethica.esf.model.ESFOrganization} interface instead.
	 */

	private long companyId;
	private long userId;
	private String userName;
	private Date createDate;
	private Date modifiedDate;
	private long parentOrganizationId;
	private String treePath;
	private String name;
	private String type_;
	private boolean recursable;
	private int statusId;
	private String comments;

	public ESFOrganizationImpl() {

		companyId = -1;
		userId = -1;
		userName = null;
		createDate = null;
		modifiedDate = null;
		parentOrganizationId = -1;
		treePath = null;
		name = null;
		type_ = null;
		recursable = false;
		statusId = -1;
		comments = null;
	}

	public ESFOrganizationImpl(
		long companyId, long userId, String userName, Date createDate,
		Date modifiedDate, long parentOrganizationId, String treePath,
		String name, String type_, boolean recursable, long regionId,
		long countryId, int statusId, String comments) {

		super();
		this.companyId = companyId;
		this.userId = userId;
		this.userName = userName;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.parentOrganizationId = parentOrganizationId;
		this.treePath = treePath;
		this.name = name;
		this.type_ = type_;
		this.recursable = recursable;
		this.statusId = statusId;
		this.comments = comments;
	}

	public long getCompanyId()
		throws PortalException, SystemException {

		companyId =
			OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).getCompanyId();
		return companyId;
	}

	public long getUserId()
		throws PortalException, SystemException {

		userId =
			OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).getUserId();
		return userId;
	}

	public String getUserName()
		throws PortalException, SystemException {

		userName =
			OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).getUserName();
		return userName;
	}

	public Date getCreateDate()
		throws PortalException, SystemException {

		createDate =
			OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).getCreateDate();
		return createDate;
	}

	public Date getModifiedDate()
		throws PortalException, SystemException {

		modifiedDate =
			OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).getModifiedDate();
		return modifiedDate;
	}

	public long getParentOrganizationId()
		throws PortalException, SystemException {

		parentOrganizationId =
			OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).getParentOrganizationId();
		return parentOrganizationId;
	}

	public String getTreePath()
		throws PortalException, SystemException {

		treePath =
			OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).getTreePath();
		return treePath;
	}

	public String getName()
		throws PortalException, SystemException {

		name =
			OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).getName();
		return name;
	}

	public String getType_()
		throws PortalException, SystemException {

		type_ =
			OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).getType();
		return type_;
	}

	public boolean getRecursable()
		throws PortalException, SystemException {

		recursable =
			OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).getRecursable();
		return recursable;
	}

	public long getStatusId()
		throws PortalException, SystemException {

		statusId =
			OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).getStatusId();
		return statusId;
	}

	public String getComments()
		throws PortalException, SystemException {

		comments =
			OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).getComments();
		return comments;
	}

	public void setCompanyId(long companyId)
		throws PortalException, SystemException {

		this.companyId = companyId;
		OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).setCompanyId(
			companyId);
	}

	public void setUserId(long userId)
		throws PortalException, SystemException {

		this.userId = userId;
		OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).setUserId(
			userId);
	}

	public void setUserName(String userName)
		throws PortalException, SystemException {

		this.userName = userName;
		OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).setUserName(
			userName);
	}

	public void setCreateDate(Date createDate)
		throws PortalException, SystemException {

		this.createDate = createDate;
		OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).setCreateDate(
			createDate);
	}

	public void setModifiedDate(Date modifiedDate)
		throws PortalException, SystemException {

		this.modifiedDate = modifiedDate;
		OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).setModifiedDate(
			modifiedDate);
	}

	public void setParentOrganizationId(long parentOrganizationId)
		throws PortalException, SystemException {

		this.parentOrganizationId = parentOrganizationId;
		OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).setParentOrganizationId(
			parentOrganizationId);
	}

	public void setTreePath(String treePath)
		throws PortalException, SystemException {

		this.treePath = treePath;
		OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).setTreePath(
			treePath);
	}

	public void setName(String name)
		throws PortalException, SystemException {

		this.name = name;

		Organization originalOrganization =
			OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId());
		originalOrganization.setName(name);
		OrganizationLocalServiceUtil.updateOrganization(originalOrganization);
	}

	public void setType_(String type_)
		throws PortalException, SystemException {

		this.type_ = type_;
		OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).setType(
			type_);
	}

	public void setRecursable(boolean recursable)
		throws PortalException, SystemException {

		this.recursable = recursable;
		OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).setRecursable(
			recursable);
	}

	public void setStatusId(int statusId)
		throws PortalException, SystemException {

		this.statusId = statusId;
		OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).setStatusId(
			statusId);
	}

	public void setComments(String comments)
		throws PortalException, SystemException {

		this.comments = comments;
		OrganizationLocalServiceUtil.getOrganization(getEsfOrganizationId()).setComments(
			comments);
	}
}
