package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Log 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@ManyToOne
	User user;
	@ManyToOne
	Test test;
	@ManyToOne
	QuestionBank questionBank;
	@Override
	public String toString() {
		return "Log [id=" + id + ", user=" + user + ", test=" + test + ", questionBank=" + questionBank + ", answer="
				+ answer + ", submit=" + submit + ", verify=" + verify + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public QuestionBank getQuestionBank() {
		return questionBank;
	}
	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getSubmit() {
		return submit;
	}
	public void setSubmit(int submit) {
		this.submit = submit;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}
	public Log(int id, User user, Test test, QuestionBank questionBank, String answer, int submit, int verify) {
		super();
		this.id = id;
		this.user = user;
		this.test = test;
		this.questionBank = questionBank;
		this.answer = answer;
		this.submit = submit;
		this.verify = verify;
	}
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	String answer;
	int submit;
	int verify;

}

