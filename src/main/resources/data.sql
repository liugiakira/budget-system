insert into account(id, account_number, owner_name, currency_code, balance)
values(10001,'232123wq', 'Tugushev', 'RUR', 0);
insert into account(id, account_number, owner_name, currency_code, balance)
values(10002,'R111111avi', 'Skochilov', 'USD', 0);


insert into transaction(id, id_account, category_name, booking_date, amount)
values(5,10001, 'category1', TO_DATE('1992-02-28', 'YYYY-MM-DD'), 3334.6);
insert into transaction(id, id_account, category_name, booking_date, amount)
values(6,10001, 'category2', CURRENT_DATE, 444);
insert into transaction(id, id_account, category_name, booking_date, amount)
values(7,10001, 'category3', CURRENT_DATE, -4455.6);
insert into transaction(id, id_account, category_name, booking_date, amount)
values(8,10002, 'category1', CURRENT_DATE, 555);
insert into transaction(id, id_account, category_name, booking_date, amount)
values(9,10002, 'category2', TO_DATE('2019-01-01', 'YYYY-MM-DD'), -666.8);
insert into transaction(id, id_account, category_name, booking_date, amount)
values(10,10002, 'category3', CURRENT_DATE, -0.22);