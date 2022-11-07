package com.example.lab3.domain.dto.response;

import com.example.lab3.domain.User;

import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public
class PostDto {
   Integer id;
   String content;
   String title;
   List<CommentDto> comments;
}
