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

package com.ethica.esf.service;

import com.ethica.esf.model.ESFArticleClp;
import com.ethica.esf.model.ESFArticleTypeClp;
import com.ethica.esf.model.ESFArticle_ESFOrderClp;
import com.ethica.esf.model.ESFArticle_ESFUserClp;
import com.ethica.esf.model.ESFBillClp;
import com.ethica.esf.model.ESFOrderClp;
import com.ethica.esf.model.ESFStockistClp;

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
						"esf-fitav-warehouse-portlet-deployment-context");

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
							"esf-fitav-warehouse-portlet-deployment-context");

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
				_servletContextName = "esf-fitav-warehouse-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ESFArticleClp.class.getName())) {
			return translateInputESFArticle(oldModel);
		}

		if (oldModelClassName.equals(ESFArticle_ESFOrderClp.class.getName())) {
			return translateInputESFArticle_ESFOrder(oldModel);
		}

		if (oldModelClassName.equals(ESFArticle_ESFUserClp.class.getName())) {
			return translateInputESFArticle_ESFUser(oldModel);
		}

		if (oldModelClassName.equals(ESFArticleTypeClp.class.getName())) {
			return translateInputESFArticleType(oldModel);
		}

		if (oldModelClassName.equals(ESFBillClp.class.getName())) {
			return translateInputESFBill(oldModel);
		}

		if (oldModelClassName.equals(ESFOrderClp.class.getName())) {
			return translateInputESFOrder(oldModel);
		}

		if (oldModelClassName.equals(ESFStockistClp.class.getName())) {
			return translateInputESFStockist(oldModel);
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

	public static Object translateInputESFArticle(BaseModel<?> oldModel) {
		ESFArticleClp oldClpModel = (ESFArticleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFArticleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFArticle_ESFOrder(
		BaseModel<?> oldModel) {
		ESFArticle_ESFOrderClp oldClpModel = (ESFArticle_ESFOrderClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFArticle_ESFOrderRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFArticle_ESFUser(BaseModel<?> oldModel) {
		ESFArticle_ESFUserClp oldClpModel = (ESFArticle_ESFUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFArticle_ESFUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFArticleType(BaseModel<?> oldModel) {
		ESFArticleTypeClp oldClpModel = (ESFArticleTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFArticleTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFBill(BaseModel<?> oldModel) {
		ESFBillClp oldClpModel = (ESFBillClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFBillRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFOrder(BaseModel<?> oldModel) {
		ESFOrderClp oldClpModel = (ESFOrderClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFOrderRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFStockist(BaseModel<?> oldModel) {
		ESFStockistClp oldClpModel = (ESFStockistClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFStockistRemoteModel();

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

		if (oldModelClassName.equals("com.ethica.esf.model.impl.ESFArticleImpl")) {
			return translateOutputESFArticle(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ethica.esf.model.impl.ESFArticle_ESFOrderImpl")) {
			return translateOutputESFArticle_ESFOrder(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ethica.esf.model.impl.ESFArticle_ESFUserImpl")) {
			return translateOutputESFArticle_ESFUser(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ethica.esf.model.impl.ESFArticleTypeImpl")) {
			return translateOutputESFArticleType(oldModel);
		}

		if (oldModelClassName.equals("com.ethica.esf.model.impl.ESFBillImpl")) {
			return translateOutputESFBill(oldModel);
		}

		if (oldModelClassName.equals("com.ethica.esf.model.impl.ESFOrderImpl")) {
			return translateOutputESFOrder(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ethica.esf.model.impl.ESFStockistImpl")) {
			return translateOutputESFStockist(oldModel);
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

		if (className.equals("com.ethica.esf.ESFOrderAssociatedException")) {
			return new com.ethica.esf.ESFOrderAssociatedException();
		}

		if (className.equals("com.ethica.esf.NoSuchArticleException")) {
			return new com.ethica.esf.NoSuchArticleException();
		}

		if (className.equals("com.ethica.esf.NoSuchArticle_ESFOrderException")) {
			return new com.ethica.esf.NoSuchArticle_ESFOrderException();
		}

		if (className.equals("com.ethica.esf.NoSuchArticle_ESFUserException")) {
			return new com.ethica.esf.NoSuchArticle_ESFUserException();
		}

		if (className.equals("com.ethica.esf.NoSuchArticleTypeException")) {
			return new com.ethica.esf.NoSuchArticleTypeException();
		}

		if (className.equals("com.ethica.esf.NoSuchBillException")) {
			return new com.ethica.esf.NoSuchBillException();
		}

		if (className.equals("com.ethica.esf.NoSuchOrderException")) {
			return new com.ethica.esf.NoSuchOrderException();
		}

		if (className.equals("com.ethica.esf.NoSuchStockistException")) {
			return new com.ethica.esf.NoSuchStockistException();
		}

		return throwable;
	}

	public static Object translateOutputESFArticle(BaseModel<?> oldModel) {
		ESFArticleClp newModel = new ESFArticleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFArticleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFArticle_ESFOrder(
		BaseModel<?> oldModel) {
		ESFArticle_ESFOrderClp newModel = new ESFArticle_ESFOrderClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFArticle_ESFOrderRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFArticle_ESFUser(
		BaseModel<?> oldModel) {
		ESFArticle_ESFUserClp newModel = new ESFArticle_ESFUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFArticle_ESFUserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFArticleType(BaseModel<?> oldModel) {
		ESFArticleTypeClp newModel = new ESFArticleTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFArticleTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFBill(BaseModel<?> oldModel) {
		ESFBillClp newModel = new ESFBillClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFBillRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFOrder(BaseModel<?> oldModel) {
		ESFOrderClp newModel = new ESFOrderClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFOrderRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFStockist(BaseModel<?> oldModel) {
		ESFStockistClp newModel = new ESFStockistClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFStockistRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}