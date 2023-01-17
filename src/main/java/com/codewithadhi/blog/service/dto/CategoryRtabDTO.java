package com.codewithadhi.blog.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryRtabDTO {

    private Long id;
    private String categoryTitle;
    private String categoryDescription;
}
