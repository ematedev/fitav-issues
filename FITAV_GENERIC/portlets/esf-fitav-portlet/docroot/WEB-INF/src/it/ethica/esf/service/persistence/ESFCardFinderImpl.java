package it.ethica.esf.service.persistence;

import java.util.ArrayList;
import java.util.List;

import it.ethica.esf.migration.util.ESFKeys;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.impl.ESFCardImpl;
import it.ethica.esf.model.impl.ESFUserImpl;
import it.ethica.esf.service.impl.ESFCardLocalServiceImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ESFCardFinderImpl extends BasePersistenceImpl<ESFCard> implements ESFCardFinder {

	public List<ESFCard> findCardByOrganizationId(long orgId) {

		int begin = 0;
		int end = Integer.MAX_VALUE;
		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_CARD);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ESFCard", ESFCardImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add("%" + orgId + "/%");

			// List<ESFCard> u= (List<ESFCard>) QueryUtil.list(q, getDialect(),
			// 0, -1);
			List<ESFCard> u = (List<ESFCard>) q.list();
			if (u == null) {
				u = new ArrayList<ESFCard>();
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

	public List<ESFCard> findCardByOrganizationIdFree(long orgId) {

		int begin = 0;
		int end = Integer.MAX_VALUE;
		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_CARD_FREE);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ESFCard", ESFCardImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add("%" + orgId + "/%");

			// List<ESFCard> u= (List<ESFCard>) QueryUtil.list(q, getDialect(),
			// 0, -1);
			List<ESFCard> u = (List<ESFCard>) q.list();
			if (u == null) {
				u = new ArrayList<ESFCard>();
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

	public List<ESFCard> findFreeCardsInt() {

		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_FREE_CARD);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ESFCard", ESFCardImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			List<ESFCard> u = (List<ESFCard>) q.list();
			if (u == null) {
				u = new ArrayList<ESFCard>();
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

	public List<ESFCard> getFreeCards() {

		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_FREE_CARD);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ESFCard", ESFCardImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			List<ESFCard> u = (List<ESFCard>) q.list();
			if (u == null) {
				u = new ArrayList<ESFCard>();
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

	public List<ESFCard> findFreeCards(int begin, int end) {

		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_FREE_CARD);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ESFCard", ESFCardImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			// List<ESFCard> u= (List<ESFCard>) q.list();
			List<ESFCard> u = (List<ESFCard>) QueryUtil.list(q, getDialect(), begin, end);
			if (u == null) {
				u = new ArrayList<ESFCard>();
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

	public List<ESFCard> findActualUserCards(long esfUserId) {

		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_ACTUAL_USER_CARDS);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ESFCard", ESFCardImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(esfUserId);

			List<ESFCard> u = (List<ESFCard>) q.list();
			if (u == null) {
				u = new ArrayList<ESFCard>();
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

	public List<ESFCard> findCardByUserState(int state, long userId) {
		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_CARD_USER_STATE);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFCard", ESFCardImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(state);
			qPos.add(userId);
			List<ESFCard> cards = (List<ESFCard>) q.list();
			if (cards == null) {
				cards = new ArrayList<ESFCard>();
			}
			return cards;
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
	
	public List<ESFCard> findCardByUser(long userId) {
		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_LAST_CARD_USER);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFCard", ESFCardImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(userId);
			qPos.add(userId);
			List<ESFCard> cards = (List<ESFCard>) q.list();
			if (cards == null) {
				cards = new ArrayList<ESFCard>();
			}
			return cards;
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

	public List<ESFCard> findCardsByOrgId(long esforgId) {

		Session session = null;
		try {
			session = openSession();
			int state = ESFKeys.ESFStateType.ENABLE;
			String sql = CustomSQLUtil.get(FIND_CARDS_BY_ORG_ID);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ESFCard", ESFCardImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(state);
			qPos.add(esforgId);

			List<ESFCard> u = (List<ESFCard>) q.list();
			if (u == null) {
				u = new ArrayList<ESFCard>();
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
	
	public ESFCard findShooterByCardActiveInMatch(String cardCode, String startDate, String endDate) {
		
		ESFCard card = new ESFCardImpl();

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_SHOOTER_BY_CARD_ACTIVE_IN_MATCH);
			
			sql = sql.replaceAll("%lt;", "<");
			sql = sql.replaceAll("&gt;", ">");
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ESFCard", ESFCardImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(cardCode);
			qPos.add(startDate);
			qPos.add(endDate);
			
			card = (ESFCard) q.uniqueResult();
			
			if(card == null){
				card = new ESFCardImpl();;
			}
			return card;
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
		return null;
		
	}
	
	private static Log _log = LogFactoryUtil.getLog(ESFCardFinderImpl.class);

	public static final String FIND_CARD_USER_STATE = ESFCardFinder.class.getName() + ".findCardByUserState";
	public static final String FIND_LAST_CARD_USER = ESFCardFinder.class.getName() + ".findLastCardByUser";
	public static final String FIND_CARD = ESFCardFinder.class.getName() + ".findCardByOrganizationId";
	public static final String FIND_CARD_FREE = ESFCardFinder.class.getName() + ".findCardByOrganizationIdFree";
	public static final String FIND_FREE_CARD = ESFCardFinder.class.getName() + ".findFreeCards";
	public static final String FIND_ACTUAL_USER_CARDS = ESFCardFinder.class.getName() + ".findActualUserCards";
	public static final String FIND_CARDS_BY_ORG_ID = ESFCardFinder.class.getName() + ".findCardByOrgId";
	public static final String FIND_SHOOTER_BY_CARD_ACTIVE_IN_MATCH = ESFCardFinder.class.getName() + ".findShooterByCardActiveInMatch";
}
