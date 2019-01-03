import {Component, OnInit} from '@angular/core';
import {AdminService} from "../../../service/admin.service";
import {InstructionsMap} from "../../../entity/instruction";

@Component({
    selector: 'app-admin-instruction-list',
    templateUrl: './admin-instruction-list.component.html',
    styleUrls: ['./admin-instruction-list.component.css']
})
export class AdminInstructionListComponent implements OnInit {
    instructionsMap: InstructionsMap[];

    constructor(private adminService: AdminService) {
    }

    ngOnInit() {
        this.adminService.getInstructionList().subscribe(value => {
            this.instructionsMap=value;
            console.log(this.instructionsMap);
        });
    }
    getKeys(map){
        return Array.from(map.keys());
    }

}
