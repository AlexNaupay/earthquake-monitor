
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sismos
-- ----------------------------
DROP TABLE IF EXISTS `sismos`;
CREATE TABLE `sismos` (
  `id_pk` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `id` varchar(50) DEFAULT NULL,
  `alerta` varchar(35) DEFAULT NULL,
  `titulo` varchar(256) DEFAULT NULL,
  `magnitud` decimal(5,3) DEFAULT NULL,
  `lugar` varchar(256) DEFAULT NULL,
  `tiempo` datetime DEFAULT NULL,
  `actualizacion` datetime DEFAULT NULL,
  `url` varchar(256) DEFAULT NULL,
  `urldetalle` varchar(256) DEFAULT NULL,
  `tsunami` int(11) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `significancia` int(11) DEFAULT NULL,
  `longitud` double DEFAULT NULL,
  `latitud` double DEFAULT NULL,
  `profundidad` double DEFAULT NULL,
  PRIMARY KEY (`id_pk`),
  UNIQUE KEY `id_index_string` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sismos
-- ----------------------------
INSERT INTO `sismos` VALUES ('1', 'us2000657m', null, 'M 4.5 - 138km NW of Kota Ternate, Indonesia', '4.500', '138km NW of Kota Ternate, Indonesia', '2016-06-17 23:35:12', '2016-06-17 23:51:39', 'http://earthquake.usgs.gov/earthquakes/eventpage/us2000657m', 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us2000657m.geojson', '0', 'earthquake', '312', '126.5033', '1.6858', '57.36');
INSERT INTO `sismos` VALUES ('2', 'ci37609352', null, 'M 1.4 - 1km SW of Alhambra, CA', '1.430', '1km SW of Alhambra, CA', '2016-06-21 13:11:38', '2016-06-21 13:24:43', 'http://earthquake.usgs.gov/earthquakes/eventpage/ci37609352', 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/ci37609352.geojson', '0', 'earthquake', '31', '-118.1365', '34.0895', '6.22');
INSERT INTO `sismos` VALUES ('3', 'nn00548827', null, 'M 2.0 - Nevada', '2.000', 'Nevada', '2016-06-21 13:15:57', '2016-06-21 13:41:39', 'http://earthquake.usgs.gov/earthquakes/eventpage/nn00548827', 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/nn00548827.geojson', '0', 'earthquake', '62', '-117.1804', '37.4791', '4.4');
INSERT INTO `sismos` VALUES ('5', 'nc72653981', null, 'M 1.7 - 2km SW of Cobb, California', '1.700', '2km SW of Cobb, California', '2016-06-21 15:23:49', '2016-06-21 15:25:26', 'http://earthquake.usgs.gov/earthquakes/eventpage/nc72653981', 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/nc72653981.geojson', '0', 'earthquake', '44', '-122.7403336', '38.8100014', '1.53');
INSERT INTO `sismos` VALUES ('6', 'nc72653976', null, 'M 1.7 - 5km ESE of The Geysers, California', '1.670', '5km ESE of The Geysers, California', '2016-06-21 15:18:56', '2016-06-21 15:36:03', 'http://earthquake.usgs.gov/earthquakes/eventpage/nc72653976', 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/nc72653976.geojson', '0', 'earthquake', '43', '-122.7021637', '38.7503319', '1.22');
INSERT INTO `sismos` VALUES ('7', 'us2000661a', null, 'M 5.5 - 13km S of Ayaviri, Peru', '5.500', '13km S of Ayaviri, Peru', '2016-06-22 12:41:55', '2016-06-22 12:55:14', 'http://earthquake.usgs.gov/earthquakes/eventpage/us2000661a', 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us2000661a.geojson', '0', 'earthquake', '465', '-70.5863', '-15.0072', '187.89');
INSERT INTO `sismos` VALUES ('8', 'nc72654316', null, 'M 3.1 - 21km SSE of Ridgemark, California', '3.130', '21km SSE of Ridgemark, California', '2016-06-22 13:43:03', '2016-06-22 13:47:09', 'http://earthquake.usgs.gov/earthquakes/eventpage/nc72654316', 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/nc72654316.geojson', '0', 'earthquake', '151', '-121.2556686', '36.635334', '8.84');
INSERT INTO `sismos` VALUES ('9', 'us2000662k', null, 'M 5.2 - 129km N of Visokoi Island, South Georgia and the South Sandwich Islands', '5.200', '129km N of Visokoi Island, South Georgia and the South Sandwich Islands', '2016-06-22 15:10:16', '2016-06-22 15:27:42', 'http://earthquake.usgs.gov/earthquakes/eventpage/us2000662k', 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us2000662k.geojson', '0', 'earthquake', '416', '-26.8502', '-55.5521', '36.35');
INSERT INTO `sismos` VALUES ('10', 'ak13681311', null, 'M 2.8 - Southern Alaska', '2.800', 'Southern Alaska', '2016-06-22 15:02:49', '2016-06-22 15:42:30', 'http://earthquake.usgs.gov/earthquakes/eventpage/ak13681311', 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/ak13681311.geojson', '0', 'earthquake', '121', '-146.4618', '61.5222', '19.1');
INSERT INTO `sismos` VALUES ('11', 'us2000663s', null, 'M 5.2 - 112km W of Port-Vila, Vanuatu', '5.200', '112km W of Port-Vila, Vanuatu', '2016-06-22 16:43:36', '2016-06-22 17:04:36', 'http://earthquake.usgs.gov/earthquakes/eventpage/us2000663s', 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us2000663s.geojson', '0', 'earthquake', '416', '167.2722', '-17.8608', '10');
INSERT INTO `sismos` VALUES ('12', 'us2000663w', null, 'M 4.8 - 181km NNW of Sola, Vanuatu', '4.800', '181km NNW of Sola, Vanuatu', '2016-06-22 17:20:51', '2016-06-22 17:40:37', 'http://earthquake.usgs.gov/earthquakes/eventpage/us2000663w', 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us2000663w.geojson', '0', 'earthquake', '354', '167.1362', '-12.2942', '251.16');
INSERT INTO `sismos` VALUES ('13', 'ci37610680', null, 'M 2.7 - 53km WSW of Rosarito, B.C., MX', '2.690', '53km WSW of Rosarito, B.C., MX', '2016-06-22 18:16:45', '2016-06-22 19:00:56', 'http://earthquake.usgs.gov/earthquakes/eventpage/ci37610680', 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/ci37610680.geojson', '0', 'earthquake', '111', '-117.583', '32.2376667', '5.82');
INSERT INTO `sismos` VALUES ('14', 'us20006643', null, 'M 4.4 - 10km NNW of Abdanan, Iran', '4.400', '10km NNW of Abdanan, Iran', '2016-06-22 18:14:25', '2016-06-22 19:03:22', 'http://earthquake.usgs.gov/earthquakes/eventpage/us20006643', 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us20006643.geojson', '0', 'earthquake', '298', '47.3844', '33.0783', '10');
INSERT INTO `sismos` VALUES ('15', 'hv61307431', null, 'M 3.0 - 6km E of Leilani Estates, Hawaii', '2.980', '6km E of Leilani Estates, Hawaii', '2016-06-22 19:51:45', '2016-06-22 19:57:43', 'http://earthquake.usgs.gov/earthquakes/eventpage/hv61307431', 'http://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/hv61307431.geojson', '0', 'earthquake', '137', '-154.8543396', '19.479166', '1.24');
