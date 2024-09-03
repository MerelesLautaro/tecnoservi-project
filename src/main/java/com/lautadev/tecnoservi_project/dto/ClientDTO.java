package com.lautadev.tecnoservi_project.dto;

import com.lautadev.tecnoservi_project.model.Client;
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
public class ClientDTO {
    private Long id;
    private String name;
    private String lastname;
    private String address;
    private String dni;
    private String email;
    private String cel;
    private List<OrderDTO> orderDTOList;

    public static ClientDTO fromClient(Client client){
        if(client == null){
            return null;
        }

        List<OrderDTO> orderDTOS = new ArrayList<>();
        if(client.getOrderList()  != null ){
            orderDTOS = client.getOrderList().stream()
                    .map(OrderDTO::fromOrder)
                    .collect(Collectors.toList());
        }

        return new ClientDTO(
                client.getId(),
                client.getName(),
                client.getLastname(),
                client.getAddress(),
                client.getDni(),
                client.getEmail(),
                client.getCel(),
                orderDTOS
        );
    }

}
