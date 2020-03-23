package com.tk.medical.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class NoEncryptPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return (String) rawPassword;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals((String) rawPassword);
    }
}
