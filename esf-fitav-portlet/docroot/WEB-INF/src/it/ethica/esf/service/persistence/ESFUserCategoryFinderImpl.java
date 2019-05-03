package it.ethica.esf.service.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserCategory;
import it.ethica.esf.model.impl.ESFUserCategoryImpl;
import it.ethica.esf.model.impl.ESFUserImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class ESFUserCategoryFinderImpl extends BasePersistenceImpl<ESFUserCategory>
	implements ESFUserCategoryFinder{
	
	private static Log _log =
					LogFactoryUtil.getLog(ESFUserFinderImpl.class);
	
	public List<ESFUserCategory> findYouthNotPromoved(int year){
		Calendar calendar = GregorianCalendar.getInstance();
		int actualYear = calendar.get( Calendar.YEAR );
		
		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_YOUTH_NOT_PROMOVED);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUserCategory", ESFUserCategoryImpl.class);
			
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(year);
			qPos.add(actualYear);
			
			List<ESFUserCategory> u = (List<ESFUserCategory>) q.list();
			if(u==null){
				u = new ArrayList<ESFUserCategory>();
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
	
	public static final String FIND_YOUTH_NOT_PROMOVED = ESFUserCategoryFinder.class.getName() +".findYouthNotPromoved";
}
