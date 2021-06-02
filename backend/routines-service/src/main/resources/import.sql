INSERT INTO routines_group (name , photo) VALUES('aumento masa muscular' , 'photo.png');
INSERT INTO routines_group (name , photo) VALUES('adelgazar' , 'photo.png');

INSERT INTO routines (level , routine_group_id) VALUES(1, 1);
INSERT INTO routines (level , routine_group_id) VALUES(2, 1);
INSERT INTO routines (level , routine_group_id) VALUES(3, 1);

INSERT INTO workouts (name, series, repetitions, photo) VALUES('press con mancuerna' , 4 , 12 , 'photo-press.png');
INSERT INTO workouts (name, series, repetitions, photo) VALUES('zancadas' , 4 , 12 , 'photo-zancada.png');
INSERT INTO workouts (name, series, repetitions, photo) VALUES('vuelos laterales' , 4 , 12 , 'photo-lateral.png');
INSERT INTO workouts (name, series, repetitions, photo) VALUES('vuelos frontales' , 4 , 12 , 'photo-frontal.png');

INSERT INTO routines_workouts (routine_id , workout_id) VALUES(1 , 1);
INSERT INTO routines_workouts (routine_id , workout_id) VALUES(1 , 2);
INSERT INTO routines_workouts (routine_id , workout_id) VALUES(1 , 3);
INSERT INTO routines_workouts (routine_id , workout_id) VALUES(1 , 4);

INSERT INTO routines_users (routine_id , user_id) VALUES(1 , '1122652095');
INSERT INTO routines_users (routine_id , user_id) VALUES(2 , '1122652095');
INSERT INTO routines_users (routine_id , user_id) VALUES(3 , '1122122653');