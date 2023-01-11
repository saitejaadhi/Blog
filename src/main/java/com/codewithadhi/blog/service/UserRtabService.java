package com.codewithadhi.blog.service;

import com.codewithadhi.blog.service.dto.UserRtabDTO;

import java.util.List;


public interface UserRtabService {

    UserRtabDTO getUserById(Long userId);
    UserRtabDTO createUser (UserRtabDTO userRtabDTO);
    UserRtabDTO updateUser(UserRtabDTO userRtabDTO, Long userId);
    List<UserRtabDTO> getAllUsers();
    void deleteUserById(Long id);

}
