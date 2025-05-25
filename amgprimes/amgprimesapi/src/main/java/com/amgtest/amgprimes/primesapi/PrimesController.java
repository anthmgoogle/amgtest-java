package com.amgtest.amgprimes.primesapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.amgtest.amgprimes.amgprimeslib.Primes;

@RestController
@RequestMapping("/api/v1/primes")
public class PrimesController {

  // GET /api/v1/primes/count/{maximum}
  @GetMapping("/count/{maximum}")
  public int countPrimesEndpoint(@PathVariable int maximum) {
    return Primes.countPrimes(maximum);
  }

  // GET /api/v1/primes/list/{maximum}
  @GetMapping("/list/{maximum}")
  public int[] listPrimesEndpoint(@PathVariable int maximum) {
    return Primes.listPrimes(maximum);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
  public String handleIllegalArgumentException(IllegalArgumentException ex) {
    return ex.getMessage(); // Return the exception message to the client
  }

}
