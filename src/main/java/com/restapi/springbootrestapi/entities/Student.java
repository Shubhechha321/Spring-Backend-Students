package com.restapi.springbootrestapi.entities;


import javax.persistence.*;


@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name="name", length=50, nullable=false, unique=false)
    private String name;
    private String phone;
    private String code;

    public Student(Long id, String name, String phone, String code) {
        super();
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.code = code;
    }
//public Student(String name, String phone, String code) {
//    super();
//    this.name = name;
//    this.phone = phone;
//    this.code = code;
//}
    public Student() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
