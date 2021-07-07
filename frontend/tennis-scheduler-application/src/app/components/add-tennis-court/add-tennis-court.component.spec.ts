import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTennisCourtComponent } from './add-tennis-court.component';

describe('AddTennisCourtComponent', () => {
  let component: AddTennisCourtComponent;
  let fixture: ComponentFixture<AddTennisCourtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddTennisCourtComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTennisCourtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
