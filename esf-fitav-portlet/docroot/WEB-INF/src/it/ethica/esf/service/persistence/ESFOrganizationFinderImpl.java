package it.ethica.esf.service.persistence;



import java.util.ArrayList;
import java.util.List;

import it.ethica.esf.model.ESFOrganization;


import it.ethica.esf.model.impl.ESFOrganizationImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class ESFOrganizationFinderImpl extends BasePersistenceImpl<ESFOrganization>
	implements ESFOrganizationFinder {

	private static Log _log =
		LogFactoryUtil.getLog(ESFOrganizationFinderImpl.class);

	public List<ESFOrganization> findAllAffilationConiReportAndArmy(){
		
		List<ESFOrganization> u = new ArrayList<ESFOrganization>();
		Session session = null;
		
		
		try {
			
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ALL_AFFILIATION_CONI_REPORT);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFOrganization", ESFOrganizationImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			u = (List<ESFOrganization>) q.list();
			
			if(u==null){
				u = new ArrayList<ESFOrganization>();
			}
			return u;
			
		}
		catch (Exception e) {
			_log.error("findAllAffilationConiReportAndArmy e="+e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	
	
public List<ESFOrganization> findNewAffilationConiReportAndArmy( int year){
		
		List<ESFOrganization> u = new ArrayList<ESFOrganization>();
		Session session = null;
		
		try {
			
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_NEW_AFFILIATION_CONI_REPORT);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFOrganization", ESFOrganizationImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(year);
			
			u = (List<ESFOrganization>) q.list();
			
			if(u==null){
				u = new ArrayList<ESFOrganization>();
			}
			return u;
		}
		catch (Exception e) {
			_log.error("findNewAffilationConiReportAndArmy e="+e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}



	public static final String FIND_ALL_AFFILIATION_CONI_REPORT= ESFOrganizationFinder.class.getName() +".findAllAffilationConiReport";
	public static final String FIND_NEW_AFFILIATION_CONI_REPORT = ESFOrganizationFinder.class.getName() +".findNewAffilationConiReport";
}
