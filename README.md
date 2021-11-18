Tests
The term insert will refer in any test to inserting arguments to Run configuration on Eclipce

Insert zero args . Expected - The program should return current directory and file with Name, Owner ,permissions and last Modified date.
Insert -r arg alone. Expected - The program should return recursively any file and directory under current with Name, Owner ,permissions and last Modified date.
Insert -r and a directory path after as a second arg. Expected - The program should return any file and directory under the given path with Name, Owner ,permissions and last Modified date.
Insert a path of directory as an arg. Expected - The program should return the directory name.
Insert a path of a file. Expected - The program should return the file Name, Owner, permission and last modified date.
Insert a file that does not exist on the path. Expected - The program should return - “File does not exist”.
insert a file without a path. Expected - The program should return - “File does not exist”.
Insert a directory path and then -r. Expected - The program should return directory name and a message that the file -r does not exist.
Insert -r and then a file path. Expected - The program should throw an exception.
Insert a large number of file paths. Expected - The program should return all the files details as above.
Insert a large number of directory paths. Expected - The program should return all the directories names.
Insert a file path and then a directory path. Expected - The program should return the file name and details and then the directory name.
Insert a directory path and then a file path. Expected - The program should return the directory name and then the file name and details.
Insert a large number of File/Directory/File/Path… in this order. Expected - The program should return all files and directory in the given order.
Insert a large number of file an directory paths in a random order. Expected - The program should return all file and directory details in the given order.
