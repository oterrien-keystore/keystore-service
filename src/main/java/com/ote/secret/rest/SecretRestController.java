package com.ote.secret.rest;


import com.ote.domain.secret.api.ISecretService;
import com.ote.domain.secret.business.NotFoundException;
import com.ote.secret.peristence.SecretEntityMapperService;
import com.ote.secret.peristence.SecretJpaRepository;
import com.ote.secret.service.SecretServiceAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/secrets")
@Slf4j
public class SecretRestController {

    @Autowired
    private ISecretService secretServiceAdapter;

    @Autowired
    private SecretPayloadMapperService secretPayloadMapperService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void createSecret(@RequestBody SecretPayload payload) {
        secretServiceAdapter.create(secretPayloadMapperService.convert(payload));
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SecretPayload findSecret(@PathVariable("name") String name) throws NotFoundException {
        return secretPayloadMapperService.convert(secretServiceAdapter.find(name));
    }
}
