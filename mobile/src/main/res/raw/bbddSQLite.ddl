-- Generado por Oracle SQL Developer Data Modeler 4.1.3.901
--   en:        2017-02-08 14:06:28 CET
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE
  TABLE REGISTRO_MOVIMIENTOS
  (
    ID_REG_MOV                   NUMBER (8) NOT NULL ,
    X                            NUMBER (6,3) NOT NULL ,
    Y                            NUMBER (6,3) NOT NULL ,
    Z                            NUMBER (6,3) NOT NULL ,
    TIPO_MOVIMIENTOS_ID_TIPO_MOV NUMBER (8) NOT NULL ,
    USUARIOS_ID_USER             NUMBER (8) NOT NULL ,
    ID_TIPO_MOV_DETECT           NUMBER (8)
  ) ;
ALTER TABLE REGISTRO_MOVIMIENTOS ADD CONSTRAINT REGISTRO_MOVIMIENTOS_PK PRIMARY
KEY ( ID_REG_MOV ) ;


CREATE
  TABLE ROLES
  (
    ID_ROL      NUMBER (8) NOT NULL ,
    TYPE        VARCHAR2 (16) NOT NULL ,
    DESCRIPTION VARCHAR2 (20)
  ) ;
ALTER TABLE ROLES ADD CONSTRAINT ROLES_PK PRIMARY KEY ( ID_ROL ) ;


CREATE
  TABLE TIPO_MOVIMIENTOS
  (
    ID_TIPO_MOV NUMBER (8) NOT NULL ,
    TYPE        VARCHAR2 (16) NOT NULL ,
    DESCRIPTION VARCHAR2 (20)
  ) ;
ALTER TABLE TIPO_MOVIMIENTOS ADD CONSTRAINT TIPO_MOVIMIENTOS_PK PRIMARY KEY (
ID_TIPO_MOV ) ;


CREATE
  TABLE USUARIOS
  (
    ID_USER      NUMBER (8) NOT NULL ,
    USERNAME     VARCHAR2 (50) NOT NULL ,
    PASSWORD     VARCHAR2 (50) NOT NULL ,
    NAME         VARCHAR2 (50) ,
    SURENAME1    VARCHAR2 (50) ,
    SURENAME2    VARCHAR2 (50) ,
    PHONE        VARCHAR2 (50) ,
    MAIL         VARCHAR2 (50) ,
    ROLES_ID_ROL NUMBER (8) NOT NULL
  ) ;
ALTER TABLE USUARIOS ADD CONSTRAINT USUARIOS_PK PRIMARY KEY ( ID_USER ) ;


ALTER TABLE REGISTRO_MOVIMIENTOS ADD CONSTRAINT REG_MOV_TIPO_MOV_FK FOREIGN KEY
( TIPO_MOVIMIENTOS_ID_TIPO_MOV ) REFERENCES TIPO_MOVIMIENTOS ( ID_TIPO_MOV ) ;

ALTER TABLE REGISTRO_MOVIMIENTOS ADD CONSTRAINT REG_MOV_USUARIOS_FK FOREIGN KEY
( USUARIOS_ID_USER ) REFERENCES USUARIOS ( ID_USER ) ;

ALTER TABLE USUARIOS ADD CONSTRAINT USUARIOS_ROLES_FK FOREIGN KEY (
ROLES_ID_ROL ) REFERENCES ROLES ( ID_ROL ) ;


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
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
