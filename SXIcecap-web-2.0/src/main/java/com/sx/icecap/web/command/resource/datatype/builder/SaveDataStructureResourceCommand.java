package com.sx.icecap.web.command.resource.datatype.builder;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sx.icecap.constant.MVCCommand;
import com.sx.icecap.constant.ParameterType;
import com.sx.icecap.constant.WebPortletKey;
import com.sx.icecap.model.DataStructure;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.icecap.service.ParameterLocalService;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + WebPortletKey.DATA_STRUCTURE_BUILDER,
	        "mvc.command.name="+MVCCommand.RESOURCE_UPDATE_DATA_STRUCTURE
	    },
	    service = MVCResourceCommand.class
)
public class SaveDataStructureResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		long dataTypeId = ParamUtil.getLong(resourceRequest, "dataTypeId");
		String version = ParamUtil.getString(resourceRequest, "version");
		String strDataStructure = ParamUtil.getString(resourceRequest, "dataStructure");

		System.out.println("dataTypeId: " + dataTypeId);
		System.out.println("version: " + version);
		System.out.println("dataStructure: " + strDataStructure);
		
		DataStructure dataStructure = _dataTypeLocalService.updateDataStructure(dataTypeId, strDataStructure);
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("dataTypeId", dataStructure.getDataTypeId());
		//result.put("dataStructureId", 12345);
		PrintWriter pw = resourceResponse.getWriter();
		pw.write(result.toJSONString());
		pw.flush();
		pw.close();
	}
	
	private void _printOutParameterAttributes( 
							String paramType, 
							String paramName, 
							String paramVersion, 
							Map<Locale, String> displayNameMap,
							Map<Locale, String> definitionMap,
							Map<Locale, String> tooltipMap,
							String synonyms,
							boolean mandatory,
							boolean searchable,
							boolean downloadable,
							String value,
							String attributes,
							String groupParameterId,
							long status) {
		
		System.out.println("******** " + paramName + " v. " + paramVersion + " *******");
		System.out.println("Type: " + paramType );
		System.out.println("DisplayName: " + displayNameMap.toString() );
		displayNameMap.forEach((locale, val)->{ System.out.println(locale.toString() + ", " +val); }) ;
		
		String defStr = Validator.isNotNull( definitionMap ) ? definitionMap.toString()  : "";
		System.out.println( "Definition: " + defStr ); 
		String tipStr = Validator.isNotNull( tooltipMap ) ? tooltipMap.toString()  : "";
		System.out.println("Tooltip: " + tipStr );
		System.out.println("Synonyms: " + synonyms );
		System.out.println("Mandatory: " + mandatory );
		System.out.println("Searchable: " + searchable );
		System.out.println("Downloadable: " + downloadable );
		System.out.println("Value: " + value );
		System.out.println("Attributes: " + attributes );
		System.out.println("GroupParameterId: " + groupParameterId );
		System.out.println("Status: " + status );
		System.out.println("***************************************************");
		
	}
	/**
	 * GroupParameter has no dedicated attributes.
	 * 
	 * @param jsonObj
	 * @param paramType
	 * @return
	 */
	private String _extractParameterTypeAttributes( JSONObject jsonObj, String paramType ) {
		
		if( paramType.equalsIgnoreCase(ParameterType.STRING) ) {
			return _extractStringAttributes(jsonObj);
		}
		else if( paramType.equalsIgnoreCase(ParameterType.NUMERIC) ) {
			return _extractNumericAttributes(jsonObj);
		}
		else if( paramType.equalsIgnoreCase(ParameterType.SELECT) || 
				   paramType.equalsIgnoreCase(ParameterType.BOOLEAN) ) {
			return _extractListAttributes(jsonObj);
		}
		else if( paramType.equalsIgnoreCase(ParameterType.DATE)) {
			return _extractDateAttributes(jsonObj);
		}
		else if( paramType.equalsIgnoreCase(ParameterType.FILE)) {
			return _extractFileAttributes(jsonObj);
		}
		else if( paramType.equalsIgnoreCase(ParameterType.GROUP)) {
			return _extractGroupAttributes(jsonObj);
		}
		else {
			return "";
		}
		
	}
	
	private String _extractStringAttributes( JSONObject jsonObj ) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		if( !jsonObj.isNull("placeHolder") ) {
			JSONObject jsonPlaceHolder = jsonObj.getJSONObject("placeHolder");
			System.out.println( "jsonPlaceHolder: " + jsonPlaceHolder.toJSONString() );
			json.put("placeHolder",  jsonPlaceHolder.toJSONString() );
		}
		
		if( !jsonObj.isNull("minLength") ) {
			json.put("minLength",  jsonObj.getInt("minLength"));
		}

		if( !jsonObj.isNull("maxLength") ) {
			json.put("maxLength",  jsonObj.getInt("maxLength"));
		}

		if( !jsonObj.isNull("multiLine") ) {
			json.put("multiLine",  jsonObj.getBoolean("multiLine"));
		}
		
		if( !jsonObj.isNull("validationRule") ) {
			json.put("validationRule",  jsonObj.getString("validationRule"));
		}
		return json.toJSONString();
	}
	
	private String _extractNumericAttributes( JSONObject jsonObj ) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		if( !jsonObj.has("minValue") ) {
			json.put("minValue",  jsonObj.getDouble("minValue"));
		}
		
		if( !jsonObj.has("minBoundary") ) {
			json.put("minBoundary",  jsonObj.getBoolean("minBoundary"));
		}

		if( !jsonObj.has("maxValue") ) {
			json.put("maxValue",  jsonObj.getDouble("maxValue"));
		}
		
		if( !jsonObj.has("maxBoundary") ) {
			json.put("maxBoundary",  jsonObj.getBoolean("maxBoundary"));
		}

		if( !jsonObj.has("unit") ) {
			json.put("unit",  jsonObj.getString("unit"));
		}

		if( !jsonObj.has("uncertainty") ) {
			json.put("uncertainty",  jsonObj.getBoolean("uncertainty"));
		}

		if( !jsonObj.has("sweepable") ) {
			json.put("sweepable",  jsonObj.getBoolean("sweepable"));
		}
		
		if( !jsonObj.has("placeHolder") ) {
			json.put("placeHolder",  jsonObj.getString("placeHolder"));
		}

		return json.toJSONString();
	}
	
	/**
	 * This function is shared by ListParameter and BooleanParameter 
	 * because BooleanParameter is a kind of special cases of the ListParameter. 
	 * 
	 * @param jsonObj
	 * @return
	 */
	private String _extractListAttributes( JSONObject jsonObj ) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		if( jsonObj.has("displayStyle") ) {
			json.put("displayStyle",  jsonObj.getString("displayStyle"));
		}
		
		if( jsonObj.has("options") ) {
			JSONArray jsonOptions = jsonObj.getJSONArray("options");
			
			if( jsonOptions != null ) {
				json.put("options",  jsonOptions);
			}
		}

		return json.toJSONString();
	}
	
	private String _extractDateAttributes( JSONObject jsonObj ) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		if( jsonObj.has("enableTime") ) {
			json.put("enableTime",  jsonObj.getString("enableTime"));
		}
		
		System.out.println("Date Attrs: " + json.toString());
		return json.toJSONString();
	}
	
	private String _extractFileAttributes(JSONObject jsonObj) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		return json.toJSONString();
	}
	
	private String _extractGroupAttributes(JSONObject jsonObj) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		if(  jsonObj.has("extended") ) {
			json.put("extended",jsonObj.getBoolean("extended"));
		}
		
		return json.toJSONString();
	}
	
	private Map<Locale, String> _jsonObject2LocaleMap( JSONObject jsonObj ){
		Map<Locale, String> map = new HashMap<Locale, String>();
		if( Validator.isNull(jsonObj) ) {
			return map;
		}
		
		Iterator<String> keyIterator = jsonObj.keys();
		System.out.println("_jsonObject2Map: "+jsonObj.length());
		while( keyIterator.hasNext() ) {
			String key = keyIterator.next();
			map.put(LocaleUtil.fromLanguageId(key), jsonObj.getString(key));
		}

		return map;
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
	
	@Reference
	private ParameterLocalService _parameterLocalService;
}
