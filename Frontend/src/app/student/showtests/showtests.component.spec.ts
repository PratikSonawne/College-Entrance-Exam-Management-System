import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowtestsComponent } from './showtests.component';

describe('ShowtestsComponent', () => {
  let component: ShowtestsComponent;
  let fixture: ComponentFixture<ShowtestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShowtestsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShowtestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
