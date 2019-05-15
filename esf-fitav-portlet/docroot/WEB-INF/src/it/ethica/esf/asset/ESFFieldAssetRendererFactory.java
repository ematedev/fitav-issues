package it.ethica.esf.asset;

import it.ethica.esf.model.ESFField;
import it.ethica.esf.permission.ESFFieldPermission;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class ESFFieldAssetRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = ESFField.class.getName();

	public static final String TYPE = "esfField";

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException, SystemException {

		ESFField esfField = ESFFieldLocalServiceUtil.getESFField(classPK);

		return new ESFFieldAssetRenderer(esfField);
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

		return ESFFieldPermission
				.contains(permissionChecker, classPK, actionId);
	}

	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}

	private static final boolean _LINKABLE = true;

}
