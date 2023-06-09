INSERT INTO roles(id, name)
VALUES (1, "ROLE_ADMIN"),
       (2, "ROLE_VISITOR");
INSERT INTO users(id, username, email, password)
VALUES (1, 'admin', 'admin@tm.example.fr', 'admin'),
       (2, 'visitor', 'visitor@tm.example.fr', 'visitor');
INSERT INTO user_roles(user_id,role_id)
VALUES (1,1),
       (2,2);
INSERT INTO tournament(id, type, name, description, state, date)
VALUES (1, "Double élimination", "LPL Spring 2023", "A crazy League of Legends tournament", "PLANNED", "2023-01-01"),
       (2, "Élimination directe", "RSUT", "A Rainbow 6: Siege Tournament", "ENDED", "2018-05-01"),
       (3, "Suisse", "Tournament 1", "An ok tournament", "ENDED", "2022-12-1"),
       (4, "Round Robin", "Tournament 2", "An ok tournament", "INPROGRESS", "2023-01-01"),
       (5, "Élimination direct avec tête de série", "An ok tournament", "Tournament 3", "PLANNED", "2023-04-15"),
       (6, "Double élimination", "Tournament 4", "An ok tournament", "INPROGRESS", "2022-12-25");
INSERT INTO team(id, name)
VALUES (1, "Les alpha dogs"),
       (2, "Guns and Brothers"),
       (3, "Dummy Team 1"),
       (4, "Dummy Team 2"),
       (5, "Dummy Team 3"),
       (6, "Dummy Team 4"),
       (7, "Dummy Team 5"),
       (8, "Dummy Team 6"),
       (9, "Dummy Team 7"),
       (10, "Dummy Team 8"),
       (11, "Dummy Team 9"),
       (12, "Dummy Team 10"),
       (13, "Dummy Team 11"),
       (14, "Dummy Team 12"),
       (15, "Dummy Team 13"),
       (16, "Dummy Team 14"),
       (17, "Dummy Team 15"),
       (18, "Dummy Team 16"),
       (19, "Dummy Team 17"),
       (20, "Dummy Team 18"),
       (21, "Dummy Team 19"),
       (22, "Dummy Team 20"),
       (23, "Dummy Team 21"),
       (24, "Dummy Team 22"),
       (25, "Dummy Team 23"),
       (26, "Dummy Team 24"),
       (27, "Dummy Team 25"),
       (28, "Dummy Team 26"),
       (29, "Dummy Team 27"),
       (30, "Dummy Team 28"),
       (31, "Dummy Team 29"),
       (32, "Dummy Team 30"),
       (33, "Dummy Team 31"),
       (34, "Dummy Team 32"),
       (35, "Dummy Team 33"),
       (36, "Dummy Team 34")
