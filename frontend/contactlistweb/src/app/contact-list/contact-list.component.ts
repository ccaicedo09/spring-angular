import { Component, inject, OnInit } from '@angular/core';
import { ContactService } from '../services/contact.service';
import { DatePipe } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Contact } from '../model/contact.interface';

@Component({
  selector: 'app-contact-list',
  standalone: true,
  imports: [DatePipe, RouterModule],
  templateUrl: './contact-list.component.html',
  styleUrl: './contact-list.component.css'
})
export default class ContactListComponent implements OnInit{
  private contactService = inject(ContactService);

  contacts: Contact[] = [];
  edit: string = 'edit';

  ngOnInit(): void {
    this.loadContacts();
  }

  loadContacts() {
    this.contactService.list()
    .subscribe((contacts) => {
      this.contacts = contacts;
    });
  }

  deleteContact(contact: Contact): void {
    this.contactService.delete(contact.id)
      .subscribe(() => {
        this.loadContacts();
      });
  }
}
