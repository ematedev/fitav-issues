package it.ethica.esf.hook;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata;
import com.liferay.portlet.documentlibrary.model.DLFileEntryType;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryMetadataLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;

public class DLFileEntryMetadataModelListener
		extends BaseModelListener<DLFileEntryMetadata> {

	@Override
	public void onAfterCreate(DLFileEntryMetadata meta)
			throws ModelListenerException {

		try {

			DLFileEntry file = DLFileEntryLocalServiceUtil
					.getDLFileEntry(meta.getFileEntryId());

			Map<String, Fields> map = file.getFieldsMap(file.getFileVersion()
					.getFileVersionId());

			Set<String> keys = map.keySet();

			Iterator<String> keyIterator = keys.iterator();

			while (keyIterator.hasNext()) {

				String key = keyIterator.next();
				System.out.println("KEY : "+key);

				if ("18705".equals(key)) {
					
					Fields fields = map.get(key);

					Iterator<Field> fieldIterator = fields.iterator();

					while (fieldIterator.hasNext()) {

						Field field = fieldIterator.next();
						System.out.println("    NOME CAMPO : "+field.getName());

						String fotmatString = "EEE MMM dd HH:mm:ss z yyyy";
						Calendar now = Calendar.getInstance();
						DateFormat format =
								new SimpleDateFormat(fotmatString,
										Locale.ENGLISH);

						Date deadlineDate = null, releaseDate = null;;
						
						if ("Deadline_Date".equals(field.getName())) {

							deadlineDate = format.parse(field.getValue()
									.toString());
						}

						if ("Release_Date".equals(field.getName())) {

							releaseDate = format.parse(field.getValue()
									.toString());
						}

						if (deadlineDate != null && releaseDate != null &&
								deadlineDate.after(now.getTime()) &&
								releaseDate.before(now.getTime()) &&
								deadlineDate.after(releaseDate)) {

							System.out.println("DATE CORRETTE");
						}
						else {

							System.out.println("DATE SBAGLIATE");
							DLFileEntryLocalServiceUtil
									.deleteDLFileEntry(file);
						}
						System.out.println("    VALORE CAMPO : "+field.getValue());
					}
				}
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
