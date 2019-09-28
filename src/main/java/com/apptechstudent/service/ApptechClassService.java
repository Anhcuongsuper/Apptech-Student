package com.apptechstudent.service;

import com.apptechstudent.controller.ApptechClassController;
import com.apptechstudent.entity.AptechClass;
import com.apptechstudent.reponsitory.AptechClassReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ApptechClassService {
@Autowired
    AptechClassReponsitory aptechClassReponsitory;

    public Page<AptechClass> getList(int page, int limit){
        return   aptechClassReponsitory.findAll(PageRequest.of(page -1, limit));

    }

    public AptechClass getDetail(int id){
        return aptechClassReponsitory.findById(id).orElse(null);
    }
}
