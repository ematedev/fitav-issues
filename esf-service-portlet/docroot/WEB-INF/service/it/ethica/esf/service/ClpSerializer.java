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

package it.ethica.esf.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import it.ethica.esf.model.ESFCardClp;
import it.ethica.esf.model.ESFDocumentClp;
import it.ethica.esf.model.ESFDocumentTypeClp;
import it.ethica.esf.model.ESFOrganizationClp;
import it.ethica.esf.model.ESFOrganizationTypeClp;
import it.ethica.esf.model.ESFTypeClp;
import it.ethica.esf.model.ESFUserClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ethica
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"esf-service-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"esf-service-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "esf-service-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ESFCardClp.class.getName())) {
			return translateInputESFCard(oldModel);
		}

		if (oldModelClassName.equals(ESFDocumentClp.class.getName())) {
			return translateInputESFDocument(oldModel);
		}

		if (oldModelClassName.equals(ESFDocumentTypeClp.class.getName())) {
			return translateInputESFDocumentType(oldModel);
		}

		if (oldModelClassName.equals(ESFOrganizationClp.class.getName())) {
			return translateInputESFOrganization(oldModel);
		}

		if (oldModelClassName.equals(ESFOrganizationTypeClp.class.getName())) {
			return translateInputESFOrganizationType(oldModel);
		}

		if (oldModelClassName.equals(ESFTypeClp.class.getName())) {
			return translateInputESFType(oldModel);
		}

		if (oldModelClassName.equals(ESFUserClp.class.getName())) {
			return translateInputESFUser(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputESFCard(BaseModel<?> oldModel) {
		ESFCardClp oldClpModel = (ESFCardClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFCardRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFDocument(BaseModel<?> oldModel) {
		ESFDocumentClp oldClpModel = (ESFDocumentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFDocumentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFDocumentType(BaseModel<?> oldModel) {
		ESFDocumentTypeClp oldClpModel = (ESFDocumentTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFDocumentTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFOrganization(BaseModel<?> oldModel) {
		ESFOrganizationClp oldClpModel = (ESFOrganizationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFOrganizationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFOrganizationType(
		BaseModel<?> oldModel) {
		ESFOrganizationTypeClp oldClpModel = (ESFOrganizationTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFOrganizationTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFType(BaseModel<?> oldModel) {
		ESFTypeClp oldClpModel = (ESFTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFUser(BaseModel<?> oldModel) {
		ESFUserClp oldClpModel = (ESFUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFCardImpl")) {
			return translateOutputESFCard(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFDocumentImpl")) {
			return translateOutputESFDocument(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFDocumentTypeImpl")) {
			return translateOutputESFDocumentType(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFOrganizationImpl")) {
			return translateOutputESFOrganization(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFOrganizationTypeImpl")) {
			return translateOutputESFOrganizationType(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFTypeImpl")) {
			return translateOutputESFType(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFUserImpl")) {
			return translateOutputESFUser(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("it.ethica.esf.ESFDocumentNumberException")) {
			return new it.ethica.esf.ESFDocumentNumberException();
		}

		if (className.equals("it.ethica.esf.ESFUserPortalUserException")) {
			return new it.ethica.esf.ESFUserPortalUserException();
		}

		if (className.equals("it.ethica.esf.NoSuchCardException")) {
			return new it.ethica.esf.NoSuchCardException();
		}

		if (className.equals("it.ethica.esf.NoSuchDocumentException")) {
			return new it.ethica.esf.NoSuchDocumentException();
		}

		if (className.equals("it.ethica.esf.NoSuchDocumentTypeException")) {
			return new it.ethica.esf.NoSuchDocumentTypeException();
		}

		if (className.equals("it.ethica.esf.NoSuchOrganizationException")) {
			return new it.ethica.esf.NoSuchOrganizationException();
		}

		if (className.equals("it.ethica.esf.NoSuchOrganizationTypeException")) {
			return new it.ethica.esf.NoSuchOrganizationTypeException();
		}

		if (className.equals("it.ethica.esf.NoSuchTypeException")) {
			return new it.ethica.esf.NoSuchTypeException();
		}

		if (className.equals("it.ethica.esf.NoSuchUserException")) {
			return new it.ethica.esf.NoSuchUserException();
		}

		return throwable;
	}

	public static Object translateOutputESFCard(BaseModel<?> oldModel) {
		ESFCardClp newModel = new ESFCardClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFCardRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFDocument(BaseModel<?> oldModel) {
		ESFDocumentClp newModel = new ESFDocumentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFDocumentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFDocumentType(BaseModel<?> oldModel) {
		ESFDocumentTypeClp newModel = new ESFDocumentTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFDocumentTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFOrganization(BaseModel<?> oldModel) {
		ESFOrganizationClp newModel = new ESFOrganizationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFOrganizationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFOrganizationType(
		BaseModel<?> oldModel) {
		ESFOrganizationTypeClp newModel = new ESFOrganizationTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFOrganizationTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFType(BaseModel<?> oldModel) {
		ESFTypeClp newModel = new ESFTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFUser(BaseModel<?> oldModel) {
		ESFUserClp newModel = new ESFUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFUserRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}