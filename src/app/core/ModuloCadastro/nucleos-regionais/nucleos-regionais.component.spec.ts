import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NucleosRegionaisComponent } from './nucleos-regionais.component';

describe('NucleosRegionaisComponent', () => {
  let component: NucleosRegionaisComponent;
  let fixture: ComponentFixture<NucleosRegionaisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NucleosRegionaisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NucleosRegionaisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
