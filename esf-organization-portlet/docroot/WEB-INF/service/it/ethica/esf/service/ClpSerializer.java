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

import it.ethica.esf.model.ESFAddressClp;
import it.ethica.esf.model.ESFFieldClp;
import it.ethica.esf.model.ESFFieldESFSportTypeClp;
import it.ethica.esf.model.ESFOrganizationClp;
import it.ethica.esf.model.ESFSportTypeClp;

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
						"esf-organization-portlet-deployment-context");

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
							"esf-organization-portlet-deployment-context");

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
				_servletContextName = "esf-organization-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ESFAddressClp.class.getName())) {
			return translateInputESFAddress(oldModel);
		}

		if (oldModelClassName.equals(ESFFieldClp.class.getName())) {
			return translateInputESFField(oldModel);
		}

		if (oldModelClassName.equals(ESFFieldESFSportTypeClp.class.getName())) {
			return translateInputESFFieldESFSportType(oldModel);
		}

		if (oldModelClassName.equals(ESFOrganizationClp.class.getName())) {
			return translateInputESFOrganization(oldModel);
		}

		if (oldModelClassName.equals(ESFSportTypeClp.class.getName())) {
			return translateInputESFSportType(oldModel);
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

	public static Object translateInputESFAddress(BaseModel<?> oldModel) {
		ESFAddressClp oldClpModel = (ESFAddressClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFAddressRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFField(BaseModel<?> oldModel) {
		ESFFieldClp oldClpModel = (ESFFieldClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFFieldRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFFieldESFSportType(
		BaseModel<?> oldModel) {
		ESFFieldESFSportTypeClp oldClpModel = (ESFFieldESFSportTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFFieldESFSportTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFOrganization(BaseModel<?> oldModel) {
		ESFOrganizationClp oldClpModel = (ESFOrganizationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFOrganizationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFSportType(BaseModel<?> oldModel) {
		ESFSportTypeClp oldClpModel = (ESFSportTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFSportTypeRemoteModel();

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

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFAddressImpl")) {
			return translateOutputESFAddress(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFFieldImpl")) {
			return translateOutputESFField(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFFieldESFSportTypeImpl")) {
			return translateOutputESFFieldESFSportType(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFOrganizationImpl")) {
			return translateOutputESFOrganization(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFSportTypeImpl")) {
			return translateOutputESFSportType(oldModel);
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

		if (className.equals("it.ethica.esf.ESFAddressLatitudeException")) {
			return new it.ethica.esf.ESFAddressLatitudeException();
		}

		if (className.equals("it.ethica.esf.ESFAddressLongitudeException")) {
			return new it.ethica.esf.ESFAddressLongitudeException();
		}

		if (className.equals("it.ethica.esf.ESFFieldNameException")) {
			return new it.ethica.esf.ESFFieldNameException();
		}

		if (className.equals("it.ethica.esf.ESFOrganizationNameException")) {
			return new it.ethica.esf.ESFOrganizationNameException();
		}

		if (className.equals("it.ethica.esf.ESFSportTypeNameException")) {
			return new it.ethica.esf.ESFSportTypeNameException();
		}

		if (className.equals("it.ethica.esf.NoSuchAddressException")) {
			return new it.ethica.esf.NoSuchAddressException();
		}

		if (className.equals("it.ethica.esf.NoSuchFieldException")) {
			return new it.ethica.esf.NoSuchFieldException();
		}

		if (className.equals("it.ethica.esf.NoSuchFieldESFSportTypeException")) {
			return new it.ethica.esf.NoSuchFieldESFSportTypeException();
		}

		if (className.equals("it.ethica.esf.NoSuchOrganizationException")) {
			return new it.ethica.esf.NoSuchOrganizationException();
		}

		if (className.equals("it.ethica.esf.NoSuchSportTypeException")) {
			return new it.ethica.esf.NoSuchSportTypeException();
		}

		return throwable;
	}

	public static Object translateOutputESFAddress(BaseModel<?> oldModel) {
		ESFAddressClp newModel = new ESFAddressClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFAddressRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFField(BaseModel<?> oldModel) {
		ESFFieldClp newModel = new ESFFieldClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFFieldRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFFieldESFSportType(
		BaseModel<?> oldModel) {
		ESFFieldESFSportTypeClp newModel = new ESFFieldESFSportTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFFieldESFSportTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFOrganization(BaseModel<?> oldModel) {
		ESFOrganizationClp newModel = new ESFOrganizationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFOrganizationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFSportType(BaseModel<?> oldModel) {
		ESFSportTypeClp newModel = new ESFSportTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFSportTypeRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}