package com.codewithadhi.blog.service.mapper.impl;

import com.codewithadhi.blog.domain.UserRtab;
import com.codewithadhi.blog.service.dto.UserRtabDTO;
import com.codewithadhi.blog.service.mapper.UserRtabMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserRtabMapperImpl implements UserRtabMapper {
    @Override
    public UserRtabDTO toDto(UserRtab entity) {
        if (Objects.isNull(entity)){
            return null;
        }

        return UserRtabDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .about(entity.getAbout())
                .build();
    }

    @Override
    public UserRtab toEntity(UserRtabDTO dto) {
        if (Objects.isNull(dto)){
            return null;
        }

        UserRtab entity = new UserRtab();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setAbout(dto.getAbout());

        return entity;

    }

    @Override
    public UserRtab partialUpdate(UserRtabDTO dto, UserRtab entity) {
        if (Objects.isNull(dto)){
            return null;
        }

        if (Objects.nonNull(dto.getName())){
            entity.setName(dto.getName());
        }
        if (Objects.nonNull(dto.getEmail())){
            entity.setName(dto.getEmail());
        }
        if (Objects.nonNull(dto.getPassword())){
            entity.setName(dto.getPassword());
        }
        if (Objects.nonNull(dto.getAbout())){
            entity.setName(dto.getAbout());
        }

        return entity;

    }
}
