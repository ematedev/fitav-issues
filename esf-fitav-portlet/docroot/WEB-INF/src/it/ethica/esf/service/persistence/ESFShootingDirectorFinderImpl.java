package it.ethica.esf.service.persistence;


import java.util.ArrayList;
import java.util.List;

import it.ethica.esf.model.ESFRegion;
import it.ethica.esf.model.ESFShootingDirector;
import it.ethica.esf.model.ESFShootingDirectorQualification;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.impl.ESFShootingDirectorImpl;
import it.ethica.esf.model.impl.ESFUserImpl;
import it.ethica.esf.service.ESFRegionLocalServiceUtil;
import it.ethica.esf.service.ESFShootingDirectorQualificationLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.impl.ESFShootingDirectorLocalServiceImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class ESFShootingDirectorFinderImpl extends BasePersistenceImpl<ESFShootingDirector> implements ESFShootingDirectorFinder{
	
	public List<ESFShootingDirector> findShootingDirector(String lastName, String firstName, String cardCode, String regionId,
		long qualificationId, long sportTypeId, int start, int end) throws SystemException{
		
		String regionsId = regionId;
		String qualificationsId = String.valueOf(qualificationId);
		String sportTypesId = String.valueOf(sportTypeId);
		
		
		if("0".equals(regionId)){
			regionsId = findAllRegions();
		}else{
			regionsId = "shDr.regionId = '"+ regionId +"'";
		}
		
		if(0 == qualificationId){
			qualificationsId = findAllShDrQ();
		}else{
			qualificationsId = "shDr.shootingDirectorQualificationId = "+ qualificationId ;
		}
		
		if(0 == sportTypeId){
			sportTypesId = findAllSportType();;

		}else{
			sportTypesId = "shDr.sportTypeId = "+ sportTypeId ;
		}
		
		Session session = null;
		
		try {
			
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_SHOOTINGDIRECTOR);
			sql = StringUtil.replace(sql, "[$REGIONS_IDS$]", regionsId);
			sql = StringUtil.replace(sql, "[$SDQ_IDS$]", qualificationsId);
			sql = StringUtil.replace(sql, "[$ST_IDS$]", sportTypesId);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			
			q.addEntity("ESFShootingDirector", ESFShootingDirectorImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add("%"+lastName.toUpperCase()+"%");
			qPos.add("%"+firstName.toUpperCase()+"%");
			qPos.add("%"+cardCode.toUpperCase()+"%");
			
			
			List<ESFShootingDirector> u = (List<ESFShootingDirector>) QueryUtil.list(q, getDialect(), start, end);
			if(u==null){
				u = new ArrayList<ESFShootingDirector>();
			}
			return u;
			
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
	
	private String findAllRegions() throws SystemException{
		String allRegions = "shDr.regionId = '";
		
		List<ESFRegion> regions = new ArrayList<ESFRegion>();
		regions = ESFRegionLocalServiceUtil.getESFRegions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		for(ESFRegion r :regions){
			allRegions = allRegions + r.getIdRegion() + "' or shDr.regionId = '";
		}
		
		allRegions = allRegions.substring(0, allRegions.length()-21);
		
		return allRegions;
	}
	
	private String findAllShDrQ() throws SystemException{
		String allShDrQ = "shDr.shootingDirectorQualificationId =";
		List<ESFShootingDirectorQualification> shDts = new ArrayList<ESFShootingDirectorQualification>();
		shDts = ESFShootingDirectorQualificationLocalServiceUtil.getESFShootingDirectorQualifications(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		

		for(ESFShootingDirectorQualification s : shDts){
			allShDrQ = allShDrQ + s.getEsfShootingDirectorQualificationId() + " or shDr.shootingDirectorQualificationId = ";
		}
		allShDrQ = allShDrQ.substring(0, allShDrQ.length()- 43);
		
		return allShDrQ;
	}
	
	private String findAllSportType() throws SystemException{
		String allSportType = "shDr.sportTypeId =";
		
		List<ESFSportType> sportTypes = new ArrayList<ESFSportType>();
		sportTypes = ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
		
		for(ESFSportType st : sportTypes){
			allSportType = allSportType + st.getEsfSportTypeId() +" or shDr.sportTypeId =";
		}
		allSportType = allSportType.substring(0,allSportType.length()-21);
		
		
		return allSportType; 
	}
	
	public static final String FIND_SHOOTINGDIRECTOR = ESFShootingDirectorFinder.class.getName() + ".findShootingDirector";
	
	private static Log _log = LogFactoryUtil.getLog(ESFShootingDirectorFinderImpl.class);

}
