package kz.jusan.hrapp.repository;

import kz.jusan.hrapp.dto.AdditionalWorkingInfoDto;
import kz.jusan.hrapp.model.form.AdditionalWorkingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionalWorkingInfoRepository extends JpaRepository<AdditionalWorkingInfo, Long> {
    public List<AdditionalWorkingInfo> findByUserId(Long userId);
}
