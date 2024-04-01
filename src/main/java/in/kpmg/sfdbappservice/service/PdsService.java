package in.kpmg.sfdbappservice.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import in.kpmg.sfdbappservice.dto.DataDTO;
import in.kpmg.sfdbappservice.dto.PdsDataDTO;
import in.kpmg.sfdbappservice.dto.UfcDTO;
import in.kpmg.sfdbappservice.model.LogData;
import in.kpmg.sfdbappservice.model.SrcPds;
import in.kpmg.sfdbappservice.repository.LogDataRepo;
import in.kpmg.sfdbappservice.repository.PdsData;
import in.kpmg.sfdbappservice.repository.SrcPdsRepo;
import in.kpmg.sfdbappservice.util.JwtUtil;
import jdk.nashorn.internal.parser.JSONParser;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.ResultTransformer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PdsService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    LogDataRepo logDataRepo;

    @Autowired
    PdsData pdsData;

    public DataDTO getPDSData(String ufc, String requestIp, String deptname ,String userAgent, String requestURL){
        DataDTO dataDTO = new DataDTO();
        try{
            List<PdsDataDTO> data = pdsData.getUfcData(ufc);
            JSONObject response = new JSONObject();
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("PDS------------>"+data);
            String json = objectMapper.writeValueAsString(data);
            System.out.println("After converting to JSON --------->"+json);
//            JsonObject jsonObject = new JsonObject(json);
            JSONArray jsonObject = new JSONArray(json);
//            JsonElement jsonElement = response.getAsJsonArray(json);
            System.out.println("JSON Element ------->,"+jsonObject);
            response.put("message","Success");
            response.put("Status",true);
            response.put("statusCode",200);
            response.put("Data",jsonObject);
            LogData logData = new LogData();
            logData.setClientIp(requestIp);
            logData.setUserAgent(userAgent);
            logData.setRequestUrl(requestURL);
            logData.setDeptName(deptname);
            logDataRepo.save(logData);
            String token = jwtUtil.generateToken(String.valueOf(response));
            dataDTO.setData(token);
            return dataDTO;
        }
        catch (Exception e){
            JsonObject response =  new JsonObject();
            System.out.println("Exception : : "+e);
            response.addProperty("message","failed");
            response.addProperty("statusCode",500);
            response.addProperty("Status",false);
            response.addProperty("Data",String.valueOf(e));

            dataDTO.setData(response);

            return dataDTO;
        }
    }

    public DataDTO getUFCDist(String dist, String taluk, String villg, String requestIp ,String userAgent, String requestURL){
        DataDTO dataDTO = new DataDTO();
        try{
            List<UfcDTO> data = pdsData.getUFCDist(dist, taluk, villg);
            JSONObject response = new JSONObject();
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("PDS------------>"+data);
            String json = objectMapper.writeValueAsString(data);
            System.out.println("After converting to JSON --------->"+json);
//            JsonObject jsonObject = new JsonObject(json);
            JSONArray jsonObject = new JSONArray(json);
//            JsonElement jsonElement = response.getAsJsonArray(json);
            System.out.println("JSON Element ------->,"+jsonObject);
            response.put("message","Success");
            response.put("Status",true);
            response.put("statusCode",200);
            response.put("Data",jsonObject);
            LogData logData = new LogData();
            logData.setClientIp(requestIp);
            logData.setUserAgent(userAgent);
            logData.setRequestUrl(requestURL);
            logDataRepo.save(logData);
            String token = jwtUtil.generateToken(String.valueOf(response));
            dataDTO.setData(token);
            return dataDTO;
        }
        catch (Exception e){
            JsonObject response =  new JsonObject();
            System.out.println("Exception : : "+e);
            response.addProperty("message","failed");
            response.addProperty("statusCode",500);
            response.addProperty("Status",false);
            response.addProperty("Data",String.valueOf(e));

            dataDTO.setData(response);

            return dataDTO;
        }
    }
}
