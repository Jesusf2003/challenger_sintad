import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DocumentCliService } from 'src/app/services/client/document-cli.service';
import { ITypeDocument } from 'src/app/services/models/document.model';

@Component({
  selector: 'app-document-form',
  templateUrl: './document-form.component.html',
  styleUrls: ['./document-form.component.css']
})
export class DocumentFormComponent implements OnInit, OnDestroy {

  public documentForm: FormGroup = new FormGroup({});
  model: ITypeDocument = new ITypeDocument();
  edit: boolean = false;

  constructor(
    private formBuilder: FormBuilder,
    public documentService: DocumentCliService,
    public modalService: NgbModal,
    public activeModalService: NgbActiveModal
  ) {}

  ngOnInit(): void {
    this.init();
  }

  ngOnDestroy(): void {
    this.documentService.documentSelected = undefined;
  }

  refresh() {
    window.location.reload();
  }

  init(): void {
    this.documentForm = this.formBuilder.group(
      {
        id: [''],
        code: ['', Validators.required],
        name: ['', Validators.required],
        description: ['', Validators.required],
        state: ['']
      }
    );
    if (this.documentService.documentSelected) {
      this.documentForm.patchValue(
        {
          id: this.documentService.documentSelected.id,
          code: this.documentService.documentSelected.code,
          name: this.documentService.documentSelected.name,
          description: this.documentService.documentSelected.description,
          state: this.documentService.documentSelected.state
        }
      );
    }
  }

  isSelected() {
    if (this.documentService.documentSelected) {
      this.update();
      this.activeModalService.close();
    } else {
      this.save();
      this.activeModalService.close();
    }
  }

  save(): void {
    this.model = {...this.documentForm.value};
    this.documentService.save(this.model).subscribe(
      (res: any) => {
        console.log(res);
        this.edit = true;
        this.refresh();
      },
      (err: any) => {
        console.log(err);
      }
    );
  }

  update(): void {
    this.model = {...this.documentForm.value};
    this.documentService.update(this.model).subscribe(
      (res: any) => {
        console.log(res);
        this.edit = true;
        this.refresh();
      },
      (err: any) => {
        console.log(err);
      }
    );
  }
}