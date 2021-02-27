package com.web.server.webserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.server.webserver.domain.Participant;
import com.web.server.webserver.service.ParticipantService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration
public class ParticipantControllerTest {
    @InjectMocks
    private ParticipantController controller;

    @Mock
    private ParticipantService hs;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void shouldSaveParticipant() throws Exception {
        Mockito.doNothing().when(hs).save(ArgumentMatchers.any(Participant.class));

        Participant participant = new Participant("Edward");

        String json = new ObjectMapper().writeValueAsString(participant);

        mockMvc.perform(post("/participants/attendee")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void shouldGetParticipant() throws Exception {
        Participant participant = new Participant("Edward");

        Mockito.when(hs.findById(3)).thenReturn(participant);

        mockMvc.perform(get("/participants/attendee/{id}", 3))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void shouldUpdateParticipant() throws Exception {
        Mockito.doNothing().when(hs).update(ArgumentMatchers.any(Participant.class));

        Participant heading = new Participant("12345");

        String json = new ObjectMapper().writeValueAsString(heading);

        mockMvc.perform(put("/participants/attendee")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void shouldDeleteParticipant() throws Exception {
        Mockito.doNothing().when(hs).deleteById(ArgumentMatchers.any(Integer.class));

        mockMvc.perform(delete("/participants/attendee/{id}", 12))
                .andDo(print())
                .andExpect(status().is(200));
    }
}
