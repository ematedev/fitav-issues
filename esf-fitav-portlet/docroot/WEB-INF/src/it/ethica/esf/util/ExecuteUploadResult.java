
package it.ethica.esf.util;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;

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
		
		_log.debug("--------esfMatchId="+esfMatchId);
		
		boolean isIndividual = ParamUtil.getBoolean(request, "isIndividual");
		_log.debug("----------isIndividual="+isIndividual);
		_log.debug("----------fileName="+fileName);
		
		ESFMatch esfMatch = null;
		
		if(isIndividual){
			_log.debug("individuale");
			
		}else if(!isIndividual){
			_log.debug("a squadre");
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
