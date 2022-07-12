package kz.jusan.hrapp.repository;

import kz.jusan.hrapp.model.form.RelativesInJusan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelativesInJusanRepository extends JpaRepository<RelativesInJusan, Long> {
}
