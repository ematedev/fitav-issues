package it.ethica.esf.asset;

import it.ethica.esf.model.ESFState;
import it.ethica.esf.permission.ESFStatePermission;
import it.ethica.esf.service.ESFStateLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class ESFStateAssetRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = ESFState.class.getName();

	public static final String TYPE = "esfState";

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException, SystemException {

		ESFState esfState = ESFStateLocalServiceUtil.getESFState(classPK);

		return new ESFStateAssetRenderer(esfState);
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

		return ESFStatePermission.contains(permissionChecker, classPK, actionId);
	}

	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}

	private static final boolean _LINKABLE = true;

}
