package cat.montse.DiceGame.service.impl;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cat.montse.DiceGame.dao.request.SingInRequest;
import cat.montse.DiceGame.dao.request.SingUpRequest;
import cat.montse.DiceGame.dao.response.JwtAuthenticationResponse;
import cat.montse.DiceGame.domain.entity.User;
import cat.montse.DiceGame.domain.enums.Role;
import cat.montse.DiceGame.repository.UserRepository;
import cat.montse.DiceGame.security.JwtTokenProvider;
import cat.montse.DiceGame.service.AuthenticationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

	private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    

	@Override
    public JwtAuthenticationResponse signup(SingUpRequest request) {
        var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        userRepository.save(user);
        var jwt = jwtTokenProvider.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SingInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtTokenProvider.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
    
}
