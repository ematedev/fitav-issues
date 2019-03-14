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

import it.ethica.esf.model.ESFGunClp;
import it.ethica.esf.model.ESFGunKindClp;
import it.ethica.esf.model.ESFGunTypeClp;

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
						"esf-gun-portlet-deployment-context");

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
							"esf-gun-portlet-deployment-context");

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
				_servletContextName = "esf-gun-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ESFGunClp.class.getName())) {
			return translateInputESFGun(oldModel);
		}

		if (oldModelClassName.equals(ESFGunKindClp.class.getName())) {
			return translateInputESFGunKind(oldModel);
		}

		if (oldModelClassName.equals(ESFGunTypeClp.class.getName())) {
			return translateInputESFGunType(oldModel);
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

	public static Object translateInputESFGun(BaseModel<?> oldModel) {
		ESFGunClp oldClpModel = (ESFGunClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFGunRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFGunKind(BaseModel<?> oldModel) {
		ESFGunKindClp oldClpModel = (ESFGunKindClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFGunKindRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFGunType(BaseModel<?> oldModel) {
		ESFGunTypeClp oldClpModel = (ESFGunTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFGunTypeRemoteModel();

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

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFGunImpl")) {
			return translateOutputESFGun(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFGunKindImpl")) {
			return translateOutputESFGunKind(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFGunTypeImpl")) {
			return translateOutputESFGunType(oldModel);
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

		if (className.equals("it.ethica.esf.ESFGunKindNameException")) {
			return new it.ethica.esf.ESFGunKindNameException();
		}

		if (className.equals("it.ethica.esf.ESFGunNameException")) {
			return new it.ethica.esf.ESFGunNameException();
		}

		if (className.equals("it.ethica.esf.ESFGunTypeNameException")) {
			return new it.ethica.esf.ESFGunTypeNameException();
		}

		if (className.equals("it.ethica.esf.NoSuchGunException")) {
			return new it.ethica.esf.NoSuchGunException();
		}

		if (className.equals("it.ethica.esf.NoSuchGunKindException")) {
			return new it.ethica.esf.NoSuchGunKindException();
		}

		if (className.equals("it.ethica.esf.NoSuchGunTypeException")) {
			return new it.ethica.esf.NoSuchGunTypeException();
		}

		return throwable;
	}

	public static Object translateOutputESFGun(BaseModel<?> oldModel) {
		ESFGunClp newModel = new ESFGunClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFGunRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFGunKind(BaseModel<?> oldModel) {
		ESFGunKindClp newModel = new ESFGunKindClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFGunKindRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFGunType(BaseModel<?> oldModel) {
		ESFGunTypeClp newModel = new ESFGunTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFGunTypeRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}