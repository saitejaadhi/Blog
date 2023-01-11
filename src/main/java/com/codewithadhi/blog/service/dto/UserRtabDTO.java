package com.codewithadhi.blog.service.dto;

import jakarta.persistence.Id;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserRtabDTO {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private String about;
}
