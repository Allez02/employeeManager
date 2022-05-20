package com.employeemanager.employeeManager.service;

import com.employeemanager.employeeManager.models.AdsModels;
import com.employeemanager.employeeManager.repo.AdsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdsServiceImpl {

    private final AdsRepository adsRepository;

    public List<AdsModels> getAll() {
        List<AdsModels> resultList = new ArrayList<>();
        adsRepository.findAll(Sort.by(List.of(Sort.Order.desc("id")))).forEach(resultList::add);
        return resultList;
    }

    public void adsAdd(String title, String full_text) {
        AdsModels adsModels = new AdsModels(title, full_text);
        adsRepository.save(adsModels);
    }

    public List<AdsModels> getById(long id) {
        Optional<AdsModels> adsModel= adsRepository.findById(id);
        List<AdsModels> ads = new ArrayList<>();
        adsModel.ifPresent(ads::add);
        return ads;
    }

    public void adsDelete(long id) {
        adsRepository.deleteById(id);
    }

    public void adsEdite(long id, String title, String fullText) {
        AdsModels adsModels = adsRepository.findById(id).orElseThrow();
        adsModels.setName(title);
        adsModels.setText(fullText);
        adsRepository.save(adsModels);
    }

    public boolean existsId(long id) {
        return adsRepository.existsById(id);
    }
}
