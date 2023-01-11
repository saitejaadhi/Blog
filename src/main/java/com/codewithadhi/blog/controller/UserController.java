package com.codewithadhi.blog.controller;

import com.codewithadhi.blog.service.UserRtabService;
import com.codewithadhi.blog.service.dto.UserRtabDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// POST - to create user
    // PUT - update the user
    // DELETE - to delete a user
    // GET - to get the user
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Log4j2
public class UserController {
    private final UserRtabService userRtabService;
    @PostMapping("/")
    public ResponseEntity<UserRtabDTO> createUser(@RequestBody UserRtabDTO userRtabDTO){
        log.info("REST request to create user for :{}",userRtabDTO.toString());

        UserRtabDTO createdUser = this.userRtabService.createUser(userRtabDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
