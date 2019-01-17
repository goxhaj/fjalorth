INSERT INTO `role` VALUES (1,'USER');
INSERT INTO `role` VALUES (2,'ADMIN');
INSERT INTO `user` VALUES (1, 1, 'user@test.com', 'firstname', 'lastname', '$2a$10$6dFI6mXxUr49/rG4.dai1.EYIoruqAbjJg30vFOBEkMkbllx0UchK', 'user');
INSERT INTO `user` VALUES (2, 1, 'admin@test.com', 'firstname', 'lastname', '$2a$10$6dFI6mXxUr49/rG4.dai1.EYIoruqAbjJg30vFOBEkMkbllx0UchK', 'admin');
INSERT INTO `user_role` VALUES (1,1);
INSERT INTO `user_role` VALUES (2,2);