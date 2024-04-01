package in.kpmg.sfdbappservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="pds_07_jul_2023")
@Data
public class SrcPds {

    @Column(name = "ufc")
    private String ufc;

    @Id
    @Column(name = "makkal_number")
    private String makkal_number;

    @Column(name = "name_in_english")
    private String name_in_english;

    @Column(name = "name_in_tamil")
    private  String name_in_tamil;

    @Column(name = "sex")
    private String sex;

    @Column(name = "address_line1")
    private String address_line1;

    @Column(name = "address_line2")
    private String address_line2;

    @Column(name = "address_line3")
    private String address_line3;

    @Column(name = "village_name")
    private String village_name;

    @Column(name = "taluk_name")
    private String taluk_name;

    @Column(name = "district_name")
    private String district_name;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "l_address_line1")
    private String l_address_line1;

    @Column(name = "l_address_line2")
    private  String l_address_line2;

    @Column(name = "l_address_line3")
    private String l_address_line3;

    @Column(name = "l_village_name")
    private String l_village_name;

    @Column(name = "l_taluk_name")
    private String l_taluk_name;

    @Column(name = "l_district_name")
    private String l_district_name;
}
