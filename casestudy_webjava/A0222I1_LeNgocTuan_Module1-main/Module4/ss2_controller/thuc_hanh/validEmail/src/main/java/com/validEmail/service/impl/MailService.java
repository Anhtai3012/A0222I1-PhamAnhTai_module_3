package com.validEmail.service.impl;

import com.validEmail.repository.IMailRepos;
import com.validEmail.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MailService implements IMailService {
    @Autowired
    IMailRepos mailRepos;

    @Override
    public boolean isCorrectValidEmail(String email) {
        return mailRepos.isCorrectValidEmail(email);
    }
}
