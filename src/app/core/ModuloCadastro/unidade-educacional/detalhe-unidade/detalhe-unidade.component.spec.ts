import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalheUnidadeComponent } from './detalhe-unidade.component';

describe('DetalheUnidadeComponent', () => {
  let component: DetalheUnidadeComponent;
  let fixture: ComponentFixture<DetalheUnidadeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalheUnidadeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalheUnidadeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
