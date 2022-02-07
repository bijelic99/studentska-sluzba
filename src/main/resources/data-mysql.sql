INSERT INTO admin(id, email, first_name, last_name, password, username, deleted) VALUES (1, 'a1@mail.com', 'Admin', 'One', '$2a$12$OTsU5brc2YlurIIWGJ5nq.9x8O.KDzExKLxiwwuzyEh9yfOaWs9Ey', 'aOne', false); --password1

INSERT INTO employee(id, email, first_name, last_name, password, username, deleted) VALUES (1, 'e1@mail.com', 'Employe', 'One', '$2y$12$Ejrxz18IUDZZ1IAWQhimC.mBoTkLl.OkdfcI8TWDoj9Dy2UDes2A2', 'eOne', false); --password1
INSERT INTO employee(id, email, first_name, last_name, password, username, deleted) VALUES (2, 'e2@mail.com', 'Employe', 'Two', '$2y$12$Pjgz3E4P43eoUGanEYYFOuY06d/3vUtqqrZ28Jxn0eNel7GsTe6Z2', 'eTwo', false); --password2
INSERT INTO employee(id, email, first_name, last_name, password, username, deleted) VALUES (3, 'e3@mail.com', 'Employe', 'Three', '$2y$12$dZ9azHLaXE3oLEkoLWmuFepccWfedqYJt9P3YQlBa6Y/sg5ImtsvC', 'eThree', false); --password3
INSERT INTO employee(id, email, first_name, last_name, password, username, deleted) VALUES (4, 'e4@mail.com', 'Employe', 'Four', '$2y$12$Pjgz3E4P43eoUGanEYYFOuY06d/3vUtqqrZ28Jxn0eNel7GsTe6Z2', 'eFour', false); --password2
INSERT INTO employee(id, email, first_name, last_name, password, username, deleted) VALUES (5, 'e5@mail.com', 'Employe', 'Five', '$2y$12$dZ9azHLaXE3oLEkoLWmuFepccWfedqYJt9P3YQlBa6Y/sg5ImtsvC', 'eFive', false); --password3

INSERT INTO teaching_role(id, name, deleted) VALUES (1, 'Professor', false);
INSERT INTO teaching_role(id, name, deleted) VALUES (2, 'Assistant', false);
INSERT INTO teaching_role(id, name, deleted) VALUES (3, 'Demonstrator', false);

INSERT INTO subject(id, ects, title, deleted) VALUES (1, 6, 'E learning', false);
INSERT INTO subject(id, ects, title, deleted) VALUES (2, 8, 'Mathematics I', false);
INSERT INTO subject(id, ects, title, deleted) VALUES (3, 8, 'Mathematics II', false);
INSERT INTO subject(id, ects, title, deleted) VALUES (4, 8, 'Web', false);
INSERT INTO subject(id, ects, title, deleted) VALUES (5, 8, 'Programing basics', false);
INSERT INTO subject(id, ects, title, deleted) VALUES (6, 8, 'Economics', false);
INSERT INTO subject(id, ects, title, deleted) VALUES (7, 8, 'Digital Electronics', false);

INSERT INTO course(id, start_date, end_date, subject_id, deleted) VALUES(1, '2022-01-01 00:00:00', '2022-10-01 00:00:00', 1, false);
INSERT INTO course(id, start_date, end_date, subject_id, deleted) VALUES(2, '2021-01-01 00:00:00', '2021-06-01 00:00:00', 2, false);
INSERT INTO course(id, start_date, end_date, subject_id, deleted) VALUES(3, '2022-01-01 00:00:00', '2022-10-01 00:00:00', 3, false);
INSERT INTO course(id, start_date, end_date, subject_id, deleted) VALUES(4, '2022-01-01 00:00:00', '2022-10-01 00:00:00', 4, false);
INSERT INTO course(id, start_date, end_date, subject_id, deleted) VALUES(5, '2022-01-01 00:00:00', '2022-10-01 00:00:00', 5, false);
INSERT INTO course(id, start_date, end_date, subject_id, deleted) VALUES(6, '2022-01-01 00:00:00', '2022-10-01 00:00:00', 6, false);
INSERT INTO course(id, start_date, end_date, subject_id, deleted) VALUES(7, '2022-01-01 00:00:00', '2022-10-01 00:00:00', 7, false);
INSERT INTO course(id, start_date, end_date, subject_id, deleted) VALUES(8, '2022-01-01 00:00:00', '2022-10-01 00:00:00', 1, false);

