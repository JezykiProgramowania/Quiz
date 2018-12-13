package src;

public class Question {

	
	private String question = "";
	private String ans = "";
	public boolean isCorrect;
	
	
	public Question(String question) {
		this.question = question;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	
	public String getAns() {
		return this.ans;
	}
	
	public void setAns(String ans) {
		this.ans = ans;
	}
}
