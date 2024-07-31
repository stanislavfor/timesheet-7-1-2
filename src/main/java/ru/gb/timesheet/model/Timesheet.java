//package ru.gb.timesheet.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//import java.time.LocalDate;
//
///**
// * Описание структуры json-ответа на REST-запросы.
// * Т.е. запросы, ответ на которые - JSON.
// */
//@Data
//@Entity
//@Table(name = "timesheet")
//public class Timesheet {
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @EqualsAndHashCode.Include
//  private Long id;
//  private Long projectId;
//  private Integer minutes;
//  private LocalDate createdAt;
//
//}

package ru.gb.timesheet.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Setter
@Getter
@Data
@Entity
public class Timesheet {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "project_id", nullable = false)
    private Long projectId;
    private String projectName;

    @Column(nullable = false)
    private int minutes;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;


}