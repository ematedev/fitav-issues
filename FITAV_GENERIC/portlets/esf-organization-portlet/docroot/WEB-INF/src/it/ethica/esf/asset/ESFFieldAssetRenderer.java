package it.ethica.esf.asset;

import it.ethica.esf.model.ESFField;
import it.ethica.esf.service.permission.ESFFieldPermission;

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

public class ESFFieldAssetRenderer extends BaseAssetRenderer {
	
	private ESFField _esfField;
	
	public ESFFieldAssetRenderer (ESFField esfField) {
		
		_esfField = esfField;
	}
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {
		
		long esfFieldId = _esfField.getEsfFieldId();
		
		boolean contains = false;
		
		try {
			contains = ESFFieldPermission.contains(permissionChecker,
					esfFieldId, ActionKeys.UPDATE);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}
		
		return contains;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		
		long esfFieldId = _esfField.getEsfFieldId();
		
		boolean contains = false;
		
		try {
			contains = ESFFieldPermission.contains(permissionChecker,
					esfFieldId, ActionKeys.VIEW);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}
		
		return contains;
	}

	@Override
	public String getClassName() {
		return ESFField.class.getName();
	}

	@Override
	public long getClassPK() {
		return _esfField.getEsfFieldId();
	}

	@Override
	public long getGroupId() {
		return _esfField.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return "Name: " + _esfField.getName();
	}

	@Override
	public String getTitle(Locale locale) {
		return _esfField.getName();
	}

	@Override
	public long getUserId() {
		
		return _esfField.getUserId();
	}

	@Override
	public String getUserName() {
		return _esfField.getUserName();
	}

	@Override
	public String getUuid() {
		return _esfField.getUuid();
	}

	@Override
	public String render(RenderRequest renderRequest,
			RenderResponse renderResponse, String template) throws Exception {
		
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			renderRequest.setAttribute("esfField", _esfField);

			return "/html/esffield/" + template + ".jsp";
		}
		else {
			return null;
		}
	}
	
	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {

		return themeDisplay.getURLPortal()
				+ "/esf-field-portlet/icon.png";

	}
	
	private Log _log;

}
