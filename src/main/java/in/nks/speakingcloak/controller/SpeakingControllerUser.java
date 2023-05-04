package in.nks.speakingcloak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nks.speakingcloak.service.SpeakingCloakService;
import io.swagger.v3.oas.annotations.Operation;

/*
 * Controller Class for Speaking Cloak Application
 * for handling user custom time request
 */
@RestController
@RequestMapping("user")
public class SpeakingControllerUser {
	
	@Autowired
	private SpeakingCloakService speakingCloakService;
	
	
	@Operation(summary = "Get User Input in the format hh:mm and convert to String")
	@PostMapping("/")
	public ResponseEntity<?> speakUserTime(@RequestBody String time){		
		String speakTime = speakingCloakService.speakTime(time);
		return new ResponseEntity<String>(speakTime,HttpStatus.OK);
	}
	

}
