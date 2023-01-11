package com.codewithadhi.blog.service;

import com.codewithadhi.blog.service.dto.UserRtabDTO;

import java.util.List;


public interface UserRtabService {

    UserRtabDTO getUserById(Long id);
    UserRtabDTO createUser (UserRtabDTO userRtabDTO);
    UserRtabDTO partialUpdate(UserRtabDTO userRtabDTO);
    List<UserRtabDTO> getAllUsers();
    void deleteUserById(Long id);

}
