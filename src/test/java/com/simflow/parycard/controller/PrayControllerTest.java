package com.simflow.parycard.controller;

import static com.simflow.parycard.endpoint.MemberEndPoint.MEMBER_CREATE;
import static com.simflow.parycard.endpoint.PrayEndPoint.PRAY_CREATE;
import static com.simflow.parycard.endpoint.PrayEndPoint.PRAY_LIST;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simflow.parycard.member.dto.MemberDto;
import com.simflow.parycard.member.dto.PrayDto;
import com.simflow.parycard.member.dto.PrayDto.RequestPrayList;
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
public class PrayControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    public void retrieveMyPrayListAll() throws Exception {
//        var body = RequestPrayList.builder()
//            .memberId("280c7bee-0f6e-4b71-8254-cc2a75147634")
//            .build();

        ResultActions result = mockMvc.perform(post(PRAY_LIST)
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
    @Rollback(value = false)
    public void createPray() throws Exception {
        var body = PrayDto.RequestCreate.builder()
            .prayTitle("pray title")
            .prayContent("pray content")
            .isOpened(true)
            .build();

        ResultActions result = mockMvc.perform(post(PRAY_CREATE)
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
