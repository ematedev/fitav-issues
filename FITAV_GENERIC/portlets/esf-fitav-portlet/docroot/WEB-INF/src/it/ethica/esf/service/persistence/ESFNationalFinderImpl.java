package it.ethica.esf.service.persistence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFNational;
import it.ethica.esf.model.impl.ESFMatchImpl;
import it.ethica.esf.model.impl.ESFNationalImpl;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.util.ESFKeys;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class ESFNationalFinderImpl extends BasePersistenceImpl<ESFNational> implements ESFNationalFinder{
	
	private static Log _log = LogFactoryUtil.getLog(ESFNationalFinderImpl.class);
	
	public static final String FIND_FREE_NATIONAL = ESFNationalFinder.class.getName() + ".findFreeNationalByMatchIdSportTypeId";
	
	
	public List<ESFNational> findFreeNationalByMatchIdSportTypeId(long matchId, long sportTypeId, int begin, int end){
		
		int patecipantType = ESFKeys.ESFNationalDelegationType.SHOOTER;
		
		
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String startDate = "-01-01";
		String endDate = "";
		
		Calendar cal = Calendar.getInstance(); 
		ESFMatch match = new ESFMatchImpl();
		
		
		
		try {
			match = ESFMatchLocalServiceUtil.fetchESFMatch(matchId);
			endDate = match.getEndDate().toString();
		}
		catch (Exception e) {
			// TODO: handle exception
			endDate = sdf.format(cal.getTime());
		}
		
		startDate = String.valueOf(cal.get(Calendar.YEAR))+startDate;
		
		Session session = null;
		
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_FREE_NATIONAL);
			sql = sql.replaceAll("&gt;", ">");
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ESFNational", ESFNationalImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(endDate);
			qPos.add(startDate);
			qPos.add(sportTypeId);
			qPos.add(matchId);
			qPos.add(patecipantType);
			qPos.add(sportTypeId);
			
			List<ESFNational> n = (List<ESFNational>) QueryUtil.list(q, getDialect(), begin, end);
			if(Validator.isNull(n)){
				n = new ArrayList<ESFNational>();
			}
			return n;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

}
