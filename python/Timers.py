# Python class for table timers 
# Created on 29 avr. 2016 ( Time 13:45:49 )


#
# This class defines the Timers object 
#
 
class Timers:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,idMetricsRegistry ,nom ,count ,meanRate ,oneMinuteRate ,fiveMinuteRate ,fifteenMinuteRate ,min ,max ,mean ,stddev ,median ,seventyFivePercent ,ninetyFivePercent ,ninetyHeightPercent ,ninetyNinePercent ,ninetyNinePercentPointNine ,dateCreation ,dateModification ):
		# super(TimersData,self).__init__();
		self.id = id;
		self.idMetricsRegistry = idMetricsRegistry;
		self.nom = nom;
		self.count = count;
		self.meanRate = meanRate;
		self.oneMinuteRate = oneMinuteRate;
		self.fiveMinuteRate = fiveMinuteRate;
		self.fifteenMinuteRate = fifteenMinuteRate;
		self.min = min;
		self.max = max;
		self.mean = mean;
		self.stddev = stddev;
		self.median = median;
		self.seventyFivePercent = seventyFivePercent;
		self.ninetyFivePercent = ninetyFivePercent;
		self.ninetyHeightPercent = ninetyHeightPercent;
		self.ninetyNinePercent = ninetyNinePercent;
		self.ninetyNinePercentPointNine = ninetyNinePercentPointNine;
		self.dateCreation = dateCreation;
		self.dateModification = dateModification;
		