package com.example.demo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Test 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	Date start;
	Date end;
	int questioncount;
	int passingcount;
	String result;
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Test(int id, String name, Date start, Date end, int questioncount, int passingcount, String result) {
		super();
		this.id = id;
		this.name = name;
		this.start = start;
		this.end = end;
		this.questioncount = questioncount;
		this.passingcount = passingcount;
		this.result = result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public int getQuestioncount() {
		return questioncount;
	}
	public void setQuestioncount(int questioncount) {
		this.questioncount = questioncount;
	}
	public int getPassingcount() {
		return passingcount;
	}
	public void setPassingcount(int passingcount) {
		this.passingcount = passingcount;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + ", start=" + start + ", end=" + end + ", questioncount="
				+ questioncount + ", passingcount=" + passingcount + ", result=" + result + "]";
	}
	
	
}
