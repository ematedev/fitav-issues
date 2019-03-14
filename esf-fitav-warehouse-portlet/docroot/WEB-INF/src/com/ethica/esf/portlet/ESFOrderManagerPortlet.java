
package com.ethica.esf.portlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import com.ethica.esf.model.ESFArticle;
import com.ethica.esf.model.ESFArticle_ESFOrder;
import com.ethica.esf.model.ESFBill;
import com.ethica.esf.model.ESFOrder;
import com.ethica.esf.service.ESFArticleLocalServiceUtil;
import com.ethica.esf.service.ESFArticle_ESFOrderLocalServiceUtil;
import com.ethica.esf.service.ESFBillLocalServiceUtil;
import com.ethica.esf.service.ESFOrderLocalServiceUtil;
import com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK;
import com.ethica.esf.util.ESFOrderConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.assetpublisher.util.AssetPublisherUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppHelperLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ESFOrderManagerPortlet extends MVCPortlet {

	public void editESFArticleESFOrder(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long esfOrderId = ParamUtil.getLong(request, "esfOrderId");
		long esfArticleId = ParamUtil.getLong(request, "esfArticleId");

		long xxxlQty = ParamUtil.getLong(request, "xxxlQty");
		long xxlQty = ParamUtil.getLong(request, "xxlQty");
		long xlQty = ParamUtil.getLong(request, "xlQty");
		long lQty = ParamUtil.getLong(request, "lQty");
		long mQty = ParamUtil.getLong(request, "mQty");
		long sQty = ParamUtil.getLong(request, "sQty");
		long xsQty = ParamUtil.getLong(request, "xsQty");
		long xxsQty = ParamUtil.getLong(request, "xxsQty");
		long otherQty = ParamUtil.getLong(request, "otherQty");
		long totalQty =
			xxxlQty + xxlQty + xlQty + lQty + mQty + sQty + xsQty + xxsQty +
				otherQty;

		double price = ParamUtil.getDouble(request, "price");
		double vat = ParamUtil.getDouble(request, "vat");
		double sale = ParamUtil.getDouble(request, "sale");

		String mode = ParamUtil.getString(request, "mode");

		if (!"add".equalsIgnoreCase(mode)) {
			ESFArticle_ESFOrderLocalServiceUtil.updateESFArticle_ESFOrder(
				esfArticleId, esfOrderId, xxxlQty, xxlQty, xlQty, lQty, mQty,
				sQty, xsQty, xxsQty, otherQty, totalQty, price, vat, sale);
		}
		else {
			ESFArticle_ESFOrderLocalServiceUtil.addESFArticle_ESFOrder(
				esfArticleId, esfOrderId, xxxlQty, xxlQty, xlQty, lQty, mQty,
				sQty, xsQty, xxsQty, otherQty, totalQty, price, vat, sale);
		}
	}

	public void editESFBill(ActionRequest request, ActionResponse response)
		throws ParseException, PortalException, SystemException {

		long esfBillId = ParamUtil.getLong(request, "esfBillId");

		long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
		long esfOrderId = ParamUtil.getLong(request, "esfOrderId");
		String billNumber = ParamUtil.getString(request, "billNumber");

		long xxxlQty = ParamUtil.getLong(request, "xxxlQty");
		long xxlQty = ParamUtil.getLong(request, "xxlQty");
		long xlQty = ParamUtil.getLong(request, "xlQty");
		long lQty = ParamUtil.getLong(request, "lQty");
		long mQty = ParamUtil.getLong(request, "mQty");
		long sQty = ParamUtil.getLong(request, "sQty");
		long xsQty = ParamUtil.getLong(request, "xsQty");
		long xxsQty = ParamUtil.getLong(request, "xxsQty");
		long otherQty = ParamUtil.getLong(request, "otherQty");

		long totalQty =
			xxxlQty + xxlQty + xlQty + lQty + mQty + sQty + xsQty + xxsQty +
				otherQty;

		if (esfBillId > 0) {
			ESFBillLocalServiceUtil.updateESFBill(
				esfBillId, esfArticleId, esfOrderId, billNumber, xxxlQty,
				xxlQty, xlQty, lQty, mQty, sQty, xsQty, xxsQty, otherQty,
				totalQty);
		}
		else {
			ESFBillLocalServiceUtil.addESFBill(
				esfArticleId, esfOrderId, billNumber, xxxlQty, xxlQty, xlQty,
				lQty, mQty, sQty, xsQty, xxsQty, otherQty, totalQty);
		}

		/*------------- Gestione evasione ordine --------------*/

		ESFArticle_ESFOrderPK pk =
			new ESFArticle_ESFOrderPK(esfArticleId, esfOrderId);
		ESFArticle_ESFOrder esfArticleEsfOrder =
			ESFArticle_ESFOrderLocalServiceUtil.getESFArticle_ESFOrder(pk);
		long xxxlQtyMax = esfArticleEsfOrder.getXxxlQty();
		long xxlQtyMax = esfArticleEsfOrder.getXxlQty();
		long xlQtyMax = esfArticleEsfOrder.getXlQty();
		long lQtyMax = esfArticleEsfOrder.getLQty();
		long mQtyMax = esfArticleEsfOrder.getMQty();
		long sQtyMax = esfArticleEsfOrder.getSQty();
		long xsQtyMax = esfArticleEsfOrder.getXsQty();
		long xxsQtyMax = esfArticleEsfOrder.getXxsQty();
		long otherQtyMax = esfArticleEsfOrder.getOtherQty();

		List<ESFBill> esfBills =
			ESFBillLocalServiceUtil.findByEA_EO(esfArticleId, esfOrderId);

		long xxxlQtyActual = xxxlQty;
		long xxlQtyActual = xxlQty;
		long xlQtyActual = xlQty;
		long lQtyActual = lQty;
		long mQtyActual = mQty;
		long sQtyActual = sQty;
		long xsQtyActual = xsQty;
		long xxsQtyActual = xxsQty;
		long otherQtyActual = otherQty;

		// Scorro tutte le bolle associate all'articolo dell'ordine e ne sommo
		// le quantità per ogni taglia
		for (ESFBill esfBill : esfBills) {
			xxxlQtyActual += esfBill.getXxxlQty();
			xxlQtyActual += esfBill.getXxlQty();
			xlQtyActual += esfBill.getXlQty();
			lQtyActual += esfBill.getLQty();
			mQtyActual += esfBill.getMQty();
			sQtyActual += esfBill.getSQty();
			xsQtyActual += esfBill.getXsQty();
			xxsQtyActual += esfBill.getXxsQty();
			otherQtyActual += esfBill.getOtherQty();
		}

		// Controllo se la mia attuale bolla ha completato la quantità
		// dell'articolo associato all'ordine richiesta
		if (xxxlQtyActual >= xxxlQtyMax && xxlQtyActual >= xxlQtyMax &&
			xlQtyActual >= xlQtyMax && lQtyActual >= lQtyMax &&
			mQtyActual >= mQtyMax && sQtyActual >= sQtyMax &&
			xsQtyActual >= xsQtyMax && xxsQtyActual >= xxsQtyMax &&
			otherQtyActual >= otherQtyMax) {

			boolean orderIsCompleted = true;

			List<ESFArticle_ESFOrder> otherOrderArticles =
				ESFArticle_ESFOrderLocalServiceUtil.findByEsfOrderId(esfOrderId);

			List<ESFBill> esfBillsOfOtherArticles = null;
			long xxxlQtyMaxForOtherArticle;
			long xxlQtyMaxForOtherArticle;
			long xlQtyMaxForOtherArticle;
			long lQtyMaxForOtherArticle;
			long mQtyMaxForOtherArticle;
			long sQtyMaxForOtherArticle;
			long xsQtyMaxForOtherArticle;
			long xxsQtyMaxForOtherArticle;
			long otherQtyMaxForOtherArticle;

			long xxxlQtyTempForOtherArticle;
			long xxlQtyTempForOtherArticle;
			long xlQtyTempForOtherArticle;
			long lQtyTempForOtherArticle;
			long mQtyTempForOtherArticle;
			long sQtyTempForOtherArticle;
			long xsQtyTempForOtherArticle;
			long xxsQtyTempForOtherArticle;
			long otherQtyTempForOtherArticle;

			for (ESFArticle_ESFOrder otherOrderArticle : otherOrderArticles) {
				// L'articolo attuale non lo considero visto che è stato già
				// controllato
				if (esfArticleId == otherOrderArticle.getEsfArticleId()) {
					continue;
				}
				xxxlQtyMaxForOtherArticle = otherOrderArticle.getXxxlQty();
				xxlQtyMaxForOtherArticle = otherOrderArticle.getXxlQty();
				xlQtyMaxForOtherArticle = otherOrderArticle.getXlQty();
				lQtyMaxForOtherArticle = otherOrderArticle.getLQty();
				mQtyMaxForOtherArticle = otherOrderArticle.getMQty();
				sQtyMaxForOtherArticle = otherOrderArticle.getSQty();
				xsQtyMaxForOtherArticle = otherOrderArticle.getXsQty();
				xxsQtyMaxForOtherArticle = otherOrderArticle.getXxsQty();
				otherQtyMaxForOtherArticle = otherOrderArticle.getOtherQty();

				xxxlQtyTempForOtherArticle = 0;
				xxlQtyTempForOtherArticle = 0;
				xlQtyTempForOtherArticle = 0;
				lQtyTempForOtherArticle = 0;
				mQtyTempForOtherArticle = 0;
				sQtyTempForOtherArticle = 0;
				xsQtyTempForOtherArticle = 0;
				xxsQtyTempForOtherArticle = 0;
				otherQtyTempForOtherArticle = 0;

				esfBillsOfOtherArticles =
					ESFBillLocalServiceUtil.findByEA_EO(
						otherOrderArticle.getEsfArticleId(), esfOrderId);

				for (ESFBill esfBillOfOtherArticles : esfBillsOfOtherArticles) {
					xxxlQtyTempForOtherArticle +=
						esfBillOfOtherArticles.getXxxlQty();
					xxlQtyTempForOtherArticle +=
						esfBillOfOtherArticles.getXxlQty();
					xlQtyTempForOtherArticle +=
						esfBillOfOtherArticles.getXlQty();
					lQtyTempForOtherArticle += esfBillOfOtherArticles.getLQty();
					mQtyTempForOtherArticle += esfBillOfOtherArticles.getMQty();
					sQtyTempForOtherArticle += esfBillOfOtherArticles.getSQty();
					xsQtyTempForOtherArticle +=
						esfBillOfOtherArticles.getXsQty();
					xxsQtyTempForOtherArticle +=
						esfBillOfOtherArticles.getXxsQty();
					otherQtyTempForOtherArticle +=
						esfBillOfOtherArticles.getOtherQty();
				}

				if (xxxlQtyMaxForOtherArticle > xxxlQtyTempForOtherArticle ||
					xxlQtyMaxForOtherArticle > xxlQtyTempForOtherArticle ||
					xlQtyMaxForOtherArticle > xlQtyTempForOtherArticle ||
					lQtyMaxForOtherArticle > lQtyTempForOtherArticle ||
					mQtyMaxForOtherArticle > mQtyTempForOtherArticle ||
					sQtyMaxForOtherArticle > sQtyTempForOtherArticle ||
					xsQtyMaxForOtherArticle > xsQtyTempForOtherArticle ||
					xxsQtyMaxForOtherArticle > xxsQtyTempForOtherArticle ||
					otherQtyMaxForOtherArticle > otherQtyTempForOtherArticle) {
					orderIsCompleted = false;
					break;
				}
			}

			if (orderIsCompleted) {
				ESFOrder actualOrder =
					ESFOrderLocalServiceUtil.getESFOrder(esfOrderId);
				actualOrder.setState(ESFOrderConstants.ORDER_STATE_DELIVERED);
				ESFOrderLocalServiceUtil.updateESFOrder(actualOrder);

				if (_log.isInfoEnabled()) {
					_log.info("Order " + esfOrderId + " delivered!");
				}

				List<ESFArticle_ESFOrder> temps =
					ESFArticle_ESFOrderLocalServiceUtil.findByEsfOrderId(esfOrderId);

				ESFArticle actualArticle = null;
				long tmpQty = 0;
				for (ESFArticle_ESFOrder temp : temps) {

					actualArticle =
						ESFArticleLocalServiceUtil.getESFArticle(temp.getEsfArticleId());
					if (_log.isInfoEnabled()) {
						_log.info("Updating article " +
							actualArticle.getName() + "!");
					}

					tmpQty = actualArticle.getXxxlQty() + temp.getXxxlQty();
					actualArticle.setXxxlQty(tmpQty);

					tmpQty = actualArticle.getXxlQty() + temp.getXxlQty();
					actualArticle.setXxlQty(tmpQty);

					tmpQty = actualArticle.getXlQty() + temp.getXlQty();
					actualArticle.setXlQty(tmpQty);

					tmpQty = actualArticle.getLQty() + temp.getLQty();
					actualArticle.setLQty(tmpQty);

					tmpQty = actualArticle.getMQty() + temp.getMQty();
					actualArticle.setMQty(tmpQty);

					tmpQty = actualArticle.getSQty() + temp.getSQty();
					actualArticle.setSQty(tmpQty);

					tmpQty = actualArticle.getXsQty() + temp.getXsQty();
					actualArticle.setXsQty(tmpQty);

					tmpQty = actualArticle.getXxsQty() + temp.getXxsQty();
					actualArticle.setXxsQty(tmpQty);

					tmpQty = actualArticle.getOtherQty() + temp.getOtherQty();
					actualArticle.setOtherQty(tmpQty);

					tmpQty =
						actualArticle.getXxxlQty() + actualArticle.getXxlQty() +
							actualArticle.getXlQty() + actualArticle.getLQty() +
							actualArticle.getMQty() + actualArticle.getSQty() +
							actualArticle.getXsQty() +
							actualArticle.getXxsQty() +
							actualArticle.getOtherQty();
					actualArticle.setTotalQty(tmpQty);
					ESFArticleLocalServiceUtil.updateESFArticle(actualArticle);
					if (_log.isInfoEnabled()) {
						_log.info("Article " + actualArticle.getName() +
							" updated!");
					}
				}

			}
		}
		/*------------- Termine --------------*/
	}

	public void editESFOrder(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) request.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				DLFileEntry.class.getName(), request);
		InputStream inputStream = null;
		File file = null;
		UploadPortletRequest uploadPortletRequest =
			PortalUtil.getUploadPortletRequest(request);
		long esfOrderId = ParamUtil.getLong(uploadPortletRequest, "esfOrderId");
		String code = ParamUtil.getString(uploadPortletRequest, "code");
		String name = ParamUtil.getString(uploadPortletRequest, "name");
		String description =
			ParamUtil.getString(uploadPortletRequest, "description");
		Date date =
			ParamUtil.getDate(
				uploadPortletRequest, "date", new SimpleDateFormat(""));
		String note = ParamUtil.getString(uploadPortletRequest, "note");
		String protocolCode =
			ParamUtil.getString(uploadPortletRequest, "protocolCode");
		String attachment = uploadPortletRequest.getFileName("attachment-file");

		PortletPreferences prefs = request.getPreferences();
		String folderName = prefs.getValue("folderName", StringPool.BLANK);

		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		long folderId = parentFolderId;
		try {
			folderId =
				DLFolderLocalServiceUtil.getFolder(
					themeDisplay.getScopeGroupId(), parentFolderId, folderName).getFolderId();
		}
		catch (Exception e) {
			if (_log.isErrorEnabled()) {
				_log.error(e);
			}
		}
		if (Validator.isNotNull(attachment)) {
			Random rand = new Random();
			String prefix = String.valueOf(rand.nextInt(100000));
			attachment = prefix + attachment;
			try {
				file = uploadPortletRequest.getFile("attachment-file");
				inputStream =
					uploadPortletRequest.getFileAsStream("attachment-file");

				FileEntry fileEntry =
					DLAppServiceUtil.addFileEntry(
						themeDisplay.getScopeGroupId(), folderId, attachment,
						MimeTypesUtil.getContentType(file), StringPool.BLANK,
						description, StringPool.BLANK, inputStream,
						file.length(), serviceContext);

				AssetPublisherUtil.addAndStoreSelection(
					request, DLFileEntry.class.getName(),
					fileEntry.getFileEntryId(), -1);

			}
			catch (IOException e) {
				if (_log.isErrorEnabled()) {
					_log.error(e);
				}
			}
			catch (Exception e) {
				if (_log.isErrorEnabled()) {
					_log.error(e);
				}
			}
		}
		int state = ParamUtil.getInteger(uploadPortletRequest, "state");
		long esfStockistId =
			ParamUtil.getLong(uploadPortletRequest, "esfStockistId");

		if (esfOrderId > 0) {
			String oldAttachment =
				ESFOrderLocalServiceUtil.getESFOrder(esfOrderId).getAttachment();
			if (Validator.isNull(attachment)) {
				attachment = oldAttachment;
			}
			else {
				try {
					FileEntry fileEntry =
						DLAppLocalServiceUtil.getFileEntry(
							themeDisplay.getScopeGroupId(), folderId,
							oldAttachment);
					DLAppHelperLocalServiceUtil.moveFileEntryToTrash(
						themeDisplay.getUserId(), fileEntry);
					DLAppHelperLocalServiceUtil.deleteFileEntry(fileEntry);
				}
				catch (Exception ex) {
					if (_log.isErrorEnabled()) {
						_log.error(ex);
					}
				}
			}
			ESFOrderLocalServiceUtil.updateESFOrder(
				esfOrderId, code, name, description, date, note, protocolCode,
				attachment, state, esfStockistId);
		}
		else {
			ESFOrderLocalServiceUtil.addESFOrder(
				code, name, description, date, note, protocolCode, attachment,
				state, esfStockistId);
		}
	}

	public void deleteESFArticleESFOrder(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long esfOrderId = ParamUtil.getLong(request, "esfOrderId");
		long esfArticleId = ParamUtil.getLong(request, "esfArticleId");

		ESFArticle_ESFOrderPK pk =
			new ESFArticle_ESFOrderPK(esfArticleId, esfOrderId);

		ESFArticle_ESFOrderLocalServiceUtil.deleteESFArticle_ESFOrder(pk);
	}

	public void deleteESFBill(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long esfBillId = ParamUtil.getLong(request, "esfBillId");

		ESFBillLocalServiceUtil.deleteESFBill(esfBillId);
	}

	public void deleteESFOrder(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		PortletPreferences prefs = request.getPreferences();
		String folderName = prefs.getValue("folderName", StringPool.BLANK);

		ThemeDisplay themeDisplay =
			(ThemeDisplay) request.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);

		long esfOrderId = ParamUtil.getLong(request, "esfOrderId");

		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		long folderId = parentFolderId;
		try {
			folderId =
				DLFolderLocalServiceUtil.getFolder(
					themeDisplay.getScopeGroupId(), parentFolderId, folderName).getFolderId();
		}
		catch (Exception e) {
			if (_log.isErrorEnabled()) {
				_log.error(e);
			}
		}

		ESFOrderLocalServiceUtil.deleteESFOrder(
			themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), folderId,
			esfOrderId);
	}

	private static Log _log =
		LogFactoryUtil.getLog(ESFOrderManagerPortlet.class);
}
