import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalheNucleosComponent } from './detalhe-nucleos.component';

describe('DetalheNucleosComponent', () => {
  let component: DetalheNucleosComponent;
  let fixture: ComponentFixture<DetalheNucleosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalheNucleosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalheNucleosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
