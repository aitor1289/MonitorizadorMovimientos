-- Generado por Oracle SQL Developer Data Modeler 4.2.0.932
--   en:        2017-04-30 21:48:30 CEST
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c



CREATE TABLE registro_movimientos (
    id_reg_mov         INTEGER NOT NULL,
    x                  NUMBER(6,3) NOT NULL,
    y                  NUMBER(6,3) NOT NULL,
    z                  NUMBER(6,3) NOT NULL,
    id_tipo_mov        INTEGER NOT NULL,
    usuarios_id_user   INTEGER NOT NULL
);

ALTER TABLE registro_movimientos ADD CONSTRAINT registro_movimientos_pk PRIMARY KEY ( id_reg_mov );

CREATE TABLE roles (
    id_rol        INTEGER NOT NULL,
    type          VARCHAR2(16) NOT NULL,
    description   VARCHAR2(20)
);

ALTER TABLE roles ADD CONSTRAINT roles_pk PRIMARY KEY ( id_rol );

CREATE TABLE tipo_movimientos (
    id_tipo_mov   INTEGER NOT NULL,
    type          VARCHAR2(16) NOT NULL,
    description   VARCHAR2(20)
);

ALTER TABLE tipo_movimientos ADD CONSTRAINT tipo_movimientos_pk PRIMARY KEY ( id_tipo_mov );

CREATE TABLE usuarios (
    id_user        INTEGER NOT NULL,
    username       VARCHAR2(50) NOT NULL,
    password       VARCHAR2(50) NOT NULL,
    name           VARCHAR2(50),
    surename1      VARCHAR2(50),
    surename2      VARCHAR2(50),
    phone          VARCHAR2(50),
    mail           VARCHAR2(50),
    roles_id_rol   INTEGER NOT NULL
);

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( id_user );

ALTER TABLE registro_movimientos ADD CONSTRAINT reg_mov_tipo_mov_fk FOREIGN KEY ( id_tipo_mov )
    REFERENCES tipo_movimientos ( id_tipo_mov )
NOT DEFERRABLE;

ALTER TABLE registro_movimientos ADD CONSTRAINT reg_mov_usuarios_fk FOREIGN KEY ( usuarios_id_user )
    REFERENCES usuarios ( id_user )
NOT DEFERRABLE;

ALTER TABLE usuarios ADD CONSTRAINT usuarios_roles_fk FOREIGN KEY ( roles_id_rol )
    REFERENCES roles ( id_rol )
NOT DEFERRABLE;



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             4
-- CREATE INDEX                             0
-- ALTER TABLE                              7
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
