package com.restapi.request;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostRequest {

    private Long id;


    @Size(min = 5, message = "Title should have at least 5 characters")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Long user_id;

    private String role;


}
