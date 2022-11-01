package com.mateus.feignClients;

import com.mateus.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-api", url = "http://localhost:8080")
public interface UserFeign {

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id);

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)
                                                 Pageable pageable);

}
