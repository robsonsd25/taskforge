package br.com.docodigoaocontrato.taskforge.testeBCrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TesteBCrypt {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String hash1 = encoder.encode("robson123");
        String hash2 = encoder.encode("robson123");

        System.out.println("hash1: " + hash1);
        System.out.println("hash2: " + hash2);
        System.out.println("hash1.equals(hash2): " + hash1.equals(hash2));
        System.out.println("matches(\"robson123\", hash1): " + encoder.matches("robson123", hash1));
    }
}