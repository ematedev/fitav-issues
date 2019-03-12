<%@page import="it.ethica.esf.service.ESFElectronicLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFElectronic"%>
<%@page
	import="it.ethica.esf.service.ESFFieldESFElectronicLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFFieldESFElectronic"%>
<%@page import="it.ethica.esf.model.impl.ESFFieldESFElectronicImpl"%>
<%@page import="it.ethica.esf.service.ESFBrandLocalServiceUtil"%>
<%@page import="it.ethica.esf.model.ESFBrand"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@include file="init.jsp"%>

<%
	int iesima = ParamUtil.getInteger(request, "iesima");
	long idOwner = ParamUtil.getLong(request, "idOwner");
	
	List<ESFFieldESFElectronic> esfFieldESFElectronics =
		new ArrayList<ESFFieldESFElectronic>();
	
	long brandId = 0;
	
	long electronicId = 0;
	
	long fieldId = 0;
	
	if (idOwner > 0) {
		
		esfFieldESFElectronics =
			ESFFieldESFElectronicLocalServiceUtil.findByFieldId(idOwner);
		
		if (iesima < esfFieldESFElectronics.size()) {
			
			ESFFieldESFElectronic esfFieldESFElectronic =
				esfFieldESFElectronics.get(iesima);
			
			brandId = esfFieldESFElectronic.getBrandId();
			electronicId = esfFieldESFElectronic.getElectronicId();
			fieldId = esfFieldESFElectronic.getFieldId();
		}
	}
%>

<fieldset>

	<aui:select name='<%="brandId" + iesima%>' label="brand-id">

		<aui:option label="-" value="0" />
		<%
			List<ESFBrand> esfBrands = ESFBrandLocalServiceUtil.findAll();
				
				for (ESFBrand esfBrand : esfBrands) {
					
					String label = esfBrand.getName();
					
					if (esfBrand.getBrandId() == brandId) {
		%>
		<aui:option label="<%=label%>" value="<%=esfBrand.getBrandId()%>"
			selected="true" />
		<%
			}
					else {
		%>
		<aui:option label="<%=label%>" value="<%=esfBrand.getBrandId()%>" />

		<%
			}
				}
		%>
	</aui:select>

	<aui:select name='<%="electronicId" + iesima%>' label="electronic-id">

		<aui:option label="-" value="0" />

		<%
			List<ESFElectronic> esfElectronics =
					ESFElectronicLocalServiceUtil.findAll();
				
				for (ESFElectronic esfElectronic : esfElectronics) {
					
					String label = esfElectronic.getName();
					
					if (esfElectronic.getElectronicId() == electronicId) {
		%>
		<aui:option label="<%=label%>"
			value="<%=esfElectronic.getElectronicId()%>" selected="true" />
		<%
			}
					else {
		%>
		<aui:option label="<%=label%>"
			value="<%=esfElectronic.getElectronicId()%>" />

		<%
			}
				}
		%>
	</aui:select>

	<%
		ESFFieldESFElectronic eSFFieldESFElectronic =
			ESFFieldESFElectronicLocalServiceUtil.findByFieldIdBrandIdElectronicId(
				fieldId, brandId, electronicId);
		
		String value = "";
		
		if (eSFFieldESFElectronic != null) {
			value = eSFFieldESFElectronic.getDescription();
		}
	%>
	<aui:input name='<%="description" + iesima%>' label="description"
		value="<%=value%>" type="textarea" />

</fieldset>

<style>
.aui .input-append .help-inline div, .aui .input-prepend .help-inline div
	{
	font-size: 14px;
}
</style>

