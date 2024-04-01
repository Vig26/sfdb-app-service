package in.kpmg.sfdbappservice.controller;

import in.kpmg.sfdbappservice.dto.DataDTO;
import in.kpmg.sfdbappservice.dto.ResponseDTO;
import in.kpmg.sfdbappservice.service.AdwdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdwdController {

    @Autowired
    AdwdService adwdService;

    @GetMapping("/{dept_name}/ufc/{uid}")
    public DataDTO adwd(@PathVariable String uid, @PathVariable String dept_name, HttpServletRequest request){
        String ipaddress = request.getRemoteAddr();
        String requestURL = request.getRequestURI();
        String useragent = request.getHeader("User-Agent");
        return adwdService.getAdwdData(uid,ipaddress,useragent, dept_name, requestURL);
    }

    @GetMapping("/{dept_name}/makkalid/{uid}")
    public DataDTO mkklid(@PathVariable String uid, @PathVariable String dept_name, HttpServletRequest request){
        String ipaddress = request.getRemoteAddr();
        String requestURL = request.getRequestURI();
        String useragent = request.getHeader("User-Agent");
        return adwdService.getMkklData(uid,ipaddress,useragent, dept_name, requestURL);
    }

    @GetMapping("/{dept_name}/aadhaarid/{mkklId}")
    public DataDTO aadhaarid(@PathVariable String mkklId, @PathVariable String dept_name, HttpServletRequest request){
        String ipaddress = request.getRemoteAddr();
        String requestURL = request.getRequestURI();
        String useragent = request.getHeader("User-Agent");
        return adwdService.getAaddharData(mkklId,ipaddress,useragent, dept_name, requestURL);
    }
}
