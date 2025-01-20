package com.crud.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.crud.controler.IplController;
import com.crud.service.IplService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class IplControllerTest {

    @Mock
    private IplService iplService; // Mocked service

    @InjectMocks
    private IplController controller; // The controller under test

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testDelete() throws Exception {
        // Initialize MockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Mock the service behavior
        doNothing().when(iplService).delete(2); // Assuming the service method takes ID 2

        // Perform DELETE request and validate response
        mockMvc.perform(delete("/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()); // Check if HTTP status is 200 OK

        // Verify that the service's delete method was called with the correct parameter
        verify(iplService, times(1)).delete(2);
    }
}
