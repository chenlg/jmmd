# Host: localhost  (Version: 5.6.12)
# Date: 2014-04-18 14:21:32
# Generator: MySQL-Front 5.3  (Build 4.91)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "ss_task"
#

DROP TABLE IF EXISTS `ss_task`;
CREATE TABLE `ss_task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(64) NOT NULL DEFAULT '',
  `task_code` varchar(64) NOT NULL DEFAULT '',
  `status` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "ss_task"
#
