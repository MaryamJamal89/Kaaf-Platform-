create schema kaff; 



#"INSERT INTO kaff.BOOK(bookID, bookTitle, bookLevel, bookType, bookPrice, available, edition) VALUES (?, ?, ?, ?, ?, ?, ?)";
#"INSERT INTO kaff.user(userID, fname, mname, lname, phone, level, email) VALUES (?, ?, ?, ?, ?, ?, ?)";

                    
create table kaff.user(
userID varchar(10) not null,
fname varchar(25),
mname varchar(25), 
lname varchar(25),
phone varchar(10),
userLevel int, 
email varchar(50),
primary key(userID)
);

create table kaff.admin(
adminID varchar(10) not null, 
adminName varchar(25),
adminPhone varchar(10),
adminPassword varchar(25),
primary key (adminID));

create table kaff.book (
bookID int not null auto_increment, 
bookTitle varchar(45),
bookLevel int, 
bookType Enum("بيع", "إعارة", "مجاناً"),
bookPrice float, 
available boolean, 
edition varchar(25),
ownerID varchar(10),
primary key(bookID),
foreign key(ownerID) references kaff.user(userID) 
on delete cascade on update cascade
);

create table kaff.borrowing(
borrowID int auto_increment,
bookID int,
userID varchar(10),
borrowDate date, 
dueDate date,
primary key (borrowID),
foreign key(bookID) references kaff.book(bookID),
foreign key(userID) references kaff.user(userID)
on delete cascade on update cascade
);

create table kaff.soldBooks(
bookID int,
userID varchar(10)
#set available to false
);

insert into kaff.user(userID, fname, mname, lname, phone, userLevel, email)
values ("2160006576", "هاجر", "محمد", "صالح", "057788634", 4, "hajer@kaff.com"),
("2170004342", "منى", "صلاح", "علي", "0544632742", 5, "mona@gmail.com"),
("2150005544", "فاطمة", "محمد", "خالد", "0546783492", 7, "fatimah@yahoo.com");

insert into kaff.book (bookTitle, bookLevel, bookType, bookPrice, available, edition, ownerID)
values ("Fundementals of OOP", 6, "بيع", 230.0, true, "11th, 2011", "2160006576"),
("Discrete mathematics", 5, "إعارة", 0.0, true, "3rd, 2018", "2170004342"),
("Statistics", 4, "بيع", 440, true, "2nd, 2003", "2150005544");

insert into kaff.admin (adminID, adminName, adminPhone, adminPassword)
values ("2180006622", "جمانة", "0597979744", "12345"),
("مريم", "جمال", "العياط", "54321"),
("دعاء", "صالح", "صالح", "09876"),
("زينة", "عبدالله", "الحداد", "67890"),
("لطيفة", "خليفة", "العليان", "34567");

