Objectifs
- Concevoir un programme Java pour lire/écrire des données au clavier
- Concevoir un programme Java afin de déclarer les exceptions à déclaration obligatoire
- Utiliser la généricité, liste et des classes existantes
I. Jeu de cartes 21 :
On souhaite écrire un programme qui permet à l’utilisateur de jouer au jeu de cartes 21.
I.1. Principe :
L’utilisateur reçoit une carte à la fois et après chaque carte il décide s’il continue ou non.
Le but est, en additionnant les points des cartes que l’utilisateur a en main, d’approcher le
plus possible 21 sans dépasser cette valeur. Si l’utilisateur dépasse 21 il a perdu, sinon c’est
au tour de l’ordinateur de jouer. Si lorsqu’il s’arrête il a dépassé 21 ou a moins que
l’utilisateur, c’est celui-ci qui a gagné, sinon c’est le croupier (l’ordinateur) qui gagne.
Les points sont comptés en établissant la valeur des cartes comme suit :
• de 2 à 9 → valeur nominale de la carte
• chaque figure (Jack, Queen ou King) + le 10 (surnommées "bûche") → 10 points
• l'As → 1 ou 11 points (au choix)
I.2. Étapes du Jeu :
• Premièrement, deux cartes sont distribuées dans la main de chaque joueur. Si la main de
l’ordinateur a une valeur de 21 à ce stade, alors l’ordinateur gagne. Sinon, si l'utilisateur a
21, alors l'utilisateur gagne. Notez que l’ordinateur gagne sur une égalité, donc si les deux
joueurs ont 21, alors l’ordinateur gagne.
• Maintenant, si le jeu n'est pas terminé, l'utilisateur a la possibilité d'ajouter des cartes à sa
main. Dans cette phase, l'utilisateur voit ses propres cartes et voit l'une des deux cartes
l’ordinateur. L'utilisateur décide s'il doit continuer «Hit», ce qui signifie ajouter une autre
carte à sa main, ou arrêter «Stand», ce qui signifie arrêter de prendre des cartes.
• Si l'utilisateur choisit de continuer «Hit», il est possible que l'utilisateur dépasse 21. Dans
ce cas, le jeu est terminé et l'utilisateur perd. Sinon, le processus se poursuit. L'utilisateur
peut décider à nouveau de continuer ou d’arrêter.
2
• Si l'utilisateur arrête «Stand», le jeu se terminera, mais l’ordinateur aura d'abord une
chance de tirer des cartes. L’ordinateur ne suit que les règles, sans aucun choix. La règle
est que tant que la valeur de la main de l’ordinateur est inférieure ou égale à 16, l’ordinateur
tire (c'est-à-dire prend une autre carte). L'utilisateur devrait voir toutes les
cartes de l’ordinateur à ce stade.
Maintenant, le gagnant peut être déterminé: si l’ordinateur a dépassé 21, l'utilisateur gagne.
Sinon, si le total de l’ordinateur est supérieur ou égal au total de l'utilisateur, alors
l’ordinateur gagne. Sinon, l'utilisateur gagne.
II. Définition des classes :
On définit les classes suivantes :
- Classe Card: a deux attributs value (valeur d’une carte) et color (sa couleur)
- Classe Deck: représente le jeu de cartes à jouer et contient 52 cartes régulières.
Deck a deux attributs:
o Card: un tableau de 52 cartes et,
o number: qui représente le nombre de cartes qui ont été distribuées depuis le Deck
- Classe Player: doit permettre de représenter la pile de cartes qu’a en main un joueur.
Elle a un seul attribut hand de type ArrayList<Card>.
- Classe Game fournie et NE DOIT PAS ÊTRE MODIFIÉE: contient une méthode
play qui permet de commencer le jeu entre deux joueurs (l’utilisateur et l’ordinateur). La
méthode play effectue les opérations suivantes :
o Créer le jeu de carte (Deck) et les deux joueurs (Player)
o Mélanger les cartes, puis distribuer deux cartes au départ à chaque joueur.
o Commencer le jeu.
o Vérifier si l'un des joueurs a deux cartes totalisant 21. Le joueur avec 21 remporte la partie.
La classe Game contient aussi le programme principale main qui vous permet de tester
vos classes. main permet à l'utilisateur de jouer à plusieurs parties du Jeu21. On donne à
l'utilisateur 100 dollars et on laisse l'utilisateur faire des paris sur le jeu. Si l'utilisateur perd,
on soustrait le pari de l'argent de l'utilisateur. Si l'utilisateur gagne, on ajoute un montant
égal à la mise à l'argent de l'utilisateur. Le programme est arrêté lorsque l'utilisateur veut
quitter ou quand il est à court d'argent.
- Classe ReadInput fournie et ne doit pas être modifiée: pour la communication
avec le clavier : ses méthodes sont appelées dans main et play de la classe Game.
ReadInput lève les exceptions nécessaires au cas où vous ne tapez pas le bon caractère
ou nombre.
3
II.1) Classe Card
La classe Card doit permettre de créer une carte et contient les méthodes suivantes :
- un constructeur qui doit:
o créer une carte avec une couleur et une valeur spécifiées.
o lever une exception (IllegalArgumentException) si les valeurs de ses
paramètres ne sont pas dans les plages permises.
- getColor : Renvoie la couleur de cette carte.
- getValue : Renvoie la valeur de cette carte.
- ColorToString : Renvoie une représentation sous forme de chaîne (String) de la
couleur de la carte.
- ValueToString : Renvoie une représentation sous forme de chaîne (String) de la
valeur de la carte.
- toString : Renvoie une représentation sous forme de chaîne de cette carte, y compris
sa couleur et sa valeur.
Question 1: (7 POINTS: 1.5 POINTS pour le constructeur, 1 pour chaque méthode et
0.5 point pour la lisibilité/propreté/commentaires …)
Définir la classe Card dont le croquis est fourni ci-joint en complétant ses méthodes aux
places indiquées dans la classe.
II.2) Classe Deck
La classe Deck doit permettre de construire un jeu de poker régulier de 52 cartes et contient
les méthodes suivantes :
- un constructeur qui construit un jeu de poker régulier de 52 cartes. Au départ, les cartes
sont dans un ordre trié.
- shuffle: remet toutes les cartes utilisées dans le paquet (Deck) le cas échéant, et mélange
le jeu dans un ordre aléatoire.
- numberLeft : Renvoie le nombre de cartes restantes dans le paquet (Deck).
- take : prends la carte suivante du paquet et la renvoie. Lève une exception de type
IllegalStateException s'il n'y a plus de cartes dans le Deck.
Question 2 : (6 POINTS : 1 POINT pour la méthode numberLeft, 1.5 POINTS pour
chacune des autres méthodes et 0.5 point pour la lisibilité/propreté/commentaires …)
Définir la classe Deck dont le croquis est fourni ci-joint en complétant ses méthodes aux
places indiquées dans la classe.
Vous pouvez faire appel à Math.random() dans la méthode shuffle.
Math.random() renvoie un nombre de type double pseudo-aléatoire supérieur ou égal à 0,0
et inférieur à 1,0.
4
II.3) Classe Player
La classe Player devrait pouvoir représenter l'ensemble de cartes qu'un joueur a en main.
Elle doit permettre entre autres, de prendre une carte du Deck et de la placer en main,
compter les points des cartes en main. Elle contient les méthodes suivantes :
- un constructeur pour créer une main.
- getHand: Accesseur qui renvoie une main.
- clear : Retirez toutes les cartes de la main, en la laissant vide.
- add : Ajoute une carte à la main. Il est ajouté à la fin de la main courante. Lève une
exception de type NullPointerException si le paramètre (carte) est nul.
- remove(Card card): Retire une carte de la main, le cas échéant.
- remove(int position) : Retire la carte dans une position spécifiée de la main. Le paramètre
position est la position de la carte à retirer, où les positions sont numérotées à partir de
zéro. Lève une exception de type IllegalArgumentException si la position n'existe pas dans
la main, c'est-à-dire si la position est inférieure à 0 ou supérieure à ou égal au nombre de
cartes de la main.
- totalCards : Renvoie le nombre de cartes dans la main.
- getCard(int position) : Renvoie la carte dans une position spécifiée dans la main sans la
retirer de la main. Lève une exception de type IllegalArgumentException si la position
n'existe pas dans la main.
- getHandTotal : Calcule et renvoie la valeur totale de cette main dans le jeu. Si la valeur
d’une carte dépasse 10 (Jack, Queen, ou King), on la compte pour 10. On compte aussi tout
As pour 1. Mais, s'il y a un as, et si sa valeur passe de 1 à 11 laisserait le score inférieur ou
égal à 21, alors faites-le en ajoutant les 10 points supplémentaires à la valeur de la main.
- sortByColor : Trie les cartes de la main afin que les cartes de la même couleur soient
regroupées, et dans une couleur les cartes sont triées par valeur. Notez que les As sont
considérés comme ayant la valeur la plus basse, 1.
- sortByValue : Trie les cartes de la main afin que les cartes de même valeur soient
regroupées. Les cartes de même valeur sont triées par couleur. Notez que les As sont
considérés comme ayant la valeur la plus basse, 1.
Question 3 : (12 POINTS: 1.5 POINTS pour la méthode getHandTotal, 1 POINT pour
chacune des autres méthodes et 0.5 point pour la lisibilité/propreté/commentaires …)
Définir la classe Player dont le croquis est fourni ci-joint en complétant ses méthodes
aux places indiquées dans la classe.
Notez que pour cette classe, vous pouvez utiliser les méthodes Java prédéfinies de
ArrayList<E> quand c’est nécessaire.
