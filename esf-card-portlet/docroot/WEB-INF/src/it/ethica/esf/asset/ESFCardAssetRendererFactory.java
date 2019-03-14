package it.ethica.esf.asset;

import it.ethica.esf.model.ESFCard;
import it.ethica.esf.permission.ESFCardPermission;
import it.ethica.esf.service.ESFCardLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class ESFCardAssetRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = ESFCard.class.getName();

	public static final String TYPE = "esfCard";

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException, SystemException {

		ESFCard esfCard = ESFCardLocalServiceUtil.getESFCard(classPK);

		return new ESFSCardAssetRenderer(esfCard);
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

		return ESFCardPermission.contains(permissionChecker, classPK, actionId);
	}

	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}

	private static final boolean _LINKABLE = true;

}
