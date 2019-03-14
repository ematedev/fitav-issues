
package it.ethica.esf.util;

import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFMatchResult;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.portlet.ESFUserAdminPortlet;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFMatchResultLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.impl.ESFMatchResultLocalServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

public class ExecuteUploadResult implements Runnable {
	private ActionRequest request;
	private ActionResponse response;
	
	
	
	
	public ActionRequest getRequest() {
	
		return request;
	}



	
	public void setRequest(ActionRequest request) {
	
		this.request = request;
	}



	
	public ActionResponse getResponse() {
	
		return response;
	}



	
	public void setResponse(ActionResponse response) {
	
		this.response = response;
	}



	@Override
	public void run() {
		
		String line = "";
		String fileName = ParamUtil.getString(request, "fileName"); 
		String newLine = "";
		
		int permittedRowsCounter = 0;
		
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		
		_log.info("--------esfMatchId="+esfMatchId);
		
		boolean isIndividual = ParamUtil.getBoolean(request, "isIndividual");
		_log.info("----------isIndividual="+isIndividual);
		_log.info("----------fileName="+fileName);
		
		ESFMatch esfMatch = null;
		
		if(isIndividual){
			_log.info("individuale");
			
		}else if(!isIndividual){
			_log.info("a squadre");
		}
		
		try {
			esfMatch = ESFMatchLocalServiceUtil.getESFMatch(esfMatchId);
		} catch (PortalException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (SystemException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		

		if(esfMatch == null){
			return;
		}
		
	//	BufferedReader bufferedReader = null;
	//	File file = new File(fileName);
	/*	try {
			
		}
		finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			}
			catch (IOException e) {
			}
		}*/
		
	}
	private static Log _log = LogFactoryUtil.getLog(ExecuteUploadResult.class);
}
