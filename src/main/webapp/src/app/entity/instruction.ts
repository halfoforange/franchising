import {Dictionary} from "./dictionary";
import {File} from "./file";

export class Instruction {
    id: number;
    theme: string;
    description: string;
    category: Dictionary;
    files: File[];
}

export class InstructionsMap {
    category: Dictionary;
    instructions: Instruction[];
}