import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { ITypeDocument } from '../models/document.model';

@Injectable({
  providedIn: 'root'
})
export class DocumentCliService {

  private url: string = environment.typeDocumentUrl;
  documentSelected: ITypeDocument | undefined;

  constructor(private http: HttpClient) {}

  listAll(): Observable<any> {
    return this.http.get<any>(this.url);
  }

  save(data: ITypeDocument): Observable<ITypeDocument> {
    return this.http.post<ITypeDocument>(this.url, data);
  }

  update(data: ITypeDocument): Observable<ITypeDocument> {
    return this.http.post<ITypeDocument>(this.url+"/"+data.id, data);
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(this.url+"/"+id);
  }
}