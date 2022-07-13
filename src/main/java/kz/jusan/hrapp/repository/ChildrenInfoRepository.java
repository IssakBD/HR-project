package kz.jusan.hrapp.repository;

import kz.jusan.hrapp.dto.ChildrenInfoDto;
import kz.jusan.hrapp.model.form.ChildrenInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildrenInfoRepository extends JpaRepository<ChildrenInfo, Long> {
    public List<ChildrenInfo> findByUserId(Long userId);
}
