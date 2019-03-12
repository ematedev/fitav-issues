package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFInstructsShootingDirector;
import it.ethica.esf.model.impl.ESFInstructsShootingDirectorImpl;
import it.ethica.esf.service.ESFInstructsShootingDirectorLocalServiceUtil;

import java.text.ParseException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class ESFInstructsShootingDirectorPortlet extends MVCPortlet{
	
	public void deleteESFISTRShdr(ActionRequest actionRequest, ActionResponse actionResponse)
					throws PortalException, SystemException, ParseException {

		ESFInstructsShootingDirector istrShDr = new ESFInstructsShootingDirectorImpl();
		long ishDrId = ParamUtil.getLong(actionRequest, "ishDrId");
		
		String mvcPath = "/html/esfinstructsshootingdirector/view.jsp";
		
		if(0 < ishDrId){
			istrShDr = ESFInstructsShootingDirectorLocalServiceUtil.fetchESFInstructsShootingDirector(ishDrId);
			ESFInstructsShootingDirectorLocalServiceUtil.deleteESFInstructsShootingDirector(istrShDr);
		}else{
			SessionErrors.add(actionRequest, "error-delete-IshDr");
		}
		
		actionResponse.setRenderParameter("mvcPath", mvcPath);
	}
	
	public void addIstrShooterDirector(ActionRequest actionRequest, ActionResponse actionResponse)
					throws PortalException, SystemException, ParseException {
		
		String 	mvcPath = ParamUtil.getString(actionRequest, "mvcPath");
		long ishDrId = ParamUtil.getLong(actionRequest, "ishDrId");
		String descIstr = ParamUtil.getString(actionRequest, "descIstr");
		String codeIstr = ParamUtil.getString(actionRequest, "codeIstr");
		
		ESFInstructsShootingDirector istShDr = new ESFInstructsShootingDirectorImpl();
		
		if(0 < ishDrId){
			
			istShDr = ESFInstructsShootingDirectorLocalServiceUtil.fetchESFInstructsShootingDirector(ishDrId);
			
			istShDr.setEsfInstructsShootingDirectorCode(codeIstr);
			istShDr.setEsfInstructsShootingDirectorDesc(descIstr);
			ESFInstructsShootingDirectorLocalServiceUtil.updateESFInstructsShootingDirector(istShDr);
			
		}else{
			ishDrId = CounterLocalServiceUtil.increment(ESFInstructsShootingDirector.class.getName());
			istShDr.setEsfInstructsShootingDirectorId(ishDrId);
			istShDr.setEsfInstructsShootingDirectorCode(codeIstr);
			istShDr.setEsfInstructsShootingDirectorDesc(descIstr);
			ESFInstructsShootingDirectorLocalServiceUtil.updateESFInstructsShootingDirector(istShDr);
		}
		
		actionResponse.setRenderParameter("mvcPath", mvcPath);
	}
	
	
}
