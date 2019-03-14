package it.ethica.esf.asset;

import it.ethica.esf.model.ESFTool;
import it.ethica.esf.permission.ESFToolPermission;
import it.ethica.esf.service.ESFToolLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class ESFToolAssetRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = ESFTool.class.getName();

	public static final String TYPE = "esfTool";

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException, SystemException {

		ESFTool esfTool = ESFToolLocalServiceUtil.getESFTool(classPK);

		return new ESFToolAssetRenderer(esfTool);
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

		return ESFToolPermission.contains(permissionChecker, classPK, actionId);
	}

	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}

	private static final boolean _LINKABLE = true;

}
