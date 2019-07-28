import { TestBed, inject } from '@angular/core/testing';

import { OccurrenceService } from './occurrence.service';

describe('OccurrenceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OccurrenceService]
    });
  });

  it('should be created', inject([OccurrenceService], (service: OccurrenceService) => {
    expect(service).toBeTruthy();
  }));
});
