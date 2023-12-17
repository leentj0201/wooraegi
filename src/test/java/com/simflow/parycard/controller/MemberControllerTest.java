package com.simflow.parycard.controller;

import static com.simflow.parycard.endpoint.MemberEndPoint.MEMBER_LIST;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simflow.parycard.member.dto.MemberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    public void retrieveMemberList() throws Exception {
        var body = MemberDto.RequestSearch.builder()
            .memberName("leentj")
            .build();

        ResultActions result = mockMvc.perform(post(MEMBER_LIST)
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
