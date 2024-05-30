import { Component } from '@angular/core';

@Component({
  selector: 'app-trainer',
  templateUrl: './trainer.component.html',
  styleUrl: './trainer.component.css'
})
export class TrainerComponent {
  whatToShow:number=0;

  changeWhatToShow(num:number)
  {
    this.whatToShow=num;
  }
}
