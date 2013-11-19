geotranslation
==============

A command line application for translation of geographic names using Geonames.


Installation
------------

clone geotranslation

...
git clone https://github.com/KepaJRodriguez/geotranslation
...

compile with maven


	mvn compile assembly:single


The command line application is a JAR file generated into the "target" directory:

    geotranslation-0.0.1-SNAPSHOT-jar-with-dependencies.jar


Usage
-----

	java -jar geotranslation-0.0.1-SNAPSHOT-jar-with-dependencies.jar input_file


Input format: text file with two columns separated by a tab.
1 First column: Identifier of the geographic term
2 Second column: Geographic term

Output: text file with a column for the identifier and a column for each pair language:translation

 