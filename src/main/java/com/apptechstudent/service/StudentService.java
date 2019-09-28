package com.apptechstudent.service;
import com.apptechstudent.entity.Student;
import org.springframework.data.domain.Page;

public interface StudentService {


    Page<Student> getList(int page, int limit);

    Object getDetail(int id);

    Student login(String email, String password);

    Student register(Student student);

    Student update(String email, Student student);

    Student getByEmail(String email);


}
