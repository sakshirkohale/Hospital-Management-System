import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentDashComponent } from './appointment-dash.component';

describe('AppointmentDashComponent', () => {
  let component: AppointmentDashComponent;
  let fixture: ComponentFixture<AppointmentDashComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AppointmentDashComponent]
    });
    fixture = TestBed.createComponent(AppointmentDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
