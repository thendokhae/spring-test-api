insert into invoice (id,client,vat_rate,invoice_date) values(2001,'Takealot',15,sysdate());
insert into invoice (id,client,vat_rate,invoice_date) values (2002,'PNP',15,sysdate());

insert into line_item values(1001,10,25.50,2001);
insert into line_item values(1002,50,19.90,2001);
insert into line_item values(1003,25,71.25,2002);

