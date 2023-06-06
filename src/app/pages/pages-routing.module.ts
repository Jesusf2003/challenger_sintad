import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { EntityPageComponent } from "./entity-page/entity-page.component";
import { DocumentsPageComponent } from "./documents-page/documents-page.component";
import { ContributorPageComponent } from "./contributor-page/contributor-page.component";
import { MainComponent } from "./main.component";
import { DashboardComponent } from "./dashboard/dashboard.component";

const routes: Routes = [
  {
    path: 'main',
    component: MainComponent,
    children: [
      {path: '', component: DashboardComponent},
      {path: 'entity', component: EntityPageComponent},
      {path: 'document', component: DocumentsPageComponent},
      {path: 'contributor', component: ContributorPageComponent}
    ]
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagesRoutingModule {}