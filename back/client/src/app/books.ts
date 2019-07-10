export class Books {
    id: number;
    name: string;
    author: string;
    year: string;
    publisher: string;
    city_pub: string;

    constructor () {

    }

    changeFields (name: string, author: string, year: string,
        publisher: string, pub_city: string) {
            this.name = name;
            this.author = author;
            this.year = year;
            this.publisher = publisher;
            this.city_pub = pub_city;

    }

    // constructor ( id_:number, name_ :string, author_: string, 
    //     year_: string, publisher: string, pub_city_: string ) {

    //         this.id = id_;
    //         this.name = name_;
    //         this.author = author_;
    //         this.pub_city = pub_city_;
    //         this.publisher = publisher;
    //         this.year = year_;
    // }
}