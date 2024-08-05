package com.example.api.controller;

import com.example.api.domain.usuario.AuthenticationDTO;
import com.example.api.domain.usuario.LoginResponseDTO;
import com.example.api.domain.usuario.RegisterDTO;
import com.example.api.domain.usuario.Usuario;
import com.example.api.infra.security.TokenService;
import com.example.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody AuthenticationDTO body) {
        // Hashing no password
        var userPasswordToken = new UsernamePasswordAuthenticationToken(body.login(), body.password());
        var auth = this.authManager.authenticate(userPasswordToken);

//        Faz um cas da auth.getPrincipal() do spring para a minha classe de Usuario
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO body){
        if (this.repository.findByLogin(body.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(body.password());
        Usuario newUsuario = new Usuario(body.login(), encryptedPassword, body.role());

        this.repository.save(newUsuario);
        return ResponseEntity.ok().build();

    }
}
