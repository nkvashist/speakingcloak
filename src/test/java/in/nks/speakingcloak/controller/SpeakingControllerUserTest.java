package in.nks.speakingcloak.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.nks.speakingcloak.Exception.GlobalExceptionHandler;
import in.nks.speakingcloak.service.SpeakingCloakServiceImpl;
import in.nks.speakingcloak.utilities.TimeUtils;

@WebMvcTest
@ContextConfiguration(classes = {SpeakingCloakServiceImpl.class,TimeUtils.class,GlobalExceptionHandler.class})
@Import(value = SpeakingControllerUser.class)
class SpeakingControllerUserTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	void whenInvalidtime_thenShouldReturn404() throws Exception {		
		String time = "34:28";
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/user/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8")
				.content(time);
		ResultActions resultActions = mockMvc.perform(mockRequest);
		resultActions.andDo(print()).andExpect(status().isBadRequest());

	}
	@Test
	void whenEnteredLettertime_thenShouldReturn404() throws Exception {		
		String time = "ab:28";
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/user/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8")
				.content(time);
		ResultActions resultActions = mockMvc.perform(mockRequest);
		resultActions.andDo(print()).andExpect(status().isBadRequest());

	}
	@Test
	void whenEnteredWithoutcolon_thenShouldReturn404() throws Exception {		
		String time = "1228";
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/user/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8")
				.content(time);
		ResultActions resultActions = mockMvc.perform(mockRequest);
		resultActions.andDo(print()).andExpect(status().isBadRequest());

	}
	
	@Test
	void whenEnteredMidday_thenShouldReturnItsMidday() throws Exception {
		String time = "12:00";
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/user/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8")
				.content(time);
		ResultActions resultActions = mockMvc.perform(mockRequest);
		resultActions.andDo(print()).andExpect(status().isOk()).andExpect(content().string("It's Midday"));

	}
	
	@Test
	void whenEnteredMidNight_thenShouldReturnItsMidNight() throws Exception {
		String time = "00:00";
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/user/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8")
				.content(time);
		ResultActions resultActions = mockMvc.perform(mockRequest);
		resultActions.andDo(print()).andExpect(status().isOk()).andExpect(content().string("It's Midnight"));

	}
	
	@Test
	void whenEightThirtyFour_thenShouldReturnItsEightThirtyFour() throws Exception {
		String time = "08:34";
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/user/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8")
				.content(time);
		ResultActions resultActions = mockMvc.perform(mockRequest);
		resultActions.andDo(print()).andExpect(status().isOk())
		.andExpect(content().string("It's eight thirty four"));

	}

}
