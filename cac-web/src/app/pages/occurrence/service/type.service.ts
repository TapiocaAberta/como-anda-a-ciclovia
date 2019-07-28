import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { environment } from '../../../../environments/environment';

import {Type} from "../model/type.model";

@Injectable()
export class TypeService {

  private typeService = `${environment.resouceUrl}/type`;

  constructor(private http: HttpClient) { }

  getType(): Observable<Type[]> {
    return this.http.get<Type[]>(this.typeService)
      .pipe(
        tap(type => console.log(`fetched type`)),
        catchError(this.handleError('getType', []))
      );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
