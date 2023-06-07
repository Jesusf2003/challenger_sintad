import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ContributorCliService } from 'src/app/services/client/contributor-cli.service';
import { ITypeContributor } from 'src/app/services/models/contributor.model';

@Component({
  selector: 'app-contributor-form',
  templateUrl: './contributor-form.component.html',
  styleUrls: ['./contributor-form.component.css']
})
export class ContributorFormComponent implements OnInit, OnDestroy {

  public contributorForm: FormGroup = new FormGroup({});
  model: ITypeContributor = new ITypeContributor();
  edit: boolean = false;
  
  constructor(
    private formBuilder: FormBuilder,
    public contributorService: ContributorCliService,
    public modalService: NgbModal,
    public activeModalService: NgbActiveModal
  ) {}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  
  ngOnDestroy(): void {
    this.contributorService.contributorSelected = undefined;
  }

  refresh(): void {
    window.location.reload();
  }

  init(): void {
    this.contributorForm = this.formBuilder.group(
      {
        id: [''],
        name: ['', Validators.required],
        state: ['']
      }
    );
    if (this.contributorService.contributorSelected) {
      this.contributorForm.patchValue(
        {
          id: this.contributorService.contributorSelected.id,
          name: this.contributorService.contributorSelected.name,
          state: this.contributorService.contributorSelected.state
        }
      );
    }
  }

  isSelected() {
    if (this.contributorService.contributorSelected) {
    }
  }

  save(): void {
    this.model = {...this.contributorForm.value};
    this.contributorService.save(this.model).subscribe(
      () => {
        this.edit = true;
        this.refresh();
      },
      (err: any) => {
        console.log(err);
      }
    );
  }

  update(): void {
    this.model = {...this.contributorForm.value};
    this.contributorService.update(this.model).subscribe(
      () => {
        this.edit = true;
        this.refresh();
      },
      (err: any) => {
        console.log(err);
      }
    );
  }
}