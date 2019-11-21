# Documentation partielle de la base de données
## BD_Locale
* BD_Locale(String path) -> initialise la bd locale , path correspond au chemin vers le dossier (ex : "../BDLocale")
* ArrayList<Film> getFilms() -> récupérer les films
* int getLoc(Film f) -> récupérer le nombre de location d'un film pour le mois (sert au tech pour avoir les stats et mettre le films en top vente)
* commit(ArrayList<Film> films) -> tu passes la liste des films de la bd locale en param et ça màj la bd locale, si tu as supprimé/ajouté/modifié des films c'est pris en compte (java : passage par ref)

## BD_Distante:
* BD_Distante(String path) -> comme pour bd locale
* askFilm(String titre, String realisateur) -> demande à ajouter un film, si le film est déjà présent dans la liste ou qu'il n'est pas dans les films de cybervideo => renvoie false, sinon ajoute la demande et renvoie true
* ArrayList<Film> getFilms() -> récup les films
* ArrayList<DemandeAjoutFilm> getDemandesAjoutsFilms() -> récup les demandes de films (pour le tech, pour les ajouter à la bd locale par la suite)
* Client identification(String numCarte) -> tente d'identifier un client avec un num de carte , renvoie null si aucun client trouvé, le client sinon
* Technicien identificationTechnicien(String numCarte) -> la même chose mais pour un tech
* Boolean supprimerClient(Client c) -> suppr un client , si client non trouvé renvoie false,  sinon true
* Boolean addClient(Client c)  -> add un client , si un client existe avec le meme num de carte => renvoie false ,sinon true
* void commit() -> màj la bd distante

## TODO 
* Supprimer l'historique d'un client s'il a été supprimé (?)