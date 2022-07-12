package kz.jusan.hrapp.repository;

import kz.jusan.hrapp.model.form.ChildrenInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildrenInfoRepository extends JpaRepository<ChildrenInfo, Long> {
}
