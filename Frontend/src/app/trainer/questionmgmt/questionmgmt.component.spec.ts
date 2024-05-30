import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionmgmtComponent } from './questionmgmt.component';

describe('QuestionmgmtComponent', () => {
  let component: QuestionmgmtComponent;
  let fixture: ComponentFixture<QuestionmgmtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [QuestionmgmtComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(QuestionmgmtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
