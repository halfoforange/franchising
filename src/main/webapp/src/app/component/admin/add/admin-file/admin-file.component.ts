import {Component, OnInit} from '@angular/core';
import {AdminService} from "../../../../service/admin.service";

@Component({
    selector: 'app-admin-file',
    templateUrl: './admin-file.component.html',
    styleUrls: ['./admin-file.component.css']
})
export class AdminFileComponent implements OnInit {

    constructor(private adminService: AdminService) {
    }

    /*    selectFile(event) {
            /!*    this.selectedFiles = event.target.files;*!/
        }*/


    ngOnInit(): void {
    }
}
