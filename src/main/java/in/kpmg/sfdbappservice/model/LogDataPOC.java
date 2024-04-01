package in.kpmg.sfdbappservice.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name="data_services_logs_poc")
@Data
public class LogDataPOC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="client_ip")
    private String clientIp;

    @CreationTimestamp
    @Column(name = "request_datetime")
    private Timestamp requestDateTime;

    @Column(name="user_agent")
    private String userAgent;

    @Column(name = "request_url")
    private  String requestUrl;

    @Column(name = "dept_name")
    private String deptName;
}
