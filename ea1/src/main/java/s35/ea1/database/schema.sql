
CREATE TABLE Funcionarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo_identificacion VARCHAR(20),
    numero_identificacion VARCHAR(20) UNIQUE,
    nombres VARCHAR(100),
    apellidos VARCHAR(100),
    estado_civil VARCHAR(20),
    sexo VARCHAR(10),
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    fecha_nacimiento DATE
);

CREATE TABLE GrupoFamiliar (
    id INT PRIMARY KEY AUTO_INCREMENT,
    funcionario_id INT,
    miembro_nombre VARCHAR(100),
    miembro_apellido VARCHAR(100),
    miembro_rol VARCHAR(50),
    FOREIGN KEY (funcionario_id) REFERENCES Funcionarios(id) ON DELETE CASCADE
);

CREATE TABLE InformacionAcademica (
    id INT PRIMARY KEY AUTO_INCREMENT,
    funcionario_id INT,
    universidad VARCHAR(100),
    nivel_estudio VARCHAR(50),
    titulo_estudio VARCHAR(100),
    FOREIGN KEY (funcionario_id) REFERENCES Funcionarios(id) ON DELETE CASCADE
);
