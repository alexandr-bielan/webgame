package com.web.server.webserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.server.webserver.domain.Tournament;
import com.web.server.webserver.service.TournamentService;
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
public class TournamentControllerTest {
    @InjectMocks
    private TournamentController controller;

    @Mock
    private TournamentService hs;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void shouldSaveTournament() throws Exception {
        Mockito.doNothing().when(hs).save(ArgumentMatchers.any(Tournament.class));

        Tournament tournament = new Tournament("Tennis");

        String json = new ObjectMapper().writeValueAsString(tournament);

        mockMvc.perform(post("/tournaments/tourney")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));

    }

    @Test
    public void shouldGetTournament() throws Exception {
        Tournament tournament = new Tournament("Tennis");

        Mockito.when(hs.findById(3)).thenReturn(tournament);

        mockMvc.perform(get("/tournaments/tourney/{id}", 3))
                .andDo(print())
                .andExpect(status().is(200));

    }

    @Test
    public void shouldUpdateTourney() throws Exception {
        Mockito.doNothing().when(hs).update(ArgumentMatchers.any(Tournament.class));

        Tournament tournament = new Tournament();

        String json = new ObjectMapper().writeValueAsString(tournament);

        mockMvc.perform(put("/tournaments/tourney")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));

    }

    @Test
    public void shouldDeleteTourney() throws Exception {
        Mockito.doNothing().when(hs).deleteById(ArgumentMatchers.any(Integer.class));


        mockMvc.perform(delete("/tournaments/tourney/{id}", 12))
                .andDo(print())
                .andExpect(status().is(200));
    }
}
