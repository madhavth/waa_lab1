package com.example.lab2.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
class PostDto {
    private Integer id;
    private String content;
    private String title;
}
