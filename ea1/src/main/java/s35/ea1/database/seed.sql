
INSERT INTO Funcionarios (tipo_identificacion, numero_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento) 
VALUES 
('Cédula', '123456789', 'Juan', 'Pérez', 'Soltero', 'Masculino', 'Calle 123, Ciudad', '123-456-7890', '1990-01-15'),
('Pasaporte', 'AB123456', 'María', 'Gómez', 'Casado', 'Femenino', 'Avenida 456, Pueblo', '987-654-3210', '1988-05-20');

INSERT INTO GrupoFamiliar (funcionario_id, miembro_nombre, miembro_apellido, miembro_rol)
VALUES 
(1, 'Ana', 'Pérez', 'Hija'),
(1, 'Carlos', 'Pérez', 'Hijo'),
(2, 'Luis', 'Gómez', 'Hijo');

INSERT INTO InformacionAcademica (funcionario_id, universidad, nivel_estudio, titulo_estudio)
VALUES 
(1, 'Universidad A', 'Licenciatura', 'Licenciatura en Informática'),
(2, 'Universidad B', 'Maestría', 'Maestría en Administración de Empresas');
