import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ContactService } from '../services/contact.service';
import { Contact } from '../model/contact.interface';

@Component({
  selector: 'app-contact-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './contact-form.component.html',
  styleUrl: './contact-form.component.css'
})
export default class ContactFormComponent implements OnInit{
  private formBuilder = inject(FormBuilder);
  private contactService = inject(ContactService);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

  form?: FormGroup;
  contact?: Contact;

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');

    if(id) {
      this.contactService.get(parseInt(id))
        .subscribe(contact => {
          this.contact = contact;
          this.form = this.formBuilder.group({
            name: [contact.name, [Validators.required]],
            email: [contact.email, [Validators.required, Validators.email]],
            phone: [contact.phone, [Validators.required]]
          });
        })
    } else {
      this.form = this.formBuilder.group({
        name: ['', [Validators.required]],
        email: ['', [Validators.required, Validators.email]],
        phone: ['', [Validators.required]]
      });
    }
  }


  save() {

    if(this.form?.invalid) { // Prevents the form from being submitted if it is invalid
      return;
    }

    const contactForm = this.form!.value;

    if (this.contact) { // If contact exists, reach out to the update method
      this.contactService.update(this.contact.id, contactForm)
        .subscribe(() => {
          this.router.navigate(['/']);
        })
    } else { // If not, reach out the create method
      this.contactService.create(contactForm)
      .subscribe(() => {
        this.router.navigate(['/']);
      })
    }
  }
}
