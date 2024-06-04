package org.example.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenerateHashedPasswords {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPasswordUser = "password123";
        String encodedPasswordUser = encoder.encode(rawPasswordUser);
        System.out.println("Encoded password for user: " + encodedPasswordUser);

        String rawPasswordAdmin = "adminpassword123";
        String encodedPasswordAdmin = encoder.encode(rawPasswordAdmin);
        System.out.println("Encoded password for admin: " + encodedPasswordAdmin);
    }
}
