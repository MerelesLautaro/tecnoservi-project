package com.lautadev.tecnoservi_project.dto;

import com.lautadev.tecnoservi_project.model.WorkTeam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkTeamDTO {
    private Long id;
    private String name;
    private List<EmployedDTO> employedDTOS;

    public static WorkTeamDTO fromWorkTeam(WorkTeam workTeam){
        if(workTeam == null){
            return null;
        }

        List<EmployedDTO> employedDTOList = new ArrayList<>();
        if(workTeam.getEmployees() != null){
            employedDTOList = workTeam.getEmployees().stream()
                    .map(EmployedDTO::fromEmployed)
                    .collect(Collectors.toList());
        }

        return new WorkTeamDTO(
                workTeam.getId(),
                workTeam.getName(),
                employedDTOList
        );
    }
}
