<h1>A birthday greeting JAVA command-line app</h1>
<p> This is a little command-line JAVA app made to send birthday greetings to people via e-mails thanks to a CSV file. </p>
<p> It was a little school project made to push us to be cautious about good practices in the code writing. It also introduced us to Maven. </p>
<p> The project itself was not that hard but the objective was to have the cleaner code possible. In others terms : a deployable app and something that everybody knowing JAVA could read easily. </p>
<p> It's meant to be an exercise for a job interview. The employer evaluates your level thanks to the choices you're making to achieve this app, (s)he can see how far you're going to make it the most complete, the most understandable, the most re-usable possible. Because everybody in a company should code maintainable apps ! </p>

In order to work, you have to execute it with, for arguments : 
  - The path to a CSV file
  - The path to the properties file.
You can take this CSV file : "resources/persons".

 CSV syntax :
  <code> day_of_birth,month_of_birth,year_of_birth,surname,firstName,mail </code>
</br>
You'll have to change the "resources/config.properties" file according to your preferences (to make mail sendings work).
