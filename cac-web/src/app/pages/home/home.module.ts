import { ModuleWithProviders, NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';

import { AgmCoreModule } from '@agm/core';

import { HomeComponent } from './home.component';

import { OccurrenceService } from '../occurrence/service/occurrence.service';

const homeRouting: ModuleWithProviders = RouterModule.forChild([
  {
    path: '',
    component: HomeComponent
  }
]);

@NgModule({
  imports: [
    homeRouting,
    ReactiveFormsModule,
    BrowserModule,
    AgmCoreModule.forRoot({
      apiKey: "AIzaSyDGNfRsZrh7nbJ6s8KlVFx7coXXv2cUJw0",
      libraries: ["places"]
    })
  ],
  declarations: [
    HomeComponent
  ],
  providers: [OccurrenceService]
})
export class HomeModule {}
