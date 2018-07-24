/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : mic

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 23/07/2018 22:20:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ad_class
-- ----------------------------
DROP TABLE IF EXISTS `ad_class`;
CREATE TABLE `ad_class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leader_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_ad_class_Leader_1`(`leader_id`) USING BTREE,
  INDEX `fk_ad_class_class_1`(`class_id`) USING BTREE,
  CONSTRAINT `fk_ad_class_Leader_1` FOREIGN KEY (`leader_id`) REFERENCES `leader` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_ad_class_class_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ad_departments
-- ----------------------------
DROP TABLE IF EXISTS `ad_departments`;
CREATE TABLE `ad_departments`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leader_id` int(11) NOT NULL,
  `departments_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_ad_departments_Leader_1`(`leader_id`) USING BTREE,
  INDEX `fk_ad_departments_departments_1`(`departments_id`) USING BTREE,
  CONSTRAINT `fk_ad_departments_Leader_1` FOREIGN KEY (`leader_id`) REFERENCES `leader` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_ad_departments_departments_1` FOREIGN KEY (`departments_id`) REFERENCES `departments` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_note_id` int(11) NOT NULL,
  `time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `classroom` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_attendance_course_note_1`(`course_note_id`) USING BTREE,
  CONSTRAINT `fk_attendance_course_note_1` FOREIGN KEY (`course_note_id`) REFERENCES `course_note` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `departments_id` int(11) NULL DEFAULT NULL,
  `major_id` int(11) NULL DEFAULT NULL,
  `enrolment` int(11) NULL DEFAULT NULL,
  `class_size` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_class_departments_1`(`departments_id`) USING BTREE,
  CONSTRAINT `fk_class_departments_1` FOREIGN KEY (`departments_id`) REFERENCES `departments` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `interactive_id` int(11) NULL DEFAULT NULL,
  `contents` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_content_student_1`(`student_id`) USING BTREE,
  INDEX `fk_content_interactive_1`(`interactive_id`) USING BTREE,
  CONSTRAINT `fk_content_interactive_1` FOREIGN KEY (`interactive_id`) REFERENCES `interactive` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_content_student_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NOT NULL,
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `size` int(11) NOT NULL,
  `open_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_course_teacher_1`(`teacher_id`) USING BTREE,
  CONSTRAINT `fk_course_teacher_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course_note
-- ----------------------------
DROP TABLE IF EXISTS `course_note`;
CREATE TABLE `course_note`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `begin_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `end_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_course_note_course_1`(`course_id`) USING BTREE,
  CONSTRAINT `fk_course_note_course_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for departments
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `d_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `school_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_departments_school_1`(`school_id`) USING BTREE,
  CONSTRAINT `fk_departments_school_1` FOREIGN KEY (`school_id`) REFERENCES `school` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for elective
-- ----------------------------
DROP TABLE IF EXISTS `elective`;
CREATE TABLE `elective`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_elective_course_1`(`course_id`) USING BTREE,
  INDEX `fk_elective_student_1`(`student_id`) USING BTREE,
  CONSTRAINT `fk_elective_course_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_elective_student_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attendance_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `status` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_information_attendance_1`(`attendance_id`) USING BTREE,
  INDEX `fk_information_student_1`(`student_id`) USING BTREE,
  CONSTRAINT `fk_information_attendance_1` FOREIGN KEY (`attendance_id`) REFERENCES `attendance` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_information_student_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for interactive
-- ----------------------------
DROP TABLE IF EXISTS `interactive`;
CREATE TABLE `interactive`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_interactive_course_1`(`course_id`) USING BTREE,
  CONSTRAINT `fk_interactive_course_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for leader
-- ----------------------------
DROP TABLE IF EXISTS `leader`;
CREATE TABLE `leader`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for leave
-- ----------------------------
DROP TABLE IF EXISTS `leave`;
CREATE TABLE `leave`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `s_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `begin_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `end_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_leave_student_1`(`student_id`) USING BTREE,
  CONSTRAINT `fk_leave_student_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for problem
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_note_id` int(11) NOT NULL,
  `problem` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `answer` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_problem_course_note_1`(`course_note_id`) USING BTREE,
  CONSTRAINT `fk_problem_course_note_1` FOREIGN KEY (`course_note_id`) REFERENCES `course_note` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `problem_id` int(11) NOT NULL,
  `student_id` int(11) NULL DEFAULT NULL,
  `answer` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_reply_problem_1`(`problem_id`) USING BTREE,
  INDEX `fk_reply_student_1`(`student_id`) USING BTREE,
  CONSTRAINT `fk_reply_problem_1` FOREIGN KEY (`problem_id`) REFERENCES `problem` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_reply_student_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `class_id` int(11) NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `point` int(11) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` int(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_student_class_1`(`class_id`) USING BTREE,
  CONSTRAINT `fk_student_class_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
