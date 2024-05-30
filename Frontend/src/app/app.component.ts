import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'studentexam';
  userId:number=0;
  isLoggedIn:number=0;
// baseUrl='http://localhost:8080/';
 baseUrl='http://13.233.128.178:8080/exam/';
}
