package com.inti.TD1Rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inti.TD1Rest.Json;
import com.inti.TD1Rest.model.Etudiant;
import com.inti.TD1Rest.repository.EcoleRepository;
import com.inti.TD1Rest.repository.EtudiantRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EtudiantController.class)
public class EtudiantControllerTests
{
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	EtudiantRepository etudiantRepository;

	@MockBean
	EcoleRepository ecoleRepository;

	@Test
	public void testAffichageAllEtudiant()
	{
		try
		{
			mockMvc.perform(get("/students")).andExpect(status().isOk());
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSaveStudent()
	{
			try
			{
				mockMvc.perform(post("/saveStudent")
					.contentType(MediaType.APPLICATION_JSON)
					.content(Json.fromObject(new Etudiant("Toto", "Titi", "tt@gmail.fr", "070809", 2))))
					.andExpect(status().isCreated());
			} catch (JsonProcessingException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Test
	public void testAffichageAllEtudiantInLyon()
	{
		try
		{
			mockMvc.perform(get("/studentsInLyon")).andExpect(status().isOk());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
