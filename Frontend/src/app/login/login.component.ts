import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  constructor(public http:HttpClient, public app:AppComponent)
  {
  }

  username:String='';
  password:String='';
 
  login()
  {
    let url=this.app.baseUrl+'login'+this.username;
    this.http.post(url,this.password).subscribe((data:any) =>
    {
      if(data==null)
      {
        alert('something is wrong');
      }
      else if(data[0]==1)
      {
        alert("wrong username");
      }
      else if(data[0]==2)
      {
        alert("multiple accounts with same username");
      }
      else if(data==3)
      {
        alert("wrong password");
      }
      else if(data[0]==0)
      {
        this.app.userId=data[1];
        this.app.isLoggedIn=data[2];
      }
      else
      {
        alert('something is wrong');
      }

    });

  }
}
