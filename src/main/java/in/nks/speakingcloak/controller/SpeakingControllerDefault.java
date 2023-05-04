package in.nks.speakingcloak.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nks.speakingcloak.service.SpeakingCloakService;
import io.swagger.v3.oas.annotations.Operation;

/*
 * Controller Class for Speaking Cloak Application
 * for handling current time request
 */
@RestController
@RequestMapping("default/")
public class SpeakingControllerDefault {
	
	@Autowired
	private SpeakingCloakService speakingCloakService;
	
	@Operation(summary = "Get Current Time as String")
	@GetMapping("/")
	public ResponseEntity<?> speakCurrentTime(){		
		String time=getCurrentTime();
		String speakTime = speakingCloakService.speakTime(time);
		return new ResponseEntity<String>(speakTime,HttpStatus.OK);
		
	}
	
	
	//get Current Time
	private String getCurrentTime() {
		LocalDateTime now = LocalDateTime.now();
		StringBuilder sb=new StringBuilder();
		int hour = now.getHour();
		if(hour <10) {
			sb.append("0"+now.getHour());
		}else {
			sb.append(hour);
		}
		
		
		sb.append(":");
		
		int min=now.getMinute();
		if(min <10) {
			sb.append("0"+min);
		}else {
			sb.append(min);
		}
		return sb.toString();
	}

}
