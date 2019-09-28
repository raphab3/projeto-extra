import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalheAlunosComponent } from './detalhe-alunos.component';

describe('DetalheAlunosComponent', () => {
  let component: DetalheAlunosComponent;
  let fixture: ComponentFixture<DetalheAlunosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalheAlunosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalheAlunosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
