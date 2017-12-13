Installation de UIMA Ruta Workbench:

UIMA Ruta Workbench est un plugin d'Eclipse offrant un environnement puissant pour créer et travailler sur des projets
UIMA Ruta.
	-Téléchargez, installez et démarrez Eclipse. La dernière version d'Eclips peut être obtenu à partir du site de 
téléchargement eclipse.org.
	-Ajouter le site de mise à jour Apache UIMA ( http://www.apache.org/dist/uima/eclipse-update-site/ ) aux sites 
de logiciels disponibles dans votre installation Eclipse:
		-Cliquez sur « Help → Install New Software... ». Cela ouvre l'assistant d' installation.
		-Entrer le site de mise à jour Apache UIMA ( http://www.apache.org/dist/uima/eclipse-update-site/ )dans le 
champ « Work with: » et appuyez sur « Entrée » .
		-Sélectionnez « Apache UIMA Ruta » et « Apache UIMA Eclipse tooling and runtime support » en cliquant dans 
la case à cocher correspondant.
		-Sélectionnez également « Contact all update sites during install to find required software » et cliquez 
sur « Next > ».
		-Sur la page suivante, cliquez sur « Next > » à nouveau. Maintenant, le site d'accord de licence est affiché. 
Pour installer UIMA Ruta lire la licence et choisissez «J'accepte ... » si vous l' acceptez. Ensuite, cliquez sur « Terminer ».
	-On peut maintenant choisir l'environnement UIMA Ruta dans Eclipse. Pour ce faire, cliquez sur le bouton en forme de stylo
qui se trouve dans la partie supérieure droite d'Eclipse. 

L'environnement UIMA Ruta Workbench est maintenant installé. Il faut alors ouvrir le dossier contenant le code pour lancé 
l'annotation. 

	-Cliquez sur « File → Open Projects from File System ».
	-Dans le champ « Import source », entrez le chemin du dossier racine « DetectionSentiment » contenant les sous dossiers: 
« input », « output », « recources » et « script ».
	-Un dossier est alors crée dans la partie « Package Explorer ». Il contient tous les fichiers dont nous avons
besoin. 
	-Il est possible d'ouvrir les fichiers textes contenus dans « input » directement dans Eclipse et ainsi les
modifier directement.
	-Dans le sous dossier « script → package », ouvrez le fichier annotator.ruta. 
	-Cliquez avec le clic droit sur le nom du fichier, puis cliquez sur « Run As → UIMA Ruta ».
	-Une fois l'execution terminée, le fichier .xmi qui se trouve dans le dossier « output » est mis à jour. Il 
suffit de l'ouvrir directement dans Eclipse pour voir les annotations effectuées. 
	-Ce fichier peut aussi être ouvert dans un éditeur de texte et sera semblable à un fichier xml. Et chaque balise
represente une annotation, et sera spécifié par le caractère de début et celui de fin. 