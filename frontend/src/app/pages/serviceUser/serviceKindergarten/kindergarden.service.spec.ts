import { TestBed } from '@angular/core/testing';

import { KindergardenService } from './kindergarden.service';

describe('KindergardenService', () => {
  let service: KindergardenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KindergardenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
