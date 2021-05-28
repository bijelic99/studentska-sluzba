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

INSERT INTO course_additional_points_type(id, name, pass_required) VALUES(1, 'Project', true);
INSERT INTO course_additional_points_type(id, name, pass_required) VALUES(2, 'Colloquium', true);
INSERT INTO course_additional_points_type(id, name, pass_required) VALUES(3, 'Homework', false);

INSERT INTO course_additional_points(id, name, course_id, course_additional_points_type_id) VALUES(1, "First Colloquium", 1, 2);
INSERT INTO course_additional_points(id, name, course_id, course_additional_points_type_id) VALUES(2, "Second Colloquium", 1, 2);
INSERT INTO course_additional_points(id, name, course_id, course_additional_points_type_id) VALUES(3, "Math homework", 3, 3);
INSERT INTO course_additional_points(id, name, course_id, course_additional_points_type_id) VALUES(4, "Math homework", 4, 3);
INSERT INTO course_additional_points(id, name, course_id, course_additional_points_type_id) VALUES(5, "Final project", 1, 1);
