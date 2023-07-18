INSERT INTO t_permissions (role)
VALUES
    ('ROLE_USER'),
    ('ROLE_STUDENT'),
    ('ROLE_TEACHER'),
    ('ROLE_ADMIN');

INSERT INTO t_users (email, full_name, password)
VALUES
    ('Aklbktglv@gmail.com', 'Akyl Bakhtygaliev', '$2a$10$ZB6lmMH1kCWt1SiKn3zSreILuRFjTbcvbkpx5EN3/JYoTsNMwTrse'),
    ('Akello@gmail.com', 'Akello Creepo', '$2a$10$zVIH0C2jYQlDo1PuSSxyKeW21mxQADTz0WMWnFpb0sUJu3AHM5./i'),
    ('serik@gmail.com', 'Serik Berikov', '$2a$10$J4fRTgfhCU5u4KHsFXmXJOZj.6gTU624Ao4h6kXQCUwcdRMUPpNjC'),
    ('erik@gmail.com', 'Erik Erikov', '$2a$10$gRvFqjnHgE1jyrNFESgWiuaFsdN925fmDSfcaHbhiax03CIG/QcPO'),
    ('zhandos@gmail.com', 'Ilyas User', '$2a$10$t.EhsVgv6j.rZFbz6r507OOrc5PxszKZc0q1QObAFgtnC.Xyvz/qG');

INSERT INTO t_users_permission_list (user_id, permission_list_id)
VALUES
    (1,1),
    (1,2),
    (1,3),
    (1,4),
    (2,1),
    (2,2),
    (3,1),
    (3,3),
    (2,3);