import {Dictionary} from "./dictionary";

export class Instruction {
    id: number;
    theme: string;
    description: string;
    category: Dictionary;
    files: File[];
}
export class File {
    id: number;
    description: string;
    url: string;
}

export class InstructionsMap {
    category: Dictionary;
    instructions: Instruction[];
}