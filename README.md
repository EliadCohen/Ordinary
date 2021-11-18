**Tests**
 The term insert will refer in any test to inserting arguments to Run configuration on Eclipce

1. Insert zero args . Expected - The program should return current directory and file with Name, Owner ,permissions and last Modified date.
2. Insert -r arg alone. Expected - The program should return recursively any file and directory under current with Name, Owner ,permissions and last Modified date.
3. Insert -r and a directory path after as a second arg. Expected - The program should return any file and directory under the given path with Name, Owner ,permissions and last Modified date.
4. Insert a path of directory as an arg. Expected - The program should return the directory name.
5. Insert a path of a file. Expected - The program should return the file Name, Owner, permission and last modified date.
6. Insert a file that does not exist on the path. Expected - The program should return - &quot;File does not exist&quot;.
7. insert a file without a path. Expected - The program should return - &quot;File does not exist&quot;.
8. Insert a directory path and then -r. Expected - The program should return directory name and a message that the file -r does not exist.
9. Insert -r and then a file path. Expected - The program should throw an exception.
10. Insert a large number of file paths. Expected - The program should return all the files details as above.
11. Insert a large number of directory paths. Expected - The program should return all the directories names.
12. Insert a file path and then a directory path. Expected - The program should return the file name and details and then the directory name.
13. Insert a directory path and then a file path. Expected - The program should return the directory name and then the file name and details.
14. Insert a large number of File/Directory/File/Path… in this order. Expected - The program should return all files and directory in the given order.
15. Insert a large number of file an directory paths in a random order. Expected - The program should return all file and directory details in the given order.
