import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KindergartenComponent } from './kindergarten.component';

describe('KindergartenComponent', () => {
  let component: KindergartenComponent;
  let fixture: ComponentFixture<KindergartenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KindergartenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KindergartenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
