package com.lautadev.tecnoservi_project.dto;

import com.lautadev.tecnoservi_project.model.Employed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployedDTO {
    private Long id;
    private String name;
    private String lastname;
    private String dni;
    private String email;
    private String cel;
    private String workTeamName;

    public static EmployedDTO fromEmployed(Employed employed){
        if(employed == null){
            return null;
        }

        return new EmployedDTO(
                employed.getId(),
                employed.getName(),
                employed.getLastname(),
                employed.getDni(),
                employed.getEmail(),
                employed.getCel(),
                employed.getWorkTeam().getName()
        );
    }
}
