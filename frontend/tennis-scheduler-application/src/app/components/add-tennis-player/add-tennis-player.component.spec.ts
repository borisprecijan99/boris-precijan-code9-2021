import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTennisPlayerComponent } from './add-tennis-player.component';

describe('AddTennisPlayerComponent', () => {
  let component: AddTennisPlayerComponent;
  let fixture: ComponentFixture<AddTennisPlayerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddTennisPlayerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTennisPlayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
