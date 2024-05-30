import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestmgmtComponent } from './testmgmt.component';

describe('TestmgmtComponent', () => {
  let component: TestmgmtComponent;
  let fixture: ComponentFixture<TestmgmtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TestmgmtComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TestmgmtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
