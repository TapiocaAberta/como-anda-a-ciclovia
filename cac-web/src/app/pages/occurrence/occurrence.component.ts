import { ElementRef, NgZone, OnInit, ViewChild, Input, Component } from '@angular/core';
import { FormControl } from '@angular/forms';

import { } from 'googlemaps';
import { MapsAPILoader } from '@agm/core';

import { Occurrence } from './model/occurrence.model';
import { Status } from "./model/status.model";
import { Type } from "./model/type.model";

import { OccurrenceService } from './service/occurrence.service';
import { StatusService } from './service/status.service';
import { TypeService } from './service/type.service';

@Component({
  selector: 'app-occurrence',
  templateUrl: './occurrence.component.html',
  styleUrls: ['./occurrence.component.css']
})

export class OccurrenceComponent implements OnInit {

  @Input() occurrence: Occurrence;

  @ViewChild("search")
  public searchElementRef: ElementRef;

  public statusList: Status[];
  public typeList: Type[];

  public latitude: number;
  public longitude: number;
  public address: string;
  //public login: string;
  //public password: string;
  public searchControl: FormControl;
  public zoom: number;

  public filesToUpload: Array<File> = [];

  constructor(
    private mapsAPILoader: MapsAPILoader,
    private ngZone: NgZone,
    private occurrenceService: OccurrenceService,
    private statusService: StatusService,
    private typeService: TypeService
  ) { }

  ngOnInit() {

    //set google maps defaults
    this.zoom = 4;
    this.latitude = 39.52365;
    this.longitude = -87.12502;
    this.address = '';
    //this.login = '';
    //this.password = '';

    //create search FormControl
    this.searchControl = new FormControl();

    //set current position
    this.setCurrentPosition();

    //load Places Autocomplete
    this.mapsAPILoader.load().then(() => {
      let autocomplete = new google.maps.places.Autocomplete(this.searchElementRef.nativeElement, {
        types: ["address"]
      });

      autocomplete.addListener("place_changed", () => {
        this.ngZone.run(() => {
          //get the place result
          let place: google.maps.places.PlaceResult = autocomplete.getPlace();

          //verify result
          if (place.geometry === undefined || place.geometry === null) {
            return;
          }

          //set latitude, longitude and zoom

          this.address = place.formatted_address;
          this.latitude = place.geometry.location.lat();
          this.longitude = place.geometry.location.lng();

          this.zoom = 50;
        });
      });
    });

    this.occurrence = new Occurrence();
    this.getStatus();
    this.getTypes();
  }

  save(): void {

    this.occurrence.latitude  = this.latitude;
    this.occurrence.longitude = this.longitude;
    this.occurrence.location  = this.address;

    let formData: FormData = new FormData();
    let files: Array<File> = this.filesToUpload;

    formData.append("occurrence", JSON.stringify(this.occurrence));

    for(let i =0; i < files.length; i++){
        formData.append("uploads", files[i], files[i]['name']);
    }

    //this.occurrenceService.upload(formData, this.login, this.password).subscribe();
    this.occurrenceService.upload(formData).subscribe();
  }

  fileChangeEvent(fileInput: any) {
    this.filesToUpload = <Array<File>>fileInput.target.files;
  }

  private setCurrentPosition() {
    if ("geolocation" in navigator) {
      navigator.geolocation.getCurrentPosition((position) => {
        this.latitude = position.coords.latitude;
        this.longitude = position.coords.longitude;
        this.zoom = 50;
      });
    }
  }

 private getStatus(): void {
   this.statusService.getStatus().subscribe(status => this.statusList = status);
 }

 private getTypes(): void {
   this.typeService.getType().subscribe(types => this.typeList = types);
 }

}
