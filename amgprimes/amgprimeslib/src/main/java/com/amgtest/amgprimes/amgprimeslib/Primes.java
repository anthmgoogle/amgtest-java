package com.amgtest.amgprimes.amgprimeslib;

import java.util.ArrayList;

public class Primes {

  private static final int FIRST_PRIME = 2;

  public static int countPrimes(int maximum) {
    if (maximum < 0) {
      throw new IllegalArgumentException("Argument maximum cannot be negative.");
    }
    int[] primes = listPrimes(maximum);
    return primes.length;
  }

  public static int[] listPrimes(int maximum) {
    if (maximum < 0) {
      throw new IllegalArgumentException("Argument maximum cannot be negative.");
    }
    if (maximum < FIRST_PRIME) {
      return new int[0];
    }
    boolean[] isNotPrime = new boolean[maximum + 1];
    int maxFactor = (int) Math.sqrt(maximum);
    for (int factor = FIRST_PRIME; factor <= maxFactor; factor++) {
      if (!isNotPrime[factor]) {
        for (int multiple = factor * factor; multiple <= maximum; multiple += factor) {
          isNotPrime[multiple] = true;
        }
      }
    }
    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i = FIRST_PRIME; i < isNotPrime.length; i++) {
      if (!isNotPrime[i]) {
        result.add(i);
      }
    }
    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}
