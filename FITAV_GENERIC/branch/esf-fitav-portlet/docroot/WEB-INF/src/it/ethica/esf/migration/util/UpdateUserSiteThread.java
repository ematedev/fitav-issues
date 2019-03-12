package it.ethica.esf.migration.util;

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.service.ESFUserLocalServiceUtil;

import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutSetPrototype;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeLocalServiceUtil;


public class UpdateUserSiteThread implements Runnable {

	private static Log _log =
		LogFactoryUtil.getLog(ShooterMigrationThread.class);

	@Override
	public void run() {
   
		try {
			List<ESFUser> shooters= ESFUserLocalServiceUtil.findAllUser();
			System.out.println("shooters "+shooters.size());
			
			long publicLayoutSetPrototypeId = 107045;
			long privateLayoutSetPrototypeId = 107055;
			int userProcessati=0;
			for (ESFUser shooter : shooters) {
				
				Group shoterGroup=GroupLocalServiceUtil.fetchGroup(shooter.getGroupId());
				
				
				LayoutSetPrototype prototypePublic = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototype(publicLayoutSetPrototypeId);
				LayoutSetPrototype prototypePrivate = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototype(privateLayoutSetPrototypeId);
				
				boolean layoutSetPrototypeLinkEnabled = true;
				
				LayoutSetLocalServiceUtil.updateLayoutSetPrototypeLinkEnabled(shoterGroup.getGroupId(), false, layoutSetPrototypeLinkEnabled, prototypePublic.getUuid());
				LayoutSetLocalServiceUtil.updateLayoutSetPrototypeLinkEnabled(shoterGroup.getGroupId(), true, layoutSetPrototypeLinkEnabled, prototypePrivate.getUuid());
				/*
				LayoutSet layoutSetPublic = LayoutSetLocalServiceUtil.getLayoutSet(shoterGroup.getGroupId(), false);
				LayoutSet layoutSetPrivate = LayoutSetLocalServiceUtil.getLayoutSet(shoterGroup.getGroupId(), true);
				
				SitesUtil.mergeLayoutSetProtypeLayouts(shoterGroup, layoutSetPublic);
				SitesUtil.mergeLayoutSetProtypeLayouts(shoterGroup, layoutSetPrivate);*/
				List newLayouts = LayoutLocalServiceUtil.getLayouts(shoterGroup.getGroupId(), false, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);
				userProcessati++;
				_log.info("Processato "+userProcessati);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		
	}

}
