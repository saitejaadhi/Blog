package com.codewithadhi.blog.service.mapper;

import com.codewithadhi.blog.domain.UserRtab;
import com.codewithadhi.blog.service.dto.UserRtabDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserRtabMapper extends EntityMapper<UserRtabDTO, UserRtab>{
}
