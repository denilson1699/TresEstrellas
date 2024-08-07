-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-09-2020 a las 04:46:20
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_tres_estrellas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedidos`
--

CREATE TABLE `detalle_pedidos` (
  `Id_Detalle_Pedidos` int(11) NOT NULL,
  `doc_Ident_cliente` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `codigo_producto` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `Tipo` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Serie_venta` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `Numero_Venta` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `Descripcion_pro` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `cantidad_pro` int(11) NOT NULL,
  `Precio_uni` decimal(10,0) NOT NULL,
  `Monto_generado` decimal(10,0) NOT NULL,
  `Dia_pedido` int(11) NOT NULL,
  `Mes_pedido` int(11) NOT NULL,
  `Año_pedido` int(11) NOT NULL,
  `Dni_user` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha_pedido` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `detalle_pedidos`
--

INSERT INTO `detalle_pedidos` (`Id_Detalle_Pedidos`, `doc_Ident_cliente`, `codigo_producto`, `Tipo`, `Serie_venta`, `Numero_Venta`, `Descripcion_pro`, `cantidad_pro`, `Precio_uni`, `Monto_generado`, `Dia_pedido`, `Mes_pedido`, `Año_pedido`, `Dni_user`, `Fecha_pedido`) VALUES
(107, '76131029', 'P0000019', 'BOLETA', '', '0000001', 'detergente opal ultra 500 g', 1, '4', '4', 13, 7, 2020, '76131029', '13/7/2020'),
(108, '76131029', 'P0000019', 'BOLETA', '', '0000001', 'detergente opal ultra 500 g', 1, '4', '4', 13, 7, 2020, '76131029', '13/7/2020'),
(109, '76131029', 'P0000030', 'BOLETA', '', '0000001', 'caracol anita 250g', 1, '1', '1', 13, 7, 2020, '76131029', '13/7/2020'),
(110, '76131029', 'P0000030', 'BOLETA', '', '0000001', 'caracol anita 250g', 1, '1', '1', 13, 7, 2020, '76131029', '13/7/2020'),
(111, '76131029', 'P0000030', 'BOLETA', '', '0000001', 'caracol anita 250g', 1, '1', '1', 13, 7, 2020, '76131029', '13/7/2020'),
(112, '76131029', 'P0000030', 'BOLETA', '', '0000001', 'caracol anita 250g', 1, '1', '1', 13, 7, 2020, '76131029', '13/7/2020'),
(113, '76131029', 'P0000089', 'BOLETA', '', '0000001', 'oreo original   36 gr', 1, '1', '1', 13, 7, 2020, '76131029', '13/7/2020'),
(114, '76131029', 'P0000089', 'BOLETA', '', '0000001', 'oreo original   36 gr', 1, '1', '1', 13, 7, 2020, '76131029', '13/7/2020'),
(115, '76131029', 'P0000089', 'BOLETA', '', '0000001', 'oreo original   36 gr', 1, '1', '1', 13, 7, 2020, '76131029', '13/7/2020'),
(116, '76131029', 'P0000089', 'BOLETA', '', '0000001', 'oreo original   36 gr', 1, '1', '1', 13, 7, 2020, '76131029', '13/7/2020'),
(117, '', 'P0000006', 'FACTURA', 'E001', '0000001', 'head & sholder shampoo 2 en 1 18 ml', 2, '1', '2', 16, 7, 2020, '76131029', '16/7/2020'),
(118, '1', 'P0000006', 'FACTURA', 'E001', '0000001', 'head & sholder shampoo 2 en 1 18 ml', 2, '1', '2', 16, 7, 2020, '76131029', '16/7/2020'),
(120, '1', 'P0000006', 'FACTURA', 'E001', '0000001', 'head & sholder shampoo 2 en 1 18 ml', 2, '1', '2', 16, 7, 2020, '76131029', '16/7/2020');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla_asistencias`
--

