import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DocumentCliService } from 'src/app/services/client/document-cli.service';
import { ITypeDocument } from 'src/app/services/models/document.model';
import { DocumentFormComponent } from './document-form/document-form.component';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-documents-page',
  templateUrl: './documents-page.component.html',
  styleUrls: ['./documents-page.component.css']
})
export class DocumentsPageComponent implements OnInit {

  list: ITypeDocument[] = [];
  searchText!: string;
  form!: DocumentFormComponent;

  constructor(
    private documentService: DocumentCliService,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.showAll();
  }

  showAll():void {
    this.documentService.listAll().subscribe(
      (res: any) => {
        this.list = res;
        console.log("Lista documentos: "+ res);
      }
    );
  }

  deleted(id: number) {
    Swal.fire(
      {
        position: 'top-end',
        icon: 'success',
        title: 'El registro ha sido eliminado',
        showConfirmButton: true,
        timer: 1500
      }
    ).then(
      (res: any) => {
        if (res.isConfirmed) {
          this.documentService.delete(id).subscribe(
            (data: any) => {
              console.log(data);
              this.ngOnInit();
            },
            (err: any) => {
              console.log(err);
            }
          );
        }
      }
    );
  }

  openModal() {
    this.modalService.open(DocumentFormComponent, {centered: true, backdrop: 'static'});
  }

  editModal(data: any) {
    this.modalService.open(DocumentFormComponent, {centered: true, backdrop: 'static'});
    this.documentService.documentSelected = data;
  }
}