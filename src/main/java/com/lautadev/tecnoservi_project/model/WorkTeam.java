package com.lautadev.tecnoservi_project.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "work_teams")
public class WorkTeam {
    private Long id;
    @OneToMany(mappedBy = "workTeam", cascade = CascadeType.ALL)
    List<Employed> employees;
}
