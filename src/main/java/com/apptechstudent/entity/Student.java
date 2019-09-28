package com.apptechstudent.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int studentId;
@NotNull(message = "Not empty")
@Size(max = 50, min = 7, message = "Name is charset max 50, min 7")
    private String name;
    @Email(message = "email not format")

    private String email;
    private String password;
 @Size(min = 7, max = 7, message = "code 7")
    private String codeStudent;

    private String role;

    public enum Role{
        ADMIN("admin"), USER("user");
        private String value;
        Role(String user){
            this.value = user;
        }
        public String getValue(){
            return value;
        }
        public void setValue(String value){
            this.value = value;
        }
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
        @ManyToMany(mappedBy = "studentSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Set<AptechClass> classNameSet;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Set<AptechClass> getClassNameSet() {
        return classNameSet;
    }

    public void setClassNameSet(Set<AptechClass> classNameSet) {
        this.classNameSet = classNameSet;
    }

    public int getId() {
        return studentId ;
    }

    public void setId(int id) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(String codeStudent) {
        this.codeStudent = codeStudent;
    }
}
