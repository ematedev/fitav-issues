
package it.ethica.esf.service.persistence;

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.impl.ESFUserImpl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ESFUserFinderImpl extends BasePersistenceImpl<ESFUser>
	implements ESFUserFinder {

	public List<ESFUser> findShooter(
		String firstName, String lastName, long orgId, String cardCode,int state,
		int begin, int end) {
		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_SHOOTER);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(lastName+"%");
			qPos.add(firstName+"%");
			qPos.add("%"+orgId+"%");
			qPos.add(state);
			qPos.add(cardCode+"%");
			List<ESFUser> u= (List<ESFUser>) QueryUtil.list(q, getDialect(), begin, end);
			if(u==null){
				u = new ArrayList<ESFUser>();
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
	
	
	public List<ESFUser> findAllShooter(
			String firstName, String lastName, long orgId, String cardCode,
			int begin, int end) {
			Session session = null;
			try {
				session = openSession();

				String sql = CustomSQLUtil.get(FIND_ALL_SHOOTER);

				SQLQuery q = session.createSQLQuery(sql);
				q.setCacheable(false);
				q.addEntity("ESFUser", ESFUserImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add(lastName+"%");
				qPos.add(firstName+"%");
				qPos.add("%"+orgId+"%");
				qPos.add(cardCode+"%");
				List<ESFUser> u= (List<ESFUser>) QueryUtil.list(q, getDialect(), begin, end);
				if(u==null){
					u = new ArrayList<ESFUser>();
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
	
	public List<ESFUser> findShooterFiscalCode(
		String firstName, String lastName, long orgId, String fiscalCode,int state,
		int begin, int end) {
		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_SHOOTER_FISCALCODE);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(lastName+"%");
			qPos.add(firstName+"%");
			qPos.add(fiscalCode+"%");
			qPos.add("%"+orgId+"%");
			qPos.add(state);
			List<ESFUser> u= (List<ESFUser>) QueryUtil.list(q, getDialect(), begin, end);
			if(u==null){
				u = new ArrayList<ESFUser>();
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

	public List<ESFUser> findShooterFiscalRole(
		long organizationId, int stateCard, long esfUserRoleId,
		int stateUser, int start, int end) {
		
		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_SHOOTER_ROLE);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add("%"+organizationId+"%");
			qPos.add(stateCard);
			qPos.add(stateUser);
			qPos.add(esfUserRoleId);
			
			List<ESFUser> u= (List<ESFUser>) QueryUtil.list(q, getDialect(), start, end);
			if(u==null){
				u = new ArrayList<ESFUser>();
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
	
	public List<ESFUser> findShooterFiscalRoleName(String name, String lastName,
			long organizationId, int stateCard, long esfUserRoleId,
			int stateUser, int start, int end) {
			
			Session session = null;
			try {
				session = openSession();

				String sql = CustomSQLUtil.get(FIND_SHOOTER_ROLE_NAME);

				SQLQuery q = session.createSQLQuery(sql);
				q.setCacheable(false);
				q.addEntity("ESFUser", ESFUserImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add("%"+name+"%");
				qPos.add("%"+lastName+"%");
				qPos.add(esfUserRoleId);
				qPos.add(organizationId);
				List<ESFUser> u= (List<ESFUser>) QueryUtil.list(q, getDialect(), start, end);
				if(u==null){
					u = new ArrayList<ESFUser>();
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
	
	
	public List<ESFUser> countShooterFiscalRoleName(String name, String lastName,
			long organizationId, int stateCard, long esfUserRoleId,
			int stateUser) {
			
			Session session = null;
			try {
				session = openSession();

				String sql = CustomSQLUtil.get(FIND_SHOOTER_ROLE_NAME);

				SQLQuery q = session.createSQLQuery(sql);
				q.setCacheable(false);
				q.addEntity("ESFUser", ESFUserImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add("%"+name+"%");
				qPos.add("%"+lastName+"%");
				qPos.add(esfUserRoleId);
				qPos.add(organizationId);
				
				
				List<ESFUser> u= (List<ESFUser>) q.list();
				if(u==null){
					u = new ArrayList<ESFUser>();
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
	
	
	
	public List<ESFUser> findShooterRoleAssignedName(String name, String lastName,
			long organizationId, long esfUserRoleId, int start, int end) {
			
			Session session = null;
			try {
				session = openSession();

				String sql = CustomSQLUtil.get(FIND_SHOOTER_ROLE_ASSIGNED_NAME);

				SQLQuery q = session.createSQLQuery(sql);
				q.setCacheable(false);
				q.addEntity("ESFUser", ESFUserImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add("%"+name+"%");
				qPos.add("%"+lastName+"%");
				qPos.add(esfUserRoleId);
				qPos.add(organizationId);
				
				List<ESFUser> u= (List<ESFUser>) QueryUtil.list(q, getDialect(), start, end);
				if(u==null){
					u = new ArrayList<ESFUser>();
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
	
	public List<ESFUser> countShooterRoleAssignedName(String name, String lastName,
			long organizationId, long esfUserRoleId) {
			
			Session session = null;
			try {
				session = openSession();

				String sql = CustomSQLUtil.get(FIND_SHOOTER_ROLE_ASSIGNED_NAME);

				SQLQuery q = session.createSQLQuery(sql);
				q.setCacheable(false);
				q.addEntity("ESFUser", ESFUserImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add("%"+name+"%");
				qPos.add("%"+lastName+"%");
				qPos.add(esfUserRoleId);
				qPos.add(organizationId);
				
				List<ESFUser> u= (List<ESFUser>) q.list();
				if(u==null){
					u = new ArrayList<ESFUser>();
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
	
	
	public List<ESFUser> countStaffMatch(String name, String lastName, String fiscalcode,
			long matchId, long fitavId) {
			
			Session session = null;
			try {
				session = openSession();

				String sql = CustomSQLUtil.get(FIND_STAFF_MATCHE);

				SQLQuery q = session.createSQLQuery(sql);
				q.setCacheable(false);
				q.addEntity("ESFUser", ESFUserImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add("%"+name+"%");
				qPos.add("%"+lastName+"%");
				qPos.add("%"+fiscalcode+"%");
				qPos.add(fitavId);
				qPos.add(matchId);
				
				List<ESFUser> u= (List<ESFUser>) q.list();
				if(u==null){
					u = new ArrayList<ESFUser>();
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
	
	public List<ESFUser> findStaffMatch(String name, String lastName, String fiscalcode,
			long matchId, long fitavId, int start, int end) {
			
			Session session = null;
			try {
				session = openSession();

				String sql = CustomSQLUtil.get(FIND_STAFF_MATCHE);

				SQLQuery q = session.createSQLQuery(sql);
				q.setCacheable(false);
				q.addEntity("ESFUser", ESFUserImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add("%"+name+"%");
				qPos.add("%"+lastName+"%");
				qPos.add("%"+fiscalcode+"%");
				qPos.add(fitavId);
				qPos.add(matchId);
				
				List<ESFUser> u= (List<ESFUser>) QueryUtil.list(q, getDialect(), start, end);
				if(u==null){
					u = new ArrayList<ESFUser>();
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
	
	
	
	public List<ESFUser> findStaffNormalMatch(String name, String lastName, String fiscalcode,
			long matchId, int start, int end) {
			
			Session session = null;
			try {
				session = openSession();

				String sql = CustomSQLUtil.get(FIND_STAFF_NORMAL_MATCH);

				SQLQuery q = session.createSQLQuery(sql);
				q.setCacheable(false);
				q.addEntity("ESFUser", ESFUserImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add("%"+name+"%");
				qPos.add("%"+lastName+"%");
				qPos.add("%"+fiscalcode+"%");
				qPos.add(matchId);
				
				List<ESFUser> u= (List<ESFUser>) QueryUtil.list(q, getDialect(), start, end);
				if(u==null){
					u = new ArrayList<ESFUser>();
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
	
	public List<ESFUser> countStaffNormalMatch(String name, String lastName, String fiscalcode,
			long matchId) {
			
			Session session = null;
			try {
				session = openSession();

				String sql = CustomSQLUtil.get(FIND_STAFF_NORMAL_MATCH);

				SQLQuery q = session.createSQLQuery(sql);
				q.setCacheable(false);
				q.addEntity("ESFUser", ESFUserImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add("%"+name+"%");
				qPos.add("%"+lastName+"%");
				qPos.add("%"+fiscalcode+"%");
				qPos.add(matchId);
				
				List<ESFUser> u= (List<ESFUser>) q.list();
				if(u==null){
					u = new ArrayList<ESFUser>();
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
	
	public static final String FIND_SHOOTER = ESFUserFinder.class.getName() +".findShooter";
	public static final String FIND_ALL_SHOOTER = ESFUserFinder.class.getName() +".findAllShooter";
	
	public static final String FIND_SHOOTER_FISCALCODE = ESFUserFinder.class.getName() +".findShooterFiscalCode";
	public static final String FIND_SHOOTER_ROLE = ESFUserFinder.class.getName() +".findShooterRole";
	public static final String FIND_SHOOTER_ROLE_NAME = ESFUserFinder.class.getName() +".findShooterRoleName";
	public static final String FIND_SHOOTER_ROLE_ASSIGNED_NAME = ESFUserFinder.class.getName() +".findShooterRoleAssignedName";
	public static final String FIND_STAFF_MATCHE = ESFUserFinder.class.getName() +".findStaffMatch";
	public static final String FIND_STAFF_NORMAL_MATCH = ESFUserFinder.class.getName() +".findStaffNormalMatch";
}
