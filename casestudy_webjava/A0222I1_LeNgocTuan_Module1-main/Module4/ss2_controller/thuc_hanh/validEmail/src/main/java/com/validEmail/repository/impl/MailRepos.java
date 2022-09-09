package com.validEmail.repository.impl;

import com.validEmail.repository.IMailRepos;
import org.springframework.stereotype.Repository;

@Repository
public class MailRepos implements IMailRepos {
    String pattern = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    @Override
    public boolean isCorrectValidEmail(String email) {
        return email.matches(pattern);
    }
}
