CREATE TABLE products (
                                 id bigserial NOT NULL,
                                 account_number varchar(255) NULL,
                                 balance int4 NULL,
                                 product_type varchar(255) NULL,
                                 user_id int8 NULL,
                                 CONSTRAINT products_pkey PRIMARY KEY (id)
);

insert into products values (100, 'productDto 1', 10, 'goods', 1),
    (101, 'productDto 2', 0, 'goods', 1);