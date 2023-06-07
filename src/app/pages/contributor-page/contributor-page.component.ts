import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ContributorCliService } from 'src/app/services/client/contributor-cli.service';
import { ITypeContributor } from 'src/app/services/models/contributor.model';
import Swal from 'sweetalert2';
import { ContributorFormComponent } from './contributor-form/contributor-form.component';

@Component({
  selector: 'app-contributor-page',
  templateUrl: './contributor-page.component.html',
  styleUrls: ['./contributor-page.component.css']
})
export class ContributorPageComponent implements OnInit {

  list: ITypeContributor[] = [];
  searchText!: string;

  constructor(
    private contributorService: ContributorCliService,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.showAll();
  }

  showAll(): void {
    this.contributorService.listAll().subscribe(
      (res: any) => {
        this.list = res;
        console.log(res);
      }
    );
  }

  deleted(id: number) {
    Swal.fire(
      {
        position: 'top-end',
        icon: 'success',
        title: 'El registro ha sido eliminado',
        timer: 2000
      }
    ).then(
      () => {
        this.contributorService.delete(id).subscribe(
          (data: any) => {
            console.log(data);
            this.ngOnInit();
          },
          (err: any) => {
            console.log(err);
          }
        );
      }
    );
  }

  openModal() {
    this.modalService.open(ContributorFormComponent, {centered: true, backdrop: 'static'});
  }

  editModal(data: any) {
    this.modalService.open(ContributorFormComponent, {centered: true, backdrop: 'static'});
    this.contributorService.contributorSelected = data;
  }
}