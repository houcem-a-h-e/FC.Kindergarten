import { TestBed } from '@angular/core/testing';

import { SatisfactionServiceService } from './satisfaction-service.service';

describe('SatisfactionServiceService', () => {
  let service: SatisfactionServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SatisfactionServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
