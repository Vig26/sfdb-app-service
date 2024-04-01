package in.kpmg.sfdbappservice.controller;


import in.kpmg.sfdbappservice.dto.DataDTO;
import in.kpmg.sfdbappservice.service.PdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PdsController {

    @Autowired
    PdsService pdsService;

    @GetMapping("/{deptname}/pdsdata/{ufc}")
    public DataDTO getPDSData(@PathVariable String ufc, @PathVariable String deptname , HttpServletRequest request){
        String requestIp = request.getRemoteAddr();
        String requestURL = request.getRequestURI();
        System.out.println("URL"+requestURL);
        String userAgent = request.getHeader("User-Agent");
        return pdsService.getPDSData(ufc, requestIp, deptname ,userAgent ,requestURL);
    }

    @GetMapping("/dtv/ufcs/{dist}/{taluk}/{villg}")
    public DataDTO getUFCDist(@PathVariable String dist, @PathVariable String taluk, @PathVariable String villg , HttpServletRequest request){
        String requestIp = request.getRemoteAddr();
        String requestURL = request.getRequestURI();
        System.out.println("URL"+requestURL);
        String userAgent = request.getHeader("User-Agent");
        return pdsService.getUFCDist(dist, taluk, villg,  requestIp ,userAgent ,requestURL);
    }
}
