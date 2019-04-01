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

import it.ethica.esf.model.CityClp;
import it.ethica.esf.model.CountryClp;
import it.ethica.esf.model.ESFAddressClp;
import it.ethica.esf.model.ProvinceClp;
import it.ethica.esf.model.RegionClp;

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
						"esf-address-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isErrorEnabled() ) {
					_log.error(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"esf-address-portlet-deployment-context");

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
				_servletContextName = "esf-address-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CityClp.class.getName())) {
			return translateInputCity(oldModel);
		}

		if (oldModelClassName.equals(CountryClp.class.getName())) {
			return translateInputCountry(oldModel);
		}

		if (oldModelClassName.equals(ESFAddressClp.class.getName())) {
			return translateInputESFAddress(oldModel);
		}

		if (oldModelClassName.equals(ProvinceClp.class.getName())) {
			return translateInputProvince(oldModel);
		}

		if (oldModelClassName.equals(RegionClp.class.getName())) {
			return translateInputRegion(oldModel);
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

	public static Object translateInputCity(BaseModel<?> oldModel) {
		CityClp oldClpModel = (CityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCountry(BaseModel<?> oldModel) {
		CountryClp oldClpModel = (CountryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCountryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFAddress(BaseModel<?> oldModel) {
		ESFAddressClp oldClpModel = (ESFAddressClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFAddressRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProvince(BaseModel<?> oldModel) {
		ProvinceClp oldClpModel = (ProvinceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProvinceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRegion(BaseModel<?> oldModel) {
		RegionClp oldClpModel = (RegionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRegionRemoteModel();

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

		if (oldModelClassName.equals("it.ethica.esf.model.impl.CityImpl")) {
			return translateOutputCity(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.CountryImpl")) {
			return translateOutputCountry(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFAddressImpl")) {
			return translateOutputESFAddress(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ProvinceImpl")) {
			return translateOutputProvince(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.RegionImpl")) {
			return translateOutputRegion(oldModel);
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

		if (className.equals("it.ethica.esf.NoSuchCityException")) {
			return new it.ethica.esf.NoSuchCityException();
		}

		if (className.equals("it.ethica.esf.NoSuchCountryException")) {
			return new it.ethica.esf.NoSuchCountryException();
		}

		if (className.equals("it.ethica.esf.NoSuchAddressException")) {
			return new it.ethica.esf.NoSuchAddressException();
		}

		if (className.equals("it.ethica.esf.NoSuchProvinceException")) {
			return new it.ethica.esf.NoSuchProvinceException();
		}

		if (className.equals("it.ethica.esf.NoSuchRegionException")) {
			return new it.ethica.esf.NoSuchRegionException();
		}

		return throwable;
	}

	public static Object translateOutputCity(BaseModel<?> oldModel) {
		CityClp newModel = new CityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCountry(BaseModel<?> oldModel) {
		CountryClp newModel = new CountryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCountryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFAddress(BaseModel<?> oldModel) {
		ESFAddressClp newModel = new ESFAddressClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFAddressRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProvince(BaseModel<?> oldModel) {
		ProvinceClp newModel = new ProvinceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProvinceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRegion(BaseModel<?> oldModel) {
		RegionClp newModel = new RegionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRegionRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}