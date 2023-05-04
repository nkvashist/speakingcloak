package in.nks.speakingcloak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nks.speakingcloak.utilities.TimeUtils;

@Service
public class SpeakingCloakServiceImpl implements SpeakingCloakService {

	private TimeUtils timeUtils;

	@Autowired
	public void setTimeUtils(TimeUtils timeUtils) {
		this.timeUtils = timeUtils;
	}

	@Override
	public String speakTime(String time) {
		timeUtils.validateInput(time);
		String speakTime = "";
		speakTime = timeUtils.checkMidDayOrNight(time);
		if (speakTime == null) {
			// Create instance of StringBuilder
			StringBuilder sb = new StringBuilder("It's ");

			// split time by :
			String[] splitTime = time.split(":");

			// convert hours into words
			Integer hours = Integer.parseInt(splitTime[0]);
			String hoursStr = timeUtils.convertToEnglish(hours);
			sb.append(hoursStr + " ");

			// convert minutes into words
			Integer minutes = Integer.parseInt(splitTime[1]);
			String minutesStr = timeUtils.convertToEnglish(minutes);
			sb.append(minutesStr);
			speakTime = sb.toString();
		}
		return speakTime;
	}

}
