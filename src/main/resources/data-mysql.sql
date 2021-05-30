INSERT INTO EMPLOYEE(id, email, first_name, last_name, password, username) VALUES (1, 'e1@mail.com', 'Employe', 'One', 'password1', 'eOne');
INSERT INTO EMPLOYEE(id, email, first_name, last_name, password, username) VALUES (2, 'e2@mail.com', 'Employe', 'Two', 'password2', 'eTwo');
INSERT INTO EMPLOYEE(id, email, first_name, last_name, password, username) VALUES (3, 'e3@mail.com', 'Employe', 'Three', 'password3', 'eThree');

INSERT INTO TEACHING_ROLE(id, name) VALUES (1, 'Professor');
INSERT INTO TEACHING_ROLE(id, name) VALUES (2, 'Assistant');
INSERT INTO TEACHING_ROLE(id, name) VALUES (3, 'Demonstrator');

INSERT INTO SUBJECT(id, ects, title) VALUES (1, 6, 'E learning');
INSERT INTO SUBJECT(id, ects, title) VALUES (2, 8, 'Mathematics I');
INSERT INTO SUBJECT(id, ects, title) VALUES (3, 8, 'Mathematics II');

INSERT INTO COURSE(id, start_date, end_date, subject_id) VALUES(1, '2021-01-01 00:00:00', '2021-07-01 00:00:00', 1);
INSERT INTO COURSE(id, start_date, end_date, subject_id) VALUES(2, '2020-07-01 00:00:00', '2021-01-01 00:00:00', 1);
INSERT INTO COURSE(id, start_date, end_date, subject_id) VALUES(3, '2020-07-01 00:00:00', '2021-01-01 00:00:00', 2);
INSERT INTO COURSE(id, start_date, end_date, subject_id) VALUES(4, '2021-01-01 00:00:00', '2021-07-01 00:00:00', 3);
INSERT INTO COURSE(id, start_date, end_date, subject_id) VALUES(5, '2021-01-01 00:00:00', '2021-07-01 00:00:00', 3);

INSERT INTO TEACHER(id, course_id, employee_id, teaching_role_id) VALUES (1, 1, 1, 1);
INSERT INTO TEACHER(id, course_id, employee_id, teaching_role_id) VALUES (2, 1, 2, 2);
INSERT INTO TEACHER(id, course_id, employee_id, teaching_role_id) VALUES (3, 1, 3, 3);
INSERT INTO TEACHER(id, course_id, employee_id, teaching_role_id) VALUES (4, 2, 1, 1);
INSERT INTO TEACHER(id, course_id, employee_id, teaching_role_id) VALUES (5, 2, 2, 2);
INSERT INTO TEACHER(id, course_id, employee_id, teaching_role_id) VALUES (6, 3, 3, 1);
INSERT INTO TEACHER(id, course_id, employee_id, teaching_role_id) VALUES (7, 4, 1, 1);
INSERT INTO TEACHER(id, course_id, employee_id, teaching_role_id) VALUES (8, 5, 2, 2);
INSERT INTO TEACHER(id, course_id, employee_id, teaching_role_id) VALUES (9, 5, 3, 1);
INSERT INTO TEACHER(id, course_id, employee_id, teaching_role_id) VALUES (10, 5, 1, 3);

INSERT INTO EXAM(id, exam_date_time, exam_enrolment_fee, course_id) VALUES(1, '2021-06-29 00:00:00', 200.00, 1);
INSERT INTO EXAM(id, exam_date_time, exam_enrolment_fee, course_id) VALUES(2, '2021-06-29 00:00:00', 200.00, 2);
INSERT INTO EXAM(id, exam_date_time, exam_enrolment_fee, course_id) VALUES(3, '2021-06-29 00:00:00', 200.00, 3);
INSERT INTO EXAM(id, exam_date_time, exam_enrolment_fee, course_id) VALUES(4, '2021-06-29 00:00:00', 200.00, 4);
INSERT INTO EXAM(id, exam_date_time, exam_enrolment_fee, course_id) VALUES(5, '2021-06-29 00:00:00', 200.00, 5);

INSERT INTO course_additional_points_type(id, name) VALUES(1, 'Project');
INSERT INTO course_additional_points_type(id, name) VALUES(2, 'Colloquium');
INSERT INTO course_additional_points_type(id, name) VALUES(3, 'Homework');

INSERT INTO course_additional_points(id, name, pass_required, course_id, course_additional_points_type_id) VALUES(1, "First Colloquium", true, 1, 2);
INSERT INTO course_additional_points(id, name, pass_required, course_id, course_additional_points_type_id) VALUES(2, "Second Colloquium", true, 1, 2);
INSERT INTO course_additional_points(id, name, pass_required, course_id, course_additional_points_type_id) VALUES(3, "Math homework", false, 3, 3);
INSERT INTO course_additional_points(id, name, pass_required, course_id, course_additional_points_type_id) VALUES(4, "Math homework", false, 4, 3);
INSERT INTO course_additional_points(id, name, pass_required, course_id, course_additional_points_type_id) VALUES(5, "Final project", true, 1, 1);


INSERT INTO STUDENT(id, email, first_name, last_name, password, username) VALUES(1, 'mail1@gmail.com', 'John1', 'Doe1', 'password123', 'johndoe1');
INSERT INTO STUDENT(id, email, first_name, last_name, password, username) VALUES(2, 'mail2@gmail.com', 'John2', 'Doe2', 'password123', 'johndoe2');
INSERT INTO STUDENT(id, email, first_name, last_name, password, username) VALUES(3, 'mail3@gmail.com', 'John3', 'Doe3', 'password123', 'johndoe3');
INSERT INTO STUDENT(id, email, first_name, last_name, password, username) VALUES(4, 'mail4@gmail.com', 'John4', 'Doe4', 'password123', 'johndoe4');
INSERT INTO STUDENT(id, email, first_name, last_name, password, username) VALUES(5, 'mail5@gmail.com', 'John5', 'Doe5', 'password123', 'johndoe5');

INSERT INTO STUDENTS_ACCOUNT(id, amount, student_id) VALUES(1, 250, 1);
INSERT INTO STUDENTS_ACCOUNT(id, amount, student_id) VALUES(2, 500, 2);
INSERT INTO STUDENTS_ACCOUNT(id, amount, student_id) VALUES(3, 750, 3);
INSERT INTO STUDENTS_ACCOUNT(id, amount, student_id) VALUES(4, 1000, 4);
INSERT INTO STUDENTS_ACCOUNT(id, amount, student_id) VALUES(5, 1000, 5);

INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(1, 1, 1);
INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(2, 1, 2);
INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(3, 1, 3);

INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(4, 2, 1);
INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(5, 2, 2);
INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(6, 2, 3);
INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(7, 2, 4);
INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(8, 2, 5);

INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(9, 3, 1);
INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(10, 3, 2);
INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(11, 3, 3);
INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(12, 3, 4);
INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(13, 3, 5);

INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(14, 4, 4);
INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(15, 4, 5);

INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(16, 4, 4);
INSERT INTO COURSE_ENROLMENT(id, course_id, student_id) VALUES(17, 4, 5);