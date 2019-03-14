
package it.ethica.esf.service.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import it.ethica.esf.model.ESFShooterAffiliationChrono;
import it.ethica.esf.model.ESFShootingDirectorQualification;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserCategory;
import it.ethica.esf.model.impl.ESFUserCategoryImpl;
import it.ethica.esf.model.impl.ESFUserImpl;
import it.ethica.esf.service.ESFShootingDirectorQualificationLocalServiceUtil;
import it.ethica.esf.service.impl.ESFUserLocalServiceImpl;
import it.ethica.esf.util.ESFKeys;

public class ESFUserFinderImpl extends BasePersistenceImpl<ESFUser>
	implements ESFUserFinder {

	private static Log _log =
			LogFactoryUtil.getLog(ESFUserFinderImpl.class);
	
	
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
	
	public int countRenwalUser(String thisYear, String lastYear,long orgId){
		int tot = 0;
		
		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_RENEWAL_USER);
			
			sql = sql.replaceAll("%lt;", "<");
			sql = sql.replaceAll("&gt;", ">");
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(thisYear);
			qPos.add(lastYear);
			qPos.add("%/"+orgId+"/%");
			qPos.add("%/"+orgId+"/%");
			qPos.add(thisYear);
			
			List<ESFUser> u= (List<ESFUser>) q.list();
			
			tot = u.size();
			if(u==null){
				tot = 0;
			}
			return tot;
		
		}
		catch (Exception e) {
			_log.info("e="+e);
		}
		finally {
			closeSession(session);
		}
		return 0;
	}
	
	
	public int countNewUser(String thisYear, String lastYear,long orgId){
		int tot = 0;
		
		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_NEW_USER);
			
			sql = sql.replaceAll("%lt;", "<");
			sql = sql.replaceAll("&gt;", ">");
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add("%/"+orgId+"/%");
			qPos.add(thisYear);
			qPos.add(thisYear);
			qPos.add(lastYear);
			qPos.add("%/"+orgId+"/%");
			
			List<ESFUser> u= (List<ESFUser>) q.list();
			tot = u.size();
			if(u==null){
				tot = 0;
			}
			return tot;
		
		}
		catch (Exception e) {
			_log.info("e="+e);
		}
		finally {
			closeSession(session);
		}
		return 0;
	}
	
	public List<ESFUser> findShooterByAss(String firstName, String lastName, long orgId, String cardCode){

		List<ESFUser> u = new ArrayList<ESFUser>();
		Session session = null;
		try {

			session = openSession();
			String sql = CustomSQLUtil.get(SHOOTER_BY_ASSOCIATION);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			firstName = firstName.toUpperCase();
			lastName = lastName.toUpperCase();
			cardCode = cardCode.toUpperCase();

			qPos.add("%/" +String.valueOf(orgId) + "/%");
			qPos.add("%"+firstName+"%");
			qPos.add("%"+lastName+"%");
			qPos.add("%"+cardCode+"%");
			
			u = (List<ESFUser>) q.list();
			
			//u = (List<ESFUser>) QueryUtil.list(q, getDialect(), begin, end);
			
			if(u==null){
				u = new ArrayList<ESFUser>();
			}
			return u;
		
		}
		catch (Exception e) {
			_log.info("findShooterByAss e="+e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<ESFUser> findShooterNotAssociated(String firstName, String lastName, String cardCode){

		List<ESFUser> u = new ArrayList<ESFUser>();
		Session session = null;
		
		Calendar calendar = GregorianCalendar.getInstance();
		String year = String.valueOf(calendar.get( Calendar.YEAR)) ;
		
		
		try {
			
			session = openSession();
			String sql = CustomSQLUtil.get(SHOOTER_NOT_ASSOCIATED);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);
			sql = sql.replaceAll("&gt;", ">");
			
			QueryPos qPos = QueryPos.getInstance(q);
			firstName = firstName.toUpperCase();
			lastName = lastName.toUpperCase();
			cardCode = cardCode.toUpperCase();
			
			qPos.add(year);
			qPos.add("%"+lastName+"%");
			qPos.add("%"+firstName+"%");
			qPos.add("%"+cardCode+"%");
			
			u = (List<ESFUser>) q.list();
			
			if(u==null){
				u = new ArrayList<ESFUser>();
			}
			return u;
			
		}
		catch (Exception e) {
			_log.info("findShooterByAss e="+e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<ESFUser> findNotNationalShooterBySPT(String firstName, String lastName, String cardCode, long sportTypeId,
		int start, int end){
		
		List<ESFUser> u = new ArrayList<ESFUser>();
		Session session = null;
		
		
		try {
			
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_NOT_NATIONAL_SHOOOTER_BY_SPT);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			firstName = firstName.toUpperCase();
			lastName = lastName.toUpperCase();
			cardCode = cardCode.toUpperCase();
			
			qPos.add("%"+firstName+"%");
			qPos.add("%"+lastName+"%");
			qPos.add("%"+cardCode+"%");
			qPos.add(sportTypeId);
			
			u = (List<ESFUser>) QueryUtil.list(q, getDialect(), start, end);
			
			if(u==null){
				u = new ArrayList<ESFUser>();
			}
			return u;
			
		}
		catch (Exception e) {
			_log.info("findShooterByAss e="+e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	public int countNotNationalShooterBySPT(String firstName, String lastName, String cardCode, long sportTypeId){
		
		int tot = 0;
		Session session = null;
		
		
		try {
			
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_NOT_NATIONAL_SHOOOTER_BY_SPT);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			firstName = firstName.toUpperCase();
			lastName = lastName.toUpperCase();
			cardCode = cardCode.toUpperCase();
			
			qPos.add("%"+lastName+"%");
			qPos.add("%"+firstName+"%");
			qPos.add("%"+cardCode+"%");
			qPos.add(sportTypeId);
			
			
			List<ESFUser> u= (List<ESFUser>) q.list();
			tot = u.size();
			if(u==null){
				tot = 0;
			}
			return tot;
			
		}
		catch (Exception e) {
			_log.info("findShooterByAss e="+e);
		}
		finally {
			closeSession(session);
		}
		return tot;
	}
	
	public List<ESFUser> findALLNotNationalShooterBySPT(String firstName, String lastName, String cardCode, long sportTypeId,
		int start, int end){
		
		List<ESFUser> u = new ArrayList<ESFUser>();
		Session session = null;
		
		
		try {
			
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ALL_NOT_NATIONAL_SHOOOTER_BY_SPT);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			firstName = firstName.toUpperCase();
			lastName = lastName.toUpperCase();
			cardCode = cardCode.toUpperCase();
			
			qPos.add("%"+lastName+"%");
			qPos.add("%"+firstName+"%");
			qPos.add("%"+cardCode+"%");
			qPos.add(sportTypeId);
			
			u = (List<ESFUser>) QueryUtil.list(q, getDialect(), start, end);
			
			if(u==null){
				u = new ArrayList<ESFUser>();
			}
			return u;
			
		}
		catch (Exception e) {
			_log.info("findShooterByAss e="+e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	public int countALLNotNationalShooterBySPT(String firstName, String lastName, String cardCode, long sportTypeId){
		
		int tot = 0;
		Session session = null;
		
		
		try {
			
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_ALL_NOT_NATIONAL_SHOOOTER_BY_SPT);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			firstName = firstName.toUpperCase();
			lastName = lastName.toUpperCase();
			cardCode = cardCode.toUpperCase();
			
			qPos.add("%"+firstName+"%");
			qPos.add("%"+lastName+"%");
			qPos.add("%"+cardCode+"%");
			qPos.add(sportTypeId);
			
			
			List<ESFUser> u = (List<ESFUser>) q.list();
			tot = u.size();
			if(u==null){
				tot = 0;
			}
			return tot;
			
		}
		catch (Exception e) {
			_log.info("findShooterByAss e="+e);
		}
		finally {
			closeSession(session);
		}
		return tot;
	}
	
	public List<ESFUser> findDirectorByMatch(String firstName, String lastName, long matchId, long shootingDirectorQualificationId,
		int start, int end){
		
		List<ESFUser> u = new ArrayList<ESFUser>();
		int prtecipantType = ESFKeys.ESFNationalDelegationType.REFEREE;
		String qualificationsId = String.valueOf(shootingDirectorQualificationId);
		Session session = null;
		
		if(0 == shootingDirectorQualificationId){
			try {
				qualificationsId = findAllShDrQ();
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			qualificationsId = "sd.shootingDirectorQualificationId = "+ shootingDirectorQualificationId ;
		}
		try {
			
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_SHOOTING_DIRECTOR_BY_MATCH);
			sql = StringUtil.replace(sql, "[$SDQ_IDS$]", qualificationsId);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			firstName = firstName.toUpperCase();
			lastName = lastName.toUpperCase();
			
			qPos.add("%"+lastName+"%");
			qPos.add("%"+firstName+"%");
			qPos.add(prtecipantType);
			qPos.add(matchId);
			
			u = (List<ESFUser>) QueryUtil.list(q, getDialect(), start, end);
			
			if(u==null){
				u = new ArrayList<ESFUser>();
			}
			return u;
			
		}
		catch (Exception e) {
			_log.info("findShooterByAss e="+e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	public int countDirectorByMatch(String firstName, String lastName, long matchId, long shootingDirectorQualificationId){
		
		int tot = 0;
		List<ESFUser> u = new ArrayList<ESFUser>();
		int prtecipantType = ESFKeys.ESFNationalDelegationType.REFEREE;
		String qualificationsId = String.valueOf(shootingDirectorQualificationId);
		
		Session session = null;
		
		if(0 == shootingDirectorQualificationId){
			try {
				qualificationsId = findAllShDrQ();
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			qualificationsId = "sd.shootingDirectorQualificationId = "+ shootingDirectorQualificationId ;
		}
		
		try {
			
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_SHOOTING_DIRECTOR_BY_MATCH);
			sql = StringUtil.replace(sql, "[$SDQ_IDS$]", qualificationsId);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			firstName = firstName.toUpperCase();
			lastName = lastName.toUpperCase();
			
			qPos.add("%"+lastName+"%");
			qPos.add("%"+firstName+"%");
			qPos.add(prtecipantType);
			qPos.add(matchId);
			
			u = (List<ESFUser>) q.list();
			tot = u.size();
			if(u==null){
				tot = 0;
			}
			return tot;
			
		}
		catch (Exception e) {
			_log.info("findShooterByAss e="+e);
		}
		finally {
			closeSession(session);
		}
		return tot;
	}
	
	/*
	 * 
	 * ricerca per tutte le qualifiche dei direttori di tiro
	 * 
	 */
	
	private String findAllShDrQ() throws SystemException{
		String allShDrQ = "sd.shootingDirectorQualificationId =";
		List<ESFShootingDirectorQualification> shDts = new ArrayList<ESFShootingDirectorQualification>();
		shDts = ESFShootingDirectorQualificationLocalServiceUtil.getESFShootingDirectorQualifications(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		

		for(ESFShootingDirectorQualification s : shDts){
			allShDrQ = allShDrQ + s.getEsfShootingDirectorQualificationId() + " or sd.shootingDirectorQualificationId = ";
		}
		
		allShDrQ = allShDrQ.substring(0, allShDrQ.length()- 41);
		
		return allShDrQ;
	}
	
	/*
	 * 
	 * ricerca dei tiratori in età giovanile ancora non inseriti
	 * 
	 */
	
	public List<ESFUser> findNewYouthShooter(int year){
		
		Session session = null;
		
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_NEW_YOUTH_SHOOTER);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(year);
			
			List<ESFUser> u = (List<ESFUser>) q.list();
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
	/*
	 * ricerca dei giovani per categoria
	 * la categoria tiene già conto del sesso
	 */
	
	public List<ESFUser> findYouthByCategory(long categoryId,int year,
		int start, int end){
		
		List<ESFUser> u = new ArrayList<ESFUser>();
		Session session = null;
		
		
		try {
			
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_YOUTH_BY_CATEGORY);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(year);
			qPos.add(categoryId);
			
			u = (List<ESFUser>) QueryUtil.list(q, getDialect(), start, end);
			
			if(u==null){
				u = new ArrayList<ESFUser>();
			}
			return u;
			
		}
		catch (Exception e) {
			_log.info("findYouthByCategory e="+e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	public List<ESFUser> findYouthByCategoryTotal(long categoryId,int year){
		
		List<ESFUser> u = new ArrayList<ESFUser>();
		Session session = null;
		
		
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_YOUTH_BY_CATEGORY);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(year);
			qPos.add(categoryId);
			
			u = (List<ESFUser>) QueryUtil.list(q, getDialect(), 0, Integer.MAX_VALUE);
			
			if(u==null){
				u = new ArrayList<ESFUser>();
			}
			return u;
			
		}
		catch (Exception e) {
			_log.info("findYouthByCategory e="+e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	/*
	 * RICERCA TUTTI I TIRATORI DELLA SOCIETA' NON MEMBRI DEL CONSIGLIO DIRETTIVO
	 */
	
	public List<ESFUser> findNotBDOMemberByAssociatioId(String lastName, String firstName,long associationId,
		int start, int end){
		
		List<ESFUser> u = new ArrayList<ESFUser>();
		Session session = null;
		
		
		try {
			
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_NOT_BDO_MEMBER_BY_ASSOCIATIONID);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			firstName = firstName.toUpperCase();
			lastName = lastName.toUpperCase();
			
			qPos.add("%"+lastName+"%");
			qPos.add("%"+firstName+"%");
			qPos.add(associationId);
			qPos.add(associationId);
			
			u = (List<ESFUser>) QueryUtil.list(q, getDialect(), start, end);
			
			if(u==null){
				u = new ArrayList<ESFUser>();
			}
			return u;
			
		}
		catch (Exception e) {
			_log.info("findBDO e="+e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	public List<ESFUser> countNotBDOMemberByAssociatioId(String lastName, String firstName,long associationId){
		
		List<ESFUser> u = new ArrayList<ESFUser>();
		Session session = null;
		
		
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_NOT_BDO_MEMBER_BY_ASSOCIATIONID);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			firstName = firstName.toUpperCase();
			lastName = lastName.toUpperCase();
			
			qPos.add("%"+lastName+"%");
			qPos.add("%"+firstName+"%");
			qPos.add(associationId);
			qPos.add(associationId);
			
			u = (List<ESFUser>) q.list();
			
			if(u==null){
				u = new ArrayList<ESFUser>();
			}
			return u;
			
		}
		catch (Exception e) {
			_log.info("findYouthByCategory e="+e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	/*
	 * 
	 * Ricerca tiratori associati per nome, cognome, tessera e società
	 * 
	 */
	
	public List<ESFUser> findAssociatedShooterOrganization(String lastName, String firstName, String card,long associationId,
		int start, int end){
		
		List<ESFUser> u = new ArrayList<ESFUser>();
		Session session = null;
		
		
		try {
			
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ASSOCIATED_SHOOTER_ORGANIZATION);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			firstName = firstName.toUpperCase();
			lastName = lastName.toUpperCase();
			card = card.toUpperCase();
			
			qPos.add(associationId);
			qPos.add("%"+firstName+"%");
			qPos.add("%"+lastName+"%");
			qPos.add("%"+card+"%");
			
			u = (List<ESFUser>) QueryUtil.list(q, getDialect(), start, end);
			
			if(u==null){
				u = new ArrayList<ESFUser>();
			}
			return u;
			
		}
		catch (Exception e) {
			_log.info("findAssociatedShooterOrganization e="+e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<ESFUser> countAssociatedShooterOrganization(String lastName, String firstName,String card,long associationId){
		
		List<ESFUser> u = new ArrayList<ESFUser>();
		Session session = null;
		
		try {
			
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ASSOCIATED_SHOOTER_ORGANIZATION);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUser", ESFUserImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			firstName = firstName.toUpperCase();
			lastName = lastName.toUpperCase();
			card = card.toUpperCase();
			
			qPos.add(associationId);
			qPos.add("%"+firstName+"%");
			qPos.add("%"+lastName+"%");
			qPos.add("%"+card+"%");
			
			u = (List<ESFUser>) q.list();
			
			if(u==null){
				u = new ArrayList<ESFUser>();
			}
			return u;
			
		}
		catch (Exception e) {
			_log.info("countAssociatedShooterOrganization e="+e);
		}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//////////////////////////////////////////////////////////
	
	public static final String FIND_SHOOTER = ESFUserFinder.class.getName() +".findShooter";
	public static final String FIND_ALL_SHOOTER = ESFUserFinder.class.getName() +".findAllShooter";
	public static final String FIND_SHOOTER_FISCALCODE = ESFUserFinder.class.getName() +".findShooterFiscalCode";
	public static final String FIND_SHOOTER_ROLE = ESFUserFinder.class.getName() +".findShooterRole";
	public static final String FIND_SHOOTER_ROLE_NAME = ESFUserFinder.class.getName() +".findShooterRoleName";
	public static final String FIND_SHOOTER_ROLE_ASSIGNED_NAME = ESFUserFinder.class.getName() +".findShooterRoleAssignedName";
	public static final String FIND_STAFF_MATCHE = ESFUserFinder.class.getName() +".findStaffMatch";
	public static final String FIND_STAFF_NORMAL_MATCH = ESFUserFinder.class.getName() +".findStaffNormalMatch";
	public static final String COUNT_RENEWAL_USER = ESFUserFinder.class.getName() +".countRenewalUser";
	public static final String COUNT_NEW_USER = ESFUserFinder.class.getName() +".countNewUser";
	public static final String SHOOTER_BY_YEAR = ESFUserFinder.class.getName() +".shooterByYear";
	public static final String SHOOTER_THIS_YEAR = ESFUserFinder.class.getName() +".shooterThisYear";
	public static final String SHOOTER_BY_ASSOCIATION = ESFUserFinder.class.getName() +".findShooterByAss";
	public static final String SHOOTER_NOT_ASSOCIATED = ESFUserFinder.class.getName() +".findShooterNotAssociated";
	public static final String FIND_NOT_NATIONAL_SHOOOTER_BY_SPT = ESFUserFinder.class.getName() +".findNotNationalShooterBySPT";
	public static final String COUNT_NOT_NATIONAL_SHOOOTER_BY_SPT = ESFUserFinder.class.getName() +".countNotNationalShooterBySPT";
	public static final String FIND_ALL_NOT_NATIONAL_SHOOOTER_BY_SPT = ESFUserFinder.class.getName() +".findALLNotNationalShooterBySPT";
	public static final String COUNT_ALL_NOT_NATIONAL_SHOOOTER_BY_SPT = ESFUserFinder.class.getName() +".countALLNotNationalShooterBySPT";
	public static final String FIND_SHOOTING_DIRECTOR_BY_MATCH = ESFUserFinder.class.getName() +".findShootingDirectorByMatch";
	public static final String FIND_NEW_YOUTH_SHOOTER = ESFUserFinder.class.getName() +".findNewYouthShooter";
	public static final String FIND_YOUTH_BY_CATEGORY = ESFUserFinder.class.getName() +".findYouthByCategory";
	public static final String FIND_NOT_BDO_MEMBER_BY_ASSOCIATIONID = ESFUserFinder.class.getName() +".findNotBDOMemberByAssociatioId";
	public static final String FIND_ASSOCIATED_SHOOTER_ORGANIZATION = ESFUserFinder.class.getName() +".findAssociatedShooterOrganization";
}
