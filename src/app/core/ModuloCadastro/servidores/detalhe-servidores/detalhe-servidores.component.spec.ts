import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalheServidoresComponent } from './detalhe-servidores.component';

describe('DetalheServidoresComponent', () => {
  let component: DetalheServidoresComponent;
  let fixture: ComponentFixture<DetalheServidoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalheServidoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalheServidoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
