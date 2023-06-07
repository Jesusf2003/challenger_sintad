import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { IEntity } from '../models/entity.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EntityCliService {

  private url: string = environment.entityUrl;
  entitySelected: IEntity | undefined;

  constructor(private http: HttpClient) { }

  listAll(): Observable<any> {
    return this.http.get<any>(this.url);
  }

  save(data: IEntity): Observable<any> {
    return this.http.post<any>(this.url, data);
  }

  update(data: IEntity): Observable<any> {
    return this.http.post<any>(this.url+"/"+data.id, data);
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(this.url+"/"+id);
  }
}