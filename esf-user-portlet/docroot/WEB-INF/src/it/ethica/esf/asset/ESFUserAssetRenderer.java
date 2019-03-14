package it.ethica.esf.asset;

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.permission.ESFUserPermission;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class ESFUserAssetRenderer extends BaseAssetRenderer {
	
	private ESFUser _esfUser;
	
	public ESFUserAssetRenderer (ESFUser esfUser) {
		
		_esfUser = esfUser;
	}
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {
		
		long esfUserId = _esfUser.getEsfUserId();
		
		boolean contains = false;
		
		try {
			contains = ESFUserPermission.contains(permissionChecker,
					esfUserId, ActionKeys.UPDATE);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}
		
		return contains;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		
		long esfUserId = _esfUser.getEsfUserId();
		
		boolean contains = false;
		
		try {
			contains = ESFUserPermission.contains(permissionChecker,
					esfUserId, ActionKeys.VIEW);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}
		
		return contains;
	}

	@Override
	public String getClassName() {
		return ESFUser.class.getName();
	}

	@Override
	public long getClassPK() {
		return _esfUser.getEsfUserId();
	}

	@Override
	public long getGroupId() {
		try {
			return _esfUser.getOriginalUser().getGroupId();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public String getSummary(Locale locale) {
		try {
			return _esfUser.getFirstName() + 
					StringPool.SPACE + _esfUser.getLastName();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return StringPool.BLANK;
	}

	@Override
	public String getTitle(Locale locale) {
		try {
			return _esfUser.getScreenName();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return StringPool.BLANK;
	}

	@Override
	public long getUserId() {
		
		return _esfUser.getEsfUserId();
	}

	@Override
	public String getUserName() {
		try {
			return _esfUser.getScreenName();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return StringPool.BLANK;
	}

	@Override
	public String getUuid() {
		return _esfUser.getUuid();
	}

	@Override
	public String render(RenderRequest renderRequest,
			RenderResponse renderResponse, String template) throws Exception {
		
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			renderRequest.setAttribute("esfUser", _esfUser);

			return "/html/esfuser/" + template + ".jsp";
		}
		else {
			return null;
		}
	}
	
	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {

		return themeDisplay.getURLPortal()
				+ "/esf-user-portlet/icon.png";

	}
	
	private Log _log;

}
