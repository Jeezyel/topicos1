package br.unitins.service;

import br.unitins.model.Cliente;
import br.unitins.repository.ClienteRepository;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TokenJwtServicempl implements TokenJwtService {
    
    @Inject
    ClienteService clienteService;

    @Inject
    ClienteRepository clienteRepository;

    private static final Duration EXPIRATION_TIME = Duration.ofHours(24);

    @Override
    public String generateJwt(Cliente cliente) {
        
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME);

        Set<String> roles = cliente.getPerfis()
                .stream().map(p -> p.getLabel())
                .collect(Collectors.toSet());

        return Jwt.issuer("unitins-jwt")
            .subject(cliente.getLogin())
            .groups(roles)
            .expiresAt(expiryDate)
            .sign();

    }

    @Override
    public String getLoginJtw(String loginCLiente) {
        Cliente cliente = clienteRepository.findByLogin(loginCLiente);

        return cliente.getLogin();
    }
    
    
}
