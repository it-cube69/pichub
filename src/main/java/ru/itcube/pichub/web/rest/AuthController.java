package ru.itcube.pichub.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itcube.pichub.services.AuthService;
import ru.itcube.pichub.web.model.LoginModel;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/auth")
    public ResponseEntity<JWTToken> auth(@RequestBody LoginModel loginModel) {
        if (authService.auth(loginModel)) {
            return ResponseEntity.ok(new JWTToken("secret"));
        }
        return ResponseEntity.badRequest().body(new JWTToken());
    }

    public static class JWTToken {

        private String tokenId;

        public JWTToken(String tokenId) {
            this.tokenId = tokenId;
        }

        public JWTToken() {
        }

        public String getTokenId() {
            return tokenId;
        }

        public void setTokenId(String tokenId) {
            this.tokenId = tokenId;
        }
    }

}
