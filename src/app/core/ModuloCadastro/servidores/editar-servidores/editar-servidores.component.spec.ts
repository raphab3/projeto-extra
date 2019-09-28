import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarServidoresComponent } from './editar-servidores.component';

describe('EditarServidoresComponent', () => {
  let component: EditarServidoresComponent;
  let fixture: ComponentFixture<EditarServidoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditarServidoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarServidoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
