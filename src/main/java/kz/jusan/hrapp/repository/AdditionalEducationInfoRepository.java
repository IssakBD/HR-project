package kz.jusan.hrapp.repository;

import kz.jusan.hrapp.dto.AdditionalEducationInfoDto;
import kz.jusan.hrapp.model.form.AdditionalEducationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionalEducationInfoRepository extends JpaRepository<AdditionalEducationInfo, Long> {
    public List<AdditionalEducationInfo> findByUserId(Long userId);
}
