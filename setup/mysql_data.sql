use payment_system;

insert into account_type values (1, "debit"), (2, "credit");

insert into account_status values (1, "blocked"), (2, "active");

insert into account values (1, 12365.5, 1, 2), (2, 1000.0, 2, 1);

insert into user_type values (1, "client"), (2, "administrator");

insert into `user` values (1, "client", "client", 1), (2, "admin", "admin", 2);

insert into bank_card values (1, "1111222233334444", "2019-01-02", "8462", "956", 1, 1), (2, "5555666677778888", "2018-01-02", "9465", "133", 2, 1);
