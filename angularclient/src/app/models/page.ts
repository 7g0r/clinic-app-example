export class Page<T> {
    content: T[];
    isSorted: boolean;
    sortedBy: string;
    dir: string;
    size: number;
    number: number;
    totalElements: number;
    totalPages: number;

    constructor(size?: number, sort?: string) {
        this.sortedBy = sort ? sort : 'id';
        this.isSorted = true;
        this.dir = 'asc';
        this.size = size ? size : 10;
    }

    public buildPageableUrl(): string {
        let url = '/?';
        if (this.sortedBy != null && this.sortedBy !== '' && this.dir != '') {
            url += 'sort=' + this.sortedBy;
            if (this.dir != null && this.dir !== '') {
                url += ',' + this.dir + '&';
            } else {
                url += '&';
            }
        }
        if (this.size != null) {
            url += 'size=' + this.size + '&';
        }
        if (this.number != null) {
            url += 'page=' + this.number;
        }
        return url;
    }

    fromResponse(response: any) {
        this.content = response.content;
        this.size = response.size;
        this.number = response.number;
        this.isSorted = response.sort;
        this.totalElements = response.totalElements;
        this.totalPages = response.totalPages;
        this.dir = response.dir;
    }
}
