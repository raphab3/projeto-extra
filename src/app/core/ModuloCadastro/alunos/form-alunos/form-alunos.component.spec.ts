import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAlunosComponent } from './form-alunos.component';

describe('FormAlunosComponent', () => {
  let component: FormAlunosComponent;
  let fixture: ComponentFixture<FormAlunosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormAlunosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAlunosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
