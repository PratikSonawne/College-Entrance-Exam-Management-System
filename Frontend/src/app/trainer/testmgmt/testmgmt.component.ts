import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../../app.component';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-testmgmt',
  templateUrl: './testmgmt.component.html',
  styleUrl: './testmgmt.component.css'
})
export class TestmgmtComponent {

  constructor(public http:HttpClient, public app:AppComponent){}
 

  tests:any[]=[];
  load()
  {this.wts=2;
    let url=this.app.baseUrl+'giveTests';
    this.http.get(url).subscribe((data:any)=>
    {
      this.tests=data;
    });
  }
  wts:number=0;
  name:string='';
  start:Date=new Date();
  end:Date=new Date();
  questioncount:number=0;
  passingcount:number=0;

  add()
  {
    let obj={
      "name":this.name,
      "start":this.start,
      "end":this.end,
      "questioncount":this.questioncount,
      "passingcount":this.passingcount
    }

    let url=this.app.baseUrl+'addTest';
    this.http.post(url,obj).subscribe((data:any)=>
    {
      this.tests.push(data);
    });
  }

  deleteTest(testId: number)
  {
    let url=this.app.baseUrl+'delete'+testId;
    this.http.get(url).subscribe((data:any)=>
    {
    console.log(testId)
    if(data==1)
    {
      let index=this.tests.indexOf(this.tests);
      if(index>=0)
      {
        this.tests.splice(index,1);
      }
    }
    else
    {
      alert('exception on server');
    }
});
}

}