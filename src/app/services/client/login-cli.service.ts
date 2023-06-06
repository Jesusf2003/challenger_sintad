import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { Observable, map } from "rxjs";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: 'root'
})
export class LoginCliService {
  private urlLogin: string = environment.authUrl.loginUrl;
  private urlRegister: string = environment.authUrl.registerUrl;

  constructor(
    private http: HttpClient
  ) {}

  login(user: string, pswd: string): Observable<any> {
    let params = new HttpParams()
    .set('user', user)
    .set('pswd', pswd);
    return this.http.post<any>(this.urlLogin, params)
    .pipe(
      map(
        (res: any) => {
          sessionStorage.setItem('token', res.token)
        }
      )
    );
  }

  register(data: any): Observable<any> {
    return this.http.post<any>(this.urlRegister, data);
  }
}