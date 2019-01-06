import {Dictionary} from "./dictionary";

export class User {
  id: number;
  password: string;
  email: string;
  login: string;
  name: string;
  city: Dictionary = new Dictionary();
  phone: string;
  pointType: Dictionary = new Dictionary();
  address: string;
  places: string;
  energy: string;
  manager: string;
  employees: string;
}
