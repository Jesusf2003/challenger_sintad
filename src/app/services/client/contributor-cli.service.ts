import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { ITypeContributor } from '../models/contributor.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContributorCliService {

  private url: string = environment.typeContributorUrl;
  contributorSelected: ITypeContributor | undefined;

  constructor(private http: HttpClient) {}

  listAll(): Observable<any> {
    return this.http.get<any>(this.url);
  }

  save(data: ITypeContributor): Observable<ITypeContributor> {
    return this.http.post<ITypeContributor>(this.url, data);
  }

  update(data: ITypeContributor): Observable<ITypeContributor> {
    return this.http.post<ITypeContributor>(this.url+"/"+data.id, data);
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(this.url+"/"+id);
  }
}