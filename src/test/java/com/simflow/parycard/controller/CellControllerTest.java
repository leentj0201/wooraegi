package com.simflow.parycard.controller;

import static com.simflow.parycard.endpoint.CellEndPoint.CELL_CREATE;
import static com.simflow.parycard.endpoint.CellEndPoint.CELL_LIST_ALL;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simflow.parycard.api.cell.dto.CellDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class CellControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;



    @Test
    @Transactional
    public void retrieveCellListAll() throws Exception {
//        var body = RequestPrayList.builder()
//            .memberId("280c7bee-0f6e-4b71-8254-cc2a75147634")
//            .build();

        ResultActions result = mockMvc.perform(post(CELL_LIST_ALL)
//                .content(objectMapper.writeValueAsString(body))
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        // You can perform additional assertions based on the response if needed
        // For example, checking the response content
        result.andExpect(mvcResult -> {
            String response = mvcResult.getResponse().getContentAsString();
            // Add your assertions based on the response content
            // For example, assertTrue(response.contains("Received: 123, John Doe"));
        });
    }

    @Test
    @Transactional
    @Rollback(value = true)
    public void createCell() throws Exception {
        var body = CellDto.RequestCreate.builder()
            .cellName("cell name")
            .cellDescription("cell Description")
            .isPublic(Boolean.FALSE)
            .isUsed(Boolean.TRUE)
            .build();

        ResultActions result = mockMvc.perform(post(CELL_CREATE)
                .content(objectMapper.writeValueAsString(body))
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        // You can perform additional assertions based on the response if needed
        // For example, checking the response content
        result.andExpect(mvcResult -> {
            String response = mvcResult.getResponse().getContentAsString();
            // Add your assertions based on the response content
            // For example, assertTrue(response.contains("Received: 123, John Doe"));
        });
    }
}
