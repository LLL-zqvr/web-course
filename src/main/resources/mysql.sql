create table if not exists `user`
(
    id int auto_increment primary key,
    name varchar(20) not null,
    insert_time datatime not full default current_timestamp,
    update_time datatime not full default current_timestamp on update current_timestamp
    )