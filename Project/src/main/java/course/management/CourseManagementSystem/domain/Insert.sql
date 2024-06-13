-- Insert data into PersonAccount table
INSERT INTO PersonAccount (id, password, username) VALUES
(1, 'password1', 'user1'),
(2, 'password2', 'user2');

-- Insert data into Person table
INSERT INTO Person (id, personAccount, birthdate, GenderType, createdOn, updatedOn, EmailAddress, createdBy, firstName, lastName, updatedBy) VALUES
(1, 1, '2000-01-01', 1, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 'email1@example.com', 'system', 'John', 'Doe', 'system'),
(2, 2, '2001-02-02', 2, '2023-02-02 00:00:00', '2023-02-02 00:00:00', 'email2@example.com', 'system', 'Jane', 'Doe', 'system');

-- Insert data into Faculty table
INSERT INTO Faculty (id, Salutation) VALUES
(1, 'Dr.'),
(2, 'Prof.');

-- Insert data into Student table
INSERT INTO Student (id, FacultyAdviserID, AlternateID, ApplicantID, Entry, StudentID) VALUES
(1, 1, 'A001', 'AP001', '2023', 'S001'),
(2, 2, 'A002', 'AP002', '2023', 'S002');

-- Insert data into FacultyHobby table
INSERT INTO FacultyHobby (id, Faculty_id, hobbies) VALUES
(1, 1, 'Reading'),
(2, 2, 'Swimming');

-- Insert data into LocationType table
INSERT INTO LocationType (id, createdOn, updatedOn, createdBy, type, updatedBy) VALUES
(1, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 'system', 'Classroom', 'system'),
(2, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 'system', 'Laboratory', 'system');

-- Insert data into Location table
INSERT INTO Location (ID, createdOn, updatedOn, createdBy, type_id, Name, Capacity, updatedBy) VALUES
(1, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 'system', 1, 'Room 101', 30, 'system'),
(2, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 'system', 2, 'Lab 201', 20, 'system');

-- Insert data into Course table
INSERT INTO Course (id, createdOn, updatedOn, createdBy, CourseCode, CourseDescription, CourseName, credits, department, updatedBy) VALUES
(1, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 'system', 'CS101', 'Intro to Computer Science', 'Computer Science 101', '3', 'CS', 'system'),
(2, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 'system', 'MATH101', 'Intro to Mathematics', 'Mathematics 101', '3', 'Math', 'system');

-- Insert data into CourseOffering table
INSERT INTO CourseOffering (id, createdOn, updatedOn, createdBy, CourseID, FacultyID, CourseOfferingType, capacity, Room, credits, updatedBy) VALUES
(1, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 'system', 1, 1, 1, 30, 'Room 101', '3', 'system'),
(2, '2023-01-01 00:00:00', '2023-01-01 00:00:00', 'system', 2, 2, 1, 30, 'Lab 201', '3', 'system');

-- Insert data into CoursePrerequisite table
INSERT INTO CoursePrerequisite (CourseId, PrerequisiteId) VALUES
(1, 2);

-- Insert data into CourseRegistration table
INSERT INTO CourseRegistration (id, Sequence, CourseOfferingId, StudentId) VALUES
(1, 1, 1, 1),
(2, 1, 2, 2);

-- Insert data into AttendanceRecord table
INSERT INTO AttendanceRecord (id, ScanDateTime, LocationId, StudentId) VALUES
(1, '2023-01-01', 1, 1),
(2, '2023-01-01', 2, 2);
