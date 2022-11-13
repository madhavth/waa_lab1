package com.example.lab3.domain.dto.response;

import com.example.lab3.domain.Role;
import com.example.lab3.domain.dto.RoleDto;

import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    long id;
    String name;
    
    @JsonIgnore
    String password;
    List<PostDto> posts;
    List<RoleDto> roles;
}
