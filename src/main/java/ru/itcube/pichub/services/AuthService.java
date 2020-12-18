package ru.itcube.pichub.services;

import ru.itcube.pichub.web.model.LoginModel;

public interface AuthService {

    boolean auth(LoginModel loginModel);
}
