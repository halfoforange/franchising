import {Component, OnInit} from '@angular/core';
import {News} from "../../../../entity/news";
import {AdminService} from "../../../../service/admin.service";
import {Instruction} from "../../../../entity/instruction";
import {DictionaryService} from "../../../../service/dictionary.service";
import {Dictionary} from "../../../../entity/dictionary";

@Component({
    selector: 'app-admin-instruction',
    templateUrl: './admin-instruction.component.html',
    styleUrls: ['./admin-instruction.component.css']
})
export class AdminInstructionComponent implements OnInit {

    instruction: Instruction = new Instruction();
    categories: Dictionary[];

    constructor(private adminService: AdminService, private dictionaryService: DictionaryService) {
        this.instruction.category=new Dictionary();
    }

    ngOnInit() {
        this.dictionaryService.getCategories().subscribe(value => this.categories = value);
    }

    addInstruction() {
        this.adminService.addInstruction(this.instruction).subscribe(value => {
        });
    }
}
