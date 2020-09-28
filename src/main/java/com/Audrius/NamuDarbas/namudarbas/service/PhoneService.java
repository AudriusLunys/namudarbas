package com.Audrius.NamuDarbas.namudarbas.service;

import com.Audrius.NamuDarbas.namudarbas.model.Phone;
import com.Audrius.NamuDarbas.namudarbas.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhoneService {

    private  final PhoneRepository phoneRepository;
    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public Phone findByID(Long id){
      return phoneRepository.getOne(id);
    }

    public List<Phone> findAll () {
     return phoneRepository.findAll();
    }

    public Phone savePhone (Phone phone){
     return phoneRepository.save(phone);
    }

    public void deleteById(Long id){
     phoneRepository.deleteById(id);
    }
}
