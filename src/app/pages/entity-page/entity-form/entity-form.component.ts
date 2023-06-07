import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EntityCliService } from 'src/app/services/client/entity-cli.service';
import { IEntity } from 'src/app/services/models/entity.model';

@Component({
  selector: 'app-entity-form',
  templateUrl: './entity-form.component.html',
  styleUrls: ['./entity-form.component.css']
})
export class EntityFormComponent implements OnInit, OnDestroy {

  public entityForm: FormGroup = new FormGroup({});
  model: IEntity = new IEntity();
  edit: boolean = false;

  constructor(
    private formBuilder: FormBuilder,
    public entityService: EntityCliService,
    public modalService: NgbModal,
    public activeModalService: NgbActiveModal
  ) {}

  ngOnInit(): void {
    this.init();
  }

  ngOnDestroy(): void {
    this.entityService.entitySelected = undefined;
  }

  refresh() {
    window.location.reload();
  }

  init(): void {
    this.entityForm = this.formBuilder.group(
      {
        id: [''],
        idtypedoc: ['', Validators.required],
        nrodoc: ['', Validators.required],
        socialreason: ['', Validators.required],
        tradename: ['', Validators.required],
        idtypecont: ['', Validators.required],
        address: ['', Validators.required],
        telephone: ['', Validators.required],
        state: ['']
      }
    );
    if (this.entityService.entitySelected) {
      this.entityForm.patchValue(
        {
          id: this.entityService.entitySelected.id,
          idtypedoc: this.entityService.entitySelected.id,
          nrodoc: this.entityService.entitySelected.nrodoc,
          socialreason: this.entityService.entitySelected.socialreason,
          tradename: this.entityService.entitySelected.tradename,
          idtypecont: this.entityService.entitySelected.idtypecont.id,
          address: this.entityService.entitySelected.address,
          telephone: this.entityService.entitySelected.telephone,
          state: this.entityService.entitySelected.state
        }
      );
    }
  }

  isSelected() {
    if (this.entityService.entitySelected) {
      this.update();
      this.activeModalService.close();
    } else {
      this.save();
      this.activeModalService.close();
    }
  }

  save(): void {
    this.model = {...this.entityForm.value};
    this.entityService.save(this.model).subscribe(
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
    this.model = {...this.entityForm.value};
    this.entityService.update(this.model).subscribe(
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