import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TennisCourtsComponent } from './tennis-courts.component';

describe('TennisCourtsComponent', () => {
  let component: TennisCourtsComponent;
  let fixture: ComponentFixture<TennisCourtsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TennisCourtsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TennisCourtsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
