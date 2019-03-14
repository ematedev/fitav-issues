package it.ethica.esf.service.persistence;

import it.ethica.esf.model.ESFgunUser;
import it.ethica.esf.model.impl.ESFgunUserImpl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ESFgunUserFinderImpl extends BasePersistenceImpl<ESFgunUser>
	implements ESFgunUserFinder{

	public List<ESFgunUser> findRifleByKind_Shooter(String name, String lastName, long kindId,
			int start, int end){
		
		Session session = null;
		try {
			
			
			session = openSession();
			
			if(0 == kindId){
			
			String sql = CustomSQLUtil.get(FIND_RIFLE_BY_SHOOTER);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ESFgunUser", ESFgunUserImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add("%"+name+"%");
			qPos.add("%"+lastName+"%");
			
				List<ESFgunUser> u = (List<ESFgunUser>) QueryUtil.list(q, getDialect(), start, end);
				if(u==null){
					u = new ArrayList<ESFgunUser>();
				}
				
				return u;
			
			}else{
				
				String sql = CustomSQLUtil.get(FIND_RIFLE_BY_KIND_SHOOTER);
				
				SQLQuery q = session.createSQLQuery(sql);
				q.addEntity("ESFgunUser", ESFgunUserImpl.class);
				
				QueryPos qPos = QueryPos.getInstance(q);
				
				qPos.add("%"+name+"%");
				qPos.add("%"+lastName+"%");
				qPos.add(kindId);
				
				List<ESFgunUser> u = (List<ESFgunUser>) QueryUtil.list(q, getDialect(), start, end);
				if(u==null){
					u = new ArrayList<ESFgunUser>();
				}
				
				return u;
			}

		}catch (Exception e) {
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
	
	
	public List<ESFgunUser> findCaneByKind_Shooter(String name, String lastName, long kindId,
			int start, int end){
		
		Session session = null;
		try {
			
			
			session = openSession();
			
			if(0 == kindId){
			
			String sql = CustomSQLUtil.get(FIND_CANE_BY_SHOOTER);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ESFgunUser", ESFgunUserImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add("%"+name+"%");
			qPos.add("%"+lastName+"%");
			
				List<ESFgunUser> u = (List<ESFgunUser>) QueryUtil.list(q, getDialect(), start, end);
				if(u==null){
					u = new ArrayList<ESFgunUser>();
				}
				
				return u;
			
			}else{
				
				String sql = CustomSQLUtil.get(FIND_CANE_BY_KIND_SHOOTER);
				
				SQLQuery q = session.createSQLQuery(sql);
				q.addEntity("ESFgunUser", ESFgunUserImpl.class);
				
				QueryPos qPos = QueryPos.getInstance(q);
				
				qPos.add("%"+name+"%");
				qPos.add("%"+lastName+"%");
				qPos.add(kindId);
				
				List<ESFgunUser> u = (List<ESFgunUser>) QueryUtil.list(q, getDialect(), start, end);
				if(u==null){
					u = new ArrayList<ESFgunUser>();
				}
				
				return u;
			}

		}catch (Exception e) {
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
	
	
	
	public static final String FIND_RIFLE_BY_KIND_SHOOTER= ESFgunUserFinder.class.getName() +".findRifleByKindShooter";
	public static final String FIND_RIFLE_BY_SHOOTER= ESFgunUserFinder.class.getName() +".findRifleByShooter";
	public static final String FIND_CANE_BY_KIND_SHOOTER= ESFgunUserFinder.class.getName() +".findCaneByKindShooter";
	public static final String FIND_CANE_BY_SHOOTER= ESFgunUserFinder.class.getName() +".findCaneByShooter";
	
}
