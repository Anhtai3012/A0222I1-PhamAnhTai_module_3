package com.exchange.service;

import org.springframework.stereotype.Service;

@Service
public class ExchangeImpl implements Exchange{
    @Override
    public double calculator(double usd, double vnd) {
        return usd * vnd;
    }
}
