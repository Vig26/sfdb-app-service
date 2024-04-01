package in.kpmg.sfdbappservice.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import in.kpmg.sfdbappservice.dto.DataDTO;
import in.kpmg.sfdbappservice.dto.ResponseDTO;
import in.kpmg.sfdbappservice.model.LogData;
import in.kpmg.sfdbappservice.model.SrcPds;
import in.kpmg.sfdbappservice.repository.LogDataRepo;
import in.kpmg.sfdbappservice.repository.SrcPdsRepo;
import in.kpmg.sfdbappservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdwdService {

    @Autowired
    SrcPdsRepo srcPdsRepo;

    @Autowired
    LogDataRepo logDataRepo;

    @Autowired
    JwtUtil jwtUtil;

    public DataDTO getAdwdData(String uid, String ipaddress, String useragent, String dept_name, String requestURL){
        DataDTO dataDTO = new DataDTO();
        try {
            JsonObject responseDTO = new JsonObject();
            String srcPds = srcPdsRepo.getUfc(uid);
            responseDTO.addProperty("message","Success");
            responseDTO.addProperty("Status",true);
            responseDTO.addProperty("statusCode",200);
            System.out.println("SRcPDS"+"------------->"+srcPds);
            responseDTO.addProperty("UFC",srcPds);
            String token = jwtUtil.generateToken(String.valueOf(responseDTO));
            dataDTO.setData(token);
            LogData logData = new LogData();
            logData.setClientIp(ipaddress);
            logData.setUserAgent(useragent);
            logData.setRequestUrl(requestURL);
            logData.setDeptName(dept_name);
            logDataRepo.save(logData);
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
    public DataDTO getMkklData(String uid, String ipaddress, String useragent, String dept_name, String requestURL){
        DataDTO dataDTO = new DataDTO();
        try {
            JsonObject responseDTO = new JsonObject();
            String srcPds = srcPdsRepo.getMkklId(uid);
            responseDTO.addProperty("message","Success");
            responseDTO.addProperty("Status",true);
            responseDTO.addProperty("statusCode",200);
            System.out.println("SRcPDS"+"------------->"+srcPds);
            responseDTO.addProperty("Makkal_Id",srcPds);
            String token = jwtUtil.generateToken(String.valueOf(responseDTO));
            dataDTO.setData(token);
            LogData logData = new LogData();
            logData.setClientIp(ipaddress);
            logData.setUserAgent(useragent);
            logData.setRequestUrl(requestURL);
            logData.setDeptName(dept_name);
            logDataRepo.save(logData);
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

    public DataDTO getAaddharData(String mkklId, String ipaddress, String useragent, String dept_name, String requestURL){
        DataDTO dataDTO = new DataDTO();
        try {
            JsonObject responseDTO = new JsonObject();
            String srcPds = srcPdsRepo.getAadhaarId(mkklId);
            responseDTO.addProperty("message","Success");
            responseDTO.addProperty("Status",true);
            responseDTO.addProperty("statusCode",200);
            System.out.println("SRcPDS"+"------------->"+srcPds);
            responseDTO.addProperty("UID",srcPds);
            String token = jwtUtil.generateToken(String.valueOf(responseDTO));
            dataDTO.setData(token);
            LogData logData = new LogData();
            logData.setClientIp(ipaddress);
            logData.setUserAgent(useragent);
            logData.setRequestUrl(requestURL);
            logData.setDeptName(dept_name);
            logDataRepo.save(logData);
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
