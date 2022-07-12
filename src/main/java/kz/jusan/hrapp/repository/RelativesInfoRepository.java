package kz.jusan.hrapp.repository;

import kz.jusan.hrapp.model.form.RelativesInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelativesInfoRepository extends JpaRepository<RelativesInfo, Long> {
}
