# Schedule
Project in OOP, the goal is to create a schedule with for enter a file with activities and constraints;


Ce jar est composé de :
	- un package filrouge, possédant deux classes executables : Main, InteractiveScheduling
	- un fichier Activities.txt
	- un fichier Constraints.txt
	- un script shell : exe.sh
	- une librairie externe : scheduleio.jar
	- un README.md

Info pratique : 
	- les fichiers Activities et Constraints doivent être remplies de la manière suivante, ligne par ligne comme
	montré dans l'exemple:
	Activities : nom_activité duree description;
	Constraints : CONSTRAINT arguments;
		Les contraintes disponibles sont:
						PRECEDENCE nom_activité1 nom_activité2
						PRECEDENCE_GAP durée nom_activité1 nom_activité2
						MEET nom_activité1 nom_activité2
						MAX_SPAN duréé nom_activité1 nom_activité2 ... nom_activité10
Méthode d'exécution :
	Lancer la commande ./exe.sh dans un terminal; Automatiquement le script va lancer le programme avec pour
	classe executable Main; pour rediriger l'execution vers une autre classe, il suffit de l'ajouter en argument
	du script : ./exe.sh InteractiveScheduling
 
