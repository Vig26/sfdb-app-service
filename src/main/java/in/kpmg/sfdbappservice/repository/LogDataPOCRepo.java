package in.kpmg.sfdbappservice.repository;

import in.kpmg.sfdbappservice.model.LogDataPOC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDataPOCRepo extends JpaRepository <LogDataPOC, Integer> {
}
