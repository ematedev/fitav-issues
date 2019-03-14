package it.ethica.esf.service.persistence;

import java.util.ArrayList;
import java.util.List;

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.model.impl.ESFUserESFUserRoleImpl;
import it.ethica.esf.model.impl.ESFUserImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ESFUserESFUserRoleFinderImpl extends BasePersistenceImpl<ESFUserESFUserRole>
	implements  ESFUserESFUserRoleFinder{
	
	public List<ESFUserESFUserRole> findStaffRole(long userId){
		
		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_STAFF_ROLE);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUserESFUserRole", ESFUserESFUserRoleImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);
			
			List<ESFUserESFUserRole> u= (List<ESFUserESFUserRole>) q.list();
			if(u==null){
				u = new ArrayList<ESFUserESFUserRole>();
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
	
	public List<ESFUserESFUserRole> findESFUserESFRoleByO_R_D_NOL(long esfOrganizationId,long esfUserId, java.sql.Date date)
	{
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_RoleByO_R_D_NOL);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ESFUserESFUserRole", ESFUserESFUserRoleImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(esfOrganizationId);
			qPos.add(esfUserId);
			qPos.add(date);
			
			List<ESFUserESFUserRole> u= (List<ESFUserESFUserRole>) q.list();
			if(u==null){
				u = new ArrayList<ESFUserESFUserRole>();
			}
			return u;
		} catch (Exception e) 
			{
				e.printStackTrace();
			}
		finally {
			closeSession(session);
		}
		return null;
	}
	public static final String FIND_RoleByO_R_D_NOL=ESFUserESFUserRoleFinder.class.getName() +".findESFUserESFRoleByO_R_D_NOL";
	public static final String FIND_STAFF_ROLE = ESFUserESFUserRoleFinder.class.getName() +".findStaffRole";
}
