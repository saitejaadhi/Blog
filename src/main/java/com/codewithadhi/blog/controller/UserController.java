package com.codewithadhi.blog.controller;

import com.codewithadhi.blog.payload.ApiResponse;
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
    public ResponseEntity<UserRtabDTO> createUser(@RequestBody UserRtabDTO userRtabDTO) {
        log.info("REST request to create user for :{}", userRtabDTO.toString());

        return new ResponseEntity<>(userRtabService.createUser(userRtabDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserRtabDTO> updateUser(@RequestBody UserRtabDTO userRtabDTO, @PathVariable Long userId) {
        log.info("REST request to update user of id:{}", userId);

        return ResponseEntity.ok(userRtabService.updateUser(userRtabDTO, userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        log.info("REST request to delete user of id:{}", userId);

        try {
            userRtabService.deleteUserById(userId);
            return ResponseEntity.ok(ApiResponse.builder()
                    .message("User deleted successfully")
                    .success(Boolean.TRUE)
                    .build());
        }
        catch (Exception e){
            return ResponseEntity.internalServerError()
                    .body(ApiResponse.builder()
                            .message("User deletion failed")
                            .success(Boolean.FALSE)
                            .build());
        }

    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        log.info("REST request to get all users");
        return ResponseEntity.ok(userRtabService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        log.info("REST request to get all users");
        return ResponseEntity.ok(userRtabService.getUserById(userId));
    }

}
