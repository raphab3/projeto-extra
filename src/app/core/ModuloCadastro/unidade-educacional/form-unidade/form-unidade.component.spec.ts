import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormUnidadeComponent } from './form-unidade.component';

describe('FormUnidadeComponent', () => {
  let component: FormUnidadeComponent;
  let fixture: ComponentFixture<FormUnidadeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormUnidadeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormUnidadeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
