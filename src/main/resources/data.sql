-- Carga de departamentos de El Salvador (idempotente por nombre)
INSERT INTO departments (name) VALUES ('Ahuachapán') ON DUPLICATE KEY UPDATE name=VALUES(name);
INSERT INTO departments (name) VALUES ('Santa Ana') ON DUPLICATE KEY UPDATE name=VALUES(name);
INSERT INTO departments (name) VALUES ('Sonsonate') ON DUPLICATE KEY UPDATE name=VALUES(name);
INSERT INTO departments (name) VALUES ('La Libertad') ON DUPLICATE KEY UPDATE name=VALUES(name);
INSERT INTO departments (name) VALUES ('San Salvador') ON DUPLICATE KEY UPDATE name=VALUES(name);
INSERT INTO departments (name) VALUES ('Cuscatlán') ON DUPLICATE KEY UPDATE name=VALUES(name);
INSERT INTO departments (name) VALUES ('La Paz') ON DUPLICATE KEY UPDATE name=VALUES(name);
INSERT INTO departments (name) VALUES ('Cabañas') ON DUPLICATE KEY UPDATE name=VALUES(name);
INSERT INTO departments (name) VALUES ('San Vicente') ON DUPLICATE KEY UPDATE name=VALUES(name);
INSERT INTO departments (name) VALUES ('Usulután') ON DUPLICATE KEY UPDATE name=VALUES(name);
INSERT INTO departments (name) VALUES ('San Miguel') ON DUPLICATE KEY UPDATE name=VALUES(name);
INSERT INTO departments (name) VALUES ('Morazán') ON DUPLICATE KEY UPDATE name=VALUES(name);
INSERT INTO departments (name) VALUES ('La Unión') ON DUPLICATE KEY UPDATE name=VALUES(name);
INSERT INTO departments (name) VALUES ('Chalatenango') ON DUPLICATE KEY UPDATE name=VALUES(name);

