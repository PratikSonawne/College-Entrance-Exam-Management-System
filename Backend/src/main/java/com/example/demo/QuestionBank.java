package com.example.demo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class QuestionBank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	int id;
	String questionname;
	public QuestionBank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionBank(int id, String questionname) {
		super();
		this.id = id;
		this.questionname = questionname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestionname() {
		return questionname;
	}
	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}
	@Override
	public String toString() {
		return "QuestionBank [id=" + id + ", questionname=" + questionname + "]";
	}
	
}

