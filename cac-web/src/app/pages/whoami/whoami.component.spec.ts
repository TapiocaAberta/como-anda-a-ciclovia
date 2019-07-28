import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WhoamiComponent } from './whoami.component';

describe('WhoamiComponent', () => {
  let component: WhoamiComponent;
  let fixture: ComponentFixture<WhoamiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WhoamiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WhoamiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
