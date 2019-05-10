package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFSuspensiveCode;
import it.ethica.esf.model.impl.ESFSuspensiveCodeImpl;
import it.ethica.esf.service.ESFSuspensiveCodeLocalServiceUtil;

import java.text.ParseException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class ESFSuspensiveCodePortlet extends MVCPortlet{
	
	
	public void addSuspensiveCode (ActionRequest actionRequest, ActionResponse actionResponse)
					throws PortalException, SystemException, ParseException {
		
		ESFSuspensiveCode suCode = new ESFSuspensiveCodeImpl();
		long suCodeId = ParamUtil.getLong(actionRequest, "suCodeId");
		String codeSusp= ParamUtil.getString(actionRequest, "codeSusp");
		String descSusp = ParamUtil.getString(actionRequest, "descSusp");
		String 	mvcPath = ParamUtil.getString(actionRequest, "mvcPath");
		
		if(0 < suCodeId){
			suCode = ESFSuspensiveCodeLocalServiceUtil.fetchESFSuspensiveCode(suCodeId);
			suCode.setCode(codeSusp);
			suCode.setDescription(descSusp);
			ESFSuspensiveCodeLocalServiceUtil.updateESFSuspensiveCode(suCode);
		}else{
			suCodeId = CounterLocalServiceUtil.increment(ESFSuspensiveCode.class.getName());
			suCode.setCode(codeSusp);
			suCode.setDescription(descSusp);
			suCode.setEsfSuspensiveCodeId(suCodeId);
			ESFSuspensiveCodeLocalServiceUtil.addESFSuspensiveCode(suCode);
		}
		
		
		actionResponse.setRenderParameter("mvcPath", mvcPath);
		
	}
	
	public void deleteSuspensiveCode (ActionRequest actionRequest, ActionResponse actionResponse)
					throws PortalException, SystemException, ParseException {
		
		String 	mvcPath = ParamUtil.getString(actionRequest, "mvcPath");
		long suCodeId = ParamUtil.getLong(actionRequest, "suCodeId");
		
		if(0 < suCodeId){
			ESFSuspensiveCodeLocalServiceUtil.deleteESFSuspensiveCode(suCodeId);
		}else{
			SessionErrors.add(actionRequest, "error-delete-suCode");
		}
		
		
		
		actionResponse.setRenderParameter("mvcPath", mvcPath);
	}

}
