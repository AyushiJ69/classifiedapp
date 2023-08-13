package com.classify.app.service;

import com.classify.app.model.User;

public interface CheckUser {

    public User checkBuyer(long userId);
    public User checkSeller(long userId);
    public User checkAdmin(long userId);

}
