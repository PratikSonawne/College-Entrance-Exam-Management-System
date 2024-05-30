import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerverificationComponent } from './answerverification.component';

describe('AnswerverificationComponent', () => {
  let component: AnswerverificationComponent;
  let fixture: ComponentFixture<AnswerverificationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AnswerverificationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AnswerverificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
