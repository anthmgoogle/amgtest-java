package com.amgtest.amgprimes.amgprimeslib;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PrimesTest {
  private static final int[] PRIMES_FIRST = {
      2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
      71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139,
      149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199
  };
  private static final int PRIMES_FIRST_MAX = 200;

  @ParameterizedTest
  @MethodSource("primesTestValues")
  void countPrimes_testContract(int maximum) {
    if (maximum < 0) {
      Assertions.assertThrows(IllegalArgumentException.class, () -> Primes.countPrimes(maximum));
      return;
    }
    int result = Primes.countPrimes(maximum);
    int expected = listPrimesFromConstant(maximum).length;
    Assertions.assertEquals(result, expected);
  }

  @ParameterizedTest
  @MethodSource("primesTestValues")
  public void listPrimes_testContract(int maximum) {
    if (maximum < 0) {
      Assertions.assertThrows(IllegalArgumentException.class, () -> Primes.listPrimes(maximum));
      return;
    }
    int[] result = Primes.listPrimes(maximum);
    int[] expected = listPrimesFromConstant(maximum);
    Assertions.assertArrayEquals(result, expected);
  }

  private static Stream<Arguments> primesTestValues() {
    return Stream.of(
        Arguments.of(-1),
        Arguments.of(0),
        Arguments.of(1),
        Arguments.of(2),
        Arguments.of(3),
        Arguments.of(4),
        Arguments.of(5),
        Arguments.of(10),
        Arguments.of(100),
        Arguments.of(200));
  }

  private int[] listPrimesFromConstant(int maximum) {
    if (maximum > PRIMES_FIRST_MAX) {
      throw new IllegalArgumentException("Primes too large for constant array");
    }
    int iLast = -1;
    for (int i = 0; i < PRIMES_FIRST.length; i++) {
      int prime = PRIMES_FIRST[i];
      if (prime > maximum)
        break;
      else
        iLast = i;
    }
    if (iLast < 0)
      return new int[0];
    return Arrays.copyOfRange(PRIMES_FIRST, 0, iLast + 1);
  }
}
