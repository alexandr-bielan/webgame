package com.web.server.webserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.server.webserver.domain.Game;
import com.web.server.webserver.service.GameService;
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
public class GameControllerTest {
    @InjectMocks
    private GameController controller;

    @Mock
    private GameService hs;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void shouldSaveGame() throws Exception {
        Mockito.doNothing().when(hs).save(ArgumentMatchers.any(Game.class));

        Game game = new Game(1);

        String json = new ObjectMapper().writeValueAsString(game);

        mockMvc.perform(post("/games/match")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));

    }

    @Test
    public void shouldGetGame() throws Exception {
        Game game = new Game(1);

        Mockito.when(hs.findById(3)).thenReturn(game);

        mockMvc.perform(get("/games/match/{id}", 3))
                .andDo(print())
                .andExpect(status().is(200));

    }

    @Test
    public void shouldUpdateGame() throws Exception {
        Mockito.doNothing().when(hs).update(ArgumentMatchers.any(Game.class));

        Game game = new Game();

        String json = new ObjectMapper().writeValueAsString(game);

        mockMvc.perform(put("/games/match")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));

    }

    @Test
    public void shouldDeleteGame() throws Exception {
        Mockito.doNothing().when(hs).deleteById(ArgumentMatchers.any(Integer.class));


        mockMvc.perform(delete("/games/match/{id}", 12))
                .andDo(print())
                .andExpect(status().is(200));
    }
}
