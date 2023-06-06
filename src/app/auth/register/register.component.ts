import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginCliService } from 'src/app/services/client/login-cli.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  user: string = '';
  email: string = '';
  pswd: string = '';

  constructor(
    private authService: LoginCliService,
    private router: Router
  ) {}

  register(): void {
    let data = {
      username: this.user,
      email: this.email,
      password: this.pswd
    }
    this.authService.register(data).subscribe(
      () => {
        this.router.navigate(['/login']);
      }
    );
  }
}
