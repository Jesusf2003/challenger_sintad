import { ITypeContributor } from "./contributor.model";
import { ITypeDocument } from "./document.model";

export class IEntity {
  id!: number;
  idtypedoc!: ITypeDocument;
  nrodoc!: string;
  socialreason!: string;
  tradename!: string;
  idtypecont!: ITypeContributor;
  address!: string;
  telephone!: string;
  state!: boolean;
}