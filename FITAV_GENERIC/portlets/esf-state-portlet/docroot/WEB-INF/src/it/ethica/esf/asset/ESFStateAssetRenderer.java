package it.ethica.esf.asset;


import it.ethica.esf.model.ESFState;
import it.ethica.esf.permission.ESFStatePermission;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class ESFStateAssetRenderer extends BaseAssetRenderer {
	
	private ESFState _esfState;
	
	public ESFStateAssetRenderer (ESFState esfState) {
		
		_esfState = esfState;
	}
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {
		
		long esfStateId = _esfState.getEsfStateId();
		
		boolean contains = false;
		
		try {
			contains = ESFStatePermission.contains(permissionChecker,
					esfStateId, ActionKeys.UPDATE);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}
		
		return contains;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		
		long esfStateId = _esfState.getEsfStateId();
		
		boolean contains = false;
		
		try {
			contains = ESFStatePermission.contains(permissionChecker,
					esfStateId, ActionKeys.VIEW);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}
		
		return contains;
	}

	@Override
	public String getClassName() {
		return ESFState.class.getName();
	}

	@Override
	public long getClassPK() {
		return _esfState.getEsfStateId();
	}

	@Override
	public long getGroupId() {
		return _esfState.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return "Name: " + _esfState.getEsfName();
	}

	@Override
	public String getTitle(Locale locale) {
		return _esfState.getEsfDescription();
	}

	@Override
	public long getUserId() {
		
		return _esfState.getUserId();
	}

	@Override
	public String getUserName() {
		return _esfState.getUserName();
	}

	@Override
	public String getUuid() {
		return _esfState.getUuid();
	}

	@Override
	public String render(RenderRequest renderRequest,
			RenderResponse renderResponse, String template) throws Exception {
		
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			renderRequest.setAttribute("esfState", _esfState);

			return "/html/esfstate/" + template + ".jsp";
		}
		else {
			return null;
		}
	}
	
	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {

		return themeDisplay.getURLPortal()
				+ "/esf-state-portlet/icon.png";

	}
	
	private Log _log;

}
