package kz.jusan.hrapp.repository;

import kz.jusan.hrapp.dto.UniversityInfoDto;
import kz.jusan.hrapp.model.form.UniversityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityInfoRepository extends JpaRepository<UniversityInfo, Long> {
    public List<UniversityInfo> findByUserId(Long userId);
}
