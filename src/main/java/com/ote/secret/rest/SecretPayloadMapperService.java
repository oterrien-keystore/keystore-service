package com.ote.secret.rest;

import com.ote.domain.secret.api.model.Secret;
import org.springframework.stereotype.Service;

@Service
public class SecretPayloadMapperService {

    public Secret convert(SecretPayload payload) {
        Secret secret = new Secret();
        secret.setName(payload.getName());
        secret.setDescription(payload.getDescription());
        secret.setValue(payload.getValue());
        return secret;
    }

    public SecretPayload convert(Secret secret) {
        SecretPayload payload = new SecretPayload();
        payload.setName(secret.getName());
        payload.setDescription(secret.getDescription());
        payload.setValue(secret.getValue());
        return payload;
    }
}
