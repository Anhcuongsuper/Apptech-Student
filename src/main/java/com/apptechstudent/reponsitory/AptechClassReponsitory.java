package com.apptechstudent.reponsitory;

import com.apptechstudent.entity.AptechClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AptechClassReponsitory extends JpaRepository<AptechClass, Integer> {

}
