package it.ethica.esf.asset;

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.permission.ESFUserPermission;
import it.ethica.esf.service.ESFUserLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class ESFUserAssetRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = ESFUser.class.getName();

	public static final String TYPE = "esfUser";

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException, SystemException {

		ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(classPK);

		return new ESFUserAssetRenderer(esfUser);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		return ESFUserPermission.contains(permissionChecker, classPK, actionId);
	}

	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}

	private static final boolean _LINKABLE = true;

}
