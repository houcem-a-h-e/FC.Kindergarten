import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MessagesFirstUserComponent } from './messages-first-user.component';

describe('MessagesFirstUserComponent', () => {
  let component: MessagesFirstUserComponent;
  let fixture: ComponentFixture<MessagesFirstUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MessagesFirstUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MessagesFirstUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
