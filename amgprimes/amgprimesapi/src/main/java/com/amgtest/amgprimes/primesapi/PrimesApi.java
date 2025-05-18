package com.amgtest.amgprimes.primesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimesApi {

    public static void main(String[] args) {
        System.out.println("Primes API Starting");
		SpringApplication.run(PrimesApi.class, args);
    }
}
