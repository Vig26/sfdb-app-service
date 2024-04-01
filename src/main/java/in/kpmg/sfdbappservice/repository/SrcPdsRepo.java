package in.kpmg.sfdbappservice.repository;

import in.kpmg.sfdbappservice.dto.PdsDataDTO;
import in.kpmg.sfdbappservice.model.SrcPds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SrcPdsRepo extends JpaRepository<SrcPds, Long> {

    @Query(value = "SELECT ufc FROM public.pds_07_jul_2023 where uid = :uid  ;",nativeQuery = true)
    String getUfc(String uid);

    @Query(value = "SELECT makkal_number FROM public.pds_07_jul_2023 where uid = :uid  ;",nativeQuery = true)
    String getMkklId(String uid);

    @Query(value = "SELECT uid FROM public.pds_07_jul_2023 where makkal_number = :mkklId  ;",nativeQuery = true)
    String getAadhaarId(String mkklId);

    @Query(value = "SELECT name_in_english as nameEng, name_in_tamil as nameTam, sex, address_line1 as addressL1, address_line2 as addressL2, address_line3 as addressL3, village_name as villageName, taluk_name as talukName, district_name as districtName, pincode, l_address_line1 as lAddress1, l_address_line2 as lAddress2, l_address_line3 as lAddress3, l_village_name as lVillage, l_taluk_name as lTaluk, l_district_name as lDistrictName, makkal_number as makkalNum FROM public.pds_07_jul_2023 where uid = :uid ;", nativeQuery = true)
    PdsDataDTO getPdsData(String uid);

}
