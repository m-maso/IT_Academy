package cat.montse.DiceGame.service;

import cat.montse.DiceGame.dao.request.SingInRequest;
import cat.montse.DiceGame.dao.request.SingUpRequest;
import cat.montse.DiceGame.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {

	JwtAuthenticationResponse signup(SingUpRequest request);

    JwtAuthenticationResponse signin(SingInRequest request);
    
}
