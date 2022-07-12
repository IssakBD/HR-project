package kz.jusan.hrapp.repository;

import kz.jusan.hrapp.model.form.MainInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MainInfoRepository extends JpaRepository<MainInfo, Long> {
    public Optional<MainInfo> findByUserId(Long userId);
}
