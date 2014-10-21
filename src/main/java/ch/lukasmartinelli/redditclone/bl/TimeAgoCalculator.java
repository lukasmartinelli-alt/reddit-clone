package ch.lukasmartinelli.redditclone.bl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TimeAgoCalculator {
	private ArrayList<Token> tokens = new ArrayList<>();
	public TimeAgoCalculator() {
		tokens.add(new Token("year",31536000));
		tokens.add(new Token("month",2592000));
		tokens.add(new Token("week",604800));
		tokens.add(new Token("day",86400));
		tokens.add(new Token("hour",13600));
		tokens.add(new Token("minute",60));
		tokens.add(new Token("second",1));
	}

	public String getTimeAgo(Date d) {
		int diff = this.getDiffInSeconds(new Date(), d);
		if(diff < 0) diff = -diff;
		String ret = "-";
		for(Token t: tokens) {
			if(t.duration < diff) {
				int x = diff / t.getDuration();
				ret = x + " " + t.getDivision();
				break;
			}
		}
		return ret;
	}
	private int getDiffInSeconds(Date d1, Date d2) {
		long iD1, iD2;
		Calendar c = Calendar.getInstance();
		
		c.setTime(d1);
		iD1 = c.getTimeInMillis() / 1000;
		
		c.setTime(d2);
		iD2 = c.getTimeInMillis() / 1000;

		return (int) ((int) iD1- iD2);
	}
	
	class Token {
		private String division;
		private int duration;
		public Token(String division, int duration) {
			this.division = division;
			this.duration = duration;
		}
		public String getDivision() {
			return division;
		}
		public void setDivion(String division) {
			this.division = division;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
	}
}