INSERT INTO teacher(id, course_id, employee_id, teaching_role_id, deleted) VALUES (1, 1, 1, 1, false);
INSERT INTO teacher(id, course_id, employee_id, teaching_role_id, deleted) VALUES (2, 1, 2, 2, false);
INSERT INTO teacher(id, course_id, employee_id, teaching_role_id, deleted) VALUES (3, 1, 3, 3, false);
INSERT INTO teacher(id, course_id, employee_id, teaching_role_id, deleted) VALUES (4, 2, 1, 1, false);
INSERT INTO teacher(id, course_id, employee_id, teaching_role_id, deleted) VALUES (5, 2, 2, 2, false);
INSERT INTO teacher(id, course_id, employee_id, teaching_role_id, deleted) VALUES (6, 3, 3, 1, false);
INSERT INTO teacher(id, course_id, employee_id, teaching_role_id, deleted) VALUES (7, 4, 1, 1, false);
INSERT INTO teacher(id, course_id, employee_id, teaching_role_id, deleted) VALUES (8, 5, 2, 2, false);
INSERT INTO teacher(id, course_id, employee_id, teaching_role_id, deleted) VALUES (9, 5, 3, 1, false);
INSERT INTO teacher(id, course_id, employee_id, teaching_role_id, deleted) VALUES (10, 5, 1, 3, false);

INSERT INTO exam_period(id, end_time, name, start_time, deleted) VALUES(1, '2021-10-20 00:00:00', 'October', '2021-09-29 00:00:00', false);
INSERT INTO exam_period(id, end_time, name, start_time, deleted) VALUES(2, '2022-02-15 00:00:00', 'January', '2022-01-25 00:00:00', false);
INSERT INTO exam_period(id, end_time, name, start_time, deleted) VALUES(3, '2022-03-15 00:00:00', 'February', '2022-02-15 00:00:00', false);

INSERT INTO exam(id, exam_date_time, exam_enrolment_fee, course_id, exam_period_id, deleted) VALUES(1, '2021-09-29 09:00:00', 200.00, 2, 1, false);
INSERT INTO exam(id, exam_date_time, exam_enrolment_fee, course_id, exam_period_id, deleted) VALUES(2, '2022-01-25 10:00:00', 200.00, 2, 2, false);
INSERT INTO exam(id, exam_date_time, exam_enrolment_fee, course_id, exam_period_id, deleted) VALUES(3, '2022-01-26 10:00:00', 200.00, 3, 2, false);
INSERT INTO exam(id, exam_date_time, exam_enrolment_fee, course_id, exam_period_id, deleted) VALUES(4, '2022-01-27 10:00:00', 200.00, 4, 2, false);
INSERT INTO exam(id, exam_date_time, exam_enrolment_fee, course_id, exam_period_id, deleted) VALUES(5, '2022-02-15 12:00:00', 200.00, 5, 3, false);

INSERT INTO course_additional_points_type(id, name, deleted) VALUES(1, 'Project', false);
INSERT INTO course_additional_points_type(id, name, deleted) VALUES(2, 'Colloquium', false);
INSERT INTO course_additional_points_type(id, name, deleted) VALUES(3, 'Homework', false);

INSERT INTO course_additional_points(id, name, pass_required, course_id, start_datetime, end_datetime, course_additional_points_type_id, deleted) VALUES(1, "First Colloquium", true, 1, '2022-09-29 10:00:00', '2022-09-29 12:00:00', 2, false);
INSERT INTO course_additional_points(id, name, pass_required, course_id, start_datetime, end_datetime, course_additional_points_type_id, deleted) VALUES(2, "Second Colloquium", true, 1, '2022-10-30 10:00:00', '2022-10-30 12:00:00', 2, false);
INSERT INTO course_additional_points(id, name, pass_required, course_id, start_datetime, end_datetime, course_additional_points_type_id, deleted) VALUES(3, "Math homework", false, 3, '2022-01-01 00:00:00', '2022-10-01 00:00:00', 3, false);
INSERT INTO course_additional_points(id, name, pass_required, course_id, start_datetime, end_datetime, course_additional_points_type_id, deleted) VALUES(4, "Math homework", false, 4, '2022-01-01 00:00:00', '2022-10-01 00:00:00', 3, false);
INSERT INTO course_additional_points(id, name, pass_required, course_id, start_datetime, end_datetime, course_additional_points_type_id, deleted) VALUES(5, "Final project", true, 1, '2022-01-01 00:00:00', '2022-10-01 00:00:00', 1, false);


