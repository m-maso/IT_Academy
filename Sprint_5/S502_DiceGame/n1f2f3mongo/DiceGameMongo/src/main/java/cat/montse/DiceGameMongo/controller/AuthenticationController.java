package cat.montse.DiceGameMongo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.montse.DiceGameMongo.dao.request.SignUpRequest;
import cat.montse.DiceGameMongo.dao.request.SingInRequest;
import cat.montse.DiceGameMongo.dao.response.JwtAuthenticationResponse;
import cat.montse.DiceGameMongo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService authenticationService;

	

	@PostMapping("/signup")
	public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
		return ResponseEntity.ok(authenticationService.signup(request));
	}

	@PostMapping("/signin")
	public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SingInRequest request) {
		return ResponseEntity.ok(authenticationService.signin(request));
	}
	
}
