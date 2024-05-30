package com.example.demo;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MyController 
{
	@Autowired
	UserRepo userRepo;
	@Autowired
	TestRepo testRepo;
	@Autowired
	QuestionBankRepo questionBankRepo;
	@Autowired
	LogRepo logRepo;
	

	
	@RequestMapping("acceptreject{id}")
	public int acceptreject(@PathVariable int id, @RequestBody int verify)
	{
		try 
		{
			Log log = logRepo.findById(id).get();
			log.verify=verify;
			logRepo.save(log);
			return 1;
		} catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	@RequestMapping("getAllLogsForVerification")
	public List<Log> getAllLogsForVerification()
	{
		return logRepo.findBySubmitAndVerify(1, 0);
	}
	
	@RequestMapping("submit{id}")
	public int submit(@PathVariable int id)
	{
		try 
		{
			Log log = logRepo.findById(id).get();
			log.submit=1;
			logRepo.save(log);
			return 1;
		} catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	@RequestMapping("update{id}")
	public int update(@PathVariable int id, @RequestBody String answer)
	{
		try 
		{
			Log log = logRepo.findById(id).get();
			log.answer=answer;
			logRepo.save(log);
			return 1;
		} catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	@RequestMapping("giveMeTestLogs{userid}and{testid}")
	public List<Log> giveMeTestLogs(@PathVariable int userid, @PathVariable int testid)
	{
		int count=logRepo.countByUserIdAndTestId(userid, testid);
		if(count==0)
		{
			Test test=testRepo.findById(testid).get();
			User user=userRepo.findById(userid).get();
			for (int i = 0; i < test.questioncount; i++) 
			{
				Log log=new Log();
				log.answer="";
				QuestionBank questionBank=questionBankRepo.findRandomQuestion().get();
				log.questionBank=questionBank;
				log.submit=0;
				log.test=test;
				log.user=user;
				log.verify=0;
				logRepo.save(log);
			}
		}
		return logRepo.findByUserIdAndTestId(userid, testid);
	}
	

	@RequestMapping("giveActiveTests")
	public List<Test> giveActiveTests()
	{
		List<Test> tests=testRepo.findAll();
//		List<Test> testsUi=new ArrayList<>();
//		
//		Date date=new Date();
//		long now=date.getTime();
//		for(Test test:tests)
//		{
//			Date start=test.getStart();
//			Date end=test.getEnd();
//			long startMili=start.getTime();
//			long endMili=end.getTime();
//			if(now>startMili && now<endMili)
//			{
//				testsUi.add(test);
//			}
//		}
		return tests;
		
	}
	
	@RequestMapping("addQuestion")
	public QuestionBank addQuestion(@RequestBody String name)
	{
	    QuestionBank questionBank=new QuestionBank();
	    questionBank.questionname=name;
	    return questionBankRepo.save(questionBank);
	}
	
	@RequestMapping("giveQuestions")
	public List<QuestionBank> giveQuestions()
	{
	    List<QuestionBank> questionBank=questionBankRepo.findAll();
	    return questionBank;
	}
	
	@RequestMapping("addTest")
	public Test addTest(@RequestBody Test test)
	{
		try 
		{
			Test testdb = testRepo.save(test);
		    return testdb;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}


	@RequestMapping("giveTests")
	public List<Test> giveTests()
	{
		List<Test> list=testRepo.findAll();
		for(Test test:list)
		{
			String result="";
			List<User> users=userRepo.findByRole(1);
			for(User user:users)
			{
				int count=logRepo.countByUserIdAndTestIdAndVerify(user.id,test.id,1);
				if(count>=test.passingcount)
				{
					result=result+user.name+" : Pass("+count+")\n";
				}
				else
				{
					result=result+user.name+" : Fail("+count+")\n";	
				}
			}
			test.result=result;
		}
		return list;
	}
	@RequestMapping("login{username}")
	public int[] login(@PathVariable String username, @RequestBody String password)
	{
		try
		{
			int[] a=new int[3];
			int count=userRepo.countByUsername(username);
			if(count==0)
			{
				a[0]=1;// wrong username
				return a;
			}
			else if(count>1)
			{
				a[0]=2; // multiple accounts
				return a;
			}
			
			User user=userRepo.findByUsername(username);
			if(user.password.equals(password))
			{
				a[0]=0;//success
				a[1]=user.id;
				a[2]=user.role;
				return a;
			}
			else
			{
				a[0]=3; // wrong password
				return a;
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		
		
	}

// working on it	
//	@RequestMapping("delete{id}")
//	public int deletetest(@PathVariable int id)
//	{
//		try {
//			
//			testRepo.deleteById(id);
//			return 1;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return -1;
//		}
//	}
}
