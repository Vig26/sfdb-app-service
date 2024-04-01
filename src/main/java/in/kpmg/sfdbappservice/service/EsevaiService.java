package in.kpmg.sfdbappservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import in.kpmg.sfdbappservice.dto.DataDTO;
import in.kpmg.sfdbappservice.dto.EsevaiDTO;
import in.kpmg.sfdbappservice.model.LogData;
import in.kpmg.sfdbappservice.repository.EsevaiRepo;
import in.kpmg.sfdbappservice.repository.LogDataRepo;
import in.kpmg.sfdbappservice.util.JwtUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;

@Service
public class EsevaiService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    LogDataRepo logDataRepo;

    @Autowired
    EsevaiRepo esevaiRepo;

    public DataDTO getEsevai(String uid, String requestedIP, String userAgent, String requestedURL){
        DataDTO dataDTO = new DataDTO();
        try {
            List<EsevaiDTO>  data = esevaiRepo.getEsevaiData(uid);
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
            logData.setClientIp(requestedIP);
            logData.setUserAgent(userAgent);
            logData.setRequestUrl(requestedURL);
            logDataRepo.save(logData);
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
}