CREATE TABLE `tabla_asistencias` (
  `Id_asistencia` int(11) NOT NULL,
  `Dni_user` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `CodigoContrato` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `F_asistencia` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Hr_ingreso` int(11) NOT NULL,
  `Hr_salida` int(11) NOT NULL,
  `Hrs_trabajadas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='tabal de asistencias';

--
-- Volcado de datos para la tabla `tabla_asistencias`
--

INSERT INTO `tabla_asistencias` (`Id_asistencia`, `Dni_user`, `CodigoContrato`, `F_asistencia`, `Hr_ingreso`, `Hr_salida`, `Hrs_trabajadas`) VALUES
(7, '76131029', 'C76131029', '16/7/2020', 18, 19, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla_clientes`
--

CREATE TABLE `tabla_clientes` (
  `Id_cliente` int(11) NOT NULL,
  `Dni_cliente` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `Nombre_cliente` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Apellidos_cliente` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `Direccion_cliente` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `Correo_cliente` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Telf_cliente` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Sexo_cliente` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `Edad_cliente` int(11) NOT NULL,
  `Fecha_registro` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tabla_clientes`
--

INSERT INTO `tabla_clientes` (`Id_cliente`, `Dni_cliente`, `Nombre_cliente`, `Apellidos_cliente`, `Direccion_cliente`, `Correo_cliente`, `Telf_cliente`, `Sexo_cliente`, `Edad_cliente`, `Fecha_registro`) VALUES
(12, '76131029', 'Denilson', 'Jaramilllo Castillo', 'av cesar ', '@gmail.com', '123456', 'm', 20, '13/7/20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla_clientesruc`
--

CREATE TABLE `tabla_clientesruc` (
  `Ruc_cliente` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `Razon_cliente` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `Rubro_cliente` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `direccion_cliente` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Telf_cliente` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `Correo_cliente` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha_cliente` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tabla_clientesruc`
--

INSERT INTO `tabla_clientesruc` (`Ruc_cliente`, `Razon_cliente`, `Rubro_cliente`, `direccion_cliente`, `Telf_cliente`, `Correo_cliente`, `Fecha_cliente`) VALUES
('1', '11', '1', '1', '1', '1', '16/7/2020');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla_contratos`
--

CREATE TABLE `tabla_contratos` (
  `CodigoContrato` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `Dni_user` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha_contrato` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `hr_Ingreso` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `hr_Salida` int(2) NOT NULL,
  `Dia_descanso` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `sueldo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tabla_contratos`
--

INSERT INTO `tabla_contratos` (`CodigoContrato`, `Dni_user`, `Fecha_contrato`, `hr_Ingreso`, `hr_Salida`, `Dia_descanso`, `sueldo`) VALUES
('C76131029', '76131029', '16/10/1999', '8', 17, 'Domingo', 1000),
('C07128889', '07128889', '01/10/2019', '8', 17, 'Domingo', 930);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla_primero_secundaria`
--

CREATE TABLE `tabla_primero_secundaria` (
  `Dni_est` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `Nombre_est` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Apellidos_est` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `Estado` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `FechaRegistro` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Observaciones` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Dni_tutor` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `nombre_tutor` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Apellido_tutor` varchar(40) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tabla_primero_secundaria`
--

INSERT INTO `tabla_primero_secundaria` (`Dni_est`, `Nombre_est`, `Apellidos_est`, `Estado`, `FechaRegistro`, `Observaciones`, `Dni_tutor`, `nombre_tutor`, `Apellido_tutor`) VALUES
('76131029', 'denilson', 'Jaramillo Castillo', 'Activo', '1/8/2020', '', '03120800', 'vitor', 'porres porees'),
('76131029', 'denilson', 'Jaramillo Castillo', 'Activo', '1/8/2020', '', '03120800', 'vitor', 'porres porees');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla_productos`
--

CREATE TABLE `tabla_productos` (
  `Codigo_pro` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `Descripcion_pro` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `Formato_pro` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Precio_pro` decimal(10,2) NOT NULL,
  `Stock_pro` int(11) NOT NULL,
  `Categoria_pro` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha_ingreso` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha_venc` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Ruc_proveedor` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tabla_productos`
--

INSERT INTO `tabla_productos` (`Codigo_pro`, `Descripcion_pro`, `Formato_pro`, `Precio_pro`, `Stock_pro`, `Categoria_pro`, `Fecha_ingreso`, `Fecha_venc`, `Ruc_proveedor`) VALUES
('P0000001', 'aceite deleite premiun', 'Unidad ', '5.50', 0, 'Abarrotes', '04/06/2020', '12/05/2021', '20499709944'),
('P0000002', 'papel higenico noble doble hoja', 'Unidad ', '0.80', 69, 'Productos de Limpieza', '02/06/2020', '13/05/2021', '20499709944'),
('P0000003', 'papel suave cuidado completo doble hoja ', 'Unidad ', '1.00', 23, 'Productos de Limpieza', '16/03/2020', '14/05/2021', '20499709944'),
('P0000004', 'papel elite doble hoja', 'Unidad ', '1.00', 27, 'Productos de Limpieza', '27/04/2020', '15/05/2021', '20499709944'),
('P0000005', 'head & sholder shampoo control caspa 18 ml', 'Select Formato', '1.00', 32, 'Productos de Limpieza', '28/04/2020', '16/05/2021', '20499709944'),
('P0000006', 'head & sholder shampoo 2 en 1 18 ml', 'Select Formato', '1.00', 12, 'Productos de Limpieza', '29/04/2020', '17/05/2021', '20499709944'),
('P0000007', 'sedal caspa control 2 en 1  45 ml', 'Select Formato', '1.30', 10, 'Productos de Limpieza', '30/04/2020', '18/05/2021', '20499709944'),
('P0000008', 'gohmson\'s baby shampoon 25 ml', 'Select Formato', '1.30', 10, 'Productos de Limpieza', '01/05/2020', '19/05/2021', '20499709944'),
('P0000009', 'pantene crema para peinar   16 ml', 'Bolsa Gr', '1.00', 2, 'Productos de Limpieza', '26/06/2020', '26/06/2022', '20499709944'),
('P0000010', 'pantene shampoo   18 ml + acondicionador ', 'Bolsa Gr', '1.00', 15, 'Productos de Limpieza', '26/06/2020', '27/06/2022', '20499709944'),
('P0000011', 'nutribela 10         30ml', 'Bolsa Gr', '1.50', 4, 'Productos de Limpieza', '26/06/2020', '28/06/2022', '20499709944'),
('P0000012', 'sedal shampoo  45 ml', 'Bolsa Gr', '1.30', 10, 'Productos de Limpieza', '26/06/2020', '29/06/2022', '20499709944'),
('P0000013', 'sedal provitamina B5     45', 'Bolsa Gr', '1.30', 6, 'Productos de Limpieza', '26/06/2020', '30/06/2022', '20499709944'),
('P0000014', 'banih blanco total     100 ml ', 'Bolsa Gr', '1.50', 7, 'Productos de Limpieza', '26/06/2020', '01/07/2022', '20499709944'),
('P0000015', 'downy  concentrado   80 ml', 'Bolsa Gr', '1.00', 12, 'Productos de Limpieza', '26/06/2020', '02/07/2022', '20499709944'),
('P0000016', 'bolivar barra de javon    210g', 'Barra Gr', '2.20', 9, 'Productos de Limpieza', '26/06/2020', '03/07/2022', '20499709944'),
('P0000017', 'detergente patito 140 g', 'Barra Gr', '1.00', 48, 'Productos de Limpieza', '26/06/2020', '31/01/2023', '20499709944'),
('P0000018', 'detergente sapolio 150 g', 'Barra Gr', '1.20', 36, 'Productos de Limpieza', '26/06/2020', '28/10/2023', '20499709944'),
('P0000019', 'detergente opal ultra 500 g', 'Barra Gr', '4.00', 13, 'Productos de Limpieza', '14/02/2020', '03/07/2022', '20499709944'),
('P0000020', 'detergente marcella 150 g', 'Barra Gr', '1.20', 38, 'Productos de Limpieza', '23/01/2020', '04/07/2022', '20499709944'),
('P0000021', 'detergente marcella 350g', 'Barra Gr', '3.00', 35, 'Productos de Limpieza', '23/01/2020', '05/07/2022', '20499709944'),
('P0000022', 'sapolio quita mancha 3 en 1   300 ml', 'Botella Ml', '2.00', 4, 'Productos de Limpieza', '26/06/2020', '01/03/2023', '20499709944'),
('P0000023', 'clorox triple accion 639 ml', 'Botella Ml', '1.80', 10, 'Productos de Limpieza', '19/05/2020', '10/05/2021', '20499709944'),
('P0000024', 'liguria lejia tradicional   323 ml', 'Botella Ml', '1.00', 14, 'Productos de Limpieza', '26/06/2020', '01/05/2022', '20499709944'),
('P0000025', 'poet 325 ml', 'Botella Ml', '1.40', 20, 'Abarrotes', '26/06/2020', '01/02/2022', '20499709944'),
('P0000026', 'tallarin anita 500g', 'Bolsa Gr', '1.50', 33, 'Abarrotes', '26/06/2020', '01/04/2022', '20499709944'),
('P0000027', 'cabello angel anita', 'Bolsa Gr', '0.80', 5, 'Abarrotes', '26/06/2020', '01/02/2022', '20499709944'),
('P0000028', 'lavaggi 1kg', 'Bolsa kg', '4.00', 12, 'Abarrotes', '26/06/2020', '24/05/2022', '20499709944'),
('P0000029', 'macarron anita 500g', 'Bolsa Gr', '1.50', 20, 'Abarrotes', '26/06/2020', '01/01/2022', '20499709944'),
('P0000030', 'caracol anita 250g', 'Bolsa Gr', '0.80', 36, 'Abarrotes', '26/06/2020', '01/04/2022', '20499709944'),
('P0000031', 'liguria lejia tradicional   636 ml', 'Botella Ml', '2.00', 2, 'Productos de Limpieza', '26/06/2020', '01/05/2022', '20499709944'),
('P0000032', '7 semillas 180g', 'Barra Gr', '2.00', 15, 'Abarrotes', '26/06/2020', '21/02/2021', '20499709944'),
('P0000033', 'harina sin preparar 250 g', 'Bolsa Gr', '1.30', 20, 'Abarrotes', '26/06/2020', '15/10/2020', '20499709944'),
('P0000034', 'harina preparada 500g', 'Barra Gr', '3.50', 2, 'Abarrotes', '26/06/2020', '06/11/2020', '20499709944'),
('P0000035', 'Mc Colin\'s  manzanilla', 'Unidad ', '0.10', 180, 'Abarrotes', '26/06/2020', '01/08/2022', '20499709944'),
('P0000036', 'Herbi Anis', 'Unidad ', '0.10', 95, 'Abarrotes', '26/06/2020', '14/02/2222', '20499709944'),
('P0000037', 'Herbi Te , Canela y Clavo', 'Unidad ', '0.10', 110, 'Abarrotes', '26/06/2020', '04/01/2021', '20499709944'),
('P0000038', 'Mc Colin\'s  Te, Canela y Clavo', 'Unidad ', '0.10', 100, 'Abarrotes', '26/06/2020', '09/10/2021', '20499709944'),
('P0000039', 'avena familiar Quaker   130gr', 'Bolsa Gr', '1.00', 32, 'Abarrotes', '26/06/2020', '20/04/2021', '20499709944'),
('P0000040', 'avena  precocida 3 ositos    220gr', 'Barra Gr', '2.00', 48, 'Abarrotes', '26/06/2020', '19/05/2021', '20499709944'),
('P0000041', 'vinagre tinto del FIRME   125 ml', 'Botella Ml', '1.00', 24, 'Abarrotes', '26/06/2020', '13/04/2025', '20499709944'),
('P0000042', 'kiko siyau salsa de soya 85 ml', 'Botella Ml', '1.00', 16, 'Abarrotes', '26/06/2020', '22/05/2022', '20499709944'),
('P0000043', 'kiko siyau salsa de soya  160 ml', 'Botella Ml', '1.20', 1, 'Abarrotes', '26/06/2020', '22/05/1922', '20499709944'),
('P0000044', 'esencia de vanilla Frandori   90 ml', 'Botella Ml', '1.00', 8, 'Abarrotes', '26/06/2020', '01/12/2026', '20499709944'),
('P0000045', 'palillo sibarita    10.5 gr', 'Bolsa Gr', '0.50', 84, 'Abarrotes', '26/06/2020', '12/01/2021', '20499709944'),
('P0000046', 'Maizena Duryea   100gr', 'Bolsa Gr', '1.50', 1, 'Abarrotes', '26/06/2020', '20/02/1921', '20499709944'),
('P0000047', 'katita Maizena   100gr', 'Bolsa Gr', '1.50', 11, 'Abarrotes', '26/06/2020', '20/02/1921', '20499709944'),
('P0000048', 'zuko chicha morada 15gr', 'Bolsa Gr', '1.00', 4, 'Abarrotes', '26/06/2020', '02/02/2023', '20499709944'),
('P0000049', 'zuko pi?a 15 gr', 'Bolsa Gr', '1.00', 4, 'Abarrotes', '26/06/2020', '02/02/2023', '20499709944'),
('P0000050', 'zuko naranja 15 gr ', 'Bolsa Gr', '1.00', 1, 'Abarrotes', '26/06/2020', '02/02/2023', '20499709944'),
('P0000051', 'semola Molitaria 200gr', 'Select Formato', '1.20', 13, 'Abarrotes', '26/06/2020', '25/10/2020', '20499709944'),
('P0000052', 'semola Marco Polo  180gr', 'Select Formato', '1.00', 21, 'Abarrotes', '26/06/2020', '22/11/2020', '20499709944'),
('P0000053', 'sal comun Marina    500gr', 'Select Formato', '0.80', 104, 'Abarrotes', '26/06/2020', '20/02/1922', '20499709944'),
('P0000054', 'pomarola Molitaria 160gr', 'Select Formato', '1.20', 15, 'Abarrotes', '26/06/2020', '01/01/2021', '20499709944'),
('P0000055', 'mazamorra morada Negrita 160gr', 'Select Formato', '3.20', 6, 'Abarrotes', '26/06/2020', '01/12/2021', '20499709944'),
('P0000056', 'mazamorra pi?a Negrita 160gr', 'Select Formato', '3.20', 1, 'Abarrotes', '26/06/2020', '01/08/2020', '20499709944'),
('P0000057', 'gelatina naranja Negrita 2L 150gr', 'Bolsa Gr', '3.20', 2, 'Abarrotes', '26/06/2020', '01/02/2022', '20499709944'),
('P0000058', 'gelatina pi?a Negrita 2L 150gr', 'Bolsa Gr', '3.20', 1, 'Abarrotes', '26/06/2020', '01/02/2022', '20499709944'),
('P0000059', 'aceite la patrona premiun 1litro', 'Select Formato', '5.00', 4, 'Abarrotes', '26/06/2020', '29/05/1921', '20499709944'),
('P0000060', 'aceite cocinero 1 litro', 'Select Formato', '6.50', 9, 'Abarrotes', '26/06/2020', '14/02/1921', '20499709944'),
('P0000061', 'aceite real   200ml', 'Select Formato', '1.50', 5, 'Abarrotes', '26/06/2020', '29/01/1922', '20499709944'),
('P0000062', 'filete de caballa Pariona 170 gr', 'Select Formato', '3.50', 14, 'Abarrotes', '26/06/2020', '28/12/2023', '20499709944'),
('P0000063', 'trozos de atun Florida  140 gr', 'Select Formato', '5.00', 7, 'Abarrotes', '26/06/2020', '01/10/2024', '20499709944'),
('P0000064', 'trozos de atun inca mar 170 gr', 'Select Formato', '4.50', 2, 'Abarrotes', '26/06/2020', '17/03/2024', '20499709944'),
('P0000065', 'cubo gallina maggi 18.8g', 'Select Formato', '0.50', 23, 'Abarrotes', '26/06/2020', '30/09/2020', '20499709944'),
('P0000066', 'do?a gusta tocino  7g', 'Select Formato', '0.20', 12, 'Abarrotes', '26/06/2020', '23/12/1920', '20499709944'),
('P0000067', 'do?a gusta gallina 7g', 'Select Formato', '0.20', 71, 'Abarrotes', '26/06/2020', '04/03/2021', '20499709944'),
('P0000068', 'sazobador aji panca 9.5g', 'Select Formato', '0.50', 38, 'Abarrotes', '26/06/2020', '25/3/2022', '20499709944'),
('P0000069', 'pimienta  sibarita   3.6g', 'Select Formato', '0.50', 26, 'Abarrotes', '26/06/2020', '25/3/2022', '20499709944'),
('P0000070', 'tuco tallarin  sibarita   9.3g', 'Select Formato', '0.50', 47, 'Abarrotes', '26/06/2020', '29/11/2021', '20499709944'),
('P0000071', 'ajinomoto 13gr', 'Bolsa Gr', '0.30', 37, 'Abarrotes', '26/06/2020', '23/10/2024', '20499709944'),
('P0000072', 'ajinomoto 52gr', 'Bolsa Gr', '1.00', 15, 'Abarrotes', '26/06/2020', '13/02/2025', '20499709944'),
('P0000073', 'pimienta  sibarita   1,25g', 'Select Formato', '0.20', 12, 'Abarrotes', '26/06/2020', '30/07/2020', '20499709944'),
('P0000074', 'cuates picantes 31gr', 'Select Formato', '0.50', 6, 'Dulces', '26/06/2020', '07/12/2020', '10735847266'),
('P0000075', 'cuates tradiciones 31gr', 'Select Formato', '0.50', 7, 'Dulces', '26/06/2020', '08/02/2020', '10735847266'),
('P0000076', 'papas lay\'s clasicas 36 gr ', 'Select Formato', '1.00', 6, 'Dulces', '26/06/2020', '19/07/2020', '10735847266'),
('P0000077', 'piqueo snax 45 gr', 'Select Formato', '1.20', 5, 'Dulces', '26/06/2020', '07/05/2020', '10735847266'),
('P0000078', 'cerel copy copos de trigo con cocoa y sabor a chocolate y con marshmal', 'Select Formato', '0.50', 8, 'Dulces', '26/06/2020', '21/04/2021', '10735847266'),
('P0000079', 'cereal chock    18 gr', 'Bolsa Gr', '0.50', 16, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000080', 'cerel zuck  18gr', 'Bolsa Gr', '0.50', 9, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000081', 'cerel meli   20gr', 'Bolsa Gr', '0.50', 8, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000082', 'cheese tris    16 gr', 'Bolsa Gr', '0.50', 13, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000083', 'chizitos sabor a queso    40gr', 'Bolsa Gr', '1.00', 5, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000084', 'zuck 140 gr', 'Bolsa Gr', '2.20', 6, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000085', 'costa  Nick 29 gr   sabor chocolate', 'Paquete un', '0.50', 17, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000086', 'costa choman 30 gr', 'Paquete un', '0.50', 15, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000087', 'ritz  67gr', 'Paquete un', '1.00', 8, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000088', 'soda v  sabor original ', 'Paquete un', '0.50', 3, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000089', 'oreo original   36 gr', 'Paquete un', '0.60', 0, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000090', 'soda san jorge  40gr ', 'Paquete un', '0.50', 0, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000091', 'soda field    34 gr', 'Paquete un', '0.50', 10, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000092', 'cancun costa 44gr', 'Paquete un', '0.50', 5, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000093', 'choman doble manjar de costa4  53 gr', 'Paquete un', '1.00', 4, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000094', 'vanilla de costa', 'Paquete un', '0.50', 5, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000095', 'galleta agua libe de costa   44gr', 'Paquete un', '0.70', 9, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000096', 'galleta GN Rellenitas fresa  36 gr', 'Paquete un', '0.50', 5, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000097', 'Frac  sabor chocolate 45 gr', 'Paquete un', '0.60', 8, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000098', 'lentejitas nestle   16gr', 'Paquete un', '0.50', 8, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000099', 'galleta tentacion chocolate  45 gr', 'Paquete un', '0.60', 4, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000100', 'galleta soda familiar san jorge 75gr', 'Paquete un', '1.00', 4, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000101', 'galleta Cracknel  san  jorge 140 gr', 'Paquete un', '1.70', 2, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000102', 'galleta Cracknel integral san   jorge 140 gr', 'Paquete un', '1.70', 7, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000103', 'ca?onazo costa 22gr', 'Paquete un', '0.50', 27, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000104', 'sublime clasico  30gr', 'Paquete un', '1.30', 13, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000105', 'princesa nestle  30gr', 'Paquete un', '1.50', 12, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000106', 'mecano costa gr 19gr', 'Paquete un', '0.50', 28, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000107', 'halls extra fuerte-lyptus', 'Paquete un', '1.00', 21, 'Dulces', '26/06/2020', '21/04/2022', '10735847266'),
('P0000108', 'mermelada de fresa Fanny 100gr', 'Paquete un', '1.30', 24, 'Abarrotes', '26/06/2020', '21/04/2022', '20499709944'),
('P0000109', 'cocoa winters 11gr', 'Paquete un', '0.50', 25, 'Abarrotes', '26/06/2020', '21/04/2022', '20499709944'),
('P0000110', 'deli fresa   Fanny    85 gr', 'Paquete un', '1.00', 2, 'Abarrotes', '26/06/2020', '21/04/2022', '20499709944'),
('P0000111', 'sello de oro margarina   45 gr', 'Paquete Gr', '1.00', 4, 'Abarrotes', '26/06/2020', '21/04/2022', '20499709944'),
('P0000112', 'Ecco nestle  10 gr', 'Paquete Gr', '1.00', 3, 'Abarrotes', '26/06/2020', '21/04/2022', '20499709944'),
('P0000113', 'Milo nestle 18 gr', 'Paquete Gr', '1.00', 19, 'Abarrotes', '26/06/2020', '21/04/2022', '20499709944'),
('P0000114', 'leche evaporada entera   170 gr', 'Bolsa Gr', '1.80', 20, 'Abarrotes', '26/06/2020', '21/04/2021', '20499709944'),
('P0000115', 'leche evaporada entera   400gr', 'Bolsa Gr', '2.30', 26, 'Abarrotes', '26/06/2020', '21/04/2021', '20499709944'),
('P0000116', 'pura vida    165 gr', 'Bolsa Gr', '1.50', 38, 'Abarrotes', '26/06/2020', '21/04/2021', '20499709944'),
('P0000117', 'leche condesada    100gr', 'Bolsa Gr', '1.50', 8, 'Abarrotes', '26/06/2020', '21/04/2021', '20499709944'),
('P0000118', 'Bonle gloria 500 gr', 'Bolsa Gr', '2.80', 6, 'Abarrotes', '26/06/2020', '21/04/2021', '20499709944'),
('P0000119', 'gatorade  500 ml', 'Bolsa Gr', '2.00', 8, 'Bebidas ', '26/06/2020', '21/04/2021', '20517861732'),
('P0000120', 'coca cola 500ml', 'Botella Ml', '2.50', 9, 'Bebidas ', '26/06/2020', '21/04/2021', '20517861732'),
('P0000121', 'big cola   400ml', 'Botella Ml', '1.20', 13, 'Bebidas ', '26/06/2020', '21/04/2021', '20517861732'),
('P0000122', 'guarana backus  450 ml', 'Botella Ml', '1.50', 11, 'Bebidas ', '26/06/2020', '21/04/2021', '20517861732'),
('P0000123', 'big oro 400 ml', 'Botella Ml', '1.20', 9, 'Bebidas ', '26/06/2020', '21/04/2021', '20517861732'),
('P0000124', 'volt 300ml', 'Botella Ml', '2.00', 7, 'Bebidas ', '26/06/2020', '21/04/2021', '20517861732'),
('P0000125', 'inca kola 3litros ', 'Botella Ml', '11.00', 1, 'Bebidas ', '26/06/2020', '21/04/2021', '20517861732'),
('P0000126', 'coca cola 3 litros', 'Botella Ml', '11.00', 3, 'Bebidas ', '26/06/2020', '21/04/2021', '20517861732'),
('P0000127', 'agua cielo 2.5', 'Botella Ml', '3.20', 2, 'Bebidas ', '26/06/2020', '21/04/2021', '20517861732'),
('P0000128', 'dento triple accion ', 'Bolsa Gr', '3.00', 6, 'Productos de Limpieza', '26/06/2020', '21/04/2021', '20499709944'),
('P0000129', 'jabon protex', 'Bolsa Gr', '3.00', 9, 'Productos de Limpieza', '26/06/2020', '21/04/2021', '20499709944'),
('P0000130', 'jabon  neko', 'Bolsa Gr', '3.00', 10, 'Productos de Limpieza', '26/06/2020', '21/04/2021', '20499709944'),
('P0000131', 'jabon camay', 'Bolsa Gr', '2.80', 2, 'Productos de Limpieza', '26/06/2020', '21/04/2021', '20499709944'),
('P0000132', 'arroz  kg', 'Bolsa Gr', '3.20', 28, 'Abarrotes', '26/06/2020', '21/04/2021', '20499709944');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla_proveedores`
--

CREATE TABLE `tabla_proveedores` (
  `Id_proveedores` int(11) NOT NULL,
  `Ruc_proveedor` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `Razon_proveedor` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `Correo_proveedor` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `Telf_proveedor` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Direccion__proveedor` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tabla_proveedores`
--

INSERT INTO `tabla_proveedores` (`Id_proveedores`, `Ruc_proveedor`, `Razon_proveedor`, `Correo_proveedor`, `Telf_proveedor`, `Direccion__proveedor`) VALUES
(4, '20499709944', 'GRUPO VEGA DISTRIBUCION S.A.C', '@gmail.com', '0', 'null'),
(5, '10735847266', 'DULCERÍA JHEVERLY', '@gmail.com', '0', 'Av. Jose Carlos Mariátegui N 1278 (VMT)'),
(6, '20517861732', 'NILDA & ROGELIO E.I.R.L.', '@gmail.com', '0', 'null');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla_user`
--

CREATE TABLE `tabla_user` (
  `Dni_user` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `Pass_user` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Nombre_user` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Apellidos_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Correo_user` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Cargo_user` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Estado_user` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Telf_user` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `Sexo_user` varchar(1) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tabla_user`
--

INSERT INTO `tabla_user` (`Dni_user`, `Pass_user`, `Nombre_user`, `Apellidos_user`, `Correo_user`, `Cargo_user`, `Estado_user`, `Telf_user`, `Sexo_user`) VALUES
('76131029', '123456', 'DENILSON', 'JARAMILLO CASTILLO', 'jaramillod1699@gmail.com', 'ADMINISTRADOR', 'ACTIVO', '933569112', 'M'),
('07128889', '123456', 'FELIPE', 'QUICAÑO CALLAÑAUPA', '@gmail.com', 'ADMINISTRADOR', 'ACTIVO', '0', 'M'),
('00000000', '123456', 'FILOMENA', 'SALVATIERRA', '@gmail.com', 'VENDEDOR', 'ACTIVO', '1', 'F');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla_venta_boletas`
--

CREATE TABLE `tabla_venta_boletas` (
  `Id_ventaBol` int(11) NOT NULL,
  `Numero_VentaBol` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `doc_Ident_cliente` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `Total_ventaBol` decimal(10,0) NOT NULL,
  `Dia_ventaBol` int(11) NOT NULL,
  `Mes_ventaBol` int(11) NOT NULL,
  `Año_ventaBol` int(11) NOT NULL,
  `Dni_user` varchar(8) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla_venta_facturas`
--

CREATE TABLE `tabla_venta_facturas` (
  `Id_ventaFac` int(11) NOT NULL,
  `Serie_ventaFac` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `Numero_ventaFac` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `doc_Ident_cliente` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `Total_ventaFac` decimal(10,0) NOT NULL,
  `Dia_ventaFac` int(11) NOT NULL,
  `Mes_ventaFac` int(11) NOT NULL,
  `año_ventaFac` int(11) NOT NULL,
  `Dni_user` varchar(8) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalle_pedidos`
--
ALTER TABLE `detalle_pedidos`
  ADD PRIMARY KEY (`Id_Detalle_Pedidos`);

--
-- Indices de la tabla `tabla_asistencias`
--
ALTER TABLE `tabla_asistencias`
  ADD PRIMARY KEY (`Id_asistencia`);

--
-- Indices de la tabla `tabla_clientes`
--
ALTER TABLE `tabla_clientes`
  ADD PRIMARY KEY (`Id_cliente`);

--
-- Indices de la tabla `tabla_clientesruc`
--
ALTER TABLE `tabla_clientesruc`
  ADD UNIQUE KEY `Ruc_cliente` (`Ruc_cliente`);

--
-- Indices de la tabla `tabla_productos`
--
ALTER TABLE `tabla_productos`
  ADD UNIQUE KEY `Codigo_pro` (`Codigo_pro`);

--
-- Indices de la tabla `tabla_proveedores`
--
ALTER TABLE `tabla_proveedores`
  ADD PRIMARY KEY (`Id_proveedores`);

--
-- Indices de la tabla `tabla_venta_boletas`
--
ALTER TABLE `tabla_venta_boletas`
  ADD PRIMARY KEY (`Id_ventaBol`);

--
-- Indices de la tabla `tabla_venta_facturas`
--
ALTER TABLE `tabla_venta_facturas`
  ADD PRIMARY KEY (`Id_ventaFac`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalle_pedidos`
--
ALTER TABLE `detalle_pedidos`
  MODIFY `Id_Detalle_Pedidos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=122;

--
-- AUTO_INCREMENT de la tabla `tabla_asistencias`
--
ALTER TABLE `tabla_asistencias`
  MODIFY `Id_asistencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tabla_clientes`
--
ALTER TABLE `tabla_clientes`
  MODIFY `Id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `tabla_proveedores`
--
ALTER TABLE `tabla_proveedores`
  MODIFY `Id_proveedores` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tabla_venta_boletas`
--
ALTER TABLE `tabla_venta_boletas`
  MODIFY `Id_ventaBol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tabla_venta_facturas`
--
ALTER TABLE `tabla_venta_facturas`
  MODIFY `Id_ventaFac` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
