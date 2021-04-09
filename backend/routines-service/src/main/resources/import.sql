INSERT INTO `muscle_areas`(name) VALUES('pectoral')
INSERT INTO `muscle_areas`(name) VALUES('femoral')
INSERT INTO `muscle_areas`(name) VALUES('cuadriceps')
INSERT INTO `muscle_areas`(name) VALUES('deltoides')

INSERT INTO `workouts`(name , photo) VALUES('barra lateral' , 'http://www.misimagenes.com/')
INSERT INTO `workouts`(name , photo) VALUES('peso muerto' , 'http://www.misimagenes.com/')
INSERT INTO `workouts`(name , photo) VALUES('sentadillas' , 'http://www.misimagenes.com/')

INSERT INTO `workouts_muscle_areas`(workout_id , muscle_areas_id) VALUES(1 , 4)
INSERT INTO `workouts_muscle_areas`(workout_id , muscle_areas_id) VALUES(2 , 2)
INSERT INTO `workouts_muscle_areas`(workout_id , muscle_areas_id) VALUES(3 , 2)
INSERT INTO `workouts_muscle_areas`(workout_id , muscle_areas_id) VALUES(3 , 3)

INSERT INTO `routines`(description , photo , title) VALUES('Desde el piso y con la espalda recta, levante la barra' , 'http://www.misimagenes.com/' , 'Rutina de piernas')
INSERT INTO `routines`(description , photo , title) VALUES('Barra a pecho y levantar con codos totalmente estirados' , 'http://www.misimagenes.com/' , 'Rutina de pectorales')

INSERT INTO `routines_workouts`(repetitions , routine_id , series , workout_id) VALUES(12 , 1 , 4 , 2)
INSERT INTO `routines_workouts`(repetitions , routine_id , series , workout_id) VALUES(8 , 1 , 6 , 3)
