package in.kpmg.sfdbappservice.controller;


import in.kpmg.sfdbappservice.dto.DataDTO;
import in.kpmg.sfdbappservice.service.EsevaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EsevaiController {

    @Autowired
    EsevaiService esevaiService;

    @GetMapping("/esevai/certificateIds/{uid}")
    public DataDTO esevai(@PathVariable String uid, HttpServletRequest request){
        String ipaddress = request.getRemoteAddr();
        String requestURL = request.getRequestURI();
        String useragent = request.getHeader("User-Agent");
        return esevaiService.getEsevai(uid,ipaddress,useragent,requestURL);
    }
}
