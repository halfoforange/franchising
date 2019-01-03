import {Page} from "./page";

export class News {
    id: number;
    theme: string;
    description: string;
    attach: string;
    date: Date;
}

export class NewsList extends Page {
    content: Array<News>;

    constructor(page: Page) {
        super();
    }}