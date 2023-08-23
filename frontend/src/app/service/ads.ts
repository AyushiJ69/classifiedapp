export class Ads {
    _id!: String;
    title!: String;
    type!: String;
    tag!: String;
    category!: String;
    advertisor!: String;
    start_date!: String;
    end_date!: String;
    photoUrl!: String;
    description!: String;
}

export class Advertisor{
    _id!: number;
    name!: String;
    gender!:String;
    image!:String;
    email!:String;
    phone!:String;
    password!: String;
    address!:String;
    city!:String;
    state!:String;
    pin!:String;
    country!:String;
    role!:Role;
    blocked!:String;
}

export class Role{
    _id!:number;
    name:String;
}

export class Tag{
    _id!: String;
    tagName!: String;
}
export class Category{
    _id!: String;
    categoryName!: String;
}