package it.ethica.esf.service.persistence;


import java.util.ArrayList;
import java.util.List;

import it.ethica.esf.model.ESFShooterAffiliationChrono;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.impl.ESFShooterAffiliationChronoImpl;
import it.ethica.esf.model.impl.ESFUserImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class ESFShooterAffiliationChronoFinderImpl extends BasePersistenceImpl<ESFShooterAffiliationChrono>
	implements ESFShooterAffiliationChronoFinder{
	
	private static Log _log =
					LogFactoryUtil.getLog(ESFShooterAffiliationChronoFinderImpl.class);
	
	public static final String FIND_BY_DATE = ESFShooterAffiliationChronoFinder.class.getName() +".findByDate";
	public static final String SHOOTER_BY_YEAR = ESFShooterAffiliationChronoFinder.class.getName() +".shooterByYear";
	public static final String SHOOTER_THIS_YEAR = ESFShooterAffiliationChronoFinder.class.getName() +".shooterThisYear";
	
	public List<ESFShooterAffiliationChrono> findByData(String data, int start, int end){
		
		Session session = null;
		
		List<ESFShooterAffiliationChrono> u = new ArrayList<ESFShooterAffiliationChrono>();
		
		String year = "";
		String mouth = "";
		String day = "";
		
		String startDay = "";
		String endDay= "";
		
		day = data.substring(0, 2);
		mouth = data.substring(3, 5);
		year = data.substring(6, 10);
		
		startDay=year+"-"+mouth+"-"+day+" 00:00:00";
		endDay=year+"-"+mouth+"-"+day+" 23:59:59";
		
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_DATE);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			
			q.addEntity("ESFShooterAffiliationChrono", ESFShooterAffiliationChronoImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(startDay);
			qPos.add(endDay);
			
			u = (List<ESFShooterAffiliationChrono>) QueryUtil.list(q, getDialect(), start, end);
			
			if(u==null){
				u = new ArrayList<ESFShooterAffiliationChrono>();
			}
			return u;
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			closeSession(session);
		}
		return null;
		
	}
	
	public int findByData(String data){
		
		Session session = null;
		
		int tot = 0;
		
		String year = "";
		String mouth = "";
		String day = "";
		
		String startDay = "";
		String endDay= "";
		
		day = data.substring(0, 2);
		mouth = data.substring(3, 5);
		year = data.substring(6, 10);
		
		startDay=year+"-"+mouth+"-"+day+" 00:00:00";
		endDay=year+"-"+mouth+"-"+day+" 23:59:59";
		
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_DATE);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			
			q.addEntity("ESFShooterAffiliationChrono", ESFShooterAffiliationChronoImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(startDay);
			qPos.add(endDay);
			
			List<ESFShooterAffiliationChrono> u = (List<ESFShooterAffiliationChrono>) q.list();
			
			tot = u.size();
			if(u==null){
				tot = 0;
			}
			return tot;
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			closeSession(session);
		}
		return tot;
		
	}

	public List<ESFShooterAffiliationChrono> shooterThisYear(String startDateStr, String organizationCode){
		List<ESFShooterAffiliationChrono> u = null;
		
		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(SHOOTER_THIS_YEAR);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFShooterAffiliationChrono", ESFShooterAffiliationChronoImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(startDateStr);
			qPos.add(organizationCode);
			
			
			u = (List<ESFShooterAffiliationChrono>) q.list();
			
			if(u==null){
				u = new ArrayList<ESFShooterAffiliationChrono>();
			}
			return u;
		
		}
		catch (Exception e) {
			_log.error("e="+e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<ESFShooterAffiliationChrono> shooterByYear(String startDateStr, String organizationCode){
		List<ESFShooterAffiliationChrono> u = null;
		
		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(SHOOTER_BY_YEAR);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFShooterAffiliationChrono", ESFShooterAffiliationChronoImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(startDateStr);
			qPos.add(organizationCode);
			
			u = (List<ESFShooterAffiliationChrono>) q.list();
			
			if(u==null){
				u = new ArrayList<ESFShooterAffiliationChrono>();
			}
			return u;
		
		}
		catch (Exception e) {
			_log.error("e="+e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}

}
