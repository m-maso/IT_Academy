For all exercises:
-------------------
- Open command prompt (cmd)<br>
e.g. by pressing the windows logo + R and typing cmd or by writting cmd in the search box on the tasks bar 
- Open the file's directory where is the file you want to compile, by giving the pathway: cd file_path<br>
e.g. cd C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_05\\src\\n1ex01
- You compile the file by writting: javac name_of_file.java
- If you need to pass an argument you write: java name_of_file.java argument_you_want_to_pass

!! Last exercise, n5 
- You compile the file from the folder of the project (one before 'src' folder)<br> 
e.g:<br>
C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05>javac src/n1ex05/*.java<br>
C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05>java -cp src n1ex05.SerialiseObj

---------------------------------------- n1ex01 ----------------------------------------

Microsoft Windows [Version 10.0.22621.2428]
(c) Microsoft Corporation. All rights reserved.

C:\Users\monma>cd C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_05\\src\\n1ex01

C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05\src\n1ex01>javac Directory.java

C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05\src\n1ex01>java Directory.java
Write the path of the directory you want to list
C:\\Users\\monma\\Documents\\IT Academy\\espc_java
Directory's content sorted:
C:\Users\monma\Documents\IT Academy\espc_java\cmd_commands.txt
C:\Users\monma\Documents\IT Academy\espc_java\countries.txt
C:\Users\monma\Documents\IT Academy\espc_java\docs_discord
C:\Users\monma\Documents\IT Academy\espc_java\espec_java.odt
C:\Users\monma\Documents\IT Academy\espc_java\GitHub_IT_Academy
C:\Users\monma\Documents\IT Academy\espc_java\GIT_1.pdf
C:\Users\monma\Documents\IT Academy\espc_java\Sprint_0
C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1
C:\Users\monma\Documents\IT Academy\espc_java\Sprint_2
C:\Users\monma\Documents\IT Academy\espc_java\Sprint_3
C:\Users\monma\Documents\IT Academy\espc_java\Sprint_4
C:\Users\monma\Documents\IT Academy\espc_java\Sprint_5

C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05\src\n1ex01>

---------------------------------------- n1ex02 ----------------------------------------

Microsoft Windows [Version 10.0.22621.2428]
(c) Microsoft Corporation. All rights reserved.

C:\Users\monma>cd C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_05\\src\\n1ex02

C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05\src\n1ex02>javac TreeDirectories.java

C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05\src\n1ex02>java TreeDirectories.java
Write the path of the directory you want to list
C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_05\\src
Directory's content sorted:
|__(D) 2023-10-21 n1ex01
  |____(F) 2023-10-21 Directory.class
  |____(F) 2023-10-21 Directory.java
|__(D) 2023-10-21 n1ex02
  |____(F) 2023-10-21 TreeDirectories.class
  |____(F) 2023-10-21 TreeDirectories.java
|__(D) 2023-10-17 n1ex03
  |____(F) 2023-10-17 SaveDirTxt.java
|__(D) 2023-10-17 n1ex04
  |____(F) 2023-10-17 ReadTxtShowContent.java
|__(D) 2023-10-17 n1ex05
  |____(F) 2023-10-17 SerialiseObj.java
  |____(F) 2023-10-21 README.md

C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05\src\n1ex02>

---------------------------------------- n1ex03 ----------------------------------------

Microsoft Windows [Version 10.0.22621.2428]
(c) Microsoft Corporation. All rights reserved.

C:\Users\monma>cd C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_05\\src\\n1ex03

C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05\src\n1ex03>javac SaveDirTxt.java

C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05\src\n1ex03>java SaveDirTxt.java
Write the path of the directory you want to list
C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_05\\src
New Tree Directories File Created
You can see the Tree Directories file 'TreeDirectories.txt'

C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05\src\n1ex03>
s
---------------------------------------- n1ex04 ----------------------------------------

Microsoft Windows [Version 10.0.22621.2428]
(c) Microsoft Corporation. All rights reserved.

C:\Users\monma>cd C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_05\\src\\n1ex04

C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05\src\n1ex04>javac ReadTxtShowContent.java

C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05\src\n1ex04>java ReadTxtShowContent.java
Write the path of the directory you want to list
C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_05\\src
New Tree Directories File Created
You can see the Tree Directories file 'TreeDirectories.txt'

Write the path where the file you want to read is located
C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_03\\src\\n1ex03\\score.txt
Username: John, Score: 6 points
Username: Mary, Score: 8 points

C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05\src\n1ex04>

---------------------------------------- n1ex05 ----------------------------------------

Microsoft Windows [Version 10.0.22621.2428]
(c) Microsoft Corporation. All rights reserved.

C:\Users\monma>cd C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05\

C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05>javac src/n1ex05/*.java

C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05>java -cp src n1ex05.SerialiseObj
Write the path of the directory you want to save the file
C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05\src\n1ex05
Serialised data is saved in 'SerialiseObj.ser' file

Deserialising Students..
Student: George White is studying Java and is 25 years old.
Student: John Mason is studying JavaScript and is 51 years old.

C:\Users\monma\Documents\IT Academy\espc_java\Sprint_1\S1_05>
