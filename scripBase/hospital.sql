/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : hospital

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-06-24 21:20:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hospital` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `fecha_nacimiento` varchar(20) DEFAULT NULL,
  `direccion` varchar(200) NOT NULL,
  `foto` varchar(150) DEFAULT NULL,
  `fecha_creacion` datetime NOT NULL,
  `fecha_actualizacion` datetime DEFAULT NULL,
  `creado_por` varchar(20) NOT NULL DEFAULT 'user',
  `actualizado_por` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('17', '32', 'Pedro', 'Martinez', null, 'A. Vilar 10', null, '2020-06-24 00:00:00', null, 'Usuario Creacion', null);
INSERT INTO `doctor` VALUES ('19', '1', 'Jorge', 'Pacheco', '1979-10-31', 'A vilar', '', '2020-06-24 00:00:00', null, 'Usuario Creacion', null);
INSERT INTO `doctor` VALUES ('20', '1', 'Juan', 'Perez', '1982-11-11', 'Aniceto Arce Nro 22r', '', '2020-06-24 00:00:00', null, 'Usuario Creacion', null);

-- ----------------------------
-- Table structure for doctor_especialidad
-- ----------------------------
DROP TABLE IF EXISTS `doctor_especialidad`;
CREATE TABLE `doctor_especialidad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_doctor` int(11) NOT NULL,
  `id_especialidad` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor_especialidad
-- ----------------------------
INSERT INTO `doctor_especialidad` VALUES ('1', '1', '1');
INSERT INTO `doctor_especialidad` VALUES ('3', '2', '3');
INSERT INTO `doctor_especialidad` VALUES ('4', '1', '6');
INSERT INTO `doctor_especialidad` VALUES ('6', '1', '3');

-- ----------------------------
-- Table structure for especialidad
-- ----------------------------
DROP TABLE IF EXISTS `especialidad`;
CREATE TABLE `especialidad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `descripcion` varchar(40) DEFAULT NULL,
  `icono` varchar(15) DEFAULT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `creado_por` varchar(20) NOT NULL DEFAULT 'user',
  `actualizado_por` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of especialidad
-- ----------------------------
INSERT INTO `especialidad` VALUES ('1', 'Nefrología', 'Examen renal', 'icons.ico', '2020-06-22', '2020-06-23', 'Usuario Creacion', 'Actualizado Creacion');
INSERT INTO `especialidad` VALUES ('3', 'Pediatría', 'Consulta de niños', 'iconsNiños.ico', '2020-06-24', null, 'Usuario Creacion', null);
INSERT INTO `especialidad` VALUES ('6', 'Dermatología', 'Exámenes de la piel', null, '2020-06-23', null, 'Usuario Creacion', null);
INSERT INTO `especialidad` VALUES ('7', 'Cardiología', 'Exámenes del corazón', null, '2020-06-23', null, 'Usuario Creacion', null);
INSERT INTO `especialidad` VALUES ('8', 'Oftalmología', 'Exámenes de los ojos', null, '2020-06-23', null, 'Usuario Creacion', null);
INSERT INTO `especialidad` VALUES ('9', 'Hemtología', 'Exámenes de la sangre', null, '2020-06-23', null, 'Usuario Creacion', null);

-- ----------------------------
-- Table structure for hospital
-- ----------------------------
DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL,
  `fecha_creacion` datetime NOT NULL,
  `fecha_actualizacion` datetime DEFAULT NULL,
  `creado_por` varchar(20) NOT NULL DEFAULT 'user',
  `actualizado_por` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hospital
-- ----------------------------
INSERT INTO `hospital` VALUES ('11', 'Este', '2020-06-23 00:00:00', null, 'Usuario Creacion', null);
INSERT INTO `hospital` VALUES ('19', 'Sur', '2020-06-22 00:00:00', null, 'Usuario Creacion', null);
INSERT INTO `hospital` VALUES ('25', 'Obrero', '2020-06-23 00:00:00', null, 'Usuario Creacion', null);
INSERT INTO `hospital` VALUES ('32', 'Norte', '2020-06-23 00:00:00', null, 'Usuario Creacion', null);
INSERT INTO `hospital` VALUES ('33', 'Oeste', '2020-06-23 00:00:00', null, 'Usuario Creacion', null);
INSERT INTO `hospital` VALUES ('34', 'Oriental', '2020-06-23 00:00:00', null, 'Usuario Creacion', null);
INSERT INTO `hospital` VALUES ('35', 'Occidental', '2020-06-23 00:00:00', null, 'Usuario Creacion', null);
INSERT INTO `hospital` VALUES ('39', 'San Pedro', '2020-06-24 00:00:00', null, 'Usuario Creacion', null);

-- ----------------------------
-- Table structure for nota
-- ----------------------------
DROP TABLE IF EXISTS `nota`;
CREATE TABLE `nota` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_paciente` int(11) NOT NULL,
  `id_doctor` int(11) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `fecha` date NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `creado_por` varchar(20) NOT NULL DEFAULT 'user',
  `actualizado_por` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nota
-- ----------------------------
INSERT INTO `nota` VALUES ('1', '11', '1', 'Visita del día', '1979-11-16', '2020-06-22', '2020-06-22', 'Usuario Creacion', 'Actualizado Creacion');
INSERT INTO `nota` VALUES ('3', '12', '17', 'Visita número 1', '2020-06-16', '2020-06-24', null, 'Usuario Creacion', null);
INSERT INTO `nota` VALUES ('4', '13', '1', 'Visita número 2', '2020-06-23', '2020-06-24', null, 'Usuario Creacion', null);
INSERT INTO `nota` VALUES ('5', '11', '17', 'Historial Juan', '2020-06-16', '2020-06-24', null, 'Usuario Creacion', null);
INSERT INTO `nota` VALUES ('6', '12', '1', 'Jorge', '1979-11-16', '2020-06-24', null, 'Usuario Creacion', null);
INSERT INTO `nota` VALUES ('7', '13', '17', 'Esta es una prueba', '2020-06-17', '2020-06-24', null, 'Usuario Creacion', null);
INSERT INTO `nota` VALUES ('8', '11', '17', 'Dato 1', '2020-06-20', '2020-06-24', null, 'Usuario Creacion', null);

-- ----------------------------
-- Table structure for paciente
-- ----------------------------
DROP TABLE IF EXISTS `paciente`;
CREATE TABLE `paciente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hospital` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `fecha_nacimiento` varchar(20) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `foto` varchar(150) DEFAULT NULL,
  `fecha_creacion` datetime NOT NULL,
  `fecha_actualizacion` datetime DEFAULT NULL,
  `creado_por` varchar(20) NOT NULL DEFAULT 'user',
  `actualizado_por` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paciente
-- ----------------------------
INSERT INTO `paciente` VALUES ('11', '32', 'Pedro', 'Paz', '1980-05-15', 'Antonio Arce Nro 500', null, '2020-06-23 00:00:00', null, 'Usuario Creacion', null);
INSERT INTO `paciente` VALUES ('12', '25', 'Juan', 'Bautista', '1950-01-16', 'Calvo Nro 5', null, '2020-06-23 00:00:00', null, 'Usuario Creacion', null);
INSERT INTO `paciente` VALUES ('13', '25', 'Sergio', 'Bellido', '2020-06-25', 'Tarapacá Nro 200', null, '2020-06-24 00:00:00', null, 'Usuario Creacion', null);
