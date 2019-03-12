package it.ethica.esf.service.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.impl.ESFMatchImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ESFMatchFinderImpl  extends BasePersistenceImpl<ESFMatch>
	implements ESFMatchFinder{
	
	public List<ESFMatch> findDelegationActiveMatch(long esfUserId){
		
		Session session = null;
		try {
		session = openSession();
		
		String sql = CustomSQLUtil.get(FIND_DELEGATION_ACTIVE_MATCH);

		SQLQuery q = session.createSQLQuery(sql);
		q.addEntity("ESFMatch", ESFMatchImpl.class);
		
		QueryPos qPos = QueryPos.getInstance(q);
		
		qPos.add(esfUserId);
		
		//List<ESFCard> u= (List<ESFCard>) QueryUtil.list(q, getDialect(), 0, -1);
		List<ESFMatch> u= (List<ESFMatch>) q.list();
		if(u==null){
			u = new ArrayList<ESFMatch>();
		}
		return u;
		}
		catch (Exception e) {
			try {
				throw new SystemException(e);
			}
			catch (SystemException se) {
				se.printStackTrace();
			}
		}
		finally {
			closeSession(session);
		}
		return null;
		
	}
	
	public static final String FIND_DELEGATION_ACTIVE_MATCH= ESFCardFinder.class.getName() +".findDelegationActiveMatch";
}
