CREATE TABLE t_permissions(
    id bigint auto_increment,
    role VARCHAR(255),
    primary key (id)
);

CREATE TABLE t_users(
    id bigint AUTO_INCREMENT,
    email VARCHAR(255),
    full_name VARCHAR(255),
    password VARCHAR(255),
    primary key (id)
);

CREATE TABLE t_users_permission_list(
    user_id bigint,
    permission_list_id bigint
);

CREATE TABLE t_courses (
   id bigint AUTO_INCREMENT,
   name VARCHAR(255),
   description TEXT,
   price int,
   primary key (id)
);

ALTER TABLE t_users_permission_list
    ADD CONSTRAINT fk_t_users_permissions_t_users
        FOREIGN KEY (user_id)
            REFERENCES t_users (id)
            ON DELETE CASCADE;

ALTER TABLE t_users_permission_list
    ADD CONSTRAINT fk_t_users_permissions_t_permission
        FOREIGN KEY (permission_list_id)
            REFERENCES t_permissions (id)
            ON DELETE CASCADE;