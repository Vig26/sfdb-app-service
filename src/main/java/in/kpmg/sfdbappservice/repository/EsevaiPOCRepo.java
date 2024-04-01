package in.kpmg.sfdbappservice.repository;


import in.kpmg.sfdbappservice.dto.EsevaiDTO;
import in.kpmg.sfdbappservice.model.EsevaiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EsevaiPOCRepo extends JpaRepository<EsevaiModel, Long> {

    @Query(value = "SELECT income._c1 as income_id, nativity._c1 as nativity_id, \n" +
            "first_grd._c1 as first_grad_id, community._c1 as community_id\n" +
            "FROM public.esevai_income_data_poc income \n" +
            "left join public.esevai_nativity_data_poc nativity on income.aadhar_from_pds = nativity.aadhar_from_pds \n" +
            "left join public.esevai_first_grad_poc first_grd on income.aadhar_from_pds = first_grd.aadhar_from_pds \n" +
            "left join public.esevai_community_data_poc community on income.aadhar_from_pds = community.aadhar_from_pds\n" +
            "where income.aadhar_from_pds = :uid limit 1 ;",nativeQuery = true)
    List<EsevaiDTO> getEsevaiData(String uid);
}
