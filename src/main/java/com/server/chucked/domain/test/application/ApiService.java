package com.server.chucked.domain.test.application;

import org.springframework.stereotype.Service;

@Service
public class ApiService {
    public String getChuck() {
        return "Chuck Norris can divide by zero.";
    }
}
