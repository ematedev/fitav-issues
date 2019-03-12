package it.ethica.esf.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.StringPool;

public class ESFReportUtil {

	public static void downloadReport(ResourceRequest request,
			ResourceResponse response, String inputfileName,
			String outputfileName, Map<String, Object> parameters,
			List<Map<String,?>> maps)
		throws IOException, PortletException {

		PortletContext portletContext =
				request.getPortletSession().getPortletContext();
		String filePath = portletContext.getRealPath(StringPool.BLANK)
				+ "/reports/" + inputfileName;

		try {
			FileInputStream fis = new FileInputStream(filePath);
			BufferedInputStream bufferedInputStream =
					new BufferedInputStream(fis);

			JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(maps);

			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(bufferedInputStream);

			JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);

			OutputStream os = response.getPortletOutputStream();

			String pdfApplicationFormName = outputfileName;
			response.setContentType("application/pdf");
			response.setProperty(HttpHeaders.CONTENT_DISPOSITION,"attachement;filename="+pdfApplicationFormName);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
			exporter.exportReport();
			os.flush();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public interface ESFReportContants {

		public interface ESFNationalDeclaration {

			final String INPUT_FILE_NAME = "national-shooter-declaration.jasper";
			final String OUTPUT_FILE_NAME = "dichiarazione-tiratore-azzurro.pdf";

			public interface Parameters {

				final String[] VALUES = {

						"DICHIARAZIONE TIRATORE AZZURRO",
						"PARTE ANAGRAFICA",
						"PARTE DOCUMENTALE",
						"ARMA/I",
						"NOMINATIVO",
						"NATO/A A:",
						"DATA",
						"RESIDENTE IN",
						"PROV.",
						"C.A.P.",
						"INDIRIZZO",
						"Cell.",
						"Email",
						"STATO CIVILE",
						"Cod. Fiscale"
				};
				final String[] NAMES = {

						"title",
						"section1",
						"section2",
						"section3",
						"name",
						"birthplace",
						"birthday",
						"city",
						"province",
						"zip",
						"address",
						"cellPhone",
						"emailAddress",
						"maritalStatus",
						"fiscalCode"
				};
			}
		}
	}
}
