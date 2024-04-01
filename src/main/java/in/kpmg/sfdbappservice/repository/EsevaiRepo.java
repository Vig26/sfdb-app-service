package in.kpmg.sfdbappservice.repository;

import in.kpmg.sfdbappservice.dto.EsevaiDTO;
import in.kpmg.sfdbappservice.dto.PdsDataDTO;
import in.kpmg.sfdbappservice.model.EsevaiModel;
import in.kpmg.sfdbappservice.model.SrcPds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EsevaiRepo extends JpaRepository<EsevaiModel, Long> {

    @Query(value = "SELECT income._c1 as income_id, nativity._c1 as nativity_id, first_grd._c1 as first_grad_id, community._c1 as community_id FROM public.esevai_income_data income left join public.esevai_nativity_data nativity on income.aadhar_from_pds = nativity.aadhar_from_pds left join public.esevai_first_grad first_grd on income.aadhar_from_pds = first_grd.aadhar_from_pds left join public.esevai_community_data community on income.aadhar_from_pds = community.aadhar_from_pds where income.aadhar_from_pds = :uid ;",nativeQuery = true)
    List<EsevaiDTO> getEsevaiData(String uid);
}
