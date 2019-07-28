import { OnInit, Component } from '@angular/core';

import { } from 'googlemaps';
import { MapsAPILoader } from '@agm/core';

import { Occurrence } from '../occurrence/model/occurrence.model';
import { OccurrenceService } from '../occurrence/service/occurrence.service';

import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(
    private mapsAPILoader: MapsAPILoader,
    private occurrenceService: OccurrenceService
  ) { }

  public latitude: number;
  public longitude: number;
  public iconPath: string;
  public occurrences: Occurrence[];
  public JSON: JSON;

  ngOnInit() {

    this.iconPath = `${environment.iconPath}`;

    this.JSON = JSON;
    this.getOccurrences();

    this.latitude = 39.52365;
    this.longitude = -87.12502;

    //set current position
    this.setCurrentPosition();

  }

  getOccurrences(): void {
    this.occurrenceService.getOccurrences().subscribe(occurrences => this.occurrences = occurrences);
  }

  private setCurrentPosition() {
    if ("geolocation" in navigator) {
      navigator.geolocation.getCurrentPosition((position) => {
        this.latitude = position.coords.latitude;
        this.longitude = position.coords.longitude;
      });
    }
  }

}
