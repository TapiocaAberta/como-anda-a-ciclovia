-- INSERT STATUS --
INSERT INTO Status (id, name, pin_name, description) VALUES (1, 'Ciclovia não esta bem (problemas de infra-estrurura)', 'pin-01.png', '');
INSERT INTO Status (id, name, pin_name, description) VALUES (2, 'Tem reforma sendo feita (manutenção)', 'pin-02.png', '');
INSERT INTO Status (id, name, pin_name, description) VALUES (3, 'Trecho perigoso (perigo de acidentes ou falta de segurança)', 'pin-02.png', '');

-- INSERT TYPE --
INSERT INTO OccurrenceType (ID, NAME) VALUES (1, 'Não tem pintura no solo');
INSERT INTO OccurrenceType (ID, NAME) VALUES (2, 'Há desgaste na pintura do solo');
INSERT INTO OccurrenceType (ID, NAME) VALUES (3, 'Faltam placas educativas ou alertas de segurança');
INSERT INTO OccurrenceType (ID, NAME) VALUES (4, 'Buracos');
INSERT INTO OccurrenceType (ID, NAME) VALUES (5, 'Piso está desnivelado ou com ondulação');
INSERT INTO OccurrenceType (ID, NAME) VALUES (6, 'Bloquete/Tachão solto');
INSERT INTO OccurrenceType (ID, NAME) VALUES (7, 'Tachão distante entre um e outro');
INSERT INTO OccurrenceType (ID, NAME) VALUES (8, 'Trecho sem iluminação com falta de iluminação');
INSERT INTO OccurrenceType (ID, NAME) VALUES (9, 'Tem mato crescendo');
INSERT INTO OccurrenceType (ID, NAME) VALUES (10, 'Espaço é muito limitado');
INSERT INTO OccurrenceType (ID, NAME) VALUES (99, 'Sem Categoria');

--INSERT INTO SysUser(ID, NAME, PASSWORD, ROLE) VALUES (1, 'Penny', 'password', 'admin')