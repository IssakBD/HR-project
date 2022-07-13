package kz.jusan.hrapp.repository;

import kz.jusan.hrapp.dto.RelativesInJusanDto;
import kz.jusan.hrapp.model.form.RelativesInJusan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelativesInJusanRepository extends JpaRepository<RelativesInJusan, Long> {
    public List<RelativesInJusan> findByUserId(Long userId);
}
