package com.mateus.service;

import com.mateus.domain.dto.UserDTO;
import com.mateus.domain.dto.UserFormDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface UserService {

    UserDTO findById(Long id);

    Page<UserDTO> findAll(Pageable page);

    URI save(UserFormDTO userFormDTO);
}
