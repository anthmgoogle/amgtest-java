package com.amgtest.amgprimes.primesapi;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PrimesController.class)
public class PrimesControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void contextLoads() {
  }

  @Test
  void testCountPrimesEndpoint_Success() throws Exception {
    int testMaximum = 10;
    int expectedCount = 4;

    mockMvc.perform(get("/api/v1/primes/count/{maximum}", testMaximum)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(String.valueOf(expectedCount)));
  }

  @Test
  void testCountPrimesEndpoint_BadRequest() throws Exception {
    int testMaximum = -5;
    String expectedErrorMessage = "Argument maximum cannot be negative.";

    mockMvc.perform(get("/api/v1/primes/count/{maximum}", testMaximum)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(content().string(expectedErrorMessage));
  }

  @Test
  void testListPrimesEndpoint_Success() throws Exception {
    int testMaximum = 10;
    String expectedContent = "[2,3,5,7]";

    mockMvc.perform(get("/api/v1/primes/list/{maximum}", testMaximum)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().json(expectedContent));
  }

  @Test
  void testListPrimesEndpoint_BadRequest() throws Exception {
    int testMaximum = -1;
    String expectedErrorMessage = "Argument maximum cannot be negative.";

    mockMvc.perform(get("/api/v1/primes/list/{maximum}", testMaximum)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(content().string(expectedErrorMessage));
  }
}
