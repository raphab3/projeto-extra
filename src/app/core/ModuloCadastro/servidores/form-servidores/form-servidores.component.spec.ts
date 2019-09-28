import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormServidoresComponent } from './form-servidores.component';

describe('FormServidoresComponent', () => {
  let component: FormServidoresComponent;
  let fixture: ComponentFixture<FormServidoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormServidoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormServidoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
