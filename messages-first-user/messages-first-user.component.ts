import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

import { Message } from '../model/message';
import { Parent, ParentType } from '../model/parent';
import { MessagesService } from '../services/chat.service';

@Component({
  selector: 'ngx-messages-first-user',
  templateUrl: './messages-first-user.component.html',
  styleUrls: ['./messages-first-user.component.scss'],
})
export class MessagesFirstUserComponent implements OnInit {
  message: Message = new Message();
  messages: Message[];
  houcemmessages: Message[] = [];
  wissemmessages: Message[] = [];
  parents: Parent[];
  msg: Message;
  /*parent1: Parent = {
    id: 1,
    firstName: 'houcem',
    lastName: 'aouissaoui',
    phonenumber: '2222222',
    email: 'jcnscd@klsnd.com',
    password: 'jarreb',
    pType: ParentType.ordinaryParent,
  };*/
  houcem: Parent = {
    id: 41,
    firstName: 'houcem',
    lastName: 'aouissaoui',
    phonenumber: '2222222',
    email: 'jcnscd@klsnd.com',
    password: 'jarreb',
    pType: ParentType.ordinaryParent,
  };
  wissem: Parent = {
    id: 40,
    firstName: 'wissem',
    lastName: 'aouissaoui',
    phonenumber: '2222222',
    email: 'jcnscd@klsnd.com',
    password: 'jarreb',
    pType: ParentType.ordinaryParent,
  };
  messageForm: FormGroup;

  constructor(private MessagesSer: MessagesService) { }

  ngOnInit(): void {
    this.message = new Message();
    // this.getAllMessagesRecievedByParent;
  //   this.getAllMessagesSentByParent(1);
    /*this.MessagesSer.retrieveAllMessagesByParentId(1).subscribe((data: any) => {
      this.messages = data;
    });*/
 this.MessagesSer.retrieveAllMessagesByParentId(41).subscribe((data: any) => {
      this.messages = data;
      console.log(this.messages);
    });
    this.messageForm = new FormGroup({
      'sender id': new FormControl(this.houcem.id),
      'sender name': new FormControl(this.houcem.firstName),
      'sender last name': new FormControl(this.houcem.lastName),
      'reciever id': new FormControl(this.wissem.id),
      'reciever name': new FormControl(this.wissem.firstName),
      'reciever last name': new FormControl(this.wissem.lastName),
    });
  }

  getAllMessagesSentByParent(idparentsender: number) {
    idparentsender = this.houcem.id;
    this.MessagesSer.getAllMessagesByParentId(idparentsender).subscribe(
      (data: any) => {
        this.messages = data;
        //console.log(this.messages);
        //this.messages.map(ele => {
          /*if (data === this.houcem.id) {
            this.houcemmessages.push(ele);
          } else {
            this.wissemmessages.push(ele);
          }*/
        //  this.messages = data.sort((a, b) => b.id_chat - a.id_chat);
          /* this.messages.sort(
             (a, b) => a.id_chat - b.id_chat);
         });*/
          console.log(this.houcemmessages);
          console.log(this.wissemmessages);
      });


   /* retrieveAllMessagesSentByParent(idparentsender: number) {
      idparentsender = this.houcem.id;
      this.MessagesSer.retrieveAllMessagesByParentId(idparentsender).subscribe(
        (data: any) => {
          this.messages = data;
          //this.messages.map(ele => {
          /*if (data === this.houcem.id) {
            this.houcemmessages.push(ele);
          } else {
            this.wissemmessages.push(ele);
          }*/
          //  this.messages = data.sort((a, b) => b.id_chat - a.id_chat);
          /* this.messages.sort(
             (a, b) => a.id_chat - b.id_chat);
         });*/
     /*     console.log(this.houcemmessages);
          console.log(this.wissemmessages);
        });*/

  /*getAllMessagesRecievedByParent(idparentreciever: number) {
    this.MessagesSer.getAllMessagesByParentId(idparentreciever).subscribe((data: any) => {
      idparentreciever = this.houcem.id;
      this.messages = data;
    })

  };*/
      }
  sendMesg() {
    this.MessagesSer.addMessage(this.houcem.id, this.wissem.id, this.message).subscribe(() => {
      // this.getAllMessagesSentByParent(this.houcem.id);
      this.MessagesSer.retrieveAllMessagesByParentId(this.houcem.id).subscribe
        (data => {
          this.messages = data;
         /* this.messages.map(()  => {
            if (msg.sender.id === this.houcem.id) {
              this.houcemmessages.push(msg);
            } else {
              this.wissemmessages.push(msg);
            }
          });*/
          console.log(data);
          const msg: Message = new Message();
          this.message = msg;
        });
    });
  }
}
