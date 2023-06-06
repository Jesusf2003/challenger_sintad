import { RouterModule, Routes } from "@angular/router";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { EntityPageComponent } from "./entity-page/entity-page.component";
import { DocumentsPageComponent } from "./documents-page/documents-page.component";
import { ContributorPageComponent } from "./contributor-page/contributor-page.component";
import { NgModule } from "@angular/core";

const childRoutes: Routes = [
  {path: '', component: DashboardComponent},
  {path: 'entity', component: EntityPageComponent},
  {path: 'document', component: DocumentsPageComponent},
  {path: 'contributor', component: ContributorPageComponent}
]

@NgModule({
  imports: [RouterModule.forChild(childRoutes)],
  exports: [RouterModule]
}) export class ChildRoutesModule {}