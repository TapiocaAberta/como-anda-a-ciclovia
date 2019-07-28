
import {Status} from "./status.model";
import {Type} from "./type.model";

export class Occurrence {
  id: number;
  name: string;
  latitude: number;
  longitude: number;
  location: string;
  status: Status = new Status();
  type: Type = new Type();
  description: string;
  occurrenceDate: any;
  pathPhoto: string[];
}
