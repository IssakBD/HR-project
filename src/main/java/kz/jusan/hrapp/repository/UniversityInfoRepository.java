package kz.jusan.hrapp.repository;

import kz.jusan.hrapp.model.form.UniversityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityInfoRepository extends JpaRepository<UniversityInfo, Long> {
}
