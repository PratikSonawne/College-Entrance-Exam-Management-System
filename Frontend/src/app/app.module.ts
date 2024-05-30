import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { StudentComponent } from './student/student.component';
import { TrainerComponent } from './trainer/trainer.component';
import { TestmgmtComponent } from './trainer/testmgmt/testmgmt.component';
import { AnswerverificationComponent } from './trainer/answerverification/answerverification.component';
import { QuestionmgmtComponent } from './trainer/questionmgmt/questionmgmt.component';
import { ShowtestsComponent } from './student/showtests/showtests.component';
import { AttempttestComponent } from './student/attempttest/attempttest.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    StudentComponent,
    TrainerComponent,
    TestmgmtComponent,
    AnswerverificationComponent,
    QuestionmgmtComponent,
    ShowtestsComponent,
    AttempttestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
