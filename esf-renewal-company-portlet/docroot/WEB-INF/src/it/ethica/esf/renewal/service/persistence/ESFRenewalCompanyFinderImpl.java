
package it.ethica.esf.renewal.service.persistence;

import it.ethica.esf.renewal.model.ESFRenewalCompany;
import it.ethica.esf.renewal.model.impl.ESFRenewalCompanyImpl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ESFRenewalCompanyFinderImpl
	extends BasePersistenceImpl<ESFRenewalCompany>
	implements ESFRenewalCompanyFinder {

	@Override
	public List<ESFRenewalCompany> getESFRenewalCompanyByN_C_R_Y(
		String name, String code, String region, int year, int start, int end) {

		Session session = null;
		try {
			session = openSession();

			String sql =
				CustomSQLUtil.get(GET_ESFRENEWALCOMPANY_BY_N_C_R_Y);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity(
				ESFRenewalCompanyImpl.TABLE_NAME, ESFRenewalCompanyImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(year);
			qPos.add(StringPool.PERCENT + code + StringPool.PERCENT);
			qPos.add(StringPool.PERCENT + name + StringPool.PERCENT);
			String treepathQuery = StringPool.PERCENT;
			if (Validator.isNotNull(region)) {
				treepathQuery = StringPool.PERCENT + StringPool.SLASH + region + StringPool.SLASH + StringPool.PERCENT;
			}
			qPos.add(treepathQuery);

			return (List<ESFRenewalCompany>) QueryUtil.list(
				q, getDialect(), start, end);
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

	public static final String GET_ESFRENEWALCOMPANY_BY_N_C_R_Y =
		ESFRenewalCompanyFinder.class.getName() +
			".getESFRenewalCompanyByN_C_R_Y";
}
