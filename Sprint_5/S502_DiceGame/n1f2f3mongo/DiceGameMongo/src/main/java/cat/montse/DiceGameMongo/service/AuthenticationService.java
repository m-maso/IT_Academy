package cat.montse.DiceGameMongo.service;

import cat.montse.DiceGameMongo.dao.request.SignUpRequest;
import cat.montse.DiceGameMongo.dao.request.SingInRequest;
import cat.montse.DiceGameMongo.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {

	JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SingInRequest request);
    
}
