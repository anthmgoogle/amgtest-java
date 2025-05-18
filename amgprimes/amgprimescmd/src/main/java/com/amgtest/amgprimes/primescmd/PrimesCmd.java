package com.amgtest.amgprimes.primescmd;

import com.amgtest.amgprimes.amgprimeslib.Primes;
import java.util.Arrays;

public class PrimesCmd {
    
    public static void main(String[] args) {
        System.out.println( "AMGPrimes Command Line Tester" );

        int primeCount;
        
        primeCount = Primes.countPrimes(10);
        System.out.printf("Primes.countPrimes(10) = %d%n", primeCount);

        primeCount = Primes.countPrimes(100);
        System.out.printf("Primes.countPrimes(100) = %d%n", primeCount);

        int[] primes;

        primes = Primes.listPrimes(10);
        System.out.printf("Primes.listPrimes(10) = %s%n", Arrays.toString(primes));
        
        primes = Primes.listPrimes(25);
        System.out.printf("Primes.listPrimes(25) = %s%n", Arrays.toString(primes));
    }
}
