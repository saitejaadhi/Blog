package com.codewithadhi.blog.service.impl;

import com.codewithadhi.blog.domain.UserRtab;
import com.codewithadhi.blog.execptions.BlogAppServiceException;
import com.codewithadhi.blog.repositories.UserRtabRepository;
import com.codewithadhi.blog.service.UserRtabService;
import com.codewithadhi.blog.service.dto.UserRtabDTO;
import com.codewithadhi.blog.service.mapper.impl.UserRtabMapperImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserRtabServiceImpl implements UserRtabService {
    private final UserRtabRepository userRtabRepository;
    private final UserRtabMapperImpl userRtabMapper;

    @Override
    public UserRtabDTO getUserById(Long id) {
        log.info("REST request to find User by id {}", id);

        UserRtab userRtab = this.userRtabRepository.findById(id).
                orElseThrow(() -> new BlogAppServiceException("User not found for id : ".concat(String.valueOf(id))));

        return this.userRtabMapper.toDto(userRtab);
    }

    @Override
    public UserRtabDTO createUser(UserRtabDTO userRtabDTO) {
        UserRtab userRtab = this.userRtabMapper.toEntity(userRtabDTO);
        UserRtab savedUserRtab = this.userRtabRepository.save(userRtab);
        return this.userRtabMapper.toDto(savedUserRtab);
    }

    @Override
    public UserRtabDTO partialUpdate(UserRtabDTO userRtabDTO) {

        UserRtab existingUserRtab = this.userRtabRepository.findById(userRtabDTO.getId())
                .orElseThrow(() -> new BlogAppServiceException("User not found for id :".concat(String.valueOf(userRtabDTO.getId()))));

        UserRtab updatedUserRtab = userRtabMapper.partialUpdate(userRtabDTO, existingUserRtab);
        this.userRtabRepository.save(updatedUserRtab);
        return this.userRtabMapper.toDto(updatedUserRtab);

    }
    @Override
    public List<UserRtabDTO> getAllUsers() {
        log.info("REST request to find all users");

        return userRtabRepository.findAll()
                .stream()
                .map(userRtabMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUserById(Long id) {
        log.info("REST request to delete for user id :{}", id);

        UserRtab userRtab = this.userRtabRepository.findById(id).orElseThrow(() -> new BlogAppServiceException("Exception occurred, no user found with id :".concat(String.valueOf(id))));
        userRtabRepository.delete(userRtab);
    }
}