-- Carga de municipios (idempotente por (name, department_id))
INSERT INTO municipalities (name, department_id)
SELECT 'Ahuachapán', d.id
FROM departments d
WHERE d.name = 'Ahuachapán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Ahuachapán' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Apaneca', d.id
FROM departments d
WHERE d.name = 'Ahuachapán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Apaneca' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Atiquizaya', d.id
FROM departments d
WHERE d.name = 'Ahuachapán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Atiquizaya' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Concepción de Ataco', d.id
FROM departments d
WHERE d.name = 'Ahuachapán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Concepción de Ataco' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'El Refugio', d.id
FROM departments d
WHERE d.name = 'Ahuachapán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'El Refugio' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Guaymango', d.id
FROM departments d
WHERE d.name = 'Ahuachapán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Guaymango' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Jujutla', d.id
FROM departments d
WHERE d.name = 'Ahuachapán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Jujutla' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Francisco Menéndez', d.id
FROM departments d
WHERE d.name = 'Ahuachapán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Francisco Menéndez' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Lorenzo', d.id
FROM departments d
WHERE d.name = 'Ahuachapán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Lorenzo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Pedro Puxtla', d.id
FROM departments d
WHERE d.name = 'Ahuachapán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Pedro Puxtla' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Tacuba', d.id
FROM departments d
WHERE d.name = 'Ahuachapán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Tacuba' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Turín', d.id
FROM departments d
WHERE d.name = 'Ahuachapán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Turín' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Candelaria de la Frontera', d.id
FROM departments d
WHERE d.name = 'Santa Ana'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Candelaria de la Frontera' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Chalchuapa', d.id
FROM departments d
WHERE d.name = 'Santa Ana'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Chalchuapa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Coatepeque', d.id
FROM departments d
WHERE d.name = 'Santa Ana'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Coatepeque' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'El Congo', d.id
FROM departments d
WHERE d.name = 'Santa Ana'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'El Congo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'El Porvenir', d.id
FROM departments d
WHERE d.name = 'Santa Ana'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'El Porvenir' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Masahuat', d.id
FROM departments d
WHERE d.name = 'Santa Ana'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Masahuat' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Metapán', d.id
FROM departments d
WHERE d.name = 'Santa Ana'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Metapán' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Antonio Pajonal', d.id
FROM departments d
WHERE d.name = 'Santa Ana'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Antonio Pajonal' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Sebastián Salitrillo', d.id
FROM departments d
WHERE d.name = 'Santa Ana'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Sebastián Salitrillo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santa Ana', d.id
FROM departments d
WHERE d.name = 'Santa Ana'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santa Ana' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santa Rosa Guachipilín', d.id
FROM departments d
WHERE d.name = 'Santa Ana'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santa Rosa Guachipilín' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santiago de la Frontera', d.id
FROM departments d
WHERE d.name = 'Santa Ana'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santiago de la Frontera' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Texistepeque', d.id
FROM departments d
WHERE d.name = 'Santa Ana'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Texistepeque' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Acajutla', d.id
FROM departments d
WHERE d.name = 'Sonsonate'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Acajutla' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Armenia', d.id
FROM departments d
WHERE d.name = 'Sonsonate'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Armenia' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Caluco', d.id
FROM departments d
WHERE d.name = 'Sonsonate'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Caluco' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Cuisnahuat', d.id
FROM departments d
WHERE d.name = 'Sonsonate'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Cuisnahuat' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Izalco', d.id
FROM departments d
WHERE d.name = 'Sonsonate'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Izalco' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Juayúa', d.id
FROM departments d
WHERE d.name = 'Sonsonate'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Juayúa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Nahuizalco', d.id
FROM departments d
WHERE d.name = 'Sonsonate'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Nahuizalco' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Nahulingo', d.id
FROM departments d
WHERE d.name = 'Sonsonate'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Nahulingo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Salcoatitán', d.id
FROM departments d
WHERE d.name = 'Sonsonate'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Salcoatitán' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Antonio del Monte', d.id
FROM departments d
WHERE d.name = 'Sonsonate'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Antonio del Monte' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Julián', d.id
FROM departments d
WHERE d.name = 'Sonsonate'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Julián' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santa Catarina Masahuat', d.id
FROM departments d
WHERE d.name = 'Sonsonate'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santa Catarina Masahuat' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santo Domingo de Guzmán', d.id
FROM departments d
WHERE d.name = 'Sonsonate'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santo Domingo de Guzmán' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Sonsonate', d.id
FROM departments d
WHERE d.name = 'Sonsonate'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Sonsonate' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Sonzacate', d.id
FROM departments d
WHERE d.name = 'Sonsonate'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Sonzacate' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Antiguo Cuscatlán', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Antiguo Cuscatlán' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Chiltiupán', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Chiltiupán' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Ciudad Arce', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Ciudad Arce' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Colón', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Colón' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Comasagua', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Comasagua' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Huizúcar', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Huizúcar' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Jayaque', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Jayaque' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Jicalapa', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Jicalapa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'La Libertad', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'La Libertad' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Nuevo Cuscatlán', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Nuevo Cuscatlán' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Quezaltepeque', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Quezaltepeque' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Juan Opico', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Juan Opico' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San José Villanueva', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San José Villanueva' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Matías', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Matías' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Pablo Tacachico', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Pablo Tacachico' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santa Tecla', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santa Tecla' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Tamanique', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Tamanique' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Talnique', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Talnique' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Teotepeque', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Teotepeque' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Tepecoyo', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Tepecoyo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Zaragoza', d.id
FROM departments d
WHERE d.name = 'La Libertad'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Zaragoza' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Aguilares', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Aguilares' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Apopa', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Apopa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Ayutuxtepeque', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Ayutuxtepeque' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Cuscatancingo', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Cuscatancingo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Ciudad Delgado', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Ciudad Delgado' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'El Paisnal', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'El Paisnal' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Guazapa', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Guazapa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Ilopango', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Ilopango' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Mejicanos', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Mejicanos' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Nejapa', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Nejapa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Panchimalco', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Panchimalco' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Rosario de Mora', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Rosario de Mora' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Marcos', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Marcos' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Martín', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Martín' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Salvador', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Salvador' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santiago Texacuangos', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santiago Texacuangos' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santo Tomás', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santo Tomás' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Soyapango', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Soyapango' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Tonacatepeque', d.id
FROM departments d
WHERE d.name = 'San Salvador'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Tonacatepeque' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Candelaria', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Candelaria' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Cojutepeque', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Cojutepeque' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'El Carmen', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'El Carmen' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'El Rosario', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'El Rosario' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Monte San Juan', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Monte San Juan' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Oratorio de Concepción', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Oratorio de Concepción' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Bartolomé Perulapía', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Bartolomé Perulapía' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Cristóbal', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Cristóbal' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San José Guayabal', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San José Guayabal' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Pedro Perulapán', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Pedro Perulapán' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Rafael Cedros', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Rafael Cedros' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Ramón', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Ramón' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santa Cruz Analquito', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santa Cruz Analquito' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santa Cruz Michapa', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santa Cruz Michapa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Suchitoto', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Suchitoto' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Tenancingo', d.id
FROM departments d
WHERE d.name = 'Cuscatlán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Tenancingo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Cuyultitán', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Cuyultitán' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'El Rosario', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'El Rosario' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Jerusalén', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Jerusalén' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Mercedes La Ceiba', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Mercedes La Ceiba' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Olocuilta', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Olocuilta' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Paraíso de Osorio', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Paraíso de Osorio' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Antonio Masahuat', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Antonio Masahuat' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Emigdio', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Emigdio' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Francisco Chinameca', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Francisco Chinameca' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Juan Nonualco', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Juan Nonualco' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Juan Talpa', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Juan Talpa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Juan Tepezontes', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Juan Tepezontes' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Luis La Herradura', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Luis La Herradura' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Luis Talpa', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Luis Talpa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Miguel Tepezontes', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Miguel Tepezontes' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Pedro Masahuat', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Pedro Masahuat' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Pedro Nonualco', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Pedro Nonualco' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Rafael Obrajuelo', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Rafael Obrajuelo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santa María Ostuma', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santa María Ostuma' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santiago Nonualco', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santiago Nonualco' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Tapalhuaca', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Tapalhuaca' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Zacatecoluca', d.id
FROM departments d
WHERE d.name = 'La Paz'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Zacatecoluca' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Cinquera', d.id
FROM departments d
WHERE d.name = 'Cabañas'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Cinquera' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Dolores', d.id
FROM departments d
WHERE d.name = 'Cabañas'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Dolores' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Guacotecti', d.id
FROM departments d
WHERE d.name = 'Cabañas'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Guacotecti' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Ilobasco', d.id
FROM departments d
WHERE d.name = 'Cabañas'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Ilobasco' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Jutiapa', d.id
FROM departments d
WHERE d.name = 'Cabañas'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Jutiapa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Isidro', d.id
FROM departments d
WHERE d.name = 'Cabañas'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Isidro' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Sensuntepeque', d.id
FROM departments d
WHERE d.name = 'Cabañas'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Sensuntepeque' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Tejutepeque', d.id
FROM departments d
WHERE d.name = 'Cabañas'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Tejutepeque' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Victoria', d.id
FROM departments d
WHERE d.name = 'Cabañas'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Victoria' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Apastepeque', d.id
FROM departments d
WHERE d.name = 'San Vicente'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Apastepeque' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Guadalupe', d.id
FROM departments d
WHERE d.name = 'San Vicente'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Guadalupe' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Cayetano Istepeque', d.id
FROM departments d
WHERE d.name = 'San Vicente'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Cayetano Istepeque' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Esteban Catarina', d.id
FROM departments d
WHERE d.name = 'San Vicente'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Esteban Catarina' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Ildefonso', d.id
FROM departments d
WHERE d.name = 'San Vicente'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Ildefonso' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Lorenzo', d.id
FROM departments d
WHERE d.name = 'San Vicente'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Lorenzo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Sebastián', d.id
FROM departments d
WHERE d.name = 'San Vicente'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Sebastián' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Vicente', d.id
FROM departments d
WHERE d.name = 'San Vicente'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Vicente' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santa Clara', d.id
FROM departments d
WHERE d.name = 'San Vicente'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santa Clara' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santo Domingo', d.id
FROM departments d
WHERE d.name = 'San Vicente'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santo Domingo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Tecoluca', d.id
FROM departments d
WHERE d.name = 'San Vicente'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Tecoluca' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Tepetitán', d.id
FROM departments d
WHERE d.name = 'San Vicente'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Tepetitán' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Verapaz', d.id
FROM departments d
WHERE d.name = 'San Vicente'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Verapaz' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Alegría', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Alegría' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Berlín', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Berlín' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'California', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'California' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Concepción Batres', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Concepción Batres' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'El Triunfo', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'El Triunfo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Ereguayquín', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Ereguayquín' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Estanzuelas', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Estanzuelas' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Jiquilisco', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Jiquilisco' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Jucuapa', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Jucuapa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Jucuarán', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Jucuarán' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Mercedes Umaña', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Mercedes Umaña' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Nueva Granada', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Nueva Granada' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Ozatlán', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Ozatlán' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Puerto El Triunfo', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Puerto El Triunfo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Agustín', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Agustín' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Buenaventura', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Buenaventura' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Dionisio', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Dionisio' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Francisco Javier', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Francisco Javier' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santa Elena', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santa Elena' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santa María', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santa María' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santiago de María', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santiago de María' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Tecapán', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Tecapán' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Usulután', d.id
FROM departments d
WHERE d.name = 'Usulután'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Usulután' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Carolina', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Carolina' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Chapeltique', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Chapeltique' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Chinameca', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Chinameca' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Chirilagua', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Chirilagua' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Ciudad Barrios', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Ciudad Barrios' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Comacarán', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Comacarán' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'El Tránsito', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'El Tránsito' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Lolotique', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Lolotique' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Moncagua', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Moncagua' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Nueva Guadalupe', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Nueva Guadalupe' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Nuevo Edén de San Juan', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Nuevo Edén de San Juan' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Quelepa', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Quelepa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Antonio del Mosco', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Antonio del Mosco' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Gerardo', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Gerardo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Jorge', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Jorge' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Luis de la Reina', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Luis de la Reina' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Miguel', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Miguel' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Rafael Oriente', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Rafael Oriente' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Sesori', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Sesori' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Uluazapa', d.id
FROM departments d
WHERE d.name = 'San Miguel'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Uluazapa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Arambala', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Arambala' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Cacaopera', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Cacaopera' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Chilanga', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Chilanga' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Corinto', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Corinto' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Delicias de Concepción', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Delicias de Concepción' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'El Divisadero', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'El Divisadero' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'El Rosario', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'El Rosario' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Gualococti', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Gualococti' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Guatajiagua', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Guatajiagua' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Joateca', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Joateca' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Jocoaitique', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Jocoaitique' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Jocoro', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Jocoro' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Lolotiquillo', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Lolotiquillo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Meanguera', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Meanguera' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Osicala', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Osicala' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Perquín', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Perquín' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Carlos', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Carlos' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Fernando', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Fernando' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Francisco Gotera', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Francisco Gotera' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Isidro', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Isidro' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Simón', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Simón' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Sensembra', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Sensembra' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Sociedad', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Sociedad' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Torola', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Torola' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Yamabal', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Yamabal' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Yoloaiquín', d.id
FROM departments d
WHERE d.name = 'Morazán'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Yoloaiquín' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Anamorós', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Anamorós' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Bolívar', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Bolívar' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Concepción de Oriente', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Concepción de Oriente' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Conchagua', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Conchagua' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'El Carmen', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'El Carmen' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'El Sauce', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'El Sauce' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Intipucá', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Intipucá' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'La Unión', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'La Unión' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Lislique', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Lislique' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Meanguera del Golfo', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Meanguera del Golfo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Nueva Esparta', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Nueva Esparta' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Pasaquina', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Pasaquina' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Polorós', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Polorós' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Alejo', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Alejo' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San José', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San José' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santa Rosa de Lima', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santa Rosa de Lima' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Yayantique', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Yayantique' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Yucuaiquín', d.id
FROM departments d
WHERE d.name = 'La Unión'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Yucuaiquín' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Agua Caliente', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Agua Caliente' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Arcatao', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Arcatao' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Azacualpa', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Azacualpa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Chalatenango', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Chalatenango' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Citalá', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Citalá' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Comalapa', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Comalapa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Concepción Quezaltepeque', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Concepción Quezaltepeque' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Dulce Nombre de María', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Dulce Nombre de María' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'El Carrizal', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'El Carrizal' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'El Paraíso', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'El Paraíso' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'La Laguna', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'La Laguna' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'La Palma', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'La Palma' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'La Reina', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'La Reina' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Las Vueltas', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Las Vueltas' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Nombre de Jesús', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Nombre de Jesús' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Nueva Concepción', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Nueva Concepción' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Nueva Trinidad', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Nueva Trinidad' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Ojos de Agua', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Ojos de Agua' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Potonico', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Potonico' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Antonio de la Cruz', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Antonio de la Cruz' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Antonio Los Ranchos', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Antonio Los Ranchos' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Fernando', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Fernando' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Francisco Lempa', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Francisco Lempa' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Francisco Morazán', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Francisco Morazán' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Ignacio', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Ignacio' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Isidro Labrador', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Isidro Labrador' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San José Cancasque', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San José Cancasque' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San José Las Flores', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San José Las Flores' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Luis del Carmen', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Luis del Carmen' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Miguel de Mercedes', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Miguel de Mercedes' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'San Rafael', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'San Rafael' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Santa Rita', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Santa Rita' AND mm.department_id = d.id
  );
