package abdul01.SeleniumFrameworkDesign.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class DataReader {
	//read json to string
public List<HashMap<String, String>> getJsonDataToMap() throws Exception {
	 
      String jsonContent=FileUtils.readFileToString(new File("C:\\Users\\Abdul Razak\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\main\\java\\abdul01\\SeleniumFrameworkDesign\\Data\\PurchaseOrder.json"),StandardCharsets.UTF_8);
      //String to Hashmap  jackson databind
      ObjectMapper mapper=new ObjectMapper();
      List <HashMap<String,String>> data= mapper.readValue(jsonContent, new  TypeReference<List<HashMap<String,String>>>(){});
      //return {map1,map2}
      return data;
}
}
