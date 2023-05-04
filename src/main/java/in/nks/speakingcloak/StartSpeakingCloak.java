package in.nks.speakingcloak;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class StartSpeakingCloak {
	public static void main(String[] args) {
		SpringApplication.run(StartSpeakingCloak.class, args);
	}

}
