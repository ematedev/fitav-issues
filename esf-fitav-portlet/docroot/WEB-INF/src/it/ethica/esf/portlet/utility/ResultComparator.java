package it.ethica.esf.portlet.utility;

import it.ethica.esf.model.ESFResult;

import java.util.Comparator;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class ResultComparator implements Comparator<ESFResult>{
	
	public int compare(ESFResult r1, ESFResult r2){
		
		try {
			if(Validator.isNull(r1.getStartdDate()) || Validator.isNull(r1.getEndDate())){
				return 0;
			}else{
			
				if(r1.getStartdDate() == r2.getEndDate()){
					return 0; 
				}else if(r1.getStartdDate().before(r2.getEndDate())){
					return 1; 
				}else{
					return -1;
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			_log.error("errore comparator date");
			return 0;
		}
			
	}
	private static Log _log = LogFactoryUtil.getLog(ResultComparator.class);
}
