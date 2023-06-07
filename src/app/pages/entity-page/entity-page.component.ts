import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EntityCliService } from 'src/app/services/client/entity-cli.service';
import { IEntity } from 'src/app/services/models/entity.model';
import Swal from 'sweetalert2';
import { EntityFormComponent } from './entity-form/entity-form.component';

@Component({
  selector: 'app-entity-page',
  templateUrl: './entity-page.component.html',
  styleUrls: ['./entity-page.component.css']
})
export class EntityPageComponent implements OnInit {

  list: IEntity[] = [];
  searchText!: string;

  constructor(
    private entityService: EntityCliService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.showAll();
  }

  showAll(): void {
    this.entityService.listAll().subscribe(
      (res: any) => {
        this.list = res;
        console.log("Lista entidades: " + res);
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
        this.entityService.delete(id).subscribe(
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
    this.modalService.open(EntityFormComponent, { centered: true, backdrop: 'static' });
  }

  editModal(data: any) {
    this.modalService.open(EntityFormComponent, { centered: true, backdrop: 'static' });
    this.entityService.entitySelected = data;
  }
}