# Python class for table metrics_registry 
# Created on 29 avr. 2016 ( Time 13:45:49 )


#
# This class defines the MetricsRegistry object 
#
 
class MetricsRegistry:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,idProjet ,nom ,dateCreation ,dateModification ):
		# super(MetricsRegistryData,self).__init__();
		self.id = id;
		self.idProjet = idProjet;
		self.nom = nom;
		self.dateCreation = dateCreation;
		self.dateModification = dateModification;
		