INSERT INTO student(id, email, first_name, last_name, password, username, deleted) VALUES(1, 'mail1@gmail.com', 'John1', 'Doe1', '$2y$12$axnGvlxM6nxl7hb/Saxhy.wZWqg6lgVafGknsXA7jvG7qhZS9zyGq', 'johndoe1', false); --password123
INSERT INTO student(id, email, first_name, last_name, password, username, deleted) VALUES(2, 'mail2@gmail.com', 'John2', 'Doe2', '$2y$12$axnGvlxM6nxl7hb/Saxhy.wZWqg6lgVafGknsXA7jvG7qhZS9zyGq', 'johndoe2', false); --password123
INSERT INTO student(id, email, first_name, last_name, password, username, deleted) VALUES(3, 'mail3@gmail.com', 'John3', 'Doe3', '$2y$12$axnGvlxM6nxl7hb/Saxhy.wZWqg6lgVafGknsXA7jvG7qhZS9zyGq', 'johndoe3', false); --password123
INSERT INTO student(id, email, first_name, last_name, password, username, deleted) VALUES(4, 'mail4@gmail.com', 'John4', 'Doe4', '$2y$12$axnGvlxM6nxl7hb/Saxhy.wZWqg6lgVafGknsXA7jvG7qhZS9zyGq', 'johndoe4', false); --password123
INSERT INTO student(id, email, first_name, last_name, password, username, deleted) VALUES(5, 'mail5@gmail.com', 'John5', 'Doe5', '$2y$12$axnGvlxM6nxl7hb/Saxhy.wZWqg6lgVafGknsXA7jvG7qhZS9zyGq', 'johndoe5', false); --password123

INSERT INTO students_account(id, amount, student_id, deleted) VALUES(1, 250, 1, false);
INSERT INTO students_account(id, amount, student_id, deleted) VALUES(2, 500, 2, false);
INSERT INTO students_account(id, amount, student_id, deleted) VALUES(3, 750, 3, false);
INSERT INTO students_account(id, amount, student_id, deleted) VALUES(4, 1000, 4, false);
INSERT INTO students_account(id, amount, student_id, deleted) VALUES(5, 1000, 5, false);

INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(1, 1, 1, false);
INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(2, 1, 2, false);
INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(3, 1, 3, false);

INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(4, 2, 1, false);
INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(5, 2, 2, false);
INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(6, 2, 3, false);
INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(7, 2, 4, false);
INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(8, 2, 5, false);

INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(9, 3, 1, false);
INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(10, 3, 2, false);
INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(11, 3, 3, false);
INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(12, 3, 4, false);
INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(13, 3, 5, false);

INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(14, 4, 4, false);
INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(15, 4, 5, false);

INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(16, 4, 4, false);
INSERT INTO course_enrolment(id, course_id, student_id, deleted) VALUES(17, 4, 5, false);

INSERT INTO expense(id, timestamp, amount, account_id, deleted) VALUES(1, '2022-06-29 00:00:00', 15.00, 1, false);

INSERT INTO exam_enrolment(id, exam_id, course_enrolment_id, expense_id, deleted) VALUES(1, 1, 1, 1, false);

INSERT INTO course_additional_points_enrolment(id, passed, course_additional_points_id, course_enrolment_id, deleted) VALUE(1, 1, 5, 1, false);
INSERT INTO course_additional_points_enrolment(id, passed, course_additional_points_id, course_enrolment_id, deleted) VALUE(2, 0, 5, 2, false);

INSERT INTO document_type(id, name, deleted) VALUE (1, 'High school Diploma', false);
INSERT INTO document_type(id, name, deleted) VALUE (2, 'Scanned ID', false);
INSERT INTO document_type(id, name, deleted) VALUE (3, 'Enrollment costs payment slip', false);
INSERT INTO document_type(id, name, deleted) VALUE (4, 'Tuition fee payment slip', false);
INSERT INTO document_type(id, name, deleted) VALUE (5, 'First year grade testimony', false);
INSERT INTO document_type(id, name, deleted) VALUE (6, 'Second year grade testimony', false);
INSERT INTO document_type(id, name, deleted) VALUE (7, 'Third year grade testimony', false);
INSERT INTO document_type(id, name, deleted) VALUE (8, 'Fourth year grade testimony', false);