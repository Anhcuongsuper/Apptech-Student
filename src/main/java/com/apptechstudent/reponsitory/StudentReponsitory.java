package com.apptechstudent.reponsitory;
import com.apptechstudent.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentReponsitory  extends JpaRepository<Student, String> {

}

