package in.kpmg.sfdbappservice.dto;

import com.google.gson.JsonObject;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
public class ResponseDTO {
    private Boolean status;
    private Integer statusCode;
    private String message;
    private JsonObject data ;
}
