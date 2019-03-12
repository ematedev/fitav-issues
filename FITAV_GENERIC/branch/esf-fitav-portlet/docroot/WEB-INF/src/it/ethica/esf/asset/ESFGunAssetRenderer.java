package it.ethica.esf.asset;

import it.ethica.esf.model.ESFGun;
import it.ethica.esf.permission.ESFGunPermission;
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

public class ESFGunAssetRenderer extends BaseAssetRenderer {
	
	private ESFGun _esfGun;
	
	public ESFGunAssetRenderer (ESFGun esfGun) {
		
		_esfGun = esfGun;
	}
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {
		
		long esfGunId = _esfGun.getEsfGunId();
		
		boolean contains = false;
		
		try {
			contains = ESFGunPermission.contains(permissionChecker,
					esfGunId, ActionKeys.UPDATE);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}
		
		return contains;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		
		long esfGunId = _esfGun.getEsfGunId();
		
		boolean contains = false;
		
		try {
			contains = ESFGunPermission.contains(permissionChecker,
					esfGunId, ActionKeys.VIEW);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}
		
		return contains;
	}

	@Override
	public String getClassName() {
		return ESFGun.class.getName();
	}

	@Override
	public long getClassPK() {
		return _esfGun.getEsfGunId();
	}

	@Override
	public long getGroupId() {
		return _esfGun.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return _esfGun.getCode();
	}

	@Override
	public String getTitle(Locale locale) {
		return _esfGun.getFullName();
	}

	@Override
	public long getUserId() {
		
		return _esfGun.getUserId();
	}

	@Override
	public String getUserName() {
		return _esfGun.getUserName();
	}

	@Override
	public String getUuid() {
		return _esfGun.getUuid();
	}

	@Override
	public String render(RenderRequest renderRequest,
			RenderResponse renderResponse, String template) throws Exception {
		
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			renderRequest.setAttribute("esfGun", _esfGun);

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
