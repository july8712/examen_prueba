import { Component, OnInit } from '@angular/core';
import { FormGroup, NgForm, FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {
  registroForm!: FormGroup;
  constructor(private readonly fb: FormBuilder) { }

  ngOnInit(): void {
    this.registroForm = this.initForm();
  }

  onSubmit(): void {
    console.log('Form ->');

  }

  initForm():FormGroup {
    return this.fb.group({
      usuario: ["", [Validators.required, Validators.minLength(3), Validators.maxLength(8)]],
      email: ["", [Validators.required, Validators.email]],
      pass:["", [Validators.required, Validators.minLength(4), Validators.maxLength(8)]],
      pass2: ["", [Validators.required, Validators.minLength(4), Validators.maxLength(8)]]
    })

  }
}
