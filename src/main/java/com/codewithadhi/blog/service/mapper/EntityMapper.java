package com.codewithadhi.blog.service.mapper;

import com.codewithadhi.blog.domain.UserRtab;

public interface EntityMapper<D, E>{
    D toDto(E entity);
    E toEntity(D dto);
    UserRtab partialUpdate(D dto, E entity);
}
