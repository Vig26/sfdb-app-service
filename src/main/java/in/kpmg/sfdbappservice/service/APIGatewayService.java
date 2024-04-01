package in.kpmg.sfdbappservice.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import in.kpmg.sfdbappservice.dto.DataDTO;
import in.kpmg.sfdbappservice.dto.EsevaiDTO;
import in.kpmg.sfdbappservice.dto.PdsDataDTO;
import in.kpmg.sfdbappservice.dto.UfcDTO;
import in.kpmg.sfdbappservice.model.LogData;
import in.kpmg.sfdbappservice.model.LogDataPOC;
import in.kpmg.sfdbappservice.repository.*;
import in.kpmg.sfdbappservice.util.JwtUtil;
import in.kpmg.sfdbappservice.repository.LogDataPOCRepo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class APIGatewayService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    SrcPdsPOCRepo srcPdsPOCRepo;

    @Autowired
    LogDataPOCRepo logDataPOCRepo;

    @Autowired
    PdsDataPOCRepo pdsDataPOCRepo;

    @Autowired
    EsevaiPOCRepo esevaiPOCRepo;

    public DataDTO getEsevai(String uid, String requestedIP, String userAgent, String requestedURL){
        DataDTO dataDTO = new DataDTO();
        try {
            List<EsevaiDTO> data = esevaiPOCRepo.getEsevaiData(uid);
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
            LogDataPOC logData = new LogDataPOC();
            logData.setClientIp(requestedIP);
            logData.setUserAgent(userAgent);
            logData.setRequestUrl(requestedURL);
            logDataPOCRepo.save(logData);
            String token = jwtUtil.generateToken(String.valueOf(response));
            dataDTO.setData(token);
            return  dataDTO;
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

    public DataDTO getPDSData(String ufc, String requestIp ,String userAgent, String requestURL){
        DataDTO dataDTO = new DataDTO();
        try{
            List<PdsDataDTO> data = pdsDataPOCRepo.getUfcData(ufc);
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
            LogDataPOC logData = new LogDataPOC();
            logData.setClientIp(requestIp);
            logData.setUserAgent(userAgent);
            logData.setRequestUrl(requestURL);
            logDataPOCRepo.save(logData);
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
            List<UfcDTO> data = pdsDataPOCRepo.getUFCDist(dist, taluk, villg);
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
            LogDataPOC logData = new LogDataPOC();
            logData.setClientIp(requestIp);
            logData.setUserAgent(userAgent);
            logData.setRequestUrl(requestURL);
            logDataPOCRepo.save(logData);
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

    public DataDTO getMkklData(String uid, String ipaddress, String useragent, String requestURL){
        DataDTO dataDTO = new DataDTO();
        try {
            JsonObject responseDTO = new JsonObject();
            String srcPds = srcPdsPOCRepo.getMkklId(uid);
            responseDTO.addProperty("message","Success");
            responseDTO.addProperty("Status",true);
            responseDTO.addProperty("statusCode",200);
            System.out.println("SRcPDS"+"------------->"+srcPds);
            responseDTO.addProperty("Makkal_Id",srcPds);
            String token = jwtUtil.generateToken(String.valueOf(responseDTO));
            dataDTO.setData(token);
            LogDataPOC logData = new LogDataPOC();
            logData.setClientIp(ipaddress);
            logData.setUserAgent(useragent);
            logData.setRequestUrl(requestURL);
            logDataPOCRepo.save(logData);
            return dataDTO;
        }
        catch (Exception e){
            JsonObject responseDTO = new JsonObject();
            System.out.println("Exception : : "+e);
            responseDTO.addProperty("statusCode",500);
            responseDTO.addProperty("message",String.valueOf(e));
            responseDTO.addProperty("Status",false);
            responseDTO.addProperty("UFC","null");
            String token = jwtUtil.generateToken(String.valueOf(responseDTO));
            dataDTO.setData(token);
            return dataDTO;
        }
    }

    public DataDTO getAaddharData(String mkklId, String ipaddress, String useragent, String requestURL){
        DataDTO dataDTO = new DataDTO();
        try {
            JsonObject responseDTO = new JsonObject();
            String srcPds = srcPdsPOCRepo.getAadhaarId(mkklId);
            responseDTO.addProperty("message","Success");
            responseDTO.addProperty("Status",true);
            responseDTO.addProperty("statusCode",200);
            System.out.println("SRcPDS"+"------------->"+srcPds);
            responseDTO.addProperty("UID",srcPds);
            String token = jwtUtil.generateToken(String.valueOf(responseDTO));
            dataDTO.setData(token);
            LogDataPOC logData = new LogDataPOC();
            logData.setClientIp(ipaddress);
            logData.setUserAgent(useragent);
            logData.setRequestUrl(requestURL);
            logDataPOCRepo.save(logData);
            return dataDTO;
        }
        catch (Exception e){
            JsonObject responseDTO = new JsonObject();
            System.out.println("Exception : : "+e);
            responseDTO.addProperty("statusCode",500);
            responseDTO.addProperty("message",String.valueOf(e));
            responseDTO.addProperty("Status",false);
            responseDTO.addProperty("UFC","null");
            String token = jwtUtil.generateToken(String.valueOf(responseDTO));
            dataDTO.setData(token);
            return dataDTO;
        }
    }

}
