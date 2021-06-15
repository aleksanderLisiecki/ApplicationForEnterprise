import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  date: Date;

  constructor() { 
    this.date = new Date(Date.now());
  }

  ngOnInit(): void {
  }

}
