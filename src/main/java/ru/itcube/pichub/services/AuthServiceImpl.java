package ru.itcube.pichub.services;

import org.springframework.stereotype.Service;
import ru.itcube.pichub.web.model.LoginModel;

@Service
public class AuthServiceImpl implements AuthService {

    private static String USERNAME = "ivan";
    private static String PASSWORD = "secret";

    @Override
    public boolean auth(LoginModel loginModel) {
        if (USERNAME.equals(loginModel.getUsername()) && PASSWORD.equals(loginModel.getPassword())) {
            return true;
        }
        return false;
    }
}
