import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarNucleosComponent } from './editar-nucleos.component';

describe('EditarNucleosComponent', () => {
  let component: EditarNucleosComponent;
  let fixture: ComponentFixture<EditarNucleosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditarNucleosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarNucleosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
