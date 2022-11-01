package com.mateus.controller;

import com.mateus.domain.dto.UserDTO;
import com.mateus.domain.dto.UserFormDTO;
import com.mateus.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)
                                                 Pageable pageable){
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserFormDTO userFormDTO){
        return ResponseEntity.created(userService.save(userFormDTO)).build();
    }
}
