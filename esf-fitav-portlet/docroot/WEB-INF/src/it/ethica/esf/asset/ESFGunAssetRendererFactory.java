package it.ethica.esf.asset;

import it.ethica.esf.model.ESFGun;
import it.ethica.esf.permission.ESFGunPermission;
import it.ethica.esf.service.ESFGunLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class ESFGunAssetRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = ESFGun.class.getName();

	public static final String TYPE = "esfGun";

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException, SystemException {

		ESFGun esfGun = ESFGunLocalServiceUtil.getESFGun(classPK);

		return new ESFGunAssetRenderer(esfGun);
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

		return  ESFGunPermission.containsRifle(permissionChecker, classPK, actionId);
	}

	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}

	private static final boolean _LINKABLE = true;

}
