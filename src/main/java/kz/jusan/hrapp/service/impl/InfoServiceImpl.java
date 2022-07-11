package kz.jusan.hrapp.service.impl;

import kz.jusan.hrapp.model.form.MainInfo;
import kz.jusan.hrapp.repository.MainInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InfoServiceImpl {

    private final MainInfoRepository mainInfoRepository;

    @Autowired
    public InfoServiceImpl(MainInfoRepository mainInfoRepository) {
        this.mainInfoRepository = mainInfoRepository;
    }

    public void save(MainInfo mainInfo){
        mainInfoRepository.save(mainInfo);
    }

    public Optional<MainInfo> findById(Long user_id) {
        return mainInfoRepository.findById(user_id);
    }
}