;
INSERT INTO player(id, name, address)
VALUES
    -- 1
    (1, "Mag", "2 impasse de la toxicité"),
    (2, "Alpha Dog 1", "2 impasse de la toxicité"),
    (3, "Alpha Dog 2", "2 impasse de la toxicité"),
    (4, "Alpha Dog 3", "2 impasse de la toxicité"),
    (5, "Alpha Dog 4", "2 impasse de la toxicité"),
    -- 2
    (6, "Friday", "3 rue des noobs"),
    (7, "Reyvokk", "3 rue des noobs"),
    (8, "Pipoon", "3 rue des noobs"),
    (9, "Valarkook", "3 rue des noobs"),
    (10, "DemonPizza", "3 rue des noobs"),
    -- 3
    (11, "Dummy 1", "Dummy address"),
    (12, "Dummy 2", "Dummy address"),
    (13, "Dummy 3", "Dummy address"),
    (14, "Dummy 4", "Dummy address"),
    (15, "Dummy 5", "Dummy address"),
    -- 4
    (16, "Dummy 6", "Dummy address"),
    (17, "Dummy 7", "Dummy address"),
    (18, "Dummy 8", "Dummy address"),
    (19, "Dummy 9", "Dummy address"),
    (20, "Dummy 10", "Dummy address"),
    -- 5
    (21, "Dummy 11", "Dummy address"),
    (22, "Dummy 12", "Dummy address"),
    (23, "Dummy 13", "Dummy address"),
    (24, "Dummy 14", "Dummy address"),
    (25, "Dummy 15", "Dummy address"),
    -- 6
    (26, "Dummy 16", "Dummy address"),
    (27, "Dummy 17", "Dummy address"),
    (28, "Dummy 18", "Dummy address"),
    (29, "Dummy 19", "Dummy address"),
    (30, "Dummy 20", "Dummy address"),
    -- 7
    (31, "Dummy 21", "Dummy address"),
    (32, "Dummy 22", "Dummy address"),
    (33, "Dummy 23", "Dummy address"),
    (34, "Dummy 24", "Dummy address"),
    (35, "Dummy 25", "Dummy address"),
    -- 8
    (36, "Dummy 26", "Dummy address"),
    (37, "Dummy 27", "Dummy address"),
    (38, "Dummy 28", "Dummy address"),
    (39, "Dummy 29", "Dummy address"),
    (40, "Dummy 30", "Dummy address"),
    -- 9
    (41, "Dummy 31", "Dummy address"),
    (42, "Dummy 32", "Dummy address"),
    (43, "Dummy 33", "Dummy address"),
    (44, "Dummy 34", "Dummy address"),
    (45, "Dummy 35", "Dummy address"),
    -- 10
    (46, "Dummy 36", "Dummy address"),
    (47, "Dummy 37", "Dummy address"),
    (48, "Dummy 38", "Dummy address"),
    (49, "Dummy 39", "Dummy address"),
    (50, "Dummy 40", "Dummy address"),
    -- 11
    (51, "Dummy 41", "Dummy address"),
    (52, "Dummy 42", "Dummy address"),
    (53, "Dummy 43", "Dummy address"),
    (54, "Dummy 44", "Dummy address"),
    (55, "Dummy 45", "Dummy address"),
    -- 12
    (56, "Dummy 46", "Dummy address"),
    (57, "Dummy 47", "Dummy address"),
    (58, "Dummy 48", "Dummy address"),
    (59, "Dummy 49", "Dummy address"),
    (60, "Dummy 50", "Dummy address"),
    -- 13
    (61, "Dummy 51", "Dummy address"),
    (62, "Dummy 52", "Dummy address"),
    (63, "Dummy 53", "Dummy address"),
    (64, "Dummy 54", "Dummy address"),
    (65, "Dummy 55", "Dummy address"),
    -- 14
    (66, "Dummy 56", "Dummy address"),
    (67, "Dummy 57", "Dummy address"),
    (68, "Dummy 59", "Dummy address"),
    (69, "Dummy 60", "Dummy address"),
    (70, "Dummy 61", "Dummy address"),
    -- 15
    (71, "Dummy 62", "Dummy address"),
    (72, "Dummy 63", "Dummy address"),
    (73, "Dummy 64", "Dummy address"),
    (74, "Dummy 65", "Dummy address"),
    (75, "Dummy 66", "Dummy address"),
    -- 16
    (76, "Dummy 67", "Dummy address"),
    (77, "Dummy 68", "Dummy address"),
    (78, "Dummy 69", "Dummy address"),
    (79, "Dummy 70", "Dummy address"),
    (80, "Dummy 71", "Dummy address"),
    -- 17
    (81, "Dummy 72", "Dummy address"),
    (82, "Dummy 73", "Dummy address"),
    (83, "Dummy 74", "Dummy address"),
    (84, "Dummy 75", "Dummy address"),
    (85, "Dummy 76", "Dummy address"),
    -- 18
    (86, "Dummy 77", "Dummy address"),
    (87, "Dummy 78", "Dummy address"),
    (88, "Dummy 79", "Dummy address"),
    (89, "Dummy 80", "Dummy address"),
    (90, "Dummy 81", "Dummy address"),
    -- 19
    (91, "Dummy 82", "Dummy address"),
    (92, "Dummy 83", "Dummy address"),
    (93, "Dummy 84", "Dummy address"),
    (94, "Dummy 85", "Dummy address"),
    (95, "Dummy 86", "Dummy address"),
    -- 20
    (96, "Dummy 87", "Dummy address"),
    (97, "Dummy 88", "Dummy address"),
    (98, "Dummy 89", "Dummy address"),
    (99, "Dummy 90", "Dummy address"),
    (100, "Dummy 91", "Dummy address"),
    -- 21
    (101, "Dummy 92", "Dummy address"),
    (102, "Dummy 93", "Dummy address"),
    (103, "Dummy 94", "Dummy address"),
    (104, "Dummy 95", "Dummy address"),
    (105, "Dummy 96", "Dummy address"),
    -- 22
    (106, "Dummy 97", "Dummy address"),
    (107, "Dummy 98", "Dummy address"),
    (108, "Dummy 99", "Dummy address"),
    (109, "Dummy 100", "Dummy address"),
    (110, "Dummy 101", "Dummy address"),
    -- 23
    (111, "Dummy 102", "Dummy address"),
    (112, "Dummy 103", "Dummy address"),
    (113, "Dummy 104", "Dummy address"),
    (114, "Dummy 105", "Dummy address"),
    (115, "Dummy 106", "Dummy address"),
    -- 24
    (116, "Dummy 107", "Dummy address"),
    (117, "Dummy 108", "Dummy address"),
    (118, "Dummy 109", "Dummy address"),
    (119, "Dummy 110", "Dummy address"),
    (120, "Dummy 111", "Dummy address"),
    -- 25
    (121, "Dummy 112", "Dummy address"),
    (122, "Dummy 113", "Dummy address"),
    (123, "Dummy 114", "Dummy address"),
    (124, "Dummy 115", "Dummy address"),
    (125, "Dummy 116", "Dummy address"),
    -- 26
    (126, "Dummy 117", "Dummy address"),
    (127, "Dummy 118", "Dummy address"),
    (128, "Dummy 119", "Dummy address"),
    (129, "Dummy 120", "Dummy address"),
    (130, "Dummy 121", "Dummy address"),
    -- 27
    (131, "Dummy 122", "Dummy address"),
    (132, "Dummy 123", "Dummy address"),
    (133, "Dummy 124", "Dummy address"),
    (134, "Dummy 125", "Dummy address"),
    (135, "Dummy 126", "Dummy address"),
    -- 28
    (136, "Dummy 127", "Dummy address"),
    (137, "Dummy 128", "Dummy address"),
    (138, "Dummy 129", "Dummy address"),
    (139, "Dummy 130", "Dummy address"),
    (140, "Dummy 131", "Dummy address"),
    -- 29
    (141, "Dummy 132", "Dummy address"),
    (142, "Dummy 133", "Dummy address"),
    (143, "Dummy 134", "Dummy address"),
    (144, "Dummy 135", "Dummy address"),
    (145, "Dummy 136", "Dummy address"),
    -- 30
    (146, "Dummy 137", "Dummy address"),
    (147, "Dummy 138", "Dummy address"),
    (148, "Dummy 139", "Dummy address"),
    (149, "Dummy 140", "Dummy address"),
    (150, "Dummy 141", "Dummy address"),
    -- 31
    (151, "Dummy 142", "Dummy address"),
    (152, "Dummy 143", "Dummy address"),
    (153, "Dummy 144", "Dummy address"),
    (154, "Dummy 145", "Dummy address"),
    (155, "Dummy 146", "Dummy address"),
    -- 32
    (156, "Dummy 147", "Dummy address"),
    (157, "Dummy 148", "Dummy address"),
    (158, "Dummy 149", "Dummy address"),
    (159, "Dummy 150", "Dummy address"),
    (160, "Dummy 151", "Dummy address"),
    -- 33
    (161, "Dummy 152", "Dummy address"),
    (162, "Dummy 153", "Dummy address"),
    (163, "Dummy 154", "Dummy address"),
    (164, "Dummy 155", "Dummy address"),
    (165, "Dummy 156", "Dummy address"),
    -- 34
    (166, "Dummy 157", "Dummy address"),
    (167, "Dummy 158", "Dummy address"),
    (168, "Dummy 159", "Dummy address"),
    (169, "Dummy 160", "Dummy address"),
    (170, "Dummy 161", "Dummy address"),
    -- 35
    (171, "Dummy 162", "Dummy address"),
    (172, "Dummy 163", "Dummy address"),
    (173, "Dummy 164", "Dummy address"),
    (174, "Dummy 165", "Dummy address"),
    (175, "Dummy 166", "Dummy address"),
    -- 36
    (176, "Dummy 167", "Dummy address"),
    (177, "Dummy 168", "Dummy address"),
    (178, "Dummy 169", "Dummy address"),
    (179, "Dummy 170", "Dummy address"),
    (180, "Dummy 171", "Dummy address")
