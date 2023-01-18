package com.codewithadhi.blog.service.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull
    @NotNull
    private String name;
    @Email
    @NotNull
    @Size(max = 20)
    private String email;
    @NotNull
    @Size(min = 8, max = 20)
    private String password;
    private String about;
}
