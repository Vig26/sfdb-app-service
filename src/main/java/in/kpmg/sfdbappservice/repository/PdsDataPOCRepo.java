//package in.kpmg.sfdbappservice.repository;
//
//
//import in.kpmg.sfdbappservice.dto.PdsDataDTO;
//import in.kpmg.sfdbappservice.dto.UfcDTO;
//import in.kpmg.sfdbappservice.model.SrcPdsPOC;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface PdsDataPOCRepo extends JpaRepository<SrcPdsPOC, Long> {
//
//    @Query(value = "SELECT name_in_english as nameEng, name_in_tamil as nameTam, sex, address_line1 as addressL1, address_line2 as addressL2, address_line3 as addressL3, village_name as villageName, taluk_name as talukName, district_name as districtName, pincode, l_address_line1 as lAddress1, l_address_line2 as lAddress2, l_address_line3 as lAddress3, l_village_name as lVillage, l_taluk_name as lTaluk, l_district_name as lDistrictName, makkal_number as makkalNum FROM public.pds_07_jul_2023_poc where ufc = :ufc ;",nativeQuery = true)
//    List<PdsDataDTO> getUfcData(String ufc);
//
//    @Query(value = "SELECT distinct(ufc) as Ufc FROM public.pds_07_jul_2023_poc where district_name like  :dist% and taluk_name like :taluk% and village_name like :villg% ;",nativeQuery = true)
//    List<UfcDTO> getUFCDist(String dist, String taluk, String villg);
//
//}
