# Python class for table projet 
# Created on 29 avr. 2016 ( Time 13:45:49 )


#
# This class defines the Projet object 
#
 
class Projet:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,nom ,createur ,commantaires ,dateCreation ,dateModification ):
		# super(ProjetData,self).__init__();
		self.id = id;
		self.nom = nom;
		self.createur = createur;
		self.commantaires = commantaires;
		self.dateCreation = dateCreation;
		self.dateModification = dateModification;
		