import { Injectable } from '@angular/core';

@Injectable()
export class MessageService {

  messages: string[] = [];
  alertType: string = ''

  add(message: string, alertType: string) {
    this.messages.push(message);
    this.alertType = alertType;
  }

  clear() {
    this.messages = [];
  }
}
