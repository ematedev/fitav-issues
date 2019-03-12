package it.ethica.esf.service.persistence;

import it.ethica.esf.model.ESFFederalRole;
import it.ethica.esf.service.ESFFederalRoleLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class ESFFederalRoleFinderImpl extends BasePersistenceImpl<ESFFederalRole> implements ESFFederalRoleFinder {

	public List<ESFFederalRole> findByCode(String code) {

		Session session = null;
		List<ESFFederalRole> list = new ArrayList<ESFFederalRole>();
	    try {
	    	session = openSession();
	    	Criterion like = RestrictionsFactoryUtil.like("code", StringPool.PERCENT+code+StringPool.PERCENT);
	    	DynamicQuery dynamicQuery = ESFFederalRoleLocalServiceUtil.dynamicQuery()
	                .add(like);
	    	list = ESFFederalRoleLocalServiceUtil.dynamicQuery(dynamicQuery);
	    }
	    catch (Exception e) {
	    	_log.error(e.getMessage());
	    }
	    finally {
	        closeSession(session);
	    }

	    return list;
	}

	private static Log _log = LogFactoryUtil.getLog(ESFFederalRoleFinderImpl.class);

}
