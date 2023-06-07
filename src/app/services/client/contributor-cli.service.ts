import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { ITypeContributor } from '../models/contributor.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContributorCliService {

  private url: string = environment.typeContributorUrl;
  private authUrl: string = environment.authUrl.typeContributorUrl;
  contributorSelected: ITypeContributor | undefined;

  constructor(private http: HttpClient) {}

  listAll(): Observable<any> {
    if (sessionStorage.getItem("token")) {
      const httpOptions = {
        headers: new HttpHeaders(
          {
            'Content-Type': 'application/json',
            'Authorization': ''+sessionStorage.getItem("token")
          }
        )
      };
      return this.http.get(this.authUrl, httpOptions);
    }
    return this.http.get<any>(this.url);
  }

  save(data: ITypeContributor): Observable<any> {
    if (sessionStorage.getItem("token")) {
      const httpOptions = {
        headers: new HttpHeaders(
          {
            'Content-Type': 'application/json',
            'Authorization': ''+sessionStorage.getItem("token")
          }
        )
      };
      return this.http.post<any>(this.authUrl, data, httpOptions);
    }
    return this.http.post<any>(this.url, data);
  }

  update(data: ITypeContributor): Observable<any> {
    if (sessionStorage.getItem("token")) {
      const httpOptions = {
        headers: new HttpHeaders(
          {
            'Content-Type': 'application/json',
            'Authorization': ''+sessionStorage.getItem("token")
          }
        )
      };
      return this.http.post<any>(this.url+"/"+data.id, data, httpOptions);
    }
    return this.http.post<any>(this.url+"/"+data.id, data);
  }

  delete(id: number): Observable<any> {
    if (sessionStorage.getItem("token")) {
      const httpOptions = {
        headers: new HttpHeaders(
          {
            'Content-Type': 'application/json',
            'Authorization': ''+sessionStorage.getItem("token")
          }
        )
      };
      return this.http.delete<any>(this.authUrl+"/"+id, httpOptions);
    }
    return this.http.delete<any>(this.url+"/"+id);
  }
}