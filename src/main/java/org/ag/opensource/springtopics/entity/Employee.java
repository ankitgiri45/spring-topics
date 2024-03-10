package org.ag.opensource.springtopics.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.ag.opensource.springtopics.model.constant.DepartmentEnum;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


@Data
@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "department", nullable = false)
    @Enumerated(EnumType.STRING)
    private DepartmentEnum department;

    @Column(name = "created_by", nullable = false, updatable = false)
    @CreatedBy
    private String createdBy;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Column(name = "updated_by", insertable = false)
    @LastModifiedBy
    private String updatedBy;

    @Column(name = "updated_date", insertable = false)
    @LastModifiedDate
    private Date updatedDate;
}


