import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EncortrarMascotasComponent } from './encortrar-mascotas.component';

describe('EncortrarMascotasComponent', () => {
  let component: EncortrarMascotasComponent;
  let fixture: ComponentFixture<EncortrarMascotasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EncortrarMascotasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EncortrarMascotasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
