package org.pgm.shopserver.service;

import org.pgm.shopserver.model.User;



public interface AuthenticationService {
    public User signInAndReturnJWT(User signInRequest);
}
