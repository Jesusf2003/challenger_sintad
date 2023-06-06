import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginCliService } from 'src/app/services/client/login-cli.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: string = '';
  pswd: string = '';

  constructor(
    private authService: LoginCliService,
    private router: Router
  ) {}

  ngOnInit(): void {
  }

  login(): void {
    this.authService.login(this.user, this.pswd).subscribe(
      () => {
        this.router.navigate(['/main'])
      }
    );
  }
}