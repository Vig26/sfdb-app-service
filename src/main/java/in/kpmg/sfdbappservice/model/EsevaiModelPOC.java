package in.kpmg.sfdbappservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@Table(name="esevai_income_data_poc")
public class EsevaiModelPOC {
    @Id
    @Column(name = "aadhar_from_pds")
    private String aadhar_from_pds;

    @Column(name= "_c1")
    private String _c1;
}
