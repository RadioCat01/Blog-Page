package com.Blog.Blog.Controller;

import com.Blog.Blog.Service.CommentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = CommentController.class)
class CommentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService commentService;

    @Test
    void shouldCreateComment() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/comment")
                .content("new Comment"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    @Test
    void shouldThrowExceptionWhenCreatingComment() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/comment"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void shouldGetAllComments() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/comment"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }
    @Test
    void shouldThrowExceptionWhenGettingComments() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/comment"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void shouldDeleteComment() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/comment/3"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}