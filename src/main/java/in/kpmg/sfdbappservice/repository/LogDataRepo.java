package in.kpmg.sfdbappservice.repository;

import in.kpmg.sfdbappservice.model.LogData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDataRepo extends JpaRepository <LogData, Integer> {

}
