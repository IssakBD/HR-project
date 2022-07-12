package kz.jusan.hrapp.repository;

import kz.jusan.hrapp.model.form.AdditionalEducationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalEducationInfoRepository extends JpaRepository<AdditionalEducationInfo, Long> {
}
