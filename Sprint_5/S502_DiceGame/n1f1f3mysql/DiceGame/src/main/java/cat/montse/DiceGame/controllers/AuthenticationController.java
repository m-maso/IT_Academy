package cat.montse.DiceGame.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.montse.DiceGame.dao.request.SingInRequest;
import cat.montse.DiceGame.dao.request.SingUpRequest;
import cat.montse.DiceGame.dao.response.JwtAuthenticationResponse;
import cat.montse.DiceGame.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService authenticationService;


	
	@PostMapping("/signup")
	public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody @Valid SingUpRequest request) {
		return ResponseEntity.ok(authenticationService.signup(request));
	}

	@PostMapping("/signin")
	public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody @Valid SingInRequest request) {
		return ResponseEntity.ok(authenticationService.signin(request));
	}
}
