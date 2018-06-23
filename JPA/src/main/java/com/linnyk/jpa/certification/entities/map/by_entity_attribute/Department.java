package com.linnyk.jpa.certification.entities.map.by_entity_attribute;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DEPARTMENT_EA")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy="department", cascade = CascadeType.ALL)
    @MapKey(name = "id")
    private Map<Integer, Employee> employees = new HashMap<>();

}
