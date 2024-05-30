import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../../app.component';
import { StudentComponent } from '../student.component';

@Component({
  selector: 'app-showtests',
  templateUrl: './showtests.component.html',
  styleUrl: './showtests.component.css'
})
export class ShowtestsComponent {
  tests:any;
  constructor(public http:HttpClient, public app:AppComponent, public student:StudentComponent)
  {
    let url=this.app.baseUrl+'giveActiveTests';
    this.http.get(url).subscribe((data:any)=>
    {
      this.tests=data;
    });
  }

  attempt(testid:number)
  {
    let url=this.app.baseUrl+'giveMeTestLogs'+this.app.userId+'and'+testid;
    this.http.get(url).subscribe((data:any)=>
    {
      console.log(data);
      this.student.logs=data;
      this.student.whatToShow=2;
    });
  }
}
