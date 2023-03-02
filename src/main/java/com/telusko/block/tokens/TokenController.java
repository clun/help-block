package com.telusko.block.tokens;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Sample Rest API to show token
 */
@RestController
@RequestMapping("/tokens")
public class TokenController {

    private final TokenRepository tokenRepository;

    public TokenController(TokenRepository repo) {
        this.tokenRepository = repo;
    }

    @GetMapping("/{address}")
    public ResponseEntity<Token> findById(HttpServletRequest req, @PathVariable(value = "address") String address) {
        Optional<Token> token = tokenRepository.findByAddress(address);
        if (token.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(token.get());
    }

}
