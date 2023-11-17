package com.restapi.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostRequest {

    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Title should have at least 2 characters")
    private String title;

    @NotEmpty
    @Size(min = 2, message = "Title should have at least 2 characters")
    private String content;

    @NotEmpty
    private String user_id;


}
