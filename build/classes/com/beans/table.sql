drop table Tax_Details_1418560;
drop table Customer_1418560;


/*create tables*/

create table Customer_1418560
(
CustomerID number(6) primary key,
CustomerName varchar2(30) not null unique
);

create table Tax_Details_1418560
(
CustomerID number(6) not null,
foreign key (CustomerID) references Customer_1418560 (CustomerID),
IncomeTaxPin number(6) primary key,
GrossIncome number(8) not null,
TaxableIncome number(8) not null,
TotalTaxPayable number(8) not null,
FinancialYear varchar2(50) not null
);


/*insert statements */
insert into Customer_1418560
values(1, 'Ashish');

insert into Customer_1418560
values(2, 'Megha');


/*truncate */
truncate table Customer_1418560;

truncate table Tax_Details_1418560;

/* select */
select * from Customer_1418560;

select * from Tax_Details_1418560;



create sequence taxpin
start with 1000
increment by 1;

select * from Tax_Details_1418560 where CustomerID=1 and financialyear = 2018;


