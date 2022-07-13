package kz.jusan.hrapp.repository;

import kz.jusan.hrapp.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
    public List<FileDB> findByUserId(Long userId);

    public Optional<FileDB> findByData(byte[] data);
}