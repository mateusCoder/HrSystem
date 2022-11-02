package com.mateus.service.impl;

import com.mateus.domain.User;
import com.mateus.domain.dto.UserDTO;
import com.mateus.domain.dto.UserFormDTO;
import com.mateus.exception.ObjectNotFoundException;
import com.mateus.repository.UserRepository;
import com.mateus.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper mapper;

    private final Environment env;


    @Override
    public UserDTO findById(Long id) {
        log.info("USER_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port ");
        return mapper.map(userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User Not Found!")), UserDTO.class);
    }

    @Override
    public Page<UserDTO> findAll(Pageable page) {
        Page<User> users = userRepository.findAll(page);
        return users.map(e -> mapper.map(e, UserDTO.class));
    }

    @Override
    public URI save(UserFormDTO userFormDTO) {
        User user = mapper.map(userFormDTO, User.class);
        userRepository.save(user);
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(user.getId());
    }
}
