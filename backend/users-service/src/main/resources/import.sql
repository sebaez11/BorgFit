INSERT INTO `roles` (name) VALUES('ROLE_CUSTOMER');
INSERT INTO `roles` (name) VALUES('ROLE_COACH');
INSERT INTO `roles` (name) VALUES('ROLE_ADMINISTRATIVE');

INSERT INTO `users` (identification_number ,role_id , names , last_names, email, password , address , phone_number , photo , active) VALUES('1122652095' , 1 , 'pepito' , 'Baez' , 'pepito@gmail.com' , '$2a$10$QPthkje.nWZhj7gde7ODw.SnlP4CJFlvhyCPshteeuU/u5Yj67y7S' , 'muy muy lejano' , '31232141123' , 'hola.png'  , 1);
INSERT INTO `users` (identification_number ,role_id , names , last_names, email, password , address , phone_number , photo , active) VALUES('1122122653' , 1 , 'pulgarito' , 'Baez' , 'pulgarito@gmail.com' , '$2a$10$u8z2A0fUXUO/pxO46ZAjOOkKA0Q8VZ6oeX.8Fqez7t6CVHd3CU10.' , 'muy muy lejano' , '31232141123' , 'hola.png'  , 1);
INSERT INTO `users` (identification_number ,role_id , coach_id , names , last_names, email, password , address , phone_number , photo , active) VALUES('1122122654' , 1 , '1122652095' , 'pulgarito2' , 'Baez' , 'pulgarito2@gmail.com' , '$2a$10$u8z2A0fUXUO/pxO46ZAjOOkKA0Q8VZ6oeX.8Fqez7t6CVHd3CU10.' , 'muy muy lejano' , '31232141123' , 'hola.png'  , 1);
