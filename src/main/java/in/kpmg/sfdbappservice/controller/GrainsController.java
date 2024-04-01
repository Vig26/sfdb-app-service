package in.kpmg.sfdbappservice.controller;

import in.kpmg.sfdbappservice.dto.DataDTO;
import in.kpmg.sfdbappservice.dto.GrainsInputDTO;
import in.kpmg.sfdbappservice.dto.ResponseDTO;
import in.kpmg.sfdbappservice.service.GrainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GrainsController {

    @Autowired
    GrainsService grainsservice;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{deptName}/pdsinfo/{uid}")
    public DataDTO grains(@PathVariable String uid, @PathVariable String deptName , HttpServletRequest request){
        String requestIp = request.getRemoteAddr();
        String requestURL = request.getRequestURI();
        System.out.println("URL"+requestURL);
        String userAgent = request.getHeader("User-Agent");
        return grainsservice.getGrainsData(uid, requestIp, userAgent, deptName, requestURL);
    }
}
