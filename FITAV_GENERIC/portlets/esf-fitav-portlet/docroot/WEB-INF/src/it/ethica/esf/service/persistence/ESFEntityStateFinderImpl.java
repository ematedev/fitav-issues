package it.ethica.esf.service.persistence;

import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.impl.ESFCardImpl;
import it.ethica.esf.model.impl.ESFEntityStateImpl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class ESFEntityStateFinderImpl extends BasePersistenceImpl<ESFEntityState> implements ESFEntityStateFinder{
	
	public List<ESFEntityState> findESShooterLastCardActive(long shooterId) {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_SHOOTER_LAST_CARD_ACTIVE);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ESFEntityState", ESFEntityStateImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(shooterId);

			List<ESFEntityState> u = (List<ESFEntityState>) q.list();
			if (u == null) {
				u = new ArrayList<ESFEntityState>();
			}
			return u;
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
	public static final String FIND_SHOOTER_LAST_CARD_ACTIVE = ESFEntityStateFinder.class.getName() + ".findShooterLastCardActive";

}
