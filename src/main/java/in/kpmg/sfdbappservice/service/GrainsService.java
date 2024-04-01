package in.kpmg.sfdbappservice.service;

import com.google.gson.JsonObject;
import in.kpmg.sfdbappservice.dto.DataDTO;
import in.kpmg.sfdbappservice.dto.PdsDataDTO;
import in.kpmg.sfdbappservice.dto.ResponseDTO;
import in.kpmg.sfdbappservice.model.LogData;
import in.kpmg.sfdbappservice.repository.LogDataRepo;
import in.kpmg.sfdbappservice.repository.SrcPdsRepo;
import in.kpmg.sfdbappservice.util.JwtUtil;
import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GrainsService {

    @Autowired
    SrcPdsRepo srcPdsRepo;

    @Autowired
    LogDataRepo logDataRepo;

    @Autowired
    JwtUtil jwtUtil;
    public DataDTO getGrainsData(String uid, String requestIp, String userAgent, String deptName, String requestURL) {
       ResponseDTO responseDTO = new ResponseDTO();

       DataDTO dataDTO = new DataDTO();
       try {
           PdsDataDTO pdsDataDTO = srcPdsRepo.getPdsData(uid);
           if(deptName.equals("tnsdc")){
               JsonObject response =  new JsonObject();
               response.addProperty("message","Success");
               JsonObject map = new JsonObject();
               map.addProperty("makkal_number",pdsDataDTO.getMakkalNum());
               map.addProperty("name_in_english",pdsDataDTO.getNameEng());
               map.addProperty("name_in_tamil",pdsDataDTO.getNameTam());
               map.addProperty("sex",pdsDataDTO.getSex());
               map.addProperty("village_name",pdsDataDTO.getVillageName());
               map.addProperty("taluk_name",pdsDataDTO.getTalukName());
               map.addProperty("district_name",pdsDataDTO.getDistrictName());
               map.addProperty("pincode",pdsDataDTO.getPincode());
               response.add("Data",map);
               response.addProperty("Status",true);
               response.addProperty("statusCode",200);
               LogData logData = new LogData();
               logData.setUserAgent(userAgent);
               logData.setClientIp(requestIp);
               logData.setRequestUrl(requestURL);
               logData.setDeptName(deptName);
               logDataRepo.save(logData);
               System.out.println("Data"+response);
               String token = jwtUtil.generateToken(String.valueOf(response));
               dataDTO.setData(token);
               return dataDTO;
           }
           else if(deptName.equals("tnuhdb")){
               JsonObject response =  new JsonObject();
               response.addProperty("message","Success");
               JsonObject map = new JsonObject();
               map.addProperty("makkal_number",pdsDataDTO.getMakkalNum());
               map.addProperty("name_in_english",pdsDataDTO.getNameEng());
               map.addProperty("name_in_tamil",pdsDataDTO.getNameTam());
               map.addProperty("sex",pdsDataDTO.getSex());
               map.addProperty("village_name",pdsDataDTO.getVillageName());
               map.addProperty("taluk_name",pdsDataDTO.getTalukName());
               map.addProperty("district_name",pdsDataDTO.getDistrictName());
               map.addProperty("pincode",pdsDataDTO.getPincode());
               response.add("Data",map);
               response.addProperty("Status",true);
               response.addProperty("statusCode",200);
               LogData logData = new LogData();
               logData.setUserAgent(userAgent);
               logData.setClientIp(requestIp);
               logData.setRequestUrl(requestURL);
               logData.setDeptName(deptName);
               logDataRepo.save(logData);
               System.out.println("Data"+response);
               String token = jwtUtil.generateToken(String.valueOf(response));
               dataDTO.setData(token);
               return dataDTO;
           }
           else if(deptName.equals("grains")){
               JsonObject response =  new JsonObject();
               response.addProperty("message","Success");
               JsonObject map = new JsonObject();
               map.addProperty("makkal_number",pdsDataDTO.getMakkalNum());
               map.addProperty("name_in_english",pdsDataDTO.getNameEng());
               map.addProperty("name_in_tamil",pdsDataDTO.getNameTam());
               map.addProperty("sex",pdsDataDTO.getSex());
               map.addProperty("address_line1",pdsDataDTO.getAddressL1());
               map.addProperty("address_line2",pdsDataDTO.getAddressL2());
               map.addProperty("address_line3",pdsDataDTO.getAddressL3());
               map.addProperty("village_name",pdsDataDTO.getVillageName());
               map.addProperty("taluk_name",pdsDataDTO.getTalukName());
               map.addProperty("district_name",pdsDataDTO.getDistrictName());
               map.addProperty("pincode",pdsDataDTO.getPincode());
               map.addProperty("l_address_line1",pdsDataDTO.getLAddress1());
               map.addProperty("l_address_line2",pdsDataDTO.getLAddress2());
               map.addProperty("l_address_line3",pdsDataDTO.getLAddress3());
               map.addProperty("l_village_name",pdsDataDTO.getLVillage());
               map.addProperty("l_taluk_name",pdsDataDTO.getLTaluk());
               map.addProperty("l_district_name",pdsDataDTO.getLDistrictName());
               response.add("Data",map);
               response.addProperty("Status",true);
               response.addProperty("statusCode",200);
               LogData logData = new LogData();
               logData.setUserAgent(userAgent);
               logData.setClientIp(requestIp);
               logData.setRequestUrl(requestURL);
               logData.setDeptName(deptName);
               logDataRepo.save(logData);
               System.out.println("Data"+response);
               String token = jwtUtil.generateToken(String.valueOf(response));
               dataDTO.setData(token);
               return dataDTO;
           }
           else {
               JsonObject response =  new JsonObject();
               response.addProperty("message","Failed");
               response.addProperty("Data","Please enter valid department Name.");
               response.addProperty("Status",false);
               response.addProperty("statusCode",400);
               String token = jwtUtil.generateToken(String.valueOf(response));
               dataDTO.setData(token);
               return dataDTO;
           }
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
