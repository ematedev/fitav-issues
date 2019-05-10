package it.ethica.esf.asset;

import it.ethica.esf.model.ESFTool;
import it.ethica.esf.permission.ESFToolPermission;
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

public class ESFToolAssetRenderer extends BaseAssetRenderer {
	
	private ESFTool _esfTool;
	
	public ESFToolAssetRenderer (ESFTool esfTool) {
		
		_esfTool = esfTool;
	}
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {
		
		long esfToolId = _esfTool.getEsfToolId();
		
		boolean contains = false;
		
		try {
			contains = ESFToolPermission.contains(permissionChecker,
					esfToolId, ActionKeys.UPDATE);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}
		
		return contains;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		
		long esfToolId = _esfTool.getEsfToolId();
		
		boolean contains = false;
		
		try {
			contains = ESFToolPermission.contains(permissionChecker,
					esfToolId, ActionKeys.VIEW);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}
		
		return contains;
	}

	@Override
	public String getClassName() {
		return ESFTool.class.getName();
	}

	@Override
	public long getClassPK() {
		return _esfTool.getEsfToolId();
	}

	@Override
	public long getGroupId() {
		return _esfTool.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return _esfTool.getDescription();
	}

	@Override
	public String getTitle(Locale locale) {
		return _esfTool.getName();
	}

	@Override
	public long getUserId() {
		
		return _esfTool.getUserId();
	}

	@Override
	public String getUserName() {
		return _esfTool.getUserName();
	}

	@Override
	public String getUuid() {
		return _esfTool.getUuid();
	}

	@Override
	public String render(RenderRequest renderRequest,
			RenderResponse renderResponse, String template) throws Exception {
		
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			renderRequest.setAttribute("esfTool", _esfTool);

			return null;
		}
		else {
			return null;
		}
	}
	
	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {

		return themeDisplay.getURLPortal()
				+ "/esf-fitav-portlet/icon.png";

	}
	
	private Log _log;

}
