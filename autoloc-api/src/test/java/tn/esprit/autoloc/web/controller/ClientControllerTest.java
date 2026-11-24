package tn.esprit.autoloc.web.controller;

import jakarta.validation.Validation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import tn.esprit.autoloc.dto.ClientRequestDto;
import tn.esprit.autoloc.dto.ClientResponseDto;
import tn.esprit.autoloc.exception.GlobalExceptionHandler;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.service.IClientService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests MVC du ClientController via MockMvc "standalone" (aucun contexte Spring / aucune base).
 */
class ClientControllerTest {

    private IClientService clientService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        clientService = mock(IClientService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new ClientController(clientService))
                .setControllerAdvice(new GlobalExceptionHandler())
                .setValidator(new SpringValidatorAdapter(
                        Validation.buildDefaultValidatorFactory().getValidator()))
                .build();
    }

    @Test
    void post_avecTousLesChamps_retourne201_sansEmail() throws Exception {
        given(clientService.ajouterClient(any(ClientRequestDto.class)))
                .willReturn(new ClientResponseDto(1L, "Ben Ali", "Sami", "20123456"));

        String corps = """
                {"nom":"Ben Ali","prenom":"Sami","email":"sami@example.com","telephone":"20123456"}
                """;

        mockMvc.perform(post("/api/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(corps))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nom").value("Ben Ali"))
                .andExpect(jsonPath("$.telephone").value("20123456"))
                .andExpect(jsonPath("$.email").doesNotExist());
    }

    @Test
    void post_sansEmailNiTelephone_retourne201() throws Exception {
        given(clientService.ajouterClient(any(ClientRequestDto.class)))
                .willReturn(new ClientResponseDto(2L, "Ben Ali", "Sami", null));

        String corps = """
                {"nom":"Ben Ali","prenom":"Sami"}
                """;

        mockMvc.perform(post("/api/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(corps))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nom").value("Ben Ali"))
                .andExpect(jsonPath("$.email").doesNotExist());
    }

    @Test
    void post_sansNomNiPrenom_retourne400() throws Exception {
        String corps = """
                {"email":"invalide"}
                """;

        mockMvc.perform(post("/api/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(corps))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.champsInvalides.nom").exists())
                .andExpect(jsonPath("$.champsInvalides.prenom").exists())
                .andExpect(jsonPath("$.champsInvalides.email").exists());
    }

    @Test
    void get_idExistant_retourne200_sansEmail() throws Exception {
        given(clientService.getClientById(eq(1L)))
                .willReturn(new ClientResponseDto(1L, "Ben Ali", "Sami", "20123456"));

        mockMvc.perform(get("/api/clients/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Ben Ali"))
                .andExpect(jsonPath("$.email").doesNotExist());
    }

    @Test
    void get_idInexistant_retourne404() throws Exception {
        given(clientService.getClientById(eq(999L)))
                .willThrow(new ResourceNotFoundException("Client", 999L));

        mockMvc.perform(get("/api/clients/999"))
                .andExpect(status().isNotFound());
    }
}
