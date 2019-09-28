package com.apptechstudent.service;
import com.apptechstudent.entity.Student;
import com.apptechstudent.entity.Student;
import com.apptechstudent.reponsitory.StudentReponsitory;
import com.apptechstudent.reponsitory.StudentReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImplement implements StudentService{

    @Autowired
    private StudentReponsitory studentReponsitory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Page<Student> getList(int page, int limit) {

        return studentReponsitory.findAll(PageRequest.of(page -1, limit));
    }

    @Override
    public Student getDetail(int id) {

        return studentReponsitory.findById(String.valueOf(id)).orElse(null);
    }

        @Override
        public Student login(String email, String password) {
            //serach user ===
            Optional<Student> optionalStudent = studentReponsitory.findById(email);
            if (optionalStudent.isPresent()){
                Student student = optionalStudent.get();
                if (student.getPassword().equals(password)){
                    return student;
                }
            }
            return null;
        }


    @Override
    public Student register(Student student) {
            student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentReponsitory.save(student);
    }

    @Override
    public Student update(String email, Student student) {

        Optional<Student> optionalStudent = studentReponsitory.findById(email);
        if (optionalStudent == null){
            Student existStudent = optionalStudent.get();
            existStudent.setName(student.getName());
            existStudent.setPassword(student.getPassword());
            existStudent.setEmail(student.getEmail());
            existStudent.setCodeStudent(student.getCodeStudent());
            return studentReponsitory.save(student);

        }
        return null;
    }

    @Override
    public Student getByEmail(String email) {
        return studentReponsitory.findById(email).orElse(null);
    }
}