INSERT INTO municipalities (name, department_id)
SELECT 'Tejutla', d.id
FROM departments d
WHERE d.name = 'Chalatenango'
  AND NOT EXISTS (
      SELECT 1 FROM municipalities mm 
      WHERE mm.name = 'Tejutla' AND mm.department_id = d.id
  );
-- Fuentes de datos
INSERT INTO data_sources (code, description, contact_url)
VALUES ('IQAIR', 'IQAir Public API', 'https://www.iqair.com/')
ON DUPLICATE KEY UPDATE description=VALUES(description), contact_url=VALUES(contact_url);
-- Estaciones de ejemplo (idempotentes por nombre + municipio)
INSERT INTO stations (name, municipality_id, latitude, longitude, active, data_source_id)
SELECT 'Estación Centro SS', m.id, 13.698, -89.191, true, ds.id
FROM municipalities m
JOIN departments d ON d.id = m.department_id AND d.name = 'San Salvador'
JOIN data_sources ds ON ds.code = 'IQAIR'
WHERE m.name = 'San Salvador'
  AND NOT EXISTS (
    SELECT 1 FROM stations s WHERE s.name='Estación Centro SS' AND s.municipality_id=m.id
  );

INSERT INTO stations (name, municipality_id, latitude, longitude, active, data_source_id)
SELECT 'Estación Santa Tecla', m.id, 13.676, -89.279, true, ds.id
FROM municipalities m
JOIN departments d ON d.id = m.department_id AND d.name = 'La Libertad'
JOIN data_sources ds ON ds.code = 'IQAIR'
WHERE m.name = 'Santa Tecla'
  AND NOT EXISTS (
    SELECT 1 FROM stations s WHERE s.name='Estación Santa Tecla' AND s.municipality_id=m.id
  );