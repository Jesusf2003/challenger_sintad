import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DocumentsPageComponent } from './documents-page/documents-page.component';
import { ContributorPageComponent } from './contributor-page/contributor-page.component';
import { MainComponent } from './main.component';
import { EntityPageComponent } from './entity-page/entity-page.component';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HttpClientModule } from '@angular/common/http';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { DocumentFormComponent } from './documents-page/document-form/document-form.component';

@NgModule({
  declarations: [
    DocumentsPageComponent,
    ContributorPageComponent,
    MainComponent,
    EntityPageComponent,
    DashboardComponent,
    DocumentFormComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    NgbModalModule,
    ReactiveFormsModule
  ],
  exports: [
    DocumentsPageComponent,
    ContributorPageComponent,
    MainComponent,
    EntityPageComponent
  ]
})
export class PagesModule { }
