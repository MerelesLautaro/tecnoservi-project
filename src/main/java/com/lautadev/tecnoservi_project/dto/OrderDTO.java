package com.lautadev.tecnoservi_project.dto;

import com.lautadev.tecnoservi_project.model.Order;
import com.lautadev.tecnoservi_project.model.State;
import com.lautadev.tecnoservi_project.model.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private String address;
    private String nameClient;
    private LocalDateTime date;
    private Task task;
    private State state;
    private WorkTeamDTO workTeamDTO;

    public static OrderDTO fromOrder(Order order){
        if(order == null){
            return null;
        }

        WorkTeamDTO workTeamDTO = WorkTeamDTO.fromWorkTeam(order.getWorkTeam());

        return new OrderDTO(
                order.getId(),
                order.getClient().getAddress(),
                order.getClient().getName(),
                order.getDate(),
                order.getTask(),
                order.getState(),
                workTeamDTO
        );

    }
}
