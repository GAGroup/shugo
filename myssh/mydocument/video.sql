/*==============================================================*/
/*  use video                                                   */
/* if video_type exit                                           */
/* drop table video_type                                        */
/*==============================================================*/



CREATE TABLE `video_type` (
  `video_type_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `video_type_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `video_type_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `video_type_father` int(11) unsigned  DEFAULT NULL,
  `video_type_layer` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `video_type_pic` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`video_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin
comment='影音类型表';
drop table video_info
CREATE TABLE `video_info` (
  `video_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `video_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `video_uplod_user` int(11) unsigned DEFAULT NULL,
  `video_type_id` int(11) unsigned DEFAULT NULL,
  `path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `upload_time` datetime DEFAULT NULL,
  `save_name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `visited_times` int(11) DEFAULT NULL,
  `visit_power` int(11) DEFAULT NULL,
  PRIMARY KEY (`video_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin
comment='影音信息表';

CREATE TABLE `video_director` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dir_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `father_dir` int(11) DEFAULT NULL,
  `dir_layer` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin
comment='影音文件夹';

/*===========================添加加外键===========================*/
/*=======================注意两个表的类型要一致，unsign================*/
/*============================================================*/
alter table video_info add constraint FK_type_to_info foreign key (video_type_id)
      references video_type (video_type_id) on delete restrict on update restrict;






