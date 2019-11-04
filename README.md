# keras-import-to-dl4j-example
A simple example of how to import a pre-trained [Keras](https://keras.io/) model into [DL4J](https://deeplearning4j.org/) and use it to make predictions in a JVM based environment.  

## The Keras model
The Keras model is a simple binary classifier. A [Jupyter](https://jupyter.org/) notebook to train, validate and test it is provided. It has been derived from [this](https://github.com/bgweber/StartupDataScience/blob/master/DeepLearning/Keras_Binary_Classifier.ipynb) example.
In order to execute the notebook the following requirements have to be met:  
 - Python 3.6+
 - Keras 2.2.4 with TensorFlow backend
 - Pandas
 - Matplotlib  
   
 After cloning this repo, just run Jupyter and then import the notebook and the *data* directory to use it. 
   
 ## The DL4J Java application
A simple Java application implemented using the DL4J API has been provided. Please check the provided POM file for the required dependencies.  
The application requires:  
 - Java 8
 - DL4J 1.0.0-beta5
   
I have provided a copy of the serialized Keras model (HDF5 file for the weights and the representation of the model as a JSON file) in the *resources* directory of the project, so you don't have to necessarily train the Python model before running the Java application.  
You need to use [Apache Maven](https://maven.apache.org/) to build and package it.  
Once you have cloned this repository, move to the *Java* directory and compile by executing:  
`$MAVEN_HOME/mvn clean compile`  
To create the shaded jar, execute:  
`$MAVEN_HOME/mvn package`  
To execute the application:  
`java -jar target/binaryclassifier-1.0.jar`
