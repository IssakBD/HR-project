package kz.jusan.hrapp.repository;

import kz.jusan.hrapp.dto.RelativesInfoDto;
import kz.jusan.hrapp.model.form.RelativesInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelativesInfoRepository extends JpaRepository<RelativesInfo, Long> {
    public List<RelativesInfo> findByUserId(Long userId);
}
