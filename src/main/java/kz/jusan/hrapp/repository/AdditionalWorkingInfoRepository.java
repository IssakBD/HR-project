package kz.jusan.hrapp.repository;

import kz.jusan.hrapp.model.form.AdditionalWorkingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalWorkingInfoRepository extends JpaRepository<AdditionalWorkingInfo, Long> {
}
