insert into storage (type, bucket_name, path) values
('STAGING', 'staging-storage', '/staging-storage'),
('PERMANENT', 'permanent-storage', '/permanent-storage');

insert into roles (name)
values ('ROLE_USER'), ('ROLE_MODERATOR'), ('ROLE_ADMIN');
