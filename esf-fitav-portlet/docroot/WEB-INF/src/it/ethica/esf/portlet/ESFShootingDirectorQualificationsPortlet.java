package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFShootingDirector;
import it.ethica.esf.model.ESFShootingDirectorQualification;
import it.ethica.esf.model.ESFShootingDirectorQualificationSoap;
import it.ethica.esf.model.impl.ESFShootingDirectorImpl;
import it.ethica.esf.model.impl.ESFShootingDirectorQualificationImpl;
import it.ethica.esf.service.ESFShootingDirectorLocalServiceUtil;
import it.ethica.esf.service.ESFShootingDirectorQualificationLocalServiceUtil;

import java.text.ParseException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class ESFShootingDirectorQualificationsPortlet extends MVCPortlet{
	
	public void deleteESFShdrQ (ActionRequest actionRequest, ActionResponse actionResponse)
					throws PortalException, SystemException, ParseException {
		
		ESFShootingDirectorQualification shDtq = new ESFShootingDirectorQualificationImpl();
		long shDrqId = ParamUtil.getLong(actionRequest, "shDrqId");
		
		
		String 	mvcPath = "/html/esfshootingdirectorqualifications/view.jsp";
		
		
		if(0 < shDrqId){
			shDtq = ESFShootingDirectorQualificationLocalServiceUtil.fetchESFShootingDirectorQualification(shDrqId);
			ESFShootingDirectorQualificationLocalServiceUtil.deleteESFShootingDirectorQualification(shDtq);
		}else {
			SessionErrors.add(actionRequest, "error-delete-shDrq");
		}
		
		actionResponse.setRenderParameter("mvcPath", mvcPath);
	}
	
	public void addShooterDirectorQualifications(ActionRequest actionRequest, ActionResponse actionResponse)
					throws PortalException, SystemException, ParseException {
		
		String 	mvcPath = "/html/esfshootingdirectorqualifications/view.jsp";
		long shDrqId = ParamUtil.getLong(actionRequest, "shDrqId");
		String shDrqDesc = ParamUtil.getString(actionRequest, "shDrqDesc");
		ESFShootingDirectorQualification shDtq = new ESFShootingDirectorQualificationImpl();
		
		
		if(0 < shDrqId){
			shDtq = ESFShootingDirectorQualificationLocalServiceUtil.fetchESFShootingDirectorQualification(shDrqId);
			shDtq.setEsfShootingDirectorQualificationDesc(shDrqDesc);
			ESFShootingDirectorQualificationLocalServiceUtil.updateESFShootingDirectorQualification(shDtq);
		}else{
			shDrqId = CounterLocalServiceUtil.increment(ESFShootingDirectorQualification.class.getName());
			shDtq.setEsfShootingDirectorQualificationId(shDrqId);
			shDtq.setEsfShootingDirectorQualificationDesc(shDrqDesc);
			shDtq.setEsfShootingDirectorQualificationId(shDrqId);
			ESFShootingDirectorQualificationLocalServiceUtil.addESFShootingDirectorQualification(shDtq);
			
			
		}
		
		
		actionResponse.setRenderParameter("mvcPath", mvcPath);
		
	}

}
