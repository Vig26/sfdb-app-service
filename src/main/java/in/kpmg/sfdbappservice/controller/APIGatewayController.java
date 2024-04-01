package in.kpmg.sfdbappservice.controller;


import in.kpmg.sfdbappservice.dto.DataDTO;
import in.kpmg.sfdbappservice.service.APIGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class APIGatewayController {

    @Autowired
    APIGatewayService apiGatewayService;


    @GetMapping("apigateway/esevai/certificateIds/{uid}")
    public DataDTO esevai(@PathVariable String uid, HttpServletRequest request){
        String ipaddress = request.getRemoteAddr();
        String requestURL = request.getRequestURI();
        String useragent = request.getHeader("User-Agent");
        return apiGatewayService.getEsevai(uid,ipaddress,useragent,requestURL);
    }

    @GetMapping("apigateway/makkalid/{uid}")
    public DataDTO mkklid(@PathVariable String uid,  HttpServletRequest request){
        String ipaddress = request.getRemoteAddr();
        String requestURL = request.getRequestURI();
        String useragent = request.getHeader("User-Agent");
        return apiGatewayService.getMkklData(uid,ipaddress,useragent, requestURL);
    }

    @GetMapping("apigateway/aadhaarid/{mkklId}")
    public DataDTO aadhaarid(@PathVariable String mkklId,  HttpServletRequest request){
        String ipaddress = request.getRemoteAddr();
        String requestURL = request.getRequestURI();
        String useragent = request.getHeader("User-Agent");
        return apiGatewayService.getAaddharData(mkklId,ipaddress,useragent, requestURL);
    }


    @GetMapping("apigateway/pdsdata/{ufc}")
    public DataDTO getPDSData(@PathVariable String ufc, HttpServletRequest request){
        String requestIp = request.getRemoteAddr();
        String requestURL = request.getRequestURI();
        System.out.println("URL"+requestURL);
        String userAgent = request.getHeader("User-Agent");
        return apiGatewayService.getPDSData(ufc, requestIp ,userAgent ,requestURL);
    }

    @GetMapping("apigateway/dtv/ufcs/{dist}/{taluk}/{villg}")
    public DataDTO getUFCDist(@PathVariable String dist, @PathVariable String taluk, @PathVariable String villg , HttpServletRequest request){
        String requestIp = request.getRemoteAddr();
        String requestURL = request.getRequestURI();
        System.out.println("URL"+requestURL);
        String userAgent = request.getHeader("User-Agent");
        return apiGatewayService.getUFCDist(dist, taluk, villg,  requestIp ,userAgent ,requestURL);
    }
}
