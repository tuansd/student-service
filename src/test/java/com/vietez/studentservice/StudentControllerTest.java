package com.vietez.studentservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    void getStudent_forSavedStudent_isReturned() throws Exception {
        //given
        given(studentService.getStudentById(anyLong())).willReturn(
                Student.builder().Id(1l)
                        .name("Mark")
                        .grade(10)
                        .build()
        );
        //when //then
        mockMvc.perform(get("/students/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1l))
                .andExpect(jsonPath("name").value("Mark"))
                .andExpect(jsonPath("grade").value(10));
    }

    @Test
    void getStudent_forMissingStudent_status404() throws Exception{
        //given
        given(studentService.getStudentById(anyLong())).willThrow(StudentNotFoundException.class);
        //when //then
        mockMvc.perform(get("/students/1"))
                .andExpect(status().isNotFound());
    }

}
