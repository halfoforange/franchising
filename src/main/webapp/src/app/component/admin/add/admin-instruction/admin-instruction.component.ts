import {Component, Input, OnInit} from '@angular/core';
import {News} from "../../../../entity/news";
import {AdminService} from "../../../../service/admin.service";
import {Instruction} from "../../../../entity/instruction";
import {DictionaryService} from "../../../../service/dictionary.service";
import {Dictionary} from "../../../../entity/dictionary";
import {RequestOptions} from "@angular/http";
import {Observable} from "rxjs";

@Component({
    selector: 'app-admin-instruction',
    templateUrl: './admin-instruction.component.html',
    styleUrls: ['./admin-instruction.component.css']
})
export class AdminInstructionComponent implements OnInit {
    description: string;
    file: File;
    isUpload = false;
    @Input() instruction: Instruction = new Instruction();
    categories: Dictionary[];

    constructor(private adminService: AdminService, private dictionaryService: DictionaryService) {
        this.instruction.category = new Dictionary();
    }

    ngOnInit() {
        this.dictionaryService.getCategories().subscribe(value => this.categories = value);
        this.instruction.files=[];
    }

    addInstruction() {
        this.adminService.addInstruction(this.instruction).subscribe(value => {
        });
    }

    selectFile(event) {
        this.file = event.target.files[0];
    }

    upload() {
        this.adminService.pushFileToStorage(this.file, this.description).subscribe(value => {
            this.file = null;
            this.description=null;
            if(value.body!==undefined)
            this.instruction.files.push(value.body);
        });
    }

}
