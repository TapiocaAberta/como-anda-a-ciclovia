import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OccurrenceDetailComponent } from './occurrence-detail.component';

describe('OccurrenceDetailComponent', () => {
  let component: OccurrenceDetailComponent;
  let fixture: ComponentFixture<OccurrenceDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OccurrenceDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OccurrenceDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
