package it.ethica.esf.service.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFResult;
import it.ethica.esf.model.impl.ESFResultImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class ESFResultFinderImpl extends BasePersistenceImpl<ESFResult> implements ESFResultFinder{
	
	private static Log _log = LogFactoryUtil.getLog(ESFResultFinderImpl.class);
	
	public static final String FIND_DESCR_RANKING = ESFResultFinder.class.getName() + ".findDescRanking";
	public static final String FIND_RESULT_BY_MATCHID_DESCRANKING = ESFResultFinder.class.getName() + ".findResultByMatchIdDescRanking";
	
	
	public ArrayList<String> findDescRanking(long matchId) {
		
		List<String> descRanking = new ArrayList<String>();
		
		Session session = null;
		
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_DESCR_RANKING);
			
			SQLQuery q = session.createSQLQuery(sql);
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(matchId);
			
			descRanking = q.list();
			
			if(Validator.isNull(descRanking)){
				descRanking = new ArrayList<String>();
			}
			return (ArrayList<String>) descRanking;
		}
		catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		
		return new ArrayList<String>();
		
	}
	
	public List<ESFResult> findResultByMatchIdDescRanking(long matchId, String descRanking){
		
		List<ESFResult> results = new ArrayList<ESFResult>();
		
		Session session = null;
		
		try {
			
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_RESULT_BY_MATCHID_DESCRANKING);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ESFResult", ESFResultImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(matchId);
			qPos.add("%"+descRanking+"%");
			
			results = q.list();
			
			if(Validator.isNull(results)){
				results = new ArrayList<ESFResult>();
			}
			
			return results;
		}
		catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		}finally {
			closeSession(session);
		}
		
		return new ArrayList<ESFResult>();
		
	}

}
