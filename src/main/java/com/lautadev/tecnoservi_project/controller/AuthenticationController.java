package com.lautadev.tecnoservi_project.controller;

import com.lautadev.tecnoservi_project.dto.AuthLoginRequestDTO;
import com.lautadev.tecnoservi_project.dto.AuthLoginResponseDTO;
import com.lautadev.tecnoservi_project.service.IUserDetailsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class AuthenticationController {
    @Autowired
    private IUserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<AuthLoginResponseDTO> login (@RequestBody @Valid AuthLoginRequestDTO userRequest){
        return new ResponseEntity<>(this.userDetailsService.loginUser(userRequest), HttpStatus.OK);
    }
}