;
INSERT INTO team_players(teams_id, players_id)
VALUES
    -- 1
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 5),
    -- 2
    (2, 6),
    (2, 7),
    (2, 8),
    (2, 9),
    (2, 10),
    -- 3
    (3, 11),
    (3, 12),
    (3, 13),
    (3, 14),
    (3, 15),
    -- 4
    (4, 16),
    (4, 17),
    (4, 18),
    (4, 19),
    (4, 20),
    -- 5
    (5, 21),
    (5, 22),
    (5, 23),
    (5, 24),
    (5, 25),
    -- 6
    (6, 26),
    (6, 27),
    (6, 28),
    (6, 29),
    (6, 30),
    -- 7
    (7, 31),
    (7, 32),
    (7, 33),
    (7, 34),
    (7, 35),
    -- 8
    (8, 36),
    (8, 37),
    (8, 38),
    (8, 39),
    (8, 40),
    -- 9
    (9, 41),
    (9, 42),
    (9, 43),
    (9, 44),
    (9, 45),
    -- 10
    (10, 46),
    (10, 47),
    (10, 48),
    (10, 49),
    (10, 50),
    -- 11
    (11, 51),
    (11, 52),
    (11, 53),
    (11, 54),
    (11, 55),
    -- 12
    (12, 56),
    (12, 57),
    (12, 58),
    (12, 59),
    (12, 60),
    -- 13
    (13, 61),
    (13, 62),
    (13, 63),
    (13, 64),
    (13, 65),
    -- 14
    (14, 66),
    (14, 67),
    (14, 68),
    (14, 69),
    (14, 70),
    -- 15
    (15, 71),
    (15, 72),
    (15, 73),
    (15, 74),
    (15, 75),
    -- 16
    (16, 76),
    (16, 77),
    (16, 78),
    (16, 79),
    (16, 80),
    -- 17
    (17, 81),
    (17, 82),
    (17, 83),
    (17, 84),
    (17, 85),
    -- 18
    (18, 86),
    (18, 87),
    (18, 88),
    (18, 89),
    (18, 90),
    -- 19
    (19, 91),
    (19, 92),
    (19, 93),
    (19, 94),
    (19, 95),
    -- 20
    (20, 96),
    (20, 97),
    (20, 98),
    (20, 99),
    (20, 100),
    -- 21
    (21, 101),
    (21, 102),
    (21, 103),
    (21, 104),
    (21, 105),
    -- 22
    (22, 106),
    (22, 107),
    (22, 108),
    (22, 109),
    (22, 110),
    -- 23
    (23, 111),
    (23, 112),
    (23, 113),
    (23, 114),
    (23, 115),
    -- 24
    (24, 116),
    (24, 117),
    (24, 118),
    (24, 119),
    (24, 120),
    -- 25
    (25, 121),
    (25, 122),
    (25, 123),
    (25, 124),
    (25, 125),
    -- 26
    (26, 126),
    (26, 127),
    (26, 128),
    (26, 129),
    (26, 130),
    -- 27
    (27, 131),
    (27, 132),
    (27, 133),
    (27, 134),
    (27, 135),
    -- 28
    (28, 136),
    (28, 137),
    (28, 138),
    (28, 139),
    (28, 140),
    -- 29
    (29, 141),
    (29, 142),
    (29, 143),
    (29, 144),
    (29, 145),
    -- 30
    (30, 146),
    (30, 147),
    (30, 148),
    (30, 149),
    (30, 150),
    -- 31
    (31, 151),
    (31, 152),
    (31, 153),
    (31, 154),
    (31, 155),
    -- 32
    (32, 156),
    (32, 157),
    (32, 158),
    (32, 159),
    (32, 160),
    -- 33
    (33, 161),
    (33, 162),
    (33, 163),
    (33, 164),
    (33, 165),
    -- 34
    (34, 166),
    (34, 167),
    (34, 168),
    (34, 169),
    (34, 170),
    -- 35
    (35, 171),
    (35, 172),
    (35, 173),
    (35, 174),
    (35, 175),
    -- 36
    (36, 176),
    (36, 177),
    (36, 178),
    (36, 179),
    (36, 180)
;
INSERT INTO team_tournaments(teams_id, tournaments_id)
VALUES
    -- 1
    (1, 1),
    (3, 1),
    (4, 1),
    (5, 1),
    (6, 1),
    (7, 1),
    -- 2
    (2, 2),
    (8, 2),
    (9, 2),
    (10, 2),
    (11, 2),
    (12, 2),
    -- 3
    (13, 3),
    (14, 3),
    (15, 3),
    (16, 3),
    (17, 3),
    (18, 3),
    -- 4
    (19, 4),
    (20, 4),
    (21, 4),
    (22, 4),
    (23, 4),
    (24, 4),
    -- 5
    (25, 5),
    (26, 5),
    (27, 5),
    (28, 5),
    (29, 5),
    (30, 5),
    -- 6
    (31, 6),
    (32, 6),
    (33, 6),
    (34, 6),
    (35, 6),
    (36, 6)
;